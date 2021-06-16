package com.mycompany.inventory.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Table(name = "rack")
@Entity
public class Rack implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "Id not assignable")
    private Integer id;
       
    @Column(nullable = false, length = 20)
    @Size(min = 2, max = 20, message = "value is out of range")
    @NotNull
    private String identifier;
    
    @OneToMany(fetch = FetchType.LAZY, targetEntity=Row.class)
    private List<Row> sections;

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

    public List<Row> getSections() {
        return sections;
    }

    public void setSections(List<Row> sections) {
        this.sections = sections;
    }
}
