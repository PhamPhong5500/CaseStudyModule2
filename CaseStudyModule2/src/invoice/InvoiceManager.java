package invoice;

import glasses.Glasses;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceManager {

    public String path = "CaseStudyModule2/order.txt";
    private List<Invoice> listInvoice;
    private  static InvoiceManager invoiceManager = new InvoiceManager();
    public static InvoiceManager getInvoiceManager(){
        return invoiceManager;
    }
    private InvoiceManager() {
        this.listInvoice= new ArrayList<>();
    }

    public void add(Invoice invoice) {
        if(invoice != null) {
            listInvoice.add(invoice);
        }
    }
    public void remove(int id){
        if(searchById(id) != null) {
            listInvoice.remove(searchById(id));
        }

    }
    public Invoice searchById(int id){
        for(Invoice invoice : listInvoice) {
            if(invoice.getId() == id) {
                return invoice;
            }
        }
        return null;
    }

    public List<Invoice> getListInvoice() {
        return listInvoice;
    }
    public void update(int id, int idCustomer, int idGlass) {
        Invoice invoiceUpdate = searchById(id);
        if(invoiceUpdate != null) {
            invoiceUpdate.setId(id);
            invoiceUpdate.setIdCustomer(idCustomer);
            invoiceUpdate.setIdGlasses(idGlass);
        }
    }
    public void printBill(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for (Invoice invoice : listInvoice){
                bw.write(invoice.Bill());
                bw.newLine();
            }
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }



}
