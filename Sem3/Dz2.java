package Sem3;
// 2. Пусть дан произвольный список целых чисел, удалить из него чётные числа

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dz2 {

    public static List<Integer> getRandomList() {
        Random random = new Random();
        int size = 20;
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list.toString());
        return list;
    }

    public static void delEvenNum(List<Integer> list) {

        list.removeIf(number -> number % 2 == 0);
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        delEvenNum(getRandomList());
    }
}
