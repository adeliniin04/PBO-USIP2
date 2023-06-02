package program;

import java.util.Scanner;

public abstract class SoalUjian {
    
    protected String soal;
    protected Jawaban jawaban;
    // test
    public SoalUjian(String soal, Jawaban jawaban) {
        this.soal = soal;
        this.jawaban = jawaban;
    }

    public String getPertanyaan() {
        return soal;
    }

    public Jawaban getJawaban() {
        return jawaban;
    }

    public abstract void getSoal();
}

class SoalPilihanGanda extends SoalUjian {
    
    private String[] pilihanJawaban;

    public SoalPilihanGanda(String soal, String[] pilihanJawaban, Jawaban jawaban) {
        super(soal, jawaban);
        this.pilihanJawaban = pilihanJawaban;
    }

    public void tampilkanSoal() {
        System.out.println(super.getPertanyaan());
    }

    public void tampilkanJawaban() {
        for (int i = 0; i < pilihanJawaban.length; i++) {
            System.out.println("\t" + (char) ('A' + i) + ". " + pilihanJawaban[i]);
        }
    }

    @Override
    public void getSoal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jawaban Anda: ");
        String jawaban = scanner.nextLine();

        if (jawaban.isEmpty()) {
            System.out.println("Anda belum memasukkan jawaban.");
            return;
        }
        char inputJawaban = Character.toUpperCase(jawaban.charAt(0));
        String kunciJawaban = getJawaban().getLabel().toUpperCase();
        if (kunciJawaban.equals(pilihanJawaban[inputJawaban - 'A'].toUpperCase()))
            System.out.println("Jawaban Anda benar!");
        else
            System.out.println("Jawaban Anda salah!");
    }
}

class SoalIsian extends SoalUjian {
    
    public SoalIsian(String soal, Jawaban jawaban) {
        super(soal, jawaban);
    }

    @Override
    public void getSoal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Jawaban : ");
        String jawIsian = scanner.nextLine();
        if (jawIsian.length() > 20) System.out.println("Maksimal 20 karakter.");
        else {
            Jawaban jawabanIsian = new Jawaban(jawIsian);
            if (jawabanIsian.getLabel().equalsIgnoreCase(getJawaban().getLabel())) {
                System.out.println("Jawaban Anda benar!");
            } else {
                System.out.println("Jawaban Anda salah!");
            }
        }
    }
}

class SoalEsai extends SoalUjian {
    
    private String namaFile;
    private String linkFile;

    public SoalEsai(String soal, String namaFile, String linkFile) {
        super(soal, null);
        this.namaFile = namaFile;
        this.linkFile = linkFile;
    }

    public String getnamaFile() {
        return namaFile;
    }

    public String getlinkFile() {
        return linkFile;
    }

    @Override
    public void getSoal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(super.getPertanyaan());
        System.out.print("Nama File     : ");
        String namaFile = scanner.nextLine();
        System.out.print("Link gambar   :  ");
        String linkFile = scanner.nextLine();
    }
}
