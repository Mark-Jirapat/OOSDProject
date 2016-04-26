package View;

import Controller.Controller;
import Model.RestForm;
import Model.Room;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class SelectRoom extends javax.swing.JPanel {

    Controller controller;
    ArrayList<Room> rooms;
    RestForm rest;
    JPanel back;
    int bed;
    int count = 0;

    public SelectRoom(Controller controller, ArrayList<Room> rooms, RestForm rest, JPanel back) {
        this.controller = controller;
        this.rooms = rooms;
        this.rest = rest;
        this.back = back;
        this.bed = 0;
        initComponents();
        setBounds(0, 0, 800, 600);
        if (rest.getStatus() == 0) {
            add(new Header("Check In : Select Room"));
        } else {
            add(new Header("Reserve : Select Room"));
        }
        txtPeople.setText(rest.getAmountOfPeople() + "");
        txtBed.setText(bed + "");

        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                bed = 0;
                for (int i = 0; i < table.getRowCount(); i++) {
                    if ((boolean) table.getModel().getValueAt(i, 5)) {
                        bed += (int) table.getModel().getValueAt(i, 3);
                    }
                }
                txtBed.setText(bed + "");
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emptyPanel = new javax.swing.JPanel();
        scrollPaneForTable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblPeople = new javax.swing.JLabel();
        lblBed = new javax.swing.JLabel();
        txtPeople = new javax.swing.JTextField();
        txtBed = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 204, 0));

        emptyPanel.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room No", "Room Type", "Floor", "Amount of Bed", "Price", "Select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        scrollPaneForTable.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(5).setResizable(false);
        }

        btnNext.setBackground(new java.awt.Color(255, 204, 0));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
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

        lblPeople.setText("People");

        lblBed.setText("Bed");

        txtPeople.setBackground(java.awt.SystemColor.control);
        txtPeople.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPeople.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtPeople.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPeople.setEnabled(false);

        txtBed.setBackground(java.awt.SystemColor.control);
        txtBed.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBed.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtBed.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtBed.setEnabled(false);

        javax.swing.GroupLayout emptyPanelLayout = new javax.swing.GroupLayout(emptyPanel);
        emptyPanel.setLayout(emptyPanelLayout);
        emptyPanelLayout.setHorizontalGroup(
            emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emptyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneForTable, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addGroup(emptyPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblPeople)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBed, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBack)))
                .addContainerGap())
        );
        emptyPanelLayout.setVerticalGroup(
            emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emptyPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPaneForTable, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnBack)
                    .addComponent(lblPeople)
                    .addComponent(lblBed)
                    .addComponent(txtPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBed, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
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
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(emptyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        ArrayList<Integer> selectedRoomNo = new ArrayList<>();
        for (int i = 0; i < table.getRowCount(); i++) {
            if ((boolean) table.getModel().getValueAt(i, 5)) {
                selectedRoomNo.add((int) table.getModel().getValueAt(i, 0));
            }
        }
        controller.btnNextOnSelectRoom(rest, bed, rooms, selectedRoomNo, this);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        controller.goBack(back);
    }//GEN-LAST:event_btnBackActionPerformed

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JPanel emptyPanel;
    private javax.swing.JLabel lblBed;
    private javax.swing.JLabel lblPeople;
    private javax.swing.JScrollPane scrollPaneForTable;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBed;
    private javax.swing.JTextField txtPeople;
    // End of variables declaration//GEN-END:variables
}
