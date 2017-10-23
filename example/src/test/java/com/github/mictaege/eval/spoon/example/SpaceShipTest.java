package com.github.mictaege.eval.spoon.example;

import org.junit.Before;
import org.junit.Test;

import static com.github.mictaege.eval.spoon.example.SpaceShipType.HERMES;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SpaceShipTest {

    private SpaceShipType type;

    private SpaceShip ship;

    @Before
    public void context() {
        type = HERMES;
        this.ship = new SpaceShip(type);
    }

    @Test
    public void shouldProvideTest() {
        assertThat(ship.getType(), is(type));
    }

}