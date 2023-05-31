package com.senai.monitoria.sitemonitoria.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {
    
    public static ResponseEntity<?> ok(Object data, String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("success", true);
        map.put("data", data);
        map.put("timestamp", TimeUtils.getTimestamp());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public static ResponseEntity<?> ok(String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", message);
        map.put("timestamp", TimeUtils.getTimestamp());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public static ResponseEntity<?> error(String message, HttpStatus status) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        map.put("httpStatus", status.value());
        map.put("message", message);
        map.put("timestamp", TimeUtils.getTimestamp());
        return new ResponseEntity<>(map, status);
    }

}
