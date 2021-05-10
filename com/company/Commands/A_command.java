package com.company.Commands;

import com.company.entities.Ticket;
import com.company.utils.ClassAnalyzer;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public abstract class A_command implements Command {
    private static TreeSet<Ticket> set;



    public static TreeSet<Ticket> getSet() {
        return set;
    }

    public static void setSet(TreeSet<Ticket> set) {
        A_command.set = set;
    }



    @Override
    public abstract boolean getStatus();

}
