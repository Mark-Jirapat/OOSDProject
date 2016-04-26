package View;

import Controller.Controller;
import Model.RestForm;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ConfirmationAndDetail extends javax.swing.JPanel {

    Controller controller;
    RestForm rest;
    JPanel back;
    int type;

    public ConfirmationAndDetail(Controller controller, RestForm rest, int type, JPanel back) {
        this.controller = controller;
        this.rest = rest;
        this.back = back;
        this.type = type;
        initComponents();
        setBounds(0, 0, 800, 600);
        String header1 = (rest.getStatus() == 0) ? "Check In" : "Reserve";
        String header2 = (type == 0) ? "Confirmation" : "Detail";
        add(new Header(header1 + " : " + header2));
        txtSocialNo.setText(rest.getCustomer().getSocialNo());
        txtFirstName.setText(rest.getCustomer().getFirstName());
        txtLastName.setText(rest.getCustomer().getLastName());
        txtAmountOfPeople.setText(rest.getAmountOfPeople() + "");
        calendarStartDate.setDate(rest.getStartDate());
        calendarEndDate.setDate(rest.getEndDate());
        String extraDay = (rest.getExtraDay() > 0) ? " (" + rest.getExtraDay() + ")" : "";
        txtTotalDay.setText((rest.getTotalDay() + rest.getExtraDay()) + "" + extraDay);
        txtTotalRoom.setText(rest.getTotalRoom() + "");
        txtTotalBed.setText(rest.getTotalBed() + "");
        String extraPrice = (rest.getExtraPrice() > 0) ? " (" + rest.getExtraPrice() + ")" : "";
        txtTotalPrice.setText((rest.getTotalPrice() + rest.getExtraPrice()) + "" + extraPrice);
        if (type == 2) {
            btnCommand1.hide();
            btnCommand2.hide();
        } else if (type == 0) {
            btnCommand1.setText("Confirm");
            btnCommand2.hide();
        } else if (type == 1 && rest.getStatus() == 0) {
            btnCommand1.setText("Check Out");
            btnCommand2.hide();
        } else if (type == 1 && rest.getStatus() == 1) {
            btnCommand1.setText("Check In");
            btnCommand2.setText("Cancel");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emptyPanel = new javax.swing.JPanel();
        scrollPaneForTable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnCommand1 = new javax.swing.JButton();
        lblRoomList = new javax.swing.JLabel();
        txtAmountOfPeople = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtSocialNo = new javax.swing.JTextField();
        calendarStartDate = new org.freixas.jcalendar.JCalendarCombo();
        calendarEndDate = new org.freixas.jcalendar.JCalendarCombo();
        txtTotalDay = new javax.swing.JTextField();
        txtTotalRoom = new javax.swing.JTextField();
        txtTotalPrice = new javax.swing.JTextField();
        txtTotalBed = new javax.swing.JTextField();
        lblSocialNo = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblAmountOfPeople = new javax.swing.JLabel();
        lblStartDate = new javax.swing.JLabel();
        lblEndDate = new javax.swing.JLabel();
        lblTotalDay = new javax.swing.JLabel();
        lblTotalRoom = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        lblTotalBed = new javax.swing.JLabel();
        btnCommand2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 0));

        emptyPanel.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room No", "Room Type", "Floor", "Bed Amount", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFocusable(false);
        table.setRowSelectionAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        scrollPaneForTable.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
        }

        btnBack.setBackground(new java.awt.Color(255, 204, 0));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCommand1.setBackground(new java.awt.Color(255, 204, 0));
        btnCommand1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnCommand1.setText("C1");
        btnCommand1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommand1ActionPerformed(evt);
            }
        });

        lblRoomList.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblRoomList.setText("Room List");

        txtAmountOfPeople.setBackground(java.awt.SystemColor.control);
        txtAmountOfPeople.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtAmountOfPeople.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAmountOfPeople.setEnabled(false);
        txtAmountOfPeople.setPreferredSize(new java.awt.Dimension(150, 22));

        txtLastName.setBackground(java.awt.SystemColor.control);
        txtLastName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtLastName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtLastName.setEnabled(false);
        txtLastName.setPreferredSize(new java.awt.Dimension(150, 22));

        txtFirstName.setBackground(java.awt.SystemColor.control);
        txtFirstName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtFirstName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtFirstName.setEnabled(false);
        txtFirstName.setPreferredSize(new java.awt.Dimension(150, 22));

        txtSocialNo.setBackground(java.awt.SystemColor.control);
        txtSocialNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtSocialNo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtSocialNo.setEnabled(false);
        txtSocialNo.setPreferredSize(new java.awt.Dimension(150, 22));

        calendarStartDate.setEnabled(false);
        calendarStartDate.setMaximumSize(new java.awt.Dimension(166, 22));

        calendarEndDate.setEnabled(false);
        calendarEndDate.setMaximumSize(new java.awt.Dimension(166, 22));

        txtTotalDay.setBackground(java.awt.SystemColor.control);
        txtTotalDay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtTotalDay.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTotalDay.setEnabled(false);
        txtTotalDay.setPreferredSize(new java.awt.Dimension(150, 22));

        txtTotalRoom.setBackground(java.awt.SystemColor.control);
        txtTotalRoom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtTotalRoom.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTotalRoom.setEnabled(false);
        txtTotalRoom.setPreferredSize(new java.awt.Dimension(150, 22));

        txtTotalPrice.setBackground(java.awt.SystemColor.control);
        txtTotalPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtTotalPrice.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTotalPrice.setEnabled(false);
        txtTotalPrice.setPreferredSize(new java.awt.Dimension(150, 22));

        txtTotalBed.setBackground(java.awt.SystemColor.control);
        txtTotalBed.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtTotalBed.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTotalBed.setEnabled(false);
        txtTotalBed.setPreferredSize(new java.awt.Dimension(150, 22));

        lblSocialNo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblSocialNo.setText("Social No.");

        lblFirstName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblFirstName.setText("First Name");

        lblLastName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblLastName.setText("Last Name");

        lblAmountOfPeople.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblAmountOfPeople.setText("People Amount");

        lblStartDate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblStartDate.setText("Start Date");

        lblEndDate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblEndDate.setText("End Date");

        lblTotalDay.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTotalDay.setText("Total Day");

        lblTotalRoom.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTotalRoom.setText("Total Room");

        lblTotalPrice.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTotalPrice.setText("Total Price");

        lblTotalBed.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTotalBed.setText("Total Bed");

        btnCommand2.setBackground(new java.awt.Color(255, 204, 0));
        btnCommand2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnCommand2.setText("C2");
        btnCommand2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommand2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout emptyPanelLayout = new javax.swing.GroupLayout(emptyPanel);
        emptyPanel.setLayout(emptyPanelLayout);
        emptyPanelLayout.setHorizontalGroup(
            emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emptyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emptyPanelLayout.createSequentialGroup()
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFirstName)
                            .addComponent(lblSocialNo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAmountOfPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSocialNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emptyPanelLayout.createSequentialGroup()
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(emptyPanelLayout.createSequentialGroup()
                                .addComponent(lblTotalDay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalDay, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(emptyPanelLayout.createSequentialGroup()
                                .addComponent(lblTotalRoom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(emptyPanelLayout.createSequentialGroup()
                                .addComponent(lblTotalPrice)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(emptyPanelLayout.createSequentialGroup()
                                .addComponent(lblTotalBed)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalBed, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(emptyPanelLayout.createSequentialGroup()
                                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(emptyPanelLayout.createSequentialGroup()
                                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblAmountOfPeople)
                                            .addComponent(lblLastName))
                                        .addGap(7, 7, 7))
                                    .addGroup(emptyPanelLayout.createSequentialGroup()
                                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblStartDate)
                                            .addComponent(lblEndDate))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(calendarEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(calendarStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emptyPanelLayout.createSequentialGroup()
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCommand2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCommand1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)))
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(emptyPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblRoomList))
                    .addGroup(emptyPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPaneForTable, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emptyPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(27, 27, 27))
        );
        emptyPanelLayout.setVerticalGroup(
            emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emptyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRoomList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(emptyPanelLayout.createSequentialGroup()
                        .addComponent(scrollPaneForTable, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack))
                    .addGroup(emptyPanelLayout.createSequentialGroup()
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSocialNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSocialNo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFirstName))
                        .addGap(10, 10, 10)
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLastName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAmountOfPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAmountOfPeople))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calendarStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStartDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calendarEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEndDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalDay))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalRoom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalBed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalBed))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCommand1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCommand2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(emptyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCommand1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommand1ActionPerformed
        controller.btnCommand1OnConfirmationAndDetail(rest, type);
    }//GEN-LAST:event_btnCommand1ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        controller.goBack(back);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCommand2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommand2ActionPerformed
        controller.btnCommand2OnConfirmationAndDetail(rest);
    }//GEN-LAST:event_btnCommand2ActionPerformed

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCommand1;
    private javax.swing.JButton btnCommand2;
    private org.freixas.jcalendar.JCalendarCombo calendarEndDate;
    private org.freixas.jcalendar.JCalendarCombo calendarStartDate;
    private javax.swing.JPanel emptyPanel;
    private javax.swing.JLabel lblAmountOfPeople;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblRoomList;
    private javax.swing.JLabel lblSocialNo;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblTotalBed;
    private javax.swing.JLabel lblTotalDay;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JLabel lblTotalRoom;
    private javax.swing.JScrollPane scrollPaneForTable;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtAmountOfPeople;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtSocialNo;
    private javax.swing.JTextField txtTotalBed;
    private javax.swing.JTextField txtTotalDay;
    private javax.swing.JTextField txtTotalPrice;
    private javax.swing.JTextField txtTotalRoom;
    // End of variables declaration//GEN-END:variables
}
