package com.github.mictaege.eval.spoon.example;

import com.github.mictaege.eval.spoon.processing.OnlyIf;
import org.junit.Before;
import org.junit.Test;

import static com.github.mictaege.eval.spoon.example.SpaceShipType.MERCURY;
import static com.github.mictaege.eval.spoon.processing.Variant.NASA;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@OnlyIf(NASA)
public class NasaSpaceShipTest {

    private SpaceShip nasaShip;

    @Before
    public void context() {
        this.nasaShip = new SpaceShip(MERCURY);
    }

    @Test
    public void shouldProvideNasaType() {
        assertThat(nasaShip.getType(), is(MERCURY));
    }

}