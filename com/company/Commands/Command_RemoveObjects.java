package com.company.Commands;

import com.company.Server.Receiver;
import com.company.entities.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Command_RemoveObjects extends Command_DeleteByProperty {
    public final static boolean status = true;
    Ticket ticket;
    String login;

    public Command_RemoveObjects(Ticket ticket) {
        this.ticket = ticket;
    }

    public Command_RemoveObjects() {
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public ArrayList<String> execute() throws SQLException {
        return Receiver.remove(getSet(), this.ticket, -1, login);
    }

    @Override
    public boolean getStatus() {
        return status;
    }
}
