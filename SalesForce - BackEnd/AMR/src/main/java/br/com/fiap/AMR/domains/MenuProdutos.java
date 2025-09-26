package br.com.fiap.AMR.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MenuProdutos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2)
    private String produtosSales;

    @NotNull
    @Size(max = 20)
    private String servicosSales;

    @NotNull
    @Size(max = 25)
    private String categoria;

    @NotNull
    @Size(max = 1)
    private String planos;

    @ManyToOne
    private Licenca licenca;
}
