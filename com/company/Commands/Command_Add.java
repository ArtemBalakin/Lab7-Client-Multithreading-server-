package com.company.Commands;

import com.company.Server.Receiver;
import com.company.entities.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Данная команда добавляет объект в коллекцию
 */

public class Command_Add extends A_command implements Command {
    public final static boolean status = true;
    Ticket ticket;
    String login;

    public Command_Add(Ticket ticket) {
        this.ticket = ticket;
    }

    public Command_Add() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public ArrayList<String> execute() throws SQLException {
        return Receiver.add(this.ticket, login);
    }

    @Override
    public String toString() {
        return "Command Add <Ticket>: " + this.ticket;
    }

    @Override
    public String showAbility() {
        return "Command Add <Ticket>-добавляет эллемент в коллекцию";
    }
}
