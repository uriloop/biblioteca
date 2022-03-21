package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Gestiona el menu de la app
 */
public class Menu {
    private int option;

    public Menu() {
        super();
    }

    /**
     * @return
     */
    public int mainMenu() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {

            System.out.println(" \nMENU PRINCIPAL \n");

            System.out.println("1. Carrega dades desde els csv. ");
            System.out.println("2. Mostra les dades carregades");
            System.out.println("3. Borrar un pimiento (id)");
            System.out.println("4. Mostra les dades d'un pebrot (id)");
            System.out.println("5. Delete all info");
            System.out.println("6. Cambia el nombre a un pimiento");
            System.out.println("7. Buscar por nombre");



            System.out.println("0. Sortir. ");

            System.out.println("Esculli opció: ");
            try {
                option = Integer.parseInt(br.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("valor no vàlid");
                e.printStackTrace();
                option=100;
            }
        } while (option != 1  && option != 0 && option != 2&& option != 3&& option != 4 && option != 5&& option != 6&& option != 7);

        return option;
    }





}