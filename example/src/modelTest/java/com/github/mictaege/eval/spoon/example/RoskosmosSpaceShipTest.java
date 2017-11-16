package com.github.mictaege.eval.spoon.example;

import com.github.mictaege.eval.spoon.processing.OnlyIf;
import org.junit.Before;
import org.junit.Test;

import static com.github.mictaege.eval.spoon.example.SpaceShipType.WOSTOK;
import static com.github.mictaege.eval.spoon.processing.Variant.ROSKOSMOS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@OnlyIf(ROSKOSMOS)
public class RoskosmosSpaceShipTest {

    private SpaceShip roskosmosShip;

    @Before
    public void context() {
        this.roskosmosShip = new SpaceShip(WOSTOK);
    }

    @Test
    public void shouldProvideRoskosmosType() {
        assertThat(roskosmosShip.getType(), is(WOSTOK));
    }

}