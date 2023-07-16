# 다 쓴 객체 참조를 해체하라

<!-- TOC -->
* [다 쓴 객체 참조를 해체하라](#다-쓴-객체-참조를-해체하라)
  * [가비지 컬렉터](#가비지-컬렉터)
  * [잘못된 코드](#잘못된-코드)
  * [메모리 누수가 일어나는 위치는 어디인가](#메모리-누수가-일어나는-위치는-어디인가)
  * [해결](#해결)
  * [결론](#결론)
<!-- TOC -->

## 가비지 컬렉터

* 가비지 컬렉터는 자동으로 더 이상 사용되지 않는 메모리를 탐지하고 해제하는 기능을 한다
* 이를 통해 메모리 누수를 방지하고 개발자가 메모리 관리에 대한 부담을 줄여준다

## 잘못된 코드

```java
public class Stack {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private Object[] elements;
    private int size = 0;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();

        return elements[size--];
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
```

## 메모리 누수가 일어나는 위치는 어디인가

* Stack에서 pop()메서드를 실행 시켜도 값만 출력될 뿐 실제 Stack 에서 값이 빠져나가지 않는다
* 그러므로 스텍이 커졌다가 줄어들었을 떄 스택에서 꺼내진 객체들은 가비지 컬렉터가 회수하지 않는다

```java
Stack stack = new Stack();

stack.push(1);  // stack : { 1 }
stack.push(2);  // stack : { 1, 2 }

System.out.println(stack.pop());  // 출력값 : 5 | stack : { 1, 2 }
System.out.println(stack.pop());  // 출력값 : 4 | stack : { 1, 2 }
        
stack.push(A);  // stack : { A, 2 }
        
System.out.println(stack.pop());  // 출력값 : 5 | stack : { A, 2 }
System.out.println(stack.pop());  // 출력값 : EmptyStatckException() | stack : { A, 2 }
```

## 해결
```java
public Object pop() {
    if (size == 0)
        throw new EmptyStackException();

    Object result = return elements[size--];
    elements[size] = null;
    return result;
```

* Stack에서 사용한 elements는 null로 초기화를 시켜준다
* 그러면 가비지 컬렉터가 자동으로 메모리를 해제시켜 준다
* 또 다른 방법으로는 stack 변수의 유효 범위를 작게 설정하여  사용하면 된다 ([item57](https://github.com/now-start/effective-java/blob/main/chapter9/item57-지역변수의%20범위를%20최소화%20하라-nowstart.md))

## 결론
메모리 누수는 겉으로 잘 드러나지 않아 시스템에 수년간 잠복하는 사례도 있다
이런 수는 철저한 코드 리뷰나 힙 프로파일러 같은 디버깅 도구를 동원해야만 발견되기도 한다
그래서 이런 종류의 문제는 예방법을 익혀두는 것이 매우 중요하다