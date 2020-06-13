/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventory.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *
 * @author david.martinez
 */
@Component
@Table(name = "inventory_section_columns")
@Entity
public class SectionColumns implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToMany(targetEntity = Section.class)
    @JoinColumn(name ="section_rows")
    public List<Section> sectionRows;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Section> getSectionRows() {
        return sectionRows;
    }

    public void setSectionRows(List<Section> sectionRows) {
        this.sectionRows = sectionRows;
    }
   
}
