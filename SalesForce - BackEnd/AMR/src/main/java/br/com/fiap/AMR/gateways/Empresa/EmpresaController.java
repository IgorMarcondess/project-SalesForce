package br.com.fiap.AMR.gateways.Empresa;

import br.com.fiap.AMR.domains.Empresa;
import br.com.fiap.AMR.gateways.response.EmpresaPostResponse;
import br.com.fiap.AMR.usecases.Empresa.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaService empresaService;

    // Criar nova empresa
    @PostMapping("/criar")
    public ResponseEntity<EmpresaPostResponse> criarEmpresa(@RequestBody Empresa empresaParaInserir) {
        EmpresaPostResponse novaEmpresa = empresaService.inserirEmpresa(empresaParaInserir);
        return ResponseEntity.status(201).body(novaEmpresa);
    }

    // Listar todas as empresas
    @GetMapping("/todas")
    public ResponseEntity<List<Empresa>> listarTodasEmpresas() {
        List<Empresa> empresas = empresaService.listarEmpresas();
        if (empresas.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(empresas);
        }
    }

    // Buscar empresa por CNPJ
    @GetMapping("/{cnpj}")
    public ResponseEntity<Empresa> buscarEmpresaPorCnpj(@PathVariable String cnpj) {
        Optional<Empresa> empresa = empresaService.buscarEmpresaPorCnpj(cnpj);
        return empresa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Atualizar uma empresa (PUT)
    @PutMapping("/atualizar/{cnpj}")
    public ResponseEntity<Empresa> atualizarEmpresa(@PathVariable String cnpj,
                                                    @RequestBody Empresa empresaParaAtualizar) {

        Optional<Empresa> empresaAtualizada = empresaService.atualizarEmpresa(cnpj, empresaParaAtualizar);
        return empresaAtualizada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Deletar empresa por CNPJ
    @DeleteMapping("/deletar/{cnpj}")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable String cnpj) {

        boolean deletada = empresaService.deletarEmpresa(cnpj);
        if (deletada) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

}
