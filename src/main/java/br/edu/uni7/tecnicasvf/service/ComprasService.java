package br.edu.uni7.tecnicasvf.service;


import br.edu.uni7.tecnicasvf.model.Clientes;
import br.edu.uni7.tecnicasvf.model.Compras;
import br.edu.uni7.tecnicasvf.model.Produtos;
import br.edu.uni7.tecnicasvf.repository.ClienteRepository;
import br.edu.uni7.tecnicasvf.repository.ComprasRepository;
import br.edu.uni7.tecnicasvf.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ComprasService {
    private final ComprasRepository comprasRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ComprasService(ComprasRepository comprasRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository){
        this.comprasRepository = comprasRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public Compras create(Compras compras){
        double valorCompra = 0;

        Clientes cliente = clienteRepository.findByCpf(compras.getCpfCliente());
        if(cliente == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CPF inexistente");
        }

        List<Produtos> produtos = compras.getProdutos();
            for(Produtos produto: produtos) {
                try{
                    Produtos produtos2 = produtoRepository.findById(produto.getId()).get();
                    if(produto.getQuantidade() > produtos2.getQuantidade()){
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Algum produto esta com estoque insuficiente para compra");
                    }
                    produto.setNome(produtos2.getNome());
                    produto.setMarca(produtos2.getMarca());
                    produto.setPreco(produtos2.getPreco());
                    produto.setCategoria(produtos2.getCategoria());
                    produto.setCodbarras(produtos2.getCodbarras());

                    valorCompra = valorCompra +(produtos2.getPreco() * produto.getQuantidade());
                    produtos2.setQuantidade(produtos2.getQuantidade() - produto.getQuantidade());
                    produtoRepository.save(produtos2);

                }catch(NoSuchElementException e) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Algum produto listado não existe");

                }

            }
            compras.setValorcompras(valorCompra);
            System.out.println(cliente.getValorTotal());
            cliente.setValorTotal(cliente.getValorTotal() + valorCompra);
            System.out.println(cliente.getValorTotal());
            clienteRepository.save(cliente);
            return comprasRepository.save(compras);
    }

    public List<Compras> list(){
        return comprasRepository.findAll();

    }

    public List<Compras> findAllByCpfCliente(String cpf){
        List<Compras> comprascpf = comprasRepository.findAllByCpfCliente(cpf);
        if(comprascpf.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma compra encontrada com este cpf");

        }
        return comprascpf;


    }
    public Compras getComprasByNotafiscal(UUID notafiscal){

        Compras compranf = comprasRepository.getComprasByNotafiscal(notafiscal);
        if(compranf == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma compra encontrada com essa nota fiscal");
        }
        return compranf;

    }
}
