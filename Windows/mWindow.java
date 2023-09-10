package Windows;

import Objects.Holding;
import Objects.Pair;
import Systems.Logic;
import Utils.NetworkUtil;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class mWindow extends javax.swing.JFrame {
        public static final Color text_color = new Color(112, 35, 157), foreground_color = new Color(112, 35, 157),
                        background_color = new Color(220, 220, 220);
        public static final int BORDER_SIZE = 4, WINDOW_DEFAULT_WIDTH = 1100, WINDOW_DEFAULT_HEIGHT = 500,
                        WINDOW_DEFAULT_X = 300, WINDOW_DEFAULT_Y = 300;
        private final Logic logic;

        /**
         * Creates new form Window
         */
        public mWindow() {

                logic = new Logic();
                initComponents();
                jPanelInfo.setVisible(false);
                initComponentsBasedOnLogic(logic.generate_holdings_netWorth_cash());
                pack();

        }

        private void initComponentsBasedOnLogic(double netWorth) {
                jListHoldings.setListData(logic.getHoldingsForDisplayPurpose());
                jLabel_cash.setText("USD: $" + new DecimalFormat("0.00").format(logic.getCash()));
                jLabel_netWorth.setText("NET WORTH: $" + new DecimalFormat("0.00").format(netWorth));
        }

        private void setBackgroundColors() {
                jPanel_wrapper.setBackground(background_color);
                jPanel_Holdings.setBackground(background_color);
                jLabel_netWorth.setBackground(background_color);
                jScrollpane.setBackground(background_color);
                jListHoldings.setBackground(background_color);
                jPanel_wrapper2.setBackground(background_color);
                jPanelSearch.setBackground(background_color);
                jLabel_searchStatus.setBackground(background_color);
                jTextField_search.setBackground(background_color);
                jLabel_search.setBackground(background_color);
                jPanel_wrapper3.setBackground(background_color);
                jPanelInfo.setBackground(background_color);
                jLabel_info1.setBackground(background_color);
                jLabel_info2.setBackground(background_color);
                jLabel_info3.setBackground(background_color);
                jTextField_quant.setBackground(background_color);
                jButton_sell.setBackground(background_color);
                jLabel_transaction.setBackground(background_color);
                jButton_buy.setBackground(background_color);
                jButton_refresh.setBackground(background_color);
                jButton2_help.setBackground(background_color);
                jLabel_portfolio.setBackground(background_color);

                getContentPane().setBackground(background_color);

                jPanel_wrapper.setForeground(text_color);
                jPanel_Holdings.setForeground(text_color);
                jLabel_netWorth.setForeground(text_color);
                jScrollpane.setForeground(text_color);
                jListHoldings.setForeground(text_color);
                jPanel_wrapper2.setForeground(text_color);
                jPanelSearch.setForeground(text_color);
                jLabel_searchStatus.setForeground(text_color);
                jTextField_search.setForeground(text_color);
                jLabel_search.setForeground(text_color);
                jPanel_wrapper3.setForeground(text_color);
                jPanelInfo.setForeground(text_color);
                jLabel_info1.setForeground(text_color);
                jLabel_info2.setForeground(text_color);
                jLabel_info3.setForeground(text_color);
                jTextField_quant.setForeground(text_color);
                jButton_sell.setForeground(text_color);
                jLabel_transaction.setForeground(text_color);
                jButton_buy.setForeground(text_color);
                jButton_refresh.setForeground(text_color);
                jButton2_help.setForeground(text_color);
                jLabel_portfolio.setForeground(Color.GRAY);

                jButton_buy.setSelected(false);
                jButton_sell.setSelected(false);
                jButton_refresh.setSelected(false);
                jButton2_help.setSelected(false);

                jLabel_cash.setOpaque(true);
                jLabel_cash.setBackground(foreground_color);
                jLabel_cash.setForeground(background_color);

                jLabel_netWorth.setOpaque(true);
                jLabel_netWorth.setBackground(foreground_color);
                jLabel_netWorth.setForeground(background_color);

                jButton_refresh.setOpaque(true);
                jButton2_help.setOpaque(true);

                jPanel_Holdings.addMouseListener(new MouseInputAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                jListHoldings.clearSelection();
                                super.mouseClicked(e);
                        }
                });
                jPanelSearch.addMouseListener(new MouseInputAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                jListHoldings.clearSelection();
                                super.mouseClicked(e);
                        }
                });
                jPanelInfo.addMouseListener(new MouseInputAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                jListHoldings.clearSelection();
                                super.mouseClicked(e);
                        }
                });

                jPanel_Holdings.setBorder(new javax.swing.border.LineBorder(foreground_color, BORDER_SIZE, true));
                jPanel_wrapper3.setBorder(new javax.swing.border.LineBorder(foreground_color, BORDER_SIZE, true));

                jLabel_info2.setHorizontalAlignment(JLabel.CENTER);
                jLabel_info3.setHorizontalAlignment(JLabel.CENTER);

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("Market Sim Game");
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                setPreferredSize(new java.awt.Dimension(WINDOW_DEFAULT_WIDTH, WINDOW_DEFAULT_HEIGHT));

                setBounds(new java.awt.Rectangle(WINDOW_DEFAULT_X, WINDOW_DEFAULT_Y, WINDOW_DEFAULT_WIDTH,
                                WINDOW_DEFAULT_HEIGHT));
                setMinimumSize(new Dimension(408, 410));

                validate();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        private void initComponents() {

                jButton2_help = new JButton();
                jButton_refresh = new JButton();
                jPanel_wrapper = new javax.swing.JPanel();
                jPanel_Holdings = new javax.swing.JPanel();
                jLabel_netWorth = new javax.swing.JLabel();
                jLabel_cash = new javax.swing.JLabel();
                jScrollpane = new javax.swing.JScrollPane();
                jListHoldings = new javax.swing.JList<>();
                jPanel_wrapper2 = new javax.swing.JPanel();
                jPanelSearch = new javax.swing.JPanel();
                jLabel_searchStatus = new javax.swing.JLabel();
                jTextField_search = new CustomTextField("", true);
                jLabel_search = new javax.swing.JLabel();
                jPanel_wrapper3 = new javax.swing.JPanel();
                jPanelInfo = new javax.swing.JPanel();
                jLabel_info1 = new javax.swing.JLabel();
                jLabel_info2 = new javax.swing.JLabel();
                jLabel_info3 = new javax.swing.JLabel();
                jTextField_quant = new CustomTextField("", false);
                jButton_sell = new javax.swing.JButton();
                jLabel_transaction = new javax.swing.JLabel();
                jButton_buy = new javax.swing.JButton();
                jPanel_graph = new Graph(null);

                jLabel_portfolio = new javax.swing.JLabel();
                setBackgroundColors();

                jPanel_wrapper.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

                jPanel_Holdings.setBorder(new javax.swing.border.LineBorder(foreground_color, 2, true));

                jLabel_netWorth.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                jLabel_netWorth.setText("Net Worth: $");
                jLabel_netWorth.setToolTipText("");
                jLabel_netWorth.setBorder(BorderFactory.createEmptyBorder(2, 5, 5, 5));

                jLabel_cash.setText("USD: $");
                jLabel_cash.setToolTipText("");
                jLabel_cash.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 5, 5,
                                5));

                jLabel_portfolio.setText("<html><u>portfolio</u></html>");
                jLabel_portfolio.setBorder(BorderFactory.createEmptyBorder(5, 130, 3, 5));

                jScrollpane.setBorder(null);
                jScrollpane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                Border innerBorder = BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(Color.GRAY, 1),
                                BorderFactory.createEmptyBorder(0, 2, 0, 2));
                Border border = BorderFactory.createCompoundBorder(
                                BorderFactory.createEmptyBorder(0, 5, 0, 5),
                                innerBorder);
                jTextField_quant.setBorder(border);

                // jButton_buy.setBorder(buyBorder);

                Border searchBorder = BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(Color.GRAY, 1),
                                BorderFactory.createEmptyBorder(4, 2, 2, 2));
                jTextField_search.setBorder(searchBorder);

                // ======

                jButton_refresh.setText("refresh");
                jButton_refresh.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton_refreshActionPerformed(evt);
                        }
                });

                jButton2_help.setText("restart");
                jButton2_help.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                restartButton_pressed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel_HoldingsLayout = new javax.swing.GroupLayout(jPanel_Holdings);
                jPanel_Holdings.setLayout(jPanel_HoldingsLayout);
                jPanel_HoldingsLayout.setHorizontalGroup(
                                jPanel_HoldingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollpane, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel_netWorth, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                350, Short.MAX_VALUE)
                                                .addComponent(jLabel_cash, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel_portfolio, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel_HoldingsLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jButton_refresh)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton2_help)
                                                                .addGap(0, 0, Short.MAX_VALUE)));
                jPanel_HoldingsLayout.setVerticalGroup(
                                jPanel_HoldingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel_HoldingsLayout.createSequentialGroup()
                                                                .addComponent(jLabel_netWorth)
                                                                .addComponent(jLabel_cash)
                                                                .addComponent(jLabel_portfolio)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollpane,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 0,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel_HoldingsLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jButton2_help)
                                                                                .addComponent(jButton_refresh))
                                                                .addContainerGap()));

                javax.swing.GroupLayout jPanel_wrapperLayout = new javax.swing.GroupLayout(jPanel_wrapper);
                jPanel_wrapper.setLayout(jPanel_wrapperLayout);
                jPanel_wrapperLayout.setHorizontalGroup(
                                jPanel_wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel_wrapperLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel_Holdings,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap()));
                jPanel_wrapperLayout.setVerticalGroup(
                                jPanel_wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel_wrapperLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel_Holdings,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));

                jPanelSearch.setForeground(new java.awt.Color(255, 255, 255));
                jPanelSearch.setAutoscrolls(true);
                jPanelSearch.setName(""); // NOI18N

                jLabel_searchStatus.setText(" ");

                jTextField_search.setText("ex: AAPL or IBM ...");
                jTextField_search.setMixingCutoutShape(null);
                jTextField_search.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jTextField_searchActionPerformed(evt, jTextField_search.getText());
                        }
                });

                jLabel_search.setText("Enter Stock Ticker:  ");

                jPanel_wrapper3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

                jLabel_info1.setText("info1");
                jLabel_info1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                jLabel_info2.setText("info2");
                jLabel_info2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                jLabel_info3.setText("info3");
                jLabel_info3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                jLabel_info3.setVerifyInputWhenFocusTarget(false);

                jTextField_quant.setText("Num shares");
                jTextField_quant.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jTextField_quantActionPerformed(evt);
                        }
                });

                jButton_sell.setBackground(new java.awt.Color(204, 204, 204));
                jButton_sell.setText("Sell");
                jButton_sell.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton_sellActionPerformed(evt);
                        }
                });

                jLabel_transaction.setText("Status");

                jButton_buy.setText("Buy");
                jButton_buy.setSelected(true);
                jButton_buy.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton_buyActionPerformed(evt);
                        }
                });

                jPanel_graph.setBackground(new java.awt.Color(255, 51, 51));

                javax.swing.GroupLayout jPanel_graphLayout = new javax.swing.GroupLayout(jPanel_graph);
                jPanel_graph.setLayout(jPanel_graphLayout);
                jPanel_graphLayout.setHorizontalGroup(
                                jPanel_graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));
                jPanel_graphLayout.setVerticalGroup(
                                jPanel_graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));

                javax.swing.GroupLayout jPanelInfoLayout = new javax.swing.GroupLayout(jPanelInfo);
                jPanelInfo.setLayout(jPanelInfoLayout);
                jPanelInfoLayout.setHorizontalGroup(
                                jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelInfoLayout.createSequentialGroup()
                                                                .addGap(0, 0, 0)
                                                                .addGroup(jPanelInfoLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanelInfoLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jTextField_quant,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jButton_buy)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jButton_sell)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jLabel_transaction,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                341,
                                                                                                                Short.MAX_VALUE))
                                                                                .addComponent(jLabel_info3,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jLabel_info2,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jLabel_info1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jPanel_graph,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(0, 0, 0)));
                jPanelInfoLayout.setVerticalGroup(
                                jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelInfoLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel_info1)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel_info2)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel_info3)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jPanel_graph,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanelInfoLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jTextField_quant,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jButton_sell)
                                                                                .addComponent(jLabel_transaction,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                23,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jButton_buy))));

                javax.swing.GroupLayout jPanel_wrapper3Layout = new javax.swing.GroupLayout(jPanel_wrapper3);
                jPanel_wrapper3.setLayout(jPanel_wrapper3Layout);
                jPanel_wrapper3Layout.setHorizontalGroup(
                                jPanel_wrapper3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel_wrapper3Layout.createSequentialGroup()
                                                                .addGap(0, 0, 0)
                                                                .addComponent(jPanelInfo,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGap(0, 0, 0)));
                jPanel_wrapper3Layout.setVerticalGroup(
                                jPanel_wrapper3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel_wrapper3Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanelInfo,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));

                javax.swing.GroupLayout jPanelSearchLayout = new javax.swing.GroupLayout(jPanelSearch);
                jPanelSearch.setLayout(jPanelSearchLayout);
                jPanelSearchLayout.setHorizontalGroup(
                                jPanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSearchLayout
                                                                .createSequentialGroup()
                                                                .addGroup(jPanelSearchLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jPanel_wrapper3,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(jPanelSearchLayout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addGroup(jPanelSearchLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanelSearchLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jLabel_search)
                                                                                                                                .addGap(2, 2, 2)
                                                                                                                                .addComponent(jTextField_search))
                                                                                                                .addGroup(jPanelSearchLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jLabel_searchStatus)
                                                                                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                                                .addContainerGap()));
                jPanelSearchLayout.setVerticalGroup(
                                jPanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSearchLayout
                                                                .createSequentialGroup()
                                                                .addGroup(jPanelSearchLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jTextField_search,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel_search))
                                                                .addGap(4, 4, 4)
                                                                .addComponent(jLabel_searchStatus)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel_wrapper3,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout jPanel_wrapper2Layout = new javax.swing.GroupLayout(jPanel_wrapper2);
                jPanel_wrapper2.setLayout(jPanel_wrapper2Layout);
                jPanel_wrapper2Layout.setHorizontalGroup(
                                jPanel_wrapper2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel_wrapper2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanelSearch,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));
                jPanel_wrapper2Layout.setVerticalGroup(
                                jPanel_wrapper2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel_wrapper2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanelSearch,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel_wrapper,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel_wrapper2,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jPanel_wrapper,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jPanel_wrapper2,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))));

                setBackgroundColors();
                mListItem listItem = new mListItem();
                jListHoldings.setCellRenderer(listItem);
                jScrollpane.setViewportView(jListHoldings);
                pack();

        }// </editor-fold>

        private void restartButton_pressed(ActionEvent event) {
                if (logic.buttonPressed_reset(this))
                        jButton_refreshActionPerformed(null);
        }

        private void jButton_refreshActionPerformed(ActionEvent event) {
                if (logic.getHoldings().isEmpty())
                        return;
                jLabel_netWorth.setText("Calculating...");
                validate();
                update(getGraphics());
                initComponentsBasedOnLogic(logic.generate_holdings_netWorth_cash());
        }

        private void jTextField_searchActionPerformed(java.awt.event.ActionEvent evt, String ticker) {
                ticker = ticker.toUpperCase();
                jTextField_search.setText(ticker);
                jLabel_searchStatus.setText("...loading " + ticker + "...");
                jPanelInfo.setVisible(false);
                validate();
                update(getGraphics());

                String[] res = logic.searchEntered(ticker);

                if (res == null) {
                        jLabel_searchStatus.setText("Invalid Ticker / Unknown Network Error Occurred");
                        return;
                }

                jLabel_searchStatus.setText(" ");
                jPanelInfo.setVisible(true);
                setQueryStatus("", "" + res[0], "" + res[1]);

                ArrayList<Pair> candles = NetworkUtil.getCandles(jTextField_search.getText());
                jPanel_graph.update(candles);
                jPanel_graph.paintComponent(getGraphics());
                jPanel_graph.validate();
                jPanel_graph.update(getGraphics());

                jTextField_quant.setText("Num shares");
                jLabel_transaction.setText("Status: ");

                validate();
                update(getGraphics());
                repaint();

        }

        private void jButton_sellActionPerformed(java.awt.event.ActionEvent evt) {
                buySell(false);
        }

        private void jButton_buyActionPerformed(java.awt.event.ActionEvent evt) {
                buySell(true);
        }

        private void buySell(boolean isBuy) {
                String s = logic.checkIfTransactionPossible(isBuy, jLabel_info2.getText().toUpperCase(),
                                jTextField_quant.getText(), jLabel_info3.getText());

                if (!s.equals("1")) {
                        jLabel_transaction.setText(s);
                        return;
                }

                if (isBuy) {
                        jLabel_transaction.setText(logic.buyProcess(jLabel_info2.getText().toUpperCase(),
                                        Integer.parseInt(jTextField_quant.getText()),
                                        Double.parseDouble(jLabel_info3.getText())));
                } else {
                        jLabel_transaction.setText(logic.sellProcess(jLabel_info2.getText().toUpperCase(),
                                        Integer.parseInt(jTextField_quant.getText()),
                                        Double.parseDouble(jLabel_info3.getText())));
                }

                jListHoldings.setListData(logic.getHoldingsForDisplayPurpose());
                jLabel_cash.setText("USD: $" + new DecimalFormat("0.00").format(logic.getCash()));
                jLabel_netWorth.setText("Calculating...");
                validate();
                update(getGraphics());

                // last step -> calculate new net worth
                double netWorth = logic.generate_holdings_netWorth_cash();
                jLabel_netWorth.setText("NET WORTH: $" + new DecimalFormat("0.00").format(netWorth));
        }

        private void jTextField_quantActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO add your handling code here:
                return;
        }

        private void setQueryStatus(String s1, String s2, String s3) {
                jLabel_info1.setText(s1);
                jLabel_info2.setText(s2);
                jLabel_info3.setText(s3);
        }

        // Variables declaration - do not modify
        private javax.swing.JButton jButton2_help;
        private javax.swing.JButton jButton_buy;
        private javax.swing.JButton jButton_refresh;
        private javax.swing.JButton jButton_sell;
        private javax.swing.JLabel jLabel_cash;
        private javax.swing.JLabel jLabel_info1;
        private javax.swing.JLabel jLabel_info2;
        private javax.swing.JLabel jLabel_info3;
        private javax.swing.JLabel jLabel_netWorth;
        private javax.swing.JLabel jLabel_search;
        private javax.swing.JLabel jLabel_searchStatus;
        private javax.swing.JLabel jLabel_transaction;
        private javax.swing.JList<Holding> jListHoldings;
        private javax.swing.JPanel jPanelInfo;
        private javax.swing.JPanel jPanelSearch;
        private javax.swing.JPanel jPanel_Holdings;
        private javax.swing.JPanel jPanel_wrapper;
        private javax.swing.JPanel jPanel_wrapper2;
        private javax.swing.JPanel jPanel_wrapper3;
        private javax.swing.JScrollPane jScrollpane;
        private javax.swing.JTextField jTextField_quant;
        private javax.swing.JTextField jTextField_search;
        private Graph jPanel_graph;

        private javax.swing.JLabel jLabel_portfolio;
        // End of variables declaration

}
