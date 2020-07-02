package com.mycompany.inventory.model;

import com.mycompany.catalog.model.Category;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
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
@Table(name = "inventory_section_row")
public class SectionRow implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "Id not assignable")
    private Integer id;
    
    @Column(nullable = false)
    @Max(value = 99)
    @NotNull
    private Double capacity;
    
    @OneToMany(fetch = FetchType.LAZY, targetEntity=Category.class)
    @JoinColumn(name="product_category")
    private List<Category> category;
    
    @OneToMany(fetch = FetchType.EAGER)
    private List<ActiveProduct> products;

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

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public List<ActiveProduct> getProducts() {
        return products;
    }

    public void setProducts(List<ActiveProduct> products) {
        this.products = products;
    }
    
    
}
