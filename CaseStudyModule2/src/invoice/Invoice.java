package invoice;
import java.util.Date;
import java.util.List;

import customer.CustomerManager;
import glasses.GlassesManager;

public class Invoice {
    GlassesManager glassesWarehouseManager = GlassesManager.getGlassesManager();
    private int id ;
    private int idCustomer;
    private  int idGlasses;
    private Date date = new Date();
    private List<Invoice> listInvoice;

    public Invoice() {}

    public Invoice(int id, int idCustomer, int idGlasses) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.idGlasses =idGlasses;
    }

    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdCustomer(){
        return idCustomer;
    }
    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public List<Invoice> getListInvoice(){
        return listInvoice;
    }

    public int getIdGlasses() {
        return idGlasses;
    }

    public void setIdGlasses(int idGlasses) {
        this.idGlasses = idGlasses;
    }

    public void setListInvoice(List<Invoice> invoice ) {
        this.listInvoice = listInvoice;
    }
    @Override
    public String toString() {
        return id + "," + idCustomer + "," + idGlasses ;
    }


    CustomerManager customerManager = CustomerManager.getCustomerManager();
    GlassesManager glassesManager = GlassesManager.getGlassesManager();

    public int getPrice(int idGlasses){
        return glassesManager.searchById(idGlasses).getPrice();
    }
    public int getQuantity(int idGlasses){
        return glassesManager.searchById(idGlasses).getQuantity();
    }
    public String getNameGlasses(int idGlasses){
        return glassesManager.searchById(idGlasses).getName();
    }
    public int total(int price, int quantity){
        return price * quantity;
    }
    public String Bill(){
        return id + "," + getPrice(this.idGlasses) +","+ getQuantity(this.idGlasses) + "," + getNameGlasses(this.idGlasses)+ ","
                +total(getPrice(this.idGlasses), getQuantity(this.idGlasses))+ "," + this.date;
    }
}
