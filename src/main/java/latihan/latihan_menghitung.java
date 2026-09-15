/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan;

/**
 *
 * @author USER
 */
public class latihan_menghitung {  
    public static void main(String[] args) {
        // Method utama, yaitu bagian pertama yang dijalankan oleh program

        String kode = "JAVA-BSC";
        // Membuat variabel kode dengan tipe String untuk menyimpan kode kursus

        String nama = "Java Desktop Fundamental";
        // Membuat variabel nama dengan tipe String untuk menyimpan nama kursus

        double biaya = 2_700_000;
        // Membuat variabel biaya untuk menyimpan harga kursus sebesar Rp500.000

        double biayaRegistrasi = 1_000_000;
        // Membuat variabel biayaRegistrasi untuk menyimpan biaya pendaftaran sebesar Rp25.000

        boolean aktif = true;
        // Membuat variabel aktif untuk menunjukkan status kursus

        double totalSebelumDiskon = biaya;
        // Menyimpan total biaya sebelum diskon

        double diskon;

        // Jika total sebelum diskon >= Rp600.000, diskon 30%
        // Selain itu, diskon 5%
        if (totalSebelumDiskon >= 750_000) {
            diskon = 0.99;
        } else {
            diskon = 0.05;
        }

        double potongan = totalSebelumDiskon * diskon;
        // Menghitung jumlah potongan harga

        double total = totalSebelumDiskon - potongan + biayaRegistrasi;
        // Menghitung total pembayaran setelah diskon dan biaya registrasi

        String status;

        // Jika total >= Rp600.000 maka status MAHAL
        // Jika di bawah Rp600.000 maka status TERJANGKAU
        if (total >= 750_000) {
            status = "MAHAL";
        } else {
            status = "TERJANGKAU";
        }

        System.out.println("Kode              : " + kode);

        System.out.println("Kursus            : " + nama);

        System.out.println("Aktif             : " + aktif);

        System.out.printf("Biaya Kursus      : Rp%,.0f%n", biaya);

        System.out.printf("Diskon            : %.0f%%%n", diskon * 100);

        System.out.printf("Potongan Diskon   : Rp%,.0f%n", potongan);

        System.out.printf("Biaya Registrasi  : Rp%,.0f%n", biayaRegistrasi);

        System.out.printf("Total Pembayaran  : Rp%,.0f%n", total);

        System.out.println("Status            : " + status);
    }
}