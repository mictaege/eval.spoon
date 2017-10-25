package com.github.mictaege.eval.spoon.processing;

import spoon.processing.AbstractAnnotationProcessor;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtField;

import static java.lang.System.out;

public class FeatureFieldProcessor extends AbstractAnnotationProcessor<Feature, CtField<?>> {

    @Override
    public void process(final Feature annotation, final CtField<?> field) {
        final FeatureType featureType = annotation.value();

        if (!featureType.active()) {
            out.println("Spoon -> Remove field " + field.getDeclaringType().getSimpleName() + "#" + field.getSimpleName() + " for inactive feature " + featureType);
            field.delete();
        }
    }

}
