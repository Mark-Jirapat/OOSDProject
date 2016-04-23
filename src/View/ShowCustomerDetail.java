package View;

import Controller.Controller;
import Model.CustomerDetail;

public class ShowCustomerDetail extends javax.swing.JPanel {
    
    Controller controller;
    CustomerDetail customer;

    public ShowCustomerDetail(Controller controller, CustomerDetail customer) {
        this.controller = controller;
        this.customer = customer;
        initComponents();
        setBounds(0, 0, 800, 600);
        add(new Header("Customer Detail"));
        txtSocialNo.setText(customer.getSocialNo());
        txtFirstName.setText(customer.getFirstName());
        txtLastName.setText(customer.getLastName());
        txtGender.setText(customer.getGenderToString());
        txtTelephoneNo.setText(customer.getTelephoneNo());
        txtAddress.setText(customer.getAddress());
        txtStatus.setText(customer.getStatusToString());
        if(customer.getStatus() == -1){
            btnCommand1.setText("Reserve");
            btnCommand2.setText("Check In");
        } else if (customer.getStatus() == 1){
            btnCommand1.setText("Check In");
            btnCommand2.setText("Detail");
        } else {
            btnCommand1.setText("Check Out");
            btnCommand2.setText("Detail");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emptyPanel = new javax.swing.JPanel();
        lblSocialNo = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblTelephoneNo = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        txtSocialNo = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtGender = new javax.swing.JTextField();
        txtTelephoneNo = new javax.swing.JTextField();
        scrollPaneForTxtAddress = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        txtStatus = new javax.swing.JTextField();
        btnCommand1 = new javax.swing.JButton();
        btnCommand2 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 0));

        emptyPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblSocialNo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblSocialNo.setText("Social No");

        lblFirstName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblFirstName.setText("First Name");

        lblLastName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblLastName.setText("Last Name");

        lblGender.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblGender.setText("Gender");

        lblTelephoneNo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTelephoneNo.setText("Telephone No");

        lblAddress.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblAddress.setText("Address");

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblStatus.setText("Status");

        txtSocialNo.setBackground(java.awt.SystemColor.control);
        txtSocialNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtSocialNo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtSocialNo.setEnabled(false);
        txtSocialNo.setPreferredSize(new java.awt.Dimension(6, 22));

        txtFirstName.setBackground(java.awt.SystemColor.control);
        txtFirstName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtFirstName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtFirstName.setEnabled(false);
        txtFirstName.setPreferredSize(new java.awt.Dimension(6, 22));

        txtLastName.setBackground(java.awt.SystemColor.control);
        txtLastName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtLastName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtLastName.setEnabled(false);
        txtLastName.setPreferredSize(new java.awt.Dimension(6, 22));

        txtGender.setBackground(java.awt.SystemColor.control);
        txtGender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtGender.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtGender.setEnabled(false);
        txtGender.setPreferredSize(new java.awt.Dimension(6, 22));

        txtTelephoneNo.setBackground(java.awt.SystemColor.control);
        txtTelephoneNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtTelephoneNo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTelephoneNo.setEnabled(false);
        txtTelephoneNo.setPreferredSize(new java.awt.Dimension(6, 22));

        scrollPaneForTxtAddress.setEnabled(false);

        txtAddress.setEditable(false);
        txtAddress.setBackground(java.awt.SystemColor.control);
        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        scrollPaneForTxtAddress.setViewportView(txtAddress);

        txtStatus.setBackground(java.awt.SystemColor.control);
        txtStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtStatus.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtStatus.setEnabled(false);
        txtStatus.setPreferredSize(new java.awt.Dimension(6, 22));

        btnCommand1.setBackground(new java.awt.Color(255, 204, 0));
        btnCommand1.setText("C1");
        btnCommand1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommand1ActionPerformed(evt);
            }
        });

        btnCommand2.setBackground(new java.awt.Color(255, 204, 0));
        btnCommand2.setText("C2");
        btnCommand2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommand2ActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 204, 0));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout emptyPanelLayout = new javax.swing.GroupLayout(emptyPanel);
        emptyPanel.setLayout(emptyPanelLayout);
        emptyPanelLayout.setHorizontalGroup(
            emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emptyPanelLayout.createSequentialGroup()
                .addContainerGap(262, Short.MAX_VALUE)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emptyPanelLayout.createSequentialGroup()
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddress, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTelephoneNo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblGender, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblLastName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFirstName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSocialNo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblStatus, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSocialNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTelephoneNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPaneForTxtAddress)
                            .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emptyPanelLayout.createSequentialGroup()
                        .addComponent(btnCommand1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCommand2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(202, 202, 202))
        );
        emptyPanelLayout.setVerticalGroup(
            emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emptyPanelLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSocialNo)
                    .addComponent(txtSocialNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFirstName)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelephoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelephoneNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress)
                    .addComponent(scrollPaneForTxtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCommand1)
                    .addComponent(btnCommand2)
                    .addComponent(btnBack))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emptyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(emptyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCommand1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommand1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCommand1ActionPerformed

    private void btnCommand2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommand2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCommand2ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        controller.goBack();
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCommand1;
    private javax.swing.JButton btnCommand2;
    private javax.swing.JPanel emptyPanel;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblSocialNo;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTelephoneNo;
    private javax.swing.JScrollPane scrollPaneForTxtAddress;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtSocialNo;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTelephoneNo;
    // End of variables declaration//GEN-END:variables
}
