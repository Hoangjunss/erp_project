package com.project.erp.exceptions;

import lombok.*;

@Getter
@Setter
public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String message) {
        super(message);
    }
}
