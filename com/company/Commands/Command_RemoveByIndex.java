package com.company.Commands;

import com.company.Exeptions.CommandExecutionException;
import com.company.Server.Receiver;

import java.util.ArrayList;

/**
 * Данная команда удаляет  объекты из коллекции по индексу
 */
public class Command_RemoveByIndex extends Command_DeleteByProperty {
    public final static boolean status = true;
    int index;

    public Command_RemoveByIndex(int index) {
        this.index = index;
    }

    public Command_RemoveByIndex() {

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
    public ArrayList<String> execute() throws CommandExecutionException {
        return Receiver.remove(getSet(), this.index, this.getLogin());
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Command RemoveByIndex <Index>:" + this.index;
    }

    @Override
    public String showAbility() {
        return "Command RemoveByIndex <Index>- удаляет эллемент с таким индексом";
    }
}
