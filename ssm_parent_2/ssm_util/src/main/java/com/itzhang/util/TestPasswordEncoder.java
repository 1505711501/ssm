package com.itzhang.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPasswordEncoder {

    public static void main(String[] args) {

        //$2a$10$ACRfbTrt0.c2w561HN99MOyW5jmoPJAJ/PdBadwb9NO88b3XN8gUm
        //$2a$10$NsQH84KJGB26pfTpu3QWUu0.9ckAPA4vaanEb60UM0q92Nt/0VIyC
        //$2a$10$E3sabmTmEHR63aI6TWFXouNgIprkC.DHRQWXEWbHYeAAUXuxj76Ya
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("666666"));
        System.out.println(encoder.matches("666666","$2a$10$ACRfbTrt0.c2w561HN99MOyW5jmoPJAJ/PdBadwb9NO88b3XN8gUm"));
        System.out.println(encoder.matches("666666","$2a$10$NsQH84KJGB26pfTpu3QWUu0.9ckAPA4vaanEb60UM0q92Nt/0VIyC"));
        System.out.println(encoder.matches("666666","$2a$10$E3sabmTmEHR63aI6TWFXouNgIprkC.DHRQWXEWbHYeAAUXuxj76Ya"));
    }
}
