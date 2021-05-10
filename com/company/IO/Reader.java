package com.company.IO;

import com.company.Commands.Command;
import com.company.utils.Color;
import com.company.utils.EntityFabric;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;


public class Reader {

    public static Command ReadCommandFromConsole() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println("Введите название комадны и её числовые аругументы(Если они требуются).\n\"Help\" для получения списка команд :");
        Command command = null;
        Scanner scanner = new Scanner(System.in);
        String input;
        Class mClassObject;
        String name;
        while (true) {
            try {
                input = scanner.nextLine() + " ";
                name = input.substring(0, input.indexOf(" "));
                mClassObject = Class.forName("com.company.Commands.Command_" + name);
                Command command1 = (Command) mClassObject.newInstance();
                System.out.println(command1);
            } catch (ClassNotFoundException | NoClassDefFoundError e) {
                System.out.println(Color.ANSI_RED + "Вы ввели несуществующую команду!" + Color.ANSI_RESET);
                continue;
            }
            try {
                input = input.trim();
                Constructor[] constructors = mClassObject.getConstructors();
                Class[] parameterTypes = constructors[0].getParameterTypes();
                if (parameterTypes.length == 0) {
                    command = (Command) constructors[0].newInstance();
                } else if (parameterTypes.length == 1) {
                    if (parameterTypes[0].toString().compareTo("int") == 0) {
                        System.out.println("I'm Here");
                        command = (Command) constructors[0].newInstance(Integer.parseInt(input.substring(input.lastIndexOf(" ") + 1)));
                    } else if (parameterTypes[0].toString().compareTo("class Ticket") == 0) {
                        command = (Command) constructors[0].newInstance(EntityFabric.MakeTicket());
                    } else if (parameterTypes[0].toString().compareTo("class TicketType") == 0) {
                        command = (Command) constructors[0].newInstance(EntityFabric.ReadType());
                    } else if (parameterTypes[0].toString().compareTo("class Person") == 0) {
                        command = (Command) constructors[0].newInstance(EntityFabric.MakePerson());
                    } else if (parameterTypes[0].toString().compareTo("class java.lang.String") == 0) {
                        try {
                            input.substring(input.indexOf(" "));
                        } catch (StringIndexOutOfBoundsException e) {
                            throw new IllegalArgumentException();
                        }
                        command = (Command) constructors[0].newInstance(input.substring(input.indexOf(" ") + 1));
                    } else if (parameterTypes[0].toString().compareTo("class com.company.Server.User") == 0) {
                        command = (Command) constructors[0].newInstance(EntityFabric.MakeUser());
                    }
                } else if (parameterTypes.length == 2) {
                    command = (Command) constructors[0].newInstance(Integer.parseInt(input.substring(input.indexOf(" ") + 1))
                            , EntityFabric.MakeTicket());
                }
            } catch (IllegalArgumentException e) {
                System.out.println(Color.ANSI_RED + "Вы ввели неправильные аргументы команды.Повториете ввод."
                        + Color.ANSI_RESET);
                continue;
            }
            break;
        }
        System.out.println(command);
        return command;
    }
}
