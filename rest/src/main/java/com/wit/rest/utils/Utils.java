package com.wit.rest.utils;

import org.slf4j.MDC;

import java.util.UUID;

import static com.wit.rest.utils.Constants.HEADER;

public class Utils {
    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }

    public static String getUuid() {
        return MDC.get(HEADER);
    }
}
