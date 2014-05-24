/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dao.UserAccountDAO;
import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.hibernate.transaction.JOTMTransactionManagerLookup;
import pojo.UserAccount;

/**
 *
 * @author Skys
 */
public class NhanVienSieuThiDlg extends javax.swing.JDialog {

    /**
     * Creates new form UserAccountDlg
     */
    private UserAccount user_account;
    private UserAccount user_template;
    private java.awt.Frame parentthis;
    private boolean bShowHintNgaySinh = true;
    private PropertyChangeSupport _eVentCapNhatThanhCong = new PropertyChangeSupport(this);
    public void addCapNhatThanhCongCongEvent(PropertyChangeListener lsn){
        _eVentCapNhatThanhCong.addPropertyChangeListener(lsn);
    }
    public void removeCapNhatThanhCongEvent(PropertyChangeListener lsn){
        _eVentCapNhatThanhCong.removePropertyChangeListener(lsn);
    }
    private boolean bCloseCLickDsNv = false;
    public NhanVienSieuThiDlg(java.awt.Frame parent, boolean modal,UserAccount user, boolean bCloseDsNv) {
        super(parent, modal);
        initComponents();
        parentthis = parent;
        user_account = user;
        user_template = user;
        bCloseCLickDsNv = bCloseDsNv;
        setLocationRelativeTo(parent);

        if(user_account!=null)
            setDataFormUser(user_account);     
        
        
        if(bCloseDsNv){
            //An Loai nguoi mo~ Form:
            jlbTypeUser.setText("");
            jlbTypeUser.setEnabled(false);
        }else{
            jlbTypeUser.setEnabled(true);
        }
    }
    private void labelMouseMove(JLabel lb){
        lb.setForeground(new Color(0,51,153));
        lb.setBorder(BorderFactory.createLineBorder(new Color(0, 51, 153)));
    }
    private void labelMouseExited(JLabel lb){
        lb.setForeground(new Color(0,0,0));
        lb.setBorder(null);
    }
    private void setDataFormUser(UserAccount user){
        lammoiDataFindFormUser();
        switch(user.getTypeLoginUser()){
            case "A":
                jlbTypeUser.setText("Admin");
                jlbTypeUser.setForeground(Color.red);
                jchbxAdmin.setSelected(true);
                break;
            case "M":
                jlbTypeUser.setText("Moderator");
                jlbTypeUser.setForeground(Color.WHITE);
                jchbxMod.setSelected(true);
                break;
            case "N":
                jlbTypeUser.setText("Nhân Viên");
                jlbTypeUser.setForeground(Color.BLUE);
                jchbxNhanVien.setSelected(true);
                break;
        }
        jtxtfldAccount.setText(user.getMaUser());
        jtxtfdMatKhau.setText(user.getMatKhau());
        jtxtfdEmail.setText(user.getEmailUser());
        
        jtxtfdHoVaTen.setText(user.getTenUser());
        jtxtfdNgaySinh.setText(user.getNgaySinh().toString());
        jtxtfdCMND.setText(user.getCmndUser());
        jtxtarDiaChi.setText(user.getDiaChiUser());
        jtxtfdPhone.setText(user.getPhoneUser());
        
        if(user.getGioiTinh().trim().equals("1")){
           jchbxNam.setSelected(true);
        }else if(user.getGioiTinh().trim().equals("0")){
            jchbxNu.setSelected(true);
        }
        if(user.getTypeLiveUser().trim().equals("1")){
           jchbxOpen.setSelected(true);
        }else if(user.getTypeLiveUser().trim().equals("0")){
            jChbxClosed.setSelected(true);
        }
        if(jtxtfdNgaySinh.getText().isEmpty())
            bShowHintNgaySinh = true;
        else
            bShowHintNgaySinh = false;
    }
    private void lammoiDataFindFormUser(){
        user_template = null;
        
        jchbxAdmin.setSelected(false);
        jchbxMod.setSelected(false);
        jchbxNhanVien.setSelected(false);
        
        jtxtfldAccount.setText("");
        jtxtfdMatKhau.setText("");
        jtxtfdEmail.setText("");
        
        jtxtfdHoVaTen.setText("");
        jtxtfdNgaySinh.setText("");
        jtxtfdCMND.setText("");
        jtxtarDiaChi.setText("");
        jtxtfdPhone.setText("");
        
        jchbxNam.setSelected(true);
        jchbxNu.setSelected(false);
        jchbxOpen.setSelected(true);
        jChbxClosed.setSelected(false);
        jtxtfdNgaySinh.setText("Year-Month-Day");
        bShowHintNgaySinh = true;
    }
    private void setDataFindFormUser(UserAccount user){
        lammoiDataFindFormUser();
        switch(user.getTypeLoginUser()){
            case "A":
                jchbxAdmin.setSelected(true);
                break;
            case "M":
                jchbxMod.setSelected(true);
                break;
            case "N":
                jchbxNhanVien.setSelected(true);
                break;
        }
        jtxtfldAccount.setText(user.getMaUser());
        jtxtfdMatKhau.setText(user.getMatKhau());
        jtxtfdEmail.setText(user.getEmailUser());
        
        jtxtfdHoVaTen.setText(user.getTenUser());
        jtxtfdNgaySinh.setText(user.getNgaySinh().toString());
        jtxtfdCMND.setText(user.getCmndUser());
        jtxtarDiaChi.setText(user.getDiaChiUser());
        jtxtfdPhone.setText(user.getPhoneUser());
        
        if(user.getGioiTinh().trim().equals("1")){
           jchbxNam.setSelected(true);
        }else if(user.getGioiTinh().trim().equals("0")){
            jchbxNu.setSelected(true);
        }
        if(user.getTypeLiveUser().trim().equals("1")){
           jchbxOpen.setSelected(true);
        }else if(user.getTypeLiveUser().trim().equals("0")){
            jChbxClosed.setSelected(true);
        }
        if(jtxtfdNgaySinh.getText().isEmpty())
            bShowHintNgaySinh = true;
        else
            bShowHintNgaySinh = false;
    }
    private boolean kiemtraNgaySinh(){
        SimpleDateFormat fm=new SimpleDateFormat("yyyy-MM-dd");  
        Date dNgaySinh=null;
        if(!bShowHintNgaySinh){
            try {
              dNgaySinh = fm.parse(jtxtfdNgaySinh.getText().trim());
        } catch (Exception ex) {
            return false;
        }
        }else
            return false;
      return true;
    }
    private UserAccount getDataFindFormUser(UserAccount user){
        if(user == null) user = new UserAccount(jtxtfldAccount.getText().trim());
        
        if(jchbxAdmin.isSelected())
            user.setTypeLoginUser("A");
        else if(jchbxMod.isSelected())
            user.setTypeLoginUser("M");
        else if(jchbxNhanVien.isSelected())
            user.setTypeLoginUser("N");
        
        
        user.setMatKhau(jtxtfdMatKhau.getText());
        user.setEmailUser(jtxtfdEmail.getText());
        
        user.setTenUser(jtxtfdHoVaTen.getText());
        
        SimpleDateFormat fm=new SimpleDateFormat("yyyy-MM-dd");  
        Date dNgaySinh=null;
        if(!bShowHintNgaySinh){
            try {
              dNgaySinh = fm.parse(jtxtfdNgaySinh.getText().trim());
        } catch (Exception ex) {
            try {
                dNgaySinh = fm.parse("0002-11-30");
            } catch (Exception ex1) {
            } 
        }
         user.setNgaySinh(dNgaySinh);  
        }
        else{
            try {
                dNgaySinh = fm.parse("0002-11-30");
            } catch (Exception ex1) {
            } 
         user.setNgaySinh(dNgaySinh);  
        }
        user.setCmndUser(jtxtfdCMND.getText());
        user.setDiaChiUser(jtxtarDiaChi.getText());
        user.setPhoneUser(jtxtfdPhone.getText());
        
        if(jchbxNam.isSelected())
            user.setGioiTinh("1");
        else if(jchbxNu.isSelected())
            user.setGioiTinh("0");
        
        if(jchbxOpen.isSelected())
            user.setTypeLiveUser("1");
        else if(jChbxClosed.isSelected())
            user.setTypeLiveUser("0");
        return user;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtxtfldAccount = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jtxtfdMatKhau = new javax.swing.JTextField();
        jtxtfdEmail = new javax.swing.JTextField();
        jchbxAdmin = new javax.swing.JCheckBox();
        jchbxMod = new javax.swing.JCheckBox();
        jchbxNhanVien = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtxtfdPhone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtarDiaChi = new javax.swing.JTextArea();
        jtxtfdCMND = new javax.swing.JTextField();
        jtxtfdHoVaTen = new javax.swing.JTextField();
        jtxtfdNgaySinh = new javax.swing.JTextField();
        jchbxNam = new javax.swing.JCheckBox();
        jchbxNu = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jlbTrangThai = new javax.swing.JLabel();
        jchbxOpen = new javax.swing.JCheckBox();
        jChbxClosed = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jlbTypeUser = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jlbLamMoi = new javax.swing.JLabel();
        jlbDanhSachNv = new javax.swing.JLabel();
        jlbXoaNv = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thông tin User");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Account"));

        jLabel3.setText("Mật khẩu:");

        jLabel1.setText("Tài khoản:");

        jLabel10.setText("Email:");

        jtxtfldAccount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtfldAccount.setText("ADSOFT01");
        jtxtfldAccount.setToolTipText("");

        jButton3.setText("Go");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jtxtfdMatKhau.setText("123abc");
        jtxtfdMatKhau.setToolTipText("");

        jtxtfdEmail.setText("universestartheky22@gmail.com");

        buttonGroup2.add(jchbxAdmin);
        jchbxAdmin.setSelected(true);
        jchbxAdmin.setText("Admin");
        jchbxAdmin.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jchbxAdminItemStateChanged(evt);
            }
        });

        buttonGroup2.add(jchbxMod);
        jchbxMod.setText("Moderator");
        jchbxMod.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jchbxModItemStateChanged(evt);
            }
        });

        buttonGroup2.add(jchbxNhanVien);
        jchbxNhanVien.setText("Nhân viên");
        jchbxNhanVien.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jchbxNhanVienItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jtxtfldAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jtxtfdMatKhau))
                    .addComponent(jtxtfdEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jchbxAdmin)
                    .addComponent(jchbxMod)
                    .addComponent(jchbxNhanVien))
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxtfldAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxtfdMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtfdEmail)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jchbxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jchbxMod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jchbxNhanVien)
                        .addContainerGap(19, Short.MAX_VALUE))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

        jLabel5.setText("Họ và tên:");

        jLabel6.setText("Ngày sinh:");

        jLabel7.setText("CMND:");

        jLabel8.setText("Địa chỉ:");

        jLabel9.setText("Phone:");

        jtxtfdPhone.setText("0929287038, 01668033117");

        jtxtarDiaChi.setColumns(20);
        jtxtarDiaChi.setRows(5);
        jtxtarDiaChi.setText("Lạc Long Quân, Q.11, Tp.HCM");
        jScrollPane1.setViewportView(jtxtarDiaChi);

        jtxtfdCMND.setText("301436291");
        jtxtfdCMND.setToolTipText("");

        jtxtfdHoVaTen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtfdHoVaTen.setText("Lê Hoàng Phú");

        jtxtfdNgaySinh.setText("Year-Month-Day");
        jtxtfdNgaySinh.setToolTipText("");
        jtxtfdNgaySinh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtfdNgaySinhFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtfdNgaySinhFocusLost(evt);
            }
        });

        buttonGroup1.add(jchbxNam);
        jchbxNam.setSelected(true);
        jchbxNam.setText("Nam");
        jchbxNam.setToolTipText("");

        buttonGroup1.add(jchbxNu);
        jchbxNu.setText("Nữ");
        jchbxNu.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel2.setText("Ví dụ: 2014-05-31");

        jlbTrangThai.setText("Tình Trạng:");

        buttonGroup3.add(jchbxOpen);
        jchbxOpen.setSelected(true);
        jchbxOpen.setText("Open");

        buttonGroup3.add(jChbxClosed);
        jChbxClosed.setText("Closed");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtfdPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jtxtfdCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jchbxNam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jchbxNu))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtxtfdNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtxtfdHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlbTrangThai)
                        .addGap(18, 18, 18)
                        .addComponent(jchbxOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jChbxClosed, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtxtfdHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtfdNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jchbxNam, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jchbxNu, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtfdCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtxtfdPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jchbxOpen)
                    .addComponent(jChbxClosed)
                    .addComponent(jlbTrangThai)))
        );

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setText("Thông Tin Nhân Viên");

        jlbTypeUser.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jlbTypeUser.setForeground(new java.awt.Color(255, 0, 0));
        jlbTypeUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbTypeUser.setText("Admin");

        jLabel19.setText(":");

        jButton1.setText("Cập Nhật");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Thêm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jlbLamMoi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlbLamMoi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbLamMoi.setText("Làm Mới");
        jlbLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbLamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbLamMoiMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbLamMoiMouseExited(evt);
            }
        });
        jlbLamMoi.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlbLamMoiMouseMoved(evt);
            }
        });

        jlbDanhSachNv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlbDanhSachNv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbDanhSachNv.setText("Danh Sách Nv");
        jlbDanhSachNv.setToolTipText("Xem danh sách nhân viên siêu thị");
        jlbDanhSachNv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbDanhSachNv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbDanhSachNvMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbDanhSachNvMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbDanhSachNvMouseExited(evt);
            }
        });
        jlbDanhSachNv.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlbDanhSachNvMouseMoved(evt);
            }
        });

        jlbXoaNv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlbXoaNv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbXoaNv.setText("Xóa Nv");
        jlbXoaNv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbXoaNv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbXoaNvMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbXoaNvMouseExited(evt);
            }
        });
        jlbXoaNv.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jlbXoaNvMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlbXoaNv, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbTypeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jlbDanhSachNv, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbDanhSachNv, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jlbTypeUser)
                        .addComponent(jLabel19))
                    .addComponent(jlbXoaNv, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Tien hanh luu thay doi (cap nhat) roi tat form
        if(!kiemtraNgaySinh()){
            JOptionPane.showMessageDialog(parentthis,"Cập nhật thất bại!\n Ngày sinh không hợp lệ!","Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        user_template = getDataFindFormUser(user_template);
        //JOptionPane.showMessageDialog(parentthis, user_template.getTenUser());
        if(UserAccountDAO.capNhatThongTinUser(user_template)){
            user_template = UserAccountDAO.layThongTinUser(jtxtfldAccount.getText().trim().toUpperCase());
            setDataFindFormUser(user_template);
            JOptionPane.showMessageDialog(parentthis,"Cập nhật thành công!","Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
            if(user_template.getMaUser().equals(user_account.getMaUser())){
                user_account = user_template;
                _eVentCapNhatThanhCong.firePropertyChange(null, null, user_account);
            }
        }else{
            JOptionPane.showMessageDialog(parentthis,"Cập nhật thất bại!","Lỗi!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        UserAccount user = UserAccountDAO.layThongTinUser(jtxtfldAccount.getText().trim().toUpperCase());
        if(user!=null){
            setDataFindFormUser(user);
            user_template = user;
        }else{
            String strNot = jtxtfldAccount.getText();
            lammoiDataFindFormUser();
            jtxtfldAccount.setText(strNot);
            JOptionPane.showMessageDialog(parentthis,"Nhân vật này không tồn tại!!","Xin lôi!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtxtfdNgaySinhFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtfdNgaySinhFocusGained
        // TODO add your handling code here:
        if(bShowHintNgaySinh)
            jtxtfdNgaySinh.setText("");
    }//GEN-LAST:event_jtxtfdNgaySinhFocusGained

    private void jtxtfdNgaySinhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtfdNgaySinhFocusLost
        // TODO add your handling code here:
        if(jtxtfdNgaySinh.getText().isEmpty()){
            jtxtfdNgaySinh.setText("Year-Month-Day");
            bShowHintNgaySinh = true;
        } else 
            bShowHintNgaySinh = false;
    }//GEN-LAST:event_jtxtfdNgaySinhFocusLost

    private void jlbLamMoiMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbLamMoiMouseMoved
        // TODO add your handling code here:
        labelMouseMove(jlbLamMoi);
    }//GEN-LAST:event_jlbLamMoiMouseMoved

    private void jlbLamMoiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbLamMoiMouseExited
        // TODO add your handling code here:
       labelMouseExited(jlbLamMoi);
    }//GEN-LAST:event_jlbLamMoiMouseExited

    private String processIDNew(List<UserAccount> lst,int iSoChuSoMa){
        if(lst==null) return "";
        //Lay ma cuoi' danh sach'- Ma~ lon' nhat;
         String strMaSo = lst.get(lst.size()-1).getMaUser();
         
         //Tach' so' # 0 ra khoi~ Ma~ User: US010 -> 10
         strMaSo=strMaSo.substring(strMaSo.length()-iSoChuSoMa); // 2: so' cuoi' cho Admin hoac Mod; 3:Nhan vien; NV003
         int iMaSoNew = Integer.parseInt(strMaSo)+1;
          
         //Admin; mod =: Toi da 10 nguoi
         //Nhan vien: Toi da 100 nguoi
         
         //Format ve danh XY: 1->01;9-09;
         if(iSoChuSoMa==2) // Admin; Mod
         {
            if(iMaSoNew<10)
                strMaSo="0"+String.valueOf(iMaSoNew);
           else
                strMaSo=String.valueOf(iMaSoNew);
         } else if(iSoChuSoMa == 3){
             if(iMaSoNew<10)
                strMaSo="00"+String.valueOf(iMaSoNew);
             else if(iMaSoNew<100)
                strMaSo="0"+String.valueOf(iMaSoNew);
             else
                strMaSo=String.valueOf(iMaSoNew);
         }
         return strMaSo;
    }
    private void jlbLamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbLamMoiMouseClicked
        // TODO add your handling code here:
        lammoiDataFindFormUser();
        //Random ma~ cho chuc nang Them nhan vien
        if(jchbxNhanVien.isSelected()){
            jtxtfldAccount.setText("NV" + processIDNew(UserAccountDAO.layDanhSachUserNhanVien(),3));
        }else if(jchbxAdmin.isSelected()){
          jtxtfldAccount.setText("ADSOFT" + processIDNew(UserAccountDAO.layDanhSachUserAdmin(),2));  
        }else if(jchbxMod.isSelected()){
            jtxtfldAccount.setText("MOSOFT" + processIDNew(UserAccountDAO.layDanhSachUserModerator(),2));
        }
    }//GEN-LAST:event_jlbLamMoiMouseClicked

    private void jchbxAdminItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jchbxAdminItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jchbxAdminItemStateChanged

    private void jchbxModItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jchbxModItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jchbxModItemStateChanged

    private void jchbxNhanVienItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jchbxNhanVienItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jchbxNhanVienItemStateChanged

    private void jlbDanhSachNvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbDanhSachNvMouseClicked
        // TODO add your handling code here:
        if(bCloseCLickDsNv){
            this.dispose();
            return;
        }
        DanhSachNhanVienDlg dsNvDlg = new DanhSachNhanVienDlg(parentthis, true);
        dsNvDlg.setVisible(true);
        
    }//GEN-LAST:event_jlbDanhSachNvMouseClicked

    private void jlbDanhSachNvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbDanhSachNvMouseExited
        // TODO add your handling code here:
        labelMouseExited(jlbDanhSachNv);
    }//GEN-LAST:event_jlbDanhSachNvMouseExited

    private void jlbDanhSachNvMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbDanhSachNvMouseMoved
        // TODO add your handling code here:
        labelMouseMove(jlbDanhSachNv);
    }//GEN-LAST:event_jlbDanhSachNvMouseMoved

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(!kiemtraNgaySinh()){
            JOptionPane.showMessageDialog(parentthis,"Thêm nhân viên thất bại!\n Ngày sinh không hợp lệ!","Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        user_template = new UserAccount(jtxtfldAccount.getText().trim().toUpperCase());
        user_template = getDataFindFormUser(user_template);
        if(UserAccountDAO.themUser(user_template)){
            user_template = UserAccountDAO.layThongTinUser(jtxtfldAccount.getText().trim().toUpperCase());
            setDataFindFormUser(user_template);
            JOptionPane.showMessageDialog(parentthis,"Thêm nhân viên thành công!","Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(parentthis,"Thêm nhân viên thất bại!","Lỗi!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jlbXoaNvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbXoaNvMouseClicked
        // TODO add your handling code here:
        if(user_template==null){
            JOptionPane.showMessageDialog(parentthis,"Xóa nhân viên thất bại!","Lỗi!", JOptionPane.ERROR_MESSAGE);
        }else if(user_template.getMaUser().equals(user_account.getMaUser())){
            JOptionPane.showMessageDialog(parentthis,"Không thể xóa nhân viên này!","Lỗi!", JOptionPane.ERROR_MESSAGE);
        }else if(JOptionPane.showConfirmDialog(parentthis, "Bạn thật sự muốn xóa nhân viên: " + user_template.getMaUser() + " ?","Xác nhận", JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE)==JOptionPane.OK_OPTION){
            
            //Dat bien' Type lai la "X": Xoa'.
            user_template.setTypeLoginUser(null);
            if(UserAccountDAO.xoaUser(user_template.getMaUser())){
                JOptionPane.showMessageDialog(parentthis,"Xóa nhân viên thành công","Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
                lammoiDataFindFormUser();
                user_template = null;
            }else{
               JOptionPane.showMessageDialog(parentthis,"Xóa nhân viên thất bại!","Lỗi!", JOptionPane.ERROR_MESSAGE);  
            }
        }
        
    }//GEN-LAST:event_jlbXoaNvMouseClicked

    private void jlbXoaNvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbXoaNvMouseExited
        // TODO add your handling code here:
         labelMouseExited(jlbXoaNv);
    }//GEN-LAST:event_jlbXoaNvMouseExited

    private void jlbXoaNvMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbXoaNvMouseMoved
        // TODO add your handling code here:
         labelMouseMove(jlbXoaNv);
    }//GEN-LAST:event_jlbXoaNvMouseMoved

    private void jlbDanhSachNvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbDanhSachNvMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbDanhSachNvMouseEntered

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
            java.util.logging.Logger.getLogger(UserAccountDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserAccountDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserAccountDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserAccountDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NhanVienSieuThiDlg dialog = new NhanVienSieuThiDlg(new javax.swing.JFrame(), true,null,false);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jChbxClosed;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JCheckBox jchbxAdmin;
    private javax.swing.JCheckBox jchbxMod;
    private javax.swing.JCheckBox jchbxNam;
    private javax.swing.JCheckBox jchbxNhanVien;
    private javax.swing.JCheckBox jchbxNu;
    private javax.swing.JCheckBox jchbxOpen;
    private javax.swing.JLabel jlbDanhSachNv;
    private javax.swing.JLabel jlbLamMoi;
    private javax.swing.JLabel jlbTrangThai;
    private javax.swing.JLabel jlbTypeUser;
    private javax.swing.JLabel jlbXoaNv;
    private javax.swing.JTextArea jtxtarDiaChi;
    private javax.swing.JTextField jtxtfdCMND;
    private javax.swing.JTextField jtxtfdEmail;
    private javax.swing.JTextField jtxtfdHoVaTen;
    private javax.swing.JTextField jtxtfdMatKhau;
    private javax.swing.JTextField jtxtfdNgaySinh;
    private javax.swing.JTextField jtxtfdPhone;
    private javax.swing.JTextField jtxtfldAccount;
    // End of variables declaration//GEN-END:variables
}
