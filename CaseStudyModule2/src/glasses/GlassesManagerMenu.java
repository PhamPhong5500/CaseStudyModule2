package glasses;

import customer.CustomerManager;
import menu.MenuAll;
import java.util.Scanner;
public class GlassesManagerMenu {
    GlassesManager glassesWarehouseManager = GlassesManager.getGlassesManager();
    Scanner scanner = new Scanner(System.in);
    public void displayMenu(){
        System.out.println("+--------->>>>>>------MENU------<<<<<<-------------+");
        System.out.println("|      1. Thêm mắt kính !                          |");
        System.out.println("|      2. Xóa mắt kính !                           |");
        System.out.println("|      3. Tìm kiếm mắt kính dựa trên id !          |");
        System.out.println("|      4. Tìm kiếm mắt kính dựa trên thương hiệu ! |");
        System.out.println("|      5. Tìm kiếm dựa trên địa chỉ !              |");
        System.out.println("|      6. Sửa thông tin khách hàng !               |");
        System.out.println("|      7. Hiển thị danh sách !                     |");
        System.out.println("+------->>>>>--------END-----------<<<<<-----------+");
    }
    public void Menu() {
        while(true) {
            displayMenu();
            System.out.println("Mời bạn nhập lựa chọn : ");
            int choice = scanner.nextInt(); scanner.nextLine();
            switch(choice) {
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
                    searchByBrand();
                    break;
                case 5:
                    searchBySize();
                    break;
                case 6:
                    update();
                    break;
                case 7:
                    showList();
                default:
                    new MenuAll().menu();
            }
        }
    }
    public void add() {
        System.out.println("Nhập mã sản phẩm: ");
        int id = scanner.nextInt(); scanner.nextLine();
        id = checkIdGlasses(id);
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập kích thước sản phẩm: ");
        int size = scanner.nextInt();scanner.nextLine();
        System.out.println("Nhập giá tiền sản phẩm: ");
        int price = scanner.nextInt(); scanner.nextLine();
        System.out.println("Nhập thương hiệu sản phẩm: ");
        String brand = scanner.nextLine();
        System.out.println("Nhập số lượng sản phẩm : ");
        int quantity = scanner.nextInt(); scanner.nextLine();
        glassesWarehouseManager.add(new Glasses(id,name,size,price, brand, quantity));
    }
    public int checkIdGlasses(int id){
        while(glassesWarehouseManager.searchById(id) != null){
            System.out.println("Mã không hợp lệ, vui lòng nhập lại: ");
            id = scanner.nextInt(); scanner.nextLine();
        }
        return id;
    }
    public void remove(){
        System.out.println("Nhập mã : ");
        int id = scanner.nextInt(); scanner.nextLine();
        glassesWarehouseManager.remove(id);
    }
    public void searchById(){
        System.out.println("Nhập mã sản phẩm: ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.println(glassesWarehouseManager.searchById(id));
    }
    public void searchByBrand(){
        System.out.println("Nhập thương hiệu của sản phẩm : ");
        String brand = scanner.nextLine();
        System.out.println(glassesWarehouseManager.searchByBrand(brand));
    }
    public void searchBySize(){
        System.out.println("Nhập kích cỡ sản phẩm : ");
        int size = scanner.nextInt(); scanner.nextLine();
        System.out.println(glassesWarehouseManager.searchBySize(size));
    }
    public void  update(){
        System.out.println("Nhập mã : ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.println("Nhập tên : ");
        String name = scanner.nextLine();
        System.out.println("Nhập thương hiệu : ");
        String brand = scanner.nextLine();
        System.out.println("Nhập giá tiền : ");
        int price = scanner.nextInt(); scanner.nextLine();
        System.out.println("Nhập kích thước : ");
        int size = scanner.nextInt(); scanner.nextLine();
        System.out.println("Nhập số lượng : ");
        int quantity = scanner.nextInt(); scanner.nextLine();
        glassesWarehouseManager.update(id,name,size,price,brand,quantity);
    }
    public void showList(){
        glassesWarehouseManager.display();
    }
}

