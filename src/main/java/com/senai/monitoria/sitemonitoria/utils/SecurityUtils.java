package com.senai.monitoria.sitemonitoria.utils;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class SecurityUtils {
    public static String encrypt(String text){
        return BCrypt.hashpw(text, BCrypt.gensalt());
    }
    public static boolean checkPassword(String text, String hash){
        return BCrypt.checkpw(text, hash);
    }
}
