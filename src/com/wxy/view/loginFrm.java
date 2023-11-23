package com.wxy.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.wxy.dao.AdminDao;
import com.wxy.dao.StudentDao;
import com.wxy.dao.TeacherDao;
import com.wxy.model.UserType;
import com.wxy.utill.StringUtill;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.wxy.model.Admin;
import com.wxy.model.Student;
import com.wxy.model.Teacher;
public class loginFrm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 10086L;
	private JPanel contentPane;
	private JTextField userNameTextField;
	private JTextField passwordTextField;
	private JButton resetButton;
	private JComboBox<String> userTypeComboBox;
	private JLabel currentUserLabel;
	private UserType userType;
    private Object userObject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrm frame = new loginFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginFrm() {
		setTitle("\u767B\u9646\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u4FE1\u606F\u7CFB\u7EDF\u767B\u9646\u754C\u9762");
		lblNewLabel.setIcon(new ImageIcon(loginFrm.class.getResource("/image/LL.png")));
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.BOLD, 23));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(loginFrm.class.getResource("/image/\u7528\u6237\u540D.png")));
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6 \u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(loginFrm.class.getResource("/image/\u5BC6\u7801.png")));
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A\r\n");
		lblNewLabel_3.setIcon(new ImageIcon(loginFrm.class.getResource("/image/\u7C7B\u578B.png")));
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7CFB\u7EDF\u7BA1\u7406\u5458", "\u6559\u5E08", "\u5B66\u751F"}));
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginAction(ae);
				
			}
		});
		loginButton.setIcon(new ImageIcon(loginFrm.class.getResource("/image/\u767B\u5F55.png")));
		
		resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				restValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(loginFrm.class.getResource("/image/\u91CD\u7F6E.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(100)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(76)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
									.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(11))
								.addComponent(userTypeComboBox, 0, 230, Short.MAX_VALUE)
								.addComponent(passwordTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
								.addComponent(userNameTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))))
					.addGap(73))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel)
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton)
						.addComponent(loginButton))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void loginAction(ActionEvent ae) {
		// TODO Auto-generated method stub
		String userName = userNameTextField.getText().toString();
		String password = passwordTextField.getText().toString();
		// 获得登录页用户类型下拉框选中的数据
		String selectedItem = userTypeComboBox.getSelectedItem().toString();
		System.out.printf(selectedItem);
		if(StringUtill.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this,"用户名不能为空!");
			return;
		}
		if(StringUtill.isEmpty(password)) {
			JOptionPane.showMessageDialog(this,"密码不能为空!");
			return;
		}
		Admin admin = null;
		// 判断登录类型
		if("系统管理员".equals(selectedItem)){
			//系统管理员登录
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			adminTmp.setName(userName);
			adminTmp.setPassword(password);
		    admin = adminDao.login(adminTmp);
		if(admin == null) {
			JOptionPane.showMessageDialog(this,"用户名或者密码错误！");
			return;
		}
		JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.toString()+"】:"+admin.getName()+"登录本系统!");
		// 关闭当前窗口
		this.dispose();
		new MainFrm(UserType.ADMIN, admin).setVisible(true);
			
		}else if("教师".equals(selectedItem)){
			TeacherDao teacherDao = new TeacherDao();
			Teacher teacher = new Teacher();
			teacher.setName(userName);
			teacher.setPassword(password);
			Teacher teacherInfoTeacher = teacherDao.login(teacher);
			if(teacherInfoTeacher == null) {
				JOptionPane.showMessageDialog(this,"用户名或者密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.toString()+"】:"+teacherInfoTeacher.getName()+"登录本系统!");
			this.dispose();
			new MainFrm(UserType.TEACHER, teacher).setVisible(true);
		}else {
			//学生登录
			StudentDao studentDao = new StudentDao();
			Student student = new Student();
			student.setName(userName);
			student.setPassword(password);
			Student studentInfo = studentDao.login(student);
			if(studentInfo == null) {
				JOptionPane.showMessageDialog(this,"用户名或者密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.toString()+"】:"+studentInfo.getName()+"登录本系统!");
			this.dispose();
			new MainFrm(UserType.STUDENT, studentInfo).setVisible(true);
		}
	}

	protected void restValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		userNameTextField.setText("");
	    passwordTextField.setText("");
	    userTypeComboBox.setSelectedIndex(0);
	} 
}
