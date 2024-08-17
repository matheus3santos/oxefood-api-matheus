package br.com.ifpe.oxefood.api.cliente;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(   
        summary = "Serviço responsável por salvar um cliente no sistema.", 
        description = "Exemplo de descrição de um endpoint responsável por inserir um cliente no sistema."
    )

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClienteRequest request) {

        Cliente cliente = clienteService.save(request.build());
        return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
    }

    @Operation(   
        summary = "Serviço responsável por listar um cliente no sistema.", 
        description = "Exemplo de descrição de um endpoint responsável por listar um cliente no sistema."
    )

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @Operation(   
        summary = "Serviço responsável por buscar um cliente no sistema.", 
        description = "Exemplo de descrição de um endpoint responsável por buscar um cliente no sistema."
    )

    @GetMapping("/{id}")
    public Cliente obterPorId(@PathVariable Long id) {
        return clienteService.obterPorId(id);
    }

    @Operation(   
        summary = "Serviço responsável por editar um cliente no sistema.", 
        description = "Exemplo de descrição de um endpoint responsável por editar um cliente no sistema."
    )

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ClienteRequest request) {

        clienteService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @Operation(   
        summary = "Serviço responsável por deletar um cliente no sistema.", 
        description = "Exemplo de descrição de um endpoint responsável por deletar um cliente no sistema."
    )

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

}
