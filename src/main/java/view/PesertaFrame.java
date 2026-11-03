package view;

import dao.PesertaDAO;
import model.Peserta;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PesertaFrame extends javax.swing.JFrame {

    private final PesertaDAO dao = new PesertaDAO();
    private int selectedId = -1;

    public PesertaFrame() {
        initComponents();
        setLocationRelativeTo(null); // Menempatkan window di tengah layar
        configureTable();
        loadTable();
        clearForm();
    }

    private void configureTable() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"ID", "NIM", "Nama", "JK", "Prodi", "No. HP", "Email"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblPeserta.setModel(model);
        tblPeserta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPeserta.setRowHeight(28);
        tblPeserta.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tblPeserta.setSelectionBackground(new Color(219, 234, 254));
        tblPeserta.setSelectionForeground(new Color(30, 41, 59));
        tblPeserta.setShowVerticalLines(false);
        tblPeserta.setGridColor(new Color(226, 232, 240));

        // Styling Header Tabel
        JTableHeader header = tblPeserta.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 13));
        header.setBackground(new Color(241, 245, 249));
        header.setForeground(new Color(51, 65, 85));
        header.setPreferredSize(new Dimension(header.getWidth(), 34));

        // Mengatur lebar kolom agar proporsional
        tblPeserta.getColumnModel().getColumn(0).setPreferredWidth(40);  // ID
        tblPeserta.getColumnModel().getColumn(1).setPreferredWidth(90);  // NIM
        tblPeserta.getColumnModel().getColumn(2).setPreferredWidth(150); // Nama
        tblPeserta.getColumnModel().getColumn(3).setPreferredWidth(40);  // JK
        tblPeserta.getColumnModel().getColumn(4).setPreferredWidth(120); // Prodi
        tblPeserta.getColumnModel().getColumn(5).setPreferredWidth(100); // No. HP
        tblPeserta.getColumnModel().getColumn(6).setPreferredWidth(150); // Email

        // Rata tengah untuk kolom ID dan JK
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( javax.swing.JLabel.CENTER );
        tblPeserta.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblPeserta.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
    }

    private void fillTable(List<Peserta> data) {
        DefaultTableModel model = (DefaultTableModel) tblPeserta.getModel();
        model.setRowCount(0);
        for (Peserta p : data) {
            model.addRow(new Object[]{
                p.getId(),
                p.getNim(),
                p.getNama(),
                p.getJenisKelamin(),
                p.getProdi(),
                p.getNoHp(),
                p.getEmail()
            });
        }
    }

    private void loadTable() {
        try {
            fillTable(dao.findAll());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Gagal memuat data: " + ex.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void refreshData() {
        loadTable();
        clearForm();
        txtCari.setText("");
    }

    private void clearForm() {
        selectedId = -1;
        txtNim.setText("");
        txtNama.setText("");
        bgJenisKelamin.clearSelection();
        txtProdi.setText("");
        txtNoHp.setText("");
        txtEmail.setText("");
        tblPeserta.clearSelection();
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
        txtNim.requestFocus();
    }

    private String getJenisKelamin() {
        if (rbLaki.isSelected()) {
            return "L";
        }
        if (rbPerempuan.isSelected()) {
            return "P";
        }
        return null;
    }

    private Peserta getFormData() {
        Peserta p = new Peserta();
        p.setId(selectedId);
        p.setNim(txtNim.getText().trim());
        p.setNama(txtNama.getText().trim());
        p.setJenisKelamin(getJenisKelamin());
        p.setProdi(txtProdi.getText().trim());
        p.setNoHp(txtNoHp.getText().trim());
        p.setEmail(txtEmail.getText().trim());
        return p;
    }

    private boolean validateForm() {
        if (txtNim.getText().trim().isEmpty()
                || txtNama.getText().trim().isEmpty()
                || txtProdi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "NIM, Nama, dan Prodi wajib diisi."
            );
            return false;
        }
        if (getJenisKelamin() == null) {
            JOptionPane.showMessageDialog(
                this,
                "Pilih jenis kelamin."
            );
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        bgJenisKelamin = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNim = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        rbLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        txtProdi = new javax.swing.JTextField();
        txtNoHp = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCetaksemua = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeserta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIKURSUS Desktop - Master Data Peserta");

        // Background Utama (Soft Slate)
        jPanel1.setBackground(new java.awt.Color(241, 245, 249));

        // Header Panel (Dark Navy Blue)
        jPanel2.setBackground(new java.awt.Color(30, 41, 59));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("  SIKURSUS — Master Data Peserta");

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

        // Panel Form Peserta (Putih dengan Border)
        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new java.awt.Color(226, 232, 240), 1),
            BorderFactory.createEmptyBorder(15, 18, 15, 18)
        ));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16));
        jLabel2.setForeground(new java.awt.Color(30, 41, 59));
        jLabel2.setText("Form Input Peserta");

        Font labelFont = new java.awt.Font("Segoe UI", 1, 12);
        Color labelColor = new java.awt.Color(71, 85, 105);

        jLabel3.setFont(labelFont);
        jLabel3.setForeground(labelColor);
        jLabel3.setText("NIM");

        jLabel4.setFont(labelFont);
        jLabel4.setForeground(labelColor);
        jLabel4.setText("Nama Lengkap");

        jLabel5.setFont(labelFont);
        jLabel5.setForeground(labelColor);
        jLabel5.setText("Jenis Kelamin");

        jLabel6.setFont(labelFont);
        jLabel6.setForeground(labelColor);
        jLabel6.setText("Program Studi");

        jLabel7.setFont(labelFont);
        jLabel7.setForeground(labelColor);
        jLabel7.setText("Nomor HP");

        jLabel8.setFont(labelFont);
        jLabel8.setForeground(labelColor);
        jLabel8.setText("Alamat Email");

        Font inputFont = new java.awt.Font("Segoe UI", 0, 13);
        txtNim.setFont(inputFont);
        txtNama.setFont(inputFont);
        txtProdi.setFont(inputFont);
        txtNoHp.setFont(inputFont);
        txtEmail.setFont(inputFont);

        rbLaki.setBackground(new java.awt.Color(255, 255, 255));
        rbLaki.setFont(inputFont);
        bgJenisKelamin.add(rbLaki);
        rbLaki.setText("Laki-laki");

        rbPerempuan.setBackground(new java.awt.Color(255, 255, 255));
        rbPerempuan.setFont(inputFont);
        bgJenisKelamin.add(rbPerempuan);
        rbPerempuan.setText("Perempuan");

        Font btnFont = new java.awt.Font("Segoe UI", 1, 12);

        btnSimpan.setBackground(new java.awt.Color(37, 99, 235));
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setFont(btnFont);
        btnSimpan.setText("Simpan");
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(245, 158, 11));
        btnUbah.setForeground(new java.awt.Color(255, 255, 255));
        btnUbah.setFont(btnFont);
        btnUbah.setText("Ubah");
        btnUbah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(220, 38, 38));
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setFont(btnFont);
        btnHapus.setText("Hapus");
        btnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(100, 116, 139));
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setFont(btnFont);
        btnReset.setText("Reset");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnCetaksemua.setBackground(new java.awt.Color(16, 185, 129));
        btnCetaksemua.setForeground(new java.awt.Color(255, 255, 255));
        btnCetaksemua.setFont(btnFont);
        btnCetaksemua.setText("Cetak Semua");
        btnCetaksemua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCetaksemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetaksemuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2)
            .addComponent(jLabel3)
            .addComponent(txtNim)
            .addComponent(jLabel4)
            .addComponent(txtNama)
            .addComponent(jLabel5)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(rbLaki)
                .addGap(25, 25, 25)
                .addComponent(rbPerempuan))
            .addComponent(jLabel6)
            .addComponent(txtProdi)
            .addComponent(jLabel7)
            .addComponent(txtNoHp)
            .addComponent(jLabel8)
            .addComponent(txtEmail)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCetaksemua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbLaki)
                    .addComponent(rbPerempuan))
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(txtProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel7)
                .addGap(4, 4, 4)
                .addComponent(txtNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel8)
                .addGap(4, 4, 4)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetaksemua, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // Panel Tabel Data Peserta (Putih dengan Border)
        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new java.awt.Color(226, 232, 240), 1),
            BorderFactory.createEmptyBorder(15, 18, 15, 18)
        ));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16));
        jLabel9.setForeground(new java.awt.Color(30, 41, 59));
        jLabel9.setText("Daftar Peserta Terdaftar");

        jLabel10.setFont(labelFont);
        jLabel10.setForeground(labelColor);
        jLabel10.setText("Cari Data:");

        txtCari.setFont(inputFont);

        btnCari.setBackground(new java.awt.Color(30, 41, 59));
        btnCari.setForeground(new java.awt.Color(255, 255, 255));
        btnCari.setFont(btnFont);
        btnCari.setText("Cari");
        btnCari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tblPeserta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "NIM", "Nama", "JK", "Prodi", "No. HP", "Email"}
        ));
        tblPeserta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesertaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPeserta);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
        );

        // Layout Utama (Side-by-Side: Form di Kiri, Tabel di Kanan)
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void tblPesertaMouseClicked(java.awt.event.MouseEvent evt) {
        int row = tblPeserta.getSelectedRow();
        if (row == -1) {
            return;
        }

        selectedId = Integer.parseInt(tblPeserta.getValueAt(row, 0).toString());
        txtNim.setText(tblPeserta.getValueAt(row, 1).toString());
        txtNama.setText(tblPeserta.getValueAt(row, 2).toString());

        String jk = tblPeserta.getValueAt(row, 3).toString();
        rbLaki.setSelected("L".equalsIgnoreCase(jk) || "Laki-laki".equalsIgnoreCase(jk));
        rbPerempuan.setSelected("P".equalsIgnoreCase(jk) || "Perempuan".equalsIgnoreCase(jk));

        txtProdi.setText(tblPeserta.getValueAt(row, 4).toString());
        txtNoHp.setText(tblPeserta.getValueAt(row, 5).toString());
        txtEmail.setText(tblPeserta.getValueAt(row, 6).toString());

        btnUbah.setEnabled(true);
        btnHapus.setEnabled(true);
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        if (!validateForm()) {
            return;
        }
        try {
            Peserta p = getFormData();
            if (dao.insert(p)) {
                JOptionPane.showMessageDialog(
                    this,
                    "Data peserta berhasil disimpan."
                );
                refreshData();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Gagal menyimpan data: " + ex.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedId <= 0) {
            JOptionPane.showMessageDialog(
                this,
                "Pilih data peserta pada tabel terlebih dahulu."
            );
            return;
        }
        if (!validateForm()) {
            return;
        }
        try {
            Peserta p = getFormData();
            if (dao.update(p)) {
                JOptionPane.showMessageDialog(
                    this,
                    "Data peserta berhasil diubah."
                );
                refreshData();
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Data tidak ditemukan atau tidak berubah."
                );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Gagal mengubah data: " + ex.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedId <= 0) {
            JOptionPane.showMessageDialog(
                this,
                "Pilih data peserta yang akan dihapus."
            );
            return;
        }

        String nama = txtNama.getText().trim();
        int jawab = JOptionPane.showConfirmDialog(
            this,
            "Yakin menghapus peserta: " + nama + "?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (jawab != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            if (dao.delete(selectedId)) {
                JOptionPane.showMessageDialog(
                    this,
                    "Data peserta berhasil dihapus."
                );
                refreshData();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Gagal menghapus data: " + ex.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {
        txtCari.setText("");
        loadTable();
        clearForm();
    }

    private void btnCetaksemuaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            List<Peserta> list = dao.findAll();
            fillTable(list);
            System.out.println("=== DAFTAR SEMUA PESERTA ===");
            for (Peserta p : list) {
                System.out.println(p.getId() + " | " + p.getNim() + " | " + p.getNama() + " | " + p.getProdi());
            }
            JOptionPane.showMessageDialog(this, "Seluruh data peserta (" + list.size() + " baris) berhasil ditampilkan.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Gagal memuat data: " + ex.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {
        String keyword = txtCari.getText().trim();
        try {
            if (keyword.isEmpty()) {
                loadTable();
            } else {
                fillTable(dao.search(keyword));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Pencarian gagal: " + ex.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(PesertaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesertaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.ButtonGroup bgJenisKelamin;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCetaksemua;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTable tblPeserta;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNim;
    private javax.swing.JTextField txtNoHp;
    private javax.swing.JTextField txtProdi;
    // End of variables declaration
}