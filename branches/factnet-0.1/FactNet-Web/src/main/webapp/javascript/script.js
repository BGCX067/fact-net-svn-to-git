function Search(){
	this.element = document.createElement("form");
	this.element.name = "search";
	this.element.id = "form_busca";
	this.element.action = "";
	this.element.method = "get";
	this.element.appendChild(new Text());
	return this.element;
}

function Text(){
	this.element = document.createElement("input");
	this.element.type = "text";
	this.element.name = "s";
	myStyle = function(element){
		style = element.style;
		style.border= "2px #1CB1BA solid";
		style.padding = "3px 2px 2px 2px";
		style.font = "bold 14px Arial";
		style.marginRight = "15px";
		style.background = "url(images/fundo_busca.jpg) repeat-x -150px 0";
	}	
	myStyle(this.element);
	return this.element;
}

function createSearch(){
	var busca = new Search();
	document.getElementById("saudacao").appendChild(busca);
	document.getElementById("pesquisa").href="javascript: removeSearch()";
}
	
function removeSearch(){
	document.getElementById("saudacao").removeChild(document.getElementById("form_busca"));
	document.getElementById("pesquisa").href="javascript: createSearch()";
}

function slider(objeto){
		this.title = document.getElementById("title_Promo");
		this.value = document.getElementById("value_Promo");
		this.img = document.getElementById("img_Promo");
		this.linkPag = document.getElementById("link_Promo");
		this.oldObject = document.getElementById("item_promo_click");
		this.objeto = objeto;
		info = objeto.rel;//Terá no href os dados : url-img, url-pagina, nome-prod e  preço-produto, obrigatoriamente nesta ordem 
		ini = 0;
		fim = info.indexOf("&");
		this.img.src = info.substring(ini,fim);
		ini = fim+1;
		fim = info.indexOf("&",ini)
		this.linkPag.href = info.substring(ini,fim);
		ini = fim+1;
		fim = info.indexOf("&",ini)
		this.title.innerHTML= info.substring(ini,fim);
		this.value.innerHTML= "R$ "+info.substring(fim+1);
		this.oldObject.id = "";
		this.oldObject.className = "item_promo";
		this.objeto.id = "item_promo_click";
		this.objeto.className = "";
}


//Valida Form de Contato

function validarCampos(validador,campo){
	if(validador == "EMAIL"){
		texto = campo.value;	
		if(texto.indexOf("@")!= -1){
			if(texto.indexOf(".", texto.indexOf("@"))!= -1){
				mostrarErro("email", "");
				document.form_contato.email.className="";
				return true;
			}else{
				mostrarErro("email","Email Invalido");
				return false;
			}
		}else{
			mostrarErro("email","Email Invalido");
			return false;
		}
	}
	
	if(validador == "NOME"){
		
		texto = campo.value;	
		if(texto.length >=1 && texto!= " "){
			mostrarErro("nome","");
			document.form_contato.nome.className = "";
			return true;
		}else{
			mostrarErro("nome","Nome Invalido");
			return false;
		}
	}

	if(validador == "MESSAGE"){
		texto = campo.value;
		if(texto == "" || texto == " "){
			mostrarErro("message","Escreva uma mensagem");
			return false;
		}else{
			mostrarErro("message", "");
			document.form_contato.message.className="";
			return true;	
		}
	}
}
	function validarForm(){
		
				nome = validarCampos("NOME",document.form_contato.nome);
				email = validarCampos("EMAIL",document.form_contato.email);
				message = validarCampos("MESSAGE",document.form_contato.message);
				
				if(nome && email && message){
					document.form_contato.submit();
				}
	}
	
	function mostrarErro(tipo,mensagem){
		document.getElementById("erro_"+tipo).innerHTML = mensagem;
		if(tipo == "nome"){
			document.form_contato.nome.className="erro_border";
		}
		if(tipo == "message"){
			document.form_contato.message.className="erro_border";
		}
		if(tipo == "email"){
			document.form_contato.email.className="erro_border";
		}
	}

		

