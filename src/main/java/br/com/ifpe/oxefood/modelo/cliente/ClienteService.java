package br.com.ifpe.oxefood.modelo.cliente;

//Caso a função não funcione importar ela manualmente
import java.util.List;
import jakarta.transaction.Transactional;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    public Cliente save(Cliente cliente) {

        cliente.setHabilitado(Boolean.TRUE);
        cliente.setVersao(1L);
        cliente.setDataCriacao(LocalDate.now());
        return repository.save(cliente);
    }

    public List<Cliente> listarTodos() {

        return repository.findAll();
    }

    public Cliente obterPorId(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Cliente clienteAlterado) {

        Cliente cliente = repository.findById(id).get();
        cliente.setNome(clienteAlterado.getNome());
        cliente.setDataNascimento(clienteAlterado.getDataNascimento());
        cliente.setCpf(clienteAlterado.getCpf());
        cliente.setFoneCelular(clienteAlterado.getFoneCelular());
        cliente.setFoneFixo(clienteAlterado.getFoneFixo());

        cliente.setVersao(cliente.getVersao() + 1);
        repository.save(cliente);
    }

    @Transactional
    public void delete(Long id) {

        Cliente cliente = repository.findById(id).get();
        cliente.setHabilitado(Boolean.FALSE);
        cliente.setVersao(cliente.getVersao() + 1);

        repository.save(cliente);
    }

}
