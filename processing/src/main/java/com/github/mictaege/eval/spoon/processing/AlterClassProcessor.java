package com.github.mictaege.eval.spoon.processing;

import spoon.processing.AbstractAnnotationProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtType;

import static java.lang.System.out;

public class AlterClassProcessor extends AbstractAnnotationProcessor<Alter, CtClass<?>> {

    @Override
    public void process(final Alter annotation, final CtClass<?> clazz) {
        final Variant feature = annotation.ifActive();
        if (Variant.anyVariant() && feature.active()) {
            final String altClass = annotation.with();
            out.println("[Spoon] Replace class " + clazz.getSimpleName() + " with " + altClass);

            final CtType<?> altType;
            if (annotation.nested()) {
                altType = clazz.getNestedType(altClass);
            } else {
                altType = clazz.getPackage().getType(altClass);
            }

            altType.setSimpleName(clazz.getSimpleName());
            altType.setModifiers(clazz.getModifiers());
            clazz.replace(altType);
        }
    }

}
