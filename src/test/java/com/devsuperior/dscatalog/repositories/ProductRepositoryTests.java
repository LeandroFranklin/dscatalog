package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository repository;

    private long exintingId;
    private long notExistingId;
    private long contTotalProducts;

    @BeforeEach
    void setUp() throws Exception{
        exintingId = 1L;
        notExistingId = 55L;
        contTotalProducts =25L;
    }

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull(){

        Product product = Factory.createProduct();
        product.setId(null);

        product = repository.save(product);

        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals(contTotalProducts + 1, product.getId());
    }


    @Test
    public void deleteShouldDeleteObjectWhenIdExists(){

        repository.deleteById(exintingId);

        Optional<Product> result = repository.findById(exintingId);
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void findByIdShoulReturnOptionalNotEmptyWhenIdExists(){

        Optional<Product> result = repository.findById(exintingId);

        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    public void findByIdShouldReturnOptionalEmptyWhenIdDoesNotExist(){

        Optional<Product> result = repository.findById(notExistingId);

        Assertions.assertTrue(result.isEmpty());
    }

}

