package com.github.mictaege.eval.spoon.example;

import com.github.mictaege.eval.spoon.processing.OnlyIf;
import org.junit.Test;

import static com.github.mictaege.eval.spoon.example.BearerType.ARIANE5;
import static com.github.mictaege.eval.spoon.example.BearerType.ATLAS;
import static com.github.mictaege.eval.spoon.example.BearerType.SOJUS;
import static com.github.mictaege.eval.spoon.example.BearerType.TITAN;
import static com.github.mictaege.eval.spoon.example.BearerType.WOSTOK;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.GEMINI;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.HERMES;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.MERCURY;
import static com.github.mictaege.eval.spoon.processing.Variant.ESA;
import static com.github.mictaege.eval.spoon.processing.Variant.NASA;
import static com.github.mictaege.eval.spoon.processing.Variant.ROSKOSMOS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BearerTypeTest {

    @Test
    @OnlyIf(ESA)
    public void shouldAssertAriane5() {
        assertThat(ARIANE5.getName(), is("Ariane5"));
        assertThat(ARIANE5.getConstructionYear(), is(1996));
        assertThat(ARIANE5.getSpaceShip().getType(), is(HERMES));
        assertThat(ARIANE5.getImg(), is("com/github/mictaege/eval/spoon/example/Ariane5.jpg"));
    }

    @Test
    @OnlyIf(NASA)
    public void shouldAssertAtlas() {
        assertThat(ATLAS.getName(), is("Atlas"));
        assertThat(ATLAS.getSpaceShip().getType(), is(MERCURY));
        assertThat(ATLAS.getImg(), is("com/github/mictaege/eval/spoon/example/Atlas.jpg"));
    }

    @Test
    @OnlyIf(NASA)
    public void shouldAssertTitan() {
        assertThat(TITAN.getName(), is("Titan"));
        assertThat(TITAN.getSpaceShip().getType(), is(GEMINI));
        assertThat(TITAN.getImg(), is("com/github/mictaege/eval/spoon/example/Titan.jpg"));
    }

    @Test
    @OnlyIf(ROSKOSMOS)
    public void shouldAssertWostok() {
        assertThat(WOSTOK.getName(), is("Wostok"));
        assertThat(WOSTOK.getSpaceShip().getType(), is(SpaceShipType.WOSTOK));
        assertThat(WOSTOK.getImg(), is("com/github/mictaege/eval/spoon/example/Wostok.jpg"));
    }

    @Test
    @OnlyIf(ROSKOSMOS)
    public void shouldAssertSojus() {
        assertThat(SOJUS.getName(), is("Sojus"));
        assertThat(SOJUS.getSpaceShip().getType(), is(SpaceShipType.SOJUS));
        assertThat(SOJUS.getImg(), is("com/github/mictaege/eval/spoon/example/Sojus.jpg"));
    }

}