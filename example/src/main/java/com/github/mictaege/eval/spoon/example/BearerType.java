package com.github.mictaege.eval.spoon.example;

import static com.github.mictaege.eval.spoon.processing.FeatureType.ESA;
import static com.github.mictaege.eval.spoon.processing.FeatureType.NASA;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.GEMINI;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.HERMES;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.MERCURY;

import com.github.mictaege.eval.spoon.processing.Feature;

public enum BearerType {

    @Feature(ESA)
    ARIANE5("Ariane5", 1996, new SpaceShip(HERMES), "com/github/mictaege/eval/spoon/Ariane5.jpg"),

    @Feature(NASA)
    ATLAS("Atlas", 0, new SpaceShip(MERCURY), "com/github/mictaege/eval/spoon/Atlas.jpg"),
    @Feature(NASA)
    TITAN("Titan", 0, new SpaceShip(GEMINI), "com/github/mictaege/eval/spoon/Titan.jpg");

    private String name;
    @Feature(ESA)
    private int constructionYear;
    private SpaceShip spaceShip;
    private String img;

    BearerType(final String name, @Feature(ESA)final int constructionYear, final SpaceShip spaceShip, final String img) {
        this.name = name;
        this.constructionYear = constructionYear;
        this.spaceShip = spaceShip;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    @Feature(ESA)
    public int getConstructionYear() {
        return constructionYear;
    }

    public SpaceShip getSpaceShip() {
        return spaceShip;
    }

    public String getImg() {
        return img;
    }
}
