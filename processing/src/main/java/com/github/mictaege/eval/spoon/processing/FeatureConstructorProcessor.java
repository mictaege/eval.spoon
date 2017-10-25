package com.github.mictaege.eval.spoon.processing;

import spoon.processing.AbstractAnnotationProcessor;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtMethod;

import static java.lang.System.out;

public class FeatureConstructorProcessor extends AbstractAnnotationProcessor<Feature, CtConstructor<?>> {

    @Override
    public void process(final Feature annotation, final CtConstructor<?> constructor) {
        final FeatureType featureType = annotation.value();
        if (!featureType.active()) {
            out.println("Spoon -> Remove constructor " + constructor.getDeclaringType().getSimpleName() + " for inactive feature " + featureType);
            constructor.delete();
        }
    }

}
