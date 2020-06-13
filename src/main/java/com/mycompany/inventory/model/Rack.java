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
import org.springframework.stereotype.Component;

@Component
@Table(name = "inventory_srack")
@Entity
public class Rack implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
       
    @Column(nullable = false, length = 20)
    private String identifier;
    
    @OneToOne(fetch = FetchType.EAGER, targetEntity=SectionColumns.class)
    private List<SectionColumns> sectionColumns;

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

    public List<SectionColumns> getSectionColumns() {
        return sectionColumns;
    }

    public void setSectionColumns(List<SectionColumns> sectionColumns) {
        this.sectionColumns = sectionColumns;
    }    
}
