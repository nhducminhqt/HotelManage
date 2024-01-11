/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Menu extends ArrayList<String> {

    public Menu() {
    }
    Scanner sc = new Scanner(System.in);
    int choise;

    public int getUserChoise() {
        for (int i = 1; i <= this.size(); i++) {
            System.out.println(i + " - " + this.get(i - 1));
            System.out.println("---------------------");
        }
        do {
            System.out.println("chose one options from 1 to " + this.size());
            choise = sc.nextInt();
        } while ((choise < 1) || (choise > this.size()));

        return choise;
    }

}
