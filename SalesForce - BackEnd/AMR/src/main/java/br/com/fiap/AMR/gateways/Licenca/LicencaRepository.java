package br.com.fiap.AMR.gateways.Licenca;

import br.com.fiap.AMR.domains.Licenca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LicencaRepository extends JpaRepository<Licenca, Long> {
    List<Licenca> findByEmpresaCnpj(String cnpj);
}

