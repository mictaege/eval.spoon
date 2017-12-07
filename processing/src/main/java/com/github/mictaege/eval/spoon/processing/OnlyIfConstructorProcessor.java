package com.github.mictaege.eval.spoon.processing;

import spoon.processing.AbstractAnnotationProcessor;
import spoon.reflect.declaration.CtConstructor;

import java.util.List;

import static java.lang.System.out;
import static java.util.Arrays.asList;

public class OnlyIfConstructorProcessor extends AbstractAnnotationProcessor<OnlyIf, CtConstructor<?>> {

    @Override
    public void process(final OnlyIf annotation, final CtConstructor<?> constructor) {
        final List<Variant> flavour = asList(annotation.value());
        if (flavour.stream().noneMatch(Variant::active)) {
            out.println("[Spoon] Remove constructor " + constructor.getDeclaringType().getSimpleName());
            constructor.delete();
        }
    }

}
