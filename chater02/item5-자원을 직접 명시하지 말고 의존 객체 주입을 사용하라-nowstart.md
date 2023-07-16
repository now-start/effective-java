# 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라

<!-- TOC -->
* [자원을 직접 명시하지 말고 의존 객체 주입을 사용하라](#자원을-직접-명시하지-말고-의존-객체-주입을-사용하라)
  * [잘못된 유틸리티 클래스 생성](#잘못된-유틸리티-클래스-생성)
  * [의존 객체 주입](#의존-객체-주입)
  * [결론](#결론)
<!-- TOC -->

## 잘못된 유틸리티 클래스 생성

* 정적 유틸리티를 잘못 사용한 예

```java
public class SpellChecker {
    private static final Lexicon dictionary = ...;

    private SpellChecker() {}

    public static boolean isValid(String word) { ... }

    public static List<String> suggestions(String typo) { ... }
}
```

* 싱클턴을 잘못 사용한 예

```java
import java.util.List;

public class SpellChecker {
    private static final Lexicon dictionary = ...;

    private SpellChecker(...) {}
    public static SpellChecker INSTANCE = new SpellChecker(...);

    public boolean isValid(String word) { ... }
    public List<String> suggestions(String typo) { ... }
}
```

* 유연하지 않고 테스트하기 어렵다
* dictionary 필드를 변경할 수 없어 모든 쓰임에서 유연하지 못하다

## 의존 객체 주입

```java
public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Object.requireNonNull(dictionary);
    }

    public boolean isValid(String word) { ... }
    public List<String> suggestions(String typo) { ... }
}
```

* 앞선 2방식 모두 유연한 클래스를 만들기에는 적합한 방식이 아니다
* 필드에서 final 한정자를 제거하고 다른 사전을 교체하는 메서드를 추가할 수도 있긴 함
* 하지만 이러한 방식은 멀티스레드 환경에서는 적합하지 않음
    * 언제 필드가 변경될지 모르기 때문이다, 다른 스레드에서 사용 중에 변경될 경우 잘못된 동작을 할 수 있다
* 그러므로 유연성을 높이기 위해 인스턴스를 생성할 때 생성자에 필요한 자원을 넘겨주는 방식을 사용한다
    * 각 스레드에서 필요한 자원을 넘겨줘 사용하기 때문에 변경 시점을 통제할 수 있다

## 결론

클래스가 내부적으로 하나 이상의 자원에 의존하고, 그 자원이 클래스 동작에 영향을 준다면 싱글턴과 정적 유틸리티 클래스는 사용하지 않는 것이 좋다
의존 객체 주입은 클래스의 유연성, 재사용성, 테스트 용이성을 기가막히게 개선해준다


