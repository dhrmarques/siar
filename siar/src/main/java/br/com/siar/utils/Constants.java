package br.com.siar.utils;

public class Constants {

	public static final String SESSION_KEY_USER = "usuario";
	public static final String SESSION_ERROR_CODE = "erro";
	public static final String SESSION_EMAIL = "email";
	
	public static final int ERROR_FORM_INCOMPLETE = 2;
	public static final int ERROR_FORM_INVALID = 3;
	
	public static final int ERROR_LOGIN_NO_MATCH = 5;

	public static final String REDIRECT_NOT_LOGGED = "redirect:/";
	public static final String REDIRECT_HOME = "redirect:/home";
	public static final String REDIRECT_UNAUTHORIZED = REDIRECT_HOME;
}
