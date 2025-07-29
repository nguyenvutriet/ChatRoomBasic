package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil_ {
	private static File fileLog = new File("D:\\fileLog.txt");
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			writeFileLong(e.getMessage());
			e.printStackTrace();
			return null;
			
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void closeSessionFactory() {
		getSessionFactory().close();
	}
	public static void writeFileLong(String message) {
		try {
			if(!fileLog.exists()) {
				fileLog.createNewFile();
			}
			
			FileOutputStream os = new FileOutputStream(fileLog, true);
			OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
			BufferedWriter bw = new BufferedWriter(osw);
			
			LocalDateTime currentTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String time = currentTime.format(formatter);
			
			bw.append(time + " --> " + message);
			bw.newLine();
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
