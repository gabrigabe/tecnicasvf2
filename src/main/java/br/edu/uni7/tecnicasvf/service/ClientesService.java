package br.edu.uni7.tecnicasvf.service;


import br.edu.uni7.tecnicasvf.model.Clientes;
import br.edu.uni7.tecnicasvf.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClientesService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClientesService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Clientes create(Clientes clientes){
        return clienteRepository.save(clientes);
    }
    public List<Clientes> list(){
        return clienteRepository.findAll();
    }
    public Clientes findById(Integer id) {
        try{
            return clienteRepository.findById(id).get();
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id inexistente");
        }
    }

    public Clientes findByCpf(String cpf) {
        try{
            return clienteRepository.findByCpf(cpf);
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CPF inexistente");
        }
    }
    public Clientes update(Clientes clientes) {
        Optional<Clientes> idcliente = clienteRepository.findById(clientes.getId());
        if(idcliente.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id inexistente");
        }
        clienteRepository.save(clientes);
        return clientes;
    }

    public void remove(Integer id){
        try{
            clienteRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id inexistente");
        }
    }

}
