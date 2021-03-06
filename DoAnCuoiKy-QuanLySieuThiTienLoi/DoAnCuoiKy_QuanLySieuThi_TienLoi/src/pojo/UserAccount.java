package pojo;
// Generated May 24, 2014 11:59:19 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * UserAccount generated by hbm2java
 */
public class UserAccount  implements java.io.Serializable {


     private String maUser;
     private String matKhau;
     private String tenUser;
     private String emailUser;
     private String diaChiUser;
     private String phoneUser;
     private String avatarUser;
     private String cmndUser;
     private Date ngaySinh;
     private String gioiTinh;
     private String typeLoginUser;
     private String typeLiveUser;

    public UserAccount() {
    }

	
    public UserAccount(String maUser) {
        this.maUser = maUser;
    }
    public UserAccount(String maUser, String matKhau, String tenUser, String emailUser, String diaChiUser, String phoneUser, String avatarUser, String cmndUser, Date ngaySinh, String gioiTinh, String typeLoginUser, String typeLiveUser) {
       this.maUser = maUser;
       this.matKhau = matKhau;
       this.tenUser = tenUser;
       this.emailUser = emailUser;
       this.diaChiUser = diaChiUser;
       this.phoneUser = phoneUser;
       this.avatarUser = avatarUser;
       this.cmndUser = cmndUser;
       this.ngaySinh = ngaySinh;
       this.gioiTinh = gioiTinh;
       this.typeLoginUser = typeLoginUser;
       this.typeLiveUser = typeLiveUser;
    }
   
    public String getMaUser() {
        return this.maUser;
    }
    
    public void setMaUser(String maUser) {
        this.maUser = maUser;
    }
    public String getMatKhau() {
        return this.matKhau;
    }
    
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public String getTenUser() {
        return this.tenUser;
    }
    
    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }
    public String getEmailUser() {
        return this.emailUser;
    }
    
    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
    public String getDiaChiUser() {
        return this.diaChiUser;
    }
    
    public void setDiaChiUser(String diaChiUser) {
        this.diaChiUser = diaChiUser;
    }
    public String getPhoneUser() {
        return this.phoneUser;
    }
    
    public void setPhoneUser(String phoneUser) {
        this.phoneUser = phoneUser;
    }
    public String getAvatarUser() {
        return this.avatarUser;
    }
    
    public void setAvatarUser(String avatarUser) {
        this.avatarUser = avatarUser;
    }
    public String getCmndUser() {
        return this.cmndUser;
    }
    
    public void setCmndUser(String cmndUser) {
        this.cmndUser = cmndUser;
    }
    public Date getNgaySinh() {
        return this.ngaySinh;
    }
    
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getGioiTinh() {
        return this.gioiTinh;
    }
    
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public String getTypeLoginUser() {
        return this.typeLoginUser;
    }
    
    public void setTypeLoginUser(String typeLoginUser) {
        this.typeLoginUser = typeLoginUser;
    }
    public String getTypeLiveUser() {
        return this.typeLiveUser;
    }
    
    public void setTypeLiveUser(String typeLiveUser) {
        this.typeLiveUser = typeLiveUser;
    }




}


