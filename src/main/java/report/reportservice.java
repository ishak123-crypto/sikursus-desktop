package report;

import config.Database;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class reportservice {

    public static void tampilkanLaporanPeserta() {
        try (Connection conn = Database.getConnection()) {
            InputStream in = reportservice.class.getResourceAsStream(
                    "/report/laporan_peserta_1.jasper"
            );
            if (in == null) {
                throw new IllegalStateException(
                        "File laporan_peserta_1.jasper tidak ditemukan di /report/."
                );
            }
            JasperPrint print = JasperFillManager.fillReport(
                    in,
                    new HashMap<String, Object>(),
                    conn
            );
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Gagal membuka laporan: " + e.getMessage(),
                    "Laporan Peserta",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}