/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dao.UserAccountDAO;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import pojo.UserAccount;

/**
 *
 * @author Skys
 */
public class DanhSachNhanVienDlg extends javax.swing.JDialog {

    /**
     * Creates new form DanhSachNhanVienDlg
     */
    private DefaultTableModel dsNvModel = new DefaultTableModel();
    private DefaultTableModel dsNvModelFind = new DefaultTableModel();
    private Thread _tFindUser;
    private Thread _tLoadUser;
    private Thread _tProgressBarFindUser;
    private Thread _tProgressBarLoadUser;
    private java.awt.Frame parentthis;
    private UserAccount user_account;
    public DanhSachNhanVienDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        parentthis = parent;
        setLocationRelativeTo(null);
        
        //Danh sach nv
        dsNvModel.addColumn("STT");
        dsNvModel.addColumn("Mã Nv");
        dsNvModel.addColumn("Loại Nv");
        dsNvModel.addColumn("Tình Trạng");
        dsNvModel.addColumn("Mật khẩu");
        dsNvModel.addColumn("Email");
        dsNvModel.addColumn("Tên Nv");
        dsNvModel.addColumn("Ngày sinh");
        dsNvModel.addColumn("Giới tính");
        dsNvModel.addColumn("CMND");
        dsNvModel.addColumn("Phone");
        dsNvModel.addColumn("Địa chỉ");
        
        //Nhan vien Finded
        dsNvModelFind.addColumn("STT");
        dsNvModelFind.addColumn("Mã Nv");
        dsNvModelFind.addColumn("Loại Nv");
        dsNvModelFind.addColumn("Tình Trạng");
        dsNvModelFind.addColumn("Mật khẩu");
        dsNvModelFind.addColumn("Email");
        dsNvModelFind.addColumn("Tên Nv");
        dsNvModelFind.addColumn("Ngày sinh");
        dsNvModelFind.addColumn("Giới tính");
        dsNvModelFind.addColumn("CMND");
        dsNvModelFind.addColumn("Phone");
        dsNvModelFind.addColumn("Địa chỉ");
        
        jtbDanhSachNv.setModel(dsNvModel);
        jtbFindNv.setModel(dsNvModelFind);
        threadFindUserStart();
        threadLoadUserStart();
        
        jMenuBar1.setVisible(false);
        jPopupMenu1.add(jmnXemChiTietFinder);
        //jPopupMenu1.add(new JSeparator());
        //jPopupMenu1.add(jMenuItem1);
        
        jPopupMenu2.add(jmnXemChiTietDanhSach);
        
        jpgrssFindUser.setStringPainted(true);
        jpgrssLoadUser.setStringPainted(true);
        
    }
    private boolean bStopThreadFind = false;
    private boolean bStopThreadLoad = false;
    private void threadFindUserStart(){
      // bStopThreadFind = false;
      _tProgressBarFindUser=  new Thread(new Runnable() {

            @Override
            public void run() {
                int i=0;
               jpgrssFindUser.setVisible(true);
               jpgrssFindUser.setMaximum(100);
               jpgrssFindUser.setValue(0);
               while(i<100){
                   if(bStopThreadFind){
                       jpgrssFindUser.setValue(100);
                       return;
                   }
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException ex) {
                   }
                   i++;
                   jpgrssFindUser.setValue(i);
               }
               jpgrssFindUser.setVisible(false);
            }
        });
      _tProgressBarFindUser.start();
      
      _tFindUser = new Thread(new Runnable() {

            @Override
            public void run() {
               findUser();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
  
                }
               bStopThreadFind = true;
               jpgrssFindUser.setValue(jpgrssFindUser.getMaximum());
               jpgrssFindUser.setVisible(false);
            }
        });
        _tFindUser.start();
    }
    private void threadLoadUserStart(){
        //bStopThreadLoad = false;
        _tProgressBarLoadUser=  new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
               jpgrssLoadUser.setVisible(true);
               jpgrssLoadUser.setMaximum(100);
               jpgrssLoadUser.setValue(0);
               while(i<100){
                   if(bStopThreadLoad){
                       jpgrssLoadUser.setValue(100);
                       return;
                   }
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException ex) {
                   }
                   i++;
                   jpgrssLoadUser.setValue(i);
               }
               jpgrssLoadUser.setVisible(false);
            }
        });
      _tProgressBarLoadUser.start();
      
        _tLoadUser = new Thread(new Runnable() {

            @Override
            public void run() {
               loadListUser();
               
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                 
                }
               bStopThreadLoad = true;
               jpgrssLoadUser.setValue(jpgrssLoadUser.getMaximum());
               jpgrssLoadUser.setVisible(false);
            }
        });
        _tLoadUser.start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbDanhSachNv = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jcmbLoai = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbFindNv = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtxtfldAccount = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jlbTypeUser = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jpgrssFindUser = new javax.swing.JProgressBar();
        jpgrssLoadUser = new javax.swing.JProgressBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmnXemChiTietFinder = new javax.swing.JMenuItem();
        jmnXemChiTietDanhSach = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtbDanhSachNv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtbDanhSachNv.setComponentPopupMenu(jPopupMenu2);
        jtbDanhSachNv.getTableHeader().setResizingAllowed(false);
        jtbDanhSachNv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbDanhSachNvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbDanhSachNv);

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jcmbLoai.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcmbLoai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất cả", "Admin", "Moderator", "Nhân viên" }));
        jcmbLoai.setToolTipText("");

        jLabel2.setText("Loại Nv:");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jtbFindNv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        jtbFindNv.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(jtbFindNv);

        jLabel1.setText("Mã Nv:");

        jtxtfldAccount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtfldAccount.setText("ADSOFT01");
        jtxtfldAccount.setToolTipText("");

        jButton3.setText("Find");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Danh Sách Nhân Viên");

        jlbTypeUser.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jlbTypeUser.setForeground(new java.awt.Color(255, 0, 0));
        jlbTypeUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbTypeUser.setText("Admin");

        jLabel19.setText(":");

        jpgrssFindUser.setForeground(new java.awt.Color(0, 51, 153));

        jpgrssLoadUser.setForeground(new java.awt.Color(0, 51, 153));

        jMenu1.setText("File");

        jmnXemChiTietFinder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/use1.png"))); // NOI18N
        jmnXemChiTietFinder.setText("Xem Chi Tiết");
        jmnXemChiTietFinder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnXemChiTietFinderActionPerformed(evt);
            }
        });
        jMenu1.add(jmnXemChiTietFinder);

        jmnXemChiTietDanhSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/use1.png"))); // NOI18N
        jmnXemChiTietDanhSach.setText("Xem Chi Tiết");
        jmnXemChiTietDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnXemChiTietDanhSachActionPerformed(evt);
            }
        });
        jMenu1.add(jmnXemChiTietDanhSach);

        jMenuItem2.setText("jMenuItem2");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtfldAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcmbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpgrssLoadUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpgrssFindUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbTypeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(jlbTypeUser)
                                    .addComponent(jLabel19))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jpgrssFindUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jtxtfldAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcmbLoai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpgrssLoadUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(345, 345, 345))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Vector getRowModel(UserAccount user, int iSTT){
        Vector vtRow = new Vector();
        if(user==null) return vtRow;
        vtRow.add(iSTT);
        vtRow.add(user.getMaUser());
         switch(user.getTypeLoginUser()){
            case "A":
                vtRow.add("Admin");
                break;
            case "M":
                vtRow.add("Moderator");
                break;
            case "N":
                vtRow.add("Nhân viên");
                break;
        }
         if(user.getTypeLiveUser().trim().equals("1")){
           vtRow.add("Open");
        }else if(user.getTypeLiveUser().trim().equals("0")){
           vtRow.add("Closed");
        }
         vtRow.add(user.getMatKhau());
         vtRow.add(user.getEmailUser());
         vtRow.add(user.getTenUser());
         vtRow.add(user.getNgaySinh());
         if(user.getGioiTinh().trim().equals("1")){
            vtRow.add("Nam");
        }else if(user.getGioiTinh().trim().equals("0")){
            vtRow.add("Nữ");
        }
         vtRow.add(user.getCmndUser());
         vtRow.add(user.getPhoneUser());
         vtRow.add(user.getDiaChiUser());
        return vtRow;
    }
    private void clearTable(DefaultTableModel table){
        while(table.getRowCount()>0){
            table.removeRow(0);
        }
    }
    private void findUser(){
        UserAccount user = UserAccountDAO.layThongTinUser(jtxtfldAccount.getText().trim().toUpperCase());
        if(user==null) return;
        user_account = user;
        jtxtfldAccount.setText(user.getMaUser());
        clearTable(dsNvModelFind);
        //Update len table
        dsNvModelFind.addRow(getRowModel(user, 1));
        dsNvModelFind.addRow(new Vector());//dong trong'
    }
     private void loadListUser(){
         List<UserAccount> lstUser=null;
        //Tất cả, Admin, Moderator, Nhân viên
        switch(jcmbLoai.getSelectedIndex()){
            case 0: // Tất cả
                lstUser = UserAccountDAO.layDanhSachUser();
                break;
            case 1://Admin
                lstUser = UserAccountDAO.layDanhSachUserAdmin();
                break;
            case 2://Moderator
                lstUser = UserAccountDAO.layDanhSachUserModerator();
                break;
            case 3://Nhân viên
                lstUser = UserAccountDAO.layDanhSachUserNhanVien();
                break;
        }
        
        clearTable(dsNvModel);
        if(lstUser==null){
            dsNvModel.addRow(new Vector());//dong trong'
            JOptionPane.showMessageDialog(rootPane, "ok");
            return;
        }
        for (UserAccount userAccount : lstUser) {
            dsNvModel.addRow(getRowModel(userAccount, dsNvModel.getRowCount()));
        }
        dsNvModel.addRow(new Vector());//dong trong'
     }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       //findUser();
       //xoa trang' danh sach
       clearTable(dsNvModelFind);
       threadFindUserStart();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //loadListUser();
        clearTable(dsNvModel);
        threadLoadUserStart();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtbDanhSachNvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbDanhSachNvMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbDanhSachNvMouseClicked

    private void jmnXemChiTietFinderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnXemChiTietFinderActionPerformed
        // TODO add your handling code here:
        if(this.dsNvModelFind.getRowCount()!=0){
            NhanVienSieuThiDlg nvDlg = new NhanVienSieuThiDlg(parentthis, true,user_account , true);
            nvDlg.setVisible(true);
        }
    }//GEN-LAST:event_jmnXemChiTietFinderActionPerformed

    private void jmnXemChiTietDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnXemChiTietDanhSachActionPerformed
        // TODO add your handling code here:
        if(this.dsNvModel.getRowCount()>0){;
            int iRow = this.jtbDanhSachNv.getSelectedRow();
            if(iRow>=0){
            user_account = UserAccountDAO.layThongTinUser(dsNvModel.getValueAt(iRow,1).toString().trim());
            //JOptionPane.showMessageDialog(parentthis,user_account.getMaUser());
            NhanVienSieuThiDlg nvDlg = new NhanVienSieuThiDlg(parentthis, true,user_account , true);
            nvDlg.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(parentthis, "Bạn chưa chọn nhân viên!","Warning",JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jmnXemChiTietDanhSachActionPerformed

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
            java.util.logging.Logger.getLogger(DanhSachNhanVienDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachNhanVienDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachNhanVienDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachNhanVienDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DanhSachNhanVienDlg dialog = new DanhSachNhanVienDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox jcmbLoai;
    private javax.swing.JLabel jlbTypeUser;
    private javax.swing.JMenuItem jmnXemChiTietDanhSach;
    private javax.swing.JMenuItem jmnXemChiTietFinder;
    private javax.swing.JProgressBar jpgrssFindUser;
    private javax.swing.JProgressBar jpgrssLoadUser;
    private javax.swing.JTable jtbDanhSachNv;
    private javax.swing.JTable jtbFindNv;
    private javax.swing.JTextField jtxtfldAccount;
    // End of variables declaration//GEN-END:variables
}
