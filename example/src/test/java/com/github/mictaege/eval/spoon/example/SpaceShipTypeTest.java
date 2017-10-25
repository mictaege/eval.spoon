package com.github.mictaege.eval.spoon.example;

import com.github.mictaege.eval.spoon.processing.Feature;
import org.junit.Test;

import static com.github.mictaege.eval.spoon.example.SpaceShipType.GEMINI;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.HERMES;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.MERCURY;
import static com.github.mictaege.eval.spoon.processing.FeatureType.ESA;
import static com.github.mictaege.eval.spoon.processing.FeatureType.NASA;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SpaceShipTypeTest {

    @Test
    @Feature(ESA)
    public void shouldAssertHermes() {
        assertThat(HERMES.getName(), is("Hermes"));
    }

    @Test
    @Feature(NASA)
    public void shouldAssertMercury() {
        assertThat(MERCURY.getName(), is("Mercury"));
    }

    @Test
    @Feature(NASA)
    public void shouldAssertGemini() {
        assertThat(GEMINI.getName(), is("Gemini"));
    }

}