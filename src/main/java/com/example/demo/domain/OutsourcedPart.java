package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 *
 *
 *
 */
@Entity
@DiscriminatorValue("2")
public class OutsourcedPart extends Part{
String companyName;

    public OutsourcedPart() {
        this.minInv = 0;
        this.maxInv = 100;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isValidInvAmount() {
        return this.inv >= this.minInv && this.inv <= this.maxInv;
    }

    public int getMinValue() {
        return this.minInv;
    }

    public int getMaxValue() {
        return this.maxInv;
    }

    public int getQuantity() {
        return this.inv;
    }
}
