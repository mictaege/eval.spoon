package com.github.mictaege.eval.spoon.example;

import org.junit.Test;

import static com.github.mictaege.eval.spoon.example.SpaceShipType.GEMINI;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.HERMES;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.MERCURY;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SpaceShipTypeTest {

    @Test
    public void shouldAssertHermes() {
        assertThat(HERMES.getName(), is("Hermes"));
    }

    @Test
    public void shouldAssertMercury() {
        assertThat(MERCURY.getName(), is("Mercury"));
    }

    @Test
    public void shouldAssertGemini() {
        assertThat(GEMINI.getName(), is("Gemini"));
    }

}