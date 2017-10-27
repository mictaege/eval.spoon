package com.github.mictaege.eval.spoon.processing;

import spoon.processing.AbstractAnnotationProcessor;
import spoon.reflect.declaration.CtMethod;

import static java.lang.System.out;

public class ForkMethodProcessor extends AbstractAnnotationProcessor<Fork, CtMethod<?>> {

    @Override
    public void process(final Fork annotation, final CtMethod<?> method) {
        final Variant feature = annotation.ifActive();
        if (feature.active()) {
            final String altName = annotation.to();
            final CtMethod<?> alternative = method.getDeclaringType().getMethodsByName(altName).stream()
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("[ERROR] The given alternative method " + altName + " could not be found"));
            out.println("[Spoon] Replace method " + method.getDeclaringType().getSimpleName() + "#" + method.getSimpleName() + " with #" + altName);
            method.setBody(alternative.getBody());
            alternative.delete();
        }
    }

}
