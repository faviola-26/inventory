package com.mycompany.inventory.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
@Entity
@Table(name = "entry_order")
public class EntryOrder implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "Id not assignable")
    private Integer id;
    
    @Column(name = "created_date", nullable = false, length = 10)
    @NotNull
    @NotEmpty
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private String createdHour;
    
    @Column(name = "created_hour", nullable = false, length = 6)
    @DateTimeFormat(pattern = "hh:mm:ss")
    private String createdDate;
    
    @ElementCollection
    @CollectionTable(
            name="entry_order_product",
            joinColumns={@JoinColumn(name="entry_order_id", referencedColumnName="id")})
    @MapKeyColumn(name = "catalog_product_id")
    @Column(name = "quantity")
    private Map<Long, Integer> products = new HashMap<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedHour() {
        return createdHour;
    }

    public void setCreatedHour(String createdHour) {
        this.createdHour = createdHour;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Map<Long, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Long, Integer> products) {
        this.products = products;
    }
}
