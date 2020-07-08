package com.mycompany.inventory.unit.testRepository;

import com.mycompany.inventory.model.Location;
import com.mycompany.inventory.repository.LocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:test_inventory.properties")
public class PersistLocationRepositoryTest {
    
    @Autowired
    private Location location;
    
    @Autowired
    private LocationRepository repository;
    
    @BeforeEach
    public void init(){
        location.setId(null);
        location.setLandline("");
        location.setAddress(null);
        location.setAreas(null);
    }
    
    @Test
    public void test() {
        
    }
}
