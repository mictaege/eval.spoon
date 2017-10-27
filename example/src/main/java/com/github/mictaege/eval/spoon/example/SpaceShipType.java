package com.github.mictaege.eval.spoon.example;

import com.github.mictaege.eval.spoon.processing.OnlyIf;

import static com.github.mictaege.eval.spoon.processing.Variant.ESA;
import static com.github.mictaege.eval.spoon.processing.Variant.NASA;
import static com.github.mictaege.eval.spoon.processing.Variant.ROSKOSMOS;

public enum SpaceShipType {

    @OnlyIf(ESA)
    HERMES("Hermes"),

    @OnlyIf(NASA)
    MERCURY("Mercury"),
    @OnlyIf(NASA)
    GEMINI("Gemini"),

    @OnlyIf(ROSKOSMOS)
    WOSTOK("Wostok"),
    @OnlyIf(ROSKOSMOS)
    SOJUS("Sojus");



    private String name;

    SpaceShipType(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
