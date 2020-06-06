package com.mycompany.inventory.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "rack", catalog = "inventory")
@Entity
public class Rack implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
       
    @Column(nullable = false, length = 20)
    private String identifier;
    
    @OneToOne(fetch = FetchType.EAGER)
    private List<List<Section>> sections;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<List<Section>> getSections() {
        return sections;
    }

    public void setSections(List<List<Section>> sections) {
        this.sections = sections;
    }
    
    
}
