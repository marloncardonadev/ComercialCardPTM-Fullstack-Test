package com.example.ComercialCardPTM.domain.repository;

import com.example.ComercialCardPTM.domain.model.ProductoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Long> {

}
