/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import classes.DaftarMenu;
import classes.Kuah;
import classes.Menu;
import classes.Minuman;
import classes.Pesanan;
import classes.Ramen;
import classes.Toping;
import classes.Transaksi;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author saintone17
 */
public class MainAplikasiKasir {

    public DaftarMenu daftarmenu;
    //tambahkan
    public static double PAJAK_PPN = 0.10;
    public static double BIAYA_SERVICES = 0.05;
    
    public static void main(String[]args){
        Scanner input = new Scanner (System.in);
        
        String no_transaksi, nama_pemesan, tanggal, no_meja = "";
        String transaksi_lagi = "", pesan_lagi = "", keterangan = "", makan_ditempat;
        int jumlah_pesanan, no_menu;
        
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
        //buat transaksi baru 
        Transaksi trans = new Transaksi (no_transaksi, nama_pemesan, tanggal, makan_ditempat);
        System.out.println("======== PESANAN =======");
        int no_kuah;
        do {
            Menu menu_yang_dipilih = app.daftarmenu.pilihMenu();
            
            jumlah_pesanan = (int) app.cekInputNumber("Jumlah : ");
            
            Pesanan pesanan = new Pesanan(menu_yang_dipilih, jumlah_pesanan);
            trans.tambahPesanan(pesanan);
            if (menu_yang_dipilih.getKategori().equals("Ramen")){
                int jumlah_ramen = jumlah_pesanan;
                do{
                    Menu kuah_yang_dipilih = app.daftarmenu.pilihKuah();
                    
                    System.out.print("Level : [0-5] : ");
                    String level = input.next();
                    int jumlah_kuah = 0;
                    do{
                        jumlah_kuah = (int) app.cekInputNumber("jumlah : ");
                        
                        if (jumlah_kuah > jumlah_ramen) {
                            System.out.println("[Err] jumlah kuah melebihi jumlah ramen yang sudah dipesan");
                        }else {
                            break;
                        }
                    }while (jumlah_kuah > jumlah_ramen);
                    
                    Pesanan pesanan_kuah = new Pesanan(kuah_yang_dipilih, jumlah_kuah);
                    pesanan_kuah.setKeterangan("Level" + level);
                    
                    trans.tambahPesanan(pesanan_kuah);
                    
                    jumlah_ramen -= jumlah_kuah;
                }while (jumlah_ramen > 0);
            }else{
                System.out.print("Keterangan [- jika kosong]: ");
                keterangan = input.next();
            }
            if (!keterangan.equals("-")){
                pesanan.setKeterangan(keterangan);
            }
            System.out.print("Tambah Pesan Lagi? [Y/N] : ");
            pesan_lagi = input.next();
        
        }while(pesan_lagi.equalsIgnoreCase("Y"));
        trans.cetakStruk();
        
        double total_pesanan = trans.hitungTotalPesanan();
        System.out.println("============================");
        System.out.println("Total : \t\t" + total_pesanan);
        
        //hitung pajak
        //jika makan ditempat, biaya pajak = 10% ppn + 5% service
        trans.setPajak(PAJAK_PPN);
        double ppn = trans.hitungPajak();
        System.out.println("Pajak 10% : \t\t" + ppn);
        
        double biaya_service = 0;
        if (makan_ditempat.equalsIgnoreCase("Y")) {
            trans.setBiayaServices(BIAYA_SERVICES);
            biaya_service = trans.hitungBiayaService();
            System.out.println("Biaya Service 5% : \t" + biaya_service);
        }
        
        //tampilkan total bayar
        System.out.println("Total : \t\t" + trans.hitungTotalBayar(ppn, biaya_service));
        
        //cek uang bayar,apakah > total bayar atau tidak
        double kembalian = 0;
        do {
            //ambil input uang bayar
            double uang_bayar = app.cekInputNumber("Uang Bayar : \t\t");
            
            kembalian = trans.hitungKembalian(uang_bayar);
            if (kembalian < 0) {
                System.out.println("[Err] Uang Anda Kurang");
            } else {
                System.out.println("Kembalian : \t\t" + kembalian);
                break;
            }
        } while (kembalian < 0);
        System.out.println("===== TERIMA KASIH =====");

    }
    public void generateDaftarMenu(){
    daftarmenu = new DaftarMenu();
    daftarmenu.tambahMenu (new Ramen("Ramen Seafood", 25000));
    daftarmenu.tambahMenu (new Ramen("Ramen Original", 18000));
    daftarmenu.tambahMenu (new Ramen("Ramen Vegetarian", 22000));
    daftarmenu.tambahMenu (new Ramen("Ramen Karnivor", 28000));
    daftarmenu.tambahMenu (new Kuah("Kuah Orisinil"));
    daftarmenu.tambahMenu (new Kuah("Kuah Internasional"));
    daftarmenu.tambahMenu (new Kuah("Kuah Spicy Lada"));
    daftarmenu.tambahMenu (new Kuah("Kuah Soto Padang"));
    daftarmenu.tambahMenu (new Toping("Crab Stick Bakar", 6000));
    daftarmenu.tambahMenu (new Toping("Chicken Katsu", 8000));
    daftarmenu.tambahMenu (new Toping("Gyoza Goreng", 4000));
    daftarmenu.tambahMenu (new Toping("Bakso Goreng", 7000));
    daftarmenu.tambahMenu (new Toping("Enoki Goreng", 5000));
    daftarmenu.tambahMenu (new Minuman("Jus Alpukat SPC", 10000));
    daftarmenu.tambahMenu (new Minuman("Jus stroberi", 11000));
    daftarmenu.tambahMenu (new Minuman("Capucino Coffee", 15000));
    daftarmenu.tambahMenu (new Minuman("Vietnam Dripp", 14000));
    
    daftarmenu.tampilDaftarMenu();
    }
    public double cekInputNumber(String label){
            try{
                Scanner get_input = new Scanner (System.in);
                System.out.print(label);
                double nilai = get_input.nextDouble();
                return nilai;
            }catch(InputMismatchException Err){
                System.out.println("[Err] Harap masukan angka");
                return cekInputNumber(label);
            }
        }

}
