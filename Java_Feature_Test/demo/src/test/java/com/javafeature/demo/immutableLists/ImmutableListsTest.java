package com.javafeature.demo.immutableLists;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

class ImmutableListsTest {


    @Nested
    public class list_invariants_test {
        @DisplayName("immutableList 값 추가 되는지 테스트")
        @Test
        void immutableListTest() {

            List<String> modifiableList = new ArrayList<>();
            modifiableList.add("a");

            List<String> immutableList= List.copyOf(modifiableList);

            modifiableList.add("c");

            assertThatThrownBy(() -> immutableList.add("c"))
                .as("Check immutableList modification")
                .isInstanceOf(UnsupportedOperationException.class);

            assertThat(modifiableList).hasSize(2);
            assertThat(immutableList).hasSize(1);

        }

        @DisplayName("unmodifiedList 에 값 추가되는지 테스트")
        @Test
        void unmodifiedListTest(){
            //given
            List<String> modifiableList = new ArrayList<>();
            modifiableList.add("a");

            List<String> unModifiableList= Collections.unmodifiableList(
                modifiableList);

            modifiableList.add("b");

            //when then
            assertThatThrownBy(() -> unModifiableList.add("b"))
                .as("Check unmodifiableList modification")
                .isInstanceOf(UnsupportedOperationException.class);
            assertThat(modifiableList).hasSize(2);
            assertThat(unModifiableList).hasSize(2);

        }
    }

    @Test
    public void givenUsingJava9_whenNullElement_thenThrowsException() {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three", null));
        assertThatThrownBy(() -> List.of(list.toArray(new String[0])))
            .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void givenUsingGuava_whenNullElement_thenNoException() {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three", null));
        assertThatThrownBy(() -> ImmutableList.copyOf(list).add("four"))
            .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void givenUsingUnmodifiableList_whenAddElement_thenUnmodifiableListReflectsChange() {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        list.add("four");

        assertThat(unmodifiableList)
            .hasSize(4)
            .containsExactly("one", "two", "three", "four");
    }


}