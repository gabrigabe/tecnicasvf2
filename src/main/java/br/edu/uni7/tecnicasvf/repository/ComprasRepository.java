package br.edu.uni7.tecnicasvf.repository;


import br.edu.uni7.tecnicasvf.model.Compras;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ComprasRepository extends MongoRepository<Compras,Integer> {
    List<Compras> findAllByCpfCliente(String cpf);
    Compras getComprasByNotafiscal(UUID notafiscal);
}
