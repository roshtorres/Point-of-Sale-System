package packagePointOfSaleSystem;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTabbedPane;

public class CoffeeShopPOS2
{
    JFrame frmPOS;
    JTable table_OrderList;
    JTextField jtxtBarcode;
    JTextField jtxtSubTotal;
    JTextField jtxtTotalSale;
    JTextField jtxtTax;
    JTextField jtxtAmountPaid;
    JTextField jtxtChangeDue;

    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("Application Icon.png"));

    /**
     * Launch the application.
     */
    public static void PointOfSaleSystem() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CoffeeShopPOS2 window = new CoffeeShopPOS2();
                    window.frmPOS.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public CoffeeShopPOS2() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */

    //============================================ITEM COST FUNCTION (START)============================================
    public void ItemCost()
    {
        double sum = 0;
        double tax = 0.25;

        for(int i = 0; i < table_OrderList.getRowCount(); i++)
        {
            sum = sum + Double.parseDouble(table_OrderList.getValueAt(i, 2).toString());
        }
        jtxtSubTotal.setText(Double.toString(sum));
        double cTotal = Double.parseDouble(jtxtSubTotal.getText());

        double cTax = (cTotal * tax)/100;
        String iTaxTotal = String.format("₱ %.2f", cTax);
        jtxtTax.setText(iTaxTotal);

        String iSubTotal = String.format("₱ %.2f", cTotal);
        jtxtSubTotal.setText(iSubTotal);

        String iTotal = String.format("₱ %.2f", cTotal + cTax);
        jtxtTotalSale.setText(iTotal);

        String BarCode = String.format("Total is %.2f", cTotal + cTax);
        jtxtBarcode.setText(BarCode);

    }
    //============================================ITEM COST FUNCTION (END)============================================

    //****************************************************************************************************************

    //============================================CHANGE FUNCTION (START)============================================
    public void Change()
    {
        double sum = 0;
        double tax = 0.25;
        double cash = Double.parseDouble(jtxtAmountPaid.getText());

        for(int i = 0; i < table_OrderList.getRowCount(); i++)
        {
            sum = sum + Double.parseDouble(table_OrderList.getValueAt(i, 2).toString());
        }

        double cTax = (tax * sum)/100;
        double cChange = (cash - (sum + cTax));
        String ChangeGiven = String.format("₱ %.2f", cChange);
        jtxtChangeDue.setText(ChangeGiven);

    }
    //============================================CHANGE FUNCTION (END)============================================

    //****************************************************************************************************************

    private void initialize() {
        frmPOS = new JFrame();
        frmPOS.getContentPane().setBackground(new Color(238, 232, 170));
        frmPOS.setTitle("POS System");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frmPOS.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
        frmPOS.setLocationRelativeTo(null);
        frmPOS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmPOS.getContentPane().setLayout(null);
        frmPOS.setIconImage(icon.getImage());

        //****************************************************************************************************************

        //============================================MENU BUTTONS (START)============================================
        JLabel jlblMenu = new JLabel("");
        jlblMenu.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Label - Menu.png"));
        jlblMenu.setHorizontalAlignment(SwingConstants.CENTER);
        jlblMenu.setFont(new Font("Arial Black", Font.BOLD, 20));
        jlblMenu.setBounds(35, 28, 510, 35);
        frmPOS.getContentPane().add(jlblMenu);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(45, 74, 500, 599);
        frmPOS.getContentPane().add(tabbedPane);

        //--------------------COFFEE--------------------
        JPanel panel_Coffee = new JPanel();
        panel_Coffee.setBorder(new LineBorder(new Color(139, 69, 19), 5));
        tabbedPane.addTab("Coffee", null, panel_Coffee, null);
        panel_Coffee.setLayout(null);

        JLabel jlblCoffee = new JLabel("");
        jlblCoffee.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Label - Coffee.png"));
        jlblCoffee.setHorizontalAlignment(SwingConstants.CENTER);
        jlblCoffee.setFont(new Font("Arial Black", Font.BOLD, 20));
        jlblCoffee.setBounds(10, 36, 475, 48);
        panel_Coffee.add(jlblCoffee);

        //-----Americano-----
        JButton jbtnAmericano = new JButton("");
        jbtnAmericano.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 110;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Americano", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnAmericano.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Coffee - 1.png"));
        jbtnAmericano.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnAmericano.setBounds(10, 106, 110, 98);
        panel_Coffee.add(jbtnAmericano);

        //-----Cappucino-----
        JButton jbtnCappucino = new JButton("");
        jbtnCappucino.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 120;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Cappucino", "1", priceOfItem});
                ItemCost();
            }

        });
        jbtnCappucino.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Coffee - 2.png"));
        jbtnCappucino.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnCappucino.setBounds(10, 215, 110, 98);
        panel_Coffee.add(jbtnCappucino);

        //-----Cocoa-----
        JButton jbtnCocoa = new JButton("");
        jbtnCocoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 120;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Cocoa", "1", priceOfItem});
                ItemCost();

            }
        });
        jbtnCocoa.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Coffee - 3.png"));
        jbtnCocoa.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnCocoa.setBounds(10, 324, 110, 98);
        panel_Coffee.add(jbtnCocoa);

        //-----Decaf-----
        JButton jbtnDecaf = new JButton("");
        jbtnDecaf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 95;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Decaf", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnDecaf.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Coffee - 5.png"));
        jbtnDecaf.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnDecaf.setBounds(130, 106, 110, 98);
        panel_Coffee.add(jbtnDecaf);

        //-----Dalgona-----
        JButton jbtnDalgona = new JButton("");
        jbtnDalgona.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 135;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Dalgona", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnDalgona.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Coffee - 4.png"));
        jbtnDalgona.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnDalgona.setBounds(10, 433, 110, 98);
        panel_Coffee.add(jbtnDalgona);

        //-----Doppio-----
        JButton jbtnDoppio = new JButton("");
        jbtnDoppio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 140;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Doppio", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnDoppio.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Coffee - 6.png"));
        jbtnDoppio.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnDoppio.setBounds(130, 215, 110, 98);
        panel_Coffee.add(jbtnDoppio);

        //-----Espresso-----
        JButton jbtnEspresso = new JButton("");
        jbtnEspresso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 100;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Espresso", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnEspresso.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Coffee - 7.png"));
        jbtnEspresso.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnEspresso.setBounds(130, 324, 110, 98);
        panel_Coffee.add(jbtnEspresso);

        //-----Frappe-----
        JButton jbtnFrappe = new JButton("");
        jbtnFrappe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 165;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Frappe", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnFrappe.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Coffee - 8.png"));
        jbtnFrappe.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnFrappe.setBounds(130, 433, 110, 98);
        panel_Coffee.add(jbtnFrappe);

        //-----Glace-----
        JButton jbtnGlace = new JButton("");
        jbtnGlace.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 130;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Glace", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnGlace.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Coffee - 9.png"));
        jbtnGlace.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnGlace.setBounds(253, 106, 110, 98);
        panel_Coffee.add(jbtnGlace);

        //-----Latte-----
        JButton jbtnLatte = new JButton("");
        jbtnLatte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 120;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Latte", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnLatte.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Coffee - 10.png"));
        jbtnLatte.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnLatte.setBounds(253, 215, 110, 98);
        panel_Coffee.add(jbtnLatte);

        //-----Lungo-----
        JButton jbtnLungo = new JButton("");
        jbtnLungo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 125;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Lungo", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnLungo.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Coffee - 11.png"));
        jbtnLungo.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnLungo.setBounds(253, 324, 110, 98);
        panel_Coffee.add(jbtnLungo);

        //-----Macchiato-----
        JButton jbtnMacchiato = new JButton("");
        jbtnMacchiato.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 140;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Macchiato", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnMacchiato.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Coffee - 12.png"));
        jbtnMacchiato.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnMacchiato.setBounds(253, 433, 110, 98);
        panel_Coffee.add(jbtnMacchiato);

        //-----Mocha-----
        JButton jbtnMochaCoffee = new JButton("");
        jbtnMochaCoffee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 135;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Mocha", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnMochaCoffee.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Coffee - 14.png"));
        jbtnMochaCoffee.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnMochaCoffee.setBounds(375, 215, 110, 98);
        panel_Coffee.add(jbtnMochaCoffee);

        //-----Marocchino-----
        JButton jbtnMarocchino = new JButton("");
        jbtnMarocchino.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 150;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Marocchino", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnMarocchino.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Coffee - 13.png"));
        jbtnMarocchino.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnMarocchino.setBounds(375, 106, 110, 98);
        panel_Coffee.add(jbtnMarocchino);

        //-----Ristretto-----
        JButton jbtnRistretto = new JButton("");
        jbtnRistretto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 165;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Ristretto", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnRistretto.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Coffee - 15.png"));
        jbtnRistretto.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnRistretto.setBounds(375, 324, 110, 98);
        panel_Coffee.add(jbtnRistretto);

        //-----Romano-----
        JButton jbtnRomano = new JButton("");
        jbtnRomano.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 100;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Romano", "1", priceOfItem});
                ItemCost();
            }

        });
        jbtnRomano.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Coffee - 16.png"));
        jbtnRomano.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnRomano.setBounds(375, 433, 110, 98);
        panel_Coffee.add(jbtnRomano);

        //--------------------BREAD--------------------
        JPanel panel_Bread = new JPanel();
        panel_Bread.setBorder(new LineBorder(new Color(139, 69, 19), 5));
        tabbedPane.addTab("Bread", null, panel_Bread, null);
        panel_Bread.setLayout(null);

        JLabel jlblBread = new JLabel("");
        jlblBread.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Label - Bread.png"));
        jlblBread.setHorizontalAlignment(SwingConstants.CENTER);
        jlblBread.setFont(new Font("Arial Black", Font.BOLD, 20));
        jlblBread.setBounds(10, 36, 475, 48);
        panel_Bread.add(jlblBread);

        //-----Banana Loaf-----
        JButton jbtnBananaLoaf = new JButton("");
        jbtnBananaLoaf.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                double priceOfItem = 85;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Banana Loaf", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnBananaLoaf.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Bread - 1.png"));
        jbtnBananaLoaf.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnBananaLoaf.setBounds(10, 106, 110, 98);
        panel_Bread.add(jbtnBananaLoaf);

        //-----Blueberry Muffin-----
        JButton jbtnBlueberryMuffin = new JButton("");
        jbtnBlueberryMuffin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 90;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Blueberry Muffin", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnBlueberryMuffin.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Bread - 2.png"));
        jbtnBlueberryMuffin.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnBlueberryMuffin.setBounds(10, 215, 110, 98);
        panel_Bread.add(jbtnBlueberryMuffin);

        //-----Butter Croissant-----
        JButton jbtnButterCroissant = new JButton("");
        jbtnButterCroissant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 100;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Butter Croissant", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnButterCroissant.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Bread - 3.png"));
        jbtnButterCroissant.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnButterCroissant.setBounds(10, 324, 110, 98);
        panel_Bread.add(jbtnButterCroissant);

        //-----Cheese Roll-----
        JButton jbtnCheeseRoll = new JButton("");
        jbtnCheeseRoll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 65;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Cheese Roll", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnCheeseRoll.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Bread - 4.png"));
        jbtnCheeseRoll.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnCheeseRoll.setBounds(10, 433, 110, 98);
        panel_Bread.add(jbtnCheeseRoll);

        //-----Chocolate Brownies-----
        JButton jbtnChocolateBrownies = new JButton("");
        jbtnChocolateBrownies.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 95;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Chocolate Brownies", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnChocolateBrownies.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Bread - 5.png"));
        jbtnChocolateBrownies.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnChocolateBrownies.setBounds(131, 106, 110, 98);
        panel_Bread.add(jbtnChocolateBrownies);

        //-----Cinnamon Bun-----
        JButton jbtnCinnamonBun = new JButton("");
        jbtnCinnamonBun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 125;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Cinnamon Bun", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnCinnamonBun.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Bread - 6.png"));
        jbtnCinnamonBun.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnCinnamonBun.setBounds(131, 215, 110, 98);
        panel_Bread.add(jbtnCinnamonBun);

        //-----Classic Pandesal-----
        JButton jbtnClassicPandesal = new JButton("");
        jbtnClassicPandesal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 50;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Classic Pandesal", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnClassicPandesal.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Bread - 7.png"));
        jbtnClassicPandesal.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnClassicPandesal.setBounds(131, 324, 110, 98);
        panel_Bread.add(jbtnClassicPandesal);

        //-----Creamy Ensaimada-----
        JButton jbtnCreamyEnsaimada = new JButton("");
        jbtnCreamyEnsaimada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 115;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Creamy Ensaimada", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnCreamyEnsaimada.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Bread - 8.png"));
        jbtnCreamyEnsaimada.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnCreamyEnsaimada.setBounds(131, 433, 110, 98);
        panel_Bread.add(jbtnCreamyEnsaimada);

        //-----Crusty Baguette-----
        JButton jbtnCrustyBaguette = new JButton("");
        jbtnCrustyBaguette.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 130;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Crusty Baguette", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnCrustyBaguette.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Bread - 9.png"));
        jbtnCrustyBaguette.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnCrustyBaguette.setBounds(253, 106, 110, 98);
        panel_Bread.add(jbtnCrustyBaguette);

        //-----French Toast-----
        JButton jbtnFrenchToast = new JButton("");
        jbtnFrenchToast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 125;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"French Toast", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnFrenchToast.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Bread - 10.png"));
        jbtnFrenchToast.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnFrenchToast.setBounds(253, 215, 110, 98);
        panel_Bread.add(jbtnFrenchToast);

        //-----Garlic Bread-----
        JButton jbtnGarlicBread = new JButton("");
        jbtnGarlicBread.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 120;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Garlic Bread", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnGarlicBread.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Bread - 11.png"));
        jbtnGarlicBread.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnGarlicBread.setBounds(253, 324, 110, 98);
        panel_Bread.add(jbtnGarlicBread);

        //-----Glazed Doughnut-----
        JButton jbtnGlazedDoughnut = new JButton("");
        jbtnGlazedDoughnut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 90;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Glazed Doughnut", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnGlazedDoughnut.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Bread - 12.png"));
        jbtnGlazedDoughnut.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnGlazedDoughnut.setBounds(253, 433, 110, 98);
        panel_Bread.add(jbtnGlazedDoughnut);

        //-----Oatmeal Cookie-----
        JButton jbtnOatmealCookie = new JButton("");
        jbtnOatmealCookie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 75;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Oatmeal Cookie", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnOatmealCookie.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Bread - 13.png"));
        jbtnOatmealCookie.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnOatmealCookie.setBounds(375, 106, 110, 98);
        panel_Bread.add(jbtnOatmealCookie);

        //-----Pan De Coco-----
        JButton jbtnPanDeCoco = new JButton("");
        jbtnPanDeCoco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 70;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Pan De Coco", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnPanDeCoco.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Bread - 14.png"));
        jbtnPanDeCoco.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnPanDeCoco.setBounds(375, 215, 110, 98);
        panel_Bread.add(jbtnPanDeCoco);

        //-----Spanish Bread-----
        JButton jbtnSpanishBread = new JButton("");
        jbtnSpanishBread.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 70;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Spanish Bread", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnSpanishBread.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Bread - 15.png"));
        jbtnSpanishBread.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnSpanishBread.setBounds(375, 324, 110, 98);
        panel_Bread.add(jbtnSpanishBread);

        //-----Swiss Roll-----
        JButton jbtnSwissRoll = new JButton("");
        jbtnSwissRoll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 80;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Swiss Roll", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnSwissRoll.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Bread - 16.png"));
        jbtnSwissRoll.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnSwissRoll.setBounds(375, 433, 110, 98);
        panel_Bread.add(jbtnSwissRoll);

        //--------------------CAKE--------------------
        JPanel panel_Cake = new JPanel();
        panel_Cake.setBorder(new LineBorder(new Color(139, 69, 19), 5));
        tabbedPane.addTab("Cake", null, panel_Cake, null);
        panel_Cake.setLayout(null);

        JLabel jlblCake = new JLabel("");
        jlblCake.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Label - Cake.png"));
        jlblCake.setHorizontalAlignment(SwingConstants.CENTER);
        jlblCake.setFont(new Font("Arial Black", Font.BOLD, 20));
        jlblCake.setBounds(10, 36, 475, 48);
        panel_Cake.add(jlblCake);

        //-----Blueberry Cheese-----
        JButton jbtnBlueberryCheese = new JButton("");
        jbtnBlueberryCheese.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Cake - 1.png"));
        jbtnBlueberryCheese.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 1045;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Blueberry Cheesecake", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnBlueberryCheese.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnBlueberryCheese.setBounds(10, 106, 110, 98);
        panel_Cake.add(jbtnBlueberryCheese);

        //-----Caramel-----
        JButton jbtnCaramel = new JButton("");
        jbtnCaramel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 625;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Caramel Cake", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnCaramel.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Cake - 2.png"));
        jbtnCaramel.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnCaramel.setBounds(10, 215, 110, 98);
        panel_Cake.add(jbtnCaramel);

        //-----Carrot Walnut-----
        JButton jbtnCarrotWalnut = new JButton("");
        jbtnCarrotWalnut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 885;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Carrot Walnut Cake", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnCarrotWalnut.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Cake - 3.png"));
        jbtnCarrotWalnut.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnCarrotWalnut.setBounds(10, 324, 110, 98);
        panel_Cake.add(jbtnCarrotWalnut);

        //-----Choco Midnight-----
        JButton jbtnChocoMidnight = new JButton("");
        jbtnChocoMidnight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 630;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Choco Midnight Cake", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnChocoMidnight.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Cake - 4.png"));
        jbtnChocoMidnight.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnChocoMidnight.setBounds(10, 433, 110, 98);
        panel_Cake.add(jbtnChocoMidnight);

        //-----Decadent-----
        JButton jbtnDecadent = new JButton("");
        jbtnDecadent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 550;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Decadent Cake", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnDecadent.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Cake - 5.png"));
        jbtnDecadent.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnDecadent.setBounds(131, 106, 110, 98);
        panel_Cake.add(jbtnDecadent);

        //-----Mango Torte-----
        JButton jbtnMangoTorte = new JButton("");
        jbtnMangoTorte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 900;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Mango Torte Cake", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnMangoTorte.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Cake - 6.png"));
        jbtnMangoTorte.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnMangoTorte.setBounds(131, 215, 110, 98);
        panel_Cake.add(jbtnMangoTorte);

        //-----Minimalist-----
        JButton jbtnMinimalist = new JButton("");
        jbtnMinimalist.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 670;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Minimalist Cake", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnMinimalist.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Cake - 7.png"));
        jbtnMinimalist.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnMinimalist.setBounds(131, 324, 110, 98);
        panel_Cake.add(jbtnMinimalist);

        //-----Mocha-----
        JButton jbtnMochaCake = new JButton("");
        jbtnMochaCake.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 475;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Mocha Cake", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnMochaCake.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Cake - 8.png"));
        jbtnMochaCake.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnMochaCake.setBounds(131, 433, 110, 98);
        panel_Cake.add(jbtnMochaCake);

        //-----Moist Chocolate-----
        JButton jbtnMoistChocolate = new JButton("");
        jbtnMoistChocolate.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Cake - 9.png"));
        jbtnMoistChocolate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 585;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Moist Chocolate Cake", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnMoistChocolate.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnMoistChocolate.setBounds(253, 106, 110, 98);
        panel_Cake.add(jbtnMoistChocolate);

        //-----New York Cheese-----
        JButton jbtnNewYorkCheese = new JButton("");
        jbtnNewYorkCheese.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 1200;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"New York Cheesecake", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnNewYorkCheese.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Cake - 10.png"));
        jbtnNewYorkCheese.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnNewYorkCheese.setBounds(253, 215, 110, 98);
        panel_Cake.add(jbtnNewYorkCheese);

        //-----Oreo Cheese-----
        JButton jbtnOreoCheese = new JButton("");
        jbtnOreoCheese.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 1045;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Oreo Cheesecake", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnOreoCheese.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Cake - 11.png"));
        jbtnOreoCheese.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnOreoCheese.setBounds(253, 324, 110, 98);
        panel_Cake.add(jbtnOreoCheese);

        //-----Pistachio Sansrival-----
        JButton jbtnPistachioSansrival = new JButton("");
        jbtnPistachioSansrival.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 680;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Pistachio Sansrival Cake", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnPistachioSansrival.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Cake - 12.png"));
        jbtnPistachioSansrival.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnPistachioSansrival.setBounds(253, 433, 110, 98);
        panel_Cake.add(jbtnPistachioSansrival);

        //-----Red Velvet-----
        JButton jbtnRedVelvet = new JButton("");
        jbtnRedVelvet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 685;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Red Velvet Cake", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnRedVelvet.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Cake - 13.png"));
        jbtnRedVelvet.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnRedVelvet.setBounds(375, 106, 110, 98);
        panel_Cake.add(jbtnRedVelvet);

        //-----Toblerone-----
        JButton jbtnToblerone = new JButton("");
        jbtnToblerone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 600;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Toblerone Cake", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnToblerone.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Cake - 14.png"));
        jbtnToblerone.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnToblerone.setBounds(375, 215, 110, 98);
        panel_Cake.add(jbtnToblerone);

        //-----Ube Pastillas-----
        JButton jbtnUbePastillas = new JButton("");
        jbtnUbePastillas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 670;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Ube Pastillas Cake", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnUbePastillas.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Cake - 15.png"));
        jbtnUbePastillas.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnUbePastillas.setBounds(375, 324, 110, 98);
        panel_Cake.add(jbtnUbePastillas);

        //-----Yema-----
        JButton jbtnYema = new JButton("");
        jbtnYema.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double priceOfItem = 625;
                DefaultTableModel model = (DefaultTableModel) table_OrderList.getModel();
                model.addRow(new Object[] {"Yema Cake", "1", priceOfItem});
                ItemCost();
            }
        });
        jbtnYema.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Cake - 16.png"));
        jbtnYema.setFont(new Font("Arial", Font.BOLD, 48));
        jbtnYema.setBounds(375, 433, 110, 98);
        panel_Cake.add(jbtnYema);
        //============================================MENU BUTTONS (END)============================================

        //****************************************************************************************************************

        //============================================ORDER LIST (START)============================================
        JScrollPane scrollPane_OrderList = new JScrollPane();
        scrollPane_OrderList.setBounds(560, 28, 310, 572);
        frmPOS.getContentPane().add(scrollPane_OrderList);

        //-----Order List-----
        table_OrderList = new JTable();
        table_OrderList.setFont(new Font("Arial", Font.PLAIN, 12));
        table_OrderList.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Item", "Quantity", "Price"
                }
        ));
        table_OrderList.getColumnModel().getColumn(0).setPreferredWidth(120);
        table_OrderList.getColumnModel().getColumn(1).setPreferredWidth(60);
        scrollPane_OrderList.setViewportView(table_OrderList);
        //============================================ORDER LIST (END)============================================

        //****************************************************************************************************************

        //============================================BARCDODE (END)============================================
        jtxtBarcode = new JTextField();
        jtxtBarcode.setFont(new Font("3 of 9 Barcode", Font.PLAIN, 50));
        jtxtBarcode.setBounds(560, 611, 310, 62);
        frmPOS.getContentPane().add(jtxtBarcode);
        jtxtBarcode.setColumns(10);
        //============================================BARCODE (END)============================================

        //****************************************************************************************************************

        //============================================TOTAL SALE DETAILS (START)============================================
        JPanel panel_TotalSale = new JPanel();
        panel_TotalSale.setBounds(885, 28, 436, 148);
        frmPOS.getContentPane().add(panel_TotalSale);
        panel_TotalSale.setLayout(null);
        panel_TotalSale.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

        //-----SubTotal-----
        JLabel jlblSubTotal = new JLabel("SubTotal");
        jlblSubTotal.setBounds(10, 11, 130, 35);
        panel_TotalSale.add(jlblSubTotal);
        jlblSubTotal.setFont(new Font("Arial", Font.BOLD, 20));

        jtxtSubTotal = new JTextField();
        jtxtSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
        jtxtSubTotal.setFont(new Font("Arial", Font.PLAIN, 18));
        jtxtSubTotal.setBounds(138, 12, 288, 35);
        panel_TotalSale.add(jtxtSubTotal);
        jtxtSubTotal.setColumns(10);

        //-----Tax-----
        JLabel jlblTax = new JLabel("Tax");
        jlblTax.setFont(new Font("Arial", Font.BOLD, 20));
        jlblTax.setBounds(10, 57, 130, 35);
        panel_TotalSale.add(jlblTax);

        jtxtTax = new JTextField();
        jtxtTax.setHorizontalAlignment(SwingConstants.CENTER);
        jtxtTax.setFont(new Font("Arial", Font.PLAIN, 18));
        jtxtTax.setColumns(10);
        jtxtTax.setBounds(138, 57, 288, 35);
        panel_TotalSale.add(jtxtTax);

        //-----Total Sale-----
        JLabel jlblTotalSale = new JLabel("Total Sale");
        jlblTotalSale.setFont(new Font("Arial", Font.BOLD, 20));
        jlblTotalSale.setBounds(10, 103, 130, 35);
        panel_TotalSale.add(jlblTotalSale);

        jtxtTotalSale = new JTextField();
        jtxtTotalSale.setHorizontalAlignment(SwingConstants.CENTER);
        jtxtTotalSale.setFont(new Font("Arial", Font.PLAIN, 18));
        jtxtTotalSale.setColumns(10);
        jtxtTotalSale.setBounds(138, 104, 288, 35);
        panel_TotalSale.add(jtxtTotalSale);
        //============================================TOTAL SALE DETAILS (END)============================================

        //****************************************************************************************************************

        //============================================CHANGE DUE DETAILS (START)============================================
        JPanel panel_ChangeDue = new JPanel();
        panel_ChangeDue.setBounds(885, 190, 436, 148);
        frmPOS.getContentPane().add(panel_ChangeDue);
        panel_ChangeDue.setLayout(null);
        panel_ChangeDue.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

        //-----Payment Method-----
        JLabel jlblPaymentMethod = new JLabel("Payment Method");
        jlblPaymentMethod.setFont(new Font("Arial", Font.BOLD, 15));
        jlblPaymentMethod.setBounds(10, 11, 130, 35);
        panel_ChangeDue.add(jlblPaymentMethod);

        JComboBox jcbxPaymentMethod = new JComboBox();
        jcbxPaymentMethod.setModel(new DefaultComboBoxModel(new String[] {"", "Cash", "Credit Card", "Debit Card"}));
        jcbxPaymentMethod.setFont(new Font("Arial", Font.BOLD, 18));
        jcbxPaymentMethod.setBounds(138, 11, 288, 35);
        panel_ChangeDue.add(jcbxPaymentMethod);

        //-----Amount Paid-----
        JLabel jlblAmountPaid = new JLabel("Amount Paid");
        jlblAmountPaid.setBounds(10, 61, 130, 35);
        panel_ChangeDue.add(jlblAmountPaid);
        jlblAmountPaid.setFont(new Font("Arial", Font.BOLD, 18));

        jtxtAmountPaid = new JTextField();
        jtxtAmountPaid.setHorizontalAlignment(SwingConstants.CENTER);
        jtxtAmountPaid.setFont(new Font("Arial", Font.PLAIN, 18));
        jtxtAmountPaid.setColumns(10);
        jtxtAmountPaid.setBounds(138, 60, 288, 35);
        panel_ChangeDue.add(jtxtAmountPaid);

        //-----Change Due-----
        JLabel jlblChangeDue = new JLabel("Change Due");
        jlblChangeDue.setFont(new Font("Arial", Font.BOLD, 20));
        jlblChangeDue.setBounds(10, 107, 130, 35);
        panel_ChangeDue.add(jlblChangeDue);

        jtxtChangeDue = new JTextField();
        jtxtChangeDue.setHorizontalAlignment(SwingConstants.CENTER);
        jtxtChangeDue.setFont(new Font("Arial", Font.PLAIN, 18));
        jtxtChangeDue.setColumns(10);
        jtxtChangeDue.setBounds(138, 107, 288, 35);
        panel_ChangeDue.add(jtxtChangeDue);
        //============================================CHANGE DUE DETAILS (END)============================================

        //****************************************************************************************************************

        //============================================FUNCTIONAL BUTTONS (START)============================================
        JPanel panel_FunctionalBtn = new JPanel();
        panel_FunctionalBtn.setBounds(1128, 352, 193, 324);
        frmPOS.getContentPane().add(panel_FunctionalBtn);
        panel_FunctionalBtn.setLayout(null);
        panel_FunctionalBtn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

        //-----Pay-----
        JButton jbtnPay = new JButton("Pay");
        jbtnPay.setBounds(14, 11, 165, 42);
        panel_FunctionalBtn.add(jbtnPay);
        jbtnPay.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Button - Pay.png"));
        jbtnPay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(jcbxPaymentMethod.getSelectedItem().equals("Cash"))
                {
                    Change();
                }
                else
                {
                    jtxtChangeDue.setText("");
                    jtxtAmountPaid.setText("");
                }
            }
        });
        jbtnPay.setFont(new Font("Arial", Font.BOLD, 16));

        //-----Orders-----
        JButton jbtnOrders = new JButton("Orders");
        jbtnOrders.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Button - Orders.png"));
        jbtnOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MessageFormat Header = new MessageFormat("J&R Coffeehouse - Order List");
                MessageFormat Footer = new MessageFormat("Page {0, number, integer}");

                try
                {
                    table_OrderList.print(JTable.PrintMode.NORMAL, Header, Footer);
                }
                catch(java.awt.print.PrinterException ex)
                {
                    System.err.format("No Printer found", ex.getMessage());
                }

            }
        });
        jbtnOrders.setFont(new Font("Arial", Font.BOLD, 15));
        jbtnOrders.setBounds(14, 63, 165, 42);
        panel_FunctionalBtn.add(jbtnOrders);

        //-----Receipt-----
        JButton jbtnReceipt = new JButton("Receipt");
        jbtnReceipt.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Button - Receipt.png"));
        jbtnReceipt.setBounds(14, 115, 165, 42);
        panel_FunctionalBtn.add(jbtnReceipt);
        jbtnReceipt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TableModel table = table_OrderList.getModel();
                String outputBarcode = jtxtBarcode.getText();
                String outputSubTotal = jtxtSubTotal.getText();
                String outputTax = jtxtTax.getText();
                String outputTotalSale = jtxtTotalSale.getText();
                String inputAmountPaid = jtxtAmountPaid.getText();
                String outputChangeDue = jtxtChangeDue.getText();

                CoffeeShopPOS3 window = new CoffeeShopPOS3();
                window.table_OutputOrderList.setModel(table);
                window.txtOutputBarcode.setText(outputBarcode);
                window.lblOutputSubtotal.setText(outputSubTotal);
                window.lblOutputTax.setText(outputTax);
                window.lblOutputTotalSale.setText(outputTotalSale);
                window.lblInputAmountPaid.setText(inputAmountPaid);
                window.lblOutputChangeDue.setText(outputChangeDue);

                window.frmReceipt.setVisible(true);
                frmPOS.dispose();
            }
        });
        jbtnReceipt.setFont(new Font("Arial", Font.BOLD, 16));

        //-----Remove-----
        JButton jbtnRemove = new JButton("Remove");
        jbtnRemove.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Button - Remove.png"));
        jbtnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel Model = (DefaultTableModel) table_OrderList.getModel();

                int DeleteItem = table_OrderList.getSelectedRow();
                if(DeleteItem >= 0)
                {
                    Model.removeRow(DeleteItem);
                }

                ItemCost();

                if(jcbxPaymentMethod.getSelectedItem().equals("Cash"))
                {
                    Change();
                }
                else
                {
                    jtxtChangeDue.setText("");
                    jtxtAmountPaid.setText("");
                }
            }
        });
        jbtnRemove.setFont(new Font("Arial", Font.BOLD, 16));
        jbtnRemove.setBounds(14, 166, 165, 42);
        panel_FunctionalBtn.add(jbtnRemove);

        //-----Reset-----
        JButton jbtnReset = new JButton("Reset");
        jbtnReset.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Button - Reset.png"));
        jbtnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                jtxtSubTotal.setText(null);
                jtxtTax.setText(null);
                jtxtTotalSale.setText(null);
                jtxtAmountPaid.setText(null);
                jtxtChangeDue.setText(null);
                jtxtBarcode.setText(null);

                DefaultTableModel RecordTable = (DefaultTableModel) table_OrderList.getModel();
                RecordTable.setRowCount(0);

            }

        });
        jbtnReset.setFont(new Font("Arial", Font.BOLD, 16));
        jbtnReset.setBounds(14, 219, 165, 42);
        panel_FunctionalBtn.add(jbtnReset);

        //-----Back-----
        JButton jbtnBack = new JButton("Back");
        jbtnBack.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Button - Back.png"));
        jbtnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmPOS.setVisible(false);
                CoffeeShopPOS1 window = new CoffeeShopPOS1();
                window.main(null);

            }
        });
        jbtnBack.setFont(new Font("Arial", Font.BOLD, 16));
        jbtnBack.setBounds(14, 271, 165, 42);
        panel_FunctionalBtn.add(jbtnBack);
        //============================================OTHER BUTTONS (END)============================================

        //****************************************************************************************************************

        //============================================NUMERIC BUTTON (START)============================================
        JPanel panel_NumericBtn = new JPanel();
        panel_NumericBtn.setBounds(885, 352, 228, 324);
        frmPOS.getContentPane().add(panel_NumericBtn);
        panel_NumericBtn.setLayout(null);
        panel_NumericBtn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

        //-----7-----
        JButton jbtn7 = new JButton("7");
        jbtn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enterNumber = jtxtAmountPaid.getText();

                if(enterNumber == "")
                {
                    jtxtAmountPaid.setText(jbtn7.getText());
                }
                else
                {
                    enterNumber = jtxtAmountPaid.getText() + jbtn7.getText();
                    jtxtAmountPaid.setText(enterNumber);
                }
            }
        });
        jbtn7.setFont(new Font("Arial", Font.BOLD, 35));
        jbtn7.setBounds(14, 11, 60, 65);
        panel_NumericBtn.add(jbtn7);

        //-----8-----
        JButton jbtn8 = new JButton("8");
        jbtn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enterNumber = jtxtAmountPaid.getText();

                if(enterNumber == "")
                {
                    jtxtAmountPaid.setText(jbtn8.getText());
                }
                else
                {
                    enterNumber = jtxtAmountPaid.getText() + jbtn8.getText();
                    jtxtAmountPaid.setText(enterNumber);
                }
            }
        });
        jbtn8.setFont(new Font("Arial", Font.BOLD, 35));
        jbtn8.setBounds(84, 11, 60, 65);
        panel_NumericBtn.add(jbtn8);

        //-----9-----
        JButton jbtn9 = new JButton("9");
        jbtn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enterNumber = jtxtAmountPaid.getText();

                if(enterNumber == "")
                {
                    jtxtAmountPaid.setText(jbtn9.getText());
                }
                else
                {
                    enterNumber = jtxtAmountPaid.getText() + jbtn9.getText();
                    jtxtAmountPaid.setText(enterNumber);
                }
            }
        });
        jbtn9.setFont(new Font("Arial", Font.BOLD, 35));
        jbtn9.setBounds(154, 11, 60, 65);
        panel_NumericBtn.add(jbtn9);

        //-----4-----
        JButton jbtn4 = new JButton("4");
        jbtn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enterNumber = jtxtAmountPaid.getText();

                if(enterNumber == "")
                {
                    jtxtAmountPaid.setText(jbtn4.getText());
                }
                else
                {
                    enterNumber = jtxtAmountPaid.getText() + jbtn4.getText();
                    jtxtAmountPaid.setText(enterNumber);
                }
            }
        });
        jbtn4.setFont(new Font("Arial", Font.BOLD, 35));
        jbtn4.setBounds(14, 90, 60, 65);
        panel_NumericBtn.add(jbtn4);

        //-----5-----
        JButton jbtn5 = new JButton("5");
        jbtn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enterNumber = jtxtAmountPaid.getText();

                if(enterNumber == "")
                {
                    jtxtAmountPaid.setText(jbtn5.getText());
                }
                else
                {
                    enterNumber = jtxtAmountPaid.getText() + jbtn5.getText();
                    jtxtAmountPaid.setText(enterNumber);
                }
            }
        });
        jbtn5.setFont(new Font("Arial", Font.BOLD, 35));
        jbtn5.setBounds(84, 90, 60, 65);
        panel_NumericBtn.add(jbtn5);

        //-----6-----
        JButton jbtn6 = new JButton("6");
        jbtn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enterNumber = jtxtAmountPaid.getText();

                if(enterNumber == "")
                {
                    jtxtAmountPaid.setText(jbtn6.getText());
                }
                else
                {
                    enterNumber = jtxtAmountPaid.getText() + jbtn6.getText();
                    jtxtAmountPaid.setText(enterNumber);
                }
            }
        });
        jbtn6.setFont(new Font("Arial", Font.BOLD, 35));
        jbtn6.setBounds(154, 90, 60, 65);
        panel_NumericBtn.add(jbtn6);

        //-----1-----
        JButton jbtn1 = new JButton("1");
        jbtn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enterNumber = jtxtAmountPaid.getText();

                if(enterNumber == "")
                {
                    jtxtAmountPaid.setText(jbtn1.getText());
                }
                else
                {
                    enterNumber = jtxtAmountPaid.getText() + jbtn1.getText();
                    jtxtAmountPaid.setText(enterNumber);
                }
            }

        });
        jbtn1.setFont(new Font("Arial", Font.BOLD, 35));
        jbtn1.setBounds(14, 170, 60, 65);
        panel_NumericBtn.add(jbtn1);

        //-----2-----
        JButton jbtn2 = new JButton("2");
        jbtn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enterNumber = jtxtAmountPaid.getText();

                if(enterNumber == "")
                {
                    jtxtAmountPaid.setText(jbtn2.getText());
                }
                else
                {
                    enterNumber = jtxtAmountPaid.getText() + jbtn2.getText();
                    jtxtAmountPaid.setText(enterNumber);
                }
            }
        });
        jbtn2.setFont(new Font("Arial", Font.BOLD, 35));
        jbtn2.setBounds(84, 170, 60, 65);
        panel_NumericBtn.add(jbtn2);

        //-----3-----
        JButton jbtn3 = new JButton("3");
        jbtn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enterNumber = jtxtAmountPaid.getText();

                if(enterNumber == "")
                {
                    jtxtAmountPaid.setText(jbtn3.getText());
                }
                else
                {
                    enterNumber = jtxtAmountPaid.getText() + jbtn3.getText();
                    jtxtAmountPaid.setText(enterNumber);
                }
            }
        });
        jbtn3.setFont(new Font("Arial", Font.BOLD, 35));
        jbtn3.setBounds(154, 170, 60, 65);
        panel_NumericBtn.add(jbtn3);

        //-----0-----
        JButton jbtn0 = new JButton("0");
        jbtn0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enterNumber = jtxtAmountPaid.getText();

                if(enterNumber == "")
                {
                    jtxtAmountPaid.setText(jbtn0.getText());
                }
                else
                {
                    enterNumber = jtxtAmountPaid.getText() + jbtn0.getText();
                    jtxtAmountPaid.setText(enterNumber);
                }
            }
        });
        jbtn0.setFont(new Font("Arial", Font.BOLD, 35));
        jbtn0.setBounds(14, 248, 60, 65);
        panel_NumericBtn.add(jbtn0);

        //-----Point-----
        JButton jbtnPoint = new JButton(".");
        jbtnPoint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(! jtxtAmountPaid.getText().contains("."))
                {
                    jtxtAmountPaid.setText(jtxtAmountPaid.getText() + jbtnPoint.getText());
                }
            }
        });
        jbtnPoint.setFont(new Font("Arial", Font.BOLD, 35));
        jbtnPoint.setBounds(84, 248, 60, 65);
        panel_NumericBtn.add(jbtnPoint);

        //-----Clear-----
        JButton jbtnClear = new JButton("C");
        jbtnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jtxtAmountPaid.setText(null);
                jtxtChangeDue.setText(null);

            }
        });
        jbtnClear.setFont(new Font("Arial", Font.BOLD, 30));
        jbtnClear.setBounds(154, 248, 60, 65);
        panel_NumericBtn.add(jbtnClear);
        //============================================NUMBERS BUTTONS (END)============================================
    }
}

