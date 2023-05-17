// 1.1.  Дан список сотрудников:
// Иван Иванов
//
//Светлана Петрова
//
//Кристина Белова
//
//Анна Мусина
//
//Анна Крутова
//
//Иван Юрин
//
//Петр Лыков
//
//Павел Чернов
//
//Петр Чернышов
//
//Мария Федорова
//
//Марина Светлова
//
//Мария Савина
//
//Мария Рыкова
//
//Марина Лугова
//
//Анна Владимирова
//
//Иван Мечников
//
//Петр Петин
//
//Иван Ежов
//
//Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.

package Sem5;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Dz1_1 {

    public static void main(String[] args) {
        List<String> workers = List.of("""
                Иван Иванов

                Светлана Петрова

                Кристина Белова

                Анна Мусина

                Анна Крутова

                Иван Юрин

                Петр Лыков

                Павел Чернов

                Петр Чернышов

                Мария Федорова

                Марина Светлова

                Мария Савина

                Мария Рыкова

                Марина Лугова

                Анна Владимирова

                Иван Мечников

                Петр Петин

                Иван Ежов""");
        System.out.println(repeat(workers));
    }

    public static Map<String, Integer> repeat(List<String> workers) {
        Map<String, Integer> repeatNameCount = new LinkedHashMap<>();

        for (String worker : workers) {
            if (repeatNameCount.containsKey(worker)) {
                repeatNameCount.put(worker, repeatNameCount.get(worker) + 1);
            } else {
                repeatNameCount.put(worker, 1);
            }
        }

        return repeatNameCount.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new));
    }
}
