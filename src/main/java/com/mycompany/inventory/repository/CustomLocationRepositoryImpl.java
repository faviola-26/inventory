package com.mycompany.inventory.repository;

import com.mycompany.catalog.exceptions.InvalidEntityException;
import com.mycompany.inventory.model.Location;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomLocationRepositoryImpl implements CustomLocationRepository{
    @Autowired
    private EntityManagerFactory factory;
    
    @Override
    public void update(Location location) {
        EntityManager manager = factory.createEntityManager();
        
        try{
            manager.getTransaction().begin();
            manager.merge(location);
            manager.getTransaction().commit();
        }catch(ConstraintViolationException e){
            throw new InvalidEntityException(e.getMessage());
        }
    }
    
}
