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
@Table(name = "_section")
@Entity
public class Section implements Serializable {
    @Null(message = "Id not assignable")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private Integer columnY;
    
    @Column(nullable = false)
    private Integer rowX;
    
    @Column(nullable = false)
    @Max(value = 99)
    @NotNull
    private Double capacity;
    
    @ElementCollection
    @CollectionTable(name = "section_categories", joinColumns = @JoinColumn(name = "section_id"))
    @Column(name = "product_category_id")
    private List<Integer> categories;
    
    @OneToMany(fetch = FetchType.EAGER)
    private List<ActiveProduct> activeProducts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getColumnY() {
        return columnY;
    }

    public void setColumnY(Integer columnY) {
        this.columnY = columnY;
    }

    public Integer getRowX() {
        return rowX;
    }

    public void setRowX(Integer rowX) {
        this.rowX = rowX;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }

    public List<ActiveProduct> getActiveProducts() {
        return activeProducts;
    }

    public void setActiveProducts(List<ActiveProduct> activeProducts) {
        this.activeProducts = activeProducts;
    }

    
}
