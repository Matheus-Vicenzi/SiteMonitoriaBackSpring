package com.senai.monitoria.sitemonitoria.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtils {
    
    public static String getTimestamp() {
        return LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).toString();
    }

    public static GregorianCalendar timestampToGregorianCalendar(String timestamp)  {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try{
            Date date = formatDate.parse(timestamp);
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            return calendar;
        }catch (ParseException e){
            e.printStackTrace();
            throw new RuntimeException("Erro ao converter data");
        }

    }
}
