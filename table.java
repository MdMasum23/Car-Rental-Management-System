
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class table extends javax.swing.JFrame {

    /**
     * Creates new form table
     */
  private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    /**
     * Creates new form Table and populates data.
     */
    public table() {
        initComponents();
        // Initialize database connection and populate table
        initializeDatabase();
        populateTable();
    }
    // </editor-fold>
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        DELETE = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        SEARCH = new javax.swing.JTextField();
        jButton1SEARCH = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NAME", "MOBILE", "ADDRESS", "NID_NUMBER", "PAYMENT", "ADVANCED", "DUE", "DISCOUNT", "car_name", "available"
            }
        ));
        jTable1.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 766, 337));

        DELETE.setText("DELETE");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });
        getContentPane().add(DELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 404, -1, -1));

        jButton2.setText("PREVIOUS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 404, -1, -1));

        UPDATE.setText("UPDATE");
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });
        getContentPane().add(UPDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 404, -1, -1));

        jButton4.setText("LOGOUT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 404, -1, -1));

        SEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEARCHActionPerformed(evt);
            }
        });
        getContentPane().add(SEARCH, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 456, 355, -1));

        jButton1SEARCH.setText("SEARCH");
        jButton1SEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1SEARCHActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1SEARCH, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 484, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallpaperflare.com_wallpaper (1).jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 780, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   FIRST loginPage = new FIRST();
    loginPage.setVisible(true);

    // Close the current window (FIRST page)
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
   login1 loginPage = new login1();
    loginPage.setVisible(true);

    // Close the current window (FIRST page)
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
           int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        try {
            String name = jTable1.getValueAt(selectedRow, 0).toString(); // Assuming the first column is "NAME".
            pst = con.prepareStatement("DELETE FROM information WHERE name_column = ?");
            pst.setString(1, name);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                ((DefaultTableModel) jTable1.getModel()).removeRow(selectedRow);
                System.out.println("Record deleted successfully.");
            }
        } catch (Exception ex) {
            System.err.println("Error deleting record: " + ex.getMessage());
        }
    } else {
        System.out.println("No row selected for deletion.");
    }
    }//GEN-LAST:event_DELETEActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
       int selectedRow = jTable1.getSelectedRow();  // Get selected row index
    
    if (selectedRow != -1) {  // If a row is selected
        try {
            // Get the updated values from the selected row (now the user may have edited these directly in the table)
            String name = (String) jTable1.getValueAt(selectedRow, 0);  // Assuming the first column is "NAME"
            String mobile = (String) jTable1.getValueAt(selectedRow, 1);
            String address = (String) jTable1.getValueAt(selectedRow, 2);
            String nid = (String) jTable1.getValueAt(selectedRow, 3);
            int payment = (int) jTable1.getValueAt(selectedRow, 4);
            int advanced = (int) jTable1.getValueAt(selectedRow, 5);
            float due = (float) jTable1.getValueAt(selectedRow, 6);
            int discount = (int) jTable1.getValueAt(selectedRow, 7);
            
            // Debugging: Print out values to verify what you're trying to update
            System.out.println("Updating row with: ");
            System.out.println("Name: " + name);
            System.out.println("Mobile: " + mobile);
            System.out.println("Address: " + address);
            System.out.println("NID: " + nid);
            System.out.println("Payment: " + payment);
            System.out.println("Advanced: " + advanced);
            System.out.println("Due: " + due);
            System.out.println("Discount: " + discount);

            // Prepare the SQL UPDATE query
            String updateQuery = "UPDATE information SET mobile_column = ?, address_column = ?, "
                    + "nid_number_column = ?, PAYMENT = ?, ADVANCED = ?, DUE = ?, DISCOUNT = ? WHERE name_column = ?";
            
            pst = con.prepareStatement(updateQuery);
            
            // Set the new values for the query
            pst.setString(1, mobile);
            pst.setString(2, address);
            pst.setString(3, nid);
            pst.setInt(4, payment);
            pst.setInt(5, advanced);
            pst.setFloat(6, due);
            pst.setInt(7, discount);
            pst.setString(8, name);  // Update the record where the name matches
            
            // Execute the update
            int rowsAffected = pst.executeUpdate();
            
            // Debugging: Print out the number of affected rows
            System.out.println("Rows affected: " + rowsAffected);
            
            if (rowsAffected > 0) {
                // Optionally, update the table model to reflect changes
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setValueAt(mobile, selectedRow, 1);
                model.setValueAt(address, selectedRow, 2);
                model.setValueAt(nid, selectedRow, 3);
                model.setValueAt(payment, selectedRow, 4);
                model.setValueAt(advanced, selectedRow, 5);
                model.setValueAt(due, selectedRow, 6);
                model.setValueAt(discount, selectedRow, 7);
                
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No record was updated. Please check the SQL query and row selection.");
            }
        } catch (Exception ex) {
            System.err.println("Error updating record: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (Exception e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    } else {
        System.out.println("No row selected for updating.");
    }
    }//GEN-LAST:event_UPDATEActionPerformed

    private void SEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEARCHActionPerformed
        jButton1SEARCHActionPerformed(evt);
    }//GEN-LAST:event_SEARCHActionPerformed

    private void jButton1SEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1SEARCHActionPerformed
 String nid = SEARCH.getText().trim();  // Get the NID from the search text field

    if (nid.isEmpty()) {
        System.out.println("Please enter an NID to search.");
        return;
    }

    try {
        // Query the database based on the entered NID
        String query = "SELECT * FROM information WHERE nid_number_column = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, nid);
        rs = pst.executeQuery();

        // Get the table model
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);  // Clear existing rows

        boolean found = false;
        while (rs.next()) {
            found = true;
            Object[] row = {
                rs.getString("name_column"),
                rs.getString("mobile_column"),
                rs.getString("address_column"),
                rs.getString("nid_number_column"),
                rs.getInt("PAYMENT"),
                rs.getInt("ADVANCED"),
                rs.getFloat("DUE"),
                rs.getInt("DISCOUNT")
            };
            model.addRow(row);
        }

        if (!found) {
            System.out.println("No records found for the given NID.");
        }

    } catch (Exception ex) {
        System.err.println("Error during search: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
        } catch (Exception e) {
            System.err.println("Error closing resources: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_jButton1SEARCHActionPerformed

 private void populateTable() {
        try {
            // Step 1: Establish database connection
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fahim", "root", "12345678");

            // Step 2: Prepare and execute the query
            pst = con.prepareStatement("SELECT * FROM information");
            rs = pst.executeQuery();

            // Step 3: Update table model with all columns
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setColumnIdentifiers(new String[] {
                "Serial", "Name", "Mobile", "Address", "NID", "Payment", "Advanced", "Due", "Discount"
            });
            model.setRowCount(0);

            // Step 4: Populate rows with data from the database
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("C_SERIAL"),
                    rs.getString("name_column"),
                    rs.getString("mobile_column"),
                    rs.getString("address_column"),
                    rs.getString("nid_number_column"),
                    rs.getInt("PAYMENT"),
                    rs.getInt("ADVANCED"),
                    rs.getFloat("DUE"),
                    rs.getInt("DISCOUNT")
                                       // rs.getFloat("car_name"),
                                         //                   rs.getFloat("available")
                };
                model.addRow(row);
            }

        } catch (Exception ex) {
            System.out.println("Error populating table: " + ex);
        } finally {
            try {
                // Step 5: Close connections
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing database resources: " + e);
            }
        }
    }
 
 
 
 
 private void initializeDatabase() {
        try {
            // Step 1: Establish database connection
            System.out.println("Connecting to database...");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fahim", "root", "12345678");
            System.out.println("Database connection successful.");
        } catch (Exception ex) {
            System.err.println("Error connecting to database: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Populates the JTable with data from the "information" table.
     */
  /*  private void populateTable() {
    try {
        if (con == null) {
            throw new IllegalStateException("Database connection is not initialized.");
        }

        // Step 2: Prepare and execute the query
        pst = con.prepareStatement("SELECT * FROM information");
        rs = pst.executeQuery();

        // Step 3: Populate table model with data
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear any existing rows

        while (rs.next()) {
            Object[] row = {
                rs.getString("name_column"),
                rs.getString("mobile_column"),
                rs.getString("address_column"),
                rs.getString("nid_number_column"),
                rs.getInt("PAYMENT"),
                rs.getInt("ADVANCED"),
                rs.getFloat("DUE"),
                rs.getInt("DISCOUNT")
            };
            model.addRow(row);
        }

        System.out.println("Data successfully fetched and displayed in the table.");
    } catch (Exception ex) {
        System.err.println("Error populating table: " + ex.getMessage());
        ex.printStackTrace();
    } finally {
        // Step 4: Close resources
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
        } catch (Exception e) {
            System.err.println("Error closing database resources: " + e.getMessage());
        }
    }
}

 */
  @SuppressWarnings("unchecked")
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new table().setVisible(true));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DELETE;
    private javax.swing.JTextField SEARCH;
    private javax.swing.JButton UPDATE;
    private javax.swing.JButton jButton1SEARCH;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
