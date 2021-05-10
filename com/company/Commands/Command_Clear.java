package com.company.Commands;


import com.company.Server.Receiver;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Данная команда очищает коллекцию
 */
public class Command_Clear extends A_command implements Command {
    public final static boolean status = true;
    String login;

    public Command_Clear() {
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public ArrayList<String> execute() throws SQLException {
        return Receiver.clear(A_command.getSet(), this.login);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Command Clear";
    }

    @Override
    public String showAbility() {
        return "Command Clear- очищает коллекцию";
    }
}

