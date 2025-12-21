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
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author asus
 */
public class Panel_Produk extends javax.swing.JPanel {
    public ResultSet rs;
    private List<AP_ProductCard> cards = new ArrayList<>();
    public static Map<String, Map<String, Object>> cart = new HashMap<>();
    public static Menu_Customer menu_customer;

    /**
     * Creates new form Panel_Produk
     * @param menu
     */
    public Panel_Produk(Menu_Customer menu) {
        initComponents();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // ================= CONTAINER MERAH =================
        AP_RoundedPanel containerMerah = new AP_RoundedPanel(25);
        containerMerah.setBackground(new Color(255, 255, 255));
        containerMerah.setLayout(new BoxLayout(containerMerah, BoxLayout.Y_AXIS));
        containerMerah.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        // ================= PANEL HIJAU =================
        JPanel panelHijau = new JPanel(new BorderLayout());
        panelHijau.setBackground(new Color(255, 255, 255));
        panelHijau.setPreferredSize(new Dimension(760, 50));
        panelHijau.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        // ================= TITLE HEADER ================
        JLabel lblJudul = new JLabel("Pilih Produk Air");
        lblJudul.setFont(new Font("Antipasto Pro Bold", Font.BOLD, 28));
        lblJudul.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        lblJudul.setHorizontalAlignment(SwingConstants.LEFT);
        panelHijau.add(lblJudul, BorderLayout.CENTER);

        // ================= PANEL BIRU ==================
        JPanel panelBiru = new JPanel();
        panelBiru.setBackground(new Color(255, 255, 255));
        panelBiru.setLayout(new GridLayout(0, 2, 30, 30));
        panelBiru.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        // ============= VALUE STYLE TAMPILAN =============
        final int CARD_HEIGHT = 180;  // tinggi ProductCard
        final int V_GAP = 30;
        final int COLUMN = 2;
        final int PANEL_PADDING = 20;

        // ============= LOAD DATA PRODUK =================
        String sql = "SELECT * FROM produk";
        int x = 0;
        try (PreparedStatement ps = AP_Database.con.prepareStatement(sql)) 
        {
            rs = ps.executeQuery();
            while (rs.next()) {
                x++;
                String idProduk = rs.getString("id_produk");
                String nama = rs.getString("nama_produk");
                int harga = rs.getInt("harga");
                AP_ProductCard card = new AP_ProductCard(
                    idProduk,
                    nama,
                    harga,
                    "Asset/produk" + x + ".svg"
                );

                // WRAPPER biar ukuran itemProduk stabil
                JPanel cardWrapper = new JPanel(new BorderLayout());
                cardWrapper.setOpaque(false);
                cardWrapper.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
                cardWrapper.add(card, BorderLayout.CENTER);

                panelBiru.add(cardWrapper);
                cards.add(card);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        // ================= HITUNG TINGGI PANEL BIRU =================
        int totalItem = cards.size();
        int row = (int) Math.ceil(totalItem / (double) COLUMN);
        int panelBiruHeight =(row * CARD_HEIGHT) + ((row - 1) * V_GAP) + PANEL_PADDING;
        panelBiru.setPreferredSize(new Dimension(760, panelBiruHeight));
        panelBiru.setMaximumSize(new Dimension(Integer.MAX_VALUE, panelBiruHeight));

        // ================= SUSUN KE CONTAINER MERAH =================
        containerMerah.add(panelHijau);
        containerMerah.add(panelBiru);
        containerMerah.setAlignmentX(Component.LEFT_ALIGNMENT);
       
        add(containerMerah);
        add(Box.createVerticalStrut(20));

        // ================= CONTAINER UNGU =================
        AP_RoundedPanel containerUngu = new AP_RoundedPanel(30);
        containerUngu.setBackground(new Color(255, 255, 255));
        containerUngu.setLayout(null);
        containerUngu.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

        // ============ TOMBOL PESAN SEKARANG ===============
        AP_RoundedButton btnPesan = new AP_RoundedButton("Pesan Sekarang",30,24);
        btnPesan.setBackground( new Color(40, 90, 200));
        btnPesan.setForeground(Color.WHITE);
        btnPesan.setFont(new Font("Antipasto Pro Bold", Font.BOLD, 24));
        btnPesan.setSize(240, 40);
        btnPesan.setLocation(260, 10);
        btnPesan.setFocusPainted(false);
        btnPesan.addActionListener(e -> pesan());

        containerUngu.add(btnPesan);
        containerUngu.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(containerUngu);
        Panel_Produk.menu_customer = menu;
        revalidate();
        repaint();
    }

    // HANDLE PROSES PESANAN
    private void pesan(){
        for (AP_ProductCard produk : cards){
            if(produk.getQuantity() > 0){
                Map<String, Object> dataProduk = new HashMap<>();
                dataProduk.put("nama_produk",produk.getNamaProduk());
                dataProduk.put("harga",produk.getHarga());
                dataProduk.put("jumlah",produk.getQuantity());
                cart.put(produk.getIdProduk(), dataProduk);
            }
            produk.resetNumber();
        }
        if(cart.isEmpty()) return;
        
        Panel_Pembayaran pembayaran = new Panel_Pembayaran(cart);
        CardLayout cardLayout = (CardLayout) menu_customer.content.getLayout();
        menu_customer.content.add(pembayaran, "produk");
        cardLayout.show(menu_customer.content, "produk");
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(230, 234, 237));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
