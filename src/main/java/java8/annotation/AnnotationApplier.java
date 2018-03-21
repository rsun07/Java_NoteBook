package java8.annotation;

public class AnnotationApplier {

    // Only allow one annotation here
    @NonRepeatableAnnotation("")
    // @NonRepeatableAnnotation("")
    public void nonRepeatableAnnotation() {

    }

    @RepeatableAnnotation
    @RepeatableAnnotation("Repeatable Annotation 2")
    @RepeatableAnnotation("repeatable_annotation_3")
    public void repeatableAnnotation() {

    }
}
