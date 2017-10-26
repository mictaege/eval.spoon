package com.github.mictaege.eval.spoon.processing;

import static java.lang.System.getProperty;
import static java.util.Optional.ofNullable;

public enum Variant {

    ESA,
    NASA,
    ROSKOSMOS;

    public boolean active() {
        return ofNullable(getProperty("variant"))
                .map(p -> p.equals(this.name()))
                .orElse(false);
    }

}
