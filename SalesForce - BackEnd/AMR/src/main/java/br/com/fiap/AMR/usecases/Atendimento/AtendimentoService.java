package br.com.fiap.AMR.usecases.Atendimento;


import br.com.fiap.AMR.domains.Atendimento;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AtendimentoService {

    Atendimento inserirAtendimento(Atendimento atendimentoParaInserir);

    List<Atendimento> listarAgentes();

    Optional<Atendimento> buscarAtendimento(int idAAtendimento);

    Optional<Atendimento> atualizarAtendimeno(int idAtendimento, Atendimento atendimentoParaAtualizar);

    boolean deletarAtendimento(int idAtendimento);

    List<Atendimento> buscarAtendimentosPorContato(long contatoEncaminha);

    Optional<Atendimento> buscarAtendimentoPorContatoEData(long contatoEncaminha, LocalDate dataEncaminha);

    List<Atendimento> buscarAtendimentosPorChatbot(String chatbot);

}
