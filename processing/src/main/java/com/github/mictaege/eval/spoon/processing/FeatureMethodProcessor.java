package com.github.mictaege.eval.spoon.processing;

import spoon.processing.AbstractAnnotationProcessor;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtTypeReference;

import static java.lang.System.out;
import static java.util.Optional.ofNullable;

public class FeatureMethodProcessor extends AbstractAnnotationProcessor<Feature, CtMethod<?>> {

    @Override
    public void process(final Feature annotation, final CtMethod<?> method) {
        final FeatureType featureType = annotation.value();

        if (annotation.useTemplate().length() > 0) {
            if (featureType.active()) {
                final String altName = annotation.useTemplate();
                final CtTypeReference<?>[] params = method.getParameters().stream().toArray(i -> new CtTypeReference<?>[i]);
                final CtMethod<Object> alternative = ofNullable(method.getDeclaringType().getMethod(altName, params))
                        .orElseThrow(() -> new IllegalStateException("[ERROR] The given alternative method " + altName + " could not be found"));
                method.setBody(alternative.getBody());
            }
        } else if (!featureType.active()) {
            out.println("Spoon -> Remove method " + method.getDeclaringType().getSimpleName() + "#" + method.getSimpleName() + " for inactive feature " + featureType);
            method.delete();
        }
    }

}
