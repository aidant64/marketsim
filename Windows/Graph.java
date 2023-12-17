package Windows;

import Objects.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Graph extends JComponent {
    private Double W;
    private Double H;
    private ArrayList<Pair> points;
    private final Color barColour = null;

    Graph(ArrayList<Pair> points) {
        super();
        // W = 500.0;
        W = getSize().getWidth();
        // H = 180.0;
        H = getSize().getHeight();
        this.points = points;
    }

    public void update(ArrayList<Pair> points) {
        this.points = points;
        W = getSize().getWidth();
        H = getSize().getHeight();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        W = getSize().getWidth();
        H = getSize().getHeight();
        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(mWindow.foreground_color);
        g2D.fillRect(0, 0, W.intValue(), H.intValue());
        g2D.setStroke(new BasicStroke(3f));

        if (points == null || points.isEmpty()) {
            g2D.setColor(mWindow.foreground_color);
            g2D.drawString("Chart Unavailable / Unknown Network Error", 10, 10);
            return;
        }

        float max = points.get(0).y;
        float min = points.get(0).y;
        for (Pair p : points) {
            if (p.y > max)
                max = p.y;
            if (p.y < min)
                min = p.y;
        }
        max = max + (max * 0.05f);
        min = min - (min * 0.05f);

        final double graphX = 32;
        final double graphY = H - 10;

        final double graphW = W - 40;
        final double graphH = H - 20;

        g2D.setColor(mWindow.background_color);
        g2D.drawString("6 Months", (int) (W - 64), 18);

        // x-axis, y-axis
        // g2D.setStroke(new BasicStroke(3f));
        // g2D.drawLine((int) graphX, (int) graphY, (int) (graphX + graphW), (int)
        // (graphY));
        // g2D.drawLine((int) graphX, (int) graphY, (int) graphX, (int) (graphY -
        // graphH));

        double s1 = max;
        double s2 = min + ((max - min) * .33f);
        double s3 = min + ((max - min) * .66f);
        double s4 = min;
        g2D.drawString("" + (int) s4, (int) graphX - 30, (int) graphY);
        g2D.drawString("" + (int) s3, (int) graphX - 30, (int) (graphY - (graphH * .66f)));
        g2D.drawString("" + (int) s2, (int) graphX - 30, (int) (graphY - (graphH * .33f)));
        g2D.drawString("" + (int) s1, (int) graphX - 30, (int) (graphY - graphH + 8));

        int size = points.size();

        g2D.setStroke(new BasicStroke(mWindow.BORDER_SIZE));

        double prevX = 0;
        double prevY = 0;
        int i = 0;
        for (Pair pair : points) {

            double x = graphX + (((double) pair.x / size) * graphW);
            double y = graphY - ((((double) pair.y - min) / (double) (max - min)) * graphH);

            if (i != 0) {
                // g2D.fillOval((int) x, (int) y, 5, 5);
                g2D.drawLine((int) x, (int) y, (int) prevX, (int) prevY);
            }

            prevX = x;
            prevY = y;
            i++;
        }

    }
}