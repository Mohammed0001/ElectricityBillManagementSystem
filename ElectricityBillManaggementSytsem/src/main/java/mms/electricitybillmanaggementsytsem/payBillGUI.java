
package mms.electricitybillmanaggementsytsem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Group Work
 */
public class payBillGUI extends javax.swing.JFrame {

    User user;
    Bill bill;
    double amount;
    public payBillGUI(User user , Bill bill ) {
        this.user = user;
        this.bill = bill;
        initComponents(); 
        amount = bill.getAmount() - (bill.getAmount() * bill.getDiscount()/100);
        jLabel4.setText(String.valueOf(amount));
        bankPanel.setVisible(false);
        instaPayPanel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        loginBtn2 = new javax.swing.JButton();
        instaPayRBtn = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        visaRBtn = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginBtn3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        instaPayPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        instaPayHandle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bankPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        expDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cardNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cvv = new javax.swing.JTextField();

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pay Bill");
        setBackground(new java.awt.Color(51, 204, 255));
        setName("Pay Bill"); // NOI18N
        setResizable(false);

        loginBtn2.setBackground(new java.awt.Color(0, 0, 0));
        loginBtn2.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn2.setText("Pay");
        loginBtn2.setActionCommand("Pay");
        loginBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtn2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(instaPayRBtn);
        instaPayRBtn.setText("Instapay");
        instaPayRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instaPayRBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Cash");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(visaRBtn);
        visaRBtn.setText("Visa");
        visaRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visaRBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter your payment method");

        jLabel2.setText("Pay bill");

        loginBtn3.setBackground(new java.awt.Color(204, 0, 0));
        loginBtn3.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn3.setText("Cancel payment");
        loginBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtn3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Amount To Pay");

        jLabel5.setText("Payment Address");

        javax.swing.GroupLayout instaPayPanelLayout = new javax.swing.GroupLayout(instaPayPanel);
        instaPayPanel.setLayout(instaPayPanelLayout);
        instaPayPanelLayout.setHorizontalGroup(
            instaPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instaPayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(instaPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(instaPayPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(instaPayHandle)))
        );
        instaPayPanelLayout.setVerticalGroup(
            instaPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instaPayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instaPayHandle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel4.setText("Amount To Pay");

        jLabel6.setText("Exp date");

        expDate.setText("mm/yy");

        jLabel7.setText("Card Number");

        cardNumber.setText("****-****-****-****");

        jLabel8.setText("cvv");

        cvv.setText("***");

        javax.swing.GroupLayout bankPanelLayout = new javax.swing.GroupLayout(bankPanel);
        bankPanel.setLayout(bankPanelLayout);
        bankPanelLayout.setHorizontalGroup(
            bankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bankPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardNumber)
                    .addGroup(bankPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))
                    .addGroup(bankPanelLayout.createSequentialGroup()
                        .addGroup(bankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(expDate, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cvv, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        bankPanelLayout.setVerticalGroup(
            bankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bankPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cvv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(instaPayPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bankPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(instaPayRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(visaRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginBtn3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loginBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(instaPayRBtn)
                    .addComponent(visaRBtn)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instaPayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bankPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        instaPayPanel.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void loginBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtn2ActionPerformed
        IPayBillB type;
        if (instaPayRBtn.isSelected()){
            type = new InstapayB(instaPayHandle.getText());
        }else if (visaRBtn.isSelected()) {
            type = new BankCardB(Integer.parseInt(cardNumber.getText()), Integer.parseInt(cvv.getText()), expDate.getText());
        }else{
            type = new CashB();
        }
        PaymentB payment = new PaymentB(bill);
        payment.setType(type);
        if(payment.payBill()){
              JOptionPane.showMessageDialog(null, "Payment Added Successfully!", "Success!", JOptionPane.PLAIN_MESSAGE);
              user.openHome();
             this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "Error! Paying Bill", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_loginBtn2ActionPerformed

    private void loginBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtn3ActionPerformed
        user.openHome();
        this.setVisible(false);    // TODO add your handling code here:
    }//GEN-LAST:event_loginBtn3ActionPerformed

    private void instaPayRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instaPayRBtnActionPerformed
        instaPayPanel.setVisible(true);
        bankPanel.setVisible(false);
    }//GEN-LAST:event_instaPayRBtnActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        instaPayPanel.setVisible(false);
        bankPanel.setVisible(false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void visaRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visaRBtnActionPerformed
        instaPayPanel.setVisible(false);
        bankPanel.setVisible(true);
    }//GEN-LAST:event_visaRBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bankPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cardNumber;
    private javax.swing.JTextField cvv;
    private javax.swing.JTextField expDate;
    private javax.swing.JTextField instaPayHandle;
    private javax.swing.JPanel instaPayPanel;
    private javax.swing.JRadioButton instaPayRBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton loginBtn2;
    private javax.swing.JButton loginBtn3;
    private javax.swing.JRadioButton visaRBtn;
    // End of variables declaration//GEN-END:variables
}
