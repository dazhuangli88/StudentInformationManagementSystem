package com.wxy.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtill {
	private String dbUrl="jdbc:mysql://localhost:3306/db_student?useUnicode=ture&characterEncodeing=utf8&&serverTimezone=UTC";//���ݿ����ӵ�ַ
	private String dbUserName="root";//�û���
	private String dbPassword="root";//����
	private String jdbcName="com.mysql.jdbc.Driver";//��������
	/**��ȡ���ݿ�����
	 * 
	 * @return
	 */
	public Connection getCon() {
		try {
			Class.forName(jdbcName);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	/**�ر����ݿ�����
	 * 
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	public static void main(String[] args) {
		DbUtill dbUtill=new DbUtill();
		try {
			dbUtill.getCon();
		System.out.println("���ݿ����ӳɹ���");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.print("���ݿ�����ʧ��");
		}
	}
}
