package com.github.mictaege.eval.spoon.processing;

public enum Variant {

    ESA(true),
    NASA(false),
    ROSKOSMOS(false);

    private final boolean active;

    Variant(final boolean active) {
        this.active = active;
    }

    public boolean active() {
        return active;
    }

}
