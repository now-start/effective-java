package util;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

enum Constant {
    ITEM("""
                   
        | item | name | presentation |
        |------|------|--------------"""),
    LIST_TOC("<!-- LIST TOC -->"),
    LIST("<!-- LIST -->");


    private final String value;

    Constant(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}

enum Path {
    ROOT_PATH("./"),
    README_PATH("./README.md"),
    INIT_PATH("util/INIT.md");

    private final String value;

    Path(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}

public class CreateReadme {
    public static void main(String[] args) {
        List<String> chapters = Arrays.stream(Objects.requireNonNull(new File(Path.ROOT_PATH.toString()).list())).filter(s -> s.contains("chater")).sorted().toList();

        try (BufferedReader br = new BufferedReader(new FileReader(Path.INIT_PATH.toString()));
             BufferedWriter bw = new BufferedWriter(new FileWriter(Path.README_PATH.toString()))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (Constant.LIST_TOC.toString().equals(line)) {
                    list(chapters, bw);
                } else if (Constant.LIST.toString().equals(line)) {
                    itemList(chapters, bw);
                } else {
                    bw.write(line + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void itemList(List<String> chapters, BufferedWriter bw) throws IOException {
        for (String chapter : chapters) {
            bw.write( System.lineSeparator() + "## " + toUpperCase(chapter) + System.lineSeparator());
            bw.write(Constant.ITEM.toString());

            List<String> items = Arrays.stream(Objects.requireNonNull(new File(Path.ROOT_PATH + chapter).list())).filter(s -> s.contains("item")).sorted().toList();
            String flag = "";
            for (String item : items) {
                String[] split = item.split("-");
                String itemNumber = split[0];
                String itemName = split[1];
                String userName = split[2];

                if (!flag.equals(itemNumber)) {
                    bw.write("|" + System.lineSeparator());
                    bw.write("| " + itemNumber + " | " + itemName + " | [" + userName.split("\\.")[0] + "](https://github.com/now-start/effective-java/blob/main/" + chapter + "/" + item.replace(" ", "%20") + ") ");
                } else {
                    bw.write("/ [" + userName.split("\\.")[0] + "](https://github.com/now-start/effective-java/blob/main/" + chapter + "/" + item.replace(" ", "%20") + ") ");
                }
                flag = itemNumber;
            }
            bw.write("|" + System.lineSeparator());
        }
    }

    private static void list(List<String> chapters, BufferedWriter bw) throws IOException {
        if (!chapters.isEmpty()) {
            bw.write("* List" + System.lineSeparator());
            for (String chapter : chapters) {
                bw.write("    * [" + toUpperCase(chapter) + "](#" + chapter + ")" + System.lineSeparator());
            }
        }
    }

    private static String toUpperCase(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
