/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author saintone17
 */
    


    public class Transaksi {
    private String noTransaksi;
    private String namaPemesan;
    private String tanggal;
    private String noMeja;
    private ArrayList<Pesanan> pesanan;
    private double uangBayar;
    private double pajak;
    private double totalBayar;
    
    private double biayaServices=0;
        
    public Transaksi(String no_transaksi, String nm_pemesan, String tanggal, String no_meja){
        this.noTransaksi = no_transaksi;
        this.namaPemesan = nm_pemesan;
        this.tanggal = tanggal;
        this.noMeja = no_meja;
        
        pesanan = new ArrayList<>();
    }
    
    public void tambahPesanan(Pesanan pesanan) {
        this.pesanan.add(pesanan);
    }
//    public Pesanan getPesanan() {return null;}
    public ArrayList<Pesanan> getSemuaPesanan() {return pesanan;}
    public double hitungTotalBayar() {return 0;}
    public double hitungKembalian() {return 0;}
    public void cetakStruk(){
    System.out.println("\n======== ALDEBARAMEN ========");
        System.out.println("No Transaksi : "+noTransaksi);
        System.out.println("Pemesan : "+namaPemesan);
        System.out.println("Tanggal : "+tanggal);
        
        //cek jika nomor meja kosong, berarti take away
        if(noMeja.equals("")){
            noMeja = "Take Away";
        }
        
        System.out.println("Meja : "+noMeja);
        System.out.println("============================");
        for (int i = 0; i < pesanan.size(); i++) {
            Pesanan pan = pesanan.get(i);
            Menu m = pan.getMenu();
            String pesanan = pan.getJumlah() + " " + m.getNama_menu() + "\t" + (m.getHarga()*pan.getJumlah());
            
            //jika pesanan kuah, tambah spasi di awal 2
            if (m.getKategori().equals("Kuah")) {
                pesanan = " "+pesanan;
            }
            //tampilan pesanan
            System.out.println(pesanan);
    }
}
    public void setBiayaServices(double services){
        this.biayaServices = services;
    }
    
    public void setPajak(double pajak){
        this.pajak = pajak;
    }
    public double hitungTotalPesanan(){
        
        for (int i = 0; i < pesanan.size(); i++) {
            Pesanan pan = pesanan.get(i);
            double harga = pan.getMenu().getHarga();
            totalBayar += (harga * pan.getJumlah());
        }
        return totalBayar;
    }
    
    //tambahkan
    public double hitungPajak(){
        return totalBayar * pajak;
    }
    
    //tambahkan
    public double hitungBiayaService(){
        return totalBayar * biayaServices;
    }
    
    //tambahkan
    public double hitungTotalBayar(double pajak, double service) {
        totalBayar = totalBayar + pajak + service;
        return totalBayar;
    }
    
    public double hitungKembalian(double uang_bayar) {
        return uang_bayar - totalBayar; //bisa dibuat validator?
    }
}