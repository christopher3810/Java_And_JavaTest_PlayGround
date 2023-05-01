package com.javafeature.demo.immutableLists;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class ImmutableListsTest {

    @Test
    public void test() {

        List<String> modifiableList = new ArrayList<String>();
        modifiableList.add("a");

        System.out.println("modifiableList:"+modifiableList);
        System.out.println("--");


        //unModifiableList

        assertEquals(1, modifiableList.size());

        List<String> unModifiableList= Collections.unmodifiableList(
            modifiableList);

        modifiableList.add("b");

        boolean exceptionThrown=false;
        try {
            unModifiableList.add("b");
            fail("add supported for unModifiableList!!");
        } catch (UnsupportedOperationException e) {
            exceptionThrown=true;
            System.out.println("unModifiableList.add() not supported");
        }
        assertTrue(exceptionThrown);

        System.out.println("modifiableList:"+modifiableList);
        System.out.println("unModifiableList:"+unModifiableList);

        assertEquals(2, modifiableList.size());
        assertEquals(2, unModifiableList.size());
        System.out.println("--");



        //immutableList


        List<String> immutableList=Collections.unmodifiableList(
            new ArrayList<String>(modifiableList));

        modifiableList.add("c");

        exceptionThrown=false;
        try {
            immutableList.add("c");
            fail("add supported for immutableList!!");
        } catch (UnsupportedOperationException e) {
            exceptionThrown=true;
            System.out.println("immutableList.add() not supported");
        }
        assertTrue(exceptionThrown);


        System.out.println("modifiableList:"+modifiableList);
        System.out.println("unModifiableList:"+unModifiableList);
        System.out.println("immutableList:"+immutableList);
        System.out.println("--");

        assertEquals(3, modifiableList.size());
        assertEquals(3, unModifiableList.size());
        assertEquals(2, immutableList.size());

    }

    @Test
    public void givenUsingJava9_whenNullElement_thenThrowsException() {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three", null));
        assertThrows(NullPointerException.class, () -> List.of(list.toArray(new String[]{})));
    }

    @Test
    public void givenUsingGuava_whenNullElement_thenNoException() {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three", null));
        assertThrows(NullPointerException.class, () -> ImmutableList.copyOf(list).add("four"));
    }

    @Test
    public void givenUsingUnmodifiableList_whenAddElement_thenUnmodifiableListReflectsChange() {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        list.add("four");

        assertEquals(4, unmodifiableList.size());
        assertEquals("one", unmodifiableList.get(0));
        assertEquals("two", unmodifiableList.get(1));
        assertEquals("three", unmodifiableList.get(2));
        assertEquals("four", unmodifiableList.get(3));
    }


}