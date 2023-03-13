/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.jakproject1;

import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.output.PrinterOutputStream;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.*;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.standard.PrinterName;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.table.TableModel;
import org.icepdf.ri.common.PrintJobWatcher;
import java.util.Formatter;
import javax.print.PrintService;
import static javax.swing.JOptionPane.WARNING_MESSAGE;




/**
 *
 * @author HP
 */
public class Sales2 extends javax.swing.JFrame {

    /**
     * Creates new form Sales2
     */
            public class PrinterOptions {
    String commandSet = "";

    public String initialize() {
        final byte[] Init = {27, 64};
        commandSet += new String(Init);
        return new String(Init);
    }

    public String chooseFont(int Options) {
        String s = "";
        final byte[] ChooseFontA = {27, 77, 0};
        final byte[] ChooseFontB = {27, 77, 1};
        final byte[] ChooseFontC = {27, 77, 48};
        final byte[] ChooseFontD = {27, 77, 49};
        
                switch(Options) {
            case 1:
            s = new String(ChooseFontA);
            break;

            case 2:
            s = new String(ChooseFontB);
            break;

            case 3:
            s = new String(ChooseFontC);
            break;

            case 4:
            s = new String(ChooseFontD);
            break;

            default:
            s = new String(ChooseFontB);
        }
        commandSet += s;
        return new String(s);
    }
    
        public String feedBack(byte lines) {
        final byte[] Feed = {27,101,lines};
        String s = new String(Feed);
        commandSet += s;
        return s;
    }

    public String feed(byte lines) {
        final byte[] Feed = {27,100,lines};
        String s = new String(Feed);
        commandSet += s;
        return s;
    }

    public String alignLeft() {
        final byte[] AlignLeft = {27, 97,48};
        String s = new String(AlignLeft);
        commandSet += s;
        return s;
    }

        public String alignCenter() {
        final byte[] AlignCenter = {27, 97,49};
        String s = new String(AlignCenter);
        commandSet += s;
        return s;
    }

    public String alignRight() {
        final byte[] AlignRight = {27, 97,50};
        String s = new String(AlignRight);
        commandSet += s;
        return s;
    }

    public String newLine() {
        final  byte[] LF = {10};
        String s = new String(LF);
        commandSet += s;
        return s;
   }

   public String reverseColorMode(boolean enabled) {
        final byte[] ReverseModeColorOn = {29, 66, 1};
        final byte[] ReverseModeColorOff = {29, 66, 0};

        String s = "";
        if(enabled)
            s = new String(ReverseModeColorOn);
        else
            s = new String(ReverseModeColorOff);

        commandSet += s;
        return s;
    } 

    public String doubleStrik(boolean enabled) {
        final byte[] DoubleStrikeModeOn = {27, 71, 1};
        final byte[] DoubleStrikeModeOff = {27, 71, 0};

        String s="";
        if(enabled)
            s = new String(DoubleStrikeModeOn);
        else
            s = new String(DoubleStrikeModeOff);

        commandSet += s;
        return s;
    } 

    public String doubleHeight(boolean enabled) {
        final byte[] DoubleHeight = {27, 33, 17};
        final byte[] UnDoubleHeight={27, 33, 0};

        String s = "";
        if(enabled)
            s = new String(DoubleHeight);
        else
            s = new String(UnDoubleHeight);

        commandSet += s;
        return s;
    }
    
        public String emphasized(boolean enabled) {
        final byte[] EmphasizedOff={27 ,0};
        final byte[] EmphasizedOn={27 ,1};

        String s="";
        if(enabled)
            s = new String(EmphasizedOn);
        else
            s = new String(EmphasizedOff);

        commandSet += s;
        return s;
    } 

    public String underLine(int Options) {
        final byte[] UnderLine2Dot = {27, 45, 50};
        final byte[] UnderLine1Dot = {27, 45, 49};
        final byte[] NoUnderLine = {27, 45, 48};

        String s = "";
        switch(Options) {
            case 0:
            s = new String(NoUnderLine);
            break;

            case 1:
            s = new String(UnderLine1Dot);
            break;

            default:
            s = new String(UnderLine2Dot);
        }
        commandSet += s;
        return new String(s);
    }

    public String color(int Options) {
        final byte[] ColorRed = {27, 114, 49};
        final byte[] ColorBlack = {27, 114, 48};

        String s = "";
        switch(Options) {
            case 0:
            s = new String(ColorBlack);
            break;

            case 1:
            s = new String(ColorRed);
            break;

            default:
            s = new String(ColorBlack);
        }
        commandSet += s;
        return s;
    }

    public String finit() {
        final byte[] FeedAndCut = {29, 'V', 66, 0};

        String s = new String(FeedAndCut);

        final byte[] DrawerKick={27,70,0,60,120};   
        s += new String(DrawerKick);

        commandSet+=s;
        return s;
    }

    public String addLineSeperator() {
        String lineSpace = "------------------------------------------------";
        commandSet += lineSpace;
        return lineSpace;
    }

    public void resetAll() {
        commandSet = "";
    }

    public void setText(String s) {
        commandSet+=s;
    }

    public String finalCommandSet() {
        return commandSet;
    }
}
        
        private static boolean feedPrinter(byte[] b) {
    try {       
        AttributeSet attrSet = new HashPrintServiceAttributeSet(new PrinterName("EPSON TM-T20III Receipt", null)); 

        DocPrintJob job = PrintServiceLookup.lookupPrintServices(null, attrSet)[0].createPrintJob();       
        //PrintServiceLookup.lookupDefaultPrintService().createPrintJob();  

        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(b, flavor, null);
        PrintJobWatcher pjDone = new PrintJobWatcher(job);

        job.print(doc, null);
        pjDone.waitForDone();
        System.out.println("Done !");
    } catch (javax.print.PrintException pex) {
        System.out.println("Printer Error " + pex.getMessage());
        return false;
    } catch(Exception e) {
        e.printStackTrace();
        return false;
    }
    return true;
}
        public void ClearInput()
    {
        
  producttxt.setText("");
  
  randtottxt.setText("");
                        ecotottxt.setText("");
                        swipetottxt.setText("");
                        zwltottxt.setText("");
        
   pricetxt.setText("");
        
   quantitytxt.setText("");
          
   barcodetxt.requestFocus();
   barcodetxt.setText("");
    }
        
        
        public final void Payout(Double usd, Double zwl, Double rand, Double ecocash, Double swipe){
            
        String tt = totusdtxt.getText();
        String z = "0";
        String b = "";

        if (tt.equalsIgnoreCase(z) || tt.equalsIgnoreCase(b)){
            JOptionPane.showMessageDialog(this, "No transaction detected");
        }
        else{
            PrinterOutputStream printerOutputStream = null;
            try {
                String datex = dtf.format(now);
                PrinterOptions p=new PrinterOptions();
                p.resetAll();
                p.initialize();
                p.feedBack((byte)2);
                p.color(0);
                p.alignCenter();
                p.setText("JAK PROJECTS");
                p.newLine();
                p.setText("Bulawayo \n\n");
                p.newLine();
                p.setText(datex);
                p.newLine();
                p.setText(usertxt.getText());
                p.newLine();
                Formatter fmt = new Formatter();
                fmt.format("\n%-44s", "------------------------------------------------");
                fmt.format("\n%-5s %-25s %-7s %-7s\n", "Qty", "Item", "Unit", "Total");
                fmt.format("%-44s\n", "------------------------------------------------");
                for (int i=0; i<jTable1.getRowCount(); i++)
                {
                    fmt.format("%-5s %-25s %-7s %-7s\n", jTable1.getValueAt(i, 2).toString(), jTable1.getValueAt(i, 0).toString(), jTable1.getValueAt(i, 1).toString(), jTable1.getValueAt(i, 3).toString());
                }               fmt.format("%-44s\n", "------------------------------------------------");
                fmt.format("\n%-25s %-5s %-7s %-7s\n", "USD Total", "", "", totusdtxt.getText());
                fmt.format("%-25s %-5s %-7s %-7s\n", "RAND Total", "", "", randtxt.getText());
                fmt.format("%-25s %-5s %-7s %-7s\n", "ZWL BOND Total", "", "", zwltxt.getText());
                fmt.format("%-25s %-5s %-7s %-7s\n", "ECOCASH Total", "", "", ecocashtxt.getText());
                fmt.format("%-25s %-5s %-7s %-7s\n", "SWIPE Total", "", "", swipetxt.getText());
                fmt.format("%44s\n", "------------------------------------------------");
                if((usd>0.00) && (zwl==0.00) && (rand==0.00) && (ecocash==0.00) && (swipe==0.00)){
                    fmt.format("\n%-25s %-5s %-7s %-7s\n", "USD Amount Paid", "", "", usd);
                    fmt.format("\n%-44s", "------------------------------------------------");
                    
                }
                else if((usd==0.00) && (zwl>0.00) && (rand==0.00) && (ecocash==0.00) && (swipe==0.00)){
                    fmt.format("\n%-25s %-5s %-7s %-7s\n", "ZWL Amount Paid", "", "", zwl);
                    fmt.format("\n%-44s", "------------------------------------------------");
                }
                else if((usd==0.00) && (zwl==0.00) && (rand>0.00) && (ecocash==0.00) && (swipe==0.00)){
                    fmt.format("\n%-25s %-5s %-7s %-7s\n", "RAND Amount Paid", "", "", rand);
                    p.setText(fmt.toString());
                }
                else if((usd==0.00) && (zwl==0.00) && (rand==0.00) && (ecocash>0.00) && (swipe==0.00)){
                    fmt.format("\n%-25s %-5s %-7s %-7s\n", "ECOCASH Amount Paid", "", "", ecocash);
                    fmt.format("\n%-44s", "------------------------------------------------");
                }
                else if((usd==0.00) && (zwl==0.00) && (rand==0.00) && (ecocash==0.00) && (swipe>0.00)){
                    fmt.format("\n%-25s %-5s %-7s %-7s\n", "SWIPE Amount Paid", "", "", swipe);
                    fmt.format("\n%-44s", "------------------------------------------------");
                }
                else if((usd>0.00) || (zwl>0.00) || (rand>0.00) || (ecocash>0.00) || (swipe>0.00)){
                    fmt.format("\n%-25s %-5s %-7s %-7s\n", "USD Amount Paid", "", "", usd);
                    fmt.format("%-25s %-5s %-7s %-7s\n", "ZWL BOND Amount Paid", "", "", zwl);
                    fmt.format("%-25s %-5s %-7s %-7s\n", "RAND Amount Paid", "", "", rand);
                    fmt.format("%-25s %-5s %-7s %-7s\n", "ECOCASH Amount Paid", "", "", ecocash);
                    fmt.format("%-25s %-5s %-7s %-7s\n", "SWIPE Amount Paid", "", "", swipe);
                    fmt.format("\n%-44s", "------------------------------------------------");
                }               
                
                Double v1 = Double.valueOf(usdctxt.getText());
                Double v2 = Double.valueOf(zwlctxt.getText());
                Double v3 = Double.valueOf(randctxt.getText());
                
                if(v1>0.00){
                    fmt.format("\n%-25s %-5s %-7s %-7s\n", "USD Change Given", "", "", v1);
                }
                else if(v2>0.00){
                    fmt.format("\n%-25s %-5s %-7s %-7s\n", "ZWL BOND Change Given", "", "", v2);
                }
                if(v3>0.00){
                    fmt.format("\n%-25s %-5s %-7s %-7s\n", "RAND Change Given", "", "", v3);
                }
                
                p.setText(fmt.toString());
                p.addLineSeperator();
                p.feed((byte)3);
                p.finit();
                feedPrinter(p.finalCommandSet().getBytes());
                
                
                
                
                model.setRowCount(0);
                ClearInput();
                usd1txt.setText("");
                zwl1txt.setText("");
                eco1txt.setText("");
                rand1txt.setText("");
                swipe1txt.setText("");
                totusdtxt.setText("");
                randtxt.setText("");
                swipetxt.setText("");
                ecocashtxt.setText("");
                zwltxt.setText("");
                jTextField1.setText("0.00");
                jTextField2.setText("0.00");
                jTextField3.setText("0.00");
                jTextField4.setText("0.00");
                jTextField5.setText("0.00");
                usdc.setText("");
                zwlc.setText("");
                randc.setText("");
                usdctxt.setText("");
                zwlctxt.setText("");
                randctxt.setText("");
                usdbutton.setEnabled(true);
                randbutton.setEnabled(true);
                zwlbutton.setEnabled(true);
                swipebutton.setEnabled(true);
                ecobutton.setEnabled(true);
                
                PrintService printService = PrinterOutputStream.getPrintServiceByName("EPSON TM-T20III Receipt");
                printerOutputStream = new PrinterOutputStream(printService);
                try (EscPos escpos = new EscPos(printerOutputStream)) {
                    escpos.write(27).write(112).write(0).write(25).write(250);
                    escpos.cut(EscPos.CutMode.FULL);
                }
            } catch (IOException ex) {
                Logger.getLogger(Sales2.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    printerOutputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(Sales2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


        }

        }
  
        
        
        
    public Sales2() {
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

    }
    
        Sales2(String user){
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

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm");  
                LocalDateTime now = LocalDateTime.now();
                private static final DecimalFormat decfors = new DecimalFormat("0.00");
    
                
                
    public final void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

             con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jak_database","root","admin");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        datetxt = new javax.swing.JLabel();
        timetxt = new javax.swing.JLabel();
        usertxt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        usdctxt = new javax.swing.JTextField();
        zwlctxt = new javax.swing.JTextField();
        randctxt = new javax.swing.JTextField();
        usdc = new javax.swing.JButton();
        zwlc = new javax.swing.JButton();
        randc = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        usdradio = new javax.swing.JRadioButton();
        zwlradio = new javax.swing.JRadioButton();
        randradio = new javax.swing.JRadioButton();
        ecoradio = new javax.swing.JRadioButton();
        swiperadio = new javax.swing.JRadioButton();
        usdbutton = new javax.swing.JButton();
        zwlbutton = new javax.swing.JButton();
        randbutton = new javax.swing.JButton();
        ecobutton = new javax.swing.JButton();
        swipebutton = new javax.swing.JButton();
        usd1txt = new javax.swing.JButton();
        zwl1txt = new javax.swing.JButton();
        rand1txt = new javax.swing.JButton();
        eco1txt = new javax.swing.JButton();
        swipe1txt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        zwltottxt = new javax.swing.JLabel();
        randtottxt = new javax.swing.JLabel();
        ecotottxt = new javax.swing.JLabel();
        swipetottxt = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        barcodetxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        producttxt = new javax.swing.JTextField();
        pricetxt = new javax.swing.JTextField();
        quantitytxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        totusdtxt = new javax.swing.JLabel();
        zwltxt = new javax.swing.JLabel();
        randtxt = new javax.swing.JLabel();
        ecocashtxt = new javax.swing.JLabel();
        swipetxt = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        setPreferredSize(new java.awt.Dimension(1065, 704));

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));

        datetxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        timetxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        usertxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setBackground(new java.awt.Color(0, 102, 102));
        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Price", "Quantity", "Total Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setText("          Change");
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setText("USD");

        jLabel14.setText("ZWL BOND");

        jLabel15.setText("RAND");

        usdctxt.setText("0.00");
        usdctxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usdctxtKeyReleased(evt);
            }
        });

        zwlctxt.setText("0.00");
        zwlctxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                zwlctxtKeyReleased(evt);
            }
        });

        randctxt.setText("0.00");

        usdc.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        usdc.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        usdc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        usdc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usdcActionPerformed(evt);
            }
        });

        zwlc.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        zwlc.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        zwlc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zwlcActionPerformed(evt);
            }
        });

        randc.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        randc.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        randc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usdc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zwlc, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(randc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addComponent(zwlctxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(usdctxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(randctxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(119, 119, 119))
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(usdctxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(usdc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(zwlctxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(zwlc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(randctxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(randc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setText("             Payments");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextField1.setText("0.00");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTextField2.setText("0.00");
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jTextField3.setText("0.00");
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jTextField4.setText("0.00");
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jTextField5.setText("0.00");
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        usdradio.setText("USD Cash");

        zwlradio.setText("ZWL Bond");

        randradio.setText("RAND");

        ecoradio.setText("ECOCASH");

        swiperadio.setText("SWIPE");

        usdbutton.setText("USD");
        usdbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usdbuttonActionPerformed(evt);
            }
        });

        zwlbutton.setText("ZWL");
        zwlbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zwlbuttonActionPerformed(evt);
            }
        });

        randbutton.setText("RAND");
        randbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randbuttonActionPerformed(evt);
            }
        });

        ecobutton.setText("ECOCASH");
        ecobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ecobuttonActionPerformed(evt);
            }
        });

        swipebutton.setText("SWIPE");
        swipebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                swipebuttonActionPerformed(evt);
            }
        });

        usd1txt.setBackground(new java.awt.Color(0, 102, 102));
        usd1txt.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        usd1txt.setForeground(new java.awt.Color(255, 255, 255));
        usd1txt.setToolTipText("");
        usd1txt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        usd1txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usd1txtActionPerformed(evt);
            }
        });

        zwl1txt.setBackground(new java.awt.Color(0, 102, 102));
        zwl1txt.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        zwl1txt.setForeground(new java.awt.Color(255, 255, 255));
        zwl1txt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        zwl1txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zwl1txtActionPerformed(evt);
            }
        });

        rand1txt.setBackground(new java.awt.Color(0, 102, 102));
        rand1txt.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        rand1txt.setForeground(new java.awt.Color(255, 255, 255));
        rand1txt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rand1txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rand1txtActionPerformed(evt);
            }
        });

        eco1txt.setBackground(new java.awt.Color(0, 102, 102));
        eco1txt.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        eco1txt.setForeground(new java.awt.Color(255, 255, 255));
        eco1txt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eco1txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eco1txtActionPerformed(evt);
            }
        });

        swipe1txt.setBackground(new java.awt.Color(0, 102, 102));
        swipe1txt.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        swipe1txt.setForeground(new java.awt.Color(255, 255, 255));
        swipe1txt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        swipe1txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                swipe1txtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usdradio)
                    .addComponent(zwlradio)
                    .addComponent(randradio)
                    .addComponent(ecoradio)
                    .addComponent(swiperadio))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usd1txt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zwl1txt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rand1txt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eco1txt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(swipe1txt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zwlbutton)
                    .addComponent(usdbutton)
                    .addComponent(randbutton)
                    .addComponent(ecobutton)
                    .addComponent(swipebutton))
                .addGap(19, 19, 19))
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usd1txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(usdradio)
                        .addComponent(usdbutton)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zwlbutton)
                    .addComponent(zwl1txt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(zwlradio)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(randbutton)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(randradio)
                        .addComponent(rand1txt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ecobutton)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ecoradio)
                        .addComponent(eco1txt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(swiperadio)
                    .addComponent(swipebutton)
                    .addComponent(swipe1txt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ZWL");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("RAND");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ECOCASH");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("SWIPE");

        zwltottxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        zwltottxt.setForeground(new java.awt.Color(255, 255, 255));
        zwltottxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        randtottxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        randtottxt.setForeground(new java.awt.Color(255, 255, 255));
        randtottxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ecotottxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ecotottxt.setForeground(new java.awt.Color(255, 255, 255));
        ecotottxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        swipetottxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        swipetottxt.setForeground(new java.awt.Color(255, 255, 255));
        swipetottxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(swipetottxt, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(ecotottxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(randtottxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zwltottxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(zwltottxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(randtottxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(ecotottxt, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap())
                    .addComponent(swipetottxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jButton1.setBackground(new java.awt.Color(51, 255, 0));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("PayOut");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 255, 0));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Purchases");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton4.setBackground(new java.awt.Color(51, 255, 0));
        jButton4.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Order In");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Verdana", 3, 20)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 102, 102));
        jButton5.setText("Shift End");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton12.setText("Void");
        jButton12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        barcodetxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        barcodetxt.setForeground(new java.awt.Color(0, 102, 102));
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Barcode");

        producttxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        producttxt.setForeground(new java.awt.Color(0, 102, 102));

        pricetxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pricetxt.setForeground(new java.awt.Color(0, 102, 102));

        quantitytxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        quantitytxt.setForeground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Price");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantity");

        jButton3.setBackground(new java.awt.Color(51, 255, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 102, 102));
        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(barcodetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(producttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(quantitytxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(pricetxt, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barcodetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(producttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantitytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("TOTAL USD");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("TOTAL ZWL BOND");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("TOTAL RAND");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("TOTAL ECOCASH");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("TOTAL SWIPE");

        totusdtxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totusdtxt.setForeground(new java.awt.Color(255, 255, 255));
        totusdtxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        zwltxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        zwltxt.setForeground(new java.awt.Color(255, 255, 255));
        zwltxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        randtxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        randtxt.setForeground(new java.awt.Color(255, 255, 255));
        randtxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ecocashtxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ecocashtxt.setForeground(new java.awt.Color(255, 255, 255));
        ecocashtxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        swipetxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        swipetxt.setForeground(new java.awt.Color(255, 255, 255));
        swipetxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ecocashtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                        .addComponent(randtxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(zwltxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totusdtxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(swipetxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11)
                    .addComponent(totusdtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(zwltxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(randtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(ecocashtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(swipetxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton7.setText("Open Drawer");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(63, 63, 63)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(datetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(timetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(510, 510, 510)
                        .addComponent(usertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Double usd = Double.valueOf(jTextField1.getText());
        Double zwl = Double.valueOf(jTextField2.getText());
        Double rand = Double.valueOf(jTextField3.getText());
        Double ecocash = Double.valueOf(jTextField4.getText());
        Double swipe = Double.valueOf(jTextField5.getText());
        
Payout(usd, zwl, rand, ecocash, swipe);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        int a = JOptionPane.showConfirmDialog(this, "Are you sure?");
        if(a==JOptionPane.YES_OPTION){
                    ClearInput();
        usd1txt.setText("");
        zwl1txt.setText("");
        swipe1txt.setText("");
        eco1txt.setText("");
        rand1txt.setText("");
            ShiftEnd se = new ShiftEnd();
            se.setVisible(true);
            this.setVisible(false);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void barcodetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcodetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barcodetxtActionPerformed

    private void barcodetxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barcodetxtKeyPressed
        // TODO add your handling code here:

        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            try {
                String itemCode = barcodetxt.getText();
                Connect();
                pst = con.prepareStatement("select * from paytype where not (pay_type = 'usd')");
                rs = pst.executeQuery();
                Double rand = 0.00;
                Double zwlcash = 0.00;
                Double swipe = 0.00;
                Double ecocash = 0.00;
                String rand2 = "rand";
                String zwlcash2 = "zwl cash";
                String ecocash2 = "ecocash";
                String swipe2 = "swipe";
                String results = "";

                while(rs.next())
                {
                    results = rs.getString("pay_type");
                    if(results.equalsIgnoreCase(rand2)){
                        rand = Double.valueOf(rs.getString("exchangerate"));
                    }
                    else if(results.equalsIgnoreCase(zwlcash2)){
                        zwlcash = Double.valueOf(rs.getString("exchangerate"));
                    }
                    else if(results.equalsIgnoreCase(ecocash2)){
                        ecocash = Double.valueOf(rs.getString("exchangerate"));
                    }
                    else if(results.equalsIgnoreCase(swipe2)){
                        swipe = Double.valueOf(rs.getString("exchangerate"));
                    }

                }

                try {
                    pst = con.prepareStatement("select * from item where barcode=?");
                    pst.setString(1, itemCode);
                    rs = pst.executeQuery();

                    if(rs.next()==true)
                    {
                        String productname = rs.getString("itemname");
                        String price = rs.getString("selling_price");

                        Double pric = Double.valueOf(price);

                        Double sum5 = pric * rand;
                        Double sum6 = pric * zwlcash;
                        Double sum7 = pric * ecocash;
                        Double sum8 = pric * swipe;

                        producttxt.setText(productname.trim());
                        pricetxt.setText(price.trim());

                        randtottxt.setText(String.valueOf(decfors.format(sum5)));
                        ecotottxt.setText(String.valueOf(decfors.format(sum7)));
                        zwltottxt.setText(String.valueOf(decfors.format(sum6)));
                        swipetottxt.setText(String.valueOf(decfors.format(sum8)));
                        
                    }

                    else
                    {
                        JOptionPane.showMessageDialog(this,"Barcode not Found");
                        ClearInput();

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (SQLException ex) {
                Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_barcodetxtKeyPressed

    private void barcodetxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barcodetxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_barcodetxtKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        String input = quantitytxt.getText();

        // Check if input is valid
        try {
            int value = Integer.parseInt(input);
            if (value < 0) {
                JOptionPane.showMessageDialog(null, "Quantity cannot be less than 0");
                quantitytxt.setText("");
                return; // Return if input is invalid
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Quantity must be a number");
            quantitytxt.setText("");
            return; // Return if input is invalid
        }

        // Continue with the rest of the button click event code
        // ...

        String q = quantitytxt.getText();
        int ck = Integer.parseInt(quantitytxt.getText());
        if( q.isEmpty()==true){
            JOptionPane.showMessageDialog(this, "Specify Quantity!");
        }

        else if(ck<=0){
            JOptionPane.showMessageDialog(this, "Quantity must be greater than zero!");
        }

        else{
            Double price = Double.valueOf(pricetxt.getText());
            Double qty = Double.valueOf(quantitytxt.getText());

            Double tot = price * qty;

            model = (DefaultTableModel)jTable1.getModel();
            model.addRow(new Object[]
                {
                    producttxt.getText(),
                    pricetxt.getText(),
                    quantitytxt.getText(),
                    decfors.format(tot)

                });

                Double sum=0.0;
                for(int i=0; i<jTable1.getRowCount(); i++)
                {

                    sum = sum + Double.valueOf(jTable1.getValueAt(i, 3).toString());

                }

                {

                }

                try {
                    Connect();
                    pst = con.prepareStatement("select * from paytype where not (pay_type = 'usd')");
                    rs = pst.executeQuery();
                    Double rand = 0.00;
                    Double zwlcash = 0.00;
                    Double swipe = 0.00;
                    Double ecocash = 0.00;
                    String rand3 = "rand";
                    String zwlcash3 = "zwl cash";
                    String ecocash3 = "ecocash";
                    String swipe3 = "swipe";
                    String results = "";

                    while(rs.next())
                    {
                        results = rs.getString("pay_type");
                        if(results.equalsIgnoreCase(rand3)){
                            rand = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(zwlcash3)){
                            zwlcash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(ecocash3)){
                            ecocash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(swipe3)){
                            swipe = Double.valueOf(rs.getString("exchangerate"));
                        }

                    }

                    Double sum1 = sum * rand;
                    Double sum2 = sum * zwlcash;
                    Double sum3 = sum * ecocash;
                    Double sum4 = sum * swipe;

                    usd1txt.setText(decfors.format(sum));
                    zwl1txt.setText(decfors.format(sum2));
                    rand1txt.setText(decfors.format(sum1));
                    eco1txt.setText(decfors.format(sum3));
                    swipe1txt.setText(decfors.format(sum4));
                    
                    totusdtxt.setText(decfors.format(sum));
                    zwltxt.setText(decfors.format(sum2));
                    randtxt.setText(decfors.format(sum1));
                    ecocashtxt.setText(decfors.format(sum3));
                    swipetxt.setText(decfors.format(sum4));

                    ClearInput();
                }
                catch (SQLException ex) {
                    Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        ClearInput();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
                    // TODO add your handling code here:
                try {
                    
                  
                    Connect();
                    pst = con.prepareStatement("select * from paytype where not (pay_type = 'usd')");
                    rs = pst.executeQuery();
                    Double rand = 0.00;
                    Double zwlcash = 0.00;
                    Double swipe = 0.00;
                    Double ecocash = 0.00;
                    String rand3 = "rand";
                    String zwlcash3 = "zwl cash";
                    String ecocash3 = "ecocash";
                    String swipe3 = "swipe";
                    String results = "";

                    while(rs.next())
                    {
                        
                        results = rs.getString("pay_type");
                        if(results.equalsIgnoreCase(rand3)){
                            rand = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(zwlcash3)){
                            zwlcash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(ecocash3)){
                            ecocash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(swipe3)){
                            swipe = Double.valueOf(rs.getString("exchangerate"));
                        }
                    }
                    
                    
                    Double x = Double.valueOf(jTextField1.getText());                    
                    Double x2 = Double.valueOf(usd1txt.getText());
                    Double comp = 0.00;
                    if(x>0.00){
                        usdradio.setSelected(true);
                        usdbutton.setEnabled(false);
                        randbutton.setEnabled(false);
                        zwlbutton.setEnabled(false);
                        swipebutton.setEnabled(false);
                        ecobutton.setEnabled(false);
                        comp = x2 - x;
                        
                        if(comp<0){
                          
                                comp = comp * -1;
                                usdc.setText(comp.toString());
                                
                                
                                
                                
                                Double zwlcha = zwlcash * comp;
                                Double randcha = rand * comp;
                                
                                zwlc.setText(zwlcha.toString());
                                randc.setText(randcha.toString());
                               
                            }
                            else if(comp>0){
                                    Double zwlrem = comp * zwlcash;
                                    Double randrem = comp * rand;
                                    Double swiperem = comp * swipe;
                                    Double ecorem = ecocash * comp;
                                    
                                    zwl1txt.setText(decfors.format(zwlrem));
                                    rand1txt.setText(decfors.format(randrem));
                                    swipe1txt.setText(decfors.format(swiperem));
                                    eco1txt.setText(decfors.format(ecorem));
                                    
                                    

                                    }
                            
                        }
                        else{
                            usdradio.setSelected(false);
                        }
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Sales2.class.getName()).log(Level.SEVERE, null, ex);
                }

    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
                try {
                    // TODO add your handling code here:

                    Connect();
                    pst = con.prepareStatement("select * from paytype where not (pay_type = 'usd')");
                    rs = pst.executeQuery();
                    Double rand = 0.00;
                    Double zwlcash = 0.00;
                    Double swipe = 0.00;
                    Double ecocash = 0.00;
                    String rand3 = "rand";
                    String zwlcash3 = "zwl cash";
                    String ecocash3 = "ecocash";
                    String swipe3 = "swipe";
                    String results = "";

                    while(rs.next())
                    {
                        
                        results = rs.getString("pay_type");
                        if(results.equalsIgnoreCase(rand3)){
                            rand = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(zwlcash3)){
                            zwlcash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(ecocash3)){
                            ecocash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(swipe3)){
                            swipe = Double.valueOf(rs.getString("exchangerate"));
                        }
                    }
                    Double x = Double.valueOf(jTextField2.getText());                    
                    Double x2 = Double.valueOf(zwl1txt.getText());
                    Double comp = 0.00;
                    if(Double.parseDouble(jTextField2.getText())>0.00){
                        zwlradio.setSelected(true);
                        usdbutton.setEnabled(false);
                        randbutton.setEnabled(false);
                        zwlbutton.setEnabled(false);
                        swipebutton.setEnabled(false);
                        ecobutton.setEnabled(false);
                        comp = x2 - x;
                        
                        if(usdradio.isSelected()){
                            Double m = Double.valueOf(jTextField2.getText());
                            m = Double.valueOf(zwl1txt.getText()) - m;
                            Double m2 = m / zwlcash ;
                            
                            
                            Double randrem2 = m2 * rand;
                            Double swiperem2 = m2 * swipe;
                            Double ecorem2 = ecocash * m2;
                            
                            
                            rand1txt.setText(decfors.format(randrem2));
                            swipe1txt.setText(decfors.format(swiperem2));
                            eco1txt.setText(decfors.format(ecorem2));
                        }
                        else if(randradio.isSelected()){
                            Double m = Double.valueOf(jTextField2.getText());
                            m = Double.valueOf(zwl1txt.getText()) - m;
                            Double m2 = m / zwlcash ;
                            
                            
                            Double usdrem = m2;
                            Double swiperem2 = m2 * swipe;
                            Double ecorem2 = ecocash * m2;
                            
                            
                            usd1txt.setText(decfors.format(usdrem));
                            swipe1txt.setText(decfors.format(swiperem2));
                            eco1txt.setText(decfors.format(ecorem2));
                        }
                        else if(swiperadio.isSelected()){
                            Double m = Double.valueOf(jTextField2.getText());
                            m = Double.valueOf(zwl1txt.getText()) - m;
                            Double m2 = m / zwlcash ;
                            
                            
                            Double usdrem = m2;
                            Double randrem2 = m2 * rand;
                            Double ecorem2 = ecocash * m2;
                            
                            
                            rand1txt.setText(decfors.format(randrem2));
                            usd1txt.setText(decfors.format(usdrem));
                            eco1txt.setText(decfors.format(ecorem2));
                        }
                        else if(ecoradio.isSelected()){
                            Double m = Double.valueOf(jTextField2.getText());
                            m = Double.valueOf(zwl1txt.getText()) - m;
                            Double m2 = m / zwlcash ;
                            
                            Double usdrem = m2;
                            Double swiperem2 = m2 * swipe;
                            Double randrem2 = m2 * rand;
                            
                            
                            usd1txt.setText(decfors.format(usdrem));
                            swipe1txt.setText(decfors.format(swiperem2));
                            rand1txt.setText(decfors.format(randrem2));
                            
                        }
                        
                        else{
                            if(comp<0){
                          
                                comp = comp * -1;
                                Double m2 = comp*zwlcash;
                                zwlc.setText(decfors.format(m2));
                                
                                
                                Double randcha = rand * comp;
                                
                                usdc.setText(comp.toString());
                                randc.setText(randcha.toString());
                               
    
                            }
                            else if(comp>0){
                                    Double usdrem = comp ;
                                    Double randrem = comp * rand;
                                    Double swiperem = comp * swipe;
                                    Double ecorem = ecocash * comp;
                                    
                                    usd1txt.setText(decfors.format(usdrem));
                                    rand1txt.setText(decfors.format(randrem));
                                    swipe1txt.setText(decfors.format(swiperem));
                                    eco1txt.setText(decfors.format(ecorem));
                                    
                                    

                                    }
                        }
                    }
                    else{
                        zwlradio.setSelected(false);
                    }       } catch (SQLException ex) {
                    Logger.getLogger(Sales2.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:
        try {
                    // TODO add your handling code here:

                    Connect();
                    pst = con.prepareStatement("select * from paytype where not (pay_type = 'usd')");
                    rs = pst.executeQuery();
                    Double rand = 0.00;
                    Double zwlcash = 0.00;
                    Double swipe = 0.00;
                    Double ecocash = 0.00;
                    String rand3 = "rand";
                    String zwlcash3 = "zwl cash";
                    String ecocash3 = "ecocash";
                    String swipe3 = "swipe";
                    String results = "";

                    while(rs.next())
                    {
                        
                        results = rs.getString("pay_type");
                        if(results.equalsIgnoreCase(rand3)){
                            rand = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(zwlcash3)){
                            zwlcash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(ecocash3)){
                            ecocash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(swipe3)){
                            swipe = Double.valueOf(rs.getString("exchangerate"));
                        }
                    }
                    Double x = Double.valueOf(jTextField3.getText());                    
                    Double x2 = Double.valueOf(rand1txt.getText());
                    Double comp = 0.00;
                    if(Double.parseDouble(jTextField3.getText())>0.00){
                        randradio.setSelected(true);
                        usdbutton.setEnabled(false);
                        randbutton.setEnabled(false);
                        zwlbutton.setEnabled(false);
                        swipebutton.setEnabled(false);
                        ecobutton.setEnabled(false);
                        comp = x2 - x;
                        
                        if(usdradio.isSelected()){
                            Double m = Double.valueOf(jTextField3.getText());
                            m = Double.valueOf(rand1txt.getText()) - m;
                            Double m2 = m / rand ;
                            
                            
                            Double zwlrem2 = m2 * zwlcash;
                            Double swiperem2 = m2 * swipe;
                            Double ecorem2 = ecocash * m2;
                            
                            
                            zwl1txt.setText(decfors.format(zwlrem2));
                            swipe1txt.setText(decfors.format(swiperem2));
                            eco1txt.setText(decfors.format(ecorem2));
                        }
                        else if(zwlradio.isSelected()){
                            Double m = Double.valueOf(jTextField3.getText());
                            m = Double.valueOf(rand1txt.getText()) - m;
                            Double m2 = m / rand ;
                            
                            
                            Double usdrem = m2;
                            Double swiperem2 = m2 * swipe;
                            Double ecorem2 = ecocash * m2;
                            
                            
                            usd1txt.setText(decfors.format(usdrem));
                            swipe1txt.setText(decfors.format(swiperem2));
                            eco1txt.setText(decfors.format(ecorem2));
                        }
                        else if(swiperadio.isSelected()){
                            Double m = Double.valueOf(jTextField3.getText());
                            m = Double.valueOf(rand1txt.getText()) - m;
                            Double m2 = m / rand ;
                            
                            
                            Double usdrem = m2;
                            Double zwlrem2 = m2 * zwlcash;
                            Double ecorem2 = ecocash * m2;
                            
                            
                            zwl1txt.setText(decfors.format(zwlrem2));
                            usd1txt.setText(decfors.format(usdrem));
                            eco1txt.setText(decfors.format(ecorem2));
                        }
                        else if(ecoradio.isSelected()){
                            Double m = Double.valueOf(jTextField3.getText());
                            m = Double.valueOf(rand1txt.getText()) - m;
                            Double m2 = m / rand ;
                            
                            Double usdrem = m2;
                            Double swiperem2 = m2 * swipe;
                            Double zwlrem2 = m2 * zwlcash;
                            
                            
                            usd1txt.setText(decfors.format(usdrem));
                            swipe1txt.setText(decfors.format(swiperem2));
                            zwl1txt.setText(decfors.format(zwlrem2));
                            
                        }
                        else{
                            if(comp<0){
                          
                                comp = comp * -1;
                                Double m2 = comp*rand;
                                randc.setText(decfors.format(m2));
                                
                                
                               Double zwlcha = zwlcash * comp;
                                
                                
                                zwlc.setText(zwlcha.toString());
                                usdc.setText(comp.toString());
                               
    
                            }
                            else if(comp>0){
                                    Double usdrem = comp ;
                                    Double zwlrem = comp * zwlcash;
                                    Double swiperem = comp * swipe;
                                    Double ecorem = ecocash * comp;
                                    
                                    usd1txt.setText(decfors.format(usdrem));
                                    zwl1txt.setText(decfors.format(zwlrem));
                                    swipe1txt.setText(decfors.format(swiperem));
                                    eco1txt.setText(decfors.format(ecorem));
                                    
                                    

                                    }
                        }
                    }
                    else{
                        randradio.setSelected(false);
                    }       } catch (SQLException ex) {
                    Logger.getLogger(Sales2.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
        try {
                    // TODO add your handling code here:

                    Connect();
                    pst = con.prepareStatement("select * from paytype where not (pay_type = 'usd')");
                    rs = pst.executeQuery();
                    Double rand = 0.00;
                    Double zwlcash = 0.00;
                    Double swipe = 0.00;
                    Double ecocash = 0.00;
                    String rand3 = "rand";
                    String zwlcash3 = "zwl cash";
                    String ecocash3 = "ecocash";
                    String swipe3 = "swipe";
                    String results = "";

                    while(rs.next())
                    {
                        
                        results = rs.getString("pay_type");
                        if(results.equalsIgnoreCase(rand3)){
                            rand = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(zwlcash3)){
                            zwlcash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(ecocash3)){
                            ecocash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(swipe3)){
                            swipe = Double.valueOf(rs.getString("exchangerate"));
                        }
                    }
                    Double x = Double.valueOf(jTextField4.getText());                    
                    Double x2 = Double.valueOf(eco1txt.getText());
                    Double comp = 0.00;
                    if(Double.parseDouble(jTextField4.getText())>0.00){
                        ecoradio.setSelected(true);
                        usdbutton.setEnabled(false);
                        randbutton.setEnabled(false);
                        zwlbutton.setEnabled(false);
                        swipebutton.setEnabled(false);
                        ecobutton.setEnabled(false);
                        comp = x2 - x;
                        
                        if(usdradio.isSelected()){
                            Double m = Double.valueOf(jTextField4.getText());
                            m = Double.valueOf(eco1txt.getText()) - m;
                            Double m2 = m / ecocash ;
                            
                            
                            Double zwlrem2 = m2 * zwlcash;
                            Double swiperem2 = m2 * swipe;
                            Double randrem2 = rand * m2;
                            
                            
                            zwl1txt.setText(decfors.format(zwlrem2));
                            swipe1txt.setText(decfors.format(swiperem2));
                            rand1txt.setText(decfors.format(randrem2));
                        }
                        else if(zwlradio.isSelected()){
                            Double m = Double.valueOf(jTextField4.getText());
                            m = Double.valueOf(eco1txt.getText()) - m;
                            Double m2 = m / ecocash ;
                            
                            
                            Double usdrem = m2;
                            Double swiperem2 = m2 * swipe;
                            Double randrem2 = rand * m2;
                            
                            
                            usd1txt.setText(decfors.format(usdrem));
                            swipe1txt.setText(decfors.format(swiperem2));
                            rand1txt.setText(decfors.format(randrem2));
                        }
                        else if(swiperadio.isSelected()){
                            Double m = Double.valueOf(jTextField4.getText());
                            m = Double.valueOf(eco1txt.getText()) - m;
                            Double m2 = m / ecocash ;
                            
                            
                            Double usdrem = m2;
                            Double zwlrem2 = m2 * zwlcash;
                            Double randrem2 = rand * m2;
                            
                            
                            zwl1txt.setText(decfors.format(zwlrem2));
                            usd1txt.setText(decfors.format(usdrem));
                            rand1txt.setText(decfors.format(randrem2));
                        }
                        else if(randradio.isSelected()){
                            Double m = Double.valueOf(jTextField4.getText());
                            m = Double.valueOf(eco1txt.getText()) - m;
                            Double m2 = m / ecocash ;
                            
                            Double usdrem = m2;
                            Double swiperem2 = m2 * swipe;
                            Double zwlrem2 = m2 * zwlcash;
                            
                            
                            usd1txt.setText(decfors.format(usdrem));
                            swipe1txt.setText(decfors.format(swiperem2));
                            zwl1txt.setText(decfors.format(zwlrem2));
                            
                        }
                        else{
                            if(comp>0){
                                    Double usdrem = comp ;
                                    Double zwlrem = comp * zwlcash;
                                    Double swiperem = comp * swipe;
                                    Double randrem = rand * comp;
                                    
                                    usd1txt.setText(decfors.format(usdrem));
                                    zwl1txt.setText(decfors.format(zwlrem));
                                    swipe1txt.setText(decfors.format(swiperem));
                                    rand1txt.setText(decfors.format(randrem));
                                    
                                    

                                    }
                        }
                    }
                    else{
                        ecoradio.setSelected(false);
                    }       } catch (SQLException ex) {
                    Logger.getLogger(Sales2.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
        try {
                    // TODO add your handling code here:

                    Connect();
                    pst = con.prepareStatement("select * from paytype where not (pay_type = 'usd')");
                    rs = pst.executeQuery();
                    Double rand = 0.00;
                    Double zwlcash = 0.00;
                    Double swipe = 0.00;
                    Double ecocash = 0.00;
                    String rand3 = "rand";
                    String zwlcash3 = "zwl cash";
                    String ecocash3 = "ecocash";
                    String swipe3 = "swipe";
                    String results = "";

                    while(rs.next())
                    {
                        
                        results = rs.getString("pay_type");
                        if(results.equalsIgnoreCase(rand3)){
                            rand = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(zwlcash3)){
                            zwlcash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(ecocash3)){
                            ecocash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(swipe3)){
                            swipe = Double.valueOf(rs.getString("exchangerate"));
                        }
                    }
                    Double x = Double.valueOf(jTextField5.getText());                    
                    Double x2 = Double.valueOf(swipe1txt.getText());
                    Double comp = 0.00;
                    if(Double.parseDouble(jTextField5.getText())>0.00){
                        swiperadio.setSelected(true);
                        usdbutton.setEnabled(false);
                        randbutton.setEnabled(false);
                        zwlbutton.setEnabled(false);
                        swipebutton.setEnabled(false);
                        ecobutton.setEnabled(false);
                        comp = x2 - x;
                        
                        if(usdradio.isSelected()){
                            Double m = Double.valueOf(jTextField5.getText());
                            m = Double.valueOf(swipe1txt.getText()) - m;
                            Double m2 = m / swipe ;
                            
                            
                            Double zwlrem2 = m2 * zwlcash;
                            Double ecorem2 = m2 * ecocash;
                            Double randrem2 = rand * m2;
                            
                            
                            zwl1txt.setText(decfors.format(zwlrem2));
                            eco1txt.setText(decfors.format(ecorem2));
                            rand1txt.setText(decfors.format(randrem2));
                        }
                        else if(zwlradio.isSelected()){
                            Double m = Double.valueOf(jTextField5.getText());
                            m = Double.valueOf(swipe1txt.getText()) - m;
                            Double m2 = m / swipe ;
                            
                            
                            Double usdrem = m2;
                            Double ecorem2 = m2 * ecocash;
                            Double randrem2 = rand * m2;
                            
                            
                            usd1txt.setText(decfors.format(usdrem));
                            eco1txt.setText(decfors.format(ecorem2));
                            rand1txt.setText(decfors.format(randrem2));
                        }
                        else if(ecoradio.isSelected()){
                            Double m = Double.valueOf(jTextField5.getText());
                            m = Double.valueOf(swipe1txt.getText()) - m;
                            Double m2 = m / swipe ;
                            
                            
                            Double usdrem = m2;
                            Double zwlrem2 = m2 * zwlcash;
                            Double randrem2 = rand * m2;
                            
                            
                            zwl1txt.setText(decfors.format(zwlrem2));
                            usd1txt.setText(decfors.format(usdrem));
                            rand1txt.setText(decfors.format(randrem2));
                        }
                        else if(randradio.isSelected()){
                            Double m = Double.valueOf(jTextField5.getText());
                            m = Double.valueOf(swipe1txt.getText()) - m;
                            Double m2 = m / swipe ;
                            
                            Double usdrem = m2;
                            Double ecorem2 = m2 * ecocash;
                            Double zwlrem2 = m2 * zwlcash;
                            
                            
                            usd1txt.setText(decfors.format(usdrem));
                            eco1txt.setText(decfors.format(ecorem2));
                            zwl1txt.setText(decfors.format(zwlrem2));
                            
                        }
                        else{
                            if(comp>0){
                                    Double usdrem = comp ;
                                    Double zwlrem = comp * zwlcash;
                                    Double ecorem = comp * ecocash;
                                    Double randrem = rand * comp;
                                    
                                    usd1txt.setText(decfors.format(usdrem));
                                    zwl1txt.setText(decfors.format(zwlrem));
                                    eco1txt.setText(decfors.format(ecorem));
                                    rand1txt.setText(decfors.format(randrem));
                                    
                                    

                                    }
                        }
                    }
                    else{
                        swiperadio.setSelected(false);
                    }       } catch (SQLException ex) {
                    Logger.getLogger(Sales2.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_jTextField5KeyReleased

    private void usdbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usdbuttonActionPerformed
        // TODO add your handling code here:
        Double usd = Double.valueOf(usd1txt.getText());
        Double zwl = 0.00;
        Double rand = 0.00;
        Double ecocash = 0.00;
        Double swipe = 0.00;
        
        Payout(usd, zwl, rand, ecocash, swipe);
    }//GEN-LAST:event_usdbuttonActionPerformed

    private void usd1txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usd1txtActionPerformed
        // TODO add your handling code here:
        String tt = usd1txt.getText();
        jTextField1.setText(tt);
        
        try {
                    
                  
                    Connect();
                    pst = con.prepareStatement("select * from paytype where not (pay_type = 'usd')");
                    rs = pst.executeQuery();
                    Double rand = 0.00;
                    Double zwlcash = 0.00;
                    Double swipe = 0.00;
                    Double ecocash = 0.00;
                    String rand3 = "rand";
                    String zwlcash3 = "zwl cash";
                    String ecocash3 = "ecocash";
                    String swipe3 = "swipe";
                    String results = "";

                    while(rs.next())
                    {
                        
                        results = rs.getString("pay_type");
                        if(results.equalsIgnoreCase(rand3)){
                            rand = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(zwlcash3)){
                            zwlcash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(ecocash3)){
                            ecocash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(swipe3)){
                            swipe = Double.valueOf(rs.getString("exchangerate"));
                        }
                    }
                    
                    
                    Double x = Double.valueOf(jTextField1.getText());                    
                    Double x2 = Double.valueOf(usd1txt.getText());
                    Double comp = 0.00;
                    if(x>0.00){
                        usdradio.setSelected(true);
                        usdbutton.setEnabled(false);
                        randbutton.setEnabled(false);
                        zwlbutton.setEnabled(false);
                        swipebutton.setEnabled(false);
                        ecobutton.setEnabled(false);
                        comp = x2 - x;
                        
                        if(comp<0){
                          
                                comp = comp * -1;
                                usdc.setText(comp.toString());
                                
                                
                                
                                
                                Double zwlcha = zwlcash * comp;
                                Double randcha = rand * comp;
                                
                                zwlc.setText(zwlcha.toString());
                                randc.setText(randcha.toString());
                               
                            }
                            else if(comp>0){
                                    Double zwlrem = comp * zwlcash;
                                    Double randrem = comp * rand;
                                    Double swiperem = comp * swipe;
                                    Double ecorem = ecocash * comp;
                                    
                                    zwl1txt.setText(decfors.format(zwlrem));
                                    rand1txt.setText(decfors.format(randrem));
                                    swipe1txt.setText(decfors.format(swiperem));
                                    eco1txt.setText(decfors.format(ecorem));
                                    
                                    

                                    }
                            
                        }
                        else{
                            usdradio.setSelected(false);
                        }
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Sales2.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_usd1txtActionPerformed

    private void zwl1txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zwl1txtActionPerformed
        // TODO add your handling code here:
        String tt = zwl1txt.getText();
        jTextField2.setText(tt);
        
        try {
                    // TODO add your handling code here:

                    Connect();
                    pst = con.prepareStatement("select * from paytype where not (pay_type = 'usd')");
                    rs = pst.executeQuery();
                    Double rand = 0.00;
                    Double zwlcash = 0.00;
                    Double swipe = 0.00;
                    Double ecocash = 0.00;
                    String rand3 = "rand";
                    String zwlcash3 = "zwl cash";
                    String ecocash3 = "ecocash";
                    String swipe3 = "swipe";
                    String results = "";

                    while(rs.next())
                    {
                        
                        results = rs.getString("pay_type");
                        if(results.equalsIgnoreCase(rand3)){
                            rand = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(zwlcash3)){
                            zwlcash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(ecocash3)){
                            ecocash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(swipe3)){
                            swipe = Double.valueOf(rs.getString("exchangerate"));
                        }
                    }
                    Double x = Double.valueOf(jTextField2.getText());                    
                    Double x2 = Double.valueOf(zwl1txt.getText());
                    Double comp = 0.00;
                    if(Double.parseDouble(jTextField2.getText())>0.00){
                        zwlradio.setSelected(true);
                        usdbutton.setEnabled(false);
                        randbutton.setEnabled(false);
                        zwlbutton.setEnabled(false);
                        swipebutton.setEnabled(false);
                        ecobutton.setEnabled(false);
                        comp = x2 - x;
                        
                        if(usdradio.isSelected()){
                            Double m = Double.valueOf(jTextField2.getText());
                            m = Double.valueOf(zwl1txt.getText()) - m;
                            Double m2 = m / zwlcash ;
                            
                            
                            Double randrem2 = m2 * rand;
                            Double swiperem2 = m2 * swipe;
                            Double ecorem2 = ecocash * m2;
                            
                            
                            rand1txt.setText(decfors.format(randrem2));
                            swipe1txt.setText(decfors.format(swiperem2));
                            eco1txt.setText(decfors.format(ecorem2));
                        }
                        else if(randradio.isSelected()){
                            Double m = Double.valueOf(jTextField2.getText());
                            m = Double.valueOf(zwl1txt.getText()) - m;
                            Double m2 = m / zwlcash ;
                            
                            
                            Double usdrem = m2;
                            Double swiperem2 = m2 * swipe;
                            Double ecorem2 = ecocash * m2;
                            
                            
                            usd1txt.setText(decfors.format(usdrem));
                            swipe1txt.setText(decfors.format(swiperem2));
                            eco1txt.setText(decfors.format(ecorem2));
                        }
                        else if(swiperadio.isSelected()){
                            Double m = Double.valueOf(jTextField2.getText());
                            m = Double.valueOf(zwl1txt.getText()) - m;
                            Double m2 = m / zwlcash ;
                            
                            
                            Double usdrem = m2;
                            Double randrem2 = m2 * rand;
                            Double ecorem2 = ecocash * m2;
                            
                            
                            rand1txt.setText(decfors.format(randrem2));
                            usd1txt.setText(decfors.format(usdrem));
                            eco1txt.setText(decfors.format(ecorem2));
                        }
                        else if(ecoradio.isSelected()){
                            Double m = Double.valueOf(jTextField2.getText());
                            m = Double.valueOf(zwl1txt.getText()) - m;
                            Double m2 = m / zwlcash ;
                            
                            Double usdrem = m2;
                            Double swiperem2 = m2 * swipe;
                            Double randrem2 = m2 * rand;
                            
                            
                            usd1txt.setText(decfors.format(usdrem));
                            swipe1txt.setText(decfors.format(swiperem2));
                            rand1txt.setText(decfors.format(randrem2));
                            
                        }
                        
                        else{
                            if(comp<0){
                          
                                comp = comp * -1;
                                Double m2 = comp*zwlcash;
                                zwlc.setText(decfors.format(m2));
                                
                                
                                Double randcha = rand * comp;
                                
                                usdc.setText(comp.toString());
                                randc.setText(randcha.toString());
                               
    
                            }
                            else if(comp>0){
                                    Double usdrem = comp ;
                                    Double randrem = comp * rand;
                                    Double swiperem = comp * swipe;
                                    Double ecorem = ecocash * comp;
                                    
                                    usd1txt.setText(decfors.format(usdrem));
                                    rand1txt.setText(decfors.format(randrem));
                                    swipe1txt.setText(decfors.format(swiperem));
                                    eco1txt.setText(decfors.format(ecorem));
                                    
                                    

                                    }
                        }
                    }
                    else{
                        zwlradio.setSelected(false);
                    }       } catch (SQLException ex) {
                    Logger.getLogger(Sales2.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_zwl1txtActionPerformed

    private void rand1txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rand1txtActionPerformed
        // TODO add your handling code here:
        String tt = rand1txt.getText();
        jTextField3.setText(tt);
        
        try {
                    // TODO add your handling code here:

                    Connect();
                    pst = con.prepareStatement("select * from paytype where not (pay_type = 'usd')");
                    rs = pst.executeQuery();
                    Double rand = 0.00;
                    Double zwlcash = 0.00;
                    Double swipe = 0.00;
                    Double ecocash = 0.00;
                    String rand3 = "rand";
                    String zwlcash3 = "zwl cash";
                    String ecocash3 = "ecocash";
                    String swipe3 = "swipe";
                    String results = "";

                    while(rs.next())
                    {
                        
                        results = rs.getString("pay_type");
                        if(results.equalsIgnoreCase(rand3)){
                            rand = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(zwlcash3)){
                            zwlcash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(ecocash3)){
                            ecocash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(swipe3)){
                            swipe = Double.valueOf(rs.getString("exchangerate"));
                        }
                    }
                    Double x = Double.valueOf(jTextField3.getText());                    
                    Double x2 = Double.valueOf(rand1txt.getText());
                    Double comp = 0.00;
                    if(Double.parseDouble(jTextField3.getText())>0.00){
                        randradio.setSelected(true);
                        usdbutton.setEnabled(false);
                        randbutton.setEnabled(false);
                        zwlbutton.setEnabled(false);
                        swipebutton.setEnabled(false);
                        ecobutton.setEnabled(false);
                        comp = x2 - x;
                        
                        if(usdradio.isSelected()){
                            Double m = Double.valueOf(jTextField3.getText());
                            m = Double.valueOf(rand1txt.getText()) - m;
                            Double m2 = m / rand ;
                            
                            
                            Double zwlrem2 = m2 * zwlcash;
                            Double swiperem2 = m2 * swipe;
                            Double ecorem2 = ecocash * m2;
                            
                            
                            zwl1txt.setText(decfors.format(zwlrem2));
                            swipe1txt.setText(decfors.format(swiperem2));
                            eco1txt.setText(decfors.format(ecorem2));
                        }
                        else if(zwlradio.isSelected()){
                            Double m = Double.valueOf(jTextField3.getText());
                            m = Double.valueOf(rand1txt.getText()) - m;
                            Double m2 = m / rand ;
                            
                            
                            Double usdrem = m2;
                            Double swiperem2 = m2 * swipe;
                            Double ecorem2 = ecocash * m2;
                            
                            
                            usd1txt.setText(decfors.format(usdrem));
                            swipe1txt.setText(decfors.format(swiperem2));
                            eco1txt.setText(decfors.format(ecorem2));
                        }
                        else if(swiperadio.isSelected()){
                            Double m = Double.valueOf(jTextField3.getText());
                            m = Double.valueOf(rand1txt.getText()) - m;
                            Double m2 = m / rand ;
                            
                            
                            Double usdrem = m2;
                            Double zwlrem2 = m2 * zwlcash;
                            Double ecorem2 = ecocash * m2;
                            
                            
                            zwl1txt.setText(decfors.format(zwlrem2));
                            usd1txt.setText(decfors.format(usdrem));
                            eco1txt.setText(decfors.format(ecorem2));
                        }
                        else if(ecoradio.isSelected()){
                            Double m = Double.valueOf(jTextField3.getText());
                            m = Double.valueOf(rand1txt.getText()) - m;
                            Double m2 = m / rand ;
                            
                            Double usdrem = m2;
                            Double swiperem2 = m2 * swipe;
                            Double zwlrem2 = m2 * zwlcash;
                            
                            
                            usd1txt.setText(decfors.format(usdrem));
                            swipe1txt.setText(decfors.format(swiperem2));
                            zwl1txt.setText(decfors.format(zwlrem2));
                            
                        }
                        else{
                            if(comp<0){
                          
                                comp = comp * -1;
                                Double m2 = comp*rand;
                                randc.setText(decfors.format(m2));
                                
                                
                               Double zwlcha = zwlcash * comp;
                                
                                
                                zwlc.setText(zwlcha.toString());
                                usdc.setText(comp.toString());
                               
    
                            }
                            else if(comp>0){
                                    Double usdrem = comp ;
                                    Double zwlrem = comp * zwlcash;
                                    Double swiperem = comp * swipe;
                                    Double ecorem = ecocash * comp;
                                    
                                    usd1txt.setText(decfors.format(usdrem));
                                    zwl1txt.setText(decfors.format(zwlrem));
                                    swipe1txt.setText(decfors.format(swiperem));
                                    eco1txt.setText(decfors.format(ecorem));
                                    
                                    

                                    }
                        }
                    }
                    else{
                        randradio.setSelected(false);
                    }       } catch (SQLException ex) {
                    Logger.getLogger(Sales2.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_rand1txtActionPerformed

    private void eco1txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eco1txtActionPerformed
        // TODO add your handling code here:
        String tt = eco1txt.getText();
        jTextField4.setText(tt);
    }//GEN-LAST:event_eco1txtActionPerformed

    private void swipe1txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_swipe1txtActionPerformed
        // TODO add your handling code here:
        String tt = swipe1txt.getText();
        jTextField5.setText(tt);
    }//GEN-LAST:event_swipe1txtActionPerformed

    private void zwlbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zwlbuttonActionPerformed
        // TODO add your handling code here:
        Double usd = 0.00;
        Double zwl = Double.valueOf(zwl1txt.getText());
        Double rand = 0.00;
        Double ecocash = 0.00;
        Double swipe = 0.00;
        
        Payout(usd, zwl, rand, ecocash, swipe);
    }//GEN-LAST:event_zwlbuttonActionPerformed

    private void randbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randbuttonActionPerformed
        // TODO add your handling code here:
        Double usd = 0.00;
        Double zwl = 0.00;
        Double rand = Double.valueOf(rand1txt.getText());
        Double ecocash = 0.00;
        Double swipe = 0.00;
        
        Payout(usd, zwl, rand, ecocash, swipe);
    }//GEN-LAST:event_randbuttonActionPerformed

    private void ecobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecobuttonActionPerformed
        // TODO add your handling code here:
        Double usd = 0.00;
        Double zwl = 0.00;
        Double rand = 0.00;
        Double ecocash = Double.valueOf(eco1txt.getText());
        Double swipe = 0.00;
        
        Payout(usd, zwl, rand, ecocash, swipe);
    }//GEN-LAST:event_ecobuttonActionPerformed

    private void swipebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_swipebuttonActionPerformed
        // TODO add your handling code here:
        Double usd = 0.00;
        Double zwl = 0.00;
        Double rand = 0.00;
        Double ecocash = 0.00;
        Double swipe = Double.valueOf(swipe1txt.getText());
        
        Payout(usd, zwl, rand, ecocash, swipe);
    }//GEN-LAST:event_swipebuttonActionPerformed

    private void usdcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usdcActionPerformed
        // TODO add your handling code here:
        String tt = usdc.getText();
        usdctxt.setText(tt);
        
        
    }//GEN-LAST:event_usdcActionPerformed

    private void zwlcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zwlcActionPerformed
        // TODO add your handling code here:
        String tt = zwlc.getText();
        zwlctxt.setText(tt);
    }//GEN-LAST:event_zwlcActionPerformed

    private void randcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randcActionPerformed
        // TODO add your handling code here:
        String tt = randc.getText();
        randctxt.setText(tt);
        
        
    }//GEN-LAST:event_randcActionPerformed

    private void usdctxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usdctxtKeyReleased
        // TODO add your handling code here:
        try {
                    
                  
                    Connect();
                    pst = con.prepareStatement("select * from paytype where not (pay_type = 'usd')");
                    rs = pst.executeQuery();
                    Double rand = 0.00;
                    Double zwlcash = 0.00;
                    Double swipe = 0.00;
                    Double ecocash = 0.00;
                    String rand3 = "rand";
                    String zwlcash3 = "zwl cash";
                    String ecocash3 = "ecocash";
                    String swipe3 = "swipe";
                    String results = "";

                    while(rs.next())
                    {
                        
                        results = rs.getString("pay_type");
                        if(results.equalsIgnoreCase(rand3)){
                            rand = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(zwlcash3)){
                            zwlcash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(ecocash3)){
                            ecocash = Double.valueOf(rs.getString("exchangerate"));
                        }
                        else if(results.equalsIgnoreCase(swipe3)){
                            swipe = Double.valueOf(rs.getString("exchangerate"));
                        }
                    }
                    
                    
                    Double x = Double.valueOf(usdctxt.getText());                    
                    Double x2 = Double.valueOf(usdc.getText());
                    Double comp = 0.00;
                    if(x>0.00){
                        comp = x2 - x;
                        
                        if(comp<0){
                          
                                JOptionPane.showMessageDialog(this, "That's too much change", "WARNING!", WARNING_MESSAGE);
                            }
                            else if(comp>0){
                                    Double zwlrem = comp * zwlcash;
                                    Double randrem = comp * rand;
                                    
                                    
                                    zwlc.setText(decfors.format(zwlrem));
                                    randc.setText(decfors.format(randrem));

                                    }
                            
                        }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Sales2.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_usdctxtKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        PrinterOutputStream printerOutputStream = null;
                try {
                    // TODO add your handling code here:
                    
                    PrintService printService = PrinterOutputStream.getPrintServiceByName("EPSON TM-T20III Receipt");
                    printerOutputStream = new PrinterOutputStream(printService);
            try (EscPos escpos = new EscPos(printerOutputStream)) {
                escpos.write(27).write(112).write(0).write(25).write(250);
                escpos.cut(EscPos.CutMode.FULL);
            }
                } catch (IOException ex) {
                    Logger.getLogger(Sales2.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        printerOutputStream.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Sales2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void zwlctxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zwlctxtKeyReleased
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_zwlctxtKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Orders oe = new Orders();
            oe.setVisible(true);
         
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Sales2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Sales2 s = new Sales2();
                
         
        s.setVisible(true);
        
                        Toolkit tk=Toolkit.getDefaultToolkit(); //Initializing the Toolkit class.
        Dimension screenSize = tk.getScreenSize(); //Get the Screen resolution of our device.


        //APPROACH - 2 : Using MAXIMIZED_BOTH
        s.setExtendedState(JFrame.MAXIMIZED_BOTH); //Maximize both the horizontal and vertical directions
        System.out.println(screenSize);

                
        
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barcodetxt;
    private javax.swing.JLabel datetxt;
    private javax.swing.JButton eco1txt;
    private javax.swing.JButton ecobutton;
    private javax.swing.JLabel ecocashtxt;
    private javax.swing.JRadioButton ecoradio;
    private javax.swing.JLabel ecotottxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField pricetxt;
    private javax.swing.JTextField producttxt;
    private javax.swing.JTextField quantitytxt;
    private javax.swing.JButton rand1txt;
    private javax.swing.JButton randbutton;
    private javax.swing.JButton randc;
    private javax.swing.JTextField randctxt;
    private javax.swing.JRadioButton randradio;
    private javax.swing.JLabel randtottxt;
    private javax.swing.JLabel randtxt;
    private javax.swing.JButton swipe1txt;
    private javax.swing.JButton swipebutton;
    private javax.swing.JRadioButton swiperadio;
    private javax.swing.JLabel swipetottxt;
    private javax.swing.JLabel swipetxt;
    private javax.swing.JLabel timetxt;
    private javax.swing.JLabel totusdtxt;
    private javax.swing.JButton usd1txt;
    private javax.swing.JButton usdbutton;
    private javax.swing.JButton usdc;
    private javax.swing.JTextField usdctxt;
    private javax.swing.JRadioButton usdradio;
    private javax.swing.JLabel usertxt;
    private javax.swing.JButton zwl1txt;
    private javax.swing.JButton zwlbutton;
    private javax.swing.JButton zwlc;
    private javax.swing.JTextField zwlctxt;
    private javax.swing.JRadioButton zwlradio;
    private javax.swing.JLabel zwltottxt;
    private javax.swing.JLabel zwltxt;
    // End of variables declaration//GEN-END:variables
}
