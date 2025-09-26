package br.com.fiap.AMR.gateways.response;

import br.com.fiap.AMR.domains.Licenca;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LicencaPostResponse {

    private String mensagem;
    private Licenca licenca;

}
