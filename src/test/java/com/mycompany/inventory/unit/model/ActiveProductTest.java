package com.mycompany.inventory.unit.model;

import com.mycompany.catalog.model.Product;
import com.mycompany.inventory.model.ActiveProduct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ActiveProductTest {
    @Autowired
    private ActiveProduct activeProduct;
    
    @Autowired
    private Product product;
    
    @Autowired
    private EntityManagerFactory factory;
    
    @BeforeEach
    public void init(){
        product.setId(Long.parseLong("1"));
        activeProduct.setId(null);
        activeProduct.setQuantity(Integer.SIZE);
        activeProduct.setProduct(product);
    }
    
    @Test
    public void given_id_is_not_present_when_persistent_then_should_fail(){
        //given
        activeProduct.setId(Long.valueOf("1"));
        
        Assertions.assertThrows(ConstraintViolationException.class, ()->{
            EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(activeProduct);
        transaction.commit();
        });
    }
}
