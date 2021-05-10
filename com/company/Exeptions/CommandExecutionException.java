package com.company.Exeptions;

;

public class CommandExecutionException extends Exception {
    public CommandExecutionException(String message) {
        super(message);
    }

    public CommandExecutionException() {
        super();
    }
}
