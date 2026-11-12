package Quiz2;

import java.util.Scanner;

public class KuisKantin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int porsi, pesananTerbanyak = 0, total = 0, jumlahTransaksi = 0, jumlahTransaksiLebihDari2 = 0;

        int nim2 = 22;
        int totalDiskon = 0;
        float diskon = .5f;

        int k = (nim2 % 3) + 3;
        System.out.println("k = " + k);

        System.out.print("Jumlah porsi (0 = selesai): ");
        porsi = sc.nextInt();
        total = 0;

        while (porsi != 0) {
            if (porsi > 10 || porsi < 0) {
                System.out.println("Jumlah porsi tidak boleh negatif atau lebih dari 10!");
                System.out.print("Jumlah porsi (0 = selesai): ");
                porsi = sc.nextInt();
                continue;
            }

            if (porsi > 2) {
                jumlahTransaksiLebihDari2++;
            }

            if (porsi > pesananTerbanyak) {
                pesananTerbanyak = porsi;
            }

            // Harga: porsi pertama Rp 15000, porsi berikutnya Rp 12000 per porsi
            int biaya = 15000 + (porsi - 1) * 12000;
            
            jumlahTransaksi++;
            if (jumlahTransaksi % k == 0) {
                System.out.println("Selamat! Anda mendapatkan diskon 50% untuk transaksi ini.");
                diskon = 0.5f;
                totalDiskon += biaya * diskon;
            }  else {
                diskon = 1.0f;
            }
            biaya = (int) (biaya * diskon);
            
            System.out.println("Biaya: Rp " + biaya);
            total += biaya;

            System.out.print("Jumlah porsi (0 = selesai): ");
            porsi = sc.nextInt();
        }

        System.out.println("=== RINGKASAN ===");

        System.out.println("Jumlah transaksi : " + jumlahTransaksi);
        System.out.println("Porsi terbanyak dalam 1 transaksi: " + pesananTerbanyak);
        System.out.println("Jumlah transaksi lebih dari 2 porsi: " + jumlahTransaksiLebihDari2);
        
        System.out.println("Total diskon  : Rp " + totalDiskon);
        System.out.println("Total biaya    : Rp " + (total - totalDiskon));
        sc.close();
    }
}