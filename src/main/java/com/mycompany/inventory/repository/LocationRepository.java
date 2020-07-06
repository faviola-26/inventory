package com.mycompany.inventory.repository;

import com.mycompany.inventory.model.Location;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface LocationRepository extends JpaRepository<Location, Long>, CustomLocationRepository{
    
}
