package com.github.mictaege.eval.spoon.processing;

import static java.lang.System.out;

import spoon.processing.AbstractAnnotationProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.ModifierKind;

public class AlterClassProcessor extends AbstractAnnotationProcessor<Alter, CtClass<?>> {

    @Override
    public void process(final Alter annotation, final CtClass<?> toBeAltered) {
        final Variant flavour = annotation.ifActive();
        if (Variant.anyVariant() && flavour.active()) {
            final String altClass = annotation.with();
            out.println("[Spoon] Alter class " + toBeAltered.getSimpleName() + " with " + altClass);

            final CtType<?> altType = toBeAltered.getPackage().getType(altClass);

            final ModifierKind visibility = toBeAltered.getVisibility();
            final String simpleName = toBeAltered.getSimpleName();
            toBeAltered.delete();

            final CtType<?> clone = altType.clone();
            clone.setVisibility(visibility);
            clone.setSimpleName(simpleName);

            toBeAltered.getPackage().addType(clone);
        }
    }

}
