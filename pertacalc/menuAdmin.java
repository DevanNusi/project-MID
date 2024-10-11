package pertacalc;

import java.util.ArrayList;
import java.util.Scanner;

public class menuAdmin {
    public static ArrayList<datastock> mario = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    private static datastock inputdata(){
        datastock data=new datastock();
        System.out.print("masukan nama stok : ");
        data.nama = input.nextLine();
        System.out.print("masukan harga : ");
        data.harga = input.nextInt();
        System.out.print("masukan stok : ");
        data.stock = input.nextInt();
        return data;
    }
    private static void tambahdata(){
        mario.add(inputdata());

    }

    private static void hapusdata(){
        if (!mario.isEmpty()){
            System.out.print("masukan baris data yg mau dihapus");
            int index = input.nextInt() -1;
            mario.remove(index);
        } else {
            System.out.println("data masih kosong");
        }

    }
    private static void editdata(){
        if(!mario.isEmpty()){
            System.out.print("masukan baris data yg mau di edit");
            int index = input.nextInt() -1;
            mario.set(index,inputdata());
        } else {
            System.out.println("data masih kosong");
        }


    }
    private static void bacadata(){
        if(!mario.isEmpty()){
            System.out.println("no\tnama\tharga\tstok");
            int nomor = 1;
            for (datastock data : mario){
                System.out.println(nomor + ".\t" + data.nama +"\t" + data.harga + "\t" + data.stock);
                nomor++;
            }
        } else {
            System.out.println("data masih kosong");
        }


    }

    public static void tampilkanmenu (){
        while (true) {
            System.out.println("selamat datang di menu admin\n");
            System.out.println("1.tambah produk");
            System.out.println("2.hapus produk");
            System.out.println("3.edit produk");
            System.out.println("4.tampilkan produk");
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
                    return;
                default:
                    System.out.println("pilihan yg anda masukan salah");

            }

        }

    }

}
