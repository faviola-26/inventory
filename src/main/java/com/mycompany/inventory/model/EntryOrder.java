package com.mycompany.inventory.model;

import com.mycompany.catalog.model.Product;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Format;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
@Entity
@Table(name = "inventory_entry_order")
public class EntryOrder implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "Id not assignable")
    private Integer id;
    
    @Column(nullable = false, length = 10)
    @NotNull
    @NotEmpty
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private String date;
    
    @Column(nullable = false, length = 6)
    @DateTimeFormat(pattern = "hh:mm:ss")
    private String hour;
    
    @ElementCollection
    @CollectionTable(
            name="inventory_entry_product",
            joinColumns={@JoinColumn(name="entry_order_id", referencedColumnName="id"),
                         @JoinColumn(name="product_id", referencedColumnName="id")})
    @MapKeyColumn(name = "product_id")
    @Column(name = "quantity")
    private Map<Product, Integer> products = new HashMap<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
}
