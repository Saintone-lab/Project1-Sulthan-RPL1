/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
    
    public ArrayList<Menu> getSemuaMenu() {
        return daftarmenu;
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

    public Menu pilihMenu() {
        try{
            Scanner Input = new Scanner(System.in);
            
            System.out.print("Nomor Menu yang dipesan : ");
            int no_menu = Input.nextInt();
            
            Menu m = daftarmenu.get(no_menu-1);
            
            if(!m.getKategori().equalsIgnoreCase("Kuah")){
                return m;
        }else{
               System.out.println("[Err] Pesan Dulu Ramen");
               return pilihMenu();
            }
    }catch(IndexOutOfBoundsException err){
        System.out.println("[Err] Pesanan Ridak tersedia");
        return pilihMenu();
    }catch(InputMismatchException err){
     System.out.println("[Err] Mohon masukan nomor menu");
     return pilihMenu();
    }
}
    public Menu pilihKuah() {
        try{
            Scanner Input = new Scanner(System.in);
            
            System.out.print("Kuah [sesuai nomor menu] : ");
            int no_menu = Input.nextInt();
            
            Menu m = daftarmenu.get(no_menu-1);
            
            if(!m.getKategori().equalsIgnoreCase("Kuah")){
                return m;
        }else{
               System.out.println("[Err] Bukan Menu Kuah");
               return pilihKuah();
            }
    }catch(IndexOutOfBoundsException err){
        System.out.println("[Err] Pesanan Ridak tersedia");
        return pilihKuah();
    }catch(InputMismatchException err){
     System.out.println("[Err] Mohon masukan nomor kuah");
     return pilihKuah();
    }
}
}
