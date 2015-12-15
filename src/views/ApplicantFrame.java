/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.ApplicantController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.ApplicantBean;
import models.CompanyBean;

/**
 *
 * @author developer
 */
public class ApplicantFrame extends javax.swing.JFrame {

    private final DefaultTableModel tablemodel;
    private final DefaultTableModel companyTablemodel;
    private int primaryId = 1;
    private int companyId = 1;

    /**
     * Creates new form NewJFrame
     */
    public ApplicantFrame() {
        initComponents();
        tablemodel = (DefaultTableModel) tableApplicants.getModel();
        companyTablemodel = (DefaultTableModel) companyTable.getModel();
        refresh();
        refreshCompanies();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        companyTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableApplicants = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        companyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Company Name", "Address", "phone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        companyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                companyTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(companyTable);
        if (companyTable.getColumnModel().getColumnCount() > 0) {
            companyTable.getColumnModel().getColumn(0).setPreferredWidth(25);
            companyTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            companyTable.getColumnModel().getColumn(2).setPreferredWidth(200);
            companyTable.getColumnModel().getColumn(3).setPreferredWidth(75);
        }

        jButton1.setText("add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tableApplicants.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Applicant Name", "email", "contact #"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableApplicants.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableApplicantsMousePressed(evt);
            }
        });
        tableApplicants.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableApplicantsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableApplicantsKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tableApplicants);
        if (tableApplicants.getColumnModel().getColumnCount() > 0) {
            tableApplicants.getColumnModel().getColumn(0).setResizable(false);
            tableApplicants.getColumnModel().getColumn(0).setPreferredWidth(25);
            tableApplicants.getColumnModel().getColumn(1).setPreferredWidth(200);
            tableApplicants.getColumnModel().getColumn(2).setPreferredWidth(150);
            tableApplicants.getColumnModel().getColumn(3).setResizable(false);
            tableApplicants.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 36)); // NOI18N
        jLabel1.setText("Applicants");

        jButton4.setText("add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("edit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("remove");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 2, 36)); // NOI18N
        jLabel2.setText("Work History");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 435, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addGap(170, 170, 170))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(227, 227, 227))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(615, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jButton6))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jButton3))
                        .addGap(29, 29, 29))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(64, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(59, 59, 59)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ApplicantDialog d = new ApplicantDialog(this, true, ApplicantDialog.Type.add, null);
        d.setLocationRelativeTo(this);
        d.setVisible(true);
        if (d.isSuccess()) {
            refresh();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (!getSelected()) {
                return;
            }

            ApplicantBean mymodel = ApplicantController.getData(primaryId);

            ApplicantDialog d = new ApplicantDialog(this, true, ApplicantDialog.Type.edit, mymodel);
            d.setLocationRelativeTo(this);
            d.setVisible(true);
            if (d.isSuccess()) {
                refresh();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApplicantFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if (!getSelected()) {
                return;
            }

            ApplicantController.removeData(primaryId);
            JOptionPane.showMessageDialog(this, "Success!");
            refresh();
        } catch (SQLException ex) {
            Logger.getLogger(ApplicantFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void companyTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_companyTableMousePressed

    }//GEN-LAST:event_companyTableMousePressed

    private void tableApplicantsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableApplicantsMousePressed
        getSelected();
    }//GEN-LAST:event_tableApplicantsMousePressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int row = tableApplicants.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "please select an applicant!");
        }

        primaryId = Integer.parseInt(tablemodel.getValueAt(row, 0).toString());
        CompanyDialog d = new CompanyDialog(this, true, CompanyDialog.Type.add, null, primaryId);

        d.setLocationRelativeTo(this);
        d.setVisible(true);
        if (d.isSuccess()) {
            refreshCompanies();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            if (!getSelectedCompany()) {
                return;
            }

            CompanyBean mymodel = ApplicantController.getWorkHistoryData(companyId, primaryId);

            CompanyDialog d = new CompanyDialog(this, true, CompanyDialog.Type.edit, mymodel, primaryId);
            d.setLocationRelativeTo(this);
            d.setVisible(true);
            if (d.isSuccess()) {
                refreshCompanies();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApplicantFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            if (!getSelectedCompany()) {
                return;
            }

            ApplicantController.deleteCompanyXMLData(companyId, primaryId); 
            JOptionPane.showMessageDialog(this, "Success!");
            refreshCompanies();
        } catch (SQLException ex) {
            Logger.getLogger(ApplicantFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tableApplicantsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableApplicantsKeyPressed
        getSelected();
    }//GEN-LAST:event_tableApplicantsKeyPressed

    private void tableApplicantsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableApplicantsKeyReleased
        getSelected();
    }//GEN-LAST:event_tableApplicantsKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable companyTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableApplicants;
    // End of variables declaration//GEN-END:variables

    private void refresh() {
        try {
            while (tablemodel.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }

            ArrayList<ApplicantBean> al = ApplicantController.getAllData();
            Iterator<ApplicantBean> it = al.iterator();
            while (it.hasNext()) {
                ApplicantBean mymodel = it.next();
                Object[] ob = {
                    mymodel.getApplicantId(),
                    mymodel.getApplicantName(),
                    mymodel.getEmail(),
                    mymodel.getContactNumber()
                };
                tablemodel.addRow(ob);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApplicantFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refreshCompanies() {
        try {
            while (companyTablemodel.getRowCount() > 0) {
                companyTablemodel.removeRow(0);
            }

            ArrayList<CompanyBean> al = ApplicantController.getWorkHistoryAllData(primaryId);
            Iterator<CompanyBean> it = al.iterator();
            while (it.hasNext()) {
                CompanyBean mymodel = it.next();
                Object[] ob = {
                    mymodel.getCompanyId(),
                    mymodel.getCompanyName(),
                    mymodel.getAddress(),
                    mymodel.getPhone()
                };
                companyTablemodel.addRow(ob);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApplicantFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean getSelected() {
        int row = tableApplicants.getSelectedRow();
        if (row == -1) {
            return false;
        }

        primaryId = Integer.parseInt(tablemodel.getValueAt(row, 0).toString());
        refreshCompanies();
        return true;
    }
    
    private boolean getSelectedCompany() {
        int row = companyTable.getSelectedRow();
        if (row == -1) {
            return false;
        }

        companyId = Integer.parseInt(companyTablemodel.getValueAt(row, 0).toString());
       // refreshCompanies();
        return true;
    }

}