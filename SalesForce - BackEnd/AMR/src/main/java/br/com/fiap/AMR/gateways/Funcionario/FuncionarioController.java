package br.com.fiap.AMR.gateways.Funcionario;

import br.com.fiap.AMR.domains.Funcionario;
import br.com.fiap.AMR.gateways.response.FuncionarioPostResponse;
import br.com.fiap.AMR.usecases.Funcionario.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    // Criar novo funcionário
    @PostMapping("/criar")
    public ResponseEntity<FuncionarioPostResponse> criarFuncionario(@RequestBody Funcionario funcionarioParaInserir, String cnpj) {
        FuncionarioPostResponse novoFuncionario = funcionarioService.inserirFuncionario(funcionarioParaInserir);
        return ResponseEntity.status(201).body(novoFuncionario);
    }

    // Listar todos os funcionários
    @GetMapping("/todos")
    public ResponseEntity<List<Funcionario>> listarTodosFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionario();
        if (funcionarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(funcionarios);
        }
    }

    // Buscar funcionário por CPF
    @GetMapping("/{cpf}")
    public ResponseEntity<Funcionario> buscarFuncionarioPorCpf(@PathVariable String cpf) {
        // Verificar se o CPF contém apenas números e tem 11 dígitos
        if (!cpf.matches("\\d{11}")) {
            return ResponseEntity.badRequest().body(null); // Retorna 400 se o CPF estiver inválido
        }

        // Buscar o funcionário pelo CPF
        Optional<Funcionario> funcionario = funcionarioService.buscarFuncionarioPorCpf(cpf);
        return funcionario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar funcionário (PUT)
    @PutMapping("/atualizar/{cpf}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable String cpf,
                                                            @RequestBody Funcionario funcionarioParaAtualizar) {
        // Verificar se o CPF contém apenas números e tem 11 dígitos
        if (!cpf.matches("\\d{11}")) {
            return ResponseEntity.badRequest().body(null); // Retorna 400 se o CPF estiver inválido
        }

        Optional<Funcionario> funcionarioAtualizado = funcionarioService.atualizarFuncionario(cpf, funcionarioParaAtualizar);
        return funcionarioAtualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Deletar funcionário por CPF
    @DeleteMapping("/deletar/{cpf}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable String cpf) {
        // Verificar se o CPF contém apenas números e tem 11 dígitos
        if (!cpf.matches("\\d{11}")) {
            return ResponseEntity.badRequest().build(); // Retorna 400 se o CPF estiver inválido
        }

        boolean deletado = funcionarioService.deletarFuncionario(cpf);
        if (deletado) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    // Buscar funcionários por CNPJ da empresa
    @GetMapping("/empresa/{cnpj}")
    public ResponseEntity<List<Funcionario>> buscarFuncionariosPorEmpresa(@PathVariable String cnpj) {
        // Verificar se o CNPJ contém apenas números e tem 14 dígitos
        if (!cnpj.matches("\\d{14}")) {
            return ResponseEntity.badRequest().build(); // Retorna 400 se o CNPJ estiver inválido
        }

        String cnpjFormatado = String.format("%s.%s.%s/%s-%s",
                cnpj.substring(0, 2),
                cnpj.substring(2, 5),
                cnpj.substring(5, 8),
                cnpj.substring(8, 12),
                cnpj.substring(12, 14));

        List<Funcionario> funcionarios = funcionarioService.buscarFuncionarioPorEmpresa(cnpjFormatado);
        if (funcionarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(funcionarios);
        }
    }
}
