package br.edu.uni7.tecnicasvf.controller;

import br.edu.uni7.tecnicasvf.model.Clientes;
import br.edu.uni7.tecnicasvf.model.Compras;
import br.edu.uni7.tecnicasvf.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class ComprasController {

    private final ComprasService service;

    @Autowired
    public ComprasController(ComprasService service){
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "compras", method = RequestMethod.POST)
    public Compras create(@RequestBody Compras compras) {
        return service.create(compras);
    }

    @ResponseBody
    @RequestMapping(value = "compras", method = RequestMethod.GET)
    public List<Compras> list() {
        return service.list();
    }

    @ResponseBody
    @RequestMapping(value = "compras/cpf/{cpf}", method = RequestMethod.GET)
    public List<Compras> findAllByCpfCliente(@PathVariable String cpf) {
        return service.findAllByCpfCliente(cpf);
    }

    @ResponseBody
    @RequestMapping(value = "compras/notafiscal/{notafiscal}", method = RequestMethod.GET)
    public Compras getComprasByNotafiscal(@PathVariable UUID notafiscal) {
        System.out.println(notafiscal);
        return service.getComprasByNotafiscal(notafiscal);
    }
}
