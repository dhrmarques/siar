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

	public MissaoSiar missao;
	public String acidenteDesc;
	public TipoMissaoSiar tipoMissao;
	public Object statusAtual; // TODO
	
	public MissaoResponse(MissaoSiar missao, AcidenteSiar acidente, TipoMissaoSiar tipo, Object status) {
		this.missao = missao;
		this.acidenteDesc = acidente.getDescricao() + "\n" + acidente.getPrioridade();
		this.tipoMissao = tipo;
		this.statusAtual = status;
	}
}
