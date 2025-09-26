package br.com.fiap.AMR.usecases.MenuProdutos;

import br.com.fiap.AMR.domains.MenuProdutos;
import br.com.fiap.AMR.gateways.response.MenuProdutosResponse;

import java.util.List;
import java.util.Optional;

public interface MenuProdutosService {

    MenuProdutosResponse inserirMenuProduto(MenuProdutos menuProduto);

    List<MenuProdutos> listarMenuProdutos();

    Optional<MenuProdutos> buscarMenuProdutoPorId(Long id);

    Optional<MenuProdutos> atualizarMenuProduto(Long id, MenuProdutos menuProduto);

    boolean deletarMenuProduto(Long id);
}
