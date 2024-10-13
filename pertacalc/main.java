package pertacalc;

import java.util.Scanner;

public class main {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        while (true){
            System.out.println("SELAMAT DATANG DI PERTACALC");
            System.out.println("1. Admin");
            System.out.println("2. Pembeli");
            System.out.println("3. keluar menu");
            System.out.print("Masukan Pilhan anda : ");
            int pilihan = input.nextInt();
            switch (pilihan){
                case 1:
                    menuAdmin.tampilkanmenu();
                    break;
                case 2:
                    menuPelanggan.bukaMenu();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu yang anda input tidak tersedia !!!");
                    break;
            }
        }
    }
}
