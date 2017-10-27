package com.github.mictaege.eval.spoon.processing;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD})
@Repeatable(Gateway.class)
public @interface Fork {

    Variant ifActive();

    String to();

}
