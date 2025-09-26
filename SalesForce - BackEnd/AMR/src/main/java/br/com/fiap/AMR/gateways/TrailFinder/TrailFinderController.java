package br.com.fiap.AMR.gateways.TrailFinder;

import br.com.fiap.AMR.domains.TrailFinder;
import br.com.fiap.AMR.gateways.response.TrailFinderResponse;
import br.com.fiap.AMR.gateways.response.TrailFinderResponseFlask;
import br.com.fiap.AMR.usecases.TrailFinder.TrailFinderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trailfinder")
@RequiredArgsConstructor
public class TrailFinderController {

    private final TrailFinderService trailFinderService;

    @GetMapping("/todos")
    public ResponseEntity<List<TrailFinderResponse>> listarTodos() {
        List<TrailFinderResponse> trailFinders = trailFinderService.buscarTodos();
        return ResponseEntity.ok(trailFinders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrailFinder> buscarTrailFinderPorId(@PathVariable Long id) {
        Optional<TrailFinder> trailFinder = trailFinderService.buscarTrailFinderPorId(id);
        return trailFinder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email")
    public ResponseEntity<List<TrailFinder>> buscarTrailFindersPorEmail(@RequestParam String email) {
        List<TrailFinder> trailFinders = trailFinderService.buscarTrailFindersPorEmail(email);
        return ResponseEntity.ok(trailFinders);
    }

    @GetMapping("/nome")
    public ResponseEntity<List<TrailFinder>> buscarTrailFindersPorNome(@RequestParam String name) {
        List<TrailFinder> trailFinders = trailFinderService.buscarTrailFindersPorNome(name);
        return ResponseEntity.ok(trailFinders);
    }

    @GetMapping("/tipo-empresa")
    public ResponseEntity<List<TrailFinder>> buscarTrailFindersPorTipoEmpresa(@RequestParam String tipoEmpresa) {
        List<TrailFinder> trailFinders = trailFinderService.buscarTrailFindersPorTipoEmpresa(tipoEmpresa);
        return ResponseEntity.ok(trailFinders);
    }

    @GetMapping("/probabilidade")
    public ResponseEntity<List<TrailFinderResponse>> buscarTrailFindersPorProbabilidade() {
        List<TrailFinderResponse> trailFinders = trailFinderService.buscarTrailPorProbabilidadeContratacaoTrail(0.0);
        return ResponseEntity.ok(trailFinders);
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarTrailFinder(@RequestBody TrailFinder trailFinder) {
        TrailFinder novoTrailFinder = trailFinderService.salvarTrailFinder(trailFinder);
        try {
            // Buscar TrailFinders com probabilidade 0.0
            List<TrailFinderResponseFlask> trailFinders = trailFinderService.buscarTrailPorProbabilidadeContratacao(0.0);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonInput = objectMapper.writeValueAsString(trailFinders);

            // Enviar JSON para o Flask
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))  // Timeout de conexão
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:5000/prever")) // URL do servidor Flask
                    .header("Content-Type", "application/json; charset=UTF-8")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonInput))
                    .build();

            // Enviar a requisição e receber a resposta do Flask
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar o código de status da resposta
            if (response.statusCode() == 200) {
                // Log de resposta bem-sucedida
                System.out.println("Resposta do Flask: " + response.body());

                // Processar a resposta JSON do Flask
                List<TrailFinderResponse> updatedTrailFinders = objectMapper.readValue(response.body(),
                        objectMapper.getTypeFactory().constructCollectionType(List.class, TrailFinderResponse.class));

                // Atualizar as probabilidades no banco de dados
                atualizarProbabilidades(updatedTrailFinders);

                return ResponseEntity.ok("Novo uso adicionado em sistema. Todas as probabilidades de contratação foram atualizadas com sucesso.");
            } else {
                // Log para erro com o Flask
                System.err.println("Erro ao receber resposta do Flask: " + response.body());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Erro ao receber resposta do Flask.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar probabilidades: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro inesperado ao atualizar probabilidades.");
        }
    }
    private void atualizarProbabilidades(List<TrailFinderResponse> updatedTrailFinders) {
        for (TrailFinderResponse updated : updatedTrailFinders) {
            if (updated.getId() == null) {
                System.err.println("ID é nulo para o objeto: " + updated);
                continue; // Ignora objetos com ID nulo
            }
            trailFinderService.atualizarProbabilidadeContratacao(updated.getId(), updated.getProbabilidadeContratacao());
        }
    }

    @PostMapping("/receberPredicoes")
    public ResponseEntity<String> receberPredicoes(@RequestBody List<TrailFinderResponse> predicoes) {
        try {
            // Processar as previsões recebidas e atualizar as probabilidades
            for (TrailFinderResponse predicao : predicoes) {
                // Log para verificar a previsão recebida
                System.out.println("Recebendo previsão: " + predicao);

                // Verifica se o ID é nulo
                if (predicao.getId() == null) {
                    System.err.println("ID é nulo para a previsão: " + predicao);
                    continue; // Ignora previsões com ID nulo
                }
                // Chama o serviço para atualizar a probabilidade de contratação
                trailFinderService.atualizarProbabilidadeContratacao(predicao.getId(), predicao.getProbabilidadeContratacao());
            }
            return ResponseEntity.ok("Previsões recebidas com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao processar previsões.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTrailFinder(@PathVariable Long id) {
        trailFinderService.deletarTrailFinder(id);
        return ResponseEntity.noContent().build();
    }
}
