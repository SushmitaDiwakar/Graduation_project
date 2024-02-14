
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * @author DELL
 */
public class Medicine extends javax.swing.JFrame {
public static int[]idar;// id arrey variable
    /**
     * Creates new form Medicine
     */
    public Medicine() {
        initComponents();
        filldata();
        loaddata();
        //Tableshowdata();
        Companydata();
        lblmid.setVisible(false);
        txtmid.setVisible(false);
        btnupdate.setEnabled(false);
        btndelete.setEnabled(false);
    }

    public void Companydata() {
        
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
            q_count="select count(*) as ttl_list from company";
            stmt=con.createStatement();
            rs_count=stmt.executeQuery(q_count);
            if(rs_count.next())
            {
            int total_list,i=0;
            total_list=rs_count.getInt("ttl_list");
            idar=new int[total_list];
             q_list="SELECT * from company";
             stmt=con.createStatement();
            rs_list= stmt.executeQuery(q_list);
            
            //String qry = "SELECT * From company";
            //System.out.println(qry);
            //ResultSet rs = stmt.executeQuery(qry);
            while (rs_list.next()) {
                // int[] row;
                itemc.addItem(rs_list.getString("cname"));
                //itemc.addItem(row[0]);
                idar[i]=rs_list.getInt("cid");
                i++;
            }
            }
           
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void filldata() {

        //cat.addItem("Select Category");//
        itemmtype.addItem("Ointment");
        itemmtype.addItem("capsule");
        itemmtype.addItem("Antyseptic");
        itemmtype.addItem("Tabelets");
        itemmtype.addItem("Syrup");
        itemmtype.addItem("Spray");
        itemmtype.addItem("Powder");
    }

//    public void Tableshowdata()// throws SQLException
//    {
//
//        //cat.addItem("Select Category");//
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        jTable1.setModel(model);
//        model.setRowCount(0);
//        Object row[] = new Object[5];
//        try {
//
//            Connection con;
//            Statement stmt;
//            String uid = "root";
//            String pwd = "";
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharma", uid, pwd);
//            stmt = con.createStatement();
//            String qry = "SELECT * From medicine";
//            //System.out.println(qry);
//            ResultSet rs = stmt.executeQuery(qry);
//            while (rs.next()) {
//                // int[] row;
//                row[0] = rs.getInt("mid");
//                row[1] = rs.getInt("mname");
//                row[2] = rs.getInt("cid");
//                row[3] = rs.getInt("mtype");
//                row[4] = rs.getInt("medicineprice");
//                //row[0]=rs.getInt("mid");
//
//                model.addRow(row);
//
//                //itemc.addItem(row[0]);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//    }
//
    public void loaddata() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        jTable1.setModel(model);
        model.setRowCount(0);
        Object row[] = new Object[5];
        try {
            Connection con;

            Statement stmt;
            String uid = "root";
            String pwd = "";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharma", uid, pwd);
            stmt = con.createStatement();
           String qry = "SELECT *, cd.cname FROM Medicine md,company cd WHERE cd.cid=md.cid";
            //String qry = "SELECT md.mid,md.mname,md.mtype,md.medicineprice,cd.cname From Medicine md,company cd WHERE cd.cid=md.mid";
            System.out.println(qry);
            ResultSet rs = stmt.executeQuery(qry);
            while (rs.next()) {
                row[0] = rs.getInt("mid");
                row[1] = rs.getString("mname");
                row[2] = rs.getString("cname");
                row[3] = rs.getString("mtype");
                row[4] = rs.getInt("medicineprice");
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

        lblmid = new javax.swing.JLabel();
        txtmid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtmname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        itemc = new javax.swing.JComboBox();
        itemmtype = new javax.swing.JComboBox();
        btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        txtback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Medicine Entry");
        setBackground(new java.awt.Color(51, 102, 153));

        lblmid.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        lblmid.setText("Medicine ID");

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel2.setText("Medicine Name");

        txtmname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmnameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel5.setText("Price of Medicine");

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setText("Search By Name");

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine ID", "Medicine Name", "Company ", "Medicine Type", " Price "
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel3.setText("Company");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel4.setText("Medicine Type");

        itemc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemcActionPerformed(evt);
            }
        });

        btnsave.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnsave.setText("Save");
        btnsave.setBorder(new javax.swing.border.MatteBorder(null));
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnupdate.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        btnupdate.setText("Update");
        btnupdate.setBorder(new javax.swing.border.MatteBorder(null));
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgForProject/Delete.png"))); // NOI18N
        btndelete.setText("Delete");
        btndelete.setBorder(new javax.swing.border.MatteBorder(null));
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        txtback.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        txtback.setText("Back to Homepage");
        txtback.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        txtback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(lblmid)
                            .addComponent(jLabel2))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtprice, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(txtmname)
                            .addComponent(txtmid))
                        .addGap(455, 455, 455)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(itemmtype, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(598, 598, 598)
                        .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(txtback, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(111, 111, 111)
                                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1368, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtmid, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblmid))
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(itemc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtmname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(itemmtype, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtback, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtmnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmnameActionPerformed

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
       System.out.println("selected cod e: "+pro_code);
       
        try {
            String mname, mtype,company;
            int price;
            mname = txtmname.getText();
           // cid = Integer.parseInt(itemc.getSelectedItem().toString());
            mtype = itemmtype.getSelectedItem().toString();
            price = Integer.parseInt(txtprice.getText());

            Connection con;
            Statement stmt;
            String uid = "root";
            String pwd = "";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharma", uid, pwd);
            stmt = con.createStatement();
            String qry = "INSERT INTO medicine(mname,mtype,medicineprice,cid) VALUES('" + mname + "','" + mtype + "'," + price + "," +  pro_code+ ")";
            System.out.println(qry);
            stmt.executeUpdate(qry);
            JOptionPane.showMessageDialog(this, "Data Saved Successfully", "Status", JOptionPane.INFORMATION_MESSAGE);
            loaddata();
        } catch (NumberFormatException | SQLException | HeadlessException e) {
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
        try {
            String mname, mtype,cid;
            int price;
            mname = txtmname.getText();
            mtype = itemmtype.getSelectedItem().toString();
            price = Integer.parseInt(txtprice.getText());
            Connection con;
            Statement stmt;
            String uid = "root";
            String pwd = "";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharma", uid, pwd);
            stmt = con.createStatement();
            String qry = "UPDATE medicine SET mname='" + mname + "',mtype='"+ mtype + "',cid='"+pro_code+"',medicineprice=" + price + " WHERE mid=" +  Integer.parseInt(txtmid.getText());
            //System.out.println(qry);
            stmt.executeUpdate(qry);
            JOptionPane.showMessageDialog(this, "Data Updated Successfully", "Status", JOptionPane.INFORMATION_MESSAGE);
            loaddata();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        lblmid.setVisible(false);

        txtmid.setVisible(false);
        btnupdate.setEnabled(false);
        btndelete.setEnabled(false);
        btnsave.setEnabled(true);
        txtmname.setText("");
        txtprice.setText("");

    }//GEN-LAST:event_btnupdateActionPerformed

    private void txtsearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtsearchCaretUpdate
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        jTable1.setModel(model);
        model.setRowCount(0);
        Object row[] = new Object[5];
        try {

            Connection con;
            Statement stmt;
            String uid = "root";
            String pwd = "";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharma", uid, pwd);
            stmt = con.createStatement();
            String qry = "SELECT * ,cd.cname FROM Medicine md,company cd WHERE cd.cid = md.cid AND md.mname like '%" + txtsearch.getText() + "%'";
             //"SELECT *,md.mname From Stock_purchase sp,medicine md WHERE md.mid=sp.mid AND md.mname like '%"+txtsearch.getText()+"%'";
            //System.out.println(qry);
            ResultSet rs = stmt.executeQuery(qry);
            while (rs.next()) {
                row[0] = rs.getInt("mid");
                row[1] = rs.getString("mname");
                row[2] = rs.getString("cname");
                row[3] = rs.getString("mtype");
                row[4] = rs.getInt("medicineprice");
                model.addRow(row);
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_txtsearchCaretUpdate

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
                String qry = "DELETE FROM medicine WHERE mid=" + Integer.parseInt(txtmid.getText());
                //System.out.println(qry);
                stmt.executeUpdate(qry);
                JOptionPane.showMessageDialog(this, "Data Deleted Successful", "Status", JOptionPane.INFORMATION_MESSAGE);
                loaddata();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        lblmid.setVisible(false);
        txtmid.setVisible(false);
        btnupdate.setEnabled(false);
        btndelete.setEnabled(false);
        btnsave.setEnabled(true);
        txtmname.setText("");
        txtprice.setText("");


    }//GEN-LAST:event_btndeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        lblmid.setVisible(true);
        txtmid.setVisible(true);
        btnupdate.setEnabled(true);
        btndelete.setEnabled(true);
        btnsave.setEnabled(false);
        int i = jTable1.getSelectedRow();
        //  JOptionPane.showMessageDialog(this,""+i,"Status",JOptionPane.INFORMATION_MESSAGE);
        TableModel model = jTable1.getModel();
        txtmid.setText(model.getValueAt(i, 0).toString());
        txtmname.setText(model.getValueAt(i, 1).toString());
        itemc.setSelectedItem(model.getValueAt(i, 2).toString());
        itemmtype.setSelectedItem(model.getValueAt(i, 3).toString());
        txtprice.setText(model.getValueAt(i, 4).toString());


    }//GEN-LAST:event_jTable1MouseClicked

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
       
        
       
    }//GEN-LAST:event_txtsearchActionPerformed

    private void itemcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemcActionPerformed

    private void txtbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbackActionPerformed
        // TODO add your handling code here:
         Homepage h=new Homepage();
               h.setVisible(true);
               dispose();
    }//GEN-LAST:event_txtbackActionPerformed

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
            java.util.logging.Logger.getLogger(Medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Medicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox itemc;
    private javax.swing.JComboBox itemmtype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblmid;
    private javax.swing.JButton txtback;
    private javax.swing.JTextField txtmid;
    private javax.swing.JTextField txtmname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
