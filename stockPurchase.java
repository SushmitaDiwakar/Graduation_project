import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CG-DTE
 */
public class stockPurchase extends javax.swing.JFrame {
public static int[]idar;
    /**
     * Creates new form stockPurchase
     */
    public stockPurchase() {
        initComponents();
        loaddata();
        medicinedata();
        changname();
        //loadavidata();
        lblstid.setVisible(false);
        txtstid.setVisible(false);
        btnupdate.setEnabled(false);
        btndelete.setEnabled(false);
    }
    public void changname()
    {
        try
        {
        String code="";
        int i=0;
        Connection con;
        Statement stmt;
        String uid = "root";
        String pwd = "";
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharma", uid, pwd);
        String qry ="SELECT MAX(SUBSTRING(stockcode,5)) AS maxcode FROM stock_purchase";
        System.out.println(qry);
        
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(qry);
        if(rs.next()==true)
        {
          // i =Integer.parseInt(rs.getString("maxcode"));
            i= Integer.parseInt(rs.getString("maxcode"));
           i++;
        }
        code="stck"+i;
        txtcode.setText(code);
        }
        catch(Exception e)
        {
          System.out.println(e.getMessage());
        }
    }
//    public void loadavidata()
//    {
//          DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        jTable1.setModel(model);
//        model.setRowCount(0);
//        Object row[] = new Object[9];
//        try {
//            Connection con;
//
//            Statement stmt;
//            String uid = "root";
//            String pwd = "";
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharma", uid, pwd);
//            stmt = con.createStatement();
//            String qry = "SELECT *,md.mname From Stock_available sp,medicine md WHERE md.mid=sp.mid";
//            System.out.println(qry);
//            ResultSet rs = stmt.executeQuery(qry);
//            while (rs.next()) {
//                row[0] = rs.getInt("stid");
//                row[1] = rs.getString("stockcode");
//                row[2] = rs.getString("mname");
//                row[3] = rs.getInt("sqty");
//                row[4] = rs.getString("s_mfg");
//                row[5] = rs.getString("s_exp");
//                row[6] = rs.getString("s_date");
//                row[8] = rs.getInt("batch_no");
//                
//                model.addRow(row);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
 //   }
    
    public void medicinedata() {
        
            Connection con;
            Statement stmt;
            ResultSet rs_count,rs_list;
            String q_count,q_list;
            try
            {
            String uid = "root";
            String pwd = "";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharma", uid, pwd);
            stmt = con.createStatement();
            q_count="select count(*) as ttl_list from medicine";
            stmt=con.createStatement();
            rs_count=stmt.executeQuery(q_count);
            if(rs_count.next())
            {
            int total_list,i=0;
            total_list=rs_count.getInt("ttl_list");
            idar=new int[total_list];
             q_list="SELECT * from medicine";
             stmt=con.createStatement();
            rs_list= stmt.executeQuery(q_list);
            
            //String qry = "SELECT * From company";
            //System.out.println(qry);
            //ResultSet rs = stmt.executeQuery(qry);
            while (rs_list.next()) {
                // int[] row;
                itemc.addItem(rs_list.getString("mname"));
                //itemc.addItem(row[0]);
                idar[i]=rs_list.getInt("mid");
                i++;
            }
            }
           
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
    public void loaddata() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        jTable1.setModel(model);
        model.setRowCount(0);
        Object row[] = new Object[9];
        try {
            Connection con;

            Statement stmt;
            String uid = "root";
            String pwd = "";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharma", uid, pwd);
            stmt = con.createStatement();
            String qry = "SELECT *,md.mname From Stock_purchase sp,medicine md WHERE md.mid=sp.mid";
            //System.out.println(qry);
            ResultSet rs = stmt.executeQuery(qry);
            while (rs.next()) {
                row[0] = rs.getInt("stockid");
                row[1] = rs.getString("stockcode");
                row[2] = rs.getString("mname");
                row[3] = rs.getDouble("stock_total_price");
                row[4] = rs.getInt("sqty");
                row[5] = rs.getString("s_mfg");
                row[6] = rs.getString("s_exp");
                row[7] = rs.getString("s_date");
                row[8] = rs.getInt("batch_no");
                
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblstid = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtstid = new javax.swing.JTextField();
        txtcode = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        txtqty = new javax.swing.JTextField();
        txtbno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jdcmfg = new org.netbeans.modules.form.InvalidComponent();
        jdcexp = new org.netbeans.modules.form.InvalidComponent();
        jdcdate = new org.netbeans.modules.form.InvalidComponent();
        itemc = new javax.swing.JComboBox();
        txtmfg = new javax.swing.JTextField();
        txtexp = new javax.swing.JTextField();
        txtdate = new javax.swing.JTextField();
        txtback = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jTextField5.setText("jTextField5");

        jTextField6.setText("jTextField6");

        jTextField11.setText("jTextField11");

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stock Purchase");
        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(102, 102, 102));
        setMaximumSize(new java.awt.Dimension(2073600, 2073600));

        jPanel1.setLayout(null);

        lblstid.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        lblstid.setText("stock id");
        jPanel1.add(lblstid);
        lblstid.setBounds(10, 100, 100, 29);

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel3.setText("stock code");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 160, 120, 22);

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel4.setText("medicine id");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(410, 110, 99, 20);

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel5.setText("stock total price");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(410, 200, 135, 22);

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel6.setText("Manufecturing Date");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(820, 110, 167, 22);

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel7.setText("Expairy Date");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(830, 160, 108, 22);

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel8.setText("Current Date");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(830, 200, 109, 22);

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel9.setText("batch no");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 210, 100, 29);

        jLabel10.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel10.setText("stock quantity");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(410, 160, 121, 22);

        txtstid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstidActionPerformed(evt);
            }
        });
        jPanel1.add(txtstid);
        txtstid.setBounds(150, 102, 218, 30);

        txtcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodeActionPerformed(evt);
            }
        });
        jPanel1.add(txtcode);
        txtcode.setBounds(150, 152, 218, 30);
        jPanel1.add(txtprice);
        txtprice.setBounds(560, 192, 220, 30);

        txtqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtyActionPerformed(evt);
            }
        });
        jPanel1.add(txtqty);
        txtqty.setBounds(560, 152, 217, 30);

        txtbno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbnoActionPerformed(evt);
            }
        });
        jPanel1.add(txtbno);
        txtbno.setBounds(150, 200, 220, 30);

        jTable1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "stock id", "stock code", "medicine id", "total  price", "stock quantity", "mfg", "exp", "date", "batch no"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(100, 420, 1100, 320);

        jLabel11.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgForProject/Find.png"))); // NOI18N
        jLabel11.setText("search by name");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(0, 300, 210, 29);

        txtsearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtsearchCaretUpdate(evt);
            }
        });
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        jPanel1.add(txtsearch);
        txtsearch.setBounds(231, 300, 410, 40);

        btnsave.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgForProject/Down.png"))); // NOI18N
        btnsave.setText("save");
        btnsave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), null));
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnsave);
        btnsave.setBounds(820, 300, 79, 35);

        btnupdate.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgForProject/Refresh.png"))); // NOI18N
        btnupdate.setText("update");
        btnupdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), null));
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnupdate);
        btnupdate.setBounds(930, 300, 110, 35);

        btndelete.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgForProject/Delete.png"))); // NOI18N
        btndelete.setText("delete");
        btndelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), null));
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete);
        btndelete.setBounds(680, 300, 110, 35);
        jPanel1.add(jdcmfg);
        jdcmfg.setBounds(1000, 112, 154, 30);
        jPanel1.add(jdcexp);
        jdcexp.setBounds(1000, 162, 154, 30);
        jPanel1.add(jdcdate);
        jdcdate.setBounds(1000, 202, 150, 30);

        itemc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemcActionPerformed(evt);
            }
        });
        jPanel1.add(itemc);
        itemc.setBounds(560, 100, 218, 30);

        txtmfg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmfgActionPerformed(evt);
            }
        });
        jPanel1.add(txtmfg);
        txtmfg.setBounds(1170, 120, 130, 20);

        txtexp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtexpActionPerformed(evt);
            }
        });
        jPanel1.add(txtexp);
        txtexp.setBounds(1170, 162, 130, 30);

        txtdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdateActionPerformed(evt);
            }
        });
        jPanel1.add(txtdate);
        txtdate.setBounds(1170, 210, 130, 20);

        txtback.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        txtback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgForProject/Back.png"))); // NOI18N
        txtback.setText("Back to Homepage");
        txtback.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbackActionPerformed(evt);
            }
        });
        jPanel1.add(txtback);
        txtback.setBounds(1060, 300, 250, 35);

        jPanel2.setBackground(new java.awt.Color(14, 0, 102));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Stock Purchase");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(510, 0, 370, 57);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(-30, 0, 1370, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
       String combo_value;
       int index,i,pro_code=0;
       combo_value=itemc.getSelectedItem().toString();
       index=itemc.getSelectedIndex();
       System.out.println("selected Name: "+combo_value);
        System.out.println("selected Name: "+index);
       
       for(i=0;i<idar.length;i++)
       {
           if(index==i)
           {
              pro_code=idar[i];
              
           }
       }
       System.out.println("selected code: "+pro_code);
       
         try
       {
           //SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
           String stockcode,smfg,sexp,sdate;
           int mid,sqty,batchno;
           double tprice;
           stockcode=txtcode.getText();
           SimpleDateFormat s1=new SimpleDateFormat("dd/mm/yyyy");
           smfg=s1.format(jdcmfg.getDate());
           SimpleDateFormat s2=new SimpleDateFormat("dd/mm/yyyy");
           sexp=s2.format(jdcexp.getDate());
           SimpleDateFormat s3=new SimpleDateFormat("dd/mm/yyyy");
           sdate=s3.format(jdcdate.getDate());
           sqty=Integer.parseInt(txtqty.getText());
           batchno=Integer.parseInt(txtbno.getText());
           tprice=Double.parseDouble(txtprice.getText());
           Connection con;
           Statement stmt;
           String uid="root";
           String pwd="";
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharma",uid,pwd);
           stmt=con.createStatement();
           String qry1="INSERT INTO stock_purchase (stockcode,mid,stock_total_price,sqty,s_mfg,s_exp,s_date,batch_no)VALUES('"+stockcode+"',"+pro_code+","+tprice+","+sqty+",'"+smfg+"','"+sexp+"','"+sdate+"',"+batchno+")";
             String qry2="INSERT INTO stock_available (stockcode,mid,sqty,s_mfg,s_exp,s_date,batch_no)VALUES('"+stockcode+"',"+pro_code+","+sqty+",'"+smfg+"','"+sexp+"','"+sdate+"',"+batchno+")";
           // System.out.println(qry1);
           stmt.executeUpdate(qry1);
            stmt.executeUpdate(qry2);
           JOptionPane.showMessageDialog(this,"Data Saved Successfully","Status",JOptionPane.INFORMATION_MESSAGE);
           loaddata();
       }
       catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
       String combo_value;
       int index,i,pro_code=0;
       combo_value=itemc.getSelectedItem().toString();
       index=itemc.getSelectedIndex();
       System.out.println("selected Name: "+combo_value);
        System.out.println("selected Name: "+index);
       
       for(i=0;i<idar.length;i++)
       {
           if(index==i)
           {
              pro_code=idar[i];
              
           }
       }
       System.out.println("selected code: "+pro_code);
       
         try
       {
           //SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
           String stockcode,smfg,sexp,sdate;
           int sqty,batchno;
           double tprice;
           stockcode=txtcode.getText();
           SimpleDateFormat s1=new SimpleDateFormat("dd/mm/yyyy");
           smfg=s1.format(jdcmfg.getDate());
           SimpleDateFormat s2=new SimpleDateFormat("dd/mm/yyyy");
           sexp=s2.format(jdcexp.getDate());
           SimpleDateFormat s3=new SimpleDateFormat("dd/mm/yyyy");
           sdate=s3.format(jdcdate.getDate());
           sqty=Integer.parseInt(txtqty.getText());
           batchno=Integer.parseInt(txtbno.getText());
           tprice=Double.parseDouble(txtprice.getText());
           Connection con;
           Statement stmt;
           String uid="root";
           String pwd="";
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharma",uid,pwd);
           stmt=con.createStatement();
           String qry="UPDATE stock_purchase SET stockcode='"+stockcode+"',mid="+ pro_code +",stock_total_price='"+ tprice +"',sqty=" +sqty+ ",s_mfg='"+smfg+"',s_exp='"+sexp+ "',s_date='"+sdate+"',batch_no="+batchno+" WHERE stockid=" +Integer.parseInt(txtstid.getText());
          System.out.println(qry);
            stmt.executeUpdate(qry);
            JOptionPane.showMessageDialog(this, "Data Updated Successfully", "Status", JOptionPane.INFORMATION_MESSAGE);
            loaddata();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        lblstid.setVisible(false);

        txtstid.setVisible(false);
        btnupdate.setEnabled(false);
        btndelete.setEnabled(false);
        btnsave.setEnabled(true);
        txtcode.setText("");
        txtprice.setText("");
        txtqty.setText("");
        txtbno.setText("");
     

        
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
         int result = JOptionPane.showConfirmDialog(this, "Are You Sure??", "Confimation", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            try {

                Connection con;
                Statement stmt;
                String uid = "root";
                String pwd = "";
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharma", uid, pwd);
                stmt = con.createStatement();
                String qry = "DELETE FROM stock_purchase WHERE stockid=" + Integer.parseInt(txtstid.getText());
                //System.out.println(qry);
                stmt.executeUpdate(qry);
                JOptionPane.showMessageDialog(this, "Data Deleted Successful", "Status", JOptionPane.INFORMATION_MESSAGE);
                loaddata();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        lblstid.setVisible(false);
        txtstid.setVisible(false);
        btnupdate.setEnabled(false);
        btndelete.setEnabled(false);
        btnsave.setEnabled(true);
        txtcode.setText("");
        txtprice.setText("");
        txtqty.setText("");
        txtbno.setText("");
        txtmfg.setText("");
        txtexp.setText("");
        txtdate.setText("");
     
        

    }//GEN-LAST:event_btndeleteActionPerformed

    private void txtsearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtsearchCaretUpdate
        // TODO add your handling code here:
          DefaultTableModel model=(DefaultTableModel) jTable1.getModel();    
     jTable1.setModel(model);
     model.setRowCount(0);
     Object row[]=new Object[9];
     try
        {
            Connection con;
            Statement stmt;
            String uid="root";
            String pwd="";
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharma",uid,pwd);
            stmt=con.createStatement();
            //String qry="SELECT * FROM stock_available  WHERE mid="+Integer.parseInt(txtsearch.getText());
           // String qry="SELECT * FROM stock_purchase WHERE mid in(SELECT mid from medicine where mname like '%"+txtsearch.getText()+"%')";
           //String qry = "SELECT sp.stockid,sp.stockcode, sp.stock_total_price ,sp.sqty,sp.s_mfg,sp.s_exp,sp.s_date,md.mname,sp.batch_no From Stock_purchase sp,medicine md WHERE md.mid=sp.mid, AND md.mname like '%"+txtsearch.getText()+"%'";
            String qry = "SELECT *,md.mname From Stock_purchase sp,medicine md WHERE md.mid=sp.mid AND md.mname like '%"+txtsearch.getText()+"%'";
            //System.out.println(qry);
            ResultSet rs=stmt.executeQuery(qry);
            while(rs.next())
            {
                row[0]=rs.getInt("stockid");
                row[1]=rs.getString("stockcode");
                row[2]=rs.getString("mname");
                row[3]=rs.getDouble("stock_total_price");
                row[4]=rs.getInt("sqty");
                row[5]=rs.getString("s_mfg");
                row[6]=rs.getString("s_exp");
                row[7]=rs.getString("s_date");
                row[8]=rs.getInt("batch_no");
                model.addRow(row);
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
         
         
    }//GEN-LAST:event_txtsearchCaretUpdate

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         lblstid.setVisible(true);
        txtstid.setVisible(true);
        btnupdate.setEnabled(true);
        btndelete.setEnabled(true);
        btnsave.setEnabled(false);
        int i = jTable1.getSelectedRow();
        //  JOptionPane.showMessageDialog(this,""+i,"Status",JOptionPane.INFORMATION_MESSAGE);
        TableModel model = jTable1.getModel();
        txtstid.setText(model.getValueAt(i, 0).toString());
        txtcode.setText(model.getValueAt(i, 1).toString());
        itemc.setSelectedItem(model.getValueAt(i, 2).toString());
        txtprice.setText(model.getValueAt(i, 3).toString());
        txtqty.setText(model.getValueAt(i, 4).toString());
        txtmfg.setText(model.getValueAt(i, 5).toString());
        txtexp.setText(model.getValueAt(i, 6).toString());
        txtdate.setText(model.getValueAt(i, 7).toString());
        txtbno.setText(model.getValueAt(i, 8).toString());


    }//GEN-LAST:event_jTable1MouseClicked

    private void txtbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbackActionPerformed
        // TODO add your handling code here:
         Homepage h=new Homepage();
               h.setVisible(true);
               dispose();
    }//GEN-LAST:event_txtbackActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void txtdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdateActionPerformed

    private void txtexpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtexpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtexpActionPerformed

    private void itemcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemcActionPerformed

    private void txtqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqtyActionPerformed

    private void txtbnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbnoActionPerformed

    private void txtcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodeActionPerformed

    private void txtstidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstidActionPerformed

    private void txtmfgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmfgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmfgActionPerformed

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
            java.util.logging.Logger.getLogger(stockPurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stockPurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stockPurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stockPurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stockPurchase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox itemc;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private org.netbeans.modules.form.InvalidComponent jdcdate;
    private org.netbeans.modules.form.InvalidComponent jdcexp;
    private org.netbeans.modules.form.InvalidComponent jdcmfg;
    private javax.swing.JLabel lblstid;
    private javax.swing.JButton txtback;
    private javax.swing.JTextField txtbno;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtexp;
    private javax.swing.JTextField txtmfg;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtstid;
    // End of variables declaration//GEN-END:variables

    //private void initComponents() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
}
