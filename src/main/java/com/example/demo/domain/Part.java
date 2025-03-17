package com.example.demo.domain;

import com.example.demo.validators.ValidDeletePart;
import com.example.demo.validators.ValidInv;
import jakarta.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 *
 *
 */
@Entity
@ValidDeletePart
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="part_type",discriminatorType = DiscriminatorType.INTEGER)
@Table(name="Parts")
@ValidInv
public abstract class Part implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;

    @Min(value = 0, message = "Price value must be positive")
    double price;
    @Min(value = 0, message = "Inventory value must be positive")
    int Inv;
    @Min(value = 0, message = "Min Inventory value must be positive")
    int MinInv;
    @Min(value = 100, message = "Max Inventory value must be positive")
    int MaxInv;


    @ManyToMany
    @JoinTable(name="product_part", joinColumns = @JoinColumn(name="part_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))
    Set<Product> products= new HashSet<>();

    public Part() {

    }

    public Part(String name, double price, int Inv) {
        this.name = name;
        this.price = price;
        this.Inv = Inv;
    }

    public Part(long id, String name, double price, int Inv) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.Inv = Inv;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInv() {
        return Inv;
    }

    public void setInv(int Inv) {
        this.Inv = Inv;
    }

    public int getMinInv(){
        return MinInv;
    }

    public void setMinInv(int MinInv){
        this.MinInv = MinInv;
    }

    public int getMaxInv(){
        return MaxInv;
    }

    public void setMaxInv(int MaxInv){
        this.MaxInv = MaxInv;
    }


    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String toString(){
        return this.name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Part part = (Part) o;

        return id == part.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }


}