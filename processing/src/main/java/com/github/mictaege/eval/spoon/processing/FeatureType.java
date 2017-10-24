package com.github.mictaege.eval.spoon.processing;

public enum FeatureType {

    ESA(true),
    NASA(false);

    private final boolean active;

    FeatureType(final boolean active) {
        this.active = active;
    }

    public boolean active() {
        return active;
    }
}
