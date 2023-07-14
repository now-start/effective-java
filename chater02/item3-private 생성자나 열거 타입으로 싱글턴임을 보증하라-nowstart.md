# private 생성자나 열거 타입으로 싱글턴임을 보증하라

## 싱글턴

싱글턴이란 인스턴스를 오직 하나만 생성할 수 있는 클래스를 말한다

## 싱글턴 생성 방식

## public static final 필드 방식의 싱글턴

```java
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() { ...}

    public void leaveTheBuilding() {...}
}
```
* 
### 정적 팩터리 방식의 싱글턴
```java
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {...}

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {...}
}
```

### 열거 타입 압식의 싱클턴


## 결론

생성자나 정적 팩터리가 처리해야 할 매개변수가 많다면 빌더 패턴을 선택하는게 더 낫다
특히 빌더 패턴을 사용할 경우 **객체의 기본값**을 설정 할 수 있다


