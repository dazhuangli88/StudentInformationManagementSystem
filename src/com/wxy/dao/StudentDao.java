package com.wxy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.wxy.model.Student;
import com.wxy.utill.DbUtill;
import com.wxy.utill.StringUtill;
import com.wxy.model.Student;

public class StudentDao extends BaseDao {
	private static Connection connection = new DbUtill().getCon();
	public boolean addStudent(Student student) {
		String sql = "insert into s_student values(null,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getClassId());
			preparedStatement.setString(3, student.getPassword());
			preparedStatement.setString(4, student.getSex());
			if(preparedStatement.executeUpdate() > 0)return true;
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		return false;
		}
	public List<Student>getStudentList(Student student){
		List<Student> retList = new ArrayList<Student>();
		StringBuffer sqlStringBuffer = new StringBuffer("select * from s_student");
		if(!StringUtill.isEmpty(student.getName())){
			sqlStringBuffer.append(" and name like '%"+student.getName()+"%'");
		}
		if(student.getClassId() != 0){
			sqlStringBuffer.append(" and classId ="+student.getClassId());
		}
		try {
			PreparedStatement preparedStatement =connection.prepareStatement(sqlStringBuffer.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Student s = new Student();
				s.setId(executeQuery.getInt("id"));
				s.setName(executeQuery.getString("name"));
				s.setClassId(executeQuery.getInt("classId"));
				s.setSex(executeQuery.getString("sex"));
				s.setPassword(executeQuery.getString("password"));
				retList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean update(Student student) {
		String sql = "update s_student set name=?,classId=?,sex=?,password=? where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,student.getName());
			preparedStatement.setInt(2,student.getClassId());
			preparedStatement.setString(3,student.getSex());
			preparedStatement.setString(4,student.getPassword());
			preparedStatement.setInt(5,student.getId());
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  false;
	}
	public String editPassword(Student student,String newPassword) {
		String sql= "select * from s_student where id=? and password=?";
		PreparedStatement prst = null;
		int id = 0;
		try {	
		prst = connection.prepareStatement(sql);
		prst.setInt(1, student.getId());
		prst.setString(2, student.getPassword());
		ResultSet executeQuery = prst.executeQuery();
		if (!executeQuery.next()) {
			String retString = "旧密码错误！";
			return retString;
		} 
		id = executeQuery.getInt("id");
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}//把sql语句传给数据库操作对象
		String retString = "修改失败";
		sql= "update s_admin set password = ? where id = ?";
		try {
			prst =  connection.prepareStatement(sql);
			prst.setString(1, newPassword);
			prst.setInt(2, id); 
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
	public Student login(Student student) {
		String sql = "select * from s_student where name=? and password=?";
		Student studentRst = null;
		try {
			PreparedStatement prst = connection.prepareStatement(sql);
			prst.setString(1, student.getName());
			prst.setString(2,student.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if (executeQuery.next()) {
				studentRst = new Student();
				studentRst.setId(executeQuery.getInt("id"));
				studentRst.setClassId(executeQuery.getInt("classId"));
				studentRst.setName(executeQuery.getString("name"));
				studentRst.setPassword(executeQuery.getString("password"));
				studentRst.setSex(executeQuery.getString("sex"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentRst;
	}
	
	//关闭方法 
	public void closeDao() {
		// TODO Auto-generated method stub
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 具体删除操作在这里做
	 * @param parseInt
	 * @return
	 */
	public boolean delete(int id) {
		String sql = "delete from s_student where id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  false;
		
	}
}
	


