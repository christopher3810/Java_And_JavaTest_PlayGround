package com.javafeature.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Repeatable(ChickenContainer.class)
public @interface DuplicatedChicken {

    //자기자신을 감쌀 컨테이너 애너테이션보다 같거나 넓어야 함.
    String value();
}
