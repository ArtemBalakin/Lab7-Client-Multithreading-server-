package com.company.Commands;

import com.company.Exeptions.CommandExecutionException;
import com.company.Server.Receiver;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Данная команда сохраняет коллекцию в файл
 */
public class Command_Save extends A_command implements Command {
    public final static boolean status = true;
    String path;

    public Command_Save(String path) {
        this.path = path;
    }

    public Command_Save() {

    }

    @Override
    public ArrayList<String> execute() throws IOException, CommandExecutionException {
        return Receiver.save(A_command.getSet(), this.path);
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "Command Save <Path>: " + this.path;
    }

    @Override
    public String showAbility() {
        return "Command Save <Path>- сохраняет коллекцию в файл";
    }

    @Override
    public boolean getStatus() {
        return status;
    }
}


