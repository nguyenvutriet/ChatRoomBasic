package dao;

import java.awt.desktop.AboutEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import model.Register;
import util.HibernateUtil;
import util.HibernateUtil_;

public class registerDAO {
	public List<Register> getAll(){
		List<Register> dsDangKy = new ArrayList<Register>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
				String hql = "from Register";
				Query query = session.createQuery(hql);
				dsDangKy = query.getResultList();
				
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			HibernateUtil_.writeFileLong(e.getMessage());
		}
		return dsDangKy;
	}
	public boolean condition(String name) {
		List<Register> ds = new ArrayList<Register>();
		try {
			SessionFactory sessionFactory = HibernateUtil_.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
				String hql = "from Register where hoTen = :ten";
				Query query = session.createQuery(hql);
				query.setParameter("ten", name);
				
				ds = query.getResultList();
				
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			HibernateUtil_.writeFileLong(e.getMessage());
		}
		return ds.size() > 0;
	}
	public boolean insert(Register re) {
		try {
			SessionFactory sessionFactory = HibernateUtil_.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
				session.save(re);
				
				tr.commit();
				session.close();
				
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			HibernateUtil_.writeFileLong(e.getMessage());
		}
		return false;
	}
	public boolean examPassword(String pass, String name) {
		List<Register> pa = new ArrayList<Register>();
		try {
			SessionFactory sessionFactory = HibernateUtil_.getSessionFactory();
			if(sessionFactory != null) {
				 Session session = sessionFactory.openSession();
				 Transaction tr = session.beginTransaction();
				 
				 String hql = "from Register where matKhau = :pas and hoTen = :ten";
				 Query query = session.createQuery(hql);
				 query.setParameter("pas", pass);
				 query.setParameter("ten", name);
				 
				 pa = query.getResultList();
				 
				 tr.commit();
				 session.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			HibernateUtil_.writeFileLong(e.getMessage());
		}
		return pa.size() > 0;
	}
	public boolean checkExist(String pass, String name, String user) {
		List<Register> ds = new ArrayList<Register>();
		try {
			SessionFactory sessionFactory = HibernateUtil_.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				
				String hql = "from Register where maKhau = :pass  and hoTen = :name and tenDangNhap = :user";
				Query query = session.createQuery(hql);
				query.setParameter("pass", pass);
				query.setParameter("name", name);
				query.setParameter("user", user);
				
				ds = query.getResultList();
				
				tr.commit();
				session.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			HibernateUtil_.writeFileLong(e.getMessage());
		}
		return ds.size() > 0;
	}
	
}
