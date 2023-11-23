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
	
/**管理员登陆
 * 
 */
	public Admin login(Admin admin) {
		DbUtill dbUtill = new DbUtill();
		Connection con = dbUtill.getCon();
		String sql = "select * from s_admin where name=?  and password=? ";
	    Admin adminRst = null;
		try {
		// 预声明
	    PreparedStatement  prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
	    // SQL的第一个？问好替换为管理员名称
	    prst.setString(1,admin.getName());
	    prst.setString(2,admin.getPassword());
	    // 执行SQL
	    ResultSet executeQuery = prst.executeQuery();
	    // 判断是否有结果
	    if(executeQuery.next()) {
	    	// 把数据库的数据塞入管理员对象中
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
			prst = connection.prepareStatement(sql);// 把sql语句传给数据库操作对象
			prst.setString(1, admin.getName());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if (!executeQuery.next()) {
				String retString = "旧密码错误！";
				return retString;
			} 
			Id = executeQuery.getInt("id");
		} catch (Exception el) {
			// TODO: handle exception
			el.printStackTrace();
		}//把sql语句传给数据库操作对象
		String retString = "修改失败";
		String sqlString = "update s_admin set password = ? where id = ?";
		try {
			prst =  connection.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, Id); 
//			prst.setString(2, admin.getPassword());
			int rst = prst.executeUpdate();
			if (rst > 0) {
				retString = "密码修改成功！";
			} 
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return retString;

	}
}
