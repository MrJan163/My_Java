package Sem6;
// Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
//
//Создать множество ноутбуков.
//
//Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
//
//“Введите цифру, соответствующую необходимому критерию:
//
//1 - ОЗУ
//
//2 - Объём ЖД
//
//3 - Операционная система
//
//4 - Цвет …
//
//Далее нужно запросить минимальные и максимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
//Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Dz6 {

    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("Samsung", "64", "2000", "Windows 11", "gold");
        Notebook notebook2 = new Notebook("Infix", "16", "1000", "Windows 10", "white");
        Notebook notebook3 = new Notebook("Asus", "32", "2000", "Windows 10", "black");
        Notebook notebook4 = new Notebook("Honor", "16", "1000", "Windows 10", "grey");
        Notebook notebook5 = new Notebook("Huawei", "8", "500", "Windows XP", "black");

        Set<Notebook> notebooks = new HashSet<>(List.of(notebook1, notebook2,
                notebook3, notebook4, notebook5));

        Map<String, String> sel = selectCriteria();
        sort(sel, notebooks);

    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
    }

    public static Map<String, String> selectCriteria() {
        Map<String, String> resultCriteria = new HashMap<>();
        while (true) {
            System.out.println("Вы хотите выбрать критерий? Если да введите 'y', если нет введите 'n'");
            String question = scanner();
            if (question.equals("n")) {
                break;
            } else {

                System.out.println(
                        "Введите цифру, соответствующую необходимому критерию: \n 1 - Название \n 2 - ОЗУ \n 3 - Объем ЖД \n 4 - Операционная система \n 5 - Цвет");
                String key = scanner();
                System.out.println("Введите значения для выбранного критерия: ");
                String value = scanner();

                resultCriteria.put(key, value);
            }
        }
        System.out.println(resultCriteria);
        return resultCriteria;

    }

    public static void sort(Map<String, String> criteria, Set<Notebook> notebooks) {

        Set<Notebook> temp = new HashSet<>(notebooks);
        for (Notebook notebook : notebooks) {

            for (Object pair : criteria.keySet()) {

                if (pair.equals("1") && !notebook.getName().equals(criteria.get(pair))) {
                    temp.remove(notebook);
                }
                for (Object pair1 : criteria.keySet()) {

                    if (pair1.equals("2") && !notebook.getRam().equals(criteria.get(pair1))) {
                        temp.remove(notebook);

                    }
                    for (Object pair2 : criteria.keySet()) {

                        if (pair2.equals("3") && !notebook.getHardDisk().equals(criteria.get(pair2))) {
                            temp.remove(notebook);

                        }
                        for (Object pair3 : criteria.keySet()) {

                            if (pair3.equals("4") && !notebook.getOperatingSystem().equals(criteria.get(pair3))) {
                                temp.remove(notebook);

                            }
                            for (Object pair4 : criteria.keySet()) {

                                if (pair4.equals("5") && !notebook.getColour().equals(criteria.get(pair4))) {
                                    temp.remove(notebook);

                                }
                            }
                        }
                    }
                }
            }

        }
        if (temp.isEmpty()) {
            System.out.println("По введенным критериям ничего не найдено!");
        } else {
            System.out.println("Вот что мы можем предложить: \n" + temp);
        }

    }


}