/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.jakproject1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.PrinterName;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.icepdf.ri.common.PrintJobWatcher;



/**
 *
 * @author HP
 */
public class SalePayout extends javax.swing.JFrame {


/**
     * Creates new form SalePayout
     * @param abc
     */
        SalePayout() {
        initComponents();
        
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
        
        SalePayout(String usd, String zwl, String ecocash, String swipe, String rand, String user, TableModel tableModel) {
        initComponents();
        
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
        
        usd1txt.setText(usd);
        zwl1txt.setText(zwl);
        eco1txt.setText(ecocash);
        swipe1txt.setText(swipe);
        rand1txt.setText(rand);
        usertxt.setText(user);
        
    }
        
        
    
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
        String lineSpace = "---------------------------------------------";
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
        AttributeSet attrSet = new HashPrintServiceAttributeSet(new PrinterName("EPSON TM-T20III Receipt", null)); //EPSON TM-U220 ReceiptE4

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
        
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm");  
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
        
        

        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        usd1txt = new javax.swing.JLabel();
        zwl1txt = new javax.swing.JLabel();
        rand1txt = new javax.swing.JLabel();
        eco1txt = new javax.swing.JLabel();
        swipe1txt = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        datetxt = new javax.swing.JLabel();
        timetxt = new javax.swing.JLabel();
        usertxt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Change");

        jLabel13.setText("USD");

        jLabel14.setText("ZWL BOND");

        jLabel15.setText("RAND");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(212, 212, 212))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Payments");

        jRadioButton1.setText("USD Cash");

        jRadioButton2.setText("ZWL Bond");

        jRadioButton3.setText("RAND");

        jRadioButton4.setText("ECOCASH");

        jRadioButton5.setText("SWIPE");

        usd1txt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        zwl1txt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        rand1txt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        eco1txt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        swipe1txt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton3.setText("USD");

        jButton4.setText("ZWL");

        jButton5.setText("RAND");

        jButton6.setText("ECOCASH");

        jButton7.setText("SWIPE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton5))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usd1txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(zwl1txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rand1txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eco1txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(swipe1txt, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usd1txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton1)
                        .addComponent(jButton3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zwl1txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton2)
                        .addComponent(jButton4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rand1txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton3)
                        .addComponent(jButton5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eco1txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton4)
                        .addComponent(jButton6)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton5)
                    .addComponent(swipe1txt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        jButton1.setText("PAYOUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        datetxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        timetxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        usertxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(datetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(timetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161)
                        .addComponent(usertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datetxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timetxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usertxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Sales s = new Sales();
        s.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
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
p.newLine();
p.addLineSeperator();
p.newLine();


p.setText("Qty \tItem\t\t\tUnit\tTotal");
p.newLine();
p.addLineSeperator();
p.newLine();


p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");
p.newLine();
p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");
p.newLine();
p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");
p.newLine();
p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");
p.newLine();
p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");
p.newLine();
p.setText("1" + "\t" + "Aliens Everywhere" + "\t" +  "Rats" + "\t" + "500");
p.newLine();

p.addLineSeperator();
p.feed((byte)3);
p.finit();

feedPrinter(p.finalCommandSet().getBytes());

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SalePayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalePayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalePayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalePayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalePayout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel datetxt;
    private javax.swing.JLabel eco1txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel rand1txt;
    private javax.swing.JLabel swipe1txt;
    private javax.swing.JLabel timetxt;
    private javax.swing.JLabel usd1txt;
    private javax.swing.JLabel usertxt;
    private javax.swing.JLabel zwl1txt;
    // End of variables declaration//GEN-END:variables
}
