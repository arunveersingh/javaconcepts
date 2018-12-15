package annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// This tells that it should be Javadoc
@Documented
@Target(ElementType.METHOD)
// If it is inherited by child
@Inherited

@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation {

    int age() default 18;

    String name();

    String address();

    String stream() default "ME";
    
}
