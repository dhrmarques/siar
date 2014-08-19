package br.com.siar.utils;

public class Const {
	public static final String UPDATED = " atualizado com sucesso";
	public static final String CREATED = " criado com sucesso";
	public static final String ALREADY_EXISTS_THAT_EMAIL = "Já existe um elemento com esse email: ";
	public static final String THERE_IS_ONLY_ONE_USER = "Há apenas um usuário do tipo: ";
	public static final String ALREADY_EXISTS = "Já existe um elemento com esse nome: ";
	public static final String DELETED = " removido com sucesso";
	public static final String FORM_INCOMPLETE = "Formulário incompleto";
	public static final String SUCCESS = "Operação realizada com sucesso";
	public static final String CSS_ERROR_CLASS = "error";
	public static final String CSS_SUCCESS_CLASS = "success";
	

	/**
	 * Session object keys
	 */
	public static final String SESSION_KEY_USER = "usuario";
	public static final String SESSION_ERROR_CODE = "erro";
	public static final String SESSION_EMAIL = "email";
	
	/**
	 * Error codes (try using prime numbers) 
	 */
	public static final int ERROR_FORM_INCOMPLETE = 2;
	public static final int ERROR_FORM_INVALID = 3;
	public static final int ERROR_LOGIN_NO_MATCH = 5;

	/** 
	 * Paths and stuff
	 */
	public static final String SIAR = "/siar/";
	public static final String ROOT_ADDRESS = "/";
	public static final String HOME_ADDRESS = ROOT_ADDRESS + "home";
	public static final String CHEFEMISSAO_ADDRESS = "/chefe";
	public static final String REDIRECT_NOT_LOGGED = "redirect:" + ROOT_ADDRESS;
	public static final String REDIRECT_HOME = "redirect:" + HOME_ADDRESS;
	public static final String REDIRECT_UNAUTHORIZED = REDIRECT_HOME;
	public static final String REDIRECT_CHEFEMISSAO = "redirect:" + CHEFEMISSAO_ADDRESS;
	
	public static final String LIST = "";
	public static final String NEW = "/new";
	public static final String SAVE = "/save";
	public static final String UPDATE = "/update/{id}";
	public static final String DELETE = "/delete/{id}";
	
	/**
	 * ModelMap attributes frequently used for JSP 
	 */
	public static final String ATTR_TITLE = "title";
	public static final String ATTR_NAME = "nome";
	public static final String ATTR_USER_TYPE = "tipo_usuario";
	public static final String ATTR_USER_ID = "id_usuario";
	public static final String ATTR_HIDE_HR = "hide_header_right";
	public static final String ATTR_LINKS = "linklist";
	public static final String ATTR_LINK_ACTIVE = "active_path";
}
