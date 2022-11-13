package packagePointOfSaleSystem;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CoffeeShopPOS1 {

    private JFrame frmHome;

    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("Application Icon.png"));

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CoffeeShopPOS1 window = new CoffeeShopPOS1();
                    window.frmHome.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public CoffeeShopPOS1() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmHome = new JFrame();
        frmHome.setTitle("Introductory");
        frmHome.getContentPane().setBackground(new Color(238, 232, 170));
        frmHome.getContentPane().setLayout(null);
        frmHome.setIconImage(icon.getImage());

        JPanel panel_CoffeeShopIntro = new JPanel();
        panel_CoffeeShopIntro.setBackground(new Color(238, 232, 170));
        panel_CoffeeShopIntro.setBorder(new LineBorder(new Color(139, 69, 19), 5));
        panel_CoffeeShopIntro.setBounds(94, 84, 1170, 398);
        frmHome.getContentPane().add(panel_CoffeeShopIntro);
        panel_CoffeeShopIntro.setLayout(null);

        JLabel lblCoffeeShop = new JLabel("");
        lblCoffeeShop.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Label - Introductory Window.png"));
        lblCoffeeShop.setBounds(40, 36, 1088, 326);
        panel_CoffeeShopIntro.add(lblCoffeeShop);


        //--------------------POINT-OF-SALE SYSTEM (START)--------------------
        JButton jbtnPointOfSaleSystem = new JButton("");
        jbtnPointOfSaleSystem.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Button - POS.png"));
        jbtnPointOfSaleSystem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //-----POS System Window-----
                CoffeeShopPOS2 nw = new CoffeeShopPOS2();
                nw.frmPOS.setVisible(true);
                frmHome.dispose();

            }


        });
        jbtnPointOfSaleSystem.setBounds(163, 526, 480, 96);
        //--------------------POINT-OF-SALE SYSTEM (END)--------------------


        frmHome.getContentPane().add(jbtnPointOfSaleSystem);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frmHome.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
        frmHome.setLocationRelativeTo(null);
        frmHome.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmHome.getContentPane().setLayout(null);


        //--------------------EXIT (START)--------------------
        JButton jbtnExit = new JButton("");
        jbtnExit.setIcon(new ImageIcon("C:\\Users\\Rosh Torres\\Documents\\New Era University\\OOP Project - Coffee Shop POS\\Button - Exit.png"));
        jbtnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmHome = new JFrame("Exit");

                if(JOptionPane.showConfirmDialog(frmHome, "Confirm if you want to exit", "Point of Sale",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
                {
                    System.exit(0);
                }
            }
        });
        jbtnExit.setBounds(706, 526, 480, 96);
        frmHome.getContentPane().add(jbtnExit);
        //--------------------EXIT (END)--------------------

    }
}
