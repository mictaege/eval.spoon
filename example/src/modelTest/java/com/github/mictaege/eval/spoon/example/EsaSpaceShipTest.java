package com.github.mictaege.eval.spoon.example;

import com.github.mictaege.eval.spoon.processing.OnlyIf;
import org.junit.Before;
import org.junit.Test;

import static com.github.mictaege.eval.spoon.example.SpaceShipType.HERMES;
import static com.github.mictaege.eval.spoon.processing.Variant.ESA;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@OnlyIf(ESA)
public class EsaSpaceShipTest {

    private SpaceShip esaShip;

    @Before
    public void context() {
        this.esaShip = new SpaceShip(HERMES);
    }

    @Test
    public void shouldProvideEsaType() {
        assertThat(esaShip.getType(), is(HERMES));
    }

}