package invoice;

import customer.CustomerManager;
import glasses.GlassesManager;
import menu.MenuAll;

import java.util.List;
import java.util.Scanner;

public class InvoiceManagerMenu {
    InvoiceManager invoiceManager = InvoiceManager.getInvoiceManager();
    CustomerManager customerManager = CustomerManager.getCustomerManager();
    GlassesManager glassesWarehouseManager = GlassesManager.getGlassesManager();
    List<Invoice> listInvoice = InvoiceManager.getInvoiceManager().getListInvoice();
    Scanner scanner = new Scanner(System.in);
    public void displayMenu() {
        System.out.println("+-------->>>>----------MENU----------<<<<-----------+");
        System.out.println("|      1. Thêm hóa đơn !                            |");
        System.out.println("|      2. Xóa đơn hàng !                            |");
        System.out.println("|      3. Tìm kiếm dựa trên mã đơn hàng !           |");
        System.out.println("|      4. Cập nhật Đơn hàng !                       |");
        System.out.println("|      5. Hiển thị hóa đơn thanh toán !             |");
        System.out.println("|      6. Xuất hóa đơn !                            |");
        System.out.println("+--------->>>>---------END---------<<<<-------------+");
    }
    public void Menu() {
        while (true) {
            displayMenu();
            System.out.println("---->>-Mời bạn nhập lựa chọn-<<----");
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
                    update();
                    break;
                case 5:
                    showList();
                    break;
                case 6:
                    invoiceManager.printBill();
                    break;
                default:
                    new MenuAll().menu();
            }
        }
    }
    public void add() {
        System.out.println("Nhập mã hóa đơn: ");
        int idInvoice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập mã khách hàng : ");
        int idCustomer = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập mã sản phẩm : ");
        int idGlasses = scanner.nextInt();
        scanner.nextLine();
        Invoice newInvoice = new Invoice(idInvoice, idCustomer, idGlasses);
        invoiceManager.add(newInvoice);
    }
    public void remove() {
        System.out.println("Nhập mã bạn muốn xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Invoice invoice : invoiceManager.getListInvoice()) {
            if (invoice.getId() == id) {
                invoiceManager.remove(id);
            }
        }
    }
    public void update() {
        System.out.println("Nhập mã hóa đơn: ");
        int idInvoice = scanner.nextInt();
        System.out.println("Nhập mã khách hàng: ");
        int idCustomer = scanner.nextInt();
        System.out.println("Nhập mã sản phẩm: ");
        int idGlasses = scanner.nextInt();
        invoiceManager.update(idInvoice, idCustomer, idGlasses);

    }
    public void searchById(){
        System.out.println("Nhập mã hóa đơn: ");
        int idInvoice = scanner.nextInt(); scanner.nextLine();
        System.out.println(invoiceManager.searchById(idInvoice));
    }

    public void showList() {
        for (Invoice invoice : listInvoice) {
            System.out.println(invoice.toString());
        }
    }

}
