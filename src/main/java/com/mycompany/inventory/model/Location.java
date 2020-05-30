package com.mycompany.inventory.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "location", catalog = "inventory")
@Scope("prototype")
public class Location implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column()
    @OneToOne
    private Address address;
    
    @OneToMany
    private List<String> landline;
    
    @OneToMany
    private List<Area> areas;
}
