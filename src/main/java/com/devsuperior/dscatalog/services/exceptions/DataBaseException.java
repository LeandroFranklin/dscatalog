package com.devsuperior.dscatalog.services.exceptions;

import java.io.Serial;

public class DataBaseException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public DataBaseException(String message) {
        super(message);
    }
}
