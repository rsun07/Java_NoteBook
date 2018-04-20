package pers.xiaoming.notebook.lang.annotation;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Annotation;

public class RetentionPolicyTest {
    @Test
    public void test() {
        Class clazz = AnnotationApplier.class;

        Annotation[] annotations = clazz.getAnnotations();

        for(Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        Assert.assertEquals(1, annotations.length);
    }
}
