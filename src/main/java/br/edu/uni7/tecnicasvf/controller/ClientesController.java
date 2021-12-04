package br.edu.uni7.tecnicasvf.controller;


import br.edu.uni7.tecnicasvf.model.Clientes;
import br.edu.uni7.tecnicasvf.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientesController {
    public final ClientesService service;

    @Autowired
    public ClientesController(ClientesService service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "clientes", method = RequestMethod.POST)
    public Clientes create(@RequestBody Clientes clientes) {
        return service.create(clientes);
    }

    @ResponseBody
    @RequestMapping(value = "clientes", method = RequestMethod.GET)
    public List<Clientes> list() {
        return service.list();
    }

    @ResponseBody
    @RequestMapping(value = "clientes/{id}", method = RequestMethod.GET)
    public Clientes FindById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "clientes/{id}", method = RequestMethod.PUT)
    public Clientes update(@PathVariable Integer id, @RequestBody Clientes clientes) {
        clientes.setId(id);
        return service.update(clientes);

    }

    @ResponseBody
    @RequestMapping("clientes/{id}")
    public void remove(@PathVariable Integer id) {
        service.remove(id);

    }
}
