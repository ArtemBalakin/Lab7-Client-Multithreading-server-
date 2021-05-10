package com.company.utils;

import com.company.Commands.Command;
import com.company.Exeptions.CommandExecutionException;
import com.company.Exeptions.UncorrectedScriptException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class Invoker {
    /**
     * Инвокер. Начинает выполнение любой комманды
     */

    private Command command;

    public Invoker() {
    }

    public ArrayList<String> executeCommand() throws UncorrectedScriptException, CommandExecutionException,
            IOException, SQLException {
        return command.execute();
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command com) {
        this.command = com;
        this.command.add(this.command);
    }
}

