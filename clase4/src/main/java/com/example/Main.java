package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       
        MaquinaCafe cafe1 = new MaquinaCafe();
        MaquinaCafe cafe2 = new MaquinaCafe("Capuchino", 75.0, 250, new BigDecimal("3500"), 7, LocalDate.of(2023, 5, 20));
        System.out.println(cafe1);
        System.out.println(cafe2);

        Biblioteca biblio1 = new Biblioteca();
        Biblioteca biblio2 = new Biblioteca("Biblioteca Central", 20000, true, new BigDecimal("5000000"), LocalDate.of(1995, 3, 15), List.of("Ficción", "Ciencia", "Infantil"));
        System.out.println(biblio1);
        System.out.println(biblio2);

        MaquinaMecatos snack1 = new MaquinaMecatos();
        MaquinaMecatos snack2 = new MaquinaMecatos("Papas BBQ", 30, new BigDecimal("2500"), true, LocalDate.of(2026, 10, 10), List.of("Papas", "Sal", "Aceite"));
        System.out.println(snack1);
        System.out.println(snack2);

        
    }
}
