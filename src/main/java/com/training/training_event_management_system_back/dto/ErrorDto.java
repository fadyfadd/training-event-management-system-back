package com.training.training_event_management_system_back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class ErrorDto implements Serializable {
    private String message;
    private Map<String, String> errors = new HashMap<>();
}
