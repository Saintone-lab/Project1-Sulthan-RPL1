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
            public static void main(String[] args, String no_transaksi, String nama_pemesan, String tanggal, String makan_ditempat, String no_meja){
        Scanner input = new Scanner (System.in);
        MainAplikasiKasir app = new MainAplikasiKasir();
        app.generateDaftarMenu();
        
        //mulai transaksi
        System.out.println("======== TRANSAKSI =======");
        
        //ambil data transaksi
        System.out.println("No Transaksi : ");
        no_transaksi = input.next();
        System.out.println("Pemesan : ");
        nama_pemesan = input.next();
        System.out.println("Tanggal : [dd-mm-yyyy] ");
        tanggal = input.next();
        System.out.println("Makan ditempat? [Y/N] ");
        makan_ditempat = input.next();
        
        if (makan_ditempat. equalsIgnoreCase("Y")){
            System.out.println("Nomor Meja : ");
            no_meja = input.next();
        }
        
        
        
    }

    public void add(Menu menu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
