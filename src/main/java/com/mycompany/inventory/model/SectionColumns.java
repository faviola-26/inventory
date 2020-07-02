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
import javax.validation.constraints.Null;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
@Table(name = "inventory_section_columns")
@Entity
public class SectionColumns implements Serializable {
    @Null(message = "Id not assignable")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToMany(targetEntity = SectionRow.class)
    @JoinColumn(name ="section_rows")
    public List<SectionRow> sectionRows;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<SectionRow> getSectionRows() {
        return sectionRows;
    }

    public void setSectionRows(List<SectionRow> sectionRows) {
        this.sectionRows = sectionRows;
    }
   
}
