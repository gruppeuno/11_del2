package Test;

import java.util.Scanner;

public class TestAfMove {

    public static void main(String[] args) {
        String valg ="";
        String ryk = "ryk";
        String traek = "træk";

        System.out.println("Vælg mellem at rykke 1 felt frem, eller trække et chance kort mere!");

        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Skriv \"Ryk\" for ar rykke frem eller \"Træk\" for at trække et nyt chancekort ");
            valg = scan.nextLine(); }
        while (!((traek.equals(valg.toLowerCase())) || (ryk.equals(valg.toLowerCase()))));

        if (valg.toLowerCase().equals(ryk)) {
            System.out.println("noget");
        }
        else if (valg.toLowerCase().equals(traek)) {
            System.out.println("noget men på fransk");
        }

        scan.close();
    }







}
