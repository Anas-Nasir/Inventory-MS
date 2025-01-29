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
@DiscriminatorValue("1")
public class InhousePart extends Part {
    int partId;
    private int maxInv;
    private int minInv;


    public InhousePart() {
        this.minInv = 0;
        this.maxInv = 100;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public int getMaxInv() {
        return this.maxInv;
    }

    public void setMaxInv(int maxInv) {
        this.maxInv = maxInv;
    }

    public int getMinInv() {
        return this.minInv;
    }

    public void setMinInv(int minInv) {
        this.minInv = minInv;
    }



}
