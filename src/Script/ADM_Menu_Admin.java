/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Script;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
/**
 *
 * @author asus
 */
public class ADM_Menu_Admin extends javax.swing.JFrame {
    public ADM_Daftar_Pesanan daftar_pesan = new ADM_Daftar_Pesanan();
    public ADM_Daftar_Produk daftar_produk = new ADM_Daftar_Produk();
    public ADM_Daftar_Customer daftar_customer = new ADM_Daftar_Customer();
    
    private CardLayout cardLayout;
    
    /**
     * Creates new form Menu
     */
    
    public ADM_Menu_Admin() {
        initComponents();
        this.setLocation(300,150);
        
        cardLayout = (CardLayout) content.getLayout();
        
        daftar_pesan.loadData();
        content.add(daftar_pesan, "daftar_pesan");
       
        daftar_produk.loadData();
        content.add(daftar_produk, "daftar_produk");
        
        daftar_customer.loadData();
        content.add(daftar_customer, "daftar_customer");
        
        // Blok Kode Panel Menu       
        AP_RoundedPanel menu = new AP_RoundedPanel(20);
        menu.setBackground(new Color(230,234,237));
        menu.setLayout(new BoxLayout(menu,BoxLayout.Y_AXIS));
        menu.setSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        menu.setOpaque(false);
        all_menu.add(menu);
        // Pesan Button
        AP_RoundedButton btnDaftarPesanan = new AP_RoundedButton(
            "Daftar Pesan",        // Text Button
            15,           // Border Radius
            19,          // Normal Size Font
            true,     // resize effect
            true,      // hover effect
            new Color(40, 90, 200) // hover color
        );        
        btnDaftarPesanan.setBackground( new Color(255, 255, 255));
        btnDaftarPesanan.setForeground(Color.BLACK);
        btnDaftarPesanan.setFont(new Font("Antipasto Pro Bold", Font.BOLD, 24));
        btnDaftarPesanan.setPreferredSize(new Dimension(175, 40));
        btnDaftarPesanan.setMaximumSize(new Dimension(175, 40));
        btnDaftarPesanan.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Action Button Riwayat Transaksi        
        btnDaftarPesanan.addActionListener(e ->{
            daftar_pesan.loadData();
            cardLayout.show(content, "daftar_pesan");
            }  
        );
//        
        // Riwayat Transaksi Button
        AP_RoundedButton btnDaftarProduk = new AP_RoundedButton(
            "Daftar Produk",     // Text Button
            15,                // Border Radius
            19,               // Normal Size Font
            true,          // resize effect
            true,           // hover effect
            new Color(40, 90, 200) // hover color
        );        
        btnDaftarProduk.setBackground( new Color(255, 255, 255));
        btnDaftarProduk.setForeground(Color.BLACK);
        btnDaftarProduk.setFont(new Font("Antipasto Pro Bold", Font.BOLD, 24));
        btnDaftarProduk.setPreferredSize(new Dimension(175, 40));
        btnDaftarProduk.setMaximumSize(new Dimension(175, 40));
        btnDaftarProduk.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Action Button Riwayat Transaksi        
        btnDaftarProduk.addActionListener(e ->{
                daftar_produk.loadData();
                cardLayout.show(content, "daftar_produk");
            }  
        );

        // Profil pengguna Button
        AP_RoundedButton btnDaftarCustomer = new AP_RoundedButton(
            "Daftar Customer",     // Text Button
            15,                // Border Radius
            19,               // Normal Size Font
            true,          // resize effect
            true,           // hover effect
            new Color(40, 90, 200) // hover color
        );        
        btnDaftarCustomer.setBackground( new Color(255, 255, 255));
        btnDaftarCustomer.setForeground(Color.BLACK);
        btnDaftarCustomer.setFont(new Font("Antipasto Pro Bold", Font.BOLD, 24));
        btnDaftarCustomer.setPreferredSize(new Dimension(175, 40));
        btnDaftarCustomer.setMaximumSize(new Dimension(175, 40));
        btnDaftarCustomer.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Action Button Daftar Customer       
        btnDaftarCustomer.addActionListener(e ->{
                daftar_customer.loadData();
                cardLayout.show(content, "daftar_customer");
            }  
        );
        
        // Profil pengguna Button
        AP_RoundedButton btnLogout = new AP_RoundedButton(
            "LOGOUT",     // Text Button
            15,                // Border Radius
            19,               // Normal Size Font
            true,          // resize effect
            true,           // hover effect
            new Color(40, 90, 200) // hover color
        );        
        btnLogout.setBackground( new Color(255, 255, 255));
        btnLogout.setForeground(Color.BLACK);
        btnLogout.setFont(new Font("Antipasto Pro Bold", Font.BOLD, 24));
        btnLogout.setPreferredSize(new Dimension(175, 40));
        btnLogout.setMaximumSize(new Dimension(175, 40));
        btnLogout.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Action Button Daftar Customer       
        btnLogout.addActionListener(e ->{
                logout();
            }  
        );
  
        //Penambahan Elemen Ke Dalam Panel Menu
        menu.add(btnDaftarPesanan);
        menu.add(Box.createVerticalStrut(15));
        menu.add(btnDaftarProduk);
        menu.add(Box.createVerticalStrut(15));
        menu.add(btnDaftarCustomer);
        menu.add(Box.createVerticalStrut(15));
        menu.add(btnLogout);
      
        all_menu.revalidate();
        all_menu.repaint();
        revalidate();
        repaint();
    }

    private void logout(){
        AP_Data.reset_User();
        new Form_Login().setVisible(true);
        this.dispose();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        all_menu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        beranda = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(230, 234, 237));

        all_menu.setBackground(new java.awt.Color(230, 234, 237));

        javax.swing.GroupLayout all_menuLayout = new javax.swing.GroupLayout(all_menu);
        all_menu.setLayout(all_menuLayout);
        all_menuLayout.setHorizontalGroup(
            all_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );
        all_menuLayout.setVerticalGroup(
            all_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 70, 255));

        jLabel1.setFont(new Font("Antipasto Pro Bold",Font.BOLD,42));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("WATERGO DASHBOARD ADMIN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(345, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        content.setBackground(new java.awt.Color(249, 249, 249));
        content.setLayout(new java.awt.CardLayout());

        beranda.setBackground(new java.awt.Color(61, 144, 215));

        javax.swing.GroupLayout berandaLayout = new javax.swing.GroupLayout(beranda);
        beranda.setLayout(berandaLayout);
        berandaLayout.setHorizontalGroup(
            berandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 767, Short.MAX_VALUE)
        );
        berandaLayout.setVerticalGroup(
            berandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );

        content.add(beranda, "card2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(all_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(210, Short.MAX_VALUE)
                    .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(13, 13, 13)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(all_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel all_menu;
    private javax.swing.JPanel beranda;
    public javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
