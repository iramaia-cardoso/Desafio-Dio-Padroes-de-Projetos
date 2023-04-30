package one.digitalinnovation.ProjetoDio.service;

import one.digitalinnovation.ProjetoDio.model.Cliente;

public interface ClienteService {
    Iterable<Cliente> buscarTodos();

    Cliente buscarPosId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);

}
