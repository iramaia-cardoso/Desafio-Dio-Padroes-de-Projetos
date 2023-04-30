package one.digitalinnovation.ProjetoDio.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.ProjetoDio.model.Cliente;
import one.digitalinnovation.ProjetoDio.model.ClienteRepository;
import one.digitalinnovation.ProjetoDio.model.Endereco;
import one.digitalinnovation.ProjetoDio.model.EnderecoRepository;
import one.digitalinnovation.ProjetoDio.service.ClienteService;
import one.digitalinnovation.ProjetoDio.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPosId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        extracted(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            extracted(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void extracted(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novEndereco);
            return novEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

}
