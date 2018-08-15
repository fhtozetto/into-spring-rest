package br.com.lph.domain;

import java.io.Serializable;

public class DetalheErro implements Serializable{
	private Integer statusCode;
	private String statusMessage;
	private String httpMethod;
	private String erro;
	private String detalhe;
	private String path;
	
	
}
