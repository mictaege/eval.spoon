package com.github.mictaege.eval.spoon.example;

import com.github.mictaege.eval.spoon.processing.Feature;
import org.junit.Before;
import org.junit.Test;

import static com.github.mictaege.eval.spoon.example.SpaceShipType.HERMES;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.MERCURY;
import static com.github.mictaege.eval.spoon.processing.FeatureType.ESA;
import static com.github.mictaege.eval.spoon.processing.FeatureType.NASA;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SpaceShipTest {

    @Feature(ESA)
    private SpaceShip esaShip;

    @Feature(NASA)
    private SpaceShip nasaShip;

    @Before
    @Feature(value = ESA, useTemplate = "esaContext")
    @Feature(value = NASA, useTemplate = "nasaContext")
    public void context() {
        esaContext();
        nasaContext();
    }

    @Feature(ESA)
    private void esaContext() {
        this.esaShip = new SpaceShip(HERMES);
    }

    @Feature(NASA)
    private void nasaContext() {
        this.nasaShip = new SpaceShip(MERCURY);
    }

    @Test
    @Feature(ESA)
    public void shouldProvideEsaType() {
        assertThat(esaShip.getType(), is(HERMES));
    }

    @Test
    @Feature(NASA)
    public void shouldProvideNasaType() {
        assertThat(nasaShip.getType(), is(MERCURY));
    }

}