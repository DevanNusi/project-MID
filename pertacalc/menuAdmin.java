package pertacalc;

import java.util.ArrayList;
import java.util.Scanner;

public class menuAdmin {
    public static ArrayList<datastock> kumpulanDataStock = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    private static datastock inputdata(){
        datastock data=new datastock();
        System.out.print("masukan nama stok : ");
        input.nextLine();
        data.nama = input.nextLine();
        System.out.print("masukan harga : ");
        data.harga = input.nextInt();
        System.out.print("masukan stok : ");
        data.stock = input.nextInt();
        return data;
    }
    private static void tambahdata(){
        kumpulanDataStock.add(inputdata());

    }

    private static void hapusdata(){
        if (!kumpulanDataStock.isEmpty()){
            bacadata();
            System.out.print("masukan baris data yg mau dihapus : ");
            int index = input.nextInt() -1;
            kumpulanDataStock.remove(index);
        } else {
            System.out.println("data masih kosong");
        }

    }
    private static void editdata(){
        if(!kumpulanDataStock.isEmpty()){
            bacadata();
            System.out.print("masukan baris data yg mau di edit : ");
            int index = input.nextInt() -1;
            kumpulanDataStock.set(index,inputdata());
        } else {
            System.out.println("data masih kosong");
        }


    }
    public static void bacadata(){
        if(!kumpulanDataStock.isEmpty()){
            System.out.println("no\tnama\tharga\tstok");
            int nomor = 1;
            for (datastock data : kumpulanDataStock){
                System.out.println(nomor + ".\t" + data.nama +"\t" + data.harga + "\t" + data.stock);
                nomor++;
            }
        } else {
            System.out.println("data masih kosong");
        }


    }

    private static void lihatPesanan(){
        if(!menuPelanggan.kumpulanDataPelanggan.isEmpty()){
            int counter = 1;
            System.out.println("No.\tNama\tJenisBensin\tjumlahBensin\tMetodePembayaran\tTotal\tKritik&Saran");
            for (datapelanggan i : menuPelanggan.kumpulanDataPelanggan){
                System.out.println(counter + ".\t" + i.nama + "\t\t" + i.jenisBensin + "\t\t" + i.banyakBensin + "\t\t\t\t" + i.metodePembayaran + "\t\t\t" +i.totalPembayaran + "\t\t" + i.kritikDanSaran);
                counter++;
            }
        }else {
            System.out.println("Data Pelanggan Masih belum tersedia !!");
        }
    }

    public static void tampilkanmenu (){
        while (true) {
            System.out.println("selamat datang di menu admin\n");
            System.out.println("1.tambah produk");
            System.out.println("2.hapus produk");
            System.out.println("3.edit produk");
            System.out.println("4. tampilkan produk");
            System.out.println("5. tampilkan pesanan");
            System.out.println("6. keluar Menu");
            System.out.print("masukan pilihan anda : ");
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    tambahdata();
                    break;
                case 2:
                    hapusdata();
                    break;
                case 3:
                    editdata();
                    break;
                case 4:
                    bacadata();
                    break;
                case 5:
                    lihatPesanan();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("pilihan yg anda masukan salah");
                    break;
            }

        }

    }

}