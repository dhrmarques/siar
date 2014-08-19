/**
 * 
 */
package br.com.siar.models.response;

import br.com.siar.models.AcidenteSiar;
import br.com.siar.models.MissaoSiar;
import br.com.siar.models.TipoMissaoSiar;
import br.com.siar.models.UsuarioSiar;

/**
 * @author Leo
 *
 */
public class MissaoResponse {

	private MissaoSiar missao;
	private AcidenteSiar acidente;
	private TipoMissaoSiar tipoMissao;
	private UsuarioSiar chefe;
	
	public MissaoResponse(MissaoSiar missao, AcidenteSiar acidente, TipoMissaoSiar tipo, UsuarioSiar chefe) {
		this.missao = missao;
		this.acidente = acidente;
		this.tipoMissao = tipo;
		this.chefe = chefe;
	}

	public MissaoSiar getMissao() {
		return missao;
	}

	public void setMissao(MissaoSiar missao) {
		this.missao = missao;
	}

	public AcidenteSiar getAcidente() {
		return acidente;
	}

	public void setAcidente(AcidenteSiar acidente) {
		this.acidente = acidente;
	}

	public TipoMissaoSiar getTipoMissao() {
		return tipoMissao;
	}

	public void setTipoMissao(TipoMissaoSiar tipoMissao) {
		this.tipoMissao = tipoMissao;
	}

	public UsuarioSiar getChefe() {
		return chefe;
	}

	public void setChefe(UsuarioSiar chefe) {
		this.chefe = chefe;
	}
	
	public void setDetalhes(String detalhes){
		this.missao.setDetalhes(detalhes);
	}
}
