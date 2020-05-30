package com.mycompany.app.unit.model;

import com.mycompany.inventory.model.Address;
import com.mycompany.inventory.model.Location;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AddressTest {
    
    @Autowired
    private Location location;
    
    @Autowired
    private EntityManager manager;
    
    @Test
    public void testSchema(){
        
    }

}
