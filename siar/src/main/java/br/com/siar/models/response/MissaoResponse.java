/**
 * 
 */
package br.com.siar.models.response;

import br.com.siar.models.AcidenteSiar;
import br.com.siar.models.MissaoSiar;
import br.com.siar.models.TipoMissaoSiar;

/**
 * @author Leo
 *
 */
public class MissaoResponse {

	private MissaoSiar missao;
	private AcidenteSiar acidente;
	private TipoMissaoSiar tipoMissao;
	
	public MissaoResponse(MissaoSiar missao, AcidenteSiar acidente, TipoMissaoSiar tipo) {
		this.missao = missao;
		this.acidente = acidente;
		this.tipoMissao = tipo;
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
}
