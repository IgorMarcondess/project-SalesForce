package br.com.fiap.AMR.gateways.Empresa;

import br.com.fiap.AMR.domains.Empresa;
import br.com.fiap.AMR.gateways.response.EmpresaPostResponse;
import br.com.fiap.AMR.usecases.Empresa.EmpresaService;
import br.com.fiap.AMR.usecases.Empresa.FormatarCnpj;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService, FormatarCnpj {

    private final EmpresaRepository empresaRepository;

    @Override
    public EmpresaPostResponse inserirEmpresa(Empresa empresa) {

        Optional<Empresa> empresaBusca = empresaRepository.findByCnpj(empresa.getCnpj());
        if (empresaBusca.isPresent()) {
            return new EmpresaPostResponse("Empresa não cadastrada, CNPJ já cadastrado: ", null);
        } else {
            empresaRepository.save(empresa);
            return new EmpresaPostResponse("Empresa cadastrada!", empresa);
        }
    }

    @Override
    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    public Optional<Empresa> buscarEmpresaPorCnpj(String cnpj) {

        String cnpjFormatado = formatarCnpj(cnpj);

        return empresaRepository.findByCnpj(cnpjFormatado);
    }

    @Override
    public Optional<Empresa> atualizarEmpresa(String cnpj, Empresa empresaParaAtualizar) {

        String cnpjFormatado = formatarCnpj(cnpj);

        Optional<Empresa> empresaExistente =empresaRepository.findByCnpj(cnpjFormatado);

        if (empresaExistente.isPresent()) {
            Empresa empresaAtualizada = empresaExistente.map(e -> {
                e.setNome(empresaParaAtualizar.getNome());
                e.setRazaoSocial(empresaParaAtualizar.getRazaoSocial());
                e.setAssinatura(empresaParaAtualizar.getAssinatura());
                e.setAtuacao(empresaParaAtualizar.getAtuacao());
                e.setCodAtuacao(empresaParaAtualizar.getCodAtuacao());
                return empresaRepository.save(e);
            }).get();

            return Optional.of(empresaAtualizada);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deletarEmpresa(String cnpj) {

        String cnpjFormatado = formatarCnpj(cnpj);

        return empresaRepository.findByCnpj(cnpjFormatado)
                .map(empresa -> {
                    empresaRepository.delete(empresa);
                    return true;
                }).orElse(false);
    }

    @Override
    public String formatarCnpj(String cnpj) {
        if (cnpj == null || cnpj.length() != 14) {
            throw new IllegalArgumentException("CNPJ deve conter exatamente 14 dígitos.");
        }
        return String.format("%s.%s.%s/%s-%s",
                cnpj.substring(0, 2),
                cnpj.substring(2, 5),
                cnpj.substring(5, 8),
                cnpj.substring(8, 12),
                cnpj.substring(12, 14));
    }
}
