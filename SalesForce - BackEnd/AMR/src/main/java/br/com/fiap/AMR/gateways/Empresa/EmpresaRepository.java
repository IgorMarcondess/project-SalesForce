package br.com.fiap.AMR.gateways.Empresa;

import br.com.fiap.AMR.domains.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, String> {

    Optional<Empresa> findByCnpj(String cnpj);
}
