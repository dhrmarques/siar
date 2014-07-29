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
	private Object statusAtual; // TODO
	
	public MissaoResponse(MissaoSiar missao, AcidenteSiar acidente, TipoMissaoSiar tipo, Object status) {
		this.missao = missao;
		this.acidente = acidente;
		this.tipoMissao = tipo;
		this.statusAtual = status;
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

	public Object getStatusAtual() {
		return statusAtual;
	}

	public void setStatusAtual(Object statusAtual) {
		this.statusAtual = statusAtual;
	}
}
