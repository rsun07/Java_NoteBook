package pers.xiaoming.notebook.basic.lang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD})
public @interface MyAnnotation {
    String[] values();

    MyAnnotationType myAnnotationType() default MyAnnotationType.OTHER;

    enum MyAnnotationType {
        TYPE,
        ANNOTATION,
        OTHER
    }
}
