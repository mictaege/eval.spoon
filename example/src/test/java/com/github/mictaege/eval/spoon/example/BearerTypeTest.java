package com.github.mictaege.eval.spoon.example;

import org.junit.Test;

import static com.github.mictaege.eval.spoon.example.BearerType.ARIANE5;
import static com.github.mictaege.eval.spoon.example.BearerType.ATLAS;
import static com.github.mictaege.eval.spoon.example.BearerType.TITAN;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.GEMINI;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.HERMES;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.MERCURY;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BearerTypeTest {

    @Test
    public void shouldAssertAriane5() {
        assertThat(ARIANE5.getName(), is("Ariane5"));
        assertThat(ARIANE5.getConstructionYear(), is(1996));
        assertThat(ARIANE5.getSpaceShip().getType(), is(HERMES));
        assertThat(ARIANE5.getImg(), is("com/github/mictaege/eval/spoon/example/Ariane5.jpg"));
    }

    @Test
    public void shouldAssertAtlas() {
        assertThat(ATLAS.getName(), is("Atlas"));
        assertThat(ATLAS.getConstructionYear(), is(0));
        assertThat(ATLAS.getSpaceShip().getType(), is(MERCURY));
        assertThat(ATLAS.getImg(), is("com/github/mictaege/eval/spoon/example/Atlas.jpg"));
    }

    @Test
    public void shouldAssertTitan() {
        assertThat(TITAN.getName(), is("Titan"));
        assertThat(TITAN.getConstructionYear(), is(0));
        assertThat(TITAN.getSpaceShip().getType(), is(GEMINI));
        assertThat(TITAN.getImg(), is("com/github/mictaege/eval/spoon/example/Titan.jpg"));
    }

}