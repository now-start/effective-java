# 인스턴스화를 막으려거든 private 생성자를 사용하라

<!-- TOC -->
* [인스턴스화를 막으려거든 private 생성자를 사용하라](#인스턴스화를-막으려거든-private-생성자를-사용하라)
  * [인스턴스화를 막는 이유](#인스턴스화를-막는-이유)
  * [private 생성자](#private-생성자)
  * [결론](#결론)
<!-- TOC -->

## 인스턴스화를 막는 이유

* 정적 멤버만 담은 유틸리티 클래스의 인스턴스 생성을 근본적으로 막기위해
* 유틸리티 클래스를 추상 클래스로 만드는 것은 인스턴스화를 막는 것이 아님
* 추상 클래스의 의미는 클래스의 설계도로써 이를 상속해서 사용하라는 뜻으로 해석 될 수 있음

## private 생성자

* 클래스의 인스턴스 및 상속을 막을 수 있음


```java
public class UtilityClass {
    private utilityClass() {
        throw new AssertionError();
    }
    ...
}
```

## 결론

클래스의 상속 및 인스턴스화를 막으려면 private 생성자를 사용하는 것이 좋음
특히 정적 메서드 및 정적 필드만을 담은 유틸리티 클래스를 생성할때 유용한 방법


