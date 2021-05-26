/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.Scanner;
import main.MainAplikasiKasir;

/**
 *
 * @author saintone17
 */
public class DaftarMenu {

    private ArrayList<Menu> daftarmenu;
    public DaftarMenu(){
        daftarmenu = new ArrayList<>();
    }
    public void tambahMenu (Menu menu) {
        daftarmenu.add(menu);
    }
    public void getMenuByKategori(String kategori){
        System.out.println("======== " + kategori + " =======");
        
        for(int i = 0; i < daftarmenu.size(); i++){
            Menu m = daftarmenu.get(i);
            if (m.getKategori().equals(kategori)){
                System.out.println((i + 1) + ". " + m.getNama_menu() + "\t" + m.getHarga());
            }
        }
    }
    public void tampilDaftarMenu() {
        System.out.println("======== ALDEBARAMEN =======");
        getMenuByKategori("Ramen");
        getMenuByKategori("Kuah");
        getMenuByKategori("Toping");
        getMenuByKategori("Minuman");
    }
            public static void main(String[] args){
        Scanner input = new Scanner (System.in);
        MainAplikasiKasir app = new MainAplikasiKasir();
        app.generateDaftarMenu();
    }

    public void add(Menu menu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
