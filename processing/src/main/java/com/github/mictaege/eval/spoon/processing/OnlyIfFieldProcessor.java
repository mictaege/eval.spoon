package com.github.mictaege.eval.spoon.processing;

import spoon.processing.AbstractAnnotationProcessor;
import spoon.reflect.declaration.CtField;

import java.util.List;

import static java.lang.System.out;
import static java.util.Arrays.asList;

public class OnlyIfFieldProcessor extends AbstractAnnotationProcessor<OnlyIf, CtField<?>> {

    @Override
    public void process(final OnlyIf annotation, final CtField<?> field) {
        final List<Variant> flavour = asList(annotation.value());
        if (flavour.stream().noneMatch(Variant::active)) {
            out.println("[Spoon] Remove field " + field.getDeclaringType().getSimpleName() + "#" + field.getSimpleName());
            field.delete();
        }
    }

}
