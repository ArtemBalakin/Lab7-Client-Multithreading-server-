package com.company.Commands;

import com.company.Server.Receiver;
import com.company.entities.TicketType;

import java.util.ArrayList;

/**
 * Данная команда выводит все объекты коллекции, тип которых меньше заданного
 */
public class Command_PrintLessThenType extends Command_Print {
    public final static boolean status = false;
    TicketType type;

    public Command_PrintLessThenType(TicketType type) {
        this.type = type;
    }

    public Command_PrintLessThenType() {

    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public ArrayList<String> execute() {
        return Receiver.print(A_command.getSet(), this.type);
    }

    @Override
    public String toString() {
        return "Command PrintLessThenType <Type>: " + this.type;
    }

    @Override
    public String showAbility() {
        return "Command PrintLessThenType <Type>- выводит элементы, значения Type которых меньше";
    }
}
