package Script;

import javax.swing.*;
import java.awt.*;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.io.File;

public class AP_ProductCard extends AP_RoundedPanel {

    private String idProduk;
    private String namaProduk;
    private int harga;
    private int quantity = 0;
    private JLabel lblQty;

    public AP_ProductCard(String idProduk, String namaProduk, int harga, String imagePath) {
        super(25);
        
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.harga = harga;
        
        
        setBackground(new Color(255, 255, 255));
        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(300, 150));
        setBorder(BorderFactory.createLineBorder(new Color(40, 90, 200), 3,true));
        // ===== IMAGE =====
        JLabel lblImage = new JLabel();
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        
        FlatSVGIcon icon = new FlatSVGIcon(imagePath,70,70);
//        ImageIcon icon = loadImage(imagePath);
//        Image img = icon.getImage().getScaledInstance(
//            120, 80, Image.SCALE_SMOOTH
//        );
        lblImage.setIcon(new FlatSVGIcon(icon));

        add(lblImage, BorderLayout.NORTH);

        // ===== INFO PANEL =====
        JPanel infoPanel = new JPanel();
        infoPanel.setOpaque(false);
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JLabel lblNama = new JLabel(namaProduk);
        lblNama.setForeground(Color.BLACK);
        lblNama.setFont(new Font("Antipasto Pro Bold",Font.BOLD,20));

        JLabel lblHarga = new JLabel("Rp " + harga);
        lblHarga.setForeground(Color.BLACK);
        lblHarga.setFont(new Font("Segoe UI",Font.BOLD,14));

        lblNama.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblHarga.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(Box.createVerticalStrut(1)); // jarak atas
        infoPanel.add(lblNama);
        infoPanel.add(Box.createVerticalStrut(1)); // jarak antara nama & harga
        infoPanel.add(lblHarga);
        infoPanel.add(Box.createVerticalGlue());

        add(infoPanel, BorderLayout.CENTER);

        // ===== QTY PANEL =====
        JPanel qtyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        qtyPanel.setOpaque(false);

        JButton btnMinus = createSquareButton("Asset/minus.svg");
        JButton btnPlus  = createSquareButton("Asset/add.svg");

        lblQty = new JLabel("0");
        lblQty.setForeground(Color.BLACK);
        lblQty.setFont(new Font("Segoe UI",Font.BOLD,18));

        btnPlus.addActionListener(e -> tambah());
        btnMinus.addActionListener(e -> kurang());

        qtyPanel.add(btnMinus);
        qtyPanel.add(lblQty);
        qtyPanel.add(btnPlus);

        add(qtyPanel, BorderLayout.SOUTH);
    }

//    // ================== IMAGE LOADER ==================
//    private FlatSVGIcon loadImage(String path) {
//        FlatSVGIcon icon = new FlatSVGIcon(path,80,80);
//
////        // jika file tidak ditemukan
////        if (icon.getIconWidth() == -1) {
////            ImageIcon ico = new ImageIcon("images/notfound.png");
////            return ico;
////        }
//
//        return icon;
//    }

    // ================== BUTTON ==================
    private JButton createSquareButton(String path) {
        FlatSVGIcon icon = new FlatSVGIcon(path,20,20);
        JButton btn = new JButton(icon);
        btn.setPreferredSize(new Dimension(35, 35));
        btn.setFocusPainted(false);
        btn.setBackground(Color.WHITE);
        btn.setFont(new Font("Segoe UI",Font.BOLD,15));
        return btn;
    }

    // ================== QTY LOGIC ==================
    private void tambah() {
        quantity++;
        lblQty.setText(String.valueOf(quantity));
    }

    private void kurang() {
        if (quantity > 0) {
            quantity--;
            lblQty.setText(String.valueOf(quantity));
        }
    }
    
    public void resetNumber(){
        quantity = 0;
        lblQty.setText(String.valueOf(quantity));
    }

    public String getIdProduk() {
        return idProduk;
    }
    
    public String getNamaProduk() {
        return namaProduk;
    }
    
    public int getHarga() {
        return harga;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
}
