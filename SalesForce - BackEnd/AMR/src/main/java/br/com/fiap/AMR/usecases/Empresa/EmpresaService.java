package br.com.fiap.AMR.usecases.Empresa;

import br.com.fiap.AMR.domains.Empresa;
import br.com.fiap.AMR.gateways.response.EmpresaPostResponse;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {

    EmpresaPostResponse inserirEmpresa(Empresa empresaParaInserir);

    List<Empresa> listarEmpresas();

    Optional<Empresa> buscarEmpresaPorCnpj(String cnpj);

    Optional<Empresa> atualizarEmpresa(String cnpj, Empresa empresaParaAtualizar);

    boolean deletarEmpresa(String cnpj);

}
