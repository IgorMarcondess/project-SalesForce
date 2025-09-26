package br.com.fiap.AMR.gateways.MenuProdutos;

import br.com.fiap.AMR.domains.Licenca;
import br.com.fiap.AMR.domains.MenuProdutos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuProdutosRepository extends JpaRepository<MenuProdutos, Long> {
    List<MenuProdutos> findByCategoria(String categoria);
    Optional<MenuProdutos> findByLicenca_IdContrato(long id);
}
