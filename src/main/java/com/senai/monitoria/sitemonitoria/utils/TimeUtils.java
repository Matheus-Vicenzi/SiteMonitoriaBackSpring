package com.senai.monitoria.sitemonitoria.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeUtils {
    
    public static String getTimestamp() {
        return LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).toString().replace("T", " ");
    }    
}
