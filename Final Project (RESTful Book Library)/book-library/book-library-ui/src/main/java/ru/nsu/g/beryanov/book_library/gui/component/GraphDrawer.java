package ru.nsu.g.beryanov.book_library.gui.component;

import javax.swing.*;
import java.awt.*;

public class GraphDrawer extends JPanel {
    int[] x;
    int[] y;
    int n;

    public GraphDrawer(int[] x, int y[], int n) {
        this.x = x;
        this.y = y;
        this.n = n;
    }

    protected void paintComponent(Graphics gh) {
        Graphics2D drp = (Graphics2D) gh;

        drp.setStroke(new BasicStroke(2));
        drp.setColor(new Color(44, 102, 230, 180));
        drp.drawPolyline(x, y, n);

        drp.setColor(Color.RED);
        for (int i = 0; i < n; i++) {
            drp.fillOval(x[i] - 3, y[i] - 3, 7, 7);
        }
    }
}
