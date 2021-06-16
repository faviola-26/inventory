package com.mycompany.inventory.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name = "section_row")
public class Row implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "Id not assignable")
    private Integer id;
    
    @Column(nullable = false)
    @Max(value = 99)
    @NotNull
    private Double capacity;
    
    @ElementCollection
    @CollectionTable(name = "section_row_category_id", joinColumns = @JoinColumn(name = "section_row_id"))
    @Column(name = "category_id")
    private List<Integer> categories;
    
    @OneToMany(fetch = FetchType.EAGER)
    private List<ActiveProduct> activeProducts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public List<Integer> getCategory() {
        return categories;
    }

    public void setCategory(List<Integer> categories) {
        this.categories = categories;
    }

    public List<ActiveProduct> getProducts() {
        return activeProducts;
    }

    public void setProducts(List<ActiveProduct> products) {
        this.activeProducts = products;
    }
    
    
}
