package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {
    private int option;

    public Menu() {
        super();
    }

    public int mainMenu() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {

            System.out.println(" \nMENU PRINCIPAL \n");

            System.out.println("1. Carrega dades desde els csv. ");
            System.out.println("2. Mostra les dades carregades");

            System.out.println("0. Sortir. ");

            System.out.println("Esculli opció: ");
            try {
                option = Integer.parseInt(br.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("valor no vàlid");
                e.printStackTrace();
            }
        } while (option != 1  && option != 0 && option != 2);

        return option;
    }





}