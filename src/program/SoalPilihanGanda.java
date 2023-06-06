package program;

public class SoalPilihanGanda extends SoalUjian {

    private JawabanTunggal[] pilihanJawaban;
    private JawabanTunggal kunciJawaban;
    private JawabanTunggal inputJawaban;

    public SoalPilihanGanda(String soal, JawabanTunggal[] pilihanJawaban, JawabanTunggal kunciJawaban) {
        super(soal);
        this.pilihanJawaban = pilihanJawaban;
        this.kunciJawaban = kunciJawaban;
    }

    /* Getters */

    public JawabanTunggal[] getPilihanJawaban() {
        return pilihanJawaban;
    }

    public JawabanTunggal getKunciJawaban() {
        return kunciJawaban;
    }

    public JawabanTunggal getInputJawaban() {
        return inputJawaban;
    }

    /* Setters */

    public void setPilihanJawaban(JawabanTunggal[] pilihanJawaban) {
        this.pilihanJawaban = pilihanJawaban;
    }

    public void setKunciJawaban(JawabanTunggal kunciJawaban) {
        this.kunciJawaban = kunciJawaban;
    }

    /**
     * Mengembalikan string pilihan jawaban yang terdapat pada soal.
     * @return {@link String}
     * */
    public String getPilihan() {
        var sb = new StringBuilder();
        char option = 65; // 65 adalah A.
        for (JawabanTunggal jawaban : pilihanJawaban)
            sb.append("\n")
                    .append("\t")
                    .append(option++)
                    .append(". ")
                    .append(jawaban.getLabel());
        return sb.toString();
    }

    /**
     * Menyimpan masukan jawaban ke kelas.
     * @param jawaban jawaban yang berisi label dari kelas {@link JawabanTunggal}.
     * */
    public void setInputJawaban(JawabanTunggal jawaban) {
        inputJawaban = jawaban;
    }

    public String getSoal() {
        return soal + getPilihan();
    }
}