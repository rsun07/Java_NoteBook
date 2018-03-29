package pers.xiaoming.notebook.java8.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

@Repeatable(RepeatableAnnotationCollection.class)


@Target({TYPE, METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatableAnnotation {
    String value() default "Repeatable Annotation";
}
