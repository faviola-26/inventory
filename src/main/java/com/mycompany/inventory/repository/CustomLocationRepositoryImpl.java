package com.mycompany.inventory.repository;

import com.mycompany.inventory.model.Location;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomLocationRepositoryImpl implements CustomLocationRepository{
    @Autowired
    private EntityManagerFactory factory;
    
    @Override
    public void update(Location location) throws ConstraintViolationException {
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        Location updated = manager.merge(location);
        manager.getTransaction().commit();
    }
    
}
