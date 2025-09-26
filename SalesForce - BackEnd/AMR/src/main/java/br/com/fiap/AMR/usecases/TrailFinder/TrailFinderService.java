package br.com.fiap.AMR.usecases.TrailFinder;

import br.com.fiap.AMR.domains.TrailFinder;
import br.com.fiap.AMR.gateways.response.TrailFinderResponse;
import br.com.fiap.AMR.gateways.response.TrailFinderResponseFlask;

import java.util.List;
import java.util.Optional;

public interface TrailFinderService {

    TrailFinder salvarTrailFinder(TrailFinder trailFinder);

    Optional<TrailFinder> buscarTrailFinderPorId(Long id);

    List<TrailFinder> buscarTrailFindersPorEmail(String email);

    List<TrailFinder> buscarTrailFindersPorNome(String name);

    List<TrailFinder> buscarTrailFindersPorTipoEmpresa(String tipoEmpresa);

    List<TrailFinderResponseFlask> buscarTrailPorProbabilidadeContratacao(double probabilidadeContratacao);

    List<TrailFinderResponse> buscarTrailPorProbabilidadeContratacaoTrail(double probabilidadeContratacao);

    void deletarTrailFinder(Long id);

    void atualizarProbabilidadeContratacao(Long id, double novaProbabilidade);

    List<TrailFinderResponse> buscarTodos();

}
