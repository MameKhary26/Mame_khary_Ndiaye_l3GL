package dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {
    //public class PasswordHashing {
//    public static void main(String[] args) {
//        String password = "password123";
//        String salt = "1234567890ABCDEF";
//        System.out.println("Hashed Password: " + generatePasswordHash(password, salt));
//    }

        public String generatePasswordHash(String password, String salt) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(salt.getBytes(StandardCharsets.UTF_8));
                byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
                return new String(hashedPassword, StandardCharsets.UTF_8);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Failed to generate password hash", e);
            }
        }
    }

