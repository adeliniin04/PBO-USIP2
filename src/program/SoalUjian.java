package program;

import java.util.Scanner;

public abstract class SoalUjian {
    
    protected String soal;
    protected Jawaban kunciJawaban;

    public SoalUjian(String soal) {
        this(soal, null);
    }

    public SoalUjian(String soal, Jawaban kunciJawaban) {
        this.soal = soal;
        this.kunciJawaban = kunciJawaban;
    }

    public String getPertanyaan() {
        return soal;
    }

    public Jawaban getKunciJawaban() {
        return kunciJawaban;
    }

    public abstract String getSoal();
}

class SoalPilihanGanda extends SoalUjian {
    
    private Jawaban[] pilihanJawaban;

    public SoalPilihanGanda(String soal, Jawaban[] pilihanJawaban, Jawaban kunciJawaban) {
        super(soal, kunciJawaban);
        this.pilihanJawaban = pilihanJawaban;
    }

    public void tampilkanJawaban() {
        for (int i = 0; i < pilihanJawaban.length; i++) {
            System.out.println("\t" + (char) ('A' + i) + ". " + pilihanJawaban[i]);
        }
    }

    /**
     * Metode ini mensimpanJawaban pertanyaan secara langsung dengan masukan A hingga E menyesuaikan banyaknya
     * pilihan yang diberikan.
     * <br><br><center><code>
     *     (input < 65) || (input >= 65 + pilihanJawaban.length)
     * </code></center><br>
     * Merupakan kondisi untuk mengecek apakah character yang dimasukkan memiliki bobot yang sesuai dengan tabel
     * ASCII yaitu A = 65 hingga E = 69
     * */
    public void jawab() {
        Scanner scanner = new Scanner(System.in);
        char input;
        do {
            System.out.print("Masukkan simpanJawabanan Anda: ");
            input = scanner.nextLine().toUpperCase().charAt(0);

            if ((input < 65) || (input >= 65 + pilihanJawaban.length))
                System.out.println("Masukkan simpanJawabanan yang sesuai!");

        } while ((input < 65) || (input >= 65 + pilihanJawaban.length));

        /* Mengkonversi char ASCII menjadi index dari 0 hingga 4. */
        int inputIndex = switch (input) {
            case 'A' -> 0;
            case 'B' -> 1;
            case 'C' -> 2;
            case 'D' -> 3;
            default -> 4;
        };

        if (getKunciJawaban().getLabel().equalsIgnoreCase(pilihanJawaban[inputIndex].getLabel()))
            System.out.println("Jawaban Anda benar!");
        else
            System.out.println("Jawaban Anda salah!");
    }

    public void simpanJawaban(Jawaban jawaban) {
        kunciJawaban = jawaban;
    }

    public String getSoal() {
        var sb = new StringBuilder();
        sb.append(soal).append("\n");
        char option = 65; // 65 adalah A.
        for (Jawaban simpanJawabanan : pilihanJawaban)
            sb.append("\t")
                    .append(option++)
                    .append(simpanJawabanan.getLabel()).append("\n");
        return sb.toString();
    }
}

class SoalIsian extends SoalUjian {
    
    public SoalIsian(String soal, Jawaban kunciJawaban) {
        super(soal, kunciJawaban);
    }

    /**
     * Metode ini mensimpanJawaban dan memberikan keputusan benar salah sebuah simpanJawabanan secara langsung.
     * */
    public void jawab() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.print("Jawaban: ");
            input = scanner.nextLine();
            if (input.length() > 20)
                System.out.println("Maksimal 20 karakter.");
        } while (input.length() > 20);

        Jawaban inputJawaban = new Jawaban(input);

        if (inputJawaban.getLabel().equalsIgnoreCase(getKunciJawaban().getLabel()))
            System.out.println("Jawaban Anda benar!");
        else
            System.out.println("Jawaban Anda salah!");
    }

    public void simpanJawaban(Jawaban jawaban) {
        kunciJawaban = jawaban;
    }

    @Override
    public String getSoal() {
        return getPertanyaan();
    }
}

class SoalEsai extends SoalUjian {
    
    private String namaFile;
    private String linkFile;

    public SoalEsai(String soal, String namaFile, String linkFile) {
        super(soal);
        this.namaFile = namaFile;
        this.linkFile = linkFile;
    }

    /**
     * Metode ini mensimpanJawaban dan memberikan keputusan benar salah sebuah simpanJawabanan secara langsung.
     * */
    public void jawab() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(super.getPertanyaan());
        System.out.print("Nama File     : ");
        namaFile = scanner.nextLine();
        System.out.print("Link gambar   :  ");
        linkFile = scanner.nextLine();

        /* Menyimpan jawaban. */
        simpanJawaban(namaFile, linkFile);
        System.out.println("Jawaban anda sudah tersimpan!");
    }

    /**
     * Menyimpan masukan jawaban ke kelas.
     * @param namaFile nama file.
     * @param linkFile link file.
     * */
    public void simpanJawaban(String namaFile, String linkFile) {
        kunciJawaban = new Jawaban(namaFile, linkFile);
    }

    @Override
    public String getSoal() {
        return getPertanyaan();
    }
}
