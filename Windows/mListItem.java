package Windows;

import Objects.Holding;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class mListItem extends JPanel implements ListCellRenderer<Holding> {

        private JPanel jPanel1, jPanel2;
        private JLabel jLabel1, jLabel2, jLabel3;

        public mListItem() {
                super();

                setOpaque(true);
                setBackground(mWindow.background_color);
                setForeground(mWindow.text_color);
                setBorder(BorderFactory.createEmptyBorder(5, 3, 0, 3));// 5, 3, 5, 3

                initComponents();
        }

        private void initComponents() {

                // add(jPanel1);

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jPanel2 = new javax.swing.JPanel();

                add(jPanel1);

                setOpaque(true);
                jPanel1.setOpaque(true);

                jLabel1.setText("row1");
                jLabel2.setText("row2");
                jLabel3.setText("row3");

                jPanel2.setBackground(mWindow.foreground_color);

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 2, 2));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 2, 2));

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                200, Short.MAX_VALUE)// 394
                                                                .addContainerGap())
                                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 5, 5)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        }// </editor-fold>

        @Override
        public Component getListCellRendererComponent(JList<? extends Holding> list, Holding value, int index,
                        boolean isSelected, boolean cellHasFocus) {

                String txt = value.getTicker() + " (" + value.getAmount() + " shares)";
                if (value.getAmount() == 1) {
                        txt = value.getTicker() + " (" + value.getAmount() + " share)";
                }
                jLabel1.setText(txt);

                jLabel2.setText("price per share: " + new DecimalFormat("0.00").format(value.getPrice()));
                jLabel3.setText("worth:" + new DecimalFormat("0.00").format(value.getPrice() * value.getAmount()));

                if (isSelected) {
                        jLabel1.setForeground(mWindow.background_color);
                        jLabel1.setBackground(mWindow.foreground_color);

                        jLabel2.setForeground(mWindow.background_color);
                        jLabel2.setBackground(mWindow.foreground_color);

                        jLabel3.setForeground(mWindow.background_color);
                        jLabel3.setBackground(mWindow.foreground_color);

                        jPanel1.setBackground(mWindow.foreground_color);
                        setBackground(mWindow.foreground_color);
                } else {
                        jLabel1.setForeground(mWindow.text_color);
                        jLabel1.setBackground(mWindow.background_color);

                        jLabel2.setForeground(mWindow.text_color);
                        jLabel2.setBackground(mWindow.background_color);

                        jLabel3.setForeground(mWindow.text_color);
                        jLabel3.setBackground(mWindow.background_color);

                        jPanel1.setBackground(mWindow.background_color);
                        setBackground(mWindow.background_color);
                }

                return this;
        }
}
