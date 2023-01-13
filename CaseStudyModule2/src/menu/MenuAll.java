package menu;

import customer.CustomerManagerMenu;
import glasses.GlassesManagerMenu;
import invoice.InvoiceManagerMenu;
//import invoice.OrderManagerMenu;

import java.util.Scanner;

public class MenuAll {
        public static void menu() {
            Scanner sc = new Scanner(System.in);
            System.out.println("+--->>>-----MENU-----<<<---+");
            System.out.println("|     1. Menu Customer !   |");
            System.out.println("|     2. Menu Glasses !    |");
            System.out.println("|     3. Menu Invoice !    |");
            System.out.println("+--->>>-----AND-----<<<----+");
            System.out.println("Mời bạn nhập lựa chọn: ");
            int choice = sc.nextInt();sc.nextLine();
            switch (choice) {
                case 1:
                   new CustomerManagerMenu().Menu();
                    break;
                case 2:
                    new GlassesManagerMenu().Menu();
                    break;
                case 3:
                    new InvoiceManagerMenu().Menu();
                    break;
                default:
                    return;
            }
        }
    }


