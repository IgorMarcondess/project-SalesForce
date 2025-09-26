package br.com.fiap.AMR.gateways.Atendimento;

import br.com.fiap.AMR.domains.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {


    List<Atendimento> findByContatoEncaminha(long contatoEncaminha);

    Optional<Atendimento> findAtendimentoByContatoEncaminhaAndDataEncaminha(long contatoEncaminha, LocalDate dataEncaminha);

    List<Atendimento> findAtendimentoByChatbot(String chatbot);



}
