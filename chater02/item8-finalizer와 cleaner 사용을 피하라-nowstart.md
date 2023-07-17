# finalizer와 cleaner 사용을 피하라

<!-- TOC -->
* [finalizer와 cleaner 사용을 피하라](#finalizer와-cleaner-사용을-피하라)
  * [finalizer](#finalizer)
  * [cleaner](#cleaner)
  * [결론](#결론)
<!-- TOC -->

## finalizer

* finalizer는 객체의 소멸 시점에 호출되지만 호출 시점과 순서는 보장되지 않는다
* 다른 객체나 리소스에 대한 의존성이 있는 경우 예기치 않은 동작을 유발할 수 있다
* finalizer는 객체 소멸 전에 실행되므로 오랜 시간 동안 실행되거나 무한 루프에 빠질 경우 프로그램 전체의 성능을 저하시킬 수 있다

## cleaner

* cleaner는 명시적으로 정리 작업을 수행하기 때문에 객체 소멸 시점과 작업 순서가 더 예측 가능하다
* cleaner는 finalizer에 비해 성능 면에서 더 효율적이다
* finalizer는 가비지 컬렉터에 의해 호출되어야 하지만, cleaner는 명시적으로 호출되기 때문에 가비지 컬렉터의 동작과는 독립적이다
* cleaner는 객체에 대한 명시적인 참조를 갖고 있지 않으므로, 객체가 다른 객체를 참조하고 있는 경우에도 자동으로 메모리 해제가 가능하다

```java
public class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();

    private static class State implements Runnable {
        int numJunkPiles;

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("방 청소");
        }
    }

    private final State state;

    private final Cleaner.Cleanable cleanable;
    
    public Room(int numJunkPiles){
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }
    
    @Override
    public void close(){
        cleanable.clean();
    }
}
```

```java
public class Adult {
    public static void main(String[] args) {
        try (Room myRoom = new Room(7)) {
            System.out.println("안녕~");
        }
    }
}

// output
// 안녕~
// 방 청소
```

```java
public class Adult {
    public static void main(String[] args) {
        new Room(99);
        System.out.println("아무렴");
    }
}

// output
// 아무렴
```
* System.exit 을 호출할 때의 cleaner 동작은 구현하기 나름이다
* cleaner 호출을 보장하지 않는다

## 결론

cleaner는 안전망 역할이나 중요하지 않은 네이티브 자원 회수용도로만 사용하자
물론 이런 경우라도 불확실성과 성능 저하에 주의해야 한다