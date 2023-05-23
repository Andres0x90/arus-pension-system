package com.co.arus.commands;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class Response {
    private final String message;
}
