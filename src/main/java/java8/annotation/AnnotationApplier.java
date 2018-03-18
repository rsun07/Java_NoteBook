package java8.annotation;

public class AnnotationApplier {

    // Only allow one annotation here
    @NonRepeatableAnnotation("")
    // @NonRepeatableAnnotation("")
    public void nonRepeatableAnnotation() {

    }

    @RepeatableAnnotation
    @RepeatableAnnotation
    @RepeatableAnnotation
    public void repeatableAnnotation() {

    }
}
