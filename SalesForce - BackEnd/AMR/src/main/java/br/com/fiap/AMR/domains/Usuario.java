package br.com.fiap.AMR.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @NotNull
    private String nomeUser;

    @Email
    @NotNull
    private String emailUser;

    @NotNull
    @Size(min = 6, max = 20)
    private String senhaUser;

    @Pattern(regexp = "\\d{10,11}", message = "Telefone deve conter 10 a 11 dígitos")
    private Long telUser;

    @ManyToOne
    private MenuProdutos menuProdutos;

    @ManyToOne
    private Chatbot chatbot;
}
