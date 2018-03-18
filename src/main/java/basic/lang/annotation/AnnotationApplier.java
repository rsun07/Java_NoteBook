package basic.lang.annotation;

@RetentionSourceAnnotation("retention source")
@RetentionClassAnnotation("retention class")
@RetentionRuntimeAnnotation("retention runtime")

// Cannot present here because the MyAnnotation not target "ElementType.TYPE"
//@MyAnnotation(values = {"myAnnotation", "myannotation", "my_annotation"},
//        myAnnotationType = MyAnnotation.MyAnnotationType.ANNOTATION)
class AnnotationApplier {

    @MyAnnotation(values = {"myAnnotation", "myannotation", "my_annotation"},
            myAnnotationType = MyAnnotation.MyAnnotationType.ANNOTATION)
    void myAnnotationMethod() {
        System.out.println("Running my annotation method");
    }
}
