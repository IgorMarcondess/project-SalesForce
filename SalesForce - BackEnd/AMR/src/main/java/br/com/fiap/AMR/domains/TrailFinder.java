package br.com.fiap.AMR.domains;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TrailFinder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;

    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @Size(min = 3, max = 20)
    private String cargo;

    @NotNull
    @Size(min = 3, max = 30)
    private String tipoEmpresa;

    @NotNull
    @Size(min = 3, max = 30)
    private String setor;

    @NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataContato;

    
    private Double probabilidadeContratacao;

    @ManyToOne
    private MenuProdutos menuProdutos;
}
