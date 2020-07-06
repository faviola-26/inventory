package com.mycompany.inventory.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name = "inventory_address")
public class Address implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "Id must be null")
    private Integer id;
    
    @Column(name = "street_name", nullable = false, length = 60)
    @Size(min = 8, max = 60, message = "Value is out range")
    @NotNull
    @NotEmpty
    private String streetName;
    
    @Column(name = "street_number", nullable = false)
    @NotNull
    @Min(value = 1)
    @Max(value = 9999)
    private Integer streetNumber;
    
    @Column(name = "neighborhood", nullable = false, length = 60)
    @NotNull
    @NotEmpty
    @Size(min = 8, max = 60, message = "Value is out range")
    private String neighborhood;
    
    @Column(name = "city", nullable = false, length = 40)
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 40, message = "Value is out of range")
    private String city;
    
    @Column(name = "state", nullable = false, length = 40)
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 40, message = "Value is out of range")
    private String state;
    
    @Column(name = "cp", nullable = false, length = 10)
    @NotNull
    @NotEmpty
    @Size(min = 6, max = 10, message = "Value is out of range")
    private String cp;
    
    @Column(name = "country", nullable = false, length = 30)
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 30, message = "Value is out of range")
    private String country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
