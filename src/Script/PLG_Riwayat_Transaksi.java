/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Script;

import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author asus
 */
public class PLG_Riwayat_Transaksi extends javax.swing.JPanel {
    public ResultSet rs = null;
    private String sql;
    /**
     * Creates new form Riwayat_Transaksi
     */
    public PLG_Riwayat_Transaksi() {
        initComponents();
        
//      Assign Warna Pada Status Pesanan
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if ("Selesai".equals(value)) {
                    c.setForeground(new Color(89, 172, 119));
                } else if ("Proses".equals(value)){
                    c.setForeground(new Color(244, 153, 26));
                }else if ("Batal".equals(value)){
                    c.setForeground(new Color(207, 15, 15));
                }else {
                    c.setForeground(Color.BLACK);
                }
                return c;
            }
        };
        tableContainer.getColumnModel().getColumn(6).setCellRenderer(renderer);
    }

//  Metode Menampilkan Data Ke Tabel
    public void loadData(){
        DefaultTableModel model = (DefaultTableModel) tableContainer.getModel();
        model.setRowCount(0);
        String id_user = AP_Data.id_user; 

        //Query SQL Untuk Mengambil Data        
        sql = "SELECT * FROM pesanan WHERE id_pelanggan = ? ORDER BY id_pesanan DESC";
        try (PreparedStatement ps = AP_Database.con.prepareStatement(sql))
        {
            ps.setString(1, id_user);
            rs = ps.executeQuery();

            // Blok Menambahkan Value Ke Tabel 
            while (rs.next()) 
            {
                model.addRow(new Object[]{
                    rs.getString("id_pesanan"),
                    rs.getString("tanggal_pesan"),
                    rs.getString("alamat_kirim"),
                    rs.getString("catatan"),
                    rs.getString("metode_bayar"),
                    String.valueOf("Rp. " + rs.getInt("total_harga")),
                    rs.getString("status")
                });
            }
           //perintah untuk eksekusi sql 
            }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
//  Metode Pencarian Data
    public void cariData(String key){
        DefaultTableModel model = (DefaultTableModel) tableContainer.getModel();
        model.setRowCount(0);

        //Query SQL Untuk Pencarian Data        
        sql = "SELECT * FROM pesanan WHERE id_pelanggan = ? AND (id_pesanan LIKE ? OR tanggal_pesan LIKE ? OR alamat_kirim LIKE ? OR catatan LIKE ? OR metode_bayar LIKE ? OR total_harga LIKE ? OR status LIKE ?) ";
        try(PreparedStatement ps = AP_Database.con.prepareStatement(sql))
        {
            //ASsign Value Pencarian Ke Sql
            String cari_value = "%" + key + "%";
            ps.setString(1, AP_Data.id_user);
            ps.setString(2, cari_value);
            ps.setString(3, cari_value);
            ps.setString(4, cari_value);
            ps.setString(5, cari_value);
            ps.setString(6, cari_value);
            ps.setString(7, cari_value);
            ps.setString(8, cari_value);
            rs = ps.executeQuery();
            
            // Blok Menambahkan Value Ke Tabel 
            while (rs.next()) 
            {
                model.addRow(new Object[]{
                    rs.getString("id_pesanan"),
                    rs.getString("tanggal_pesan"),
                    rs.getString("alamat_kirim"),
                    rs.getString("catatan"),
                    rs.getString("metode_bayar"),
                    String.valueOf("Rp. " + rs.getInt("total_harga")),
                    rs.getString("status")
                });
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void batal(){
        int row = tableContainer.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih pesanan dulu");
            return;
        }

        String id_pesanan = tableContainer.getValueAt(row, 0).toString();
        String status = tableContainer.getValueAt(row, 6).toString();
        if(status.equals("Selesai") || status.equals("Batal")){return;}
        
        sql = "UPDATE pesanan SET status = 'Batal' WHERE id_pesanan = ?";
        try (PreparedStatement ps = AP_Database.con.prepareStatement(sql))
        {
            ps.setString(1, id_pesanan);
            ps.executeUpdate();            
            loadData();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableContainer = new javax.swing.JTable();
        cari = new javax.swing.JButton();
        batal = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tableContainer.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        tableContainer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Pesanan", "Tanggal Pesan", "Alamat Kirim", "Catatan", "Pembayaran", "Total Harga", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableContainer.setRowHeight(30);
        tableContainer.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableContainer);
        if (tableContainer.getColumnModel().getColumnCount() > 0) {
            tableContainer.getColumnModel().getColumn(0).setResizable(false);
            tableContainer.getColumnModel().getColumn(1).setResizable(false);
            tableContainer.getColumnModel().getColumn(2).setResizable(false);
            tableContainer.getColumnModel().getColumn(3).setResizable(false);
            tableContainer.getColumnModel().getColumn(4).setResizable(false);
            tableContainer.getColumnModel().getColumn(5).setResizable(false);
            tableContainer.getColumnModel().getColumn(6).setResizable(false);
        }

        cari.setBackground(new java.awt.Color(40, 90, 200));
        cari.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cari.setForeground(new java.awt.Color(255, 255, 255));
        cari.setText("Cari");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        batal.setBackground(new java.awt.Color(225, 2, 2));
        batal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        batal.setForeground(new java.awt.Color(255, 255, 255));
        batal.setText("Batalkan");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

//  Fitur Pencarian
    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
        String cari_value = JOptionPane.showInputDialog(this, "Cari Data:");

        if (cari_value != null && !cari_value.trim().isEmpty()) {
            cariData(cari_value);
        } 
    }//GEN-LAST:event_cariActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_batalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batal;
    private javax.swing.JButton cari;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableContainer;
    // End of variables declaration//GEN-END:variables
}
