package com.javafeature.demo.LazyAndEager;

public class SingleTonExample {
    public static void main(String[] args) {
        // Eager instantiation 사용
        EagerSingleton eagerInstance = EagerSingleton.getInstance();
        System.out.println("Eager Singleton instance: " + eagerInstance);

        // Lazy instantiation 사용
        LazySingleton lazyInstance = LazySingleton.getInstance();
        System.out.println("Lazy Singleton instance: " + lazyInstance);
    }
}
// Eager instantiation을 사용하는 Singleton 클래스
class EagerSingleton {
    // 객체를 클래스 로딩 시점에 생성합니다.
    private static final EagerSingleton instance = new EagerSingleton();

    // 생성자를 private으로 선언하여 외부에서 인스턴스 생성을 제한합니다.
    private EagerSingleton() {
    }

    // 객체 인스턴스에 접근할 수 있는 메서드를 제공합니다.
    public static EagerSingleton getInstance() {
        return instance;
    }
}

// Lazy instantiation을 사용하는 Singleton 클래스
class LazySingleton {
    // 객체 참조를 null로 초기화합니다.
    private static LazySingleton instance = null;

    // 생성자를 private으로 선언하여 외부에서 인스턴스 생성을 제한합니다.
    private LazySingleton() {
    }

    // 객체 인스턴스에 접근할 수 있는 메서드를 제공합니다.
    public static LazySingleton getInstance() {
        // 인스턴스가 아직 생성되지 않았다면, 생성 후 반환합니다.
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}