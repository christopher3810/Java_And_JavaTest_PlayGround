package com.javafeature.demo.annotation;

import java.util.Arrays;
import java.util.List;


@DuplicatedChicken("양념")
@DuplicatedChicken("치즈")
public class annotationTestMain {

    public static void main(String[] args) {

        DuplicatedChicken[] annotationsByType = annotationTestMain.class.getAnnotationsByType(
            DuplicatedChicken.class);

        List<@generalChicken String> names = Arrays.asList("test");

    }

    static class ChickenDemoClass<@Chicken T>{
        //@Target(ElementType.TYPE_PARAMETER)를 활용하여 제네릭 T에 에너테이션을 넣을 수있음.
        public static <@generalChicken C> void print(@generalChicken C c){
            System.out.println("c = " + c);
            //generalChicken은 여러 타입에 사용 가능.
        }
    }

}
