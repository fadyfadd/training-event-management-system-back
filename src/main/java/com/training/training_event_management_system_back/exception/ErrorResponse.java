package com.training.training_event_management_system_back.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private String message;
    private int status;

}
