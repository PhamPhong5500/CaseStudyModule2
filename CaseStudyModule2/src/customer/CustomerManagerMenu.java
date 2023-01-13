package customer;

import menu.MenuAll;

import java.util.Scanner;
public class CustomerManagerMenu {
    CustomerManager customerManager = CustomerManager.getCustomerManager();

     Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("+-------->>>>>-------MENU-------<<<<<--------+");
        System.out.println("|  1. Thêm khách hàng !                      |");
        System.out.println("|  2. Xóa khách hàng !                       |");
        System.out.println("|  3. Tìm kiếm khách hàng dựa trên mã !      |");
        System.out.println("|  4. Tìm kiếm khách hàng dựa trên tên !     |");
        System.out.println("|  5. Tìm kiếm khách hàng dựa trên địa chỉ ! |");
        System.out.println("|  6. Sửa thông tin khách hàng !             |");
        System.out.println("|  7. Hiển thị danh sách khách hàng !        |");
        System.out.println("+------->>>>>>-------END-------<<<<<<--------+");
    }

    public void Menu() {
        while (true) {
            displayMenu();
            System.out.println("Mời bạn nhập chức năng !");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    searchById();
                    break;
                case 4:
                    searchByName();
                    break;
                case 5:
                    searchByAddress();
                    break;
                case 6:
                    update();
                    break;
                case 7:
                    showList();
                    break;
                default:
                    new MenuAll().menu();
            }
        }
    }
    public void add() {
        System.out.println("Nhập mã khách hàng: ");
            int id = scanner.nextInt(); scanner.nextLine();
            id = checkIdCustomer(id);
        System.out.println("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi khách hàng: ");
        int age = scanner.nextInt(); scanner.nextLine();
        System.out.println("Nhập địa chỉ khách hàng: ");
        String address = scanner.nextLine();
        customerManager.add(new Customer(id, name, age, address));
    }
    public int checkIdCustomer(int id){
        while(customerManager.searchById(id) != null){
            System.out.println("Mời bạn nhập lại mã : ");
            id = scanner.nextInt(); scanner.nextLine();
        }
        return id ;
    }
    public void remove(){
        System.out.println("Nhập mã khách hàng cần xóa : ");
        int id = scanner.nextInt();scanner.nextLine();
        customerManager.remove(id);
    }
    public void searchById() {
        System.out.println("Nhập mã khách hàng cần tìm: ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.println(customerManager.searchById(id));
    }
    public void searchByName(){
        System.out.println("Nhập tên khách hàng cần tìm: ");
        String name = scanner.nextLine();
        System.out.println((customerManager.searchByName(name)));
    }
    public void searchByAddress(){
        System.out.println("Nhập địa chỉ khách hàng cần tìm: ");
        String address = scanner.nextLine();
        System.out.println(customerManager.searchByAddress(address));
    }
    public void update(){
        System.out.println("Nhập mã khách hàng cần cập nhật: ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.println("Nhập tên khách hàng cần cập nhật: ");
        String name = scanner.nextLine();
        System.out.println("nhập tuổi khách hàng cần cập nhật: ");
        int age = scanner.nextInt(); scanner.nextLine();
        System.out.println("Nhập địa chỉ khách hàng cần cập nhật: ");
        String address = scanner.nextLine();
        customerManager.update(id,name,age,address);
    }
    public void showList(){
        customerManager.display();
    }
}