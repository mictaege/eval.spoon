package com.github.mictaege.eval.spoon.processing;

import spoon.processing.AbstractAnnotationProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtMethod;

public class FeatureProcessor extends AbstractAnnotationProcessor<Feature, CtMethod<?>> {

    @Override
    public void process(final Feature annotation, final CtMethod<?> method) {
        final FeatureType featureType = annotation.value();
        System.out.println("-> Method " + method.getSimpleName() + " of class " + method.getDeclaringType().getSimpleName() + " is annotated with feature " + featureType);
        final CtBlock<?> body = method.getBody();
        final String ifStmnt = "if (!" + featureType.getClass().getName() + "." + featureType.name() + ".active()" + ") {"
                + " throw new IllegalStateException(\"Invalid feature invocation.\");"
                + "}";
        final CtCodeSnippetStatement before = getFactory().Code().createCodeSnippetStatement(ifStmnt);
        body.insertBegin(before);
    }

}
