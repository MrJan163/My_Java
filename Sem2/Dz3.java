// 4) ** (Для преподавателя: если не успели выполнить задание 7, дать наводку из этого задания) Дана json-строка (можно сохранить в файл и читать из файла)
//
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//
//Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//
//Пример вывода:
//
//Студент Иванов получил 5 по предмету Математика.
//
//Студент Петрова получил 4 по предмету Информатика.
//
//Студент Краснов получил 5 по предмету Физика.

package Sem2;

import java.io.*;

public class Dz3 {
    public static String journal(String fileName) {
        String strOffile = null;
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            strOffile = reader.readLine();

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strOffile;
    }

    private static String[][] jsonPars(String jsonStr) {
        String line = jsonStr.substring(1, jsonStr.length() - 1);

        String[] jsonArray = line.split(", ");

        String[][] jsonArrayBase = new String[jsonArray.length][3];
        for (int i = 0; i < jsonArray.length; i++) {
            line = jsonArray[i].substring(1, jsonArray[i].length() - 1);
            for (int j = 0; j < 3; j++) {
                String[] minJsonArray = line.split(",");
                String[] microJsonArray = minJsonArray[j].split(":");
                jsonArrayBase[i][j] = microJsonArray[1].substring(1, microJsonArray[1].length() - 1);

            }
        }
        return jsonArrayBase;
    }

    private static String[] gluing_strings(String[][] arrayStr) {
        String[] gluing_str = new String[arrayStr.length];
        StringBuilder NewStr = new StringBuilder();
        for (int i = 0; i < arrayStr.length; i++) {
            NewStr.append("Студент ");
            NewStr.append(arrayStr[i][0]);
            NewStr.append(" получил  ");
            NewStr.append(arrayStr[i][1]);
            NewStr.append(" по предмету ");
            NewStr.append(arrayStr[i][2]);
            gluing_str[i] = NewStr.toString();
            NewStr.delete(0, NewStr.length());
        }
        return gluing_str;
    }

    public static void main(String[] args) {
        String strJson_ofFile = journal("text2.jsn");
        System.out.println(strJson_ofFile);
        String[] array = gluing_strings(jsonPars(strJson_ofFile));
        for (String s : array) System.out.println(s);
    }
}
