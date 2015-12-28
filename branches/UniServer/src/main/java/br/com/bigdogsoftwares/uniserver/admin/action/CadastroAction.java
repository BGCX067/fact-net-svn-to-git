package br.com.bigdogsoftwares.uniserver.admin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.gson.Gson;

import br.com.bigdogsoftwares.uniserver.admin.form.CursoForm;
import br.com.bigdogsoftwares.uniserver.admin.form.DisciplinaForm;
import br.com.bigdogsoftwares.uniserver.admin.form.ProfessorForm;
import br.com.bigdogsoftwares.uniserver.admin.form.TurmaForm;
import br.com.bigdogsoftwares.uniserver.model.dao.DisciplinaDAO;
import br.com.bigdogsoftwares.uniserver.model.dao.GenericDAO;
import br.com.bigdogsoftwares.uniserver.model.entidade.curso.Curso;
import br.com.bigdogsoftwares.uniserver.model.entidade.curso.Disciplina;
import br.com.bigdogsoftwares.uniserver.model.entidade.curso.Turma;
import br.com.bigdogsoftwares.uniserver.model.entidade.pessoa.Professor;

public class CadastroAction extends BaseAction {

	
	public ActionForward abrirTelaCurso(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward paginaLogin = isLogado(mapping, form, request, response, false);
		if(paginaLogin != null){
			return paginaLogin;
		}
		return mapping.findForward("body_curso");
		
	}
	
	public ActionForward salvarCurso(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward paginaLogin = isLogado(mapping, form, request, response, true);
		if(paginaLogin != null){
			return paginaLogin;
		}
		
		CursoForm cursoForm = (CursoForm) form;
		if(cursoForm.getNome() == null || cursoForm.getNome().isEmpty()){
			addAjaxError(response,"Informe o nome do curso");
		}else{
			Curso curso = new Curso();
			curso.setNome(cursoForm.getNome());
			Long id = new GenericDAO<Curso>().salvar(curso);
			
			if(id != null){
				addAjaxInfo(response, "Operação realizada com sucesso");
			}else{
				addAjaxError(response,"Não foi possivel realizar operação, tente novamente");
			}
			
		}
		return null;
	}
	
	public ActionForward abrirTelaProfessor(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward paginaLogin = isLogado(mapping, form, request, response, false);
		if(paginaLogin != null){
			return paginaLogin;
		}
		return mapping.findForward("body_professor");
	}
	
	public ActionForward salvarProfessor(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward paginaLogin = isLogado(mapping, form, request, response, true);
		if(paginaLogin != null){
			return paginaLogin;
		}
		
		ProfessorForm professorForm = (ProfessorForm) form;
		
		if(professorForm.getNome() == null || professorForm.getNome().isEmpty()){
			addAjaxError(response,"Informe o nome do professor");
		}else if(professorForm.getSenha() == null || professorForm.getSenha().isEmpty()){
			addAjaxError(response,"Informe e confirme a senha do professor");
		}else if(professorForm.getMatricula() == null || professorForm.getMatricula().longValue() == 0){
			addAjaxError(response,"Informe o numero de matricula do professor");
		}else{
			Professor professor = new Professor();
			professor.setNome(professorForm.getNome());
			professor.setSenha(professorForm.getSenha());
			professor.setMatricula(professorForm.getMatricula());
			
			Long id = new GenericDAO<Professor>().salvar(professor);
			
			if(id != null){
				addAjaxInfo(response, "Operação realizada com sucesso");
			}else{
				addAjaxError(response,"Não foi possivel realizar operação, tente novamente");
			}
			
		}
		return null;
	}
	
	public ActionForward abrirTelaTurma(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward paginaLogin = isLogado(mapping, form, request, response, false);
		if(paginaLogin != null){
			return paginaLogin;
		}
		
		List<Curso> cursos = new GenericDAO<Curso>().listarTodos(new Curso());
		request.setAttribute("listaCursos", cursos);
		return mapping.findForward("body_turma");
	}
	
	public ActionForward salvarTurma(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward paginaLogin = isLogado(mapping, form, request, response, true);
		if(paginaLogin != null){
			return paginaLogin;
		}
		
		TurmaForm turmaForm = (TurmaForm) form;
		
		if(turmaForm.getNoSala() == 0){
			addAjaxError(response,"Informe o numero da sala");
		}else if(turmaForm.getTurma() == null || turmaForm.getTurma().isEmpty()){
			addAjaxError(response,"Informe o ano e a turma");
		}else if(turmaForm.getCurso() == null){
			addAjaxError(response,"Informe o curso da turma");
		}else if(turmaForm.getDisciplinas() == null || turmaForm.getDisciplinas().length <= 0){
			addAjaxError(response,"Informe as disciplinas do semestre desta turma");
		}else{
			
			Turma turma = new Turma();
			turma.setNoSala(turmaForm.getNoSala());
			turma.setTurma(turmaForm.getTurma());
			
			Curso curso = new GenericDAO<Curso>().obter(turmaForm.getCurso(), new Curso());
			turma.setCurso(curso);
			
			List<Disciplina> listaDisciplinas = new DisciplinaDAO().
					obterDisciplinasSelecionadas(turmaForm.getDisciplinas());
			turma.setDisciplinas(listaDisciplinas);
			
			Long id = new GenericDAO<Turma>().salvar(turma);
			
			if(id != null){
				addAjaxInfo(response, "Operação realizada com sucesso");
			}else{
				addAjaxError(response,"Não foi possivel realizar operação, tente novamente");
			}
			
		}
		return null;
	}
	
	public ActionForward abrirTelaDisciplina(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward paginaLogin = isLogado(mapping, form, request, response, false);
		if(paginaLogin != null){
			return paginaLogin;
		}
		
		List<Professor> professores = new GenericDAO<Professor>().listarTodos(new Professor());
		request.setAttribute("listaProfessores", professores);
		
		List<Curso> cursos = new GenericDAO<Curso>().listarTodos(new Curso());
		request.setAttribute("listaCursos", cursos);
		
		return mapping.findForward("body_disciplina");
	}
	
	public ActionForward salvarDisciplina(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionForward paginaLogin = isLogado(mapping, form, request, response, true);
		if(paginaLogin != null){
			return paginaLogin;
		}
		
		DisciplinaForm disciplinaForm = (DisciplinaForm) form;
		
		if(disciplinaForm.getMatriculaProfessor() == null || disciplinaForm.getMatriculaProfessor().longValue() == -1){
			addAjaxError(response,"Informe o professor responsavel pela disciplina");
		}else if(disciplinaForm.getDescricao() == null || disciplinaForm.getDescricao().isEmpty()){
			addAjaxError(response,"Informe uma descrição da disciplina");
		}else if(disciplinaForm.getNome() == null || disciplinaForm.getNome().isEmpty()){
			addAjaxError(response,"Informe o nome da disciplina");
		}else if(disciplinaForm.getCursoAlvo() == null || disciplinaForm.getCursoAlvo().longValue() == -1){
			addAjaxError(response,"Informe o curso alvo da disciplina");
		}else{
			
			Disciplina disciplina = new Disciplina();
			disciplina.setDescricao(disciplinaForm.getDescricao());
			disciplina.setNome(disciplinaForm.getNome());
			
			Professor professor = new GenericDAO<Professor>().obter(disciplinaForm.getMatriculaProfessor(), new Professor());
			Curso cursoAlvo = new GenericDAO<Curso>().obter(disciplinaForm.getCursoAlvo(), new Curso());
			if(professor == null){
				addAjaxError(response, "Professor não encontrado, informe novamente");
			}else if(cursoAlvo == null){
				addAjaxError(response, "Curso alvo não encontrado, informe novamente");
			}else{
				disciplina.setProfessor(professor);
				disciplina.setCursoAlvo(cursoAlvo);
				
				Long id = new GenericDAO<Disciplina>().salvar(disciplina);
				
				if(id != null){
					addAjaxInfo(response, "Operação realizada com sucesso");
				}else{
					addAjaxError(response,"Não foi possivel realizar operação, tente novamente");
				}
			}
		}
		return null;
	}
	
	public ActionForward carregarDisciplinasCurso(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Long idCurso = Long.parseLong(request.getParameter("idCurso"));
		
		Curso curso = new Curso();
		curso.setId(idCurso);
		List<Disciplina> listaDisciplina = new DisciplinaDAO().buscarDisciplinasParaCurso(curso);
		
		Gson g = new Gson();
		String json = g.toJson(listaDisciplina.toArray());
		response.getWriter().write(json);
		response.getWriter().flush();
		
		return null;
	}
	
	
}
