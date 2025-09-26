package br.com.fiap.AMR.gateways.TrailFinder;

import br.com.fiap.AMR.domains.TrailFinder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrailFinderRepository extends JpaRepository<TrailFinder, Long> {
    List<TrailFinder> findByEmail(String email);

    List<TrailFinder> findByName(String name);

    List<TrailFinder> findByTipoEmpresa(String tipoEmpresa);

    List<TrailFinder> findByProbabilidadeContratacao(double probabilidadeContratacao);
}
