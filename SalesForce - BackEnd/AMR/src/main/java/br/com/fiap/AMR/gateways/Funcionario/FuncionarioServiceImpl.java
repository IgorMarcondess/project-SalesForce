package br.com.fiap.AMR.gateways.Funcionario;

import br.com.fiap.AMR.domains.Empresa;
import br.com.fiap.AMR.domains.Funcionario;
import br.com.fiap.AMR.gateways.response.FuncionarioPostResponse;
import br.com.fiap.AMR.gateways.Empresa.EmpresaRepository;
import br.com.fiap.AMR.usecases.Funcionario.FuncionarioService;
import br.com.fiap.AMR.usecases.Funcionario.ManipularCpf;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService, ManipularCpf {

    private final FuncionarioRepository funcionarioRepository;

    private final EmpresaRepository empresaRepository;

    @Override
    public FuncionarioPostResponse inserirFuncionario(Funcionario funcionarioParaInserir) {

        Optional<Empresa> empresaBusca = empresaRepository.findByCnpj(funcionarioParaInserir.getEmpresa().getCnpj());

        Optional<Funcionario> funcionarioBusca = funcionarioRepository.findByCpf(funcionarioParaInserir.getCpf());

        if (funcionarioBusca.isPresent()) {
            return new FuncionarioPostResponse("Funcionário não cadastrado, CPF já registrado", null);
        } else if (empresaBusca.isEmpty()) {
            return new FuncionarioPostResponse("Funcionário não cadastrado, empresa não encontrada", null);
        } else {
            // Atribuir a empresa encontrada ao funcionário
            funcionarioParaInserir.setEmpresa(empresaBusca.get());

            funcionarioRepository.save(funcionarioParaInserir);
            return new FuncionarioPostResponse("Funcionário cadastrado com sucesso!", funcionarioParaInserir);
        }
    }


    @Override
    public List<Funcionario> listarFuncionario() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Optional<Funcionario> buscarFuncionarioPorCpf(String cpf) {
        String cpfFormatado = formatarCpf(cpf);
        return funcionarioRepository.findByCpf(cpfFormatado);
    }

    @Override
    public Optional<Funcionario> atualizarFuncionario(String cpf, Funcionario funcionarioParaAtualizar) {

        Optional<Empresa> empresaBusca = empresaRepository.findByCnpj(funcionarioParaAtualizar.getEmpresa().getCnpj());

        String cpfFormatado = formatarCpf(cpf);

        Optional<Funcionario> funcionarioExistente = funcionarioRepository.findByCpf(cpfFormatado);

        if (funcionarioExistente.isPresent() && empresaBusca.isPresent()) {
            Empresa rempresaInserir = empresaBusca.get();
            Funcionario funcionarioAtualizado = funcionarioExistente.map(f -> {
                f.setNome(funcionarioParaAtualizar.getNome());
                f.setSobrenome(funcionarioParaAtualizar.getSobrenome());
                f.setTelefone(funcionarioParaAtualizar.getTelefone());
                f.setSalario(funcionarioParaAtualizar.getSalario());
                f.setEmpresa(rempresaInserir);
                return funcionarioRepository.save(f);
            }).get();

            return Optional.of(funcionarioAtualizado);
        } else {
            return Optional.empty();
        }
    }


    @Override
    public List<Funcionario> buscarFuncionarioPorEmpresa(String cnpj) {
        return funcionarioRepository.findByEmpresa_Cnpj(cnpj);
    }

    @Override
    public boolean deletarFuncionario(String cpf) {

        String cpfFormatado = formatarCpf(cpf);

        return funcionarioRepository.findByCpf(cpfFormatado)
                .map(funcionario -> {
                    funcionarioRepository.delete(funcionario);
                    return true;
                }).orElse(false);
    }

    @Override
    public String formatarCpf(String cpf) {
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
}
