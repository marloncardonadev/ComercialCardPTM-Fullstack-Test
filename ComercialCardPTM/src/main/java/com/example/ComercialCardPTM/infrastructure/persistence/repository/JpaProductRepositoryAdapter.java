package com.example.ComercialCardPTM.infrastructure.persistence.repository;

import com.example.ComercialCardPTM.domain.model.Product;
import com.example.ComercialCardPTM.domain.repository.ProductRepository;
import com.example.ComercialCardPTM.infrastructure.persistence.entity.ProductEntity;
import com.example.ComercialCardPTM.infrastructure.persistence.mapper.ProductEntityMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

interface SpringDataProductJpa extends JpaRepository<ProductEntity, Long> { }

@Repository
public class JpaProductRepositoryAdapter implements ProductRepository {
    private final SpringDataProductJpa jpa;

    public JpaProductRepositoryAdapter(SpringDataProductJpa jpa) {
        this.jpa = jpa;
    }

    @Override
    public Product save(Product product) {
        var saved = jpa.save(ProductEntityMapper.toEntity(product));
        return ProductEntityMapper.toDomain(saved);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpa.findById(id).map(ProductEntityMapper::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return jpa.findAll().stream().map(ProductEntityMapper::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpa.existsById(id);
    }
}
