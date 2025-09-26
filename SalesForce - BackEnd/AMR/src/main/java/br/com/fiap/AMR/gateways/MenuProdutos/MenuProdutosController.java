package br.com.fiap.AMR.gateways.MenuProdutos;

import br.com.fiap.AMR.domains.MenuProdutos;
import br.com.fiap.AMR.gateways.response.MenuProdutosResponse;
import br.com.fiap.AMR.usecases.MenuProdutos.MenuProdutosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu-produtos")
@RequiredArgsConstructor
public class MenuProdutosController {

    private final MenuProdutosService menuProdutosService;

    // Criar novo menu de produtos
    @PostMapping("/criar")
    public ResponseEntity<MenuProdutosResponse> criarMenuProduto(@RequestBody MenuProdutos menuProduto) {
        MenuProdutosResponse novoMenuProduto = menuProdutosService.inserirMenuProduto(menuProduto);
        return ResponseEntity.status(201).body(novoMenuProduto);
    }

    // Listar todos os produtos do menu
    @GetMapping("/todos")
    public ResponseEntity<List<MenuProdutos>> listarTodosMenuProdutos() {
        List<MenuProdutos> produtos = menuProdutosService.listarMenuProdutos();
        return produtos.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(produtos);
    }

    // Buscar produto do menu por ID
    @GetMapping("/{id}")
    public ResponseEntity<MenuProdutos> buscarMenuProdutoPorId(@PathVariable Long id) {
        Optional<MenuProdutos> menuProduto = menuProdutosService.buscarMenuProdutoPorId(id);
        return menuProduto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar produto do menu
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<MenuProdutos> atualizarMenuProduto(@PathVariable Long id,
                                                             @RequestBody MenuProdutos menuProduto) {
        Optional<MenuProdutos> menuProdutoAtualizado = menuProdutosService.atualizarMenuProduto(id, menuProduto);
        return menuProdutoAtualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Deletar produto do menu
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarMenuProduto(@PathVariable Long id) {
        boolean deletado = menuProdutosService.deletarMenuProduto(id);
        return deletado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
