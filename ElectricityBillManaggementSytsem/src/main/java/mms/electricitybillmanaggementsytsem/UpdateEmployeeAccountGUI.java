
package mms.electricitybillmanaggementsytsem;

import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class UpdateEmployeeAccountGUI extends javax.swing.JFrame {

    Manager manager;
    ArrayList<Employee> employees;
    ArrayList<Technician> techs;
    public UpdateEmployeeAccountGUI(Manager manager) {
        this.manager = manager;
        initComponents();
        getEmployees();
        getTechs();
    }
    public void getEmployees(){
        employees = Employee.getEmployees();
        for (Employee employee : employees) {
          jComboBox1.addItem(String.valueOf(employee.getId()) +" " + String.valueOf(employee.getName()) + " Emp");
        }
    }
    public void getTechs(){
        techs = Technician.getTechs();
        for (Technician tech : techs) {
          jComboBox1.addItem(String.valueOf(tech.getId()) +" " + String.valueOf(tech.getName()) +" Tech");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dayShift = new javax.swing.JRadioButton();
        nightShift = new javax.swing.JRadioButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("createAcountCustomer");
        setBackground(new java.awt.Color(51, 204, 255));
        setName("loginFrame"); // NOI18N
        setResizable(false);

        jLabel4.setText("Update Customer Account");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Name:");

        jLabel2.setText("Username:");

        jLabel3.setText("password");

        jButton3.setBackground(new java.awt.Color(153, 204, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Home");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Employee");

        jLabel6.setText("Shift");

        buttonGroup1.add(dayShift);
        dayShift.setText("Day");
        dayShift.setName("shift"); // NOI18N
        dayShift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayShiftActionPerformed(evt);
            }
        });

        buttonGroup1.add(nightShift);
        nightShift.setText("Night");
        nightShift.setName("shift"); // NOI18N
        nightShift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nightShiftActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(91, 91, 91))
                    .addComponent(dayShift)
                    .addComponent(nightShift)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordField)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dayShift)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nightShift)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public int getId(String text){
        int id;
        id = Integer.parseInt(text.split(" ")[0]);
        return id;
    }
    public String getName(String text){
        String name;
        name = text.split(" ")[1];
        return name;
    }
    
    public String getType(String text){
        String type;
        type = text.split(" ")[text.split(" ").length - 1];
        return type;
    }
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if ("Emp".equals(getType((String)jComboBox1.getSelectedItem()))){
            Employee e = employees.get(jComboBox1.getSelectedIndex());
            nameField.setText(e.getName());
            usernameField.setText(e.getUsername());
            passwordField.setText(e.getPassword());
            if(e.getShift().equals("night")){
                dayShift.setSelected(false);
                nightShift.setSelected(true);
            }else{
                nightShift.setSelected(false);
                dayShift.setSelected(true);
            }
        }else{
            Technician t = techs.get(jComboBox1.getSelectedIndex() - employees.size());
            nameField.setText(t.getName());
            usernameField.setText(t.getUsername());
            passwordField.setText(t.getPassword());
            if(t.getShift().equals("night")){
                dayShift.setSelected(false);
                nightShift.setSelected(true);
            }else{
                nightShift.setSelected(false);
                dayShift.setSelected(true);
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String shift;
        if(dayShift.isSelected()){
            shift = "day";
        }else{
            shift = "night";
        }
        if ("Emp".equals(getType((String)jComboBox1.getSelectedItem()))){
            Employee e = employees.get(jComboBox1.getSelectedIndex());
            e.setName(nameField.getText());
            e.setShift(shift);
            e.setPassword(passwordField.getText());
            e.setUsername(usernameField.getText());
            if(e.updateAccount()){
                JOptionPane.showMessageDialog(null, "Employee : "+getName((String)jComboBox1.getSelectedItem())+" Successfully! Updated ", "Success!", JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Error! Updating Employee", "Error!", JOptionPane.PLAIN_MESSAGE);
            }
        }else{
            Technician t = techs.get(jComboBox1.getSelectedIndex() - employees.size());
            t.setName(nameField.getText());
            t.setShift(shift);
            t.setPassword(passwordField.getText());
            t.setUsername(usernameField.getText());
            if(t.updateAccount()){
                JOptionPane.showMessageDialog(null, "Technician : "+getName((String)jComboBox1.getSelectedItem())+" Successfully! Updated ", "Success!", JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Error! Updating Technican", "Error!", JOptionPane.PLAIN_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void dayShiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayShiftActionPerformed
        nightShift.setSelected(false);
    }//GEN-LAST:event_dayShiftActionPerformed

    private void nightShiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nightShiftActionPerformed
        dayShift.setSelected(false);
    }//GEN-LAST:event_nightShiftActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       manager.openHome();
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton dayShift;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nameField;
    private javax.swing.JRadioButton nightShift;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
