package com.github.mictaege.eval.spoon.example;

import static com.github.mictaege.eval.spoon.processing.FeatureType.ESA;
import static com.github.mictaege.eval.spoon.processing.FeatureType.NASA;

import com.github.mictaege.eval.spoon.processing.Feature;

public enum SpaceShipType {

    @Feature(ESA)
    HERMES("Hermes"),

    @Feature(NASA)
    MERCURY("Mercury"),
    @Feature(NASA)
    GEMINI("Gemini");

    private String name;

    SpaceShipType(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
