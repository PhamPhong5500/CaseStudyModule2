package glasses;

import java.io.*;
import java.util.*;
public class GlassesManager {
    public String path = "CaseStudyModule2/glasses.txt";
    private List<Glasses> glasses;
    private static GlassesManager glassesManager = new GlassesManager();

    public static GlassesManager getGlassesManager() {
        return glassesManager;
    }

    private GlassesManager() {
        this.glasses = new ArrayList<>();
        read();
    }

    public void add(Glasses glassesWarehouse) {
        if (glassesWarehouse != null) {
            glasses.add(glassesWarehouse);
            save();
        }
    }

    public void remove(int id) {
        if (searchById(id) != null) {
            glasses.remove(searchById(id));
            save();
        }
    }

    public Glasses searchById(int id) {
        read();
        for (Glasses glassesWarehouse : glasses) {
            if (glassesWarehouse.getId() == id) {
                return glassesWarehouse;
            }
        }
        return null;
    }

    public void update(int id, String name, int size, int price, String brand, int quantity) {
        Glasses glassesUpdate = searchById(id);
        if (glassesUpdate != null) {
            glassesUpdate.setName(name);
            glassesUpdate.setBrand(brand);
            glassesUpdate.setPrice(price);
            glassesUpdate.setSize(size);
            glassesUpdate.setQuantity(quantity);
        }
        save();
    }

    public List<Glasses> searchByBrand(String brand) {
        read();
        List<Glasses> glassesWarehouses = new ArrayList<>();
        for (Glasses glassesWarehouse : glasses) {
            if (glassesWarehouse.getBrand().equals(brand)) {
                glassesWarehouses.add(glassesWarehouse);
            }
        }
        return glassesWarehouses;
    }

    public List<Glasses> searchBySize(int size) {
        read();
        List<Glasses> glassesWarehouses = new ArrayList<>();
        for (Glasses glassesWarehouse : glasses) {
            if (glassesWarehouse.getSize() == size) {
                glassesWarehouses.add(glassesWarehouse);
            }
        }
        return glassesWarehouses;
    }

    public void save(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for (Glasses glassesWarehouse : glasses){
                bw.write(glassesWarehouse.toString());
                bw.newLine();
            }
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void read(){
        glasses.clear();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";
            while ((line = br.readLine())!=null){
                Glasses glassesWarehouse = handLeLine(line);
                glasses.add(glassesWarehouse);
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public Glasses handLeLine(String line){
        String[] strings = line.split(",");
        return new Glasses(Integer.parseInt(strings[0]),strings[1],
                Integer.parseInt(strings[2]),Integer.parseInt(strings[3]),
                strings[4],Integer.parseInt(strings[5]));
    }
    public void display(){
        for (Glasses glassesWarehouse : glasses){
            System.out.println(glassesWarehouse);
        }
    }
}