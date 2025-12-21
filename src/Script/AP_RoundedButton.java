package Script;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AP_RoundedButton extends JButton {

    private int radius;
    private int baseSize;
    private float scale = 1.0f;
    private float clickScale = 0.9f;

    private boolean hover = false;
    private boolean resizeEffect = true;
    private boolean hoverEffect = true;

    private float baseFontSize;

    private Color borderColor = new Color(40, 90, 200);
    private Boolean textHover = false;
    private Color hoverColor;
    private Color normalColor;
    
    private Timer scaleTimer;
    private float targetScale = 1.0f;


    /* ================= CONSTRUCTOR DEFAULT ================= */
    public AP_RoundedButton(String text,int radius, int baseSize) {
        super(text);
        this.radius = radius;
        this.baseSize = baseSize;
        init();
    }

    /* ================= CONSTRUCTOR SCALE ================= */
    public AP_RoundedButton(String text, int radius, int baseSize, float clickScale) {
        super(text);
        this.radius = radius;
        this.baseSize = baseSize;
        this.clickScale = clickScale;
        init();
    }

    /* ================= CONSTRUCTOR YANG KAMU MINTA ================= */
    public AP_RoundedButton(
            String text,
            int radius,
            int baseSize,
            boolean resizeEffect,
            boolean hoverEffect,
            Color hoverColor
    ) {
        super(text);
        this.radius = radius;
        this.baseSize = baseSize;
        this.resizeEffect = resizeEffect;
        this.hoverEffect = hoverEffect;
        this.hoverColor = hoverColor;
        this.textHover = true;
        init();
    }

    private void init() {
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        baseFontSize = baseSize;
        normalColor = getBackground();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (hoverEffect) {
                    hover = true;
                    repaint();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hover = false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (resizeEffect && hover) {
                    animateScale(clickScale);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (resizeEffect && hover) {
                    animateScale(1.0f);
                }
            }
        });
    }

    /* ================= SETTER TAMBAHAN ================= */
    public void setClickScale(float scale) {
        this.clickScale = scale;
    }

    public void setHoverColor(Color color) {
        this.hoverColor = color;
    }

    public void setBorderColor(Color color) {
        this.borderColor = color;
    }

    /* ================= ANIMASI ================= */
    private void animateScale(float target) {
        targetScale = target;

        if (scaleTimer != null && scaleTimer.isRunning()) return;

        scaleTimer = new Timer(10, e -> {
            scale += (targetScale - scale) * 0.25f;

            if (Math.abs(scale - targetScale) < 0.01f) {
                scale = targetScale;
                scaleTimer.stop();
            }
            repaint();
        });
        scaleTimer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // scale dari tengah
        g2.translate(w / 2, h / 2);
        g2.scale(scale, scale);
        g2.translate(-w / 2, -h / 2);

        // background
        if (hover && hoverEffect && hoverColor != null) {
            g2.setColor(hoverColor);
        } else {
            g2.setColor(getBackground());
        }
        g2.fillRoundRect(0, 0, w, h, radius, radius);

        // outline
        g2.setStroke(new BasicStroke(2f));
        g2.setColor(borderColor);
        g2.drawRoundRect(1, 1, w - 2, h - 2, radius, radius);

        // font ikut scale
        Font scaledFont = getFont().deriveFont(baseFontSize * scale);
        g2.setFont(scaledFont);
        
        if (textHover && hover) {
            g2.setColor(Color.WHITE);
        } else {
            g2.setColor(getForeground());
        }

        FontMetrics fm = g2.getFontMetrics();
        int textW = fm.stringWidth(getText());
        int textH = fm.getAscent();

        g2.drawString(
            getText(),
            (w - textW) / 2,
            (h + textH) / 2 - 2
        );

        g2.dispose();
    }
}
