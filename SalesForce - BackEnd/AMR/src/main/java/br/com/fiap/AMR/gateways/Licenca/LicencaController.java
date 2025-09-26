package br.com.fiap.AMR.gateways.Licenca;

import br.com.fiap.AMR.domains.Licenca;
import br.com.fiap.AMR.gateways.response.LicencaPostResponse;
import br.com.fiap.AMR.usecases.Licenca.LicencaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/licencas")
public class LicencaController {

    private final LicencaService licencaService;

    @PostMapping("/criar")
    public ResponseEntity<LicencaPostResponse> inserirLicenca(@RequestBody Licenca licenca) {
        LicencaPostResponse response = licencaService.inserirLicenca(licenca);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Licenca>> listarLicencas() {
        List<Licenca> licencas = licencaService.listarLicencas();
        return ResponseEntity.ok(licencas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Licenca> buscarLicencaPorId(@PathVariable long id) {
        Optional<Licenca> licenca = licencaService.buscarLicencaPorId(id);
        return licenca.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Licenca> atualizarLicenca(@PathVariable long id, @RequestBody Licenca licenca) {
        Optional<Licenca> updatedLicenca = licencaService.atualizarLicenca(id, licenca);
        return updatedLicenca.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLicenca(@PathVariable long id) {
        if (licencaService.deletarLicenca(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/empresa/{cnpj}")
    public ResponseEntity<List<Licenca>> buscarLicencaPorEmpresa(@PathVariable String cnpj) {
        List<Licenca> licencas = licencaService.buscarLicencaPorEmpresa(cnpj);
        if (licencas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(licencas);
    }
}
