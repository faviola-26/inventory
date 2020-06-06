package com.mycompany.inventory.unit.model;

import com.mycompany.catalog.model.Category;
import com.mycompany.inventory.model.Address;
import com.mycompany.inventory.model.Location;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

@Import({Category.class})
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
