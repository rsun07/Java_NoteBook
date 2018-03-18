package java8.annotation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class RepeatableAnnotationTest {
    private Method method;

    @Before
    public void setUp() throws NoSuchMethodException {
        Class<AnnotationApplier> annotationApplierClass = AnnotationApplier.class;

        method = annotationApplierClass.getMethod("repeatableAnnotation");
    }


    @Test
    public void testCollection() {
        // Will get the RepeatableAnnotationCollection
        Annotation[] annotations = method.getDeclaredAnnotations();
        Assert.assertEquals(1, annotations.length);

        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    @Test
    public void testRepeatableAnnotations() {
        Annotation[] annotations = method.getAnnotationsByType(RepeatableAnnotation.class);
        Assert.assertEquals(3, annotations.length);

        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
