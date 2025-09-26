package br.com.fiap.AMR.gateways.Atendimento;

import br.com.fiap.AMR.domains.Atendimento;
import br.com.fiap.AMR.usecases.Atendimento.AtendimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AtendimentoServiceImpl implements AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;

    @Override
    public Atendimento inserirAtendimento(Atendimento atendimentoParaInserir) {
        return atendimentoRepository.save(atendimentoParaInserir);
    }

    @Override
    public List<Atendimento> listarAgentes() {
        return atendimentoRepository.findAll();
    }

    @Override
    public Optional<Atendimento> buscarAtendimento(int idAtendimento) {
        return atendimentoRepository.findById(idAtendimento);
    }

    @Override
    public Optional<Atendimento> atualizarAtendimeno(int idAtendimento, Atendimento atendimentoParaAtualizar) {
        Optional<Atendimento> atendimentoExistente = atendimentoRepository.findById(idAtendimento);

        if (atendimentoExistente.isPresent()) {
            Atendimento atendimentoAtualizado = atendimentoExistente.map(a -> {
                a.setDataEncaminha(atendimentoParaAtualizar.getDataEncaminha());
                a.setResolucaoEncaminha(atendimentoParaAtualizar.getResolucaoEncaminha());
                a.setChatbot(atendimentoParaAtualizar.getChatbot());
                a.setContatoEncaminha(atendimentoParaAtualizar.getContatoEncaminha());
                return atendimentoRepository.save(a);
            }).get();

            return Optional.of(atendimentoAtualizado);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deletarAtendimento(int idAtendimento) {
        return atendimentoRepository.findById(idAtendimento)
                .map(atendimento -> {
                    atendimentoRepository.delete(atendimento);
                    return true;
                }).orElse(false);
    }

    @Override
    public List<Atendimento> buscarAtendimentosPorContato(long contatoEncaminha) {
        return atendimentoRepository.findByContatoEncaminha(contatoEncaminha);
    }

    @Override
    public Optional<Atendimento> buscarAtendimentoPorContatoEData(long contatoEncaminha, LocalDate dataEncaminha) {
        return atendimentoRepository.findAtendimentoByContatoEncaminhaAndDataEncaminha(contatoEncaminha, dataEncaminha);
    }

    @Override
    public List<Atendimento> buscarAtendimentosPorChatbot(String chatbot) {
        return atendimentoRepository.findAtendimentoByChatbot(chatbot);
    }

}
