package br.com.fiap.AMR.gateways.response;

import br.com.fiap.AMR.domains.MenuProdutos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuProdutosResponse {

    private String mensagem;
    private MenuProdutos menuProdutos;

}
