package com.company.utils;

import com.company.Server.User;
import com.company.entities.Coordinates;
import com.company.entities.Person;
import com.company.entities.Ticket;
import com.company.entities.TicketType;
import com.company.utils.Color;
import com.company.utils.Parser;

import java.util.Scanner;

public class EntityFabric {
    public static User MakeUser() {
        String login;
        String password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для выполнения команды необходимо указать логин и пароль.");
        System.out.print("Введите логин:");
        login = scanner.nextLine().trim();
        while (login.isEmpty()) {
            System.out.print("Вы ввели логин, не удовлетворяющий требованиям. Он должен быть больше 4 символов.");
            System.out.print("Введите логин:");
            login = scanner.nextLine().trim();
        }
        System.out.print("Введите пароль:");
        password = scanner.nextLine().trim();
        while (password.isEmpty()) {
            System.out.print("Вы ввели пароль, не удовлетворяющий требованиям. Он должен быть больше 4 символов.");
            System.out.print("Введите пароль:");
            password = scanner.nextLine().trim();
        }
        return new User(login, password);
    }

    public static Ticket MakeTicket() {
        String in;
        System.out.println("Для выполнения команды необходимо создать новый билет.");
        boolean check = false;
        Scanner scanner = new Scanner(System.in);
        String name = null; //Поле не может быть null, Строка не может быть пустой
        System.out.println("Введите название:");
        System.out.print("\tName:");
        name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.println(Color.ANSI_RED + "Неправильный ввод.Повторите!" + Color.ANSI_RESET);
            System.out.print("\tName:");
            name = scanner.nextLine().trim();
        }
        check = false;
        Coordinates coordinates; //Поле не может быть null
        coordinates = MakeCoordinates();
        Float price; //Поле может быть null, Значение поля должно быть больше 0
        System.out.println("Введите цену:");
        while (true) {
            System.out.print("\tPrice:");
            in = scanner.nextLine();
            if (Parser.tryParseFloat(in)) {
                price = Float.parseFloat(in);
                break;
            }
            System.out.println(Color.ANSI_RED + "Вы ввели неправильную цену, повторите ввод." + Color.ANSI_RESET);
        }
        TicketType type;

        System.out.println("Хотите задать тип?(Yes-если да)");
        if (scanner.nextLine().trim().toUpperCase().compareTo("YES") == 0) type = ReadType();
        else type = null;
        Person person;
        System.out.println("Хотите создать Person'a?(Yes-если да)");
        if (scanner.nextLine().trim().toUpperCase().compareTo("YES") == 0) person = MakePerson();
        else person = null;
        System.out.println(new Ticket(name, coordinates, price, type, person));
        return new Ticket(name, coordinates, price, type, person);
    }

    public static Coordinates MakeCoordinates() {
        String in;
        Scanner scanner = new Scanner(System.in);
        float x;
        System.out.println("Введите координаты:");
        while (true) {
            System.out.print("\tX:");
            in = scanner.nextLine();
            if (Parser.tryParseFloat(in)) x = Integer.parseInt(in);
            else {
                System.out.println(Color.ANSI_RED + "Вы ввели неправильный X, повторите ввод." + Color.ANSI_RESET);
                continue;
            }
            if (x > 176)
                System.out.println(Color.ANSI_RED + "Вы ввели неправильный Y, повторите ввод." + Color.ANSI_RESET);
            else break;
        }
        Integer y;
        while (true) {
            System.out.print("\tY:");
            in = scanner.nextLine();
            if (Parser.tryParseInt(in)) y = Integer.parseInt(in);
            else {
                System.out.println(Color.ANSI_RED + "Вы ввели неправильный Y, повторите ввод." + Color.ANSI_RESET);
                continue;
            }
            if (y > 178)
                System.out.println(Color.ANSI_RED + "Вы ввели неправильный Y, повторите ввод." + Color.ANSI_RESET);
            else break;
        }
        return new Coordinates(x, y);
    }

    public static TicketType ReadType() {
        System.out.println("Введите тип:");
        int index = 1;
        System.out.println("Доступные варианты:");
        for (TicketType c : TicketType.values()) {
            System.out.println("\t" + index + "." + c);
            index++;
        }
        boolean b = false;
        String type = null;
        Scanner scanner = new Scanner(System.in);
        while (!b) {
            System.out.print("Type:");
            type = scanner.nextLine();
            for (TicketType c : TicketType.values()) {
                if (c.name().equals(type.toUpperCase())) {
                    b = true;
                    break;
                }
            }
            if (!b)
                System.out.println(Color.ANSI_RED + "Вы ввели неправильный тип, повторите ввод." + Color.ANSI_RESET);
        }
        return TicketType.valueOf(type.toUpperCase());
    }

    public static Person MakePerson() {
        String in;
        System.out.println("Требуется создать человека:");
        Scanner scanner = new Scanner(System.in);
        String passportID;
        System.out.print("\tPassport ID:");
        passportID = scanner.nextLine();
        long weight;
        while (true) {
            System.out.print("\tWeight:");
            in = scanner.nextLine();
            if (Parser.tryParseLong(in)) weight = Long.parseLong(in);
            else {
                System.out.println(Color.ANSI_RED + "Вы ввели неправильный вес, повторите ввод." + Color.ANSI_RESET);
                continue;
            }
            if (weight <= 0)
                System.out.println(Color.ANSI_RED + "Вы ввели неправильный вес, повторите ввод." + Color.ANSI_RESET);
            else break;
        }
        return new Person(weight, passportID);
    }

}
