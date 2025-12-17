package com.example.ComercialCardPTM.api.error;

import java.time.Instant;

public class ApiError {
    public Instant timestamp = Instant.now();
    public int status;
    public String error;
    public String message;
    public String path;
}
