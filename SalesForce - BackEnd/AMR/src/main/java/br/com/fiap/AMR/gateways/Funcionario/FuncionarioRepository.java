package br.com.fiap.AMR.gateways.Funcionario;

import br.com.fiap.AMR.domains.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {

    List<Funcionario> findByEmpresa_Cnpj(String cnpj);

    Optional<Funcionario> findByCpf(String cpf);

}
