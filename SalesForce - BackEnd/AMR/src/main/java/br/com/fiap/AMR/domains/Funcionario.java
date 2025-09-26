package br.com.fiap.AMR.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString()
public class Funcionario {


    @CPF
    @NotNull
    private String cpf;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 3, max = 20)
    private String nome;

    @NotNull
    @Size(min = 5, max = 30)
    private String sobrenome;

    @NotNull
    @Pattern(regexp = "\\d{10,11}", message = "Telefone deve conter 10 a 11 dígitos")
    private String telefone;

    @NotNull
    @ToString.Exclude
    private double salario;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Empresa empresa;
}
