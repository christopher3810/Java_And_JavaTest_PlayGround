package com.javafeature.demo.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExamples {
    public static void main(String[] args) {
        // HashMap Example
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Three", 3);
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        // 키-값 쌍을 저장하며, 해시 함수를 사용하여 키에 대한 값의 저장 위치를 결정.
        // 키의 순서를 보장하지 않음.
        // 일반적인 경우에는 삽입, 검색, 삭제 연산이 O(1)의 시간 복잡도를 가짐.
        System.out.println("HashMap: " + hashMap);

        // TreeMap Example
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Three", 3);
        treeMap.put("One", 1);
        treeMap.put("Two", 2);
        // 레드-블랙 트리를 기반으로 하는 정렬된 맵.
        // 키는 자연스러운 순서로 정렬됩니다. 삽입, 검색, 삭제 연산은 O(log n)의 시간 복잡도를 가짐.
        // 정렬된 키를 필요로 하는 경우에 TreeMap을 사용하는 것이 좋음.
        System.out.println("TreeMap: " + treeMap);

        // LinkedHashMap Example
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Three", 3);
        linkedHashMap.put("One", 1);
        linkedHashMap.put("Two", 2);
        // 은 해시 테이블과 연결 리스트를 결합하여 구현.
        // 이로 인해 키-값 쌍의 삽입 순서를 유지할 수 있음.
        // 삽입 순서에 따라 요소를 반복해야 하는 경우에 LinkedHashMap을 사용하는 것이 좋음
음       System.out.println("LinkedHashMap: " + linkedHashMap);
    }
}
