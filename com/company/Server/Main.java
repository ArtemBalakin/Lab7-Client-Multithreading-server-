package com.company.Server;

import com.company.Exeptions.CommandExecutionException;

import java.io.IOException;
import java.sql.SQLException;


class Main {
    public static void main(String[] args) throws IOException, InterruptedException, CommandExecutionException, SQLException {
        Database database = new Database("jdbc:postgresql://localhost:5432/Lab7", "postgres",
                "22446688", "org.postgresql.Driver");
        database.connectionToDatabase();
        database.readData();
        Server server = new Server(database);
        server.start();
    }
}

