package com.company.Commands;


import com.company.Server.Database_Receiver;
import com.company.Server.Server;
import com.company.Server.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class Command_RegisterUser extends A_command implements Command {
    public final boolean status = false;
    User user;

    public Command_RegisterUser(User user) {
        this.user = user;
    }

    public Command_RegisterUser() {

    }

    @Override
    public String showAbility() {
        return "Command RegisterUser<User>- регистрирует нового пользователя в БД";
    }

    @Override
    public ArrayList<String> execute() {
        try {
            return Database_Receiver.registerUser(this.user, Server.getDatabase());
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<String>(Collections.singleton(e.getMessage()));
        }
    }

    @Override
    public boolean getStatus() {
        return status;
    }
}
