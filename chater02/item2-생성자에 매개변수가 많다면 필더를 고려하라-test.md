# 생성자에 매개변수가 많다면 필더를 고려하라

## 인스턴스 생성 방법

### 생성자 패턴

```java
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public NutritionFacts(int calories, int fat, int sodiumint, int carbohydrate) {
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    public NutritionFacts(int calories, int fat) {
        this(calories, fat, 0, 0)
    }
}
```

* 매개변수가 많아지면 코드를 작성하거나 읽기 어렵다
* 특히 매개 변수의 위치를 직관적으로 알수가 없다
* 매개변수 순서를 잘못 작성하면 알아채기 힘듦

### 자바빈즈 패턴

```java
public class NutritionFacts {
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    public void setCalories(int calories) {
        this.calories = calories
    }

    public void setFat(int fat) {
        this.fat = fat
    }

    public void setSodium(int sodium) {
        this.sodium = sodium
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate
    }
}
```

* 앞서 생성자 패턴보다는 매개변수 저장 시점을 직관적으로 알 수 있음
* 객체를 생성하기 위해서는 필요한 매개변수의 개수 만큼 setter를 호출해 줘야 함
* setter를 아무곳에서나 호출 할 수 있어 객체의 일관성이 무너짐

### 빌더 패턴

```java
public class NutritionFacts {
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    NutritionFacts(final int calories, final int fat, final int sodium, final int carbohydrate) {
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    // 정적 팩토리 메서드
    public static NutritionFactsBuilder builder() {
        return new NutritionFactsBuilder();
    }

    // builder 패턴
    public static class NutritionFactsBuilder {
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;

        NutritionFactsBuilder() {
        }

        public NutritionFactsBuilder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public NutritionFactsBuilder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public NutritionFactsBuilder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public NutritionFactsBuilder carbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this.calories, this.fat, this.sodium, this.carbohydrate);
        }
    }
}
```

```java
public class Test {
    NutritionFacts nutritionFacts = NutritionFacts.builer()
        .calories(0)
        .fat(0)
        .sodium(0)
        .carbohydrate(0)
        .build();
}
```

* 빌더로 객체를 생성하므로 생성된 객체는 일관성을 유지할 수 있다
* 메서드 연쇄를 사용하기 때문에 매개변수의 순서가 바뀌어도
* 빌더 생성 비용이 추가 될 수 있다
* lombok을 사용하면 빌더 클래스를 사용하는 비용조차 줄일 수 있다

```java
// lombok 적용
@Builder
public class NutritionFacts {
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
}
```

## 결론

생성자나 정적 팩터리가 처리해야 할 매개변수가 많다면 빌더 패턴을 선택하는게 더 낫다
특히 빌더 패턴을 사용할 경우 **객체의 기본값**을 설정 할 수 있다


