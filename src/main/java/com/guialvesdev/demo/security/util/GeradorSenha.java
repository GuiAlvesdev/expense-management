package com.guialvesdev.demo.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


//gera senha dos usuarios usando encoder
public class GeradorSenha {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("admin"));
    }
}
