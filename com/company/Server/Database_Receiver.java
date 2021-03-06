package com.company.Server;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class Database_Receiver {
    public static ArrayList<String> registerUser(User user, Database database) throws SQLException {
        return database.registerUser(user);
    }

    public static ArrayList<String> AuthorizationUser(User user, Database database) throws SQLException {
        return database.AuthorizationUser(user);
    }

    public static ArrayList<String> Disconnect() {
        return new ArrayList<>(Collections.singleton("Disconnect. Bye=) "));
    }
}
