/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.jakproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import org.json.simple.JSONObject;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author HP
 */
public class Purchases extends javax.swing.JFrame {

    /**
     * Creates new form Purchases
     */
    public Purchases() {
        initComponents();
        x1.setVisible(false);
        x0.setVisible(false);
        x2.setVisible(false);
        x3.setVisible(false);
        x4.setVisible(false);
        x5.setVisible(false);
        x6.setVisible(false);
        x7.setVisible(false);
        x8.setVisible(false);
        x9.setVisible(false);
        x10.setVisible(false);
        newcat.setVisible(false);
        catnew.setVisible(false);
        categorytxt.setVisible(false);
        catcombo.setVisible(false);
        sprice.setVisible(false);
        spricetxt.setVisible(false);
    }
    
            Purchases(String user){
        initComponents();
        
        Connect();
        
        Thread t = new Thread(){
            @Override
            public void run(){
                while(true){
                    long millis = System.currentTimeMillis();
                    java.sql.Date sqlDate = new java.sql.Date(millis);
                    java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
                    DateFormat dateFormat = new SimpleDateFormat("hh : mm : ss aa");
                    SimpleDateFormat sd = new SimpleDateFormat("dd-mm-yyyy");
                    final String stringDate = dateFormat.format(utilDate);
                    final String daystr = sd.format(utilDate);
                    timetxt.setText(stringDate);
                    datetxt.setText(daystr);
                    
                    try{
                        Thread.sleep(1);
                    }
                    
                    catch(Exception e){
                        
                    }
                }
            }
        };
        
        t.start();
        
        usertxt.setText(user);
    }
    
    String s;
    JWindow w;
    
    Purchases(String s, int x, int y)
    {
        w = new JWindow();
  
        // make the background transparent
        w.setBackground(new Color(0, 0, 0, 0));
  
        // create a panel
        JPanel p = new JPanel() {
            @Override
            public void paintComponent(Graphics g)
            {
                int wid = g.getFontMetrics().stringWidth(s);
                int hei = g.getFontMetrics().getHeight();
  
                // draw the boundary of the toast and fill it
                g.setColor(Color.black);
                g.fillRect(10, 10, wid + 30, hei + 10);
                g.setColor(Color.black);
                g.drawRect(10, 10, wid + 30, hei + 10);
                 
                // set the color of text
                g.setColor(new Color(255, 255, 255, 240));
                g.drawString(s, 25, 27);
                int t = 250;
  
                // draw the shadow of the toast
                for (int i = 0; i < 4; i++) {
                    t -= 60;
                    g.setColor(new Color(0, 0, 0, t));
                    g.drawRect(10 - i, 10 - i, wid + 30 + i * 2,
                               hei + 10 + i * 2);
                }
            }
        };
  
        w.add(p);
        w.setLocation(x, y);
        w.setSize(300, 100);
    }
    
       // function to pop up the toast
    void showtoast()
    {
        try {
            w.setOpacity(1);
            w.setVisible(true);
  
            // wait for some time
            Thread.sleep(2000);
  
            // make the message disappear  slowly
            for (double d = 1.0; d > 0.2; d -= 0.1) {
                Thread.sleep(100);
                w.setOpacity((float)d);
            }
  
            // set the visibility to false
            w.setVisible(false);
                    }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

   
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/ddHH:mm:ss");  
                LocalDateTime now = LocalDateTime.now();
                
    
    public final void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

             con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jak_database","root","admin");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public final void Clear(){
        barcodetxt.setText("");
        producttxt.setText("");
        quantitytxt.setText("");
        bprice.setText("0.00");
        usdtxt.setText("0.00");
        randtxt.setText("0.00");
        zwltxt.setText("0.00");
        ecocashtxt.setText("0.00");
        swipetxt.setText("0.00");
        combopay.setSelectedIndex(0);
        x1.setVisible(false);
        x0.setVisible(false);
        x2.setVisible(false);
        x3.setVisible(false);
        x4.setVisible(false);
        x5.setVisible(false);
        x6.setVisible(false);
        x7.setVisible(false);
        x8.setVisible(false);
        x9.setVisible(false);
        x10.setVisible(false);
        newcat.setVisible(false);
        catnew.setVisible(false);
        categorytxt.setVisible(false);
        catcombo.setVisible(false);
        newitem.setSelected(false);
        newcat.setSelected(false);
        usdtxt.setVisible(true);
        randtxt.setVisible(true);
        zwltxt.setVisible(true);
        ecocashtxt.setVisible(true);
        swipetxt.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barcodetxt = new javax.swing.JTextField();
        productlable = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        barcodelable = new javax.swing.JLabel();
        producttxt = new javax.swing.JTextField();
        combopaylab = new javax.swing.JLabel();
        combopay = new javax.swing.JComboBox<>();
        usdlable = new javax.swing.JLabel();
        randlable = new javax.swing.JLabel();
        zwllable = new javax.swing.JLabel();
        ecocashlable = new javax.swing.JLabel();
        swipelable = new javax.swing.JLabel();
        usdtxt = new javax.swing.JTextField();
        randtxt = new javax.swing.JTextField();
        zwltxt = new javax.swing.JTextField();
        ecocashtxt = new javax.swing.JTextField();
        swipetxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        quantitytxt = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        x1 = new javax.swing.JLabel();
        x0 = new javax.swing.JLabel();
        x2 = new javax.swing.JLabel();
        x3 = new javax.swing.JLabel();
        x4 = new javax.swing.JLabel();
        x5 = new javax.swing.JLabel();
        x6 = new javax.swing.JLabel();
        x7 = new javax.swing.JLabel();
        x8 = new javax.swing.JLabel();
        newitem = new javax.swing.JCheckBox();
        newcat = new javax.swing.JCheckBox();
        catnew = new javax.swing.JTextField();
        categorytxt = new javax.swing.JLabel();
        catcombo = new javax.swing.JComboBox<>();
        spricetxt = new javax.swing.JLabel();
        x9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bprice = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        sprice = new javax.swing.JTextField();
        x10 = new javax.swing.JLabel();
        datetxt = new javax.swing.JLabel();
        timetxt = new javax.swing.JLabel();
        usertxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        barcodetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barcodetxtActionPerformed(evt);
            }
        });
        barcodetxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                barcodetxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                barcodetxtKeyReleased(evt);
            }
        });

        productlable.setText("Barcode");

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Purchase");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        barcodelable.setText("Product");

        producttxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                producttxtKeyReleased(evt);
            }
        });

        combopaylab.setText("Paytype used");

        combopay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "      ", "USD", "RAND", "ZWL CASH", "ECOCASH", "SWIPE", "MIXED" }));
        combopay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combopayActionPerformed(evt);
            }
        });

        usdlable.setText("USD");

        randlable.setText("RAND");

        zwllable.setText("ZWL CASH");

        ecocashlable.setText("ECOCASH");

        swipelable.setText("SWIPE");

        usdtxt.setText("0.00");
        usdtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usdtxtKeyReleased(evt);
            }
        });

        randtxt.setText("0.00");
        randtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                randtxtKeyReleased(evt);
            }
        });

        zwltxt.setText("0.00");
        zwltxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                zwltxtKeyReleased(evt);
            }
        });

        ecocashtxt.setText("0.00");
        ecocashtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ecocashtxtKeyReleased(evt);
            }
        });

        swipetxt.setText("0.00");
        swipetxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                swipetxtKeyReleased(evt);
            }
        });

        jLabel1.setText("Quantity");

        quantitytxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantitytxtKeyReleased(evt);
            }
        });

        jButton4.setText("Next");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        x1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        x1.setForeground(new java.awt.Color(255, 0, 51));
        x1.setText("X");

        x0.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        x0.setForeground(new java.awt.Color(255, 0, 51));
        x0.setText("X");

        x2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        x2.setForeground(new java.awt.Color(255, 0, 51));
        x2.setText("X");

        x3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        x3.setForeground(new java.awt.Color(255, 0, 51));
        x3.setText("X");

        x4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        x4.setForeground(new java.awt.Color(255, 0, 51));
        x4.setText("X");

        x5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        x5.setForeground(new java.awt.Color(255, 0, 51));
        x5.setText("X");

        x6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        x6.setForeground(new java.awt.Color(255, 0, 51));
        x6.setText("X");

        x7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        x7.setForeground(new java.awt.Color(255, 0, 51));
        x7.setText("X");

        x8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        x8.setForeground(new java.awt.Color(255, 0, 51));
        x8.setText("X");

        newitem.setText("New Item");
        newitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newitemActionPerformed(evt);
            }
        });

        newcat.setText("New Category");
        newcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newcatActionPerformed(evt);
            }
        });

        categorytxt.setText("Category");

        catcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "     " }));
        catcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catcomboActionPerformed(evt);
            }
        });

        spricetxt.setText("Selling Price");

        x9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        x9.setForeground(new java.awt.Color(255, 0, 51));
        x9.setText("X");

        jLabel3.setText("USD Buying Price");

        bprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bpriceKeyReleased(evt);
            }
        });

        jCheckBox1.setText("Selling Price");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        sprice.setText("0.00");
        sprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                spriceKeyReleased(evt);
            }
        });

        x10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        x10.setForeground(new java.awt.Color(255, 0, 51));
        x10.setText("X");

        datetxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        timetxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        usertxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(barcodelable)
                            .addComponent(productlable)
                            .addComponent(combopaylab)
                            .addComponent(usdlable)
                            .addComponent(randlable)
                            .addComponent(zwllable)
                            .addComponent(ecocashlable)
                            .addComponent(swipelable)
                            .addComponent(categorytxt)
                            .addComponent(spricetxt))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(producttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(x0))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(quantitytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(x2))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(usdtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(x4)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                                        .addComponent(catnew, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(combopay, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(x3))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(randtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(x5))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(zwltxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(x6))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(ecocashtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(x7))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(catcombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(barcodetxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(x1)
                                                .addGap(117, 117, 117)
                                                .addComponent(newitem))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(swipetxt, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                                    .addComponent(sprice))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(x8)
                                                    .addComponent(x9)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(382, 382, 382)
                                                .addComponent(newcat)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(97, 97, 97))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bprice, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(x10)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(datetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(timetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116)
                                .addComponent(usertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(119, 119, 119)
                                .addComponent(jButton2)
                                .addGap(93, 93, 93)
                                .addComponent(jButton4)
                                .addGap(97, 97, 97)
                                .addComponent(jButton3))
                            .addComponent(jCheckBox1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(catcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categorytxt))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barcodetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x1)
                    .addComponent(newitem)
                    .addComponent(productlable))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barcodelable)
                    .addComponent(producttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x0)
                    .addComponent(newcat))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(quantitytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x2))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(bprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(catnew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combopay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x3)
                    .addComponent(combopaylab))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usdlable)
                    .addComponent(usdtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(randlable)
                    .addComponent(randtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zwllable)
                    .addComponent(zwltxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ecocashlable)
                    .addComponent(ecocashtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(swipelable)
                    .addComponent(swipetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(x9)
                    .addComponent(sprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spricetxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
            this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        Clear();
        
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void combopayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combopayActionPerformed
        // TODO add your handling code here:
        if (combopay.getSelectedItem() == "USD"){
            usdtxt.setVisible(true);
            randtxt.setVisible(false);
            zwltxt.setVisible(false);
            ecocashtxt.setVisible(false);
            swipetxt.setVisible(false);
            randlable.setVisible(false);
            zwllable.setVisible(false);
            ecocashlable.setVisible(false);
            swipelable.setVisible(false);
        }
        else if(combopay.getSelectedItem() == "RAND"){
            randtxt.setVisible(true);
            randlable.setVisible(true);
            usdtxt.setVisible(false);
            zwltxt.setVisible(false);
            ecocashtxt.setVisible(false);
            swipetxt.setVisible(false);
            usdlable.setVisible(false);
            zwllable.setVisible(false);
            ecocashlable.setVisible(false);
            swipelable.setVisible(false);
        }
        else if(combopay.getSelectedItem() == "ZWL CASH"){
            zwltxt.setVisible(true);
            zwllable.setVisible(true);
            usdtxt.setVisible(false);
            randtxt.setVisible(false);
            ecocashtxt.setVisible(false);
            swipetxt.setVisible(false);
            usdlable.setVisible(false);
            randlable.setVisible(false);
            ecocashlable.setVisible(false);
            swipelable.setVisible(false);
        }
        else if(combopay.getSelectedItem() == "ECOCASH"){
            ecocashtxt.setVisible(true);
            ecocashlable.setVisible(true);
            usdtxt.setVisible(false);
            zwltxt.setVisible(false);
            randtxt.setVisible(false);
            swipetxt.setVisible(false);
            usdlable.setVisible(false);
            zwllable.setVisible(false);
            randlable.setVisible(false);
            swipelable.setVisible(false);
        }
        else if(combopay.getSelectedItem() == "SWIPE"){
            swipetxt.setVisible(true);
            swipelable.setVisible(true);
            usdtxt.setVisible(false);
            zwltxt.setVisible(false);
            ecocashtxt.setVisible(false);
            randtxt.setVisible(false);
            usdlable.setVisible(false);
            zwllable.setVisible(false);
            ecocashlable.setVisible(false);
            randlable.setVisible(false);
        }
        else if(combopay.getSelectedItem() == "MIXED"){
            ecocashtxt.setVisible(true);
            ecocashlable.setVisible(true);
            usdtxt.setVisible(true);
            zwltxt.setVisible(true);
            ecocashtxt.setVisible(true);
            randtxt.setVisible(true);
            usdlable.setVisible(true);
            zwllable.setVisible(true);
            ecocashlable.setVisible(true);
            randlable.setVisible(true);
        }else
        {
                      ecocashtxt.setVisible(true);
            ecocashlable.setVisible(true);
            usdtxt.setVisible(true);
            zwltxt.setVisible(true);
            ecocashtxt.setVisible(true);
            randtxt.setVisible(true);
            usdlable.setVisible(true);
            zwllable.setVisible(true);
            ecocashlable.setVisible(true);
            randlable.setVisible(true);
        }

    }//GEN-LAST:event_combopayActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try{
        Purchases t = new Purchases("Purchase Successful.", 150, 590);
        t.showtoast();
        
        
        Clear();
        }
        
        catch(Exception e){
            Purchases t = new Purchases("Purchase Failed.", 150, 400);
        t.showtoast();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            
        String a1 = usdtxt.getText().trim();
        String a2 = randtxt.getText().trim();
        String a3 = zwltxt.getText().trim();
        String a4 = ecocashtxt.getText().trim();
        String a5 = swipetxt.getText().trim();
        String a6 = barcodetxt.getText().trim();
        String a7 = producttxt.getText().trim();
        String a8 = quantitytxt.getText().trim();
        String a9 = bprice.getText().trim();
        
        if((a6.isBlank() && a7.isBlank() && a8.isBlank() && a9.isBlank() && combopay.getSelectedIndex()==0)){
            x1.setVisible(true);
            x0.setVisible(true);
            x2.setVisible(true);
            x3.setVisible(true);
            x10.setVisible(true);
        }
        
        else if(a7.isBlank()){
            x0.setVisible(true);
        }
        else if(combopay.getSelectedIndex() == 0){
            x3.setVisible(true);
        }
        else if(a8.isBlank() || Double.parseDouble(a8)<=0.00){
            x2.setVisible(true);
        }
        else if(a9.isBlank() || Double.parseDouble(a9)<=0.00){
            x2.setVisible(true);
        }
        else if((a1.isBlank() || Double.parseDouble(a1)<=0.00) && combopay.getSelectedItem()=="USD"){
            x4.setVisible(true);
        }
        else if((a2.isBlank() || Double.parseDouble(a2)<=0.00) && combopay.getSelectedItem()=="RAND"){
            x5.setVisible(true);
        }
        else if((a3.isBlank() || Double.parseDouble(a3)<=0.00) && combopay.getSelectedItem()=="ZWL CASH"){
            x6.setVisible(true);
        }
        else if((a4.isBlank() || Double.parseDouble(a4)<=0.00) && combopay.getSelectedItem()=="ECOCASH"){
            x7.setVisible(true);
        }
        else if((a5.isBlank() || Double.parseDouble(a5)<=0.00) && combopay.getSelectedItem()=="SWIPE"){
            x8.setVisible(true);
        }
        
        else{
            
        Purchases t = new Purchases("Purchase Successful.", 150, 590);
        t.showtoast();
        Sales sal = new Sales();
        sal.setVisible(true);
        this.setVisible(false);
        }
        }
        
        catch(NumberFormatException e){
            Purchases t = new Purchases("Purchase Failed.", 150, 400);
        t.showtoast();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void barcodetxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barcodetxtKeyPressed
        // TODO add your handling code here:
        try {
            
              Connect();  
            String itemCode = barcodetxt.getText();
                pst = con.prepareStatement("select * from item where barcode=?");
                pst.setString(1, itemCode);
                rs = pst.executeQuery();
                
                if(rs.next()==true)
                {
                    String productname = rs.getString("itemname");
                    
 
                    
                    producttxt.setText(productname.trim());
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_barcodetxtKeyPressed

    private void newitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newitemActionPerformed
        
        
        

// TODO add your handling code here:

                try {
                    Connect();
                    pst = con.prepareStatement("select count(categoryname) from category");
                    rs = pst.executeQuery();
                    int c = 0;
                    while(rs.next()){
                        c = Integer.parseInt(rs.getString(1));
                    }
                    
                    pst = con.prepareStatement("select categoryname from category");
                    rs = pst.executeQuery();
                    
                    
                    String cate[] = new String[c];
                    int b = 0;
                    
                    while(rs.next()){
                        cate[b]=rs.getString("categoryname");
                        
                        catcombo.addItem(cate[b]);
                        b++;
                    }
                    

                    
                    
                    categorytxt.setVisible(true);
              
                } catch (SQLException ex) {
                    Logger.getLogger(Purchases.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(newitem.isSelected()){
                    catcombo.setVisible(true);
                          categorytxt.setVisible(true);
            newcat.setVisible(true);
            if(newcat.isSelected()){
                        categorytxt.setVisible(true);
        
                catnew.setVisible(true);
            }

        } else {
            catcombo.setVisible(false);
         newcat.setVisible(false);
        catnew.setVisible(false);
        categorytxt.setVisible(false);
        
        }
            

    }//GEN-LAST:event_newitemActionPerformed

    private void newcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newcatActionPerformed
        // TODO add your handling code here:
        if(newcat.isSelected()){
            catnew.setVisible(true);
            categorytxt.setVisible(false);
        catcombo.setVisible(false);
        }
        else{
            catnew.setVisible(false);
            categorytxt.setVisible(true);
            catcombo.setVisible(true);
        }
    }//GEN-LAST:event_newcatActionPerformed

    private void catcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catcomboActionPerformed

    }//GEN-LAST:event_catcomboActionPerformed

    private void barcodetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcodetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barcodetxtActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox1.isSelected()){
            spricetxt.setVisible(true);
            sprice.setVisible(true);
        }
        else{
            sprice.setVisible(false);
            spricetxt.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void barcodetxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barcodetxtKeyReleased
        // TODO add your handling code here:
        x1.setVisible(false);
    }//GEN-LAST:event_barcodetxtKeyReleased

    private void producttxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_producttxtKeyReleased
        // TODO add your handling code here:
        x0.setVisible(false);
    }//GEN-LAST:event_producttxtKeyReleased

    private void quantitytxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantitytxtKeyReleased
        // TODO add your handling code here:
        x2.setVisible(false);
    }//GEN-LAST:event_quantitytxtKeyReleased

    private void bpriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bpriceKeyReleased
        // TODO add your handling code here:
        x10.setVisible(false);
    }//GEN-LAST:event_bpriceKeyReleased

    private void usdtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usdtxtKeyReleased
        // TODO add your handling code here:
        x4.setVisible(false);
    }//GEN-LAST:event_usdtxtKeyReleased

    private void randtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_randtxtKeyReleased
        // TODO add your handling code here:
        x5.setVisible(false);
    }//GEN-LAST:event_randtxtKeyReleased

    private void zwltxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zwltxtKeyReleased
        // TODO add your handling code here:
        x6.setVisible(false);
    }//GEN-LAST:event_zwltxtKeyReleased

    private void ecocashtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ecocashtxtKeyReleased
        // TODO add your handling code here:
        x7.setVisible(false);
    }//GEN-LAST:event_ecocashtxtKeyReleased

    private void swipetxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_swipetxtKeyReleased
        // TODO add your handling code here:
        x8.setVisible(false);
    }//GEN-LAST:event_swipetxtKeyReleased

    private void spriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spriceKeyReleased
        // TODO add your handling code here:
        x9.setVisible(false);
    }//GEN-LAST:event_spriceKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Purchases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Purchases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Purchases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Purchases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Purchases().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barcodelable;
    private javax.swing.JTextField barcodetxt;
    private javax.swing.JTextField bprice;
    private javax.swing.JComboBox<String> catcombo;
    private javax.swing.JLabel categorytxt;
    private javax.swing.JTextField catnew;
    private javax.swing.JComboBox<String> combopay;
    private javax.swing.JLabel combopaylab;
    private javax.swing.JLabel datetxt;
    private javax.swing.JLabel ecocashlable;
    private javax.swing.JTextField ecocashtxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JCheckBox newcat;
    private javax.swing.JCheckBox newitem;
    private javax.swing.JLabel productlable;
    private javax.swing.JTextField producttxt;
    private javax.swing.JTextField quantitytxt;
    private javax.swing.JLabel randlable;
    private javax.swing.JTextField randtxt;
    private javax.swing.JTextField sprice;
    private javax.swing.JLabel spricetxt;
    private javax.swing.JLabel swipelable;
    private javax.swing.JTextField swipetxt;
    private javax.swing.JLabel timetxt;
    private javax.swing.JLabel usdlable;
    private javax.swing.JTextField usdtxt;
    private javax.swing.JLabel usertxt;
    private javax.swing.JLabel x0;
    private javax.swing.JLabel x1;
    private javax.swing.JLabel x10;
    private javax.swing.JLabel x2;
    private javax.swing.JLabel x3;
    private javax.swing.JLabel x4;
    private javax.swing.JLabel x5;
    private javax.swing.JLabel x6;
    private javax.swing.JLabel x7;
    private javax.swing.JLabel x8;
    private javax.swing.JLabel x9;
    private javax.swing.JLabel zwllable;
    private javax.swing.JTextField zwltxt;
    // End of variables declaration//GEN-END:variables
}
