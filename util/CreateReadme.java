package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

enum Constant {
    EFFECTIVE_JAVA("""
                
        # effective-java
                        
        [![build](https://github.com/now-start/effective-java/actions/workflows/pages/pages-build-deployment/badge.svg)](https://now-start.github.io/effective-java/)
        ![readme](https://github.com/now-start/effective-java/actions/workflows/readme.yml/badge.svg)
                
        """),
    CONVENTION("""
                
        ## Convention
                     
        * GitHub Workflow 사용
        * 각자 필요한 Branch 생성
        * 각 Chapter 별 패키지에 itemNumber-itemTitle-gitHubUserName 으로 저장
          * **자동으로 README.md 를 생성하기 때문에 각 변수에 '-' 대신 '_' 표기로 변환**
        * 필요시 각 Chapter 패키지에 src 및 resource 패키지 생성 가능
        * 작성 완료 후 reviewer 전체 지정 후 main 으로 PR
        * 질문 및 필요사항 review 후 merge
                    
        """),
    PROJECT_TREE("""
                
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
                
        """),
    GROUND_RULE("""
                
        ## Ground Rule
                    
        """),
    REFERENCE("""
                
        ## Reference

        * [책 정보 링크](https://www.yes24.com/Product/Goods/65551284)
        * 관련 강의
            - [이펙티브 자바 완벽 공략 1부](https://www.inflearn.com/course/%EC%9D%B4%ED%8E%99%ED%8B%B0%EB%B8%8C-%EC%9E%90%EB%B0%94-1)
            - [이펙티브 자바 완벽 공략 2부](https://www.inflearn.com/course/%EC%9D%B4%ED%8E%99%ED%8B%B0%EB%B8%8C-%EC%9E%90%EB%B0%94-2)
        * [이펙티브자바 공식 Github](https://github.com/WegraLee/effective-java-3e-source-code)
        * [이펙티브자바 3판 번역 용어 설명](https://docs.google.com/document/d/1Nw-_FJKre9x7Uy6DZ0NuAFyYUCjBPCpINxqrP0JFuXk/edit)
                    
        """),
    ITEM("""
                
        | item | name | presentation |
        |------|------|--------------""");


    private final String value;

    Constant(String path) {
        this.value = path;
    }

    @Override
    public String toString() {
        return this.value;
    }
}

enum Path {
    ROOT_PATH("./"), README_PATH("./README.md");

    private final String value;

    Path(String path) {
        this.value = path;
    }

    @Override
    public String toString() {
        return this.value;
    }
}

public class CreateReadme {
    public static void main(String[] args) throws IOException {
        List<String> chapters = Arrays.stream(Objects.requireNonNull(new File(Path.ROOT_PATH.toString()).list())).filter(s -> s.contains("chater")).sorted().toList();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(Path.README_PATH.toString(), StandardCharsets.UTF_8))){
            bw.write(Constant.EFFECTIVE_JAVA.toString());
            list(chapters, bw);
            bw.write(Constant.CONVENTION.toString());
            bw.write(Constant.PROJECT_TREE.toString());
            bw.write(Constant.GROUND_RULE.toString());
            bw.write(Constant.REFERENCE.toString());
            itemList(chapters, bw);

            bw.flush();
        }
    }

    private static void itemList(List<String> chapters, BufferedWriter bw) throws IOException {
        for (String chapter : chapters) {
            bw.write("\n## " + toUpperCase(chapter) + "\n");
            bw.write(Constant.ITEM.toString());

            List<String> items = Arrays.stream(Objects.requireNonNull(new File(Path.ROOT_PATH + chapter).list())).filter(s -> s.contains("item")).sorted().toList();
            String flag = "";
            for (String item : items) {
                String[] split = item.split("-");
                String itemNumber = split[0];
                String itemName = split[1];
                String userName = split[2];

                if (!flag.equals(itemNumber)) {
                    bw.write("|\n");
                    bw.write("| " + itemNumber + " | " + itemName + " | [" + userName.split("\\.")[0] + "](https://github.com/now-start/effective-java/blob/main/" + chapter + "/" + item.replace(" ", "%20") + ") ");
                } else {
                    bw.write("/ [" + userName.split("\\.")[0] + "](https://github.com/now-start/effective-java/blob/main/" + chapter + "/" + item.replace(" ", "%20") + ") ");
                }
                flag = itemNumber;
            }
            bw.write("|\n");
        }
    }

    private static void list(List<String> chapters, BufferedWriter bw) throws IOException {
        if (!chapters.isEmpty()) {
            bw.write("* List\n");
        }
        for (String chapter : chapters) {
            bw.write("    * [" + toUpperCase(chapter) + "](#" + chapter + ")\n");
        }
    }

    public static String toUpperCase(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
