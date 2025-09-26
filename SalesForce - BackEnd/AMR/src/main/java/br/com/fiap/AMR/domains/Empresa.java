package br.com.fiap.AMR.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmpresa;

    @CNPJ
    private String cnpj;

    @NotNull
    private String nome;

    @NotNull
    private String razaoSocial;

   @NotNull
    private String assinatura;

    @NotNull
    private String atuacao;

    @NotNull
    private String codAtuacao;

}
