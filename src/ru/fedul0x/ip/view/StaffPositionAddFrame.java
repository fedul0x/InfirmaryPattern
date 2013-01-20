/*
 * Copyright 2013 Ivashin Alexey <ivashin.alexei@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.fedul0x.ip.view;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import ru.fedul0x.ip.view.component.model.RowTableModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.fedul0x.ip.dataaccess.DataSourceHibernate;
import ru.fedul0x.ip.dataaccess.dataobject.StaffPosition;
import ru.fedul0x.ip.view.component.model.HibernateRowTablModel;

/**
 *
 * @author Ivashin Alexey <ivashin.alexei@gmail.com>
 */
public class StaffPositionAddFrame extends javax.swing.JFrame {

    final Logger logger = LoggerFactory.getLogger(StaffPositionAddFrame.class);

    /**
     * Creates new form StaffPositionAddFrame
     */
    public StaffPositionAddFrame() {
        initComponents();
        HibernateRowTablModel<StaffPosition> hrtm =  new HibernateRowTablModel(StaffPosition.class);
        staffPositionTable.setModel(hrtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addEntityButton = new javax.swing.JButton();
        staffPositionNameTextField = new javax.swing.JTextField();
        descriptionTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        staffPositionTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addEntityButton.setText("addEntityButton");
        addEntityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEntityButtonActionPerformed(evt);
            }
        });

        staffPositionNameTextField.setText("staffPositionNameTextField");

        descriptionTextField.setText("descriptionTextField");

        staffPositionTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(staffPositionTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(descriptionTextField)
                        .addComponent(staffPositionNameTextField))
                    .addComponent(addEntityButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(staffPositionNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addEntityButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addEntityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEntityButtonActionPerformed
        // TODO add your handling code here:
        StaffPosition sp = new StaffPosition();
        sp.setId(100L);
        sp.setStaffPositionName(staffPositionNameTextField.getText());
        sp.setDescription(descriptionTextField.getText());
        DataSourceHibernate<StaffPosition> dsh = new DataSourceHibernate<>(StaffPosition.class);
        dsh.makePersistent(sp);
        List<StaffPosition> list = dsh.findAll();
        for (StaffPosition item : list) {
            System.out.print(item.getStaffPositionName());
        }
        System.out.print(list.size());

        StaffPosition one = dsh.findById(1L, true);
        System.out.print(one.getDescription());

        
    }//GEN-LAST:event_addEntityButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffPositionAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new StaffPositionAddFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEntityButton;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField staffPositionNameTextField;
    private javax.swing.JTable staffPositionTable;
    // End of variables declaration//GEN-END:variables
}
