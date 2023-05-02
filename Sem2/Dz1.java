// 1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.

// Если значение null, то параметр не должен попадать в запрос.

// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}


package Sem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Dz1 {
    public static String reader() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("Txt1.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();

    }

    public static void split(String str1) {
        String str2 = str1.replace("{", "")
                .replace("}", "")
                .replace("\"", "");
        String[] newStr = str2.split(", ");

        Map<String, String> dictionary = new HashMap<String, String>();
        for (String item : newStr) {
            String[] strNew = item.split(":");
            System.out.println(Arrays.toString(strNew));
            for (int i = 0; i < newStr.length; i++) {
                dictionary.put(strNew[0], strNew[1]);

            }
        }
        System.out.println(dictionary.entrySet());
        StringBuilder WHERE = new StringBuilder();
        Set<Map.Entry<String, String>> pair = dictionary.entrySet();
        List<Map.Entry<String, String>> list = new ArrayList<>(pair);
        for (Map.Entry<String, String> stringStringEntry : list) {
            if (!stringStringEntry.getValue().equals("null")) {
                WHERE.append(stringStringEntry.getKey()).append(" = ").append(stringStringEntry.getValue()).append(" and ");

            }
        }
        System.out.println(WHERE);

    }

    public static void main(String[] args) {

        split(reader());

    }
}
