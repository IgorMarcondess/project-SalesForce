package br.com.fiap.AMR.gateways.Atendimento;

import br.com.fiap.AMR.domains.Atendimento;
import br.com.fiap.AMR.usecases.Atendimento.AtendimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atendimentos")
@RequiredArgsConstructor
public class AtendimentoController {

    private final AtendimentoService atendimentoService;

    // Criar novo atendimento
    @PostMapping("/criar")
    public ResponseEntity<Atendimento> criarAtendimento(@RequestBody Atendimento atendimentoParaInserir) {
        Atendimento novoAtendimento = atendimentoService.inserirAtendimento(atendimentoParaInserir);
        return ResponseEntity.status(201).body(novoAtendimento);
    }

    // Buscar todos os atendimentos
    @GetMapping("/todos")
    public ResponseEntity<List<Atendimento>> listarTodosAtendimentos() {
        List<Atendimento> atendimentos = atendimentoService.listarAgentes();
        if (atendimentos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(atendimentos);
        }
    }

    // Buscar atendimento por ID
    @GetMapping("/{idAtendimento}")
    public ResponseEntity<Atendimento> buscarAtendimento(@PathVariable int idAtendimento) {
        Optional<Atendimento> atendimento = atendimentoService.buscarAtendimento(idAtendimento);
        return atendimento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar um atendimento (PUT)
    @PutMapping("/atualizar/{idAtendimento}")
    public ResponseEntity<Atendimento> atualizarAtendimento(@PathVariable int idAtendimento,
                                                            @RequestBody Atendimento atendimentoParaAtualizar) {
        Optional<Atendimento> atendimentoAtualizado = atendimentoService.atualizarAtendimeno(idAtendimento, atendimentoParaAtualizar);
        return atendimentoAtualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Deletar atendimento por ID
    @DeleteMapping("/deletar/{idAtendimento}")
    public ResponseEntity<Void> deletarAtendimento(@PathVariable int idAtendimento) {
        boolean deletado = atendimentoService.deletarAtendimento(idAtendimento);
        if (deletado) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    // Buscar atendimentos por contato encaminhado
    @GetMapping("/contato")
    public ResponseEntity<List<Atendimento>> buscarAtendimentosPorContato(@RequestParam long contatoEncaminha) {
        List<Atendimento> atendimentos = atendimentoService.buscarAtendimentosPorContato(contatoEncaminha);
        if (atendimentos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(atendimentos);
        }
    }

    // Buscar atendimento por contato e data
    @GetMapping("/contato/data")
    public ResponseEntity<Atendimento> buscarAtendimentoPorContatoEData(@RequestParam long contatoEncaminha,
                                                                        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataEncaminha) {
        Optional<Atendimento> atendimento = atendimentoService.buscarAtendimentoPorContatoEData(contatoEncaminha, dataEncaminha);
        return atendimento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Buscar atendimentos por chatbot
    @GetMapping("/chatbot")
    public ResponseEntity<List<Atendimento>> buscarAtendimentosPorChatbot(@RequestParam String chatbot) {
        List<Atendimento> atendimentos = atendimentoService.buscarAtendimentosPorChatbot(chatbot);
        if (atendimentos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(atendimentos);
        }
    }

}
