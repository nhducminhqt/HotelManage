/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package hotelmanager;

/**
 *
 * @author LENOVO
 */
public class HotelManager {

    public static void main(String[] args) {
        HotelArrayList hal = new HotelArrayList();
        hal.loadFromFile("Hotel.dat");
        Menu menu = new Menu();
        menu.add("1.Add new hotel");
        menu.add("2.Check to exist hotel");
        menu.add("3.Update hotel information");
        menu.add("4.Delete hotel");
        menu.add("5.Search hotel");
        menu.add("6.Displaying a hotel list (descending by Hotel_Name)");
        menu.add("7.Save to file");
        menu.add("8.Exit the process");
        int choise = menu.getUserChoise();
        try {
            do {
                switch (choise) {
                    case 1:
                        hal.addNewHotel();
                        choise = menu.getUserChoise();
                        break;
                    case 2:
                        hal.checkExistHotel();
                        choise = menu.getUserChoise();
                        break;
                    case 3:
                        hal.updateHotelInfo();
                        choise = menu.getUserChoise();
                        break;
                    case 4:
                        hal.deleteHotel();
                        choise = menu.getUserChoise();
                        break;
                    case 5:
                        hal.searchHotel();
                        choise = menu.getUserChoise();
                        break;
                    case 6:
                        hal.displayHotelList();
                        choise = menu.getUserChoise();
                        break;
                    case 7:
                        hal.savetoFile("Hotel.dat");
                        choise = menu.getUserChoise();
                        break;
                }
            } while (choise != 8);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
