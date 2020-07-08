package com.mycompany.inventory.unit.model;

import com.mycompany.inventory.model.Location;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@ActiveProfiles("test")
@SpringBootTest
@TestPropertySource(locations="classpath:test_inventory.properties")
public class AddressTest {
    
    @Autowired
    private Location location;

    @Autowired 
    private EntityManagerFactory factory; 
    
    @Test
    public void testSchema(){
        
    }
}