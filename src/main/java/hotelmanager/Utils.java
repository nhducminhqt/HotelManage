/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanager;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Utils {

    public static String getString(String welcome,String msg) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println(msg);
            } else {
                check = false;
            }
        } while (check);
        return result;
    }
    
    public static String getStringreg(String welcome,String pattern,String msg,String msgreg) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println(msg);
            }
            else if(!result.matches(pattern)){
                System.out.println(msgreg);
            }
            else {
                check = false;
            }
        } while (check);
        return result;
    }

    public static int getInt(String welcome, int min) {
        boolean check = true;
        int number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
               
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                if(number< min){
                    System.out.println("Number must be large than " + min);
                }
                else{
                    check = false;
                }
                
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number < min);
        return number;
    }
    
     public static float getFloat(String welcome, int min) {
        boolean check = true;
        float number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                
                System.out.print(welcome);
                number = Float.parseFloat(sc.nextLine());
                 if(number< min){
                    System.out.println("Number must be large than " + min);
                }
                 else{
                      check = false;
                 }
               
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number < min);
        return number;
    }
     public static boolean getChoiseYN(String welcome){
        boolean check = true;
        int number =0;
        Scanner sc = new Scanner(System.in);
         do {             
             try {
                 System.out.println(welcome );
                 number = Integer.parseInt(sc.nextLine());
                 if (number !=0 && number != 1) {
                     System.out.println("Input 1 or 0 ");}
                 else {check = false;}
             } catch (Exception e) {
                 System.out.println("Input 1 or 0 ");
             }
         } while (check || (number!=0 && number!=1));
         if (number == 0) check = false ;
         else
         if (number == 1) check = true;
         return check;
        
    }   
  
}

