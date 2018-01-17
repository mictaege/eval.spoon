package com.github.mictaege.eval.spoon.processing;

import static java.lang.System.out;
import static java.util.Arrays.asList;

import java.util.List;

import spoon.processing.AbstractAnnotationProcessor;
import spoon.reflect.declaration.CtType;

@SuppressWarnings("squid:S106")
public class OnlyIfClassProcessor extends AbstractAnnotationProcessor<OnlyIf, CtType<?>> {

    @Override
    public void process(final OnlyIf annotation, final CtType<?> clazz) {
        final List<Variant> flavour = asList(annotation.value());
        if (flavour.stream().noneMatch(Variant::active)) {
            out.println("[Spoon] Remove class " + clazz.getSimpleName());
            clazz.delete();
        }
    }

}
