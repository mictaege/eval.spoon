package com.github.mictaege.eval.spoon.example;

import com.github.mictaege.eval.spoon.processing.OnlyIf;

import static com.github.mictaege.eval.spoon.example.SpaceShipType.GEMINI;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.HERMES;
import static com.github.mictaege.eval.spoon.example.SpaceShipType.MERCURY;
import static com.github.mictaege.eval.spoon.processing.Variant.ESA;
import static com.github.mictaege.eval.spoon.processing.Variant.NASA;
import static com.github.mictaege.eval.spoon.processing.Variant.ROSKOSMOS;

public enum BearerType {

    @OnlyIf(ESA)
    ARIANE5("Ariane5", 1996, new SpaceShip(HERMES), "com/github/mictaege/eval/spoon/example/Ariane5.jpg"),

    @OnlyIf(NASA)
    ATLAS("Atlas", new SpaceShip(MERCURY), "com/github/mictaege/eval/spoon/example/Atlas.jpg"),
    @OnlyIf(NASA)
    TITAN("Titan", new SpaceShip(GEMINI), "com/github/mictaege/eval/spoon/example/Titan.jpg"),

    @OnlyIf(ROSKOSMOS)
    WOSTOK("Wostok", new SpaceShip(SpaceShipType.WOSTOK), "com/github/mictaege/eval/spoon/example/Wostok.jpg"),
    @OnlyIf(ROSKOSMOS)
    SOJUS("Sojus", new SpaceShip(SpaceShipType.SOJUS), "com/github/mictaege/eval/spoon/example/Sojus.jpg");

    private String name;
    @OnlyIf(ESA)
    private int constructionYear;
    private SpaceShip spaceShip;
    private String img;

    @OnlyIf(ESA)
    BearerType(final String name, final int constructionYear, final SpaceShip spaceShip, final String img) {
        this.name = name;
        this.constructionYear = constructionYear;
        this.spaceShip = spaceShip;
        this.img = img;
    }

    @OnlyIf({NASA, ROSKOSMOS})
    BearerType(final String name, final SpaceShip spaceShip, final String img) {
        this.name = name;
        this.spaceShip = spaceShip;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    @OnlyIf(ESA)
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
