# try_finally보다는 try_with_resources를 사용하라

<!-- TOC -->
* [try_finally보다는 try_with_resources를 사용하라](#tryfinally보다는-trywithresources를-사용하라)
  * [try-finally](#try-finally)
  * [try_with_resources](#trywithresources)
  * [결론](#결론)
<!-- TOC -->

## try-finally
```java
static String firstLineOfFile(String path) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(path));
    try {
        return br.readLine();
    } finally {
        br.close();
    }
}
```

* 자원이 둘 이상이면 try-finally 방식은 중첩 try 문을 구성하게 되어서 코드가 지저분해진다

## try_with_resources

```java
static void copy(String src, String dst) throws IOException {
    try (InputStream in = new FileInputStream(src);
         OutputStream out = new FileOutputStream(dst)){
        byte[] buf = new byte[BUFFER_SIZE];
        int n;
        while ((n = in.read(buf)) ?= 0))
            out.write(buf, 0, n);
    }
}
```

* 특히 자원이 둘 이상일 경우 try 문을 중첩하지 않고도 다수의 예외를 처리할 수 있다
* readLine과 (코드에는 나타나지 않는) close 호출 양쪽에서 예외가 발생하면 close에서 발생한 예외는 숨겨지고 readLine에서 발생한 예외가 기록된다
* 숨겨진 예외들도 스택 추적 내역에 '숨겨졌다(suppressed)'는 꼬리표를 달고 출력된다
* getSuppressed 메서드를 이용하면 프로그램 코드에서 가져올 수도 있다

## 결론

꼭 회수해야 하는 자원을 다룰 때는 try-finally 말고, try-with-resources를 사용하자
코드는 더 짧고 분명해지고, 만들어지는 예외 정보도 훨씬 유용하다
try-finally로 작성하면 실용적이지 못할 만큼 코드가 지저분해지는 경우라도, try-with-resources로는 정확하고 쉽게 자원을 회수할 수 있다