package pers.xiaoming.notebook.basic.lang.annotation;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

public class MyAnnotationTest {
    @Test
    public void testAnnotation() throws NoSuchMethodException {
        Class<AnnotationApplier> annotationApplierClass = AnnotationApplier.class;
        Method method = annotationApplierClass.getMethod("myAnnotationMethod");

        Assert.assertTrue(method.isAnnotationPresent(MyAnnotation.class));

        MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);

        String[] expectedArray = {"myAnnotation", "myannotation", "my_annotation"};

        Assert.assertArrayEquals(expectedArray, myAnnotation.values());
        Assert.assertEquals(MyAnnotation.MyAnnotationType.ANNOTATION, myAnnotation.myAnnotationType());
    }

    @Test
    public void testDefaultType() throws NoSuchMethodException {
        Class<AnnotationApplier> annotationApplierClass = AnnotationApplier.class;
        Method method = annotationApplierClass.getMethod("myAnnotationMethodDefaultType");

        Assert.assertTrue(method.isAnnotationPresent(MyAnnotation.class));

        MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);

        Assert.assertEquals(MyAnnotation.MyAnnotationType.OTHER, myAnnotation.myAnnotationType());
    }
}
