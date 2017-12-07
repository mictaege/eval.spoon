package com.github.mictaege.eval.spoon.processing;

import spoon.processing.AbstractAnnotationProcessor;
import spoon.reflect.declaration.CtClass;

import java.util.List;

import static java.lang.System.out;
import static java.util.Arrays.asList;

public class OnlyIfClassProcessor extends AbstractAnnotationProcessor<OnlyIf, CtClass<?>> {

    @Override
    public void process(final OnlyIf annotation, final CtClass<?> clazz) {
        final List<Variant> flavour = asList(annotation.value());
        if (flavour.stream().noneMatch(Variant::active)) {
            out.println("[Spoon] Remove class " + clazz.getSimpleName());
            clazz.delete();
        }
    }

}
