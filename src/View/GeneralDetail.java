package View;

import Controller.Controller;
import Model.RestForm;
import java.util.Date;
import javax.swing.JPanel;

public class GeneralDetail extends javax.swing.JPanel {

    Controller controller;
    RestForm rest;
    Date currentDate;
    JPanel back;

    public GeneralDetail(Controller controller, RestForm rest, Date currentDate, JPanel back) {
        this.controller = controller;
        this.rest = rest;
        this.currentDate = currentDate;
        this.back = back;
        initComponents();
        setBounds(0, 0, 800, 600);
        if (rest.getStatus() == 0) {
            add(new Header("Check In : General Detail"));
        } else {
            add(new Header("Reserve : General Detail"));
        }
        txtSocialNo.setText(rest.getCustomer().getSocialNo());
        txtFirstName.setText(rest.getCustomer().getLastName());
        txtLastName.setText(rest.getCustomer().getLastName());
        txtAmountOfPeople.setText("");
        calendarStartDate.setDate(currentDate);
        calendarEndDate.setDate(currentDate);
        if (rest.getStatus() == 0) {
            calendarStartDate.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emptyPanel = new javax.swing.JPanel();
        lblSocialNo = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblAmountOfPeople = new javax.swing.JLabel();
        lblStartDate = new javax.swing.JLabel();
        lblEndDate = new javax.swing.JLabel();
        txtSocialNo = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtAmountOfPeople = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        calendarStartDate = new org.freixas.jcalendar.JCalendarCombo();
        calendarEndDate = new org.freixas.jcalendar.JCalendarCombo();

        setBackground(new java.awt.Color(255, 204, 0));

        emptyPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblSocialNo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblSocialNo.setText("Social No");

        lblFirstName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblFirstName.setText("First Name");

        lblLastName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblLastName.setText("Last Name");

        lblAmountOfPeople.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblAmountOfPeople.setText("Amount of People");

        lblStartDate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblStartDate.setText("Start Date");

        lblEndDate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblEndDate.setText("End Date");

        txtSocialNo.setBackground(java.awt.SystemColor.control);
        txtSocialNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtSocialNo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtSocialNo.setEnabled(false);

        txtFirstName.setBackground(java.awt.SystemColor.control);
        txtFirstName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtFirstName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtFirstName.setEnabled(false);

        txtLastName.setBackground(java.awt.SystemColor.control);
        txtLastName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtLastName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtLastName.setEnabled(false);

        btnNext.setBackground(new java.awt.Color(255, 204, 0));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 204, 0));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout emptyPanelLayout = new javax.swing.GroupLayout(emptyPanel);
        emptyPanel.setLayout(emptyPanelLayout);
        emptyPanelLayout.setHorizontalGroup(
            emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emptyPanelLayout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEndDate)
                    .addComponent(lblStartDate)
                    .addComponent(lblSocialNo)
                    .addComponent(lblLastName)
                    .addComponent(lblAmountOfPeople)
                    .addComponent(lblFirstName))
                .addGap(18, 18, 18)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(emptyPanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addComponent(txtSocialNo)
                    .addComponent(txtFirstName)
                    .addComponent(txtLastName)
                    .addComponent(txtAmountOfPeople)
                    .addComponent(calendarEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(calendarStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        emptyPanelLayout.setVerticalGroup(
            emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emptyPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSocialNo)
                    .addComponent(txtSocialNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFirstName)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAmountOfPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAmountOfPeople))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStartDate)
                    .addComponent(calendarStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndDate)
                    .addComponent(calendarEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnCancel))
                .addContainerGap(206, Short.MAX_VALUE))
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
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(emptyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        String amountOfPeople = txtAmountOfPeople.getText();
        Date startDate = calendarStartDate.getDate();
        startDate.setHours(1);
        Date endDate = calendarEndDate.getDate();
        endDate.setHours(1);
        controller.btnNextOnGeneralDetail(rest, amountOfPeople, startDate, endDate, this);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        controller.goBack(back);
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnNext;
    private org.freixas.jcalendar.JCalendarCombo calendarEndDate;
    private org.freixas.jcalendar.JCalendarCombo calendarStartDate;
    private javax.swing.JPanel emptyPanel;
    private javax.swing.JLabel lblAmountOfPeople;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblSocialNo;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JTextField txtAmountOfPeople;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtSocialNo;
    // End of variables declaration//GEN-END:variables
}
