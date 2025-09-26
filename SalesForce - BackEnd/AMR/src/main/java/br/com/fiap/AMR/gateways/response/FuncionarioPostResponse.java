package br.com.fiap.AMR.gateways.response;

import br.com.fiap.AMR.domains.Funcionario;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class FuncionarioPostResponse {

    @NotNull
    private String mensagem;

    private Funcionario funcionario;


}
