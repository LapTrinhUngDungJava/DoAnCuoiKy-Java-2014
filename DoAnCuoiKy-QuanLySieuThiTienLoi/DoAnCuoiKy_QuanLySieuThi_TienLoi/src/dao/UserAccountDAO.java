/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.UserAccount;
import util.HibernateUtil;

/**
 *
 * @author Skys
 */
public class UserAccountDAO {
    
    
    public static List<UserAccount> layDanhSachUser() {
       java.util.List<UserAccount> ds = null; 
       Session session = HibernateUtil.getSessionFactory().openSession();
       try { 
       String hql = "select ur from UserAccount ur";// Ten Class Sinhvien dc map sang table sinhvien;
       Query query = session.createQuery(hql); 
       ds = query.list(); 
       } catch (HibernateException ex) { //Log the exception 
           //System.err.println(ex); 
       } finally { 
           session.close(); 
       }
       return ds;
   } 
    public static UserAccount layThongTinUser(String tenDangNhap) { 
       UserAccount sv = null;
       Session session = HibernateUtil.getSessionFactory().openSession();
       try { 
           sv = (UserAccount) session.get(UserAccount.class,tenDangNhap); 
       } catch (HibernateException ex) { //Log the exception 
           //System.err.println(ex); 
       } finally { 
           session.close(); 
       } 
       return sv;  
   }
   public static boolean capNhatThongTinUser(UserAccount ur) {
       Session session = HibernateUtil.getSessionFactory().openSession();
      if (UserAccountDAO.layThongTinUser(ur.getMaUser()) == null) {
          return false;
      } 
      Transaction transaction = null; 
      try { 
          transaction = session.beginTransaction();
          session.update(ur); 
          transaction.commit(); 
      } catch (HibernateException ex) { //Log the exception 
          transaction.rollback();
         // System.err.println(ex); 
      } finally { 
          session.close();
      } 
      return true; 
   }
}
