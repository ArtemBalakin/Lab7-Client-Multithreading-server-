package com.company.Exeptions;

;

public class UncorrectedScriptException extends Exception {
    public UncorrectedScriptException(String message) {
        super(message);
    }

    public UncorrectedScriptException() {
        super();
    }
}
