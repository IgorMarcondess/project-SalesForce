package br.com.fiap.AMR.gateways.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrailFinderResponseFlask {

    private Long id;
    private String cargo;
    private String tipoEmpresa;
    private String setor;
    private double probabilidadeContratacao;


}
