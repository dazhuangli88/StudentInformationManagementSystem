package com.wxy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wxy.model.Admin;
import com.wxy.utill.DbUtill;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminDao extends BaseDao {
	
	private static Connection connection = new DbUtill().getCon();
	
/**����Ա��½
 * 
 */
	public Admin login(Admin admin) {
		DbUtill dbUtill = new DbUtill();
		Connection con = dbUtill.getCon();
		String sql = "select * from s_admin where name=?  and password=? ";
	    Admin adminRst = null;
		try {
		// Ԥ����
	    PreparedStatement  prst = con.prepareStatement(sql);//��sql��䴫�����ݿ��������
	    // SQL�ĵ�һ�����ʺ��滻Ϊ����Ա����
	    prst.setString(1,admin.getName());
	    prst.setString(2,admin.getPassword());
	    // ִ��SQL
	    ResultSet executeQuery = prst.executeQuery();
	    // �ж��Ƿ��н��
	    if(executeQuery.next()) {
	    	// �����ݿ�������������Ա������
	    	adminRst = new Admin();
	    	adminRst.setId(Integer.parseInt(executeQuery.getString("id")));
	    	adminRst.setName(executeQuery.getString("name"));
	    	adminRst.setPassword(executeQuery.getString("password"));
	    	adminRst.setCreateDate(executeQuery.getString("createDate"));
	       }
	    }catch(SQLException e) {
			e.printStackTrace();
		}
	    try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return adminRst ;
	}

	public String editpassword(Admin admin, String newPassword) {
		String sql = "select * from s_admin where name=? and password=?";
		PreparedStatement prst = null;
		int Id = 0;
		try {
			// 
			prst = connection.prepareStatement(sql);// ��sql��䴫�����ݿ��������
			prst.setString(1, admin.getName());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if (!executeQuery.next()) {
				String retString = "���������";
				return retString;
			} 
			Id = executeQuery.getInt("id");
		} catch (Exception el) {
			// TODO: handle exception
			el.printStackTrace();
		}//��sql��䴫�����ݿ��������
		String retString = "�޸�ʧ��";
		String sqlString = "update s_admin set password = ? where id = ?";
		try {
			prst =  connection.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, Id); 
//			prst.setString(2, admin.getPassword());
			int rst = prst.executeUpdate();
			if (rst > 0) {
				retString = "�����޸ĳɹ���";
			} 
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return retString;

	}
}
