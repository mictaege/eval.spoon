package com.github.mictaege.eval.spoon.example;

import com.github.mictaege.eval.spoon.processing.OnlyIf;
import com.github.mictaege.eval.spoon.processing.Fork;
import org.junit.Before;
import org.junit.Test;

import static com.github.mictaege.eval.spoon.example.SpaceShipType.HERMES;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.MERCURY;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.WOSTOK;
import static com.github.mictaege.eval.spoon.processing.Variant.ESA;
import static com.github.mictaege.eval.spoon.processing.Variant.NASA;
import static com.github.mictaege.eval.spoon.processing.Variant.ROSKOSMOS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SpaceShipTest {

    @OnlyIf(ESA)
    private SpaceShip esaShip;

    @OnlyIf(NASA)
    private SpaceShip nasaShip;

    @OnlyIf(ROSKOSMOS)
    private SpaceShip roskosmosShip;

    @Before
    @Fork(ifActive = ESA, to = "esaContext")
    @Fork(ifActive = NASA, to = "nasaContext")
    @Fork(ifActive = ROSKOSMOS, to = "roskosmosContext")
    public void context() {
        esaContext();
        nasaContext();
        roskosmosContext();
    }

    @OnlyIf(ESA)
    private void esaContext() {
        this.esaShip = new SpaceShip(HERMES);
    }

    @OnlyIf(NASA)
    private void nasaContext() {
        this.nasaShip = new SpaceShip(MERCURY);
    }


    @OnlyIf(ROSKOSMOS)
    private void roskosmosContext() {
        this.roskosmosShip = new SpaceShip(WOSTOK);
    }

    @Test
    @OnlyIf(ESA)
    public void shouldProvideEsaType() {
        assertThat(esaShip.getType(), is(HERMES));
    }

    @Test
    @OnlyIf(NASA)
    public void shouldProvideNasaType() {
        assertThat(nasaShip.getType(), is(MERCURY));
    }

    @Test
    @OnlyIf(ROSKOSMOS)
    public void shouldProvideRoskosmosType() {
        assertThat(roskosmosShip.getType(), is(WOSTOK));
    }

}