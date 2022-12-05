package com.footballmanager.exception;

public class FinancialTransactionException extends RuntimeException {
    public FinancialTransactionException(String message) {
        super(message);
    }
}
