/**
 * 
 */
package br.com.siar.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import br.com.siar.models.UsuarioSiar;
import br.com.siar.models.UsuarioSiar.TipoUsuario;
import br.com.siar.utils.Const;
import br.com.siar.utils.Link;
import br.com.siar.utils.SessionHelper;

/**
 * @author Leo
 *
 */
public abstract class BasicController {
	
	protected boolean autorizado(HttpServletRequest request, ModelMap model) {

		UsuarioSiar usuario = SessionHelper.getUsuarioLogado(request);
		if (usuario == null)
			return false;
		
		return autorizado(request, model, usuario.getTipoUsuario());
	}

	protected boolean autorizado(HttpServletRequest request, ModelMap model, TipoUsuario tipoUser) {
		
		UsuarioSiar usuario = SessionHelper.getUsuarioLogado(request);
		if (usuario != null && usuario.getTipoUsuario().equals(tipoUser)) {
			
			model.addAttribute(Const.ATTR_NAME, usuario.getNome());
			model.addAttribute(Const.ATTR_USER_TYPE, tipoUser);
			model.addAttribute(Const.ATTR_USER_ID, usuario.getId());
			model = adicionarLinks(model, tipoUser);
			
			return true;
		}
		return false;
	}
	
	private ModelMap adicionarLinks(ModelMap model, TipoUsuario tipoUser) {
		
		switch (tipoUser) {
		case ADMINISTRADOR:
			model.addAttribute(Const.ATTR_LINKS, LINKS_ADMIN);
			break;
		case COORDENADOR:
			model.addAttribute(Const.ATTR_LINKS, LINKS_COORD);
			break;
		case ESPECIALISTA:
			model.addAttribute(Const.ATTR_LINKS, LINKS_ESPEC);
			break;
		default:
			break;
		}
		
		return model;
	}

	// Administrador
	public static final String USUARIOS = "/usuarios";
	public static final Link LINK_USUARIOS = new Link("Usuários", USUARIOS);
	public static final String RECURSOS = "/recursos";
	public static final Link LINK_RECURSOS = new Link("Recursos", RECURSOS);
	public static final String FORNECEDORES = "/fornecedores";
	public static final Link LINK_FORNECEDORES = new Link("Fornecedores", FORNECEDORES);
	private static final List<Link> LINKS_ADMIN = Arrays.asList(LINK_USUARIOS, LINK_RECURSOS, LINK_FORNECEDORES);

	// Coordenador
	public static final String ACIDENTES = "/acidentes";
	public static final Link LINK_ACIDENTES = new Link("Acidentes", ACIDENTES);
	public static final String ALOCACAO = "/alocacao";
	public static final Link LINK_ALOCACAO = new Link("Alocar recursos", ALOCACAO);
	public static final String SVC = "/svc";
	public static final Link LINK_SVC = new Link("Acesso SVC", SVC);
	private static final List<Link> LINKS_COORD = Arrays.asList(LINK_ACIDENTES, LINK_ALOCACAO, LINK_SVC);

	// Especialista
	public static final String EMERGENCIAS = "/emergencias";
	public static final Link LINK_EMERGENCIAS = new Link("Acidentes em aberto", EMERGENCIAS);
	public static final String MISSOES = "/missoes";
	public static final Link LINK_MISSOES = new Link("Missões", MISSOES);
	public static final String TIPOSMISSAO = "/tiposmissao";
	public static final Link LINK_TIPOSMISSAO = new Link("Tipos de missão", TIPOSMISSAO);
	private static final List<Link> LINKS_ESPEC = Arrays.asList(LINK_EMERGENCIAS, LINK_MISSOES, LINK_TIPOSMISSAO);
	
	// Chefe de Missão
	public static final String ATUALIZACOESMISSAO = "/am";

}
