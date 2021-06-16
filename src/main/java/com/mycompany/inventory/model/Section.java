package com.mycompany.inventory.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Scope("prototype")
@Table(name = "section")
public class Section implements Serializable{
    @Id
    private long id;
    
    //lista active products , int capacity
}
