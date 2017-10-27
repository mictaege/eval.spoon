package com.github.mictaege.eval.spoon.example;

import javafx.beans.property.SimpleStringProperty;

import static java.util.Optional.ofNullable;

public class BearerTypeModel {

    private final SimpleStringProperty name;
    private final SimpleStringProperty img;
    private final SimpleStringProperty spaceShip;

    public BearerTypeModel(final BearerType type) {
        this.name = new SimpleStringProperty(ofNullable(type).map(BearerType::getName).orElse(""));
        this.img = new SimpleStringProperty(ofNullable(type).map(BearerType::getImg).orElse("com/github/mictaege/eval/spoon/example/Default.png"));
        this.spaceShip = new SimpleStringProperty(ofNullable(type).map(t -> t.getSpaceShip().getType().getName()).orElse(""));
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getImg() {
        return img.get();
    }

    public SimpleStringProperty imgProperty() {
        return img;
    }

    public void setImg(String img) {
        this.img.set(img);
    }

    public String getSpaceShip() {
        return spaceShip.get();
    }

    public SimpleStringProperty spaceShipProperty() {
        return spaceShip;
    }

    public void setSpaceShip(String spaceShip) {
        this.spaceShip.set(spaceShip);
    }
}
