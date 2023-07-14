# effective-java

[![build](https://github.com/now-start/effective-java/actions/workflows/pages/pages-build-deployment/badge.svg)](https://now-start.github.io/effective-java/)

* List
    * [Chapter2](#chapter2)
    * [Chapter3](#chapter3)
    * [Chapter4](#chapter4)
    * [Chapter5](#chapter5)
    * [Chapter6](#chapter6)
    * [Chapter7](#chapter7)
    * [Chapter8](#chapter8)
    * [Chapter9](#chapter9)

## Convention

* GitHub Workflow 사용
* 각자 필요한 Branch 생성
* 각 Chapter 별 패키지에 itemNumber_itemTitle_gitHubUserName 으로 저장
* 필요시 각 Chapter 패키지에 src 및 resource 패키지 생성 가능
* 작성 완료 후 reviewer 전체 지정 후 main 으로 PR
* 질문 및 필요사항 review 후 merge

## Ground Rule

## Reference

* [책 정보 링크](https://www.yes24.com/Product/Goods/65551284)
* 관련 강의
    - [이펙티브 자바 완벽 공략 1부](https://www.inflearn.com/course/%EC%9D%B4%ED%8E%99%ED%8B%B0%EB%B8%8C-%EC%9E%90%EB%B0%94-1)
    - [이펙티브 자바 완벽 공략 2부](https://www.inflearn.com/course/%EC%9D%B4%ED%8E%99%ED%8B%B0%EB%B8%8C-%EC%9E%90%EB%B0%94-2)
* [이펙티브자바 공식 Github](https://github.com/WegraLee/effective-java-3e-source-code)
* [이펙티브자바 3판 번역 용어 설명](https://docs.google.com/document/d/1Nw-_FJKre9x7Uy6DZ0NuAFyYUCjBPCpINxqrP0JFuXk/edit)

## Chapter2

| item                                            | presentation |
|-------------------------------------------------|--------------|
| item1. 생성자 대신 정적 팩터리 메서드를 고려하라                  |              |
| item2. 생성자에 매개변수가 많다면 필더를 고려하라                  |              |
| item3. private 생성자나 열거 타입으로 싱글턴임을 보증하라          |              |
| item4. 인스턴스화를 막으려거든 private 생성자를 사용하라           |              |
| item5. 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라            |              |
| item6. 불필요한 객체 생성을 피하라                          |              |
| item7. 다 쓴 객체 참조를 해제하라                          |              |
| item8. finalizer와 cleaner 사용을 피하라               |              |
| item9. try-finally 보다는 try-with-resources를 사용하라 |              |

## Chapter3

| item                                    | presentation  |
|-----------------------------------------|---------------|
| item10. equals는일반 규약을 지켜 재정의하라          | [now-start]() |
| item11. equals를 재정의하려거든 hashCode도 재정의하라 | [now-start]() |
| item12. toString을 항상 재정의하라              | [now-start]() |
| item13. clone 재정의는 주의해서 진행하라            | [now-start]() |
| item14. Comparable을 구현할지 고려하라           | [now-start]() |

## Chapter4

| item                                              | presentation  |
|---------------------------------------------------|---------------|
| item15. 클래스와 멤버의 접근 권한을 최소화하라                     | [now-start]() |
| item16. public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라 | [now-start]() |
| item17. 변경 가능성을 최소화하라                             | [now-start]() |
| item18. 상속보다는 컴포지션을 사용하라                          | [now-start]() |
| item19. 상속을 고래해 설계하고 문서화하라. 그렇지 않았다면 상속을 금지하라     | [now-start]() |
| item20. 추상 클래스보다는 인터페이스를 우선하라                     | [now-start]() |
| item21. 인터페이스는 구현하는 쪾을 생각해 설계하라                   | [now-start]() |
| item22. 인터페이스는 타입을 정의하는 용도로만 사용하라                 | [now-start]() |
| item23. 태그 달린 클래스보다는 클래스 계층구조를 활용하라               | [now-start]() |
| item24. 멤버 클래스는 되도록 static으로 만들어라                 | [now-start]() |
| item25. 톱레벨 클래스는 한 파일에 하나만 담으라                    | [now-start]() |

## Chapter5

| item                                | presentation  |
|-------------------------------------|---------------|
| item26. 로 타입은 사용하지 말라               | [now-start]() |
| item27. 비검사 경고를 제거하라                | [now-start]() |
| item28. 배열보다는 리스트를 사용하라             | [now-start]() |
| item29. 이왕이면 제네릭 타입으로 만들라           | [now-start]() |
| item30. 이왕이면 제네릭 메서드로 만들라           | [now-start]() |
| item31. 한정적 와일드카드를 사용해 API 유연성을 높이라 | [now-start]() |
| item32. 제네릭과 가변인수를 함꼐 쓸 때는 신중하라     | [now-start]() |
| item33. 타입 안전 이종 컨테이너를 고려하라         | [now-start]() |

## Chapter6

| item                                     | presentation  |
|------------------------------------------|---------------|
| item34. int 상수 대신 열거 타입을 사용하라            | [now-start]() |
| item35. ordinal 메서드 대신 인스턴스 필드를 사용하라     | [now-start]() |
| item36. 비트 필드 대신 EnumSet을 사용하라           | [now-start]() |
| item37. ordinal 인덱싱 대신 EnumMap을 사용하라     | [now-start]() |
| item38. 확장할 수 있는 열거 타입이 필요하면 인터페이스를 사용하라 | [now-start]() |
| item39. 명명 패턴보다 애너테이션을 사용하라              | [now-start]() |
| item40. @Override 애너테이션을 일관되게 사용하라       | [now-start]() |
| item41. 정의하려는 것이 타입이라면 마커 인터페이스를 사용하라    | [now-start]() |

## Chapter7

| item                           | presentation  |
|--------------------------------|---------------|
| item42. 익명 클래스보다는 람다를 사용하라     | [now-start]() |
| item43. 람다보다는 메서드 참조를 사용하라     | [now-start]() |
| item44. 표준 함수형 인터페이스를 사용하라     | [now-start]() |
| item45. 스트림은 주의해서 사용하라         | [now-start]() |
| item46. 스트림에서는 부작용 없는 함수를 사용하라 | [now-start]() |
| item47. 반환 타입으로는 스트림보다 컬렉션이 낫다 | [now-start]() |
| item48. 스트림 병렬화는 주의해서 적용하라     | [now-start]() |

## Chapter8

| item                                 | presentation  |
|--------------------------------------|---------------|
| item49. 매개변수가 유효한지 검사하라              | [now-start]() |
| item50. 적시에 방어적 복사본을 만들라             | [now-start]() |
| item51. 메서드 시그니처를 신중히 설계하라           | [now-start]() |
| item52. 다중정의는 신중히 사용하라               | [now-start]() |
| item53. 가변인수는 신중히 사용하라               | [now-start]() |
| item54. null이 아닌 빈 컬렉션이나 배열을 반환하라    | [now-start]() |
| item55. 옵셔널 반환은 신중히 하라               | [now-start]() |
| item56. 공개된 API 요소에는 항상 문서화 주석을 작성하라 | [now-start]() |

## Chapter9

| item                                    | presentation  |
|-----------------------------------------|---------------|
| item57. 지역변수의 범위를 최소화하라                 | [now-start]() |
| item58. 전통적인 for 문보다는 for-each 문을 사용하라  | [now-start]() |
| item59. 라이브러리를 익히고 사용하라                 | [now-start]() |
| item60. 정확한 답이 필요하다면 float와 double은 피하라 | [now-start]() |
| item61. 박싱된 기본 타입보다는 기본 타입을 사용하라        | [now-start]() |
| item62. 다른 타입이 적절하다면 문자열 사용을 피하라        | [now-start]() |
| item63. 문자열 연결은 느리니 주의하라                | [now-start]() |
| item64. 객체는 인터페이스를 사용해 참조하라             | [now-start]() |
| item65. 리플렉션보다는 인터페이스를 사용하라             | [now-start]() |
| item66. 네이티브 메서드는 신중히 사용하라              | [now-start]() |
| item67. 최적화는 신중히 하라                     | [now-start]() |
| item68. 일반적으로 통용되는 명명 규칙을 따르라           | [now-start]() |

## Chapter10

| item                                                 | presentation  |
|------------------------------------------------------|---------------|
| item69. 예외는 진짜 예외 상황에만 사용하라                          | [now-start]() |
| item70. 복구할 수 있는 상황에는 검사 예외를 프로그래밍 오류에는 런타임 예외를 사용하라 | [now-start]() |
| item71. 필요 없는 검사 에외 사용은 피하라                          | [now-start]() |
| item72. 표준 예외를 사용하라                                  | [now-start]() |
| item73. 추상화 수준에 맞는 예외를 던지라                           | [now-start]() |
| item74. 메서드가 던지는 모든 예외를 문서화하라                        | [now-start]() |
| item75. 예외의 상세 메시지에 실패 관련 정보를 담으라                    | [now-start]() |
| item76. 가능한 한 실패 원자적으로 만들라                           | [now-start]() |
| item77. 예외를 무시하지 말라                                  | [now-start]() |

## Chapter11

| item                                   | presentation  |
|----------------------------------------|---------------|
| item78. 공유 중인 가변 데이터는 동기화해 사용하라        | [now-start]() |
| item79. 과도한 동기화는 피하라                   | [now-start]() |
| item80. 스레드보다는 실행자 태스크 스트림을 애용하라       | [now-start]() |
| item81. wait와 notify보다는 동시성 유틸리티를 애용하라 | [now-start]() |
| item82. 스레드 안정성 수준을 문서화하라              | [now-start]() |
| item83. 지연 초기화는 신중히 사용하라               | [now-start]() |
| item84. 프로그램의 동작을 스레드 스케줄러에 기대지 말라     | [now-start]() |

## Chapter12

| item                                               | presentation  |
|----------------------------------------------------|---------------|
| item85. 자바 직렬화의 대안을 찾으라                            | [now-start]() |
| item86. Serializable을 구현할지는 신중히 결정하라               | [now-start]() |
| item87. 커스텀 직렬화 형태를 고려해보라                          | [now-start]() |
| item88. readObject 메서드는 방어적으로 작성하라                 | [now-start]() |
| item89. 인스턴스 수를 통제해야 한다면 redResolve보다는 열거 타입을 사용하라 | [now-start]() |
| item90. 직렬화된 인스턴스 대신 직렬화 프록시 사용을 검토하라              | [now-start]() |


