package br.com.fiap.AMR.usecases.Funcionario;

import br.com.fiap.AMR.domains.Empresa;
import br.com.fiap.AMR.domains.Funcionario;
import br.com.fiap.AMR.gateways.response.EmpresaPostResponse;
import br.com.fiap.AMR.gateways.response.FuncionarioPostResponse;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {

    FuncionarioPostResponse inserirFuncionario(Funcionario funcionarioParaInserir);

    List<Funcionario> listarFuncionario();

    Optional<Funcionario> buscarFuncionarioPorCpf(String cpf);

    Optional<Funcionario> atualizarFuncionario(String cpf, Funcionario funcionarioParaAtualizar);

    List<Funcionario> buscarFuncionarioPorEmpresa(String cnpj);

    boolean deletarFuncionario(String cpf);

}
