package com.github.mictaege.eval.spoon.processing;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(TYPE)
@Repeatable(Alternative.class)
public @interface Alter {

    Variant ifActive();

    String with();

}
