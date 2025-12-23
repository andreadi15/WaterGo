/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Script;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import java.awt.Font;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.Date;

/**
 *
 * @author asus
 */
public class Panel_Profil extends javax.swing.JPanel {
//    public ResultSet rs;
//    private List<AP_ProductCard> cards = new ArrayList<>();
//    public static Map<String, Map<String, Object>> cart = new HashMap<>();
    public static Menu_Customer menu_customer;
    private AP_RoundedButton btnSimpan;
    private String nama_user;
    private String password_value;
    private String no_telp;
    private String alamat_user;
    
    /**
     * Creates new form Panel_Produk
     */
    
    public void loadData(){
        String sql = "SELECT * FROM pelanggan WHERE id_user = ?";
        try (PreparedStatement ps = AP_Database.con.prepareStatement(sql)) {
            ps.setString(1, AP_Data.id_user);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String username_value = rs.getString("username");      
                password_value = rs.getString("password");                                
                nama_user = rs.getString("nama");
                no_telp = rs.getString("telepon");                
                alamat_user = rs.getString("alamat");

                if(!nama_user.equals(AP_Data.nama_user) || 
                   !alamat_user.equals(AP_Data.alamat) || 
                   !no_telp.equals(AP_Data.no_telp)) 
                {
                    AP_Data.reset_User();
                    new Form_Login().show();
                    menu_customer.dispose();   
                } 
                else
                {
                    nama.setText(nama_user);
                    username.setText(username_value);
                    password.setText(password_value);
                    no_hp.setText(no_telp);
                    alamat.setText(alamat_user);
                }                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // HANDLE PROSES PESANAN
    private void SaveData(){
//        Memastikan Form Diisi Semua dan Tidak Ada Yang Kosong
        if (nama.getText().trim().isEmpty() ||
            password.getText().trim().isEmpty() ||
            no_hp.getText().trim().isEmpty() ||
            alamat.getText().trim().isEmpty()) {
            return;
        }      
        
        String sql = "UPDATE pelanggan" +  
                    "SET " + 
                    "nama = ?," + 
                    "password = ?," + 
                    "telepon = ?," + 
                    "alamat = ?," + 
                    "updated_at = ? " + 
                    "WHERE id_user = ?";
        
        try (PreparedStatement ps = AP_Database.con.prepareStatement(sql)) {
            ps.setString(1, nama.getText());
            ps.setString(2, password.getText());
            ps.setString(3, no_hp.getText());
            ps.setString(4, alamat.getText());
            ps.setDate(5, Date.valueOf(LocalDate.now()));
            ps.setString(6, AP_Data.id_user);                       
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        
        AP_Data.update_User(nama.getText(), no_hp.getText(),alamat.getText());
        btnSimpan.setVisible(false);
    }
    
    private void selesaiEdit(JTextField inp) {
        if (!inp.isEditable()) return;
        setFocusable(true);
        requestFocusInWindow();
        inp.setEditable(false);

        if (!nama.getText().equals(nama_user) || 
            !password.getText().equals(password_value) ||
            !no_hp.getText().equals(no_telp) ||
            !alamat.getText().equals(alamat_user)){return;}
        
        btnSimpan.setVisible(true);
    }

    private void setInputListener(JTextField inp){
        inp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    inp.setEditable(true);
                    inp.requestFocusInWindow();
                    inp.selectAll();
                }
            }
        });
        
        inp.addActionListener(e -> {
            selesaiEdit(inp);
        });
        
        inp.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                selesaiEdit(inp);
            }
        });
    }
    
    public Panel_Profil(Menu_Customer menu) {
        initComponents();
        setInputListener(nama);
        setInputListener(password);
        setInputListener(no_hp);
        setInputListener(alamat);

        // ================= CONTAINER MERAH =================
        // ============ TOMBOL SIMPAN ===============
        btnSimpan = new AP_RoundedButton("Simpan",30,24);
        btnSimpan.setBackground( new Color(40, 90, 200));
        btnSimpan.setForeground(Color.WHITE);
        btnSimpan.setFont(new Font("Antipasto Pro Bold", Font.BOLD, 24));
        btnSimpan.setSize(240, 40);
        btnSimpan.setLocation(20, 10);
        btnSimpan.setFocusPainted(false);
        btnSimpan.addActionListener(e -> SaveData());
        btnSimpan.setVisible(false);
        panelBottom.add(btnSimpan);
        
        Panel_Profil.menu_customer = menu;
        revalidate();
        repaint();
    }

 
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        titlr = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        no_hp = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        panelBottom = new javax.swing.JPanel();

        setBackground(new java.awt.Color(230, 234, 237));

        titlr.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titlr.setText("Profil Customer");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(titlr)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(titlr)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Nama");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Password");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("No HP");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Alamat");

        nama.setEditable(false);

        username.setEditable(false);

        password.setEditable(false);

        no_hp.setEditable(false);

        alamat.setEditable(false);

        javax.swing.GroupLayout panelBottomLayout = new javax.swing.GroupLayout(panelBottom);
        panelBottom.setLayout(panelBottomLayout);
        panelBottomLayout.setHorizontalGroup(
            panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBottomLayout.setVerticalGroup(
            panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(no_hp, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(288, Short.MAX_VALUE))
            .addComponent(panelBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(no_hp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(panelBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField no_hp;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JTextField password;
    private javax.swing.JLabel titlr;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
