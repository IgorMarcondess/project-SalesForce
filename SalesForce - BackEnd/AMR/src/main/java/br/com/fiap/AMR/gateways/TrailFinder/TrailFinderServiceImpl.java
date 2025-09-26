package br.com.fiap.AMR.gateways.TrailFinder;

import br.com.fiap.AMR.domains.MenuProdutos;
import br.com.fiap.AMR.domains.TrailFinder;
import br.com.fiap.AMR.gateways.MenuProdutos.MenuProdutosRepository;
import br.com.fiap.AMR.gateways.response.TrailFinderResponse;
import br.com.fiap.AMR.gateways.response.TrailFinderResponseFlask;
import br.com.fiap.AMR.usecases.TrailFinder.TrailFinderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TrailFinderServiceImpl implements TrailFinderService {

    private TrailFinderRepository trailFinderRepository;
    private final MenuProdutosRepository menuProdutosRepository;

    @Override
    public TrailFinder salvarTrailFinder(TrailFinder trailFinder) {
        Optional<MenuProdutos> menuProdutos = menuProdutosRepository.findById(trailFinder.getMenuProdutos().getId());
        if (menuProdutos.isPresent()) {
            trailFinder.setMenuProdutos(menuProdutos.get());
            return trailFinderRepository.save(trailFinder);
        }
        return null;
    }

    @Override
    public Optional<TrailFinder> buscarTrailFinderPorId(Long id) {
        return trailFinderRepository.findById(id);
    }

    @Override
    public List<TrailFinder> buscarTrailFindersPorEmail(String email) {
        return trailFinderRepository.findByEmail(email);
    }

    @Override
    public List<TrailFinder> buscarTrailFindersPorNome(String name) {
        return trailFinderRepository.findByName(name);
    }

    @Override
    public List<TrailFinder> buscarTrailFindersPorTipoEmpresa(String tipoEmpresa) {
        return trailFinderRepository.findByTipoEmpresa(tipoEmpresa);
    }

    @Override
    public List<TrailFinderResponseFlask> buscarTrailPorProbabilidadeContratacao(double probabilidadeContratacao) {
        // Busca os TrailFinders com probabilidade igual a 0.0
        List<TrailFinder> trailFinders = trailFinderRepository.findByProbabilidadeContratacao(probabilidadeContratacao);

        // Mapeia para o DTO
        return trailFinders.stream()
                .map(trailFinder -> new TrailFinderResponseFlask(
                                        trailFinder.getId(),
                                        trailFinder.getCargo(),
                                        trailFinder.getTipoEmpresa(),
                                        trailFinder.getSetor(),
                                        trailFinder.getProbabilidadeContratacao()
                                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<TrailFinderResponse> buscarTrailPorProbabilidadeContratacaoTrail(double probabilidadeContratacao) {
        return List.of();
    }

    @Override
    public void deletarTrailFinder(Long id) {
        trailFinderRepository.deleteById(id);
    }

    @Override
    public void atualizarProbabilidadeContratacao(Long id, double novaProbabilidade) {
        Optional<TrailFinder> trailFinder = trailFinderRepository.findById(id);
        if (trailFinder.isPresent()) {
            TrailFinder tf = trailFinder.get();
            tf.setProbabilidadeContratacao(novaProbabilidade);
            trailFinderRepository.save(tf);
        }
    }

    @Override
    public List<TrailFinderResponse> buscarTodos() {
        List<TrailFinder> trailFinders = trailFinderRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        return trailFinders.stream()
                .map(trailFinder -> objectMapper.convertValue(trailFinder, TrailFinderResponse.class))
                .collect(Collectors.toList());
    }


}
