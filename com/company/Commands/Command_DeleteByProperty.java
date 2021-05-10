package com.company.Commands;

import com.company.Exeptions.CommandExecutionException;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Command_DeleteByProperty extends A_command implements Command {
    private String login;

    public Command_DeleteByProperty() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public ArrayList<String> execute() throws CommandExecutionException, SQLException {

        return null;
    }

    @Override
    public String toString() {
        return "Command Remove";
    }
}
