package com.tw.obc;

import static org.junit.Assert.*;
import org.junit.Test;

public class LengthTest {

    @Test
    public void shouldConvert1MTo1M() {
        assertEquals(new Length(1, Unit.M), new Length(1, Unit.M).in(Unit.M));
    }

    @Test
    public void shouldConvert1MTo100CM() {
        assertEquals(new Length(100, Unit.CM), new Length(1, Unit.M).in(Unit.CM));
    }

    @Test
    public void shouldConvert100CMTo1M() {
        assertEquals(new Length(1, Unit.M), new Length(100, Unit.CM).in(Unit.M));
    }

    @Test
    public void shouldConvert2500CMTo25M() {
        assertEquals(new Length(25, Unit.M), new Length(2500, Unit.CM).in(Unit.M));
    }

    @Test
    public void shouldConvert11MTo1100CM() {
        assertEquals(new Length(25, Unit.M), new Length(2500, Unit.CM).in(Unit.M));
    }

    @Test
    public void shouldConvert1CMTo10MM() {
        assertEquals(new Length(10, Unit.MM), new Length(1, Unit.CM).in(Unit.MM));
    }

    @Test
    public void shouldCreateLengthUsingFactoryMethodInUnit() {
        assertEquals(new Length(1, Unit.M), Unit.M.s(1));
    }

    @Test
    public void shouldEquate1MWith100CM() {
        assertEquals(Unit.CM.s(100), Unit.M.s(1));
    }

    @Test
    public void shouldEquate12MWith1200CM() {
        assertEquals(Unit.CM.s(1200), Unit.M.s(12));
    }

    @Test
    public void shouldEquate15MWith15000MM() {
        assertEquals(Unit.MM.s(15000), Unit.M.s(15));
    }

    @Test
    public void shouldEquate1KMWith1000000M() {
        assertEquals(Unit.MM.s(1000000), Unit.KM.s(1));
    }

    @Test
    public void shouldGive1KMWhen100CMAddedTo999M() {
        assertEquals(Unit.KM.s(1), Unit.M.s(999).plus(Unit.CM.s(100)));
    }

    @Test
    public void shouldGive500CMWhen100MMDeductedFrom510CM() {
        assertEquals(Unit.CM.s(500), Unit.CM.s(510).minus(Unit.MM.s(100)));
    }

}