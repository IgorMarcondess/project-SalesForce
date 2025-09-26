package br.com.fiap.AMR.usecases.Licenca;

import br.com.fiap.AMR.domains.Licenca;
import br.com.fiap.AMR.gateways.response.LicencaPostResponse;

import java.util.List;
import java.util.Optional;

public interface LicencaService {

    LicencaPostResponse inserirLicenca(Licenca licencaParaInserir);

    List<Licenca> listarLicencas();

    Optional<Licenca> buscarLicencaPorId(long idContrato);

    Optional<Licenca> atualizarLicenca(long idContrato, Licenca licencaParaAtualizar);

    boolean deletarLicenca(long idContrato);

    List<Licenca> buscarLicencaPorEmpresa(String cnpj);
}
