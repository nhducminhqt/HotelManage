/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class HotelArrayList extends ArrayList<Hotel> {

    public HotelArrayList() {
    }
    public void loadFromFile(String filename){
        try {
            File f = new File(filename);
            if(!f.exists()){return;}
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            Hotel ht;
            while ((ht =(Hotel)fo.readObject())!= null){this.add(ht);}
            fo.close();fi.close();
        } catch (Exception e) {
            System.out.println(e);
        }       
}
    public void addNewHotel(){  
        boolean check = true; 
        do {            
        String hotelID = Utils.getString("Input ID: ", "ID can not be empty");
        String hotelName = Utils.getString("Input the name of Hotel: ","The Hotel Name can not be empty");
        int hotelRoomAvailable = Utils.getInt("Input the room Available: ", 0);
        String hotelAddress = Utils.getString("Input the hotel Address: ", "The address can not be empty");
        String hotelPhone = Utils.getStringreg("Input the hotel Phone: ", "^[0-9]+$", "Phone number can not be empty", "Invalid phone number");
        String hotelRating = Utils.getString("Input the rating: ", "The rating can not be empty");
        Hotel hotel = new Hotel(hotelID,hotelName,hotelRoomAvailable,hotelAddress,hotelPhone,hotelRating);
        this.add(hotel);
          check = Utils.getChoiseYN("Do you want to add more hotel? ( 1 for yes / 0 for no )");     
        } while (check);
        
    }
   public void checkExistHotel(){
        boolean check = true;
       
        do {    
                    boolean ans = false;
                    String hotelID = Utils.getString("Input ID: ", "ID can not be empty");
                    for (Hotel hol : this) {
                        if (hol.getHotelID().equals(hotelID)) {ans = true; break;}
                        
                
            }
                    if (ans) System.out.println("Exist Hotel");
                    else System.out.println("No Hotel Found!");
                    check = Utils.getChoiseYN("Do you want to check more hotel? ( 1 for yes / 0 for no )");  
  
       } while (check);
        
    }; 
   public void updateHotelInfo(){
         Scanner sc = new Scanner(System.in);
         boolean ans = false;
         String hotelID = Utils.getString("Input ID: ", "ID can not be empty");
         for (Hotel hol : this) {
            if (hol.getHotelID().equals(hotelID)) 
                {   ans = true;
                    System.out.print("Input new ID: ");
                    String hotelid = sc.nextLine();
                    System.out.print("Input new name of Hotel: ");
                    String hotelName = sc.nextLine();
                    int hotelRoomAvailable = Utils.getInt("Input new room Available: ", 0);
                    System.out.print("Input new hotel Address: ");
                    String hotelAddress = sc.nextLine();
                    System.out.print("Input new hotel Phone: ");
                    String hotelPhone = sc.nextLine();
                    System.out.print("Input new rating: ");
                    String hotelRating = sc.nextLine();
                    if((hotelid.equals(""))  || (hotelName.equals("")) || (hotelAddress.equals("")) || (hotelPhone.equals("")) || (hotelRating.equals(""))){
                        System.out.println("Failure update");}
                    else{
                        hol.setHotelID(hotelid);
                        hol.setHotelName(hotelName);
                        hol.setHotelRoomAvailable(hotelRoomAvailable);
                        hol.setHotelAddress(hotelAddress);
                        hol.setHotelPhone(hotelPhone);
                        hol.setHotelRating(hotelRating);
                        System.out.println("Success update");}
                    break;
                }   
        if (ans) System.out.println("Successful update");
        else System.out.println("Hotel does not exist");
          
         }
   };
   public void deleteHotel(){
       boolean check = false;
       check = Utils.getChoiseYN("Do you ready want to delete this hotel? ( 1 for yes / 0 for no )");  
       if(!check)return;
       else{
       boolean ans = false;
       String hotelID = Utils.getString("Input ID: ", "ID can not be empty");
       for (Hotel hol : this) {
           if (hol.getHotelID().equals(hotelID)){
               ans = true;
               this.remove(hol);
               break;
           }   
       }  
    if (!ans){System.out.println("Failure delete");}
    else System.out.println("Success delete");
       } 
   }
   public void searchHotel(){
        boolean check = false;
        System.out.println("6.1: Search by Hotel_Id");
        System.out.println("6.2: Search by Hotel_name");
        check = Utils.getChoiseYN(" Choose our options:( 1 for ID / 0 for Name )");
        if(check){
            String hotelID = Utils.getString("Input ID: ", "ID can not be empty");
            boolean ans= false;
            for (Hotel hol : this) {
           if (hol.getHotelID().equals(hotelID)){  
               ans = true;
               break;         
           }
       }
            if (ans){
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|Hotel_id|Hotel_name|Hotel_Room_Available|Hotel_Address|Hotel_Phone|Hotel_Rating|");
                System.out.println("---------------------------------------------------------------------------------");
                for (Hotel hol : this) {
                     if (hol.getHotelID().equals(hotelID)){
                 System.out.printf("|%-8s|%-10s|%-20d|%-13s|%-11s|%-12s|\n",hol.getHotelID(),hol.getHotelName(),hol.getHotelRoomAvailable(),hol.getHotelAddress(),hol.getHotelPhone(),hol.getHotelRating());       
                }
            }
                System.out.println("----------------------------------------------------------------------------------");
        }        
                else {System.out.println("The ID is not exist!!");}
        }
        else{
           String hotelName = Utils.getString("Input Name: ", "Name can not be empty");
            boolean ans= false;
            for (Hotel hol : this) {
           if (hol.getHotelName().equals(hotelName)){  
               ans = true;
               break;         
           }
       }
            if (ans){
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("|Hotel_id|Hotel_name|Hotel_Room_Available|Hotel_Address|Hotel_Phone|Hotel_Rating|");
                System.out.println("---------------------------------------------------------------------------------");
                for (Hotel hol : this) {
                     if (hol.getHotelName().equals(hotelName)){
                 System.out.printf("|%-8s|%-10s|%-20d|%-13s|%-11s|%-12s|\n",hol.getHotelID(),hol.getHotelName(),hol.getHotelRoomAvailable(),hol.getHotelAddress(),hol.getHotelPhone(),hol.getHotelRating());       
                     
                }
            }   System.out.println("");
                System.out.println("----------------------------------------------------------------------------------");
        }        
                else {System.out.println("The Name is not exist!!");}}
   }
}

