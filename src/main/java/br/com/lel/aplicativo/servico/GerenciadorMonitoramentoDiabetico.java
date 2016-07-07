package br.com.lel.aplicativo.servico;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import br.com.lel.dominio.entidade.MonitoramentoDiabetico;


/**
 * 
 * @author lincoln
 * 
 * 
 */
@Api(value = "gerenciadorMonitoramentoDiabetico") //Diz ao Swagger que esse é um endpoint e REST deve ser documentado
@RestController
@RequestMapping("/gerenciadorMonitoramentoDiabetico/")
public class GerenciadorMonitoramentoDiabetico {

	@ApiOperation(value = "obtem a versão da API" )
    //Diz ao Swagger que essa operação REST deve ser documentado
    @ResponseStatus
    @RequestMapping(value = "/obterVersao", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)	
	public String obterVersao() {
		return "1.0.0 A";
	}

	
	@ApiOperation(value = "calcula a quantidade de insulina" )
    //Diz ao Swagger que essa operação REST deve ser documentado
    @ResponseStatus
    @RequestMapping(value = "/calcularQuantidadeInsulina", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)	
	public void calcularQuantidadeInsulina(@PathVariable(value = "dextro") int dextro, 
										   @PathVariable(value = "quantidadeCarboidrato") double quantidadeCarboidrato, 
										   @PathVariable(value = "quantidadeInsulina") double quantidadeInsulina) {
		System.out.println("calcularQuantidadeInsulina");
		MonitoramentoDiabetico monitoramentoDiabetico = new MonitoramentoDiabetico(dextro, quantidadeCarboidrato, quantidadeInsulina);
		
		//Implementar Validator
		
		monitoramentoDiabetico.calcularQuantidadeInsulina();
	}

	@ApiOperation(value = "Inclui um monitoramento diabético" )
    //Diz ao Swagger que essa operação REST deve ser documentado
    @RequestMapping(value = "/incluirMonitoramentoDiabetico", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void incluirMonitoramentoDiabetico(@RequestBody MonitoramentoDiabetico monitoramentoDiabetico) {
		System.out.println("incluirMonitoramentoDiabetico");
		//Implementar Validator
	}

}
