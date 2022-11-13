package packagePointOfSaleSystem;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;

public class CoffeeShopPOS3 {

    JFrame frmReceipt;
    JTable table_OutputOrderList;
    JTextField txtOutputBarcode;
    JLabel lblOutputSubtotal;
    JLabel lblOutputTax;
    JLabel lblOutputTotalSale;
    JLabel lblInputAmountPaid;
    JLabel lblOutputChangeDue;
    private JLabel Time;
    private JLabel Date;

    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("Application Icon.png"));

    /**
     * Launch the application.
     */
    public static void Receipt() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CoffeeShopPOS3 window = new CoffeeShopPOS3();
                    window.frmReceipt.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    //--------------------TIME AND DATE (START)--------------------
    public void clock()
    {
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int year = cal.get(Calendar.YEAR);

        int hour = cal.get(Calendar.HOUR);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);

        if(hour == 0)
        {
            Time.setText(12 + ":" + min + ":" + sec);
        }
        else
        {
            Time.setText(hour + ":" + min + ":" + sec);
        }
        Date.setText(month + 1 + "-" + day + "-" + year);
    }
    //--------------------TIME AND DATE (END)--------------------


    /**
     * Create the application.
     */
    public CoffeeShopPOS3() {
        initialize();
        clock();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmReceipt = new JFrame();
        frmReceipt.setTitle("Receipt");
        frmReceipt.getContentPane().setBackground(new Color(238, 232, 170));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frmReceipt.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
        frmReceipt.setLocationRelativeTo(null);
        frmReceipt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmReceipt.getContentPane().setLayout(null);
        frmReceipt.setIconImage(icon.getImage());

        JLabel jlblReceipt = new JLabel("");
        jlblReceipt.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Label - Receipt.png"));
        jlblReceipt.setHorizontalAlignment(SwingConstants.CENTER);
        jlblReceipt.setFont(new Font("Arial Black", Font.BOLD, 20));
        jlblReceipt.setBounds(316, 40, 732, 35);
        frmReceipt.getContentPane().add(jlblReceipt);


        //--------------------RECEIPT (START)--------------------
        JPanel panel_Receipt = new JPanel();
        panel_Receipt.setBorder(new LineBorder(new Color(139, 69, 19), 5));
        panel_Receipt.setBackground(new Color(255, 255, 224));
        panel_Receipt.setBounds(316, 93, 732, 501);
        frmReceipt.getContentPane().add(panel_Receipt);
        panel_Receipt.setLayout(null);

        //-----Order List-----
        JScrollPane scrollPane_OutputOrderList = new JScrollPane();
        scrollPane_OutputOrderList.setBounds(30, 29, 310, 368);
        panel_Receipt.add(scrollPane_OutputOrderList);

        table_OutputOrderList = new JTable();
        table_OutputOrderList.setFont(new Font("Arial", Font.PLAIN, 13));
        table_OutputOrderList.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Item", "Quantity", "Price"
                }
        ));
        table_OutputOrderList.getColumnModel().getColumn(0).setPreferredWidth(120);
        table_OutputOrderList.getColumnModel().getColumn(1).setPreferredWidth(60);
        scrollPane_OutputOrderList.setViewportView(table_OutputOrderList);

        //-----Barcode-----
        txtOutputBarcode = new JTextField();
        txtOutputBarcode.setFont(new Font("3 of 9 Barcode", Font.PLAIN, 50));
        txtOutputBarcode.setColumns(10);
        txtOutputBarcode.setBounds(30, 408, 310, 62);
        panel_Receipt.add(txtOutputBarcode);
        //--------------------RECEIPT (END)--------------------


        JLabel jlblCoffeeShop = new JLabel("");
        jlblCoffeeShop.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Label - Receipt Window.png"));
        jlblCoffeeShop.setHorizontalAlignment(SwingConstants.CENTER);
        jlblCoffeeShop.setFont(new Font("Arial Black", Font.BOLD, 20));
        jlblCoffeeShop.setBounds(352, 29, 347, 107);
        panel_Receipt.add(jlblCoffeeShop);


        //--------------------CLOCK (START)--------------------
        JPanel panel_Clock = new JPanel();
        panel_Clock.setLayout(null);
        panel_Clock.setBounds(352, 147, 347, 96);
        panel_Receipt.add(panel_Clock);

        //-----Time-----
        JLabel lblTime = new JLabel("Time:");
        lblTime.setFont(new Font("Arial", Font.PLAIN, 18));
        lblTime.setBounds(10, 11, 159, 31);
        panel_Clock.add(lblTime);

        Time = new JLabel("0");
        Time.setHorizontalAlignment(SwingConstants.CENTER);
        Time.setFont(new Font("Arial", Font.PLAIN, 18));
        Time.setBounds(178, 11, 159, 31);
        panel_Clock.add(Time);

        //-----Date-----
        JLabel lblDate = new JLabel("Date:");
        lblDate.setFont(new Font("Arial", Font.PLAIN, 18));
        lblDate.setBounds(10, 53, 159, 31);
        panel_Clock.add(lblDate);

        Date = new JLabel("0");
        Date.setHorizontalAlignment(SwingConstants.CENTER);
        Date.setFont(new Font("Arial", Font.PLAIN, 18));
        Date.setBounds(178, 53, 159, 31);
        panel_Clock.add(Date);
        //--------------------CLOCK (END)--------------------


        //--------------------TOTAL AND CHANGE (START)--------------------
        JPanel panel_TotalAndChange = new JPanel();
        panel_TotalAndChange.setBounds(352, 254, 347, 216);
        panel_Receipt.add(panel_TotalAndChange);
        panel_TotalAndChange.setLayout(null);

        //-----SubTotal-----
        JLabel lblSubtotal = new JLabel("SubTotal:");
        lblSubtotal.setFont(new Font("Arial", Font.PLAIN, 18));
        lblSubtotal.setBounds(10, 11, 159, 31);
        panel_TotalAndChange.add(lblSubtotal);

        lblOutputSubtotal = new JLabel("0");
        lblOutputSubtotal.setHorizontalAlignment(SwingConstants.CENTER);
        lblOutputSubtotal.setFont(new Font("Arial", Font.PLAIN, 18));
        lblOutputSubtotal.setBounds(178, 11, 159, 31);
        panel_TotalAndChange.add(lblOutputSubtotal);

        //-----Tax-----
        JLabel lblTax = new JLabel("Tax:");
        lblTax.setFont(new Font("Arial", Font.PLAIN, 18));
        lblTax.setBounds(10, 53, 159, 31);
        panel_TotalAndChange.add(lblTax);

        lblOutputTax = new JLabel("0");
        lblOutputTax.setHorizontalAlignment(SwingConstants.CENTER);
        lblOutputTax.setFont(new Font("Arial", Font.PLAIN, 18));
        lblOutputTax.setBounds(178, 53, 159, 31);
        panel_TotalAndChange.add(lblOutputTax);

        //-----Total Sale-----
        JLabel lblTotalSale = new JLabel("Total Sale:");
        lblTotalSale.setFont(new Font("Arial", Font.PLAIN, 18));
        lblTotalSale.setBounds(10, 95, 159, 31);
        panel_TotalAndChange.add(lblTotalSale);

        lblOutputTotalSale = new JLabel("0");
        lblOutputTotalSale.setHorizontalAlignment(SwingConstants.CENTER);
        lblOutputTotalSale.setFont(new Font("Arial", Font.PLAIN, 18));
        lblOutputTotalSale.setBounds(178, 95, 159, 31);
        panel_TotalAndChange.add(lblOutputTotalSale);

        //-----Amount Paid-----
        JLabel lblAmountPaid = new JLabel("Amount Paid:");
        lblAmountPaid.setFont(new Font("Arial", Font.PLAIN, 18));
        lblAmountPaid.setBounds(10, 137, 159, 31);
        panel_TotalAndChange.add(lblAmountPaid);

        lblInputAmountPaid = new JLabel("0");
        lblInputAmountPaid.setHorizontalAlignment(SwingConstants.CENTER);
        lblInputAmountPaid.setFont(new Font("Arial", Font.PLAIN, 18));
        lblInputAmountPaid.setBounds(178, 137, 159, 31);
        panel_TotalAndChange.add(lblInputAmountPaid);

        //-----Change Due-----
        JLabel lblChangeDue = new JLabel("Change Due:");
        lblChangeDue.setFont(new Font("Arial", Font.PLAIN, 18));
        lblChangeDue.setBounds(10, 179, 159, 31);
        panel_TotalAndChange.add(lblChangeDue);

        lblOutputChangeDue = new JLabel("0");
        lblOutputChangeDue.setHorizontalAlignment(SwingConstants.CENTER);
        lblOutputChangeDue.setFont(new Font("Arial", Font.PLAIN, 18));
        lblOutputChangeDue.setBounds(178, 179, 159, 31);
        panel_TotalAndChange.add(lblOutputChangeDue);
        //--------------------TOTAL AND CHANGE (END)--------------------

        //--------------------BACK (START)--------------------
        JButton jbtnBack = new JButton("Back");
        jbtnBack.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Button - Back.png"));
        jbtnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CoffeeShopPOS2 window = new CoffeeShopPOS2();
                window.frmPOS.setVisible(true);
                frmReceipt.dispose();
            }
        });
        jbtnBack.setFont(new Font("Arial", Font.BOLD, 16));
        jbtnBack.setBounds(600, 618, 165, 42);
        frmReceipt.getContentPane().add(jbtnBack);
        //--------------------BACK (END)--------------------

    }
}
