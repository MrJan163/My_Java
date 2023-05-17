// 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

package Sem5;

import java.util.*;

public class Dz1 {

    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        phoneBook.put("Jan", List.of("8 9093623133", "8 9171332299"));
        phoneBook.put("Ira", List.of("8 9093623134", "8 9171352648"));
        phoneBook.put("Ivan", List.of("8 9093623135", "8 9171987896"));
        phoneBook.put("Gosha", List.of("8 9093623136", "8 9171654879"));
        phoneBook.put("Sasha", List.of("8 9093623137", "8 9171658497"));

        menu(phoneBook);

    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        // scanner.close();
        return scanner.nextLine();
    }

    public static void find(Map<String, List<String>> phoneBook) {
        System.out.println("Введите имя: ");
        String name = scanner();
        System.out.println(phoneBook.get(name));
    }

    public static void allBook(Map<String, List<String>> phoneBook) {
        System.out.println(phoneBook);

    }

    public static void add(Map<String, List<String>> phoneBook) {
        System.out.println("Если хотите выйте хотите перестать вводить номера введите 'stop'");
        System.out.println("Введите имя: ");
        String name = scanner();
        List<String> number = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер: ");
            String phone = scanner();
            if (phone.equals("stop")) {
                break;
            } else {
                number.add(phone);
            }
        }
        phoneBook.put(name, number);

    }

    public static void menu(Map<String, List<String>> phonBook) {
        System.out.println(
                "Введите команду из списка: find - найти контакт, add - добавить контакт, all - показать всю телефонную книгу, exit - выйти");
        while (true) {
            String comands = scanner();
            if (comands.equals("exit")) {
                break;
            } else {
                switch (comands) {
                    case "find" -> find(phonBook);
                    case "add" -> add(phonBook);
                    case "all" -> allBook(phonBook);
                    default -> {
                    }
                }
            }
        }
    }
}
