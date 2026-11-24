package model;

public class Peserta extends Orang {
    private String nim;
    private String jenisKelamin;
    private String prodi;
    private String email;

    public Peserta() {
        super();
    }

    public Peserta(int id, String nama, String noHp, String nim, String prodi) {
        super(id, nama, noHp);
        setNim(nim);
        setProdi(prodi);
    }

    public Peserta(String nim, String nama, String jenisKelamin, String prodi, String noHp, String email) {
        super(0, nama, noHp);
        setNim(nim);
        setJenisKelamin(jenisKelamin);
        setProdi(prodi);
        setEmail(email);
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        if (nim == null || nim.trim().isEmpty()) {
            throw new IllegalArgumentException("NIM wajib diisi");
        }
        this.nim = nim.trim();
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        if (jenisKelamin == null || jenisKelamin.trim().isEmpty()) {
            throw new IllegalArgumentException("Jenis kelamin wajib diisi");
        }
        this.jenisKelamin = jenisKelamin.trim();
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        if (prodi == null || prodi.trim().isEmpty()) {
            throw new IllegalArgumentException("Prodi wajib diisi");
        }
        this.prodi = prodi.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? "" : email.trim();
    }

    @Override
    public String getInfo() {
        String infoDasar = "PESERTA | " + super.getInfo() + " | NIM: " + getNim() + " | Prodi: " + getProdi();
        if (jenisKelamin != null && !jenisKelamin.isEmpty()) {
            infoDasar += " | JK: " + jenisKelamin;
        }
        if (email != null && !email.isEmpty()) {
            infoDasar += " | Email: " + email;
        }
        return infoDasar;
    }
}