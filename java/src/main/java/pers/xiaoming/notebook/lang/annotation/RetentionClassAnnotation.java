package pers.xiaoming.notebook.lang.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface RetentionClassAnnotation {
    String value();
}
