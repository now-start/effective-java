
# effective-java

[![build](https://github.com/now-start/effective-java/actions/workflows/pages/pages-build-deployment/badge.svg)](https://now-start.github.io/effective-java/)
![readme](https://github.com/now-start/effective-java/actions/workflows/readme.yml/badge.svg)

* List
    * [Chater02](#chater02)

## Convention

* GitHub Workflow 사용
* 각자 필요한 Branch 생성
* 각 Chapter 별 패키지에 itemNumber-itemTitle-gitHubUserName 으로 저장
  * **자동으로 README.md 를 생성하기 때문에 각 변수에 '-' 대신 '_' 표기로 변환**
* 필요시 각 Chapter 패키지에 src 및 resource 패키지 생성 가능
* 작성 완료 후 reviewer 전체 지정 후 main 으로 PR
* 질문 및 필요사항 review 후 merge


## Project Tree

```
effective-java
├─chater1
│  ├─item1-itemTitle-gitHubUserName.md
│  ├─item1-itemTitle-gitHubUserName.md
│  ├─item2-itemTitle-gitHubUserName.md
│  └─...
├─chater2
│  └─...
├─...
└─util
```


## Ground Rule


## Reference

* [책 정보 링크](https://www.yes24.com/Product/Goods/65551284)
* 관련 강의
    - [이펙티브 자바 완벽 공략 1부](https://www.inflearn.com/course/%EC%9D%B4%ED%8E%99%ED%8B%B0%EB%B8%8C-%EC%9E%90%EB%B0%94-1)
    - [이펙티브 자바 완벽 공략 2부](https://www.inflearn.com/course/%EC%9D%B4%ED%8E%99%ED%8B%B0%EB%B8%8C-%EC%9E%90%EB%B0%94-2)
* [이펙티브자바 공식 Github](https://github.com/WegraLee/effective-java-3e-source-code)
* [이펙티브자바 3판 번역 용어 설명](https://docs.google.com/document/d/1Nw-_FJKre9x7Uy6DZ0NuAFyYUCjBPCpINxqrP0JFuXk/edit)


## Chater02

| item | presentation |
|------|--------------|
| item1. 생성자 대신 정적 팩터리 메서드를 고려하라 | [nowstart](https://github.com/now-start/effective-java/blob/main/chater02/item1-생성자%20대신%20정적%20팩터리%20메서드를%20고려하라-nowstart.md) |
| item2. 생성자에 매개변수가 많다면 필더를 고려하라 | [nowstart](https://github.com/now-start/effective-java/blob/main/chater02/item2-생성자에%20매개변수가%20많다면%20필더를%20고려하라-nowstart.md) |
| item3. private 생성자나 열거 타입으로 싱글턴임을 보증하라 | [nowstart](https://github.com/now-start/effective-java/blob/main/chater02/item3-private%20생성자나%20열거%20타입으로%20싱글턴임을%20보증하라-nowstart.md) |
| item4. 인스턴스화를 막으려거든 private 생성자를 사용하라 | [nowstart](https://github.com/now-start/effective-java/blob/main/chater02/item4-인스턴스화를%20막으려거든%20private%20생성자를%20사용하라-nowstart.md) |
| item5. 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라 | [nowstart](https://github.com/now-start/effective-java/blob/main/chater02/item5-자원을%20직접%20명시하지%20말고%20의존%20객체%20주입을%20사용하라-nowstart.md) |
| item6. 불필요한 객체 생성을 피하라 | [nowstart](https://github.com/now-start/effective-java/blob/main/chater02/item6-불필요한%20객체%20생성을%20피하라-nowstart.md) |
