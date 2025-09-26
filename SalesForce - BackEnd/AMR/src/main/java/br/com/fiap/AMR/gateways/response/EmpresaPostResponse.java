package br.com.fiap.AMR.gateways.response;

import br.com.fiap.AMR.domains.Empresa;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmpresaPostResponse {

    private String mensagem;

    private Empresa empresa;

}
