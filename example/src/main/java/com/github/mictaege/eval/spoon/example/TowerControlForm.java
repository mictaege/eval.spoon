package com.github.mictaege.eval.spoon.example;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ResourceBundle;

import static java.util.Optional.ofNullable;
import static java.util.ResourceBundle.getBundle;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.getDefault;
import static javafx.scene.text.FontWeight.EXTRA_BOLD;

public class TowerControlForm {

    public static final ResourceBundle RES = getBundle(TowerControlForm.class.getName());

    private ObjectProperty<BearerTypeModel> model;

    private GridPane root;
    private Label bearerField;
    private Label spaceShipField;

    public TowerControlForm() {
        super();
        model = new SimpleObjectProperty<>(new BearerTypeModel(null));
        model.addListener((observable, oldValue, newValue) -> ofNullable(newValue).ifPresent(m -> {
            bearerField.setText(m.getName());
            spaceShipField.setText(m.getSpaceShip());
        }));
        root = new GridPane();
        root.setHgap(10.0);
        root.setVgap(10.0);

        final Label title = new Label(RES.getString("title"));
        title.setFont(font(getDefault().getFamily(), EXTRA_BOLD, 14.0));
        root.add(title, 0, 0);

        root.add(new Label(RES.getString("bearer")), 0, 1);
        bearerField = new Label();
        root.add(bearerField, 1, 1);

        root.add(new Label(RES.getString("ship")), 0, 2);
        spaceShipField = new Label();
        root.add(spaceShipField, 1, 2);
    }

    public GridPane getRoot() {
        return root;
    }

    public ObjectProperty<BearerTypeModel> getModel() {
        return model;
    }
}
