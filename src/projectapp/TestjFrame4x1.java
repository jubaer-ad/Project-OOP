/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jubae
 */
public class TestjFrame4x1 extends javax.swing.JFrame {
    
    Connection con;
    ResultSet RS=null;
    PreparedStatement PST=null;

    public TestjFrame4x1() {
        initComponents();
        
        show_student_info_in_jTable();
        show_attendance_info_student_in_jTable();
        
    }
    String Serial;
    String LName;
    String Username;
    String Password;

    public Connection createconnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projectdb", "root", "");
            return con;
            
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }
    
    public ArrayList<student_info> getStudent_InfoList()
     {
       ArrayList<student_info> student_infoList = new ArrayList<student_info>();
       Connection conn = createconnection();
       String query = "SELECT * FROM  `studentinfo` ";
       Statement st;
       ResultSet rs;
       try {
           st = conn.createStatement();
           rs = st.executeQuery(query);

           student_info stu_info;

           while(rs.next())
           {
               stu_info = new student_info(rs.getInt("Serial"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("ID"), rs.getString("username"), rs.getString("password"), rs.getString("Email"), rs.getString("Address"), rs.getString("Mobile No."));
               student_infoList.add(stu_info);
               
           }
           return student_infoList;
       } 
      catch (SQLException e) {
           e.printStackTrace();
       }
       return null;
     }
     
     
    public ArrayList<attendance_info> getAttendance_InfoList()
   {
       ArrayList<attendance_info> attendance_infoList = new ArrayList<attendance_info>();
       Connection conn = createconnection();
       
       String query = "SELECT * FROM  `attendanceinfo` ";
       Statement st;
       ResultSet rs;
       
       try {
           st = conn.createStatement();
           rs = st.executeQuery(query);

           attendance_info att_info;

           while(rs.next())
           {
               att_info = new attendance_info(rs.getInt("Serial"), rs.getString("Name"), rs.getString("username"), rs.getString("password"), rs.getInt("d1"), rs.getInt("d2"), rs.getInt("d3"), rs.getInt("d4"), rs.getInt("d5"), rs.getInt("d6"), rs.getInt("d7"), rs.getInt("d8"), rs.getInt("d9"), rs.getInt("d10"), rs.getInt("d11"), rs.getInt("d12"), rs.getInt("d13"), rs.getInt("d14"), rs.getInt("d15"), rs.getInt("d16"), rs.getInt("d17"), rs.getInt("d18"), rs.getInt("d19"), rs.getInt("d20"), rs.getInt("d21"), rs.getInt("d22"), rs.getInt("d23"), rs.getInt("d24"), rs.getInt("d25"), rs.getInt("d26"), rs.getInt("d27"), rs.getInt("d28"), rs.getInt("d29"), rs.getInt("d30"), rs.getInt("d31"));
               attendance_infoList.add(att_info);
               
           }
           return attendance_infoList;
       } 
      catch (SQLException e) {
           e.printStackTrace();
       }
       return null;
   }
     
     //display data in jtable
     
    public void show_student_info_in_jTable() {
         ArrayList<student_info> list = getStudent_InfoList();
         DefaultTableModel model = (DefaultTableModel)jTable_view_student_info_admin.getModel();
         Object[] row = new Object[9];
         for(int i=0;i<list.size();i++) {
             row[0] = list.get(i).getIndex();
             row[1] = list.get(i).getFname();
             row[2] = list.get(i).getLname();
             row[3] = list.get(i).getId();
             row[4] = list.get(i).getUsername();
             row[5] = list.get(i).getPassword();
             row[6] = list.get(i).getEmail();
             row[7] = list.get(i).getAddress();
             row[8] = list.get(i).getMobile_no();
             model.addRow(row);
         }
     }
     
     
     public void show_attendance_info_in_jTable() {
         ArrayList<attendance_info> list = getAttendance_InfoList();
         DefaultTableModel model = (DefaultTableModel)jTable_attendance_student_admin.getModel();
         Object[] row = new Object[35];
         for(int i=0;i<list.size();i++) {
             row[0] = list.get(i).getIndex();
             row[1] = list.get(i).getName();
             row[2] = list.get(i).getUsername();
             row[3] = list.get(i).getPassword();
             row[4] = list.get(i).getd01();
             row[5] = list.get(i).getd02();
             row[6] = list.get(i).getd03();
             row[7] = list.get(i).getd04();
             row[8] = list.get(i).getd05();
             row[9] = list.get(i).getd06();
             row[10] = list.get(i).getd07();
             row[11] = list.get(i).getd08();
             row[12] = list.get(i).getd09();
             row[13] = list.get(i).getd10();
             row[14] = list.get(i).getd11();
             row[15] = list.get(i).getd12();
             row[16] = list.get(i).getd13();
             row[17] = list.get(i).getd14();
             row[18] = list.get(i).getd15();
             row[19] = list.get(i).getd16();
             row[20] = list.get(i).getd17();
             row[21] = list.get(i).getd18();
             row[22] = list.get(i).getd19();
             row[23] = list.get(i).getd20();
             row[24] = list.get(i).getd21();
             row[25] = list.get(i).getd22();
             row[26] = list.get(i).getd23();
             row[27] = list.get(i).getd24();
             row[28] = list.get(i).getd25();
             row[29] = list.get(i).getd26();
             row[30] = list.get(i).getd27();
             row[31] = list.get(i).getd28();
             row[32] = list.get(i).getd29();
             row[33] = list.get(i).getd30();
             row[34] = list.get(i).getd31();
             
             model.addRow(row);
         }
     }
     
     
     public void show_attendance_info_student_in_jTable() {
         ArrayList<attendance_info> list = getAttendance_InfoList();
         DefaultTableModel model = (DefaultTableModel)jTable_attendance_student_student.getModel();
         Object[] row = new Object[35];
         for(int i=0;i<list.size();i++) {
             row[0] = list.get(i).getIndex();
             row[1] = list.get(i).getName();
             row[2] = list.get(i).getUsername();
             row[3] = list.get(i).getPassword();
             row[4] = list.get(i).getd01();
             row[5] = list.get(i).getd02();
             row[6] = list.get(i).getd03();
             row[7] = list.get(i).getd04();
             row[8] = list.get(i).getd05();
             row[9] = list.get(i).getd06();
             row[10] = list.get(i).getd07();
             row[11] = list.get(i).getd08();
             row[12] = list.get(i).getd09();
             row[13] = list.get(i).getd10();
             row[14] = list.get(i).getd11();
             row[15] = list.get(i).getd12();
             row[16] = list.get(i).getd13();
             row[17] = list.get(i).getd14();
             row[18] = list.get(i).getd15();
             row[19] = list.get(i).getd16();
             row[20] = list.get(i).getd17();
             row[21] = list.get(i).getd18();
             row[22] = list.get(i).getd19();
             row[23] = list.get(i).getd20();
             row[24] = list.get(i).getd21();
             row[25] = list.get(i).getd22();
             row[26] = list.get(i).getd23();
             row[27] = list.get(i).getd24();
             row[28] = list.get(i).getd25();
             row[29] = list.get(i).getd26();
             row[30] = list.get(i).getd27();
             row[31] = list.get(i).getd28();
             row[32] = list.get(i).getd29();
             row[33] = list.get(i).getd30();
             row[34] = list.get(i).getd31();
             
             model.addRow(row);
         }
     }
     
     
      public void executeSQlQuery(String query, String message)
   {
       Connection con = createconnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query)) == 1)
           {
               // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)jTable_view_student_info_admin.getModel();
               model.setRowCount(0);
               show_student_info_in_jTable();
               
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+message);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
      
      
      public void executeSQlQuery1(String query1, String message)
   {
       Connection con = createconnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query1)) == 1)
           {
               // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)jTable_attendance_student_admin.getModel();
               model.setRowCount(0);
               show_attendance_info_in_jTable();
               
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+message);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
      
      public void executeSQlQuery2(String query2, String message)
   {
       Connection con = createconnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query2)) == 1)
           {
               // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)jTable_attendance_student_student.getModel();
               model.setRowCount(0);
               show_attendance_info_student_in_jTable();
               
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+message);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
     
     
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parent_panel = new javax.swing.JPanel();
        jPanel_Highlight = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton_signin_opt_student = new javax.swing.JButton();
        jButton_signin_opt_admin = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jPanel_signin_student = new javax.swing.JPanel();
        jLabel_password_student = new javax.swing.JLabel();
        jLabel_name_student = new javax.swing.JLabel();
        jTextField_name_student = new javax.swing.JTextField();
        jPasswordField_student = new javax.swing.JPasswordField();
        jButton_signin_student = new javax.swing.JButton();
        jCheckBox_password_student = new javax.swing.JCheckBox();
        jButton_homepage_from_student = new javax.swing.JButton();
        jButton_sign_in_reset_student = new javax.swing.JButton();
        jPanel_signin_admin = new javax.swing.JPanel();
        jLabel_password_admin = new javax.swing.JLabel();
        jLabel_name_admin1 = new javax.swing.JLabel();
        jTextField_name_admin = new javax.swing.JTextField();
        jPasswordField_admin = new javax.swing.JPasswordField();
        jButton_signin_admin = new javax.swing.JButton();
        jCheckBox_password_admin = new javax.swing.JCheckBox();
        jButton_homepage_from_admin = new javax.swing.JButton();
        jButton_sign_in_reset_admin = new javax.swing.JButton();
        jPanel_main_opt_student = new javax.swing.JPanel();
        jPanel_main_opt_parent_panel_student = new javax.swing.JPanel();
        jPanel_attendace_student = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_attendance_student_student = new javax.swing.JTable();
        jLabel79 = new javax.swing.JLabel();
        jTextField_attendance_name_student = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jTextField_attendance_username_student = new javax.swing.JTextField();
        jButton_back_attendance_student = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        jTextField_serial_attendance_serial = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jButton_stu_info_update_student = new javax.swing.JButton();
        jPasswordField_edit_pass_student = new javax.swing.JPasswordField();
        jPanel_main_opt_admin = new javax.swing.JPanel();
        jPanel_main_opt_parent_panel_admin = new javax.swing.JPanel();
        jPanel_main_opt_new_student_signup_admin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_new_student_first_name_admin = new javax.swing.JTextField();
        jTextField_new_student_last_name_admin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_new_student_id_admin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_new_student_username_admin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_new_student_email_admin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_new_student_address_admin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField_new_student_mobile_no_admin = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton_new_student_sign_up_admin = new javax.swing.JButton();
        jButton_new_student_sign_up_refresh_admin = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPasswordField_new_student_password_admin = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jTextField_new_student_serial_admin = new javax.swing.JTextField();
        jButton_sign_in_new_student_info_back_admin2 = new javax.swing.JButton();
        jButton_delete_student_info_admin = new javax.swing.JButton();
        jButton_update_student_info_admin = new javax.swing.JButton();
        jButton_attendance_entry_admin = new javax.swing.JButton();
        jTextField_initial_attendance_num_admin = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_view_student_info_admin = new javax.swing.JTable();
        jPanel_attendace_admin = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField_d01 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField_d02 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField_d03 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField_d04 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField_d05 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField_d06 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextFiel_d07 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField_d08 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField_d09 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextField_d10 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField_d11 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTextField_d12 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextField_d13 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField_d14 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextField_d15 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField_d16 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextField_d17 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jTextField_d18 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField_d19 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTextField_d20 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField_d21 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTextField_d22 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jTextField_d23 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jTextField_d24 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextField_d25 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextField_d26 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextField_d27 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jTextField_d28 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jTextField_d29 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jTextField_d30 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jTextField_d31 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_attendance_student_admin = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jTextField_attendance_name_admin = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField_attendance_username_admin1 = new javax.swing.JTextField();
        jButton_update_attendance_admin = new javax.swing.JButton();
        jButton_back_attendance_admin = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextField_serial_attendance_admin = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField_password_attendance_admin = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        parent_panel.setLayout(new java.awt.CardLayout());

        jPanel_Highlight.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Signin As");
        jPanel_Highlight.add(jLabel1);
        jLabel1.setBounds(221, 11, 269, 42);

        jButton_signin_opt_student.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_signin_opt_student.setText("Student");
        jButton_signin_opt_student.setToolTipText("Click to Sign In as Student");
        jButton_signin_opt_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_signin_opt_studentActionPerformed(evt);
            }
        });
        jPanel_Highlight.add(jButton_signin_opt_student);
        jButton_signin_opt_student.setBounds(590, 60, 120, 59);

        jButton_signin_opt_admin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_signin_opt_admin.setText("Admin");
        jButton_signin_opt_admin.setToolTipText("Click to Sign In as Admin");
        jButton_signin_opt_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_signin_opt_adminActionPerformed(evt);
            }
        });
        jPanel_Highlight.add(jButton_signin_opt_admin);
        jButton_signin_opt_admin.setBounds(590, 130, 120, 60);
        jPanel_Highlight.add(jLabel48);
        jLabel48.setBounds(0, 0, 150, 120);

        parent_panel.add(jPanel_Highlight, "card5");

        jPanel_signin_student.setBackground(new java.awt.Color(102, 255, 0));

        jLabel_password_student.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_password_student.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_password_student.setText("Pasword");

        jLabel_name_student.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_name_student.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_name_student.setText("Username");

        jTextField_name_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_name_studentActionPerformed(evt);
            }
        });

        jButton_signin_student.setText("SignIn");
        jButton_signin_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_signin_studentActionPerformed(evt);
            }
        });

        jCheckBox_password_student.setText("Show Password");
        jCheckBox_password_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_password_studentActionPerformed(evt);
            }
        });

        jButton_homepage_from_student.setText("Home Page");
        jButton_homepage_from_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_homepage_from_studentActionPerformed(evt);
            }
        });

        jButton_sign_in_reset_student.setText("Reset");
        jButton_sign_in_reset_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sign_in_reset_studentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_signin_studentLayout = new javax.swing.GroupLayout(jPanel_signin_student);
        jPanel_signin_student.setLayout(jPanel_signin_studentLayout);
        jPanel_signin_studentLayout.setHorizontalGroup(
            jPanel_signin_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_signin_studentLayout.createSequentialGroup()
                .addGroup(jPanel_signin_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_signin_studentLayout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jButton_signin_student, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel_signin_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_signin_studentLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(jButton_homepage_from_student)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_signin_studentLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_sign_in_reset_student))))
                    .addGroup(jPanel_signin_studentLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanel_signin_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_password_student, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_name_student, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_signin_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordField_student)
                            .addComponent(jTextField_name_student, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(jCheckBox_password_student)
                .addGap(38, 38, 38))
        );
        jPanel_signin_studentLayout.setVerticalGroup(
            jPanel_signin_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_signin_studentLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel_signin_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_name_student, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_name_student, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel_signin_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_signin_studentLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_signin_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordField_student, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_password_student, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_signin_studentLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jCheckBox_password_student)))
                .addGroup(jPanel_signin_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_signin_studentLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton_signin_student, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(252, Short.MAX_VALUE))
                    .addGroup(jPanel_signin_studentLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton_sign_in_reset_student)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_homepage_from_student, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
        );

        parent_panel.add(jPanel_signin_student, "card2");

        jPanel_signin_admin.setBackground(new java.awt.Color(51, 204, 255));

        jLabel_password_admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_password_admin.setText("Pasword");

        jLabel_name_admin1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_name_admin1.setText("Admin Name");

        jTextField_name_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_name_adminActionPerformed(evt);
            }
        });

        jButton_signin_admin.setText("SignIn");
        jButton_signin_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_signin_adminActionPerformed(evt);
            }
        });

        jCheckBox_password_admin.setText("Show Password");
        jCheckBox_password_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_password_adminActionPerformed(evt);
            }
        });

        jButton_homepage_from_admin.setText("Home Page");
        jButton_homepage_from_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_homepage_from_adminActionPerformed(evt);
            }
        });

        jButton_sign_in_reset_admin.setText("Reset");
        jButton_sign_in_reset_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sign_in_reset_adminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_signin_adminLayout = new javax.swing.GroupLayout(jPanel_signin_admin);
        jPanel_signin_admin.setLayout(jPanel_signin_adminLayout);
        jPanel_signin_adminLayout.setHorizontalGroup(
            jPanel_signin_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_signin_adminLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel_signin_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_password_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_name_admin1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel_signin_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_signin_adminLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jButton_signin_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 325, Short.MAX_VALUE)
                        .addComponent(jButton_homepage_from_admin)
                        .addGap(113, 113, 113))
                    .addGroup(jPanel_signin_adminLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_signin_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton_sign_in_reset_admin)
                            .addGroup(jPanel_signin_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPasswordField_admin, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                                .addComponent(jTextField_name_admin)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox_password_admin)
                        .addGap(36, 36, 36))))
        );
        jPanel_signin_adminLayout.setVerticalGroup(
            jPanel_signin_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_signin_adminLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel_signin_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_name_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_name_admin1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_signin_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_password_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_password_admin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_sign_in_reset_admin)
                .addGap(5, 5, 5)
                .addGroup(jPanel_signin_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_signin_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_homepage_from_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(252, Short.MAX_VALUE))
        );

        parent_panel.add(jPanel_signin_admin, "card2");

        jPanel_main_opt_student.setLayout(new java.awt.BorderLayout());

        jPanel_main_opt_parent_panel_student.setLayout(new java.awt.CardLayout());

        jTable_attendance_student_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial", "Name", "Username", "Password", "D01", "D02", "D03", "D04", "D05", "D06", "D07", "D08", "D09", "D10", "D11", "D12", "D13", "D14", "D15", "D16", "D17", "D18", "D19", "D20", "D21", "D22", "D23", "D24", "D25", "D26", "D27", "D28", "D29", "D30", "D31"
            }
        ));
        jTable_attendance_student_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_attendance_student_studentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_attendance_student_student);

        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("Name");

        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("Username(Editable)");

        jButton_back_attendance_student.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_back_attendance_student.setText("Log-Out");
        jButton_back_attendance_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_back_attendance_studentActionPerformed(evt);
            }
        });

        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("Serial");

        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("Password(Editable)");

        jButton_stu_info_update_student.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_stu_info_update_student.setText("Update");
        jButton_stu_info_update_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_stu_info_update_studentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_attendace_studentLayout = new javax.swing.GroupLayout(jPanel_attendace_student);
        jPanel_attendace_student.setLayout(jPanel_attendace_studentLayout);
        jPanel_attendace_studentLayout.setHorizontalGroup(
            jPanel_attendace_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_attendace_studentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_attendace_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
                    .addGroup(jPanel_attendace_studentLayout.createSequentialGroup()
                        .addGroup(jPanel_attendace_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel_attendace_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_attendace_studentLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jTextField_attendance_name_student, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_attendace_studentLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel_attendace_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_serial_attendance_serial, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(jTextField_attendance_username_student, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(jPasswordField_edit_pass_student))))
                        .addGroup(jPanel_attendace_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_attendace_studentLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_back_attendance_student, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jPanel_attendace_studentLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jButton_stu_info_update_student, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel_attendace_studentLayout.setVerticalGroup(
            jPanel_attendace_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_attendace_studentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_attendace_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_attendace_studentLayout.createSequentialGroup()
                        .addGroup(jPanel_attendace_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_attendance_name_student, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel_attendace_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_attendance_username_student, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton_back_attendance_student, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_attendace_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_attendace_studentLayout.createSequentialGroup()
                        .addGroup(jPanel_attendace_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_serial_attendance_serial, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_attendace_studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel82)
                            .addComponent(jPasswordField_edit_pass_student, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton_stu_info_update_student, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel_main_opt_parent_panel_student.add(jPanel_attendace_student, "card7");

        jPanel_main_opt_student.add(jPanel_main_opt_parent_panel_student, java.awt.BorderLayout.CENTER);

        parent_panel.add(jPanel_main_opt_student, "card5");

        jPanel_main_opt_admin.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("First Name");

        jLabel3.setText("Lirst Name");

        jLabel4.setText("ID");

        jLabel5.setText("Username");

        jLabel6.setText("Password");

        jLabel7.setText("Email");

        jLabel8.setText("Address");

        jLabel9.setText("Mobile No.");

        jButton_new_student_sign_up_admin.setText("Sign Up");
        jButton_new_student_sign_up_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_new_student_sign_up_adminActionPerformed(evt);
            }
        });

        jButton_new_student_sign_up_refresh_admin.setText("Reset");
        jButton_new_student_sign_up_refresh_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_new_student_sign_up_refresh_adminActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Admin Actions");

        jLabel12.setText("Serial");

        jButton_sign_in_new_student_info_back_admin2.setText("Log-Out");
        jButton_sign_in_new_student_info_back_admin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sign_in_new_student_info_back_admin2ActionPerformed(evt);
            }
        });

        jButton_delete_student_info_admin.setText("Delete");
        jButton_delete_student_info_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_delete_student_info_adminActionPerformed(evt);
            }
        });

        jButton_update_student_info_admin.setText("Update");
        jButton_update_student_info_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_update_student_info_adminActionPerformed(evt);
            }
        });

        jButton_attendance_entry_admin.setText("Attendance");
        jButton_attendance_entry_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_attendance_entry_adminActionPerformed(evt);
            }
        });

        jTextField_initial_attendance_num_admin.setText("0");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Initial no. for Attendance");

        javax.swing.GroupLayout jPanel_main_opt_new_student_signup_adminLayout = new javax.swing.GroupLayout(jPanel_main_opt_new_student_signup_admin);
        jPanel_main_opt_new_student_signup_admin.setLayout(jPanel_main_opt_new_student_signup_adminLayout);
        jPanel_main_opt_new_student_signup_adminLayout.setHorizontalGroup(
            jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createSequentialGroup()
                .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_new_student_serial_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jButton_sign_in_new_student_info_back_admin2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createSequentialGroup()
                        .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_new_student_first_name_admin, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(jTextField_new_student_last_name_admin)
                            .addComponent(jTextField_new_student_id_admin)
                            .addComponent(jTextField_new_student_username_admin)
                            .addComponent(jPasswordField_new_student_password_admin)
                            .addComponent(jTextField_initial_attendance_num_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField_new_student_mobile_no_admin))
                                    .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField_new_student_email_admin))
                                    .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField_new_student_address_admin))))
                            .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createSequentialGroup()
                                        .addComponent(jButton_attendance_entry_admin)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createSequentialGroup()
                                        .addComponent(jButton_new_student_sign_up_refresh_admin)
                                        .addGap(34, 34, 34)
                                        .addComponent(jButton_delete_student_info_admin)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton_update_student_info_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton_new_student_sign_up_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)))))))
                .addGap(122, 122, 122))
        );
        jPanel_main_opt_new_student_signup_adminLayout.setVerticalGroup(
            jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_sign_in_new_student_info_back_admin2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jTextField_new_student_serial_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_new_student_first_name_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_new_student_email_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_new_student_last_name_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_new_student_address_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_new_student_id_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_new_student_mobile_no_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_new_student_username_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jPasswordField_new_student_password_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_new_student_sign_up_refresh_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_new_student_sign_up_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_update_student_info_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_delete_student_info_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel_main_opt_new_student_signup_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_attendance_entry_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_initial_attendance_num_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable_view_student_info_admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Index", "First Name", "Last Name", "ID", "Username", "Password", "Email", "Address", "Mobile No."
            }
        ));
        jTable_view_student_info_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_view_student_info_adminMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_view_student_info_admin);

        javax.swing.GroupLayout jPanel_main_opt_parent_panel_adminLayout = new javax.swing.GroupLayout(jPanel_main_opt_parent_panel_admin);
        jPanel_main_opt_parent_panel_admin.setLayout(jPanel_main_opt_parent_panel_adminLayout);
        jPanel_main_opt_parent_panel_adminLayout.setHorizontalGroup(
            jPanel_main_opt_parent_panel_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_main_opt_parent_panel_adminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel_main_opt_new_student_signup_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel_main_opt_parent_panel_adminLayout.setVerticalGroup(
            jPanel_main_opt_parent_panel_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_main_opt_parent_panel_adminLayout.createSequentialGroup()
                .addComponent(jPanel_main_opt_new_student_signup_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
        );

        jPanel_main_opt_admin.add(jPanel_main_opt_parent_panel_admin, java.awt.BorderLayout.CENTER);

        parent_panel.add(jPanel_main_opt_admin, "card6");

        jLabel17.setText("D01");

        jTextField_d01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d01ActionPerformed(evt);
            }
        });

        jLabel18.setText("D02");

        jTextField_d02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d02ActionPerformed(evt);
            }
        });

        jLabel19.setText("D03");

        jTextField_d03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d03ActionPerformed(evt);
            }
        });

        jLabel20.setText("D04");

        jTextField_d04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d04ActionPerformed(evt);
            }
        });

        jLabel21.setText("D05");

        jTextField_d05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d05ActionPerformed(evt);
            }
        });

        jLabel22.setText("D06");

        jTextField_d06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d06ActionPerformed(evt);
            }
        });

        jLabel23.setText("D07");

        jTextFiel_d07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFiel_d07ActionPerformed(evt);
            }
        });

        jLabel24.setText("D08");

        jTextField_d08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d08ActionPerformed(evt);
            }
        });

        jLabel25.setText("D09");

        jTextField_d09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d09ActionPerformed(evt);
            }
        });

        jLabel26.setText("D10");

        jTextField_d10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d10ActionPerformed(evt);
            }
        });

        jLabel27.setText("D11");

        jTextField_d11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d11ActionPerformed(evt);
            }
        });

        jLabel28.setText("D12");

        jTextField_d12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d12ActionPerformed(evt);
            }
        });

        jLabel29.setText("D13");

        jTextField_d13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d13ActionPerformed(evt);
            }
        });

        jLabel30.setText("D14");

        jTextField_d14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d14ActionPerformed(evt);
            }
        });

        jLabel31.setText("D15");

        jTextField_d15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d15ActionPerformed(evt);
            }
        });

        jLabel32.setText("D16");

        jTextField_d16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d16ActionPerformed(evt);
            }
        });

        jLabel33.setText("D17");

        jTextField_d17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d17ActionPerformed(evt);
            }
        });

        jLabel34.setText("D18");

        jTextField_d18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d18ActionPerformed(evt);
            }
        });

        jLabel35.setText("D19");

        jTextField_d19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d19ActionPerformed(evt);
            }
        });

        jLabel36.setText("D20");

        jTextField_d20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d20ActionPerformed(evt);
            }
        });

        jLabel37.setText("D21");

        jTextField_d21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d21ActionPerformed(evt);
            }
        });

        jLabel38.setText("D22");

        jTextField_d22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d22ActionPerformed(evt);
            }
        });

        jLabel39.setText("D23");

        jTextField_d23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d23ActionPerformed(evt);
            }
        });

        jLabel40.setText("D24");

        jTextField_d24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d24ActionPerformed(evt);
            }
        });

        jLabel41.setText("D25");

        jTextField_d25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d25ActionPerformed(evt);
            }
        });

        jLabel42.setText("D26");

        jTextField_d26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d26ActionPerformed(evt);
            }
        });

        jLabel43.setText("D27");

        jTextField_d27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d27ActionPerformed(evt);
            }
        });

        jLabel44.setText("D28");

        jTextField_d28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d28ActionPerformed(evt);
            }
        });

        jLabel45.setText("D29");

        jTextField_d29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d29ActionPerformed(evt);
            }
        });

        jLabel46.setText("D30");

        jTextField_d30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d30ActionPerformed(evt);
            }
        });

        jLabel47.setText("D31");

        jTextField_d31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_d31ActionPerformed(evt);
            }
        });

        jTable_attendance_student_admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial", "Name", "Username", "Password", "D01", "D02", "D03", "D04", "D05", "D06", "D07", "D08", "D09", "D10", "D11", "D12", "D13", "D14", "D15", "D16", "D17", "D18", "D19", "D20", "D21", "D22", "D23", "D24", "D25", "D26", "D27", "D28", "D29", "D30", "D31"
            }
        ));
        jTable_attendance_student_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_attendance_student_adminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_attendance_student_admin);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Name");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Username");

        jButton_update_attendance_admin.setText("Update");
        jButton_update_attendance_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_update_attendance_adminActionPerformed(evt);
            }
        });

        jButton_back_attendance_admin.setText("Back");
        jButton_back_attendance_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_back_attendance_adminActionPerformed(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Serial");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Password");

        javax.swing.GroupLayout jPanel_attendace_adminLayout = new javax.swing.GroupLayout(jPanel_attendace_admin);
        jPanel_attendace_admin.setLayout(jPanel_attendace_adminLayout);
        jPanel_attendace_adminLayout.setHorizontalGroup(
            jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_attendace_adminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel_attendace_adminLayout.createSequentialGroup()
                        .addGroup(jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_attendace_adminLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d01, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d06, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d26, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d31, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_attendace_adminLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d02, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFiel_d07, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d22, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d27, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_attendace_adminLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d03, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d08, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d23, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d28, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_attendace_adminLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d04, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d09, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d24, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d29, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_attendace_adminLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d05, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d25, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_d30, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_attendace_adminLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jTextField_attendance_name_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_attendace_adminLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_password_attendance_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_serial_attendance_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_attendance_username_admin1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_update_attendance_admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_back_attendance_admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(214, Short.MAX_VALUE))))
        );
        jPanel_attendace_adminLayout.setVerticalGroup(
            jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_attendace_adminLayout.createSequentialGroup()
                .addGroup(jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_attendace_adminLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jTextField_d04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(jTextField_d09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addComponent(jTextField_d14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)
                            .addComponent(jTextField_d19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40)
                            .addComponent(jTextField_d24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45)
                            .addComponent(jTextField_d29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jTextField_d05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(jTextField_d10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)
                            .addComponent(jTextField_d15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36)
                            .addComponent(jTextField_d20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41)
                            .addComponent(jTextField_d25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46)
                            .addComponent(jTextField_d30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_attendace_adminLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jTextField_d01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(jTextField_d06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(jTextField_d11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)
                            .addComponent(jTextField_d16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)
                            .addComponent(jTextField_d21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42)
                            .addComponent(jTextField_d26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47)
                            .addComponent(jTextField_d31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_attendance_name_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_back_attendance_admin))
                        .addGroup(jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_attendace_adminLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18)
                                        .addComponent(jTextField_d02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel23)
                                        .addComponent(jTextFiel_d07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel28)
                                        .addComponent(jTextField_d12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel33)
                                        .addComponent(jTextField_d17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel38)
                                        .addComponent(jTextField_d22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel43)
                                        .addComponent(jTextField_d27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton_update_attendance_admin))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(jTextField_d03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24)
                                    .addComponent(jTextField_d08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29)
                                    .addComponent(jTextField_d13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34)
                                    .addComponent(jTextField_d18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39)
                                    .addComponent(jTextField_d23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel44)
                                    .addComponent(jTextField_d28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel_attendace_adminLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_attendance_username_admin1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_serial_attendance_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_attendace_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_password_attendance_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        parent_panel.add(jPanel_attendace_admin, "card7");

        getContentPane().add(parent_panel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_name_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_name_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_name_adminActionPerformed

    private void jTextField_name_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_name_studentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_name_studentActionPerformed

    private void jCheckBox_password_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_password_studentActionPerformed
        if(jCheckBox_password_student.isSelected()){
            jPasswordField_student.setEchoChar((char)0);
        }else{
            jPasswordField_student.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox_password_studentActionPerformed

    private void jCheckBox_password_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_password_adminActionPerformed
if(jCheckBox_password_admin.isSelected()){
            jPasswordField_admin.setEchoChar((char)0);
        }else{
            jPasswordField_admin.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox_password_adminActionPerformed

    private void jButton_signin_opt_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_signin_opt_adminActionPerformed
        parent_panel.removeAll();
        parent_panel.add(jPanel_signin_admin);
        parent_panel.repaint();
        parent_panel.revalidate();
    }//GEN-LAST:event_jButton_signin_opt_adminActionPerformed

    private void jButton_signin_opt_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_signin_opt_studentActionPerformed
        parent_panel.removeAll();
        parent_panel.add(jPanel_signin_student);
        parent_panel.repaint();
        parent_panel.revalidate();
    }//GEN-LAST:event_jButton_signin_opt_studentActionPerformed

    private void jButton_homepage_from_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_homepage_from_studentActionPerformed
        parent_panel.removeAll();
        parent_panel.add(jPanel_Highlight);
        parent_panel.repaint();
        parent_panel.revalidate();
    }//GEN-LAST:event_jButton_homepage_from_studentActionPerformed

    private void jButton_homepage_from_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_homepage_from_adminActionPerformed
        parent_panel.removeAll();
        parent_panel.add(jPanel_Highlight);
        parent_panel.repaint();
        parent_panel.revalidate();
    }//GEN-LAST:event_jButton_homepage_from_adminActionPerformed

    private void jButton_sign_in_reset_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sign_in_reset_studentActionPerformed
        jTextField_name_student.setText(null);
        jPasswordField_student.setText(null);
    }//GEN-LAST:event_jButton_sign_in_reset_studentActionPerformed

    private void jButton_sign_in_reset_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sign_in_reset_adminActionPerformed
        jTextField_name_admin.setText(null);
        jPasswordField_admin.setText(null);
    }//GEN-LAST:event_jButton_sign_in_reset_adminActionPerformed

    private void jButton_signin_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_signin_adminActionPerformed
        String admin_name = jTextField_name_admin.getText();
        String admin_password = jPasswordField_admin.getText();
        if (admin_name.contains("ad") && admin_password.contains("ad")) {
            jTextField_name_admin.setText(null);
            jPasswordField_admin.setText(null);
            //jPanel_main_opt_admin.setVisible(true);
            parent_panel.removeAll();
            parent_panel.add(jPanel_main_opt_admin);
            parent_panel.repaint();
            parent_panel.revalidate();
        }
        else {
            JOptionPane.showMessageDialog(null,"Invalid Login Details" , "Login Error", JOptionPane.ERROR_MESSAGE);
            jTextField_name_admin.setText(null);
            jPasswordField_admin.setText(null);
        }
    }//GEN-LAST:event_jButton_signin_adminActionPerformed

    private void jButton_new_student_sign_up_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_new_student_sign_up_adminActionPerformed
        /*
        String Serial=jTextField_new_student_serial_admin.getText();
        String LName=jTextField_new_student_last_name_admin.getText();
        String Username=jTextField_new_student_username_admin.getText();
        String Password=jPasswordField_new_student_password_admin.getText();
        
        */
        
        String query = "INSERT INTO `studentinfo`(`Serial`, `FirstName`, `LastName`, `ID`, `username`, `password`, `Email`, `Address`, `Mobile No.`) VALUES ('"+jTextField_new_student_serial_admin.getText()+"','"+jTextField_new_student_first_name_admin.getText()+"','"+jTextField_new_student_last_name_admin.getText()+"','"+jTextField_new_student_id_admin.getText()+"'"
                + ",'"+jTextField_new_student_username_admin.getText()+"','"+jPasswordField_new_student_password_admin.getText()+"','"+jTextField_new_student_email_admin.getText()+"','"+jTextField_new_student_address_admin.getText()+"','"+jTextField_new_student_mobile_no_admin.getText()+"')";
        
        String query1="INSERT INTO `attendanceinfo`(`Serial`, `Name`, `username`, `password`, `d1`, `d2`, `d3`, `d4`, `d5`, `d6`, `d7`, `d8`, `d9`, `d10`, `d11`, `d12`, `d13`, `d14`, `d15`, `d16`, `d17`, `d18`, `d19`, `d20`, `d21`, `d22`, `d23`, `d24`, `d25`, `d26`, `d27`, `d28`, `d29`, `d30`, `d31`) VALUES ('"+jTextField_new_student_serial_admin.getText()+"','"+jTextField_new_student_last_name_admin.getText()+"'"
                + ",'"+jTextField_new_student_username_admin.getText()+"','"+jPasswordField_new_student_password_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"',"
                + "'"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"'"
                + ",'"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"',"
                + "'"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"'"
                + ",'"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"',"
                + "'"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"','"+jTextField_initial_attendance_num_admin.getText()+"')";
        
        
        
        /*
        
         String Serial=jTextField_new_student_serial_admin.getText();
        
         String LName=jTextField_new_student_last_name_admin.getText();
        
         String Username=jTextField_new_student_username_admin.getText();
         String Password=jPasswordField_new_student_password_admin.getText();
         String d01=jTextField_initial_attendance_num_admin.getText();
         String d02=jTextField_initial_attendance_num_admin.getText();
         String d03=jTextField_initial_attendance_num_admin.getText();
         String d04=jTextField_initial_attendance_num_admin.getText();
         String d05=jTextField_initial_attendance_num_admin.getText();
         String d06=jTextField_initial_attendance_num_admin.getText();
         String d07=jTextField_initial_attendance_num_admin.getText();
         String d08=jTextField_initial_attendance_num_admin.getText();
         String d09=jTextField_initial_attendance_num_admin.getText();
         String d10=jTextField_initial_attendance_num_admin.getText();
         String d11=jTextField_initial_attendance_num_admin.getText();
         String d12=jTextField_initial_attendance_num_admin.getText();
         String d13=jTextField_initial_attendance_num_admin.getText();
         String d14=jTextField_initial_attendance_num_admin.getText();
         String d15=jTextField_initial_attendance_num_admin.getText();
         String d16=jTextField_initial_attendance_num_admin.getText();
         String d17=jTextField_initial_attendance_num_admin.getText();
         String d18=jTextField_initial_attendance_num_admin.getText();
         String d19=jTextField_initial_attendance_num_admin.getText();
         String d20=jTextField_initial_attendance_num_admin.getText();
         String d21=jTextField_initial_attendance_num_admin.getText();
         String d22=jTextField_initial_attendance_num_admin.getText();
         String d23=jTextField_initial_attendance_num_admin.getText();
         String d24=jTextField_initial_attendance_num_admin.getText();
         String d25=jTextField_initial_attendance_num_admin.getText();
         String d26=jTextField_initial_attendance_num_admin.getText();
         String d27=jTextField_initial_attendance_num_admin.getText();
         String d28=jTextField_initial_attendance_num_admin.getText();
         String d29=jTextField_initial_attendance_num_admin.getText();
         String d30=jTextField_initial_attendance_num_admin.getText();
         String d31=jTextField_initial_attendance_num_admin.getText();
     
        
         
        
        Connection conn=null;
        PreparedStatement pstmt=null;
        try{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projectdb", "root", "");
                pstmt=conn.prepareStatement("insert into attendanceinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,??,?,?,?)");
                pstmt.setString(1,Serial);
                pstmt.setString(2,LName);
                pstmt.setString(3,Username);
                pstmt.setString(4,Password);
                pstmt.setString(5,Username);
                pstmt.setString(6,d01);
                pstmt.setString(7,);
                pstmt.setString(8,);
                pstmt.setString(9,);
                pstmt.setString(10,);
                pstmt.setString(11,);
                pstmt.setString(12,);
                pstmt.setString(13,);
                pstmt.setString(14,);
                pstmt.setString(15,);
                pstmt.setString(16,);
                pstmt.setString(17,);
                pstmt.setString(18,);
                pstmt.setString(19,);
                pstmt.setString(20,);
                pstmt.setString(21,);
                pstmt.setString(22,);
                pstmt.setString(23,);
                pstmt.setString(24,);
                pstmt.setString(25,);
                pstmt.setString(26,);
                pstmt.setString(27,);
                pstmt.setString(28,);
                pstmt.setString(29,);
                pstmt.setString(30,);
                pstmt.setString(31,);
                
                
                int i=pstmt.executeUpdate();
                if(i>0) {
                    jTextField_new_student_serial_admin.setText(null);
                    jTextField_new_student_first_name_admin.setText(null);
                    jTextField_new_student_last_name_admin.setText(null);
                    jTextField_new_student_id_admin.setText(null);
                    jTextField_new_student_username_admin.setText(null);
                    jPasswordField_new_student_password_admin.setText(null);
                    jTextField_new_student_email_admin.setText(null);
                    jTextField_new_student_address_admin.setText(null);
                    jTextField_new_student_mobile_no_admin.setText(null);
                    JOptionPane.showMessageDialog(null, "New Student Added");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Try Again.");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(TestjFrame4x1.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        */
       
        executeSQlQuery(query, "Added");
        executeSQlQuery1(query1, "Added");
    }//GEN-LAST:event_jButton_new_student_sign_up_adminActionPerformed

    private void jButton_new_student_sign_up_refresh_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_new_student_sign_up_refresh_adminActionPerformed
        jTextField_new_student_serial_admin.setText(null);
        jTextField_new_student_first_name_admin.setText(null);
        jTextField_new_student_last_name_admin.setText(null);
        jTextField_new_student_id_admin.setText(null);
        jTextField_new_student_username_admin.setText(null);
        jPasswordField_new_student_password_admin.setText(null);
        jTextField_new_student_email_admin.setText(null);
        jTextField_new_student_address_admin.setText(null);
        jTextField_new_student_mobile_no_admin.setText(null);
        
    }//GEN-LAST:event_jButton_new_student_sign_up_refresh_adminActionPerformed

    private void jButton_sign_in_new_student_info_back_admin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sign_in_new_student_info_back_admin2ActionPerformed
        parent_panel.removeAll();
        parent_panel.add(jPanel_Highlight);
        parent_panel.repaint();
        parent_panel.revalidate();
    }//GEN-LAST:event_jButton_sign_in_new_student_info_back_admin2ActionPerformed

    private void jTable_view_student_info_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_view_student_info_adminMouseClicked
        int i = jTable_view_student_info_admin.getSelectedRow();
        TableModel model = jTable_view_student_info_admin.getModel();
        jTextField_new_student_serial_admin.setText(model.getValueAt(i,0).toString());
        jTextField_new_student_first_name_admin.setText(model.getValueAt(i,1).toString());
        jTextField_new_student_last_name_admin.setText(model.getValueAt(i,2).toString());
        jTextField_new_student_id_admin.setText(model.getValueAt(i,3).toString());
        jTextField_new_student_username_admin.setText(model.getValueAt(i,4).toString());
        jPasswordField_new_student_password_admin.setText(model.getValueAt(i,5).toString());
        jTextField_new_student_email_admin.setText(model.getValueAt(i,6).toString());
        jTextField_new_student_address_admin.setText(model.getValueAt(i,7).toString());
        jTextField_new_student_mobile_no_admin.setText(model.getValueAt(i,8).toString());
    }//GEN-LAST:event_jTable_view_student_info_adminMouseClicked

    private void jButton_update_student_info_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_update_student_info_adminActionPerformed
        String query = "UPDATE `studentinfo` SET `FirstName`='"+jTextField_new_student_first_name_admin.getText()+"',`LastName`='"+jTextField_new_student_last_name_admin.getText()+"',`ID`='"+jTextField_new_student_id_admin.getText()+"',`username`='"+jTextField_new_student_username_admin.getText()+"'"
                + ",`password`='"+jPasswordField_new_student_password_admin.getText()+"',`Email`='"+jTextField_new_student_email_admin.getText()+"',`Address`='"+jTextField_new_student_address_admin.getText()+"',`Mobile No.`='"+jTextField_new_student_mobile_no_admin.getText()+"' WHERE `Serial` = "+jTextField_new_student_serial_admin.getText();
        executeSQlQuery(query, "Updated");
        String query1="UPDATE `attendanceinfo` SET `username`='"+jTextField_new_student_username_admin.getText()+"',`password`='"+jPasswordField_new_student_password_admin.getText()+"' WHERE `Serial` = "+jTextField_new_student_serial_admin.getText();
        executeSQlQuery1(query1, "Updated");
        executeSQlQuery2(query1,"Updated");
    }//GEN-LAST:event_jButton_update_student_info_adminActionPerformed

    private void jButton_delete_student_info_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_delete_student_info_adminActionPerformed
        String query = "DELETE FROM `studentinfo` WHERE Serial = "+jTextField_new_student_serial_admin.getText();
        executeSQlQuery(query, "Deleted from Student-info ");
        String query1 = "DELETE FROM `attendanceinfo` WHERE Serial = "+jTextField_new_student_serial_admin.getText();
        executeSQlQuery1(query1,"Deleted from Attendance-info ");
        
    }//GEN-LAST:event_jButton_delete_student_info_adminActionPerformed

    private void jTextField_d01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d01ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d01ActionPerformed

    private void jTextField_d02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d02ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d02ActionPerformed

    private void jTextField_d03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d03ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d03ActionPerformed

    private void jTextField_d04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d04ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d04ActionPerformed

    private void jTextField_d05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d05ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d05ActionPerformed

    private void jTextField_d06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d06ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d06ActionPerformed

    private void jTextFiel_d07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFiel_d07ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFiel_d07ActionPerformed

    private void jTextField_d08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d08ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d08ActionPerformed

    private void jTextField_d09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d09ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d09ActionPerformed

    private void jTextField_d10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d10ActionPerformed

    private void jTextField_d11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d11ActionPerformed

    private void jTextField_d12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d12ActionPerformed

    private void jTextField_d13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d13ActionPerformed

    private void jTextField_d14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d14ActionPerformed

    private void jTextField_d15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d15ActionPerformed

    private void jTextField_d16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d16ActionPerformed

    private void jTextField_d17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d17ActionPerformed

    private void jTextField_d18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d18ActionPerformed

    private void jTextField_d19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d19ActionPerformed

    private void jTextField_d20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d20ActionPerformed

    private void jTextField_d21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d21ActionPerformed

    private void jTextField_d22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d22ActionPerformed

    private void jTextField_d23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d23ActionPerformed

    private void jTextField_d24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d24ActionPerformed

    private void jTextField_d25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d25ActionPerformed

    private void jTextField_d26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d26ActionPerformed

    private void jTextField_d27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d27ActionPerformed

    private void jTextField_d28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d28ActionPerformed

    private void jTextField_d29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d29ActionPerformed

    private void jTextField_d30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d30ActionPerformed

    private void jTextField_d31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_d31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_d31ActionPerformed

    private void jButton_back_attendance_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_back_attendance_adminActionPerformed
        parent_panel.removeAll();
        parent_panel.add(jPanel_main_opt_admin);
        parent_panel.repaint();
        parent_panel.revalidate();
    }//GEN-LAST:event_jButton_back_attendance_adminActionPerformed

    private void jButton_attendance_entry_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_attendance_entry_adminActionPerformed
        parent_panel.removeAll();
        parent_panel.add(jPanel_attendace_admin);
        parent_panel.repaint();
        parent_panel.revalidate();
    }//GEN-LAST:event_jButton_attendance_entry_adminActionPerformed

    private void jTable_attendance_student_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_attendance_student_adminMouseClicked
        int i = jTable_attendance_student_admin.getSelectedRow();
        TableModel model = jTable_attendance_student_admin.getModel();
        jTextField_serial_attendance_admin.setText(model.getValueAt(i,0).toString());
        jTextField_attendance_name_admin.setText(model.getValueAt(i,1).toString());
        jTextField_attendance_username_admin1.setText(model.getValueAt(i,2).toString());
        jTextField_password_attendance_admin.setText(model.getValueAt(i,3).toString());
        jTextField_d01.setText(model.getValueAt(i,4).toString());
        jTextField_d02.setText(model.getValueAt(i,5).toString());
        jTextField_d03.setText(model.getValueAt(i,6).toString());
        jTextField_d04.setText(model.getValueAt(i,7).toString());
        jTextField_d05.setText(model.getValueAt(i,8).toString());
        jTextField_d06.setText(model.getValueAt(i,9).toString());
        jTextFiel_d07.setText(model.getValueAt(i,10).toString());
        jTextField_d08.setText(model.getValueAt(i,11).toString());
        jTextField_d09.setText(model.getValueAt(i,12).toString());
        jTextField_d10.setText(model.getValueAt(i,13).toString());
        jTextField_d11.setText(model.getValueAt(i,14).toString());
        jTextField_d12.setText(model.getValueAt(i,15).toString());
        jTextField_d13.setText(model.getValueAt(i,16).toString());
        jTextField_d14.setText(model.getValueAt(i,17).toString());
        jTextField_d15.setText(model.getValueAt(i,18).toString());
        jTextField_d16.setText(model.getValueAt(i,19).toString());
        jTextField_d17.setText(model.getValueAt(i,20).toString());
        jTextField_d18.setText(model.getValueAt(i,21).toString());
        jTextField_d19.setText(model.getValueAt(i,22).toString());
        jTextField_d20.setText(model.getValueAt(i,23).toString());
        jTextField_d21.setText(model.getValueAt(i,24).toString());
        jTextField_d22.setText(model.getValueAt(i,25).toString());
        jTextField_d23.setText(model.getValueAt(i,26).toString());
        jTextField_d24.setText(model.getValueAt(i,27).toString());
        jTextField_d25.setText(model.getValueAt(i,28).toString());
        jTextField_d26.setText(model.getValueAt(i,29).toString());
        jTextField_d27.setText(model.getValueAt(i,30).toString());
        jTextField_d28.setText(model.getValueAt(i,31).toString());
        jTextField_d29.setText(model.getValueAt(i,32).toString());
        jTextField_d30.setText(model.getValueAt(i,33).toString());
        jTextField_d31.setText(model.getValueAt(i,34).toString());
        
        
    }//GEN-LAST:event_jTable_attendance_student_adminMouseClicked

    private void jButton_update_attendance_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_update_attendance_adminActionPerformed
        String query1="UPDATE `attendanceinfo` SET `username`='"+jTextField_attendance_username_admin1.getText()+"',`password`='"+jTextField_password_attendance_admin.getText()+"',`d1`='"+jTextField_d01.getText()+"',`d2`='"+jTextField_d02.getText()+"',`d3`='"+jTextField_d03.getText()+"',`d4`='"+jTextField_d04.getText()+"',`d5`='"+jTextField_d05.getText()+"',`d6`='"+jTextField_d06.getText()+"',`d7`='"+jTextFiel_d07.getText()+"',`d8`='"+jTextField_d08.getText()+"',`d9`='"+jTextField_d09.getText()+"',`d10`='"+jTextField_d10.getText()+"',`d11`='"+jTextField_d11.getText()+"',`d12`='"+jTextField_d12.getText()+"',`d13`='"+jTextField_d13.getText()+"',`d14`='"+jTextField_d14.getText()+"',`d15`='"+jTextField_d15.getText()+"',`d16`='"+jTextField_d16.getText()+"',`d17`='"+jTextField_d17.getText()+"',`d18`='"+jTextField_d18.getText()+"',`d19`='"+jTextField_d19.getText()+"',`d20`='"+jTextField_d20.getText()+"',`d21`='"+jTextField_d21.getText()+"',`d22`='"+jTextField_d22.getText()+"',`d23`='"+jTextField_d23.getText()+"',`d24`='"+jTextField_d24.getText()+"',`d25`='"+jTextField_d25.getText()+"',`d26`='"+jTextField_d26.getText()+"',`d27`='"+jTextField_d27.getText()+"',`d28`='"+jTextField_d28.getText()+"',`d29`='"+jTextField_d29.getText()+"',`d30`='"+jTextField_d30.getText()+"',`d31`='"+jTextField_d31.getText()+"' WHERE `Serial` = "+jTextField_serial_attendance_admin.getText();
        executeSQlQuery1(query1, "Attendance Info Updated");
        String query ="UPDATE `studentinfo` SET `username`='"+jTextField_attendance_username_admin1.getText()+"',`password`='"+jTextField_password_attendance_admin.getText()+"' WHERE `Serial` = "+jTextField_serial_attendance_admin.getText();
        executeSQlQuery(query, "Updated");
        executeSQlQuery2(query1, "Updated");
    }//GEN-LAST:event_jButton_update_attendance_adminActionPerformed

    private void jButton_signin_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_signin_studentActionPerformed
        Connection conn = createconnection();
        ResultSet rs=null;
        String query="SELECT * FROM `attendanceinfo` WHERE `username`=? and `password`=?";
        try {
            
            PST = conn.prepareStatement(query);
            PST.setString(1, jTextField_name_student.getText());
            PST.setString(2, jPasswordField_student.getText());
            rs=PST.executeQuery();
            if(rs.next()){
                
                jTextField_name_student.setText(null);
                jPasswordField_student.setText(null);
                //jPanel_main_opt_admin.setVisible(true);
                parent_panel.removeAll();
                parent_panel.add(jPanel_main_opt_student);
                parent_panel.repaint();
                parent_panel.revalidate();
            }
            else {
                JOptionPane.showMessageDialog(null,"Username or password is incorrect");
                jTextField_name_student.setText(null);
                jPasswordField_student.setText(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestjFrame4x1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton_signin_studentActionPerformed

    private void jTable_attendance_student_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_attendance_student_studentMouseClicked
        int i = jTable_attendance_student_student.getSelectedRow();
        TableModel model = jTable_attendance_student_student.getModel();
        jTextField_serial_attendance_serial.setText(model.getValueAt(i,0).toString());
        jTextField_attendance_name_student.setText(model.getValueAt(i,1).toString());
        jTextField_attendance_username_student.setText(model.getValueAt(i,2).toString());
        jPasswordField_edit_pass_student.setText(model.getValueAt(i,3).toString());
        
    }//GEN-LAST:event_jTable_attendance_student_studentMouseClicked

    private void jButton_back_attendance_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_back_attendance_studentActionPerformed
                parent_panel.removeAll();
                parent_panel.add(jPanel_Highlight);
                parent_panel.repaint();
                parent_panel.revalidate();
    }//GEN-LAST:event_jButton_back_attendance_studentActionPerformed

    private void jButton_stu_info_update_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_stu_info_update_studentActionPerformed
        String query ="UPDATE `studentinfo` SET `username`='"+jTextField_attendance_username_student.getText()+"',`password`='"+jPasswordField_edit_pass_student.getText()+"' WHERE `Serial` = "+jTextField_serial_attendance_serial.getText();
        executeSQlQuery(query, "Updated");
        String query2="UPDATE `attendanceinfo` SET `username`='"+jTextField_attendance_username_student.getText()+"',`password`='"+jPasswordField_edit_pass_student.getText()+"' WHERE `Serial` = "+jTextField_serial_attendance_serial.getText();
        executeSQlQuery2(query2, "Updated");
        executeSQlQuery1(query2, "Updated");
        
    }//GEN-LAST:event_jButton_stu_info_update_studentActionPerformed
      
    
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
            java.util.logging.Logger.getLogger(TestjFrame4x1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestjFrame4x1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestjFrame4x1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestjFrame4x1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestjFrame4x1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_attendance_entry_admin;
    private javax.swing.JButton jButton_back_attendance_admin;
    private javax.swing.JButton jButton_back_attendance_student;
    private javax.swing.JButton jButton_delete_student_info_admin;
    private javax.swing.JButton jButton_homepage_from_admin;
    private javax.swing.JButton jButton_homepage_from_student;
    private javax.swing.JButton jButton_new_student_sign_up_admin;
    private javax.swing.JButton jButton_new_student_sign_up_refresh_admin;
    private javax.swing.JButton jButton_sign_in_new_student_info_back_admin2;
    private javax.swing.JButton jButton_sign_in_reset_admin;
    private javax.swing.JButton jButton_sign_in_reset_student;
    private javax.swing.JButton jButton_signin_admin;
    private javax.swing.JButton jButton_signin_opt_admin;
    private javax.swing.JButton jButton_signin_opt_student;
    private javax.swing.JButton jButton_signin_student;
    private javax.swing.JButton jButton_stu_info_update_student;
    private javax.swing.JButton jButton_update_attendance_admin;
    private javax.swing.JButton jButton_update_student_info_admin;
    private javax.swing.JCheckBox jCheckBox_password_admin;
    private javax.swing.JCheckBox jCheckBox_password_student;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_name_admin1;
    private javax.swing.JLabel jLabel_name_student;
    private javax.swing.JLabel jLabel_password_admin;
    private javax.swing.JLabel jLabel_password_student;
    private javax.swing.JPanel jPanel_Highlight;
    private javax.swing.JPanel jPanel_attendace_admin;
    private javax.swing.JPanel jPanel_attendace_student;
    private javax.swing.JPanel jPanel_main_opt_admin;
    private javax.swing.JPanel jPanel_main_opt_new_student_signup_admin;
    private javax.swing.JPanel jPanel_main_opt_parent_panel_admin;
    private javax.swing.JPanel jPanel_main_opt_parent_panel_student;
    private javax.swing.JPanel jPanel_main_opt_student;
    private javax.swing.JPanel jPanel_signin_admin;
    private javax.swing.JPanel jPanel_signin_student;
    private javax.swing.JPasswordField jPasswordField_admin;
    private javax.swing.JPasswordField jPasswordField_edit_pass_student;
    private javax.swing.JPasswordField jPasswordField_new_student_password_admin;
    private javax.swing.JPasswordField jPasswordField_student;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_attendance_student_admin;
    private javax.swing.JTable jTable_attendance_student_student;
    private javax.swing.JTable jTable_view_student_info_admin;
    private javax.swing.JTextField jTextFiel_d07;
    private javax.swing.JTextField jTextField_attendance_name_admin;
    private javax.swing.JTextField jTextField_attendance_name_student;
    private javax.swing.JTextField jTextField_attendance_username_admin1;
    private javax.swing.JTextField jTextField_attendance_username_student;
    private javax.swing.JTextField jTextField_d01;
    private javax.swing.JTextField jTextField_d02;
    private javax.swing.JTextField jTextField_d03;
    private javax.swing.JTextField jTextField_d04;
    private javax.swing.JTextField jTextField_d05;
    private javax.swing.JTextField jTextField_d06;
    private javax.swing.JTextField jTextField_d08;
    private javax.swing.JTextField jTextField_d09;
    private javax.swing.JTextField jTextField_d10;
    private javax.swing.JTextField jTextField_d11;
    private javax.swing.JTextField jTextField_d12;
    private javax.swing.JTextField jTextField_d13;
    private javax.swing.JTextField jTextField_d14;
    private javax.swing.JTextField jTextField_d15;
    private javax.swing.JTextField jTextField_d16;
    private javax.swing.JTextField jTextField_d17;
    private javax.swing.JTextField jTextField_d18;
    private javax.swing.JTextField jTextField_d19;
    private javax.swing.JTextField jTextField_d20;
    private javax.swing.JTextField jTextField_d21;
    private javax.swing.JTextField jTextField_d22;
    private javax.swing.JTextField jTextField_d23;
    private javax.swing.JTextField jTextField_d24;
    private javax.swing.JTextField jTextField_d25;
    private javax.swing.JTextField jTextField_d26;
    private javax.swing.JTextField jTextField_d27;
    private javax.swing.JTextField jTextField_d28;
    private javax.swing.JTextField jTextField_d29;
    private javax.swing.JTextField jTextField_d30;
    private javax.swing.JTextField jTextField_d31;
    private javax.swing.JTextField jTextField_initial_attendance_num_admin;
    private javax.swing.JTextField jTextField_name_admin;
    private javax.swing.JTextField jTextField_name_student;
    private javax.swing.JTextField jTextField_new_student_address_admin;
    private javax.swing.JTextField jTextField_new_student_email_admin;
    private javax.swing.JTextField jTextField_new_student_first_name_admin;
    private javax.swing.JTextField jTextField_new_student_id_admin;
    private javax.swing.JTextField jTextField_new_student_last_name_admin;
    private javax.swing.JTextField jTextField_new_student_mobile_no_admin;
    private javax.swing.JTextField jTextField_new_student_serial_admin;
    private javax.swing.JTextField jTextField_new_student_username_admin;
    private javax.swing.JTextField jTextField_password_attendance_admin;
    private javax.swing.JTextField jTextField_serial_attendance_admin;
    private javax.swing.JTextField jTextField_serial_attendance_serial;
    private javax.swing.JPanel parent_panel;
    // End of variables declaration//GEN-END:variables
}
