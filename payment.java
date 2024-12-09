/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class payment extends javax.swing.JFrame {
    
    
    
    
    
    
 
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

   public payment() {
        initComponents();
         try {
    // Load the MySQL JDBC Driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    // Establish the connection to the database
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fahim", "root", "12345678");

    // Prepare the query to fetch data from the 'information' table
    pst = con.prepareStatement("SELECT * FROM information");

    // Execute the query
    rs = pst.executeQuery();

    // Check if there is data and populate the fields
  /*  if (rs.next()) {
        name_column.setText(rs.getString("name_column")); // Fetch name_column
        mobile_column.setText(rs.getString("mobile_column")); // Fetch mobile_column
        address_column.setText(rs.getString("address_column")); // Fetch address_column
        nid_number_column.setText(rs.getString("nid_number_column")); // Fetch nid_number_column
        
        PAYMENT.setText(String.valueOf(rs.getInt("PAYMENT"))); // Fetch PAYMENT as int
        ADVANCED.setText(String.valueOf(rs.getInt("ADVANCED"))); // Fetch ADVANCED as int
        DUE.setText(String.valueOf(rs.getInt("DUE"))); // Fetch DUE as int
        DISCOUNT.setText(String.valueOf(rs.getInt("DISCOUNT"))); // Fetch DISCOUNT as int
         car_name.setText(String.valueOf(rs.getInt("car_name")));
          available.setText(String.valueOf(rs.getInt("available")));
    }*/
} catch (Exception ex) {
    // Print any exceptions to help with debugging
    System.out.println("Error: " + ex.getMessage());
}
  
        
   

         //initializeRentMap();
      
        
        
        
        
        // Add DocumentListener to PAYMENT, ADVANCED, and DISCOUNT fields
        PAYMENT.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateDue();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateDue();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateDue();
            }
        });

        ADVANCED.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateDue();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateDue();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateDue();
            }
        });

        DISCOUNT.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateDue();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateDue();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateDue();
            }
        });
    }
private void updateDue() {
    try {
        // Get the values from PAYMENT, ADVANCED, and DISCOUNT fields
        double payment = 0.0;
        double advance = 0.0;
        double discountPercentage = 0.0;

        // Check if PAYMENT and ADVANCED are non-empty and valid
        if (!PAYMENT.getText().trim().isEmpty()) {
            payment = Double.parseDouble(PAYMENT.getText().trim());
        }
        if (!ADVANCED.getText().trim().isEmpty()) {
            advance = Double.parseDouble(ADVANCED.getText().trim());
        }
        if (!DISCOUNT.getText().trim().isEmpty()) {
            discountPercentage = Double.parseDouble(DISCOUNT.getText().trim());
        }

        // Calculate the initial due amount (without discount)
        double due = payment - advance;

        // Apply discount if it exists
        if (discountPercentage > 0) {
            // Calculate discount amount
            double discountAmount = (payment * discountPercentage) / 100;
            payment -= discountAmount; // Apply discount to payment
            due = payment - advance;   // Recalculate due after discount
        }

        // Check if advance is greater than the discounted payment
        if (advance > payment) {
            JOptionPane.showMessageDialog(this, "Advance cannot be greater than the payment after discount.");
            DUE.setText("0");
            return;
        }

        // Update the DUE field with the new due amount
        DUE.setText(String.format("%.2f", due));

    } catch (NumberFormatException e) {
        // If there is an invalid number input, reset DUE to 0
        DUE.setText("0");
    }
}




// Method to fet//ch details from the database

private void fetchDetails(String searchValue) {
    try {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connect to the database
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fahim", "root", "12345678");

        // Prepare the SQL query to search by 'NID_NUMBER'
        pst = con.prepareStatement("SELECT * FROM project2 WHERE NID_NUMBER = ?");
        pst.setString(1, searchValue); // Set the search value in the query

        // Execute the query
        rs = pst.executeQuery();

        // If a matching record is found, populate the text fields
        if (rs.next()) {
            // Populate text fields with data from the database
            name_column.setText(rs.getString("NAME"));
            mobile_column.setText(rs.getString("MOBILE"));
            address_column.setText(rs.getString("ADDRESS"));
            nid_number_column.setText(rs.getString("NID_NUMBER"));
            car_name.setText(rs.getString("car_name"));
            available.setText(rs.getString("available"));
        } else {
            // If no record is found, show a message
            JOptionPane.showMessageDialog(this, "No record found");
        }
    } catch (Exception ex) {
        // Print the exception to the console for debugging
        System.out.println(ex);
    } finally {
        // Close resources
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        name_column = new javax.swing.JTextField();
        NAME1 = new javax.swing.JTextField();
        mobile_column = new javax.swing.JTextField();
        address_column = new javax.swing.JTextField();
        nid_number_column = new javax.swing.JTextField();
        BUTTON = new javax.swing.JButton();
        PAYMENT = new javax.swing.JTextField();
        ADVANCED = new javax.swing.JTextField();
        DUE = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        DISCOUNT = new javax.swing.JTextField();
        SUBMIT = new javax.swing.JButton();
        PREVIOUS = new javax.swing.JButton();
        LOGOUT = new javax.swing.JButton();
        information = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        car_name = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        available = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();

        jLabel5.setText("jLabel2");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallpaperflare.com_wallpaper (1).jpg"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallpaperflare.com_wallpaper (1).jpg"))); // NOI18N
        jLabel13.setText("jLabel13");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallpaperflare.com_wallpaper (1).jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 51, 51));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PAYMENT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 6, 280, 70));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MOBILE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 150, 74, 24));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NAME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 108, 74, 24));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ADDRESS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 192, 74, 24));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PAYMENT");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 284, 74, 24));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NID NUMBER");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 234, 74, 24));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DUE");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 368, 74, 24));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ADVANCED");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 326, 74, 24));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("search");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 50, 30));

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 190, 30));

        name_column.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        name_column.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_columnActionPerformed(evt);
            }
        });
        getContentPane().add(name_column, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 210, 30));
        getContentPane().add(NAME1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 210, 30));

        mobile_column.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mobile_column.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobile_columnActionPerformed(evt);
            }
        });
        getContentPane().add(mobile_column, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 210, 30));

        address_column.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        address_column.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address_columnActionPerformed(evt);
            }
        });
        getContentPane().add(address_column, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 210, 30));

        nid_number_column.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nid_number_column.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nid_number_columnActionPerformed(evt);
            }
        });
        getContentPane().add(nid_number_column, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 232, 210, 30));

        BUTTON.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BUTTON.setText("SEARCH");
        BUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTTONActionPerformed(evt);
            }
        });
        getContentPane().add(BUTTON, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, -1, -1));

        PAYMENT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PAYMENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PAYMENTActionPerformed(evt);
            }
        });
        getContentPane().add(PAYMENT, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 210, 30));

        ADVANCED.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ADVANCED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADVANCEDActionPerformed(evt);
            }
        });
        getContentPane().add(ADVANCED, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 210, 30));

        DUE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DUE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DUEActionPerformed(evt);
            }
        });
        getContentPane().add(DUE, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 210, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("DISCOUNT");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        DISCOUNT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DISCOUNT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DISCOUNTActionPerformed(evt);
            }
        });
        getContentPane().add(DISCOUNT, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 210, 40));

        SUBMIT.setBackground(new java.awt.Color(204, 204, 204));
        SUBMIT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SUBMIT.setText("SUBMIT");
        SUBMIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUBMITActionPerformed(evt);
            }
        });
        getContentPane().add(SUBMIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 200, 80));

        PREVIOUS.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PREVIOUS.setText("PREVIOUS");
        PREVIOUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PREVIOUSActionPerformed(evt);
            }
        });
        getContentPane().add(PREVIOUS, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, -1, -1));

        LOGOUT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LOGOUT.setText("LOGOUT");
        LOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGOUTActionPerformed(evt);
            }
        });
        getContentPane().add(LOGOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 480, -1, -1));

        information.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        information.setText("INFORMATION");
        information.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informationActionPerformed(evt);
            }
        });
        getContentPane().add(information, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 480, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("CAR NAME");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        car_name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        car_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                car_nameActionPerformed(evt);
            }
        });
        getContentPane().add(car_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 472, 210, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("AVAILABLE");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, -1, -1));

        available.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        available.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableActionPerformed(evt);
            }
        });
        getContentPane().add(available, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 532, 210, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wallpaperflare.com_wallpaper (1).jpg"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(-530, 0, 1410, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String searchValue = search.getText();
        fetchDetails(searchValue);  // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void name_columnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_columnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_columnActionPerformed

    private void mobile_columnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobile_columnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobile_columnActionPerformed

    private void address_columnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address_columnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address_columnActionPerformed

    private void nid_number_columnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nid_number_columnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nid_number_columnActionPerformed

    private void BUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUTTONActionPerformed
    // Fetch the value from the search input field
    String searchValue = search.getText();
    
    // Check if the search field is empty
    if (searchValue.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a value to search.");
    } else {
        // Call the fetchDetails method to retrieve and display the data
        fetchDetails(searchValue);
    }
    }//GEN-LAST:event_BUTTONActionPerformed

    private void PAYMENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PAYMENTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PAYMENTActionPerformed

    private void ADVANCEDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADVANCEDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADVANCEDActionPerformed

    private void DUEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DUEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DUEActionPerformed

    private void DISCOUNTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DISCOUNTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DISCOUNTActionPerformed

    private void LOGOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGOUTActionPerformed
            // Create and display the login window
    login1 loginPage = new login1();
    loginPage.setVisible(true);

    // Close the current window (FIRST page)
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_LOGOUTActionPerformed

    private void PREVIOUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PREVIOUSActionPerformed
            // Create and display the login window
    FIRST loginPage = new FIRST();
    loginPage.setVisible(true);

    // Close the current window (FIRST page)
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_PREVIOUSActionPerformed

    private void SUBMITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUBMITActionPerformed
// Step 1: Fetch values from input fields
String name = name_column.getText().trim();
String mobile = mobile_column.getText().trim();
String address = address_column.getText().trim();
String nidNumber = nid_number_column.getText().trim();
String payment = PAYMENT.getText().trim();
String advanced = ADVANCED.getText().trim();
String due = DUE.getText().trim();
String discount = DISCOUNT.getText().trim();
String carname = car_name.getText().trim();
String av = available.getText().trim();


// Step 2: Validate inputs
if (name.isEmpty() || mobile.isEmpty() || address.isEmpty() || nidNumber.isEmpty() ||
    payment.isEmpty() || advanced.isEmpty() || due.isEmpty() || discount.isEmpty() || carname.isEmpty() || av.isEmpty()) {
    JOptionPane.showMessageDialog(this, "All fields are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
    return;
}

try {
    // Parse numeric fields to ensure they are valid integers
    int paymentInt = Integer.parseInt(payment);
    int advancedInt = Integer.parseInt(advanced);
    // Parse 'due' as a float instead of an int
    float dueFloat = Float.parseFloat(due);
    int discountInt = Integer.parseInt(discount);

    // Step 3: Establish a database connection
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fahim", "root", "12345678");

    // Step 4: Prepare the SQL insert statement
    String sql = "INSERT INTO information (name_column, mobile_column, address_column, nid_number_column, PAYMENT, ADVANCED, DUE, DISCOUNT,car_name,available) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
    PreparedStatement pst = con.prepareStatement(sql);

    // Step 5: Set parameters in the query
    pst.setString(1, name);
    pst.setString(2, mobile);
    pst.setString(3, address);
    pst.setString(4, nidNumber);
    pst.setInt(5, paymentInt);
    pst.setInt(6, advancedInt);
    // Set 'due' as a float
    pst.setFloat(7, dueFloat);
    pst.setInt(8, discountInt);
    pst.setString(9, carname);
    pst.setString(10, av);
    
    

    // Step 6: Execute the query
    int rowsInserted = pst.executeUpdate();
    if (rowsInserted > 0) {
        JOptionPane.showMessageDialog(this, "Data submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Clear input fields after successful submission
        name_column.setText("");
        mobile_column.setText("");
        address_column.setText("");
        nid_number_column.setText("");
        PAYMENT.setText("");
        ADVANCED.setText("");
        DUE.setText("");
        DISCOUNT.setText("");
        car_name.setText("");
        available.setText("");
    }

    // Step 7: Close the connection
    pst.close();
    con.close();

} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Invalid numeric values entered. Please correct them.", "Input Error", JOptionPane.ERROR_MESSAGE);
} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Error saving data to database: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
}

    
    }//GEN-LAST:event_SUBMITActionPerformed

    private void informationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informationActionPerformed
  table1 firstPage = new table1();
    firstPage.setVisible(true);
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_informationActionPerformed

    private void car_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_car_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_car_nameActionPerformed

    private void availableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_availableActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ADVANCED;
    private javax.swing.JButton BUTTON;
    private javax.swing.JTextField DISCOUNT;
    private javax.swing.JTextField DUE;
    private javax.swing.JButton LOGOUT;
    private javax.swing.JTextField NAME1;
    private javax.swing.JTextField PAYMENT;
    private javax.swing.JButton PREVIOUS;
    private javax.swing.JButton SUBMIT;
    private javax.swing.JTextField address_column;
    private javax.swing.JTextField available;
    private javax.swing.JTextField car_name;
    private javax.swing.JButton information;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField mobile_column;
    private javax.swing.JTextField name_column;
    private javax.swing.JTextField nid_number_column;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables

    private void refreshTable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
