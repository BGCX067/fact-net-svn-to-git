package br.com.geeksistemas.geekadmin.datatypes;

import java.text.SimpleDateFormat;


public class GeekDate extends java.util.Date{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6557673615544942696L;
	
	public GeekDate(){
		super();
	}
	
	
	public GeekDate(Long time){
		super(time);
	}
	
	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date data = new java.util.Date(getTime());
		return  format.format(data);
	}

}
