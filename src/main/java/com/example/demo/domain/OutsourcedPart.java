package com.example.demo.domain;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


/**
 *
 *
 *
 *
 */
@Entity
@DiscriminatorValue("2")
public class OutsourcedPart extends Part {
    private final int minimum;
    private final int maximum;

    String companyName;

    public OutsourcedPart() {
        this.minimum = 0;
        this.maximum = 100;
    }

    public String getCompanyName() {
        return companyName;
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void validateMinMax() {

    }
}