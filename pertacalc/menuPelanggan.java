package pertacalc;

import java.util.ArrayList;
import java.util.Scanner;

public class menuPelanggan {
    private static Scanner input = new Scanner(System.in);
    public static ArrayList<datapelanggan> kumpulanDataPelanggan = new ArrayList<>();
    private static datapelanggan dataPelangganSementara = new datapelanggan();
    private static int barisBensin;

    private static void kurangiStokBensin(){
        datastock temp = menuAdmin.kumpulanDataStock.get(barisBensin);
        temp.stock -= dataPelangganSementara.banyakBensin;

        if(temp.stock == 0){
            menuAdmin.kumpulanDataStock.remove(barisBensin);
        }else {
            menuAdmin.kumpulanDataStock.set(barisBensin,temp);
        }
    }

    private static void tambahPesanan(){
        if(!menuAdmin.kumpulanDataStock.isEmpty()){
            menuAdmin.bacadata();
            System.out.print("pilih jenis bensin yang tersedia : ");
            barisBensin = input.nextInt() -1;
            dataPelangganSementara.jenisBensin = menuAdmin.kumpulanDataStock.get(barisBensin).nama;

            System.out.print("Masukan nama Anda : ");
            input.nextLine();
            dataPelangganSementara.nama = input.nextLine();

            System.out.print("Masukan metode pembayaran bensin : ");
            dataPelangganSementara.metodePembayaran = input.nextLine();

            System.out.print("Masukan banyak Liter Bensin yang ingin di beli : ");
            dataPelangganSementara.banyakBensin = input.nextInt();
            dataPelangganSementara.totalPembayaran = dataPelangganSementara.banyakBensin * menuAdmin.kumpulanDataStock.get(barisBensin).harga;
        }else {
            System.out.println("Stock bensin masih belum tersedia !!");
        }
    }

    private static void masukanKritikDanSaran(){
        System.out.print("Masukan Kritik dan Saran anda : ");
        input.nextLine();
        dataPelangganSementara.kritikDanSaran = input.nextLine();
    }

    private static void editPesanan(){
        if(dataPelangganSementara.nama != null){
            hapusPesanan();
            tambahPesanan();
        }else {
            System.out.println("Anda Masih Belum Memesan !!!");
        }
    }
    private static void hapusPesanan(){
        dataPelangganSementara = new datapelanggan();
    }

    private static void checkOut(){
        if(dataPelangganSementara.nama != null){
            masukanKritikDanSaran();
            kurangiStokBensin();
            kumpulanDataPelanggan.add(dataPelangganSementara);
        }else {
            System.out.println("Anda Masih Belum Memesan !!!");
        }
    }

    public static void bukaMenu(){
        while (true){
            System.out.println("SELAMAT BERBELANJA !!!!\n\n");
            System.out.println("1.Memesan Bensin");
            System.out.println("2.Mengedit Pesanan");
            System.out.println("3.Hapus Pesanan");
            System.out.println("4.Bayar Pesanan");
            System.out.print("Masukan Pilihan Anda : ");
            int pilihan = input.nextInt();

            switch (pilihan){
                case 1:
                    tambahPesanan();
                    break;
                case 2:
                    editPesanan();
                    break;
                case 3:
                    hapusPesanan();
                    break;
                case 4:
                    checkOut();
                    return;
                default:
                    System.out.println("Menu Yang anda input tidak tersedia !!!");
                    break;
            }
        }
    }
}
