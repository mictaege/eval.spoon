package com.github.mictaege.eval.spoon.processing;

import spoon.processing.AbstractAnnotationProcessor;
import spoon.reflect.declaration.CtType;

import static java.lang.System.*;

public class FeatureTypeProcessor extends AbstractAnnotationProcessor<Feature, CtType<?>> {

    @Override
    public void process(final Feature annotation, final CtType<?> type) {
        final FeatureType featureType = annotation.value();
        if (!featureType.active()) {
            out.println("Spoon -> Remove type " + type.getDeclaringType().getSimpleName() + " for inactive feature " + featureType);
            type.delete();
        }
    }

}
