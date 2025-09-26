package br.com.fiap.AMR.domains;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Licenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idContrato;


    @Size(min = 5, max = 5)
    private String contratoLicenca;

    @NotNull
    @Size(min = 1, max = 1)
    private String tipoLicenca;

    @NotNull
    @Size(max = 25)
    private String nomeLicenca;
    
    @NotNull
    @Size(max = 15)
    private String tipoVencimento;

    @NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate expira;

    @ManyToOne
    private Empresa empresa;
}
