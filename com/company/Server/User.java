package com.company.Server;

import java.io.Serializable;
import java.net.SocketAddress;
import java.util.Random;

public class User implements Serializable {
    private String login;
    private String password;
    private String salt;
    private SocketAddress address;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        salt = makeSalt();
    }

    private static String makeSalt() {
        int length = 16;
        Random r = new Random();
        return r.ints(48, 122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public void setAddress(SocketAddress address) {
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }
}
