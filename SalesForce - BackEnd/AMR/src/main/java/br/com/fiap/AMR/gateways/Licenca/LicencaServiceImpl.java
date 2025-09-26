package br.com.fiap.AMR.gateways.Licenca;

import br.com.fiap.AMR.domains.Empresa;
import br.com.fiap.AMR.domains.Licenca;
import br.com.fiap.AMR.gateways.response.LicencaPostResponse;
import br.com.fiap.AMR.usecases.Licenca.LicencaService;
import br.com.fiap.AMR.gateways.Empresa.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LicencaServiceImpl implements LicencaService {

    private final LicencaRepository licencaRepository;
    private final EmpresaRepository empresaRepository;

    @Override
    public LicencaPostResponse inserirLicenca(Licenca licencaParaInserir) {
        // Verificar se a empresa existe pelo CNPJ
        Optional<Empresa> empresaOptional = empresaRepository.findByCnpj(licencaParaInserir.getEmpresa().getCnpj());

        if (empresaOptional.isPresent()) {
            Empresa empresa = empresaOptional.get();
            List<Licenca> licencasExistentes = licencaRepository.findByEmpresaCnpj(empresa.getCnpj());
            if (!licencasExistentes.isEmpty()) {
                // Retornar a licença existente
                return new LicencaPostResponse("Licença já existente", licencasExistentes.getFirst());
            }

            // Se não houver licença existente, atribuir a empresa encontrada à nova licença
            licencaParaInserir.setEmpresa(empresa);
        } else {
            return new LicencaPostResponse("Empresa não encontrada", null);
        }
        // Salvar nova licença
        Licenca licencaSalva = licencaRepository.save(licencaParaInserir);
        return new LicencaPostResponse("Licença criada com sucesso", licencaSalva);
    }

    @Override
    public List<Licenca> listarLicencas() {
        return licencaRepository.findAll();
    }

    @Override
    public Optional<Licenca> buscarLicencaPorId(long idContrato) {
        return licencaRepository.findById(idContrato);
    }

    @Override
    public Optional<Licenca> atualizarLicenca(long idContrato, Licenca licencaParaAtualizar) {
        return licencaRepository.findById(idContrato).map(licencaExistente -> {
            licencaExistente.setContratoLicenca(licencaParaAtualizar.getContratoLicenca());
            licencaExistente.setTipoLicenca(licencaParaAtualizar.getTipoLicenca());
            licencaExistente.setNomeLicenca(licencaParaAtualizar.getNomeLicenca());
            licencaExistente.setTipoVencimento(licencaParaAtualizar.getTipoVencimento());
            licencaExistente.setExpira(licencaParaAtualizar.getExpira());
            Licenca licencaAtualizada = licencaRepository.save(licencaExistente);
            return licencaAtualizada;
        });
    }

    @Override
    public boolean deletarLicenca(long idContrato) {
        if (licencaRepository.existsById(idContrato)) {
            licencaRepository.deleteById(idContrato);
            return true;
        }
        return false;
    }

    @Override
    public List<Licenca> buscarLicencaPorEmpresa(String cnpj) {
        return licencaRepository.findByEmpresaCnpj(cnpj);
    }
}
