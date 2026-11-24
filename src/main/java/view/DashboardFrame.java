package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import model.User;
import util.UserSession;
import util.WindowManager;

public class DashboardFrame extends javax.swing.JFrame {

    private boolean isAdmin = false;

    public DashboardFrame() {
        initComponents();
        setLocationRelativeTo(null);
        loadMenuIcons();
        applySession();
    }

    private void applySession() {
        User user = UserSession.getCurrentUser();
        if (user == null) {
            JOptionPane.showMessageDialog(this,
                    "Session tidak ditemukan. Silakan login ulang.");
            dispose();
            SwingUtilities.invokeLater(
                    () -> new LoginFrame().setVisible(true));
            return;
        }
        isAdmin = user.isAdmin();
        lblUser.setText(user.getUsername());
        lblRoleBadge.setText(user.getRole());
        lblSelamatDatang.setText("Selamat Datang, " + user.getUsername() + "!");

        String modeText = isAdmin
                ? "Akses Cepat Modul (Mode Administrator - Akses Penuh)"
                : "Akses Cepat Modul (Mode Operator - Akses Terbatas)";
        lblSectionTitle.setText(modeText);

        miPeserta.setEnabled(true);
        miInstruktur.setEnabled(isAdmin);
        miKursus.setEnabled(isAdmin);
        miKelas.setEnabled(isAdmin);
        menuTransaksi.setEnabled(true);
        menuLaporan.setEnabled(true);
        miManajemenUser.setEnabled(isAdmin);

        setCardEnabled(cardPeserta, lblCardPesertaTitle, lblCardPesertaDesc, true);
        setCardEnabled(cardInstruktur, lblCardInstrukturTitle, lblCardInstrukturDesc, isAdmin);
        setCardEnabled(cardKursus, lblCardKursusTitle, lblCardKursusDesc, isAdmin);
        setCardEnabled(cardKelas, lblCardKelasTitle, lblCardKelasDesc, isAdmin);
        setCardEnabled(cardPendaftaran, lblCardPendaftaranTitle, lblCardPendaftaranDesc, true);
        setCardEnabled(cardPembayaran, lblCardPembayaranTitle, lblCardPembayaranDesc, true);
    }

    private void setCardEnabled(JPanel card, JLabel title, JLabel desc, boolean enabled) {
        card.setEnabled(enabled);
        card.setBackground(enabled ? Color.WHITE : new Color(248, 250, 252));
        card.setCursor(Cursor.getPredefinedCursor(enabled ? Cursor.HAND_CURSOR : Cursor.DEFAULT_CURSOR));
        title.setForeground(enabled ? new Color(15, 23, 42) : new Color(148, 163, 184));
        desc.setForeground(enabled ? new Color(100, 116, 139) : new Color(148, 163, 184));
    }

    private JPanel createModuleCard(String category, String title, String description,
            final JLabel outTitle, final JLabel outDesc, final Runnable onClickAction) {
        final JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(new CompoundBorder(
                new LineBorder(new Color(226, 232, 240), 1, true),
                new EmptyBorder(18, 20, 18, 20)
        ));
        card.setComponentPopupMenu(popupDashboard);

        JPanel topRow = new JPanel(new BorderLayout());
        topRow.setOpaque(false);
        topRow.setAlignmentX(LEFT_ALIGNMENT);

        JLabel lblCat = new JLabel(category.toUpperCase());
        lblCat.setFont(new Font("Segoe UI", Font.BOLD, 10));
        lblCat.setForeground(new Color(37, 99, 235));

        JLabel lblArrow = new JLabel("\u2192");
        lblArrow.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblArrow.setForeground(new Color(148, 163, 184));

        topRow.add(lblCat, BorderLayout.WEST);
        topRow.add(lblArrow, BorderLayout.EAST);

        outTitle.setText(title);
        outTitle.setFont(new Font("Segoe UI", Font.BOLD, 15));
        outTitle.setForeground(new Color(15, 23, 42));
        outTitle.setAlignmentX(LEFT_ALIGNMENT);

        outDesc.setText(description);
        outDesc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        outDesc.setForeground(new Color(100, 116, 139));
        outDesc.setAlignmentX(LEFT_ALIGNMENT);

        card.add(topRow);
        card.add(Box.createRigidArea(new Dimension(0, 8)));
        card.add(outTitle);
        card.add(Box.createRigidArea(new Dimension(0, 4)));
        card.add(outDesc);

        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e) && card.isEnabled()) {
                    onClickAction.run();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (card.isEnabled()) {
                    card.setBackground(new Color(248, 250, 252));
                    card.setBorder(new CompoundBorder(
                            new LineBorder(new Color(148, 163, 184), 1, true),
                            new EmptyBorder(18, 20, 18, 20)
                    ));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (card.isEnabled()) {
                    card.setBackground(Color.WHITE);
                    card.setBorder(new CompoundBorder(
                            new LineBorder(new Color(226, 232, 240), 1, true),
                            new EmptyBorder(18, 20, 18, 20)
                    ));
                }
            }
        });

        return card;
    }

    private ImageIcon loadIcon(String path) {
        URL url = getClass().getResource(path);
        return url == null ? null : new ImageIcon(url);
    }

    private void loadMenuIcons() {
        miPeserta.setIcon(loadIcon("/icons/peserta.png"));
        miInstruktur.setIcon(loadIcon("/icons/instruktur.png"));
        miKursus.setIcon(loadIcon("/icons/kursus.png"));
        miKelas.setIcon(loadIcon("/icons/kelas.png"));
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        popupDashboard = new javax.swing.JPopupMenu();
        miPopupPeserta = new javax.swing.JMenuItem();
        miPopupPendaftaran = new javax.swing.JMenuItem();
        sepPopup = new javax.swing.JPopupMenu.Separator();
        miRefresh = new javax.swing.JMenuItem();
        miTentang = new javax.swing.JMenuItem();

        panelUtama = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        panelStatus = new javax.swing.JPanel();
        lblUserLabel = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblRoleBadge = new javax.swing.JLabel();
        btnLogoutHeader = new javax.swing.JButton();

        panelBody = new javax.swing.JPanel();
        panelWelcome = new javax.swing.JPanel();
        lblSelamatDatang = new javax.swing.JLabel();
        lblDeskripsi = new javax.swing.JLabel();

        lblSectionTitle = new javax.swing.JLabel();
        panelGridCards = new javax.swing.JPanel();

        lblCardPesertaTitle = new JLabel();
        lblCardPesertaDesc = new JLabel();
        lblCardInstrukturTitle = new JLabel();
        lblCardInstrukturDesc = new JLabel();
        lblCardKursusTitle = new JLabel();
        lblCardKursusDesc = new JLabel();
        lblCardKelasTitle = new JLabel();
        lblCardKelasDesc = new JLabel();
        lblCardPendaftaranTitle = new JLabel();
        lblCardPendaftaranDesc = new JLabel();
        lblCardPembayaranTitle = new JLabel();
        lblCardPembayaranDesc = new JLabel();

        lblFooterTip = new javax.swing.JLabel();

        menuBarUtama = new javax.swing.JMenuBar();
        menuMaster = new javax.swing.JMenu();
        miPeserta = new javax.swing.JMenuItem();
        miInstruktur = new javax.swing.JMenuItem();
        miKursus = new javax.swing.JMenuItem();
        miKelas = new javax.swing.JMenuItem();

        menuTransaksi = new javax.swing.JMenu();
        miPendaftaran = new javax.swing.JMenuItem();
        miPembayaran = new javax.swing.JMenuItem();

        menuLaporan = new javax.swing.JMenu();
        miLaporanPeserta = new javax.swing.JMenuItem();
        miLaporanPendaftaran = new javax.swing.JMenuItem();

        menuSistem = new javax.swing.JMenu();
        miManajemenUser = new javax.swing.JMenuItem();
        sepSistem = new javax.swing.JPopupMenu.Separator();
        miLogout = new javax.swing.JMenuItem();
        miTutup = new javax.swing.JMenuItem();

        miPopupPeserta.setText("Buka Data Peserta");
        miPopupPeserta.addActionListener(e -> miPesertaActionPerformed(e));
        popupDashboard.add(miPopupPeserta);

        miPopupPendaftaran.setText("Buka Pendaftaran");
        miPopupPendaftaran.addActionListener(e -> miPendaftaranActionPerformed(e));
        popupDashboard.add(miPopupPendaftaran);

        popupDashboard.add(sepPopup);

        miRefresh.setText("Refresh Session");
        miRefresh.addActionListener(e -> miRefreshActionPerformed(e));
        popupDashboard.add(miRefresh);

        miTentang.setText("Tentang Aplikasi");
        miTentang.addActionListener(e -> miTentangActionPerformed(e));
        popupDashboard.add(miTentang);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard - SIKURSUS DESKTOP");
        setMinimumSize(new Dimension(820, 560));
        setPreferredSize(new Dimension(920, 620));

        panelUtama.setBackground(new Color(248, 250, 252));
        panelUtama.setComponentPopupMenu(popupDashboard);
        panelUtama.setLayout(new BorderLayout());

        // Header Bar
        panelHeader.setBackground(Color.WHITE);
        panelHeader.setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(226, 232, 240)),
                new EmptyBorder(12, 28, 12, 28)
        ));
        panelHeader.setComponentPopupMenu(popupDashboard);
        panelHeader.setLayout(new BorderLayout());

        lblJudul.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblJudul.setForeground(new Color(29, 78, 216));
        lblJudul.setText("SIKURSUS DESKTOP");
        panelHeader.add(lblJudul, BorderLayout.WEST);

        panelStatus.setOpaque(false);
        panelStatus.setLayout(new BoxLayout(panelStatus, BoxLayout.X_AXIS));

        lblUserLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblUserLabel.setForeground(new Color(100, 116, 139));
        lblUserLabel.setText("User: ");

        lblUser.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblUser.setForeground(new Color(15, 23, 42));
        lblUser.setText("admin");

        lblRoleBadge.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblRoleBadge.setForeground(new Color(37, 99, 235));
        lblRoleBadge.setBackground(new Color(239, 246, 255));
        lblRoleBadge.setOpaque(true);
        lblRoleBadge.setBorder(new CompoundBorder(
                new LineBorder(new Color(191, 219, 254), 1, true),
                new EmptyBorder(2, 8, 2, 8)
        ));
        lblRoleBadge.setText("ADMIN");

        btnLogoutHeader.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnLogoutHeader.setForeground(new Color(220, 38, 38));
        btnLogoutHeader.setBackground(Color.WHITE);
        btnLogoutHeader.setText("Logout");
        btnLogoutHeader.setFocusPainted(false);
        btnLogoutHeader.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLogoutHeader.setBorder(new CompoundBorder(
                new LineBorder(new Color(254, 202, 202), 1, true),
                new EmptyBorder(4, 12, 4, 12)
        ));
        btnLogoutHeader.addActionListener(e -> miLogoutActionPerformed(e));

        panelStatus.add(lblUserLabel);
        panelStatus.add(lblUser);
        panelStatus.add(Box.createRigidArea(new Dimension(10, 0)));
        panelStatus.add(lblRoleBadge);
        panelStatus.add(Box.createRigidArea(new Dimension(14, 0)));
        panelStatus.add(btnLogoutHeader);

        panelHeader.add(panelStatus, BorderLayout.EAST);
        panelUtama.add(panelHeader, BorderLayout.NORTH);

        // Main Content Body
        panelBody.setBackground(new Color(248, 250, 252));
        panelBody.setBorder(new EmptyBorder(24, 28, 20, 28));
        panelBody.setComponentPopupMenu(popupDashboard);
        panelBody.setLayout(new BorderLayout(0, 18));

        panelWelcome.setOpaque(false);
        panelWelcome.setLayout(new BoxLayout(panelWelcome, BoxLayout.Y_AXIS));
        panelWelcome.setComponentPopupMenu(popupDashboard);

        lblSelamatDatang.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblSelamatDatang.setForeground(new Color(15, 23, 42));
        lblSelamatDatang.setText("Selamat Datang, admin!");
        lblSelamatDatang.setAlignmentX(LEFT_ALIGNMENT);

        lblDeskripsi.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblDeskripsi.setForeground(new Color(100, 116, 139));
        lblDeskripsi.setText("Kelola data peserta, instruktur, kursus, jadwal kelas, dan transaksi pelatihan melalui satu panel terpadu.");
        lblDeskripsi.setAlignmentX(LEFT_ALIGNMENT);

        panelWelcome.add(lblSelamatDatang);
        panelWelcome.add(Box.createRigidArea(new Dimension(0, 6)));
        panelWelcome.add(lblDeskripsi);
        panelBody.add(panelWelcome, BorderLayout.NORTH);

        JPanel panelCenterContent = new JPanel(new BorderLayout(0, 12));
        panelCenterContent.setOpaque(false);
        panelCenterContent.setComponentPopupMenu(popupDashboard);

        lblSectionTitle.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblSectionTitle.setForeground(new Color(30, 41, 59));
        lblSectionTitle.setText("Akses Cepat Modul (Mode Administrator - Akses Penuh)");
        panelCenterContent.add(lblSectionTitle, BorderLayout.NORTH);

        panelGridCards.setOpaque(false);
        panelGridCards.setLayout(new GridLayout(3, 2, 16, 16));
        panelGridCards.setComponentPopupMenu(popupDashboard);

        cardPeserta = createModuleCard(
                "Peserta", "Data Peserta", "Kelola biodata & riwayat peserta",
                lblCardPesertaTitle, lblCardPesertaDesc,
                () -> WindowManager.open(PesertaFrame.class, PesertaFrame::new)
        );
        cardInstruktur = createModuleCard(
                "Instruktur", "Data Instruktur", "Manajemen pengajar & keahlian",
                lblCardInstrukturTitle, lblCardInstrukturDesc,
                () -> WindowManager.open(InstrukturFrame.class, InstrukturFrame::new)
        );
        cardKursus = createModuleCard(
                "Kursus", "Program Kursus", "Daftar materi, kurikulum & biaya",
                lblCardKursusTitle, lblCardKursusDesc,
                () -> WindowManager.open(KursusFrame.class, KursusFrame::new)
        );
        cardKelas = createModuleCard(
                "Kelas", "Jadwal Kelas", "Atur ruang, kuota & jadwal",
                lblCardKelasTitle, lblCardKelasDesc,
                () -> WindowManager.open(KelasFrame.class, KelasFrame::new)
        );
        cardPendaftaran = createModuleCard(
                "Transaksi", "Pendaftaran", "Registrasi peserta ke kelas baru",
                lblCardPendaftaranTitle, lblCardPendaftaranDesc,
                () -> miPendaftaranActionPerformed(null)
        );
        cardPembayaran = createModuleCard(
                "Keuangan", "Pembayaran", "Verifikasi tagihan & bukti bayar",
                lblCardPembayaranTitle, lblCardPembayaranDesc,
                () -> miPembayaranActionPerformed(null)
        );

        panelGridCards.add(cardPeserta);
        panelGridCards.add(cardInstruktur);
        panelGridCards.add(cardKursus);
        panelGridCards.add(cardKelas);
        panelGridCards.add(cardPendaftaran);
        panelGridCards.add(cardPembayaran);

        panelCenterContent.add(panelGridCards, BorderLayout.CENTER);
        panelBody.add(panelCenterContent, BorderLayout.CENTER);

        lblFooterTip.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        lblFooterTip.setForeground(new Color(148, 163, 184));
        lblFooterTip.setText("Tips: Klik kartu di atas untuk membuka modul, atau klik kanan di area kosong untuk menu pintasan.");
        panelBody.add(lblFooterTip, BorderLayout.SOUTH);

        panelUtama.add(panelBody, BorderLayout.CENTER);

        // Menu Bar (Master Data, Transaksi, Laporan, Sistem)
        menuBarUtama.setBackground(Color.WHITE);
        menuBarUtama.setOpaque(true);
        menuBarUtama.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(226, 232, 240)));

        menuMaster.setText("Master Data");
        menuMaster.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        miPeserta.setText("Data Peserta");
        miPeserta.addActionListener(e -> miPesertaActionPerformed(e));
        menuMaster.add(miPeserta);

        miInstruktur.setText("Data Instruktur");
        miInstruktur.addActionListener(e -> miInstrukturActionPerformed(e));
        menuMaster.add(miInstruktur);

        miKursus.setText("Program Kursus");
        miKursus.addActionListener(e -> miKursusActionPerformed(e));
        menuMaster.add(miKursus);

        miKelas.setText("Jadwal Kelas");
        miKelas.addActionListener(e -> miKelasActionPerformed(e));
        menuMaster.add(miKelas);
        menuBarUtama.add(menuMaster);

        menuTransaksi.setText("Transaksi");
        menuTransaksi.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        miPendaftaran.setText("Pendaftaran");
        miPendaftaran.addActionListener(e -> miPendaftaranActionPerformed(e));
        menuTransaksi.add(miPendaftaran);

        miPembayaran.setText("Pembayaran");
        miPembayaran.addActionListener(e -> miPembayaranActionPerformed(e));
        menuTransaksi.add(miPembayaran);
        menuBarUtama.add(menuTransaksi);

        menuLaporan.setText("Laporan");
        menuLaporan.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        miLaporanPeserta.setText("Laporan Peserta");
        miLaporanPeserta.addActionListener(e -> miLaporanPesertaActionPerformed(e));
        menuLaporan.add(miLaporanPeserta);

        miLaporanPendaftaran.setText("Laporan Pendaftaran");
        miLaporanPendaftaran.addActionListener(e -> miLaporanPendaftaranActionPerformed(e));
        menuLaporan.add(miLaporanPendaftaran);
        menuBarUtama.add(menuLaporan);

        menuSistem.setText("Sistem");
        menuSistem.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        miManajemenUser.setText("Manajemen User");
        miManajemenUser.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Modul Manajemen User sedang dikembangkan pada tahap project berikutnya."));
        menuSistem.add(miManajemenUser);
        menuSistem.add(sepSistem);

        miLogout.setText("Logout");
        miLogout.addActionListener(e -> miLogoutActionPerformed(e));
        menuSistem.add(miLogout);

        miTutup.setText("Tutup Aplikasi");
        miTutup.addActionListener(e -> miTutupActionPerformed(e));
        menuSistem.add(miTutup);
        menuBarUtama.add(menuSistem);

        setJMenuBar(menuBarUtama);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelUtama, BorderLayout.CENTER);

        pack();
    }

    private void miPesertaActionPerformed(java.awt.event.ActionEvent evt) {
        WindowManager.open(PesertaFrame.class, PesertaFrame::new);
    }

    private void miInstrukturActionPerformed(java.awt.event.ActionEvent evt) {
        if (!isAdmin) {
            JOptionPane.showMessageDialog(this, "Akses menu Instruktur hanya untuk ADMIN.");
            return;
        }
        WindowManager.open(InstrukturFrame.class, InstrukturFrame::new);
    }

    private void miKursusActionPerformed(java.awt.event.ActionEvent evt) {
        if (!isAdmin) {
            JOptionPane.showMessageDialog(this, "Akses menu Kursus hanya untuk ADMIN.");
            return;
        }
        WindowManager.open(KursusFrame.class, KursusFrame::new);
    }

    private void miKelasActionPerformed(java.awt.event.ActionEvent evt) {
        if (!isAdmin) {
            JOptionPane.showMessageDialog(this, "Akses menu Kelas hanya untuk ADMIN.");
            return;
        }
        WindowManager.open(KelasFrame.class, KelasFrame::new);
    }

    private void miPendaftaranActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this,
                "Modul Pendaftaran sedang dikembangkan pada tahap project berikutnya.");
    }

    private void miPembayaranActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this,
                "Modul Pembayaran sedang dikembangkan pada tahap project berikutnya.");
    }

    private void miLaporanPesertaActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this,
                "Modul laporan diaktifkan pada Pertemuan 12 dengan Jaspersoft Studio.");
    }

    private void miLaporanPendaftaranActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this,
                "Modul laporan diaktifkan pada Pertemuan 12 dengan Jaspersoft Studio.");
    }

    private void miLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        int pilihan = JOptionPane.showConfirmDialog(this,
                "Logout dari aplikasi?",
                "Konfirmasi Logout",
                JOptionPane.YES_NO_OPTION);
        if (pilihan == JOptionPane.YES_OPTION) {
            WindowManager.closeAll();
            UserSession.clear();
            dispose();
            SwingUtilities.invokeLater(
                    () -> new LoginFrame().setVisible(true));
        }
    }

    private void miTutupActionPerformed(java.awt.event.ActionEvent evt) {
        int pilihan = JOptionPane.showConfirmDialog(this,
                "Tutup aplikasi SIKURSUS?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION);
        if (pilihan == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void miTentangActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this,
                "SIKURSUS Desktop\nProject PBO Program Studi Informatika");
    }

    private void miRefreshActionPerformed(java.awt.event.ActionEvent evt) {
        applySession();
        JOptionPane.showMessageDialog(this, "Session dan tampilan dashboard diperbarui.");
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
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardFrame().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnLogoutHeader;
    private javax.swing.JPanel cardInstruktur;
    private javax.swing.JPanel cardKelas;
    private javax.swing.JPanel cardKursus;
    private javax.swing.JPanel cardPembayaran;
    private javax.swing.JPanel cardPendaftaran;
    private javax.swing.JPanel cardPeserta;
    private javax.swing.JLabel lblCardInstrukturDesc;
    private javax.swing.JLabel lblCardInstrukturTitle;
    private javax.swing.JLabel lblCardKelasDesc;
    private javax.swing.JLabel lblCardKelasTitle;
    private javax.swing.JLabel lblCardKursusDesc;
    private javax.swing.JLabel lblCardKursusTitle;
    private javax.swing.JLabel lblCardPembayaranDesc;
    private javax.swing.JLabel lblCardPembayaranTitle;
    private javax.swing.JLabel lblCardPendaftaranDesc;
    private javax.swing.JLabel lblCardPendaftaranTitle;
    private javax.swing.JLabel lblCardPesertaDesc;
    private javax.swing.JLabel lblCardPesertaTitle;
    private javax.swing.JLabel lblDeskripsi;
    private javax.swing.JLabel lblFooterTip;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JLabel lblRoleBadge;
    private javax.swing.JLabel lblSectionTitle;
    private javax.swing.JLabel lblSelamatDatang;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUserLabel;
    private javax.swing.JMenuBar menuBarUtama;
    private javax.swing.JMenu menuLaporan;
    private javax.swing.JMenu menuMaster;
    private javax.swing.JMenu menuSistem;
    private javax.swing.JMenu menuTransaksi;
    private javax.swing.JMenuItem miInstruktur;
    private javax.swing.JMenuItem miKelas;
    private javax.swing.JMenuItem miKursus;
    private javax.swing.JMenuItem miLaporanPendaftaran;
    private javax.swing.JMenuItem miLaporanPeserta;
    private javax.swing.JMenuItem miLogout;
    private javax.swing.JMenuItem miManajemenUser;
    private javax.swing.JMenuItem miPembayaran;
    private javax.swing.JMenuItem miPendaftaran;
    private javax.swing.JMenuItem miPeserta;
    private javax.swing.JMenuItem miPopupPendaftaran;
    private javax.swing.JMenuItem miPopupPeserta;
    private javax.swing.JMenuItem miRefresh;
    private javax.swing.JMenuItem miTentang;
    private javax.swing.JMenuItem miTutup;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelGridCards;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelStatus;
    private javax.swing.JPanel panelUtama;
    private javax.swing.JPanel panelWelcome;
    private javax.swing.JPopupMenu popupDashboard;
    private javax.swing.JPopupMenu.Separator sepPopup;
    private javax.swing.JPopupMenu.Separator sepSistem;
}
