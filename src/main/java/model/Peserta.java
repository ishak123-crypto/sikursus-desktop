package model;

public class Peserta extends Orang {
    private String nim;
<<<<<<< HEAD
    private String jenisKelamin;
    private String prodi;
    private String email;

    public Peserta() {}

    public Peserta(String nim, String nama, String jenisKelamin, String prodi, String noHp, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin = jenisKelamin; }

    public String getProdi() { return prodi; }
    public void setProdi(String prodi) { this.prodi = prodi; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
=======
    private String prodi;

    public Peserta(int id, String nama, String noHp, String nim, String prodi) {
        super(id, nama, noHp);
        setNim(nim);
        setProdi(prodi);
    }

    public String getNim() { return nim; }
    public String getProdi() { return prodi; }

    public void setNim(String nim) {
        if (nim == null || nim.trim().isEmpty())
            throw new IllegalArgumentException("NIM wajib diisi");
        this.nim = nim.trim();
    }

    public void setProdi(String prodi) {
        if (prodi == null || prodi.trim().isEmpty())
            throw new IllegalArgumentException("Prodi wajib diisi");
        this.prodi = prodi.trim();
    }

    @Override
    public String getInfo() {
        return "PESERTA | " + super.getInfo() + " | NIM: " + getNim() + " | Prodi: " + getProdi();
    }
>>>>>>> bcfbb203a7c39bb92013a5302af4ad8f93834c0f
}