package Windows;

import Objects.Holding;
import Objects.Pair;
import Systems.Logic;
import Utils.NetworkUtil;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class mJFrameWindow extends javax.swing.JFrame {
        public static final Color text_color = new Color(112, 35, 157), foreground_color = new Color(112, 35, 157),
                        background_color = new Color(220, 220, 220);
        public static final int BORDER_SIZE = 4, WINDOW_DEFAULT_WIDTH = 1000, WINDOW_DEFAULT_HEIGHT = 500,
                        WINDOW_DEFAULT_X = 300, WINDOW_DEFAULT_Y = 300;
        private final Logic logic;

        /**
         * Creates new form Window
         */
        public mJFrameWindow() {
                logic = new Logic();

                initLayout();
                initComponentsBasedOnLogic(logic.generate_holdings_netWorth_cash());

                setVisible(true);

        }

        private void initComponentsBasedOnLogic(double netWorth) {
                jListHoldings.setListData(logic.getHoldingsForDisplayPurpose());
                jLabel_cash.setText("USD: $" + new DecimalFormat("0.00").format(logic.getCash()));
                jLabel_netWorth.setText("NET WORTH: $" + new DecimalFormat("0.00").format(netWorth));
        }

        private void initLayout() {

                setTitle("Sim Game");
                setSize(800, 500);
                setMinimumSize(new Dimension(368, 100));
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // getContentPane().setBackground(Color.RED);
                centerFrame();

                jPanel_left = new JPanel();
                jPanel_right = new JPanel();
                jPanel_left.setMinimumSize(new Dimension(350, 1));
                jPanel_right.setBackground(Color.GREEN);
                jPanel_left.setBackground(Color.YELLOW);

                createLeftPanelLayout();
                createRightPanel();
                // initList();

                // Create a JSplitPane to divide the frame into two panels
                JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jPanel_left, jPanel_right);
                splitPane.setDividerLocation(350);
                splitPane.setDividerSize(0);

                Border border = BorderFactory.createCompoundBorder(
                                BorderFactory.createEmptyBorder(10, 10, 10, 10), // Outer line border (color
                                BorderFactory.createLineBorder(Color.MAGENTA, 2));
                jPanel_left.setBorder(border);
                jPanel_right.setBorder(border);

                int gapSize = 6;

                JPanel contentPane = new JPanel(new BorderLayout());
                contentPane.setBackground(Color.BLUE);
                contentPane.add(splitPane, BorderLayout.CENTER);
                setContentPane(contentPane);

        }

        private void createRightPanel() {
                jPanel_right.setLayout(new BorderLayout());

                // Create a top panel to hold the "enter stock ticker" label and text field side
                // by side
                JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

                // Create and add the "enter stock ticker" label
                JLabel labelStockTicker = new JLabel("Enter stock ticker:");
                topPanel.add(labelStockTicker);

                // Create and add the text field
                JTextField textFieldStockTicker = new JTextField(15); // Adjust the size as needed
                topPanel.add(textFieldStockTicker);

                // Create a loading label
                JLabel labelLoading = new JLabel("Loading");

                // Create a JPanel to hold the "loading" label, label1, label2, and the custom
                // Graph component
                JPanel bottomPanel = new JPanel();
                bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

                // Add components to the bottom panel
                bottomPanel.add(labelLoading);
                bottomPanel.add(new JLabel("Label 1"));
                bottomPanel.add(new JLabel("Label 2"));

                // Create a custom Graph component (replace with your actual custom component)
                Graph customGraph = new Graph(null); // Replace with your custom component

                // Add the custom Graph component to the bottom panel
                bottomPanel.add(customGraph);

                // Create a border for the bottom panel
                Border bottomBorder = BorderFactory.createLineBorder(Color.BLACK, 1);

                // Apply the border to the bottom panel
                bottomPanel.setBorder(bottomBorder);

                // Add the top and bottom panels to the right panel
                jPanel_right.add(topPanel, BorderLayout.NORTH);
                jPanel_right.add(bottomPanel, BorderLayout.CENTER);
        }

        private void createLeftPanelLayout() {
                // Set the background color of the panels (for visualization)
                jPanel_left.setLayout(new BorderLayout());

                jLabel_netWorth = new JLabel("Net Worth: $");
                jLabel_netWorth.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                jLabel_cash = new JLabel("Cash: $");
                jLabel_cash.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

                // Create a JPanel to hold the labels at the top
                JPanel labelsPanel = new JPanel();
                labelsPanel.setBackground(Color.CYAN);
                labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
                labelsPanel.add(jLabel_netWorth);
                labelsPanel.add(jLabel_cash);

                // Create a scrollable section in the middle
                JPanel scrollablePanel = new JPanel();
                scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));
                jScrollpane = new JScrollPane(scrollablePanel);
                jScrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                // Dynamically add items to the scrollable section (you can add components here
                // as needed)
                for (int i = 1; i <= 20; i++) {
                        scrollablePanel.add(new JLabel("Item " + i));
                }

                // Create two buttons at the bottom
                jButton_refresh = new JButton("refresh");
                jButton2_help = new JButton("restart");

                // Create a JPanel to hold the buttons at the bottom
                JPanel buttonsPanel = new JPanel();
                buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                buttonsPanel.add(jButton_refresh);
                buttonsPanel.add(jButton2_help);

                // Add the labels, scrollable section, and buttons to the left panel
                jPanel_left.add(labelsPanel, BorderLayout.NORTH);
                jPanel_left.add(jScrollpane, BorderLayout.CENTER);
                jPanel_left.add(buttonsPanel, BorderLayout.SOUTH);

        }

        private void initList() {
                mListItem listItem = new mListItem();
                jListHoldings.setCellRenderer(listItem);
                jScrollpane.setViewportView(jListHoldings);
        }

        private void centerFrame() {
                // Get the screen dimension
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

                // Calculate the position for centering the frame
                int x = (screenSize.width - getWidth()) / 2;
                int y = (screenSize.height - getHeight()) / 2;

                // Set the frame's position
                setLocation(x, y);
        }

        private javax.swing.JPanel jPanel_left;
        private javax.swing.JPanel jPanel_right;

        // left
        private javax.swing.JLabel jLabel_netWorth;
        private javax.swing.JLabel jLabel_cash;
        private javax.swing.JList<Holding> jListHoldings = new javax.swing.JList<>();;
        private javax.swing.JScrollPane jScrollpane;
        private javax.swing.JButton jButton_refresh;
        private javax.swing.JButton jButton2_help;

        // right
        private javax.swing.JTextField jTextField_quant;
        private javax.swing.JTextField jTextField_search;
        private Graph jPanel_graph;
}
