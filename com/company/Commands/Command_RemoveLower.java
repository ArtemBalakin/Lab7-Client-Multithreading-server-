package com.company.Commands;


import com.company.Server.Receiver;
import com.company.entities.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Данная команда удаляет все объекты коллекции,которые меньше заданного
 */
public class Command_RemoveLower extends Command_RemoveObjects {
    public final static boolean status = true;
    int index;

    public Command_RemoveLower(Ticket ticket) {
        super(ticket);
        this.index = -1;
    }

    public Command_RemoveLower() {

    }

    @Override
    public String getLogin() {
        return super.getLogin();
    }

    @Override
    public void setLogin(String login) {
        super.setLogin(login);
    }

    @Override
    public ArrayList<String> execute() throws SQLException {
        return Receiver.remove(getSet(), this.ticket, this.index, login);
    }

    @Override
    public String toString() {
        return "Command RemoveGreater <Element>: " + this.ticket;
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public String showAbility() {
        return "Command RemoveGreater <Element>- удаляет все эллменты, которые меньше заданного";
    }
}
