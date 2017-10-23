package com.github.mictaege.eval.spoon.processing;

import spoon.processing.AbstractAnnotationProcessor;
import spoon.reflect.declaration.CtField;

public class FeatureProcessor extends AbstractAnnotationProcessor<Feature, CtField<?>> {

    @Override
    public void process(final Feature annotation, CtField<?> field) {
        System.out.println("-> Field " + field.getSimpleName() + " of class " + field.getDeclaringType().getSimpleName() + " is annotated with feature " + annotation.value());
    }
}
