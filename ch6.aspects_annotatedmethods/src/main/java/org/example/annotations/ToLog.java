package org.example.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)  //NOTE: This is important as annotations cannot be intercepted at RUNTIME
@Target(ElementType.METHOD) //NOTE: Explicitly set the annotation can only be used in methods.
public @interface ToLog {

}
