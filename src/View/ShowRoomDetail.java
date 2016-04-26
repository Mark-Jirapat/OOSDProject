package View;

import Controller.Controller;
import Model.RoomDetail;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ShowRoomDetail extends javax.swing.JPanel {

    Controller controller;
    RoomDetail roomDetail;
    JPanel back;

    public ShowRoomDetail(Controller controller, RoomDetail roomDetail, JPanel back) {
        this.controller = controller;
        this.roomDetail = roomDetail;
        this.back = back;
        initComponents();
        setBounds(0, 0, 800, 600);
        add(new Header("Room Detail"));
        txtRoomNo.setText(roomDetail.getRoom().getRoomNo() + "");
        txtRoomType.setText(roomDetail.getRoom().getRoomType().getRoomTypeName());
        txtFloorNo.setText(roomDetail.getRoom().getFloorNo() + "");
        txtAmountOfBed.setText(roomDetail.getRoom().getRoomType().getAmountOfBed() + "");
        txtPrice.setText(roomDetail.getRoom().getRoomType().getPrice() + "");
        if (roomDetail.getCurrentRest() == null) {
            txtInUse.setText("False");
        } else {
            txtInUse.setText("True");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emptyPanel = new javax.swing.JPanel();
        lblRoomNo = new javax.swing.JLabel();
        lblRoomTypeName = new javax.swing.JLabel();
        lblFloorNo = new javax.swing.JLabel();
        lblAmountOfBed = new javax.swing.JLabel();
        lblInUse = new javax.swing.JLabel();
        txtRoomNo = new javax.swing.JTextField();
        txtRoomType = new javax.swing.JTextField();
        txtFloorNo = new javax.swing.JTextField();
        txtAmountOfBed = new javax.swing.JTextField();
        txtInUse = new javax.swing.JTextField();
        btnDetailCurrentRest = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        scrollPaneFortable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnDetailReservedList = new javax.swing.JButton();
        lblReservedList = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 204, 0));

        emptyPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblRoomNo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblRoomNo.setText("Room No");

        lblRoomTypeName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblRoomTypeName.setText("Room Type");

        lblFloorNo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblFloorNo.setText("Floor No");

        lblAmountOfBed.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblAmountOfBed.setText("Amount of Bed");

        lblInUse.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblInUse.setText("In Use");

        txtRoomNo.setBackground(java.awt.SystemColor.control);
        txtRoomNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtRoomNo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtRoomNo.setEnabled(false);

        txtRoomType.setBackground(java.awt.SystemColor.control);
        txtRoomType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtRoomType.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtRoomType.setEnabled(false);

        txtFloorNo.setBackground(java.awt.SystemColor.control);
        txtFloorNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtFloorNo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtFloorNo.setEnabled(false);

        txtAmountOfBed.setBackground(java.awt.SystemColor.control);
        txtAmountOfBed.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtAmountOfBed.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAmountOfBed.setEnabled(false);

        txtInUse.setBackground(java.awt.SystemColor.control);
        txtInUse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtInUse.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtInUse.setEnabled(false);

        btnDetailCurrentRest.setBackground(new java.awt.Color(255, 204, 0));
        btnDetailCurrentRest.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnDetailCurrentRest.setText("Detail");
        btnDetailCurrentRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailCurrentRestActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 204, 0));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Social No", "First Name", "Last Name", "Start Date", "End Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneFortable.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
        }

        btnDetailReservedList.setBackground(new java.awt.Color(255, 204, 0));
        btnDetailReservedList.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnDetailReservedList.setText("Detail");
        btnDetailReservedList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailReservedListActionPerformed(evt);
            }
        });

        lblReservedList.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblReservedList.setText("Reserved List");

        lblPrice.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblPrice.setText("Price");

        txtPrice.setBackground(java.awt.SystemColor.control);
        txtPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtPrice.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPrice.setEnabled(false);

        javax.swing.GroupLayout emptyPanelLayout = new javax.swing.GroupLayout(emptyPanel);
        emptyPanel.setLayout(emptyPanelLayout);
        emptyPanelLayout.setHorizontalGroup(
            emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emptyPanelLayout.createSequentialGroup()
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblInUse)
                    .addComponent(lblAmountOfBed)
                    .addComponent(lblFloorNo)
                    .addComponent(lblRoomTypeName)
                    .addComponent(lblRoomNo)
                    .addComponent(lblPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrice)
                    .addComponent(txtRoomNo)
                    .addComponent(txtRoomType)
                    .addComponent(txtFloorNo)
                    .addComponent(txtAmountOfBed)
                    .addComponent(txtInUse)
                    .addGroup(emptyPanelLayout.createSequentialGroup()
                        .addComponent(btnDetailCurrentRest, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDetailReservedList, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPaneFortable, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReservedList))
                .addGap(15, 15, 15))
        );
        emptyPanelLayout.setVerticalGroup(
            emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emptyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(emptyPanelLayout.createSequentialGroup()
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoomNo)
                            .addComponent(txtRoomNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRoomTypeName)
                            .addComponent(txtRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFloorNo)
                            .addComponent(txtFloorNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAmountOfBed)
                            .addComponent(txtAmountOfBed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtInUse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInUse))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDetailCurrentRest)
                            .addComponent(btnBack)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emptyPanelLayout.createSequentialGroup()
                        .addComponent(lblReservedList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollPaneFortable, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDetailReservedList)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(110, Short.MAX_VALUE)
                .addComponent(emptyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetailCurrentRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailCurrentRestActionPerformed
        if (roomDetail.getCurrentRest() == null) {
            controller.error("Room is not in used.");
        } else {
            controller.btnDetailCurrentRestOnShowRoomDetail(roomDetail, this);
        }
    }//GEN-LAST:event_btnDetailCurrentRestActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        controller.goBack(back);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDetailReservedListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailReservedListActionPerformed
        if (roomDetail.getReservedRests().isEmpty() || roomDetail.getReservedRests() == null) {
            controller.error("Room is not reserve yet.");
        } else {
            if (table.getSelectedRow() == -1) {
                controller.error("Please select a row.");
            } else {
                String socialNo = (String) table.getModel().getValueAt(table.getSelectedRow(), 0);
                controller.btnDetailReservedListOnShowRoomDetail(socialNo, this);
            }
        }
    }//GEN-LAST:event_btnDetailReservedListActionPerformed

    public RoomDetail getRoomDetail() {
        return roomDetail;
    }

    public void setRoomDetail(RoomDetail roomDetail) {
        this.roomDetail = roomDetail;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDetailCurrentRest;
    private javax.swing.JButton btnDetailReservedList;
    private javax.swing.JPanel emptyPanel;
    private javax.swing.JLabel lblAmountOfBed;
    private javax.swing.JLabel lblFloorNo;
    private javax.swing.JLabel lblInUse;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblReservedList;
    private javax.swing.JLabel lblRoomNo;
    private javax.swing.JLabel lblRoomTypeName;
    private javax.swing.JScrollPane scrollPaneFortable;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtAmountOfBed;
    private javax.swing.JTextField txtFloorNo;
    private javax.swing.JTextField txtInUse;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtRoomNo;
    private javax.swing.JTextField txtRoomType;
    // End of variables declaration//GEN-END:variables
}
