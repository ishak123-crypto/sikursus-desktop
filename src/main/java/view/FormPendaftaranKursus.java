package view;

<<<<<<< HEAD
import dao.PesertaDAO;
import model.Peserta;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class FormPendaftaranKursus extends javax.swing.JFrame {

    private ButtonGroup groupJenis;
=======
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


public class FormPendaftaranKursus extends JFrame {

    private final Color warnaLatar = new Color(248, 250, 252);
    // Warna header dan tombol proses diubah menjadi nuansa hijau
    private final Color warnaHeader = new Color(40, 167, 69); 
    private final Color warnaProses = new Color(33, 136, 56); 
    private final Color warnaReset = new Color(255, 51, 51);

    private JPanel panelUtama;
    private JPanel panelHeader;
    private JPanel panelForm;
    private JPanel panelJenis;
    private JPanel panelFasilitas;
    private JPanel panelTombol;

    private JLabel lblJudul;
    private JLabel lblNama;
    private JLabel lblKodeAkses;
    private JLabel lblJenis;
    private JLabel lblKursus;
    private JLabel lblFasilitas;
    private JLabel lblRingkasan;

    private JTextField txtNama;
    private JPasswordField txtKodeAkses;
    private JRadioButton rbMahasiswa;
    private JRadioButton rbUmum;
    private ButtonGroup groupJenis;
    private JComboBox<String> cmbKursus;
    private JCheckBox cbModul;
    private JCheckBox cbSertifikat;
    private JCheckBox cbRekaman;
    private JTextArea txtRingkasan;
    private JScrollPane scrollRingkasan;
    private JButton btnProses;
    private JButton btnReset;
>>>>>>> bcfbb203a7c39bb92013a5302af4ad8f93834c0f

    public FormPendaftaranKursus() {
        initComponents();

<<<<<<< HEAD
        groupJenis = new ButtonGroup();
        groupJenis.add(rbLaki);
        groupJenis.add(rbPerempuan);

        txtRingkasan.setEditable(false);
        txtKodeAkses.setToolTipText("Kode akses demo praktikum: PBO2026 atau PB02026");
        setLocationRelativeTo(null);

        cmbKursus.removeAllItems();
        cmbKursus.addItem("-- Pilih Kursus --");
        cmbKursus.addItem("Java Desktop");
        cmbKursus.addItem("Data Science");
        cmbKursus.addItem("Web Programming");
        cmbKursus.addItem("UI/UX Design");
        cmbKursus.addItem("Database MySQL");
        cmbKursus.addItem("Dasar-Dasar Pemrograman");
    }

    // Method mengambil jenis kelamin peserta
    private String getJenisKelamin() {
        if (rbLaki.isSelected()) {
            return "L";
        } else if (rbPerempuan.isSelected()) {
            return "P";
=======
        groupJenis.add(rbMahasiswa);
        groupJenis.add(rbUmum);

        txtRingkasan.setEditable(false);
        txtRingkasan.setLineWrap(false);
        getRootPane().setDefaultButton(btnProses);

        setMinimumSize(new Dimension(760, 650));
        setSize(new Dimension(920, 720));
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        panelUtama = new JPanel(new BorderLayout());
        panelHeader = new JPanel(new BorderLayout());
        panelForm = new JPanel(new GridBagLayout());
        panelJenis = new JPanel(new FlowLayout(FlowLayout.LEFT, 14, 0));
        panelFasilitas = new JPanel(new FlowLayout(FlowLayout.LEFT, 14, 0));
        panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 24, 0));

        lblJudul = new JLabel("Form Pendaftaran Kursus", SwingConstants.CENTER);
        lblNama = new JLabel("Nama Peserta");
        lblKodeAkses = new JLabel("Kode Akses");
        lblJenis = new JLabel("Jenis Peserta");
        lblKursus = new JLabel("Kursus");
        lblFasilitas = new JLabel("Fasilitas");
        lblRingkasan = new JLabel("Ringkasan");

        txtNama = new JTextField();
        txtKodeAkses = new JPasswordField();
        rbMahasiswa = new JRadioButton("Mahasiswa");
        rbUmum = new JRadioButton("Umum");
        groupJenis = new ButtonGroup();

        cmbKursus = new JComboBox<String>(new String[] {
            "-- Pilih Kursus --",
            "Java Desktop",
            "Data Science",
            "Web Programming",
            "UI/UX Design"
        });

        cbModul = new JCheckBox("Modul Cetak");
        cbSertifikat = new JCheckBox("Sertifikat");
        cbRekaman = new JCheckBox("Akses Rekaman");

        txtRingkasan = new JTextArea(11, 20);
        scrollRingkasan = new JScrollPane(txtRingkasan);

        btnProses = new JButton("Proses");
        btnReset = new JButton("Reset");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SIKURSUS Desktop - Pendaftaran Kursus");

        panelUtama.setBackground(warnaLatar);
        panelHeader.setBackground(warnaHeader);
        panelForm.setBackground(warnaLatar);
        panelJenis.setBackground(warnaLatar);
        panelFasilitas.setBackground(warnaLatar);
        panelTombol.setBackground(warnaLatar);

        lblJudul.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblJudul.setForeground(Color.WHITE);
        lblJudul.setPreferredSize(new Dimension(100, 70));
        panelHeader.add(lblJudul, BorderLayout.CENTER);

        rbMahasiswa.setBackground(warnaLatar);
        rbUmum.setBackground(warnaLatar);
        cbModul.setBackground(warnaLatar);
        cbSertifikat.setBackground(warnaLatar);
        cbRekaman.setBackground(warnaLatar);

        panelJenis.add(rbMahasiswa);
        panelJenis.add(rbUmum);

        panelFasilitas.add(cbModul);
        panelFasilitas.add(cbSertifikat);
        panelFasilitas.add(cbRekaman);

        btnProses.setBackground(warnaProses);
        btnProses.setForeground(Color.WHITE);
        btnProses.setFocusPainted(false);
        btnProses.setPreferredSize(new Dimension(130, 38));
        btnProses.addActionListener(evt -> btnProsesActionPerformed());

        btnReset.setBackground(warnaReset);
        btnReset.setForeground(Color.WHITE);
        btnReset.setFocusPainted(false);
        btnReset.setPreferredSize(new Dimension(130, 38));
        btnReset.addActionListener(evt -> btnResetActionPerformed());

        panelTombol.add(btnProses);
        panelTombol.add(btnReset);

        txtNama.setPreferredSize(new Dimension(420, 36));
        txtKodeAkses.setPreferredSize(new Dimension(420, 36));
        cmbKursus.setPreferredSize(new Dimension(420, 36));
        txtKodeAkses.setToolTipText("Kode akses demo praktikum: PBO2026");

        txtRingkasan.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        txtRingkasan.setBackground(Color.WHITE);
        scrollRingkasan.setPreferredSize(new Dimension(520, 215));

        panelForm.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));

        addRow(0, lblNama, txtNama, 0.0);
        addRow(1, lblKodeAkses, txtKodeAkses, 0.0);
        addRow(2, lblJenis, panelJenis, 0.0);
        addRow(3, lblKursus, cmbKursus, 0.0);
        addRow(4, lblFasilitas, panelFasilitas, 0.0);
        addRow(5, lblRingkasan, scrollRingkasan, 1.0);

        GridBagConstraints tombol = new GridBagConstraints();
        tombol.gridx = 1;
        tombol.gridy = 6;
        tombol.weightx = 1.0;
        tombol.fill = GridBagConstraints.HORIZONTAL;
        tombol.anchor = GridBagConstraints.CENTER;
        tombol.insets = new Insets(20, 8, 0, 0);
        panelForm.add(panelTombol, tombol);

        panelUtama.add(panelHeader, BorderLayout.NORTH);
        panelUtama.add(panelForm, BorderLayout.CENTER);
        setContentPane(panelUtama);
    }

    private void addRow(int row, JLabel label, java.awt.Component component, double weightY) {
        GridBagConstraints cLabel = new GridBagConstraints();
        cLabel.gridx = 0;
        cLabel.gridy = row;
        cLabel.anchor = GridBagConstraints.NORTHWEST;
        cLabel.insets = new Insets(9, 0, 11, 16);
        cLabel.ipadx = 18;
        panelForm.add(label, cLabel);

        GridBagConstraints cField = new GridBagConstraints();
        cField.gridx = 1;
        cField.gridy = row;
        cField.weightx = 1.0;
        cField.weighty = weightY;
        cField.fill = weightY > 0 ? GridBagConstraints.BOTH : GridBagConstraints.HORIZONTAL;
        cField.anchor = GridBagConstraints.NORTHWEST;
        cField.insets = new Insets(0, 0, 11, 0);
        panelForm.add(component, cField);
    }

    private String getJenisPeserta() {
        if (rbMahasiswa.isSelected()) {
            return "Mahasiswa";
        }
        if (rbUmum.isSelected()) {
            return "Umum";
>>>>>>> bcfbb203a7c39bb92013a5302af4ad8f93834c0f
        }
        return "";
    }

<<<<<<< HEAD
    // Method menentukan biaya dasar kursus
=======
>>>>>>> bcfbb203a7c39bb92013a5302af4ad8f93834c0f
    private double hitungBiayaDasar(String kursus) {
        switch (kursus) {
            case "Java Desktop":
                return 500_000;
            case "Data Science":
                return 650_000;
            case "Web Programming":
                return 450_000;
            case "UI/UX Design":
                return 400_000;
<<<<<<< HEAD
            case "Database MySQL":
                return 450_000;
            case "Dasar-Dasar Pemrograman":
                return 350_000;
=======
>>>>>>> bcfbb203a7c39bb92013a5302af4ad8f93834c0f
            default:
                return 0;
        }
    }

<<<<<<< HEAD
    // Method menghitung biaya fasilitas tambahan
=======
>>>>>>> bcfbb203a7c39bb92013a5302af4ad8f93834c0f
    private double hitungBiayaFasilitas() {
        double total = 0;
        if (cbModul.isSelected()) {
            total += 50_000;
        }
        if (cbSertifikat.isSelected()) {
            total += 75_000;
        }
        if (cbRekaman.isSelected()) {
            total += 40_000;
        }
        return total;
    }

<<<<<<< HEAD
    // Method menyusun ringkasan fasilitas dengan Array dan Loop
=======
>>>>>>> bcfbb203a7c39bb92013a5302af4ad8f93834c0f
    private String buatRingkasanFasilitas() {
        String[] fasilitasDipilih = new String[3];
        int jumlah = 0;

        if (cbModul.isSelected()) {
<<<<<<< HEAD
            fasilitasDipilih[jumlah] = "Modul Cetak (+Rp50.000)";
            jumlah++;
        }
        if (cbSertifikat.isSelected()) {
            fasilitasDipilih[jumlah] = "Sertifikat (+Rp75.000)";
            jumlah++;
        }
        if (cbRekaman.isSelected()) {
            fasilitasDipilih[jumlah] = "Akses Rekaman (+Rp40.000)";
=======
            fasilitasDipilih[jumlah] = "Modul Cetak";
            jumlah++;
        }
        if (cbSertifikat.isSelected()) {
            fasilitasDipilih[jumlah] = "Sertifikat";
            jumlah++;
        }
        if (cbRekaman.isSelected()) {
            fasilitasDipilih[jumlah] = "Akses Rekaman";
>>>>>>> bcfbb203a7c39bb92013a5302af4ad8f93834c0f
            jumlah++;
        }

        if (jumlah == 0) {
            return "- Tidak ada fasilitas tambahan\n";
        }

        StringBuilder hasil = new StringBuilder();
        for (int i = 0; i < jumlah; i++) {
            hasil.append("- ").append(fasilitasDipilih[i]).append("\n");
        }
        return hasil.toString();
    }

<<<<<<< HEAD
    // Method mengosongkan input form
    private void clearForm() {
        txtNim.setText("");
        txtNama.setText("");
        txtKodeAkses.setText("");
        groupJenis.clearSelection();
        txtProdi.setText("");
        txtHp.setText("");
        txtEmail.setText("");
        cmbKursus.setSelectedIndex(0);
        cbModul.setSelected(false);
        cbSertifikat.setSelected(false);
        cbRekaman.setSelected(false);
        txtNim.requestFocus();
    }

    private void resetForm() {
        clearForm();
        txtRingkasan.setText("");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelForm = new javax.swing.JPanel();
        lblSubForm = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNim = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtKodeAkses = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtProdi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtHp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbKursus = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbModul = new javax.swing.JCheckBox();
        cbSertifikat = new javax.swing.JCheckBox();
        cbRekaman = new javax.swing.JCheckBox();
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanelRingkasan = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRingkasan = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIKURSUS Desktop - Form Pendaftaran Kursus");

        // Background Utama (Soft Slate)
        jPanel1.setBackground(new Color(241, 245, 249));

        // Header Panel (Dark Navy Blue)
        jPanel2.setBackground(new Color(30, 41, 59));

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 24));
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("  SIKURSUS — Form Pendaftaran Kursus");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        // Panel Form Kiri (Putih dengan Border Halus)
        jPanelForm.setBackground(new Color(255, 255, 255));
        jPanelForm.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
            BorderFactory.createEmptyBorder(18, 22, 18, 22)
        ));

        lblSubForm.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblSubForm.setForeground(new Color(30, 41, 59));
        lblSubForm.setText("Data Diri & Pilihan Kursus");

        Font labelFont = new Font("Segoe UI", Font.BOLD, 12);
        Color labelColor = new Color(71, 85, 105);
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 13);

        jLabel8.setFont(labelFont);
        jLabel8.setForeground(labelColor);
        jLabel8.setText("NIM");

        jLabel2.setFont(labelFont);
        jLabel2.setForeground(labelColor);
        jLabel2.setText("Nama Peserta");

        jLabel3.setFont(labelFont);
        jLabel3.setForeground(labelColor);
        jLabel3.setText("Kode Akses");

        jLabel4.setFont(labelFont);
        jLabel4.setForeground(labelColor);
        jLabel4.setText("Jenis Kelamin");

        jLabel9.setFont(labelFont);
        jLabel9.setForeground(labelColor);
        jLabel9.setText("Program Studi");

        jLabel10.setFont(labelFont);
        jLabel10.setForeground(labelColor);
        jLabel10.setText("Nomor HP");

        jLabel11.setFont(labelFont);
        jLabel11.setForeground(labelColor);
        jLabel11.setText("Alamat Email");

        jLabel5.setFont(labelFont);
        jLabel5.setForeground(labelColor);
        jLabel5.setText("Pilih Kursus");

        jLabel6.setFont(labelFont);
        jLabel6.setForeground(labelColor);
        jLabel6.setText("Fasilitas Tambahan");

        txtNim.setFont(inputFont);
        txtNama.setFont(inputFont);
        txtKodeAkses.setFont(inputFont);
        txtProdi.setFont(inputFont);
        txtHp.setFont(inputFont);
        txtEmail.setFont(inputFont);

        rbLaki.setBackground(new Color(255, 255, 255));
        rbLaki.setFont(inputFont);
        rbLaki.setForeground(new Color(30, 41, 59));
        rbLaki.setText("Laki-laki");
        rbLaki.addActionListener(evt -> rbLakiActionPerformed(evt));

        rbPerempuan.setBackground(new Color(255, 255, 255));
        rbPerempuan.setFont(inputFont);
        rbPerempuan.setForeground(new Color(30, 41, 59));
        rbPerempuan.setText("Perempuan");

        cmbKursus.setFont(inputFont);
        cmbKursus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Java Desktop", "Data Science", "Web Programming", "UI/UX Design" }));
        cmbKursus.addActionListener(evt -> cmbKursusActionPerformed(evt));

        cbModul.setBackground(new Color(255, 255, 255));
        cbModul.setFont(inputFont);
        cbModul.setForeground(new Color(30, 41, 59));
        cbModul.setText("Modul Cetak");

        cbSertifikat.setBackground(new Color(255, 255, 255));
        cbSertifikat.setFont(inputFont);
        cbSertifikat.setForeground(new Color(30, 41, 59));
        cbSertifikat.setText("Sertifikat");
        cbSertifikat.addActionListener(evt -> cbSertifikatActionPerformed(evt));

        cbRekaman.setBackground(new Color(255, 255, 255));
        cbRekaman.setFont(inputFont);
        cbRekaman.setForeground(new Color(30, 41, 59));
        cbRekaman.setText("Akses Rekaman");
        cbRekaman.addActionListener(evt -> cbRekamanActionPerformed(evt));

        btnSimpan.setBackground(new Color(37, 99, 235));
        btnSimpan.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnSimpan.setForeground(new Color(255, 255, 255));
        btnSimpan.setText("Simpan & Proses Pendaftaran");
        btnSimpan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSimpan.addActionListener(evt -> btnSimpanActionPerformed(evt));

        btnReset.setBackground(new Color(220, 38, 38));
        btnReset.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnReset.setForeground(new Color(255, 255, 255));
        btnReset.setText("Reset Form");
        btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnReset.addActionListener(evt -> btnResetActionPerformed(evt));

        javax.swing.GroupLayout jPanelFormLayout = new javax.swing.GroupLayout(jPanelForm);
        jPanelForm.setLayout(jPanelFormLayout);
        jPanelFormLayout.setHorizontalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSubForm)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(24, 24, 24)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNim)
                    .addComponent(txtNama)
                    .addComponent(txtKodeAkses)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addComponent(rbLaki)
                        .addGap(25, 25, 25)
                        .addComponent(rbPerempuan)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtProdi)
                    .addComponent(txtHp)
                    .addComponent(txtEmail)
                    .addComponent(cmbKursus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addComponent(cbModul)
                        .addGap(15, 15, 15)
                        .addComponent(cbSertifikat)
                        .addGap(15, 15, 15)
                        .addComponent(cbRekaman)
                        .addGap(0, 10, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelFormLayout.setVerticalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addComponent(lblSubForm)
                .addGap(18, 18, 18)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKodeAkses, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rbLaki)
                    .addComponent(rbPerempuan))
                .addGap(12, 12, 12)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtHp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbKursus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbModul)
                    .addComponent(cbSertifikat)
                    .addComponent(cbRekaman))
                .addGap(24, 24, 24)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // Panel Ringkasan Kanan (Putih dengan Border Halus)
        jPanelRingkasan.setBackground(new Color(255, 255, 255));
        jPanelRingkasan.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
            BorderFactory.createEmptyBorder(18, 22, 18, 22)
        ));

        jLabel7.setFont(new Font("Segoe UI", Font.BOLD, 16));
        jLabel7.setForeground(new Color(30, 41, 59));
        jLabel7.setText("Ringkasan & Struk Pendaftaran");

        txtRingkasan.setBackground(new Color(248, 250, 252));
        txtRingkasan.setColumns(28);
        txtRingkasan.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtRingkasan.setForeground(new Color(30, 41, 59));
        txtRingkasan.setRows(5);
        txtRingkasan.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        jScrollPane1.setViewportView(txtRingkasan);

        javax.swing.GroupLayout jPanelRingkasanLayout = new javax.swing.GroupLayout(jPanelRingkasan);
        jPanelRingkasan.setLayout(jPanelRingkasanLayout);
        jPanelRingkasanLayout.setHorizontalGroup(
            jPanelRingkasanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );
        jPanelRingkasanLayout.setVerticalGroup(
            jPanelRingkasanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRingkasanLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1))
        );

        // Layout Utama (Side-by-Side)
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanelRingkasan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRingkasan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void rbLakiActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {
        int jawab = JOptionPane.showConfirmDialog(
            this,
            "Kosongkan seluruh input dan ringkasan?",
            "Konfirmasi Reset",
            JOptionPane.YES_NO_OPTION
        );
=======
    private boolean validasiInput() {
        String nama = txtNama.getText().trim();
        String kode = new String(txtKodeAkses.getPassword());

        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nama peserta wajib diisi.",
                    "Validasi",
                    JOptionPane.WARNING_MESSAGE);
            txtNama.requestFocus();
            return false;
        }

        if (!kode.equals("PBO2026")) {
            JOptionPane.showMessageDialog(this,
                    "Kode akses demo salah.",
                    "Validasi",
                    JOptionPane.WARNING_MESSAGE);
            txtKodeAkses.requestFocus();
            return false;
        }

        if (!rbMahasiswa.isSelected() && !rbUmum.isSelected()) {
            JOptionPane.showMessageDialog(this,
                    "Pilih jenis peserta.",
                    "Validasi",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (cmbKursus.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Pilih kursus terlebih dahulu.",
                    "Validasi",
                    JOptionPane.WARNING_MESSAGE);
            cmbKursus.requestFocus();
            return false;
        }

        return true;
    }

    private void btnProsesActionPerformed() {
        if (!validasiInput()) {
            return;
        }

        String nama = txtNama.getText().trim();
        String jenis = getJenisPeserta();
        String kursus = cmbKursus.getSelectedItem().toString();

        double biayaDasar = hitungBiayaDasar(kursus);
        double diskon = jenis.equals("Mahasiswa") ? biayaDasar * 0.10 : 0;
        double biayaFasilitas = hitungBiayaFasilitas();
        double total = biayaDasar - diskon + biayaFasilitas;

        String fasilitas = buatRingkasanFasilitas();

        String ringkasan =
                "PENDAFTARAN KURSUS\n"
                + "================================\n"
                + "Nama            : " + nama + "\n"
                + "Jenis Peserta   : " + jenis + "\n"
                + "Kursus          : " + kursus + "\n"
                + "Biaya Dasar     : " + formatRupiah(biayaDasar) + "\n"
                + "Diskon          : " + formatRupiah(diskon) + "\n"
                + "Fasilitas:\n" + fasilitas
                + "Biaya Fasilitas : " + formatRupiah(biayaFasilitas) + "\n"
                + "================================\n"
                + "TOTAL           : " + formatRupiah(total);

        txtRingkasan.setText(ringkasan);
        txtRingkasan.setCaretPosition(0);

        JOptionPane.showMessageDialog(this,
                "Pendaftaran berhasil diproses.",
                "Berhasil",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnResetActionPerformed() {
        int jawab = JOptionPane.showConfirmDialog(
                this,
                "Kosongkan seluruh input?",
                "Konfirmasi Reset",
                JOptionPane.YES_NO_OPTION);

>>>>>>> bcfbb203a7c39bb92013a5302af4ad8f93834c0f
        if (jawab == JOptionPane.YES_OPTION) {
            resetForm();
        }
    }

<<<<<<< HEAD
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        String nim = txtNim.getText().trim();
        String nama = txtNama.getText().trim();
        String prodi = txtProdi.getText().trim();
        String noHp = txtHp.getText().trim();
        String email = txtEmail.getText().trim();
        String kode = txtKodeAkses.getText().trim();
        String jenisKelamin = getJenisKelamin();

        // 1. Validasi input wajib
        if (nim.isEmpty() || nama.isEmpty() || prodi.isEmpty() || jenisKelamin.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "NIM, Nama, Jenis Kelamin, dan Program Studi wajib diisi.",
                "Validasi",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // 2. Validasi Nomor HP & Email
        if (!noHp.isEmpty() && !noHp.matches("\\d+")) {
            JOptionPane.showMessageDialog(
                this,
                "Nomor HP hanya boleh berisi angka.",
                "Validasi",
                JOptionPane.WARNING_MESSAGE
            );
            txtHp.requestFocus();
            return;
        }

        if (!email.isEmpty() && !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(
                this,
                "Format email tidak valid.",
                "Validasi",
                JOptionPane.WARNING_MESSAGE
            );
            txtEmail.requestFocus();
            return;
        }

        // 3. Validasi Kode Akses (Mendukung PBO2026 atau PB02026)
        if (!kode.isEmpty() && !kode.equals("PBO2026") && !kode.equals("PB02026")) {
            JOptionPane.showMessageDialog(
                this,
                "Kode akses demo salah (Gunakan: PBO2026).",
                "Validasi",
                JOptionPane.WARNING_MESSAGE
            );
            txtKodeAkses.requestFocus();
            return;
        }

        // 4. Bentuk object Peserta menggunakan setter & simpan melalui PesertaDAO
        Peserta peserta = new Peserta();
        peserta.setNim(nim);
        peserta.setNama(nama);
        peserta.setJenisKelamin(jenisKelamin);
        peserta.setProdi(prodi);
        peserta.setNoHp(noHp);
        peserta.setEmail(email);

        PesertaDAO dao = new PesertaDAO();

        try {
            boolean berhasil = dao.insert(peserta);
            if (berhasil) {
                String kursus = cmbKursus.getSelectedIndex() > 0 ? cmbKursus.getSelectedItem().toString() : "-";
                double biayaDasar = hitungBiayaDasar(kursus);
                double diskon = !nim.isEmpty() ? biayaDasar * 0.10 : 0;
                double biayaFasilitas = hitungBiayaFasilitas();
                double total = biayaDasar - diskon + biayaFasilitas;
                String fasilitas = buatRingkasanFasilitas();

                String ringkasan = "========================================\n"
                        + "      DATA PESERTA & PENDAFTARAN        \n"
                        + "========================================\n"
                        + "NIM             : " + nim + "\n"
                        + "Nama            : " + nama + "\n"
                        + "Jenis Kelamin   : " + (jenisKelamin.equals("L") ? "Laki-laki (L)" : "Perempuan (P)") + "\n"
                        + "Program Studi   : " + prodi + "\n"
                        + "Nomor HP        : " + (noHp.isEmpty() ? "-" : noHp) + "\n"
                        + "Email           : " + (email.isEmpty() ? "-" : email) + "\n"
                        + "----------------------------------------\n"
                        + "Kursus          : " + kursus + "\n"
                        + "Biaya Dasar     : Rp" + String.format("%,.0f", biayaDasar) + "\n"
                        + "Diskon (10%)    : Rp" + String.format("%,.0f", diskon) + "\n"
                        + "----------------------------------------\n"
                        + "Fasilitas Tambahan:\n" + fasilitas
                        + "Biaya Fasilitas : Rp" + String.format("%,.0f", biayaFasilitas) + "\n"
                        + "========================================\n"
                        + "TOTAL BIAYA     : Rp" + String.format("%,.0f", total) + "\n"
                        + "========================================";

                txtRingkasan.setText(ringkasan);

                JOptionPane.showMessageDialog(this, "Data peserta berhasil disimpan.");
                clearForm();
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Data tidak tersimpan.",
                    "Informasi",
                    JOptionPane.WARNING_MESSAGE
                );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                this,
                "Gagal menyimpan data:\n" + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
        }
    }

    private void cbSertifikatActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void cbRekamanActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void cmbKursusActionPerformed(java.awt.event.ActionEvent evt) {
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPendaftaranKursus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new FormPendaftaranKursus().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JCheckBox cbModul;
    private javax.swing.JCheckBox cbRekaman;
    private javax.swing.JCheckBox cbSertifikat;
    private javax.swing.JComboBox<String> cmbKursus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JPanel jPanelRingkasan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSubForm;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHp;
    private javax.swing.JTextField txtKodeAkses;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNim;
    private javax.swing.JTextField txtProdi;
    private javax.swing.JTextArea txtRingkasan;
    // End of variables declaration
=======
    private void resetForm() {
        txtNama.setText("");
        txtKodeAkses.setText("");
        groupJenis.clearSelection();
        cmbKursus.setSelectedIndex(0);
        cbModul.setSelected(false);
        cbSertifikat.setSelected(false);
        cbRekaman.setSelected(false);
        txtRingkasan.setText("");
        txtNama.requestFocus();
    }

    private String formatRupiah(double nilai) {
        String angka = String.format(Locale.US, "%,.0f", nilai).replace(',', '.');
        return "Rp" + angka;
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FormPendaftaranKursus.class.getName())
                    .log(java.util.logging.Level.WARNING, "Nimbus tidak dapat diaktifkan", ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormPendaftaranKursus().setVisible(true);
            }
        });
    }
>>>>>>> bcfbb203a7c39bb92013a5302af4ad8f93834c0f
}