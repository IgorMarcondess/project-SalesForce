package br.com.fiap.AMR.gateways.MenuProdutos;

import br.com.fiap.AMR.domains.Licenca;
import br.com.fiap.AMR.domains.MenuProdutos;
import br.com.fiap.AMR.gateways.Licenca.LicencaRepository;
import br.com.fiap.AMR.gateways.response.MenuProdutosResponse;
import br.com.fiap.AMR.usecases.MenuProdutos.MenuProdutosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MenuProdutosServiceImpl implements MenuProdutosService {

    private final MenuProdutosRepository menuProdutosRepository;
    private final LicencaRepository licencaRepository;


    @Override
    public MenuProdutosResponse inserirMenuProduto(MenuProdutos menuProduto) {
        Optional<Licenca> licenca = licencaRepository.findById(Long.valueOf(menuProduto.getLicenca().getIdContrato()));
        Optional<MenuProdutos> menu = menuProdutosRepository.findByLicenca_IdContrato(licenca.get().getIdContrato());
        if(licenca.isPresent() && menu.isEmpty()){
            menuProduto.setLicenca(licenca.get());
            menuProdutosRepository.save(menuProduto);
            return new MenuProdutosResponse("Menu cadastrado", menuProduto);
        }
        return new MenuProdutosResponse("Menu não cadastrado, revise os parâmetros do menu do produto", menuProduto);
    }

    @Override
    public List<MenuProdutos> listarMenuProdutos() {
        return menuProdutosRepository.findAll();
    }

    @Override
    public Optional<MenuProdutos> buscarMenuProdutoPorId(Long id) {
        return menuProdutosRepository.findById(id);
    }

    @Override
    public Optional<MenuProdutos> atualizarMenuProduto(Long id, MenuProdutos menuProduto) {
        Optional<Licenca> licenca = licencaRepository.findById(Long.valueOf(menuProduto.getLicenca().getIdContrato()));
        Optional<MenuProdutos> menuExistente = menuProdutosRepository.findByLicenca_IdContrato(licenca.map(Licenca::getIdContrato).orElse(null));
        if (licenca.isPresent() && menuExistente.isPresent()) {
            return menuExistente.map(existingMenu -> {
                existingMenu.setProdutosSales(menuProduto.getProdutosSales());
                existingMenu.setServicosSales(menuProduto.getServicosSales());
                existingMenu.setCategoria(menuProduto.getCategoria());
                existingMenu.setPlanos(menuProduto.getPlanos());
                existingMenu.setLicenca(licenca.get());

                return menuProdutosRepository.save(existingMenu);
            });
        } else {
            return Optional.empty();
        }
    }


    @Override
    public boolean deletarMenuProduto(Long id) {
        return menuProdutosRepository.findById(id)
                .map(menuProduto -> {
                    menuProdutosRepository.delete(menuProduto);
                    return true;
                }).orElse(false);
    }
}
