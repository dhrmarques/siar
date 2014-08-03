package br.com.siar.utils;

public class Const {

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
	public static final String REDIRECT_NOT_LOGGED = "redirect:" + ROOT_ADDRESS;
	public static final String REDIRECT_HOME = "redirect:" + HOME_ADDRESS;
	public static final String REDIRECT_UNAUTHORIZED = REDIRECT_HOME;
	
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
	public static final String ATTR_HIDE_HR = "hide_header_right";
	public static final String ATTR_LINKS = "linklist";
	public static final String ATTR_LINK_ACTIVE = "active_path";
}
