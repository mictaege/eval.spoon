package com.github.mictaege.eval.spoon.processing;

import spoon.processing.AbstractAnnotationProcessor;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

import static java.lang.System.out;
import static java.util.Arrays.asList;

public class OnlyIfMethodProcessor extends AbstractAnnotationProcessor<OnlyIf, CtMethod<?>> {

    @Override
    public void process(final OnlyIf annotation, final CtMethod<?> method) {
        final List<Variant> features = asList(annotation.value());
        if (features.stream().noneMatch(Variant::active)) {
            out.println("[Spoon] Remove method " + method.getDeclaringType().getSimpleName() + "#" + method.getSimpleName());
            method.delete();
        }
    }

}
