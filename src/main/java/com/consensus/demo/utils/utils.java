package com.consensus.demo.utils;

import java.time.LocalDateTime;



public class utils {
    
    public static boolean validateExpiry(LocalDateTime expiryTime) {
        LocalDateTime now = LocalDateTime.now();
        return expiryTime.isAfter(now);
    }
}
