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
	private String acidenteDesc;
	private TipoMissaoSiar tipoMissao;
	private Object statusAtual; // TODO
	
	public MissaoResponse(MissaoSiar missao, AcidenteSiar acidente, TipoMissaoSiar tipo, Object status) {
		this.missao = missao;
		this.acidenteDesc = acidente.getDescricao() + "\n" + acidente.getPrioridade();
		this.tipoMissao = tipo;
		this.statusAtual = status;
	}

	public MissaoSiar getMissao() {
		return missao;
	}

	public void setMissao(MissaoSiar missao) {
		this.missao = missao;
	}

	public String getAcidenteDesc() {
		return acidenteDesc;
	}

	public void setAcidenteDesc(String acidenteDesc) {
		this.acidenteDesc = acidenteDesc;
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
