package com.wxy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;
import com.wxy.model.StudentClass;
import com.wxy.utill.DbUtill;
import com.wxy.utill.StringUtill;

/**
 * 班级信息与数据库的操作
 * 
 * @author wxy/zjc/zct
 */
public class ClassDao extends BaseDao {
	private static Connection connection = new DbUtill().getCon();

	public boolean addClass(StudentClass scl) {
		try {
			String sql = "insert into s_class values(null,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, scl.getName());
			preparedStatement.setString(2, scl.getInfo());
			if (preparedStatement.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<StudentClass> getClassList(StudentClass studentClass){
		List<StudentClass> retList = new ArrayList<StudentClass>();
		String sqlString = "select * from s_class ";
		if(!StringUtill.isEmpty(studentClass.getName())) {
			sqlString += "where name like '%" + studentClass.getName() + "%'";
		}
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement =connection.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while (executeQuery.next()) {
				StudentClass sc = new StudentClass();
				sc.setId(executeQuery.getInt("id"));
				sc.setName(executeQuery.getString("name"));
				sc.setInfo(executeQuery.getString("info"));
				retList.add(sc);
			}
		} catch (Exception e) {
			return retList;
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retList;
	}
	public boolean update(StudentClass sc) {
		String sql = "update s_class set name=?, info=? where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,sc.getName());
			preparedStatement.setString(2,sc.getInfo());
			preparedStatement.setInt(3,sc.getId());
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  false;
		
	}
	
	/**
	 * 根据班级id删除班级
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		String sql = "delete from s_class where id = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return  false;
		
	}
	public  void closeDao() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
