package com.tw.obc;

import java.math.BigDecimal;

// Understands measurement of a 1D objects
public class Length {

    private BigDecimal value;
    private LengthUnit unit;

    Length(BigDecimal value,LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    Length(double value,LengthUnit unit) {
        this(BigDecimal.valueOf(value), unit);
    }

    public Length in(LengthUnit otherUnit) {
        return new Length(this.value.multiply(this.unit.scale).divide(otherUnit.scale), otherUnit);
    }

    public Length plus(Length other) {
        return new Length(this.value.add(other.in(this.unit).value), this.unit);
    }

    public Length minus(Length other) {
        return this.plus(other.negate());
    }

    private Length negate() {
        return new Length(this.value.negate(), this.unit);
    }

    @Override
    public boolean equals(Object other) {
        return (other == this) || ((getClass() == other.getClass()) && equals((Length)other));
    }

    private boolean equals(Length other) {
        return (other != null) && (other.in(this.unit).value.compareTo(this.value) == 0);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.value != null ? this.value.hashCode() : 0);
        hash = 97 * hash + (this.unit != null ? this.unit.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return value + unit.name();
    }

}