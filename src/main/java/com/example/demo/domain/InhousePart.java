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
    private int maxValue;
    private int minValue;


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

    public int getMaxValue() {

        return this.maxValue;
    }

    public int getMinValue() {
        return this.minValue;
    }
}

