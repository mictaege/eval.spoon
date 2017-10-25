package com.github.mictaege.eval.spoon.processing;

import spoon.processing.AbstractAnnotationProcessor;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtTypeReference;

import static java.lang.System.out;
import static java.util.Optional.ofNullable;

public class ForkMethodProcessor extends AbstractAnnotationProcessor<Fork, CtMethod<?>> {

    @Override
    public void process(final Fork annotation, final CtMethod<?> method) {
        final Variant feature = annotation.ifActive();
        if (feature.active()) {
            final String altName = annotation.to();
            final CtTypeReference<?>[] params = method.getParameters().stream().toArray(i -> new CtTypeReference<?>[i]);
            final CtMethod<Object> alternative = ofNullable(method.getDeclaringType().getMethod(altName, params))
                    .orElseThrow(() -> new IllegalStateException("[ERROR] The given alternative method " + altName + " could not be found"));
            out.println("[Spoon] Replace method " + method.getDeclaringType().getSimpleName() + "#" + method.getSimpleName() + " with #" + altName);
            method.setBody(alternative.getBody());
        }
    }

}
