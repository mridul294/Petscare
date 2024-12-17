/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petscare;

import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter; 
import net.proteanit.sql.DbUtils;
import static petscare.Admin.currentAdminID;

/**
 *
 * @author Maryam Tariq
 */
public class ManageSupplies extends javax.swing.JFrame {
    
    Connection con;
    Statement st;
    ResultSet rs;
    String selectedImagePath;

    /**
     * Creates new form ManageSupplies
     */
    public ManageSupplies() {
        initComponents();
        fillTable();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(
            new WindowAdapter()
            {
                @Override
                public void windowClosed(WindowEvent event)
                {
                    closeDB();
                    System.exit(0);
                }
            }
        );
    }
    
    
    public void fillTable()
    {
        try
        {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/PetsCare","root","root");
            st=con.createStatement();
            rs=st.executeQuery("SELECT SuppliesID, Supplies_Name, Price, Quantity, AdminID FROM Supplies");
            
            suppliesTable.setModel(DbUtils.resultSetToTableModel(rs));
            admIDTxt.setText(String.valueOf(currentAdminID));
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(ManageSupplies.this, ex);
        }
    }
    
    public void closeDB()
    {
        try
        {
            rs.close();
            st.close();
            con.close();
        }
        
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(ManageSupplies.this, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        SupIDTxt = new javax.swing.JTextField();
        QuantTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        priceTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        suppliesTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        backLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        admIDTxt = new javax.swing.JTextField();
        imageButton = new javax.swing.JButton();
        imageLable = new javax.swing.JLabel();
        imageLable2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Supplies");
        setMaximumSize(new java.awt.Dimension(900, 550));
        setMinimumSize(new java.awt.Dimension(900, 550));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(78, 95, 200));
        jLabel4.setText("Manage Supplies");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(144, 143, 150));
        jLabel5.setText("Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(144, 143, 150));
        jLabel6.setText("Supplies ID");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(144, 143, 150));
        jLabel7.setText("Price");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(144, 143, 150));
        jLabel8.setText("Quantity");

        SupIDTxt.setEditable(false);
        SupIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupIDTxtActionPerformed(evt);
            }
        });

        priceTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTxtActionPerformed(evt);
            }
        });

        suppliesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Supplies_ID", "Name", "Price", "Quantity"
            }
        ));
        suppliesTable.setRowHeight(20);
        suppliesTable.setSelectionBackground(new java.awt.Color(204, 204, 255));
        suppliesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suppliesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(suppliesTable);

        addButton.setBackground(new java.awt.Color(78, 95, 200));
        addButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setBackground(new java.awt.Color(78, 95, 200));
        removeButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        removeButton.setForeground(new java.awt.Color(255, 255, 255));
        removeButton.setText("REMOVE");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(78, 95, 200));
        editButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("EDIT");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        clearButton.setBackground(new java.awt.Color(78, 95, 200));
        clearButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 27)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(193, 193, 255));
        jLabel15.setText("SUPPLIES LIST");

        backLabel.setForeground(new java.awt.Color(144, 143, 150));
        backLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petscare/Icon/back (1) (1) (1) (1).png"))); // NOI18N
        backLabel.setText(" BACK");
        backLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backLabelMouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(144, 143, 150));
        jLabel16.setText("Admin ID");

        admIDTxt.setEditable(false);
        admIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admIDTxtActionPerformed(evt);
            }
        });

        imageButton.setBackground(new java.awt.Color(78, 95, 200));
        imageButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        imageButton.setForeground(new java.awt.Color(255, 255, 255));
        imageButton.setText("Browse Image");
        imageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageButtonActionPerformed(evt);
            }
        });

        imageLable.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        imageLable.setForeground(new java.awt.Color(144, 143, 150));
        imageLable.setText("Image");

        imageLable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        imageLable2.setForeground(new java.awt.Color(144, 143, 150));
        imageLable2.setText(" No Image Chose");
        imageLable2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(imageLable2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219)
                        .addComponent(removeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(imageLable))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nameTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SupIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(imageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(70, 70, 70)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel16))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(priceTxt)
                                        .addComponent(QuantTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(admIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(88, 88, 88))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(backLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(280, 280, 280))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backLabel)
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(QuantTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(admIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(imageButton)
                                    .addComponent(imageLable))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(SupIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(imageLable2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(editButton)
                    .addComponent(removeButton)
                    .addComponent(clearButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(914, 587));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SupIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupIDTxtActionPerformed

    private void priceTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTxtActionPerformed

    private void suppliesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliesTableMouseClicked
        // TODO add your handling code here:

        try
        {
            int selectRow = suppliesTable.getSelectedRow();
            int SelectID = Integer.parseInt(suppliesTable.getModel().getValueAt(selectRow,0).toString());

            String query = "SELECT * FROM Supplies WHERE SuppliesID = " + SelectID;
            rs = st.executeQuery(query);

            rs.next();
            SupIDTxt.setText(String.format("%d", rs.getInt("SuppliesID")));
            nameTxt.setText(rs.getString("Supplies_Name"));
            priceTxt.setText(String.format("%.2f", rs.getDouble("Price")));
            QuantTxt.setText(String.format("%d", rs.getInt("Quantity")));
            admIDTxt.setText(String.format("%d", currentAdminID));
            
            String path = rs.getString("ImagePath");
            ImageIcon image = new ImageIcon(getClass().getResource("Icon/" + path));
            Image img = image.getImage();
            Image imgImage = img.getScaledInstance(imageLable2.getWidth(),imageLable2.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgImage);
            imageLable2.setIcon(scaledIcon);
            imageLable2.setText(rs.getString("ImagePath"));

        }

        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(ManageSupplies.this, ex);
        }
    }//GEN-LAST:event_suppliesTableMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        
        if(nameTxt.getText().isEmpty() || priceTxt.getText().isEmpty() || QuantTxt.getText().isEmpty() || imageLable2.getIcon() == null)
            JOptionPane.showMessageDialog(this, "Missing Information", "Error", JOptionPane.WARNING_MESSAGE);
        
        else
        {
            try
            {
                if(Integer.parseInt(QuantTxt.getText()) <= 0 || Integer.parseInt(priceTxt.getText()) <= 0)
                {
                    JOptionPane.showMessageDialog(this, "Enter Positive Value", "Quantity or Price Error", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    PreparedStatement insertQuery = con.prepareStatement("INSERT INTO Supplies (Supplies_Name, Price, Quantity, ImagePath ,AdminID)\n" +
                        "VALUES (?, ?, ?, ?, ?)");

                    insertQuery.setString(1, nameTxt.getText());
                    insertQuery.setDouble(2, Double.valueOf(priceTxt.getText()));
                    insertQuery.setInt(3, Integer.valueOf(QuantTxt.getText()));
                    insertQuery.setString(4, imageLable2.getText());
                    insertQuery.setInt(5, Integer.valueOf(admIDTxt.getText()));

                    int result = insertQuery.executeUpdate();
                    if(result == 1)
                    JOptionPane.showMessageDialog(ManageSupplies.this, "Supplies: " + nameTxt.getText()  + " is Addedd");

                    closeDB();
                    fillTable();
                }
            }

            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            }

            catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(this, "You Enter Wrong Entery Type", "Error", JOptionPane.WARNING_MESSAGE);
                }

            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(ManageSupplies.this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:

        try
        {
            int confirm = JOptionPane.showConfirmDialog(ManageSupplies.this, "You Want to Delete Selected Recored?", "Delete Recored", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION)
            {
                String DeleteQuery = "DELETE FROM Supplies WHERE SuppliesID = " + SupIDTxt.getText();
                int result = st.executeUpdate(DeleteQuery);
                if(result == 1)
                JOptionPane.showMessageDialog(ManageSupplies.this, "Selected Recored is Deleted");

                SupIDTxt.setText("");
                nameTxt.setText("");
                QuantTxt.setText("");
                priceTxt.setText("");
                imageLable2.setIcon(null);
                imageLable2.setText(" No Image Chose");
                admIDTxt.setText(String.valueOf(currentAdminID));

                closeDB();
                fillTable();
            }
        }

        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(ManageSupplies.this, ex.getMessage());
        }

        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(ManageSupplies.this, ex.getMessage());
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        
        if(nameTxt.getText().isEmpty() || priceTxt.getText().isEmpty() || QuantTxt.getText().isEmpty() || admIDTxt.getText().isEmpty() || imageLable2.getIcon() == null)
            JOptionPane.showMessageDialog(this, "Missing Information", "Error", JOptionPane.WARNING_MESSAGE);
        else
        {
            try
            {
                if(Integer.parseInt(QuantTxt.getText()) <= 0 || Integer.parseInt(priceTxt.getText()) <= 0)
                {
                    JOptionPane.showMessageDialog(this, "Enter Positive Value", "Quantity or Price Error", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    PreparedStatement updateQuery = con.prepareStatement("UPDATE Supplies SET Supplies_Name = ?, Price = ?, Quantity = ?, ImagePath = ? ,AdminID = ? WHERE SuppliesID = ?");

                    updateQuery.setString(1, nameTxt.getText());
                    updateQuery.setDouble(2, Double.valueOf(priceTxt.getText()));
                    updateQuery.setInt(3, Integer.valueOf(QuantTxt.getText()));
                    updateQuery.setString(4, imageLable2.getText());
                    updateQuery.setInt(5, Integer.valueOf(admIDTxt.getText()));
                    updateQuery.setInt(6, Integer.valueOf(SupIDTxt.getText()));

                    int result = updateQuery.executeUpdate();
                    if(result == 1)
                    JOptionPane.showMessageDialog(ManageSupplies.this, "Selected Recored is Updated");
                    else
                    JOptionPane.showMessageDialog(ManageSupplies.this, "Failed: Selected Recored is not Updated");

                    closeDB();
                    fillTable();
                }
            }

            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(ManageSupplies.this, ex.getMessage());
            }
            
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this, "You Enter Wrong Entery Type", "Error", JOptionPane.WARNING_MESSAGE);
            }

            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(ManageSupplies.this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:

        SupIDTxt.setText("");
        nameTxt.setText("");
        QuantTxt.setText("");
        priceTxt.setText("");
        imageLable2.setIcon(null);
        imageLable2.setText(" No Image Chose");
        admIDTxt.setText(String.valueOf(currentAdminID));
    }//GEN-LAST:event_clearButtonActionPerformed

    private void backLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLabelMouseClicked
        // TODO add your handling code here:

        this.setVisible(false);
        Admin admin = new Admin();
        admin.setVisible(true);
    }//GEN-LAST:event_backLabelMouseClicked

    private void admIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_admIDTxtActionPerformed

    private void imageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser imageChooser = new JFileChooser("C:\\Users\\Mzts5\\Downloads\\PetsCare\\src\\petscare\\Icon");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files (*.PNG,*.JPG, *.JPEG)", "PNG","JPG", "JPEG");
        imageChooser.setFileFilter(filter);

        int result = imageChooser.showOpenDialog(this);

        if(result == JFileChooser.APPROVE_OPTION)
        {
            File imageFile = imageChooser.getSelectedFile();
            selectedImagePath = imageFile.getName();

            ImageIcon image = new ImageIcon(getClass().getResource("Icon/" + selectedImagePath));
            Image img = image.getImage();
            Image imgImage = img.getScaledInstance(imageLable2.getWidth(),imageLable2.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgImage);
            imageLable2.setIcon(scaledIcon);
            imageLable2.setText(selectedImagePath);
        }
    }//GEN-LAST:event_imageButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ManageSupplies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageSupplies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageSupplies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageSupplies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageSupplies().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField QuantTxt;
    private javax.swing.JTextField SupIDTxt;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField admIDTxt;
    private javax.swing.JLabel backLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton imageButton;
    private javax.swing.JLabel imageLable;
    private javax.swing.JLabel imageLable2;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JButton removeButton;
    private javax.swing.JTable suppliesTable;
    // End of variables declaration//GEN-END:variables
}
