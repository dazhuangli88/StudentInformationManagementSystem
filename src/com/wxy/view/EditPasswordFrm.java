package com.wxy.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.wxy.dao.AdminDao;
import com.wxy.model.Admin;
import com.wxy.model.UserType;
import com.wxy.utill.StringUtill;

public class EditPasswordFrm extends JFrame {

	private JPanel contentPane;
	private JTextField oldPasswordTextField;
	private JTextField newPasswordTextField;
	private JTextField comfirmPasswordTextField;
	private JTextField currentUserLabel;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditPasswordFrm frame = new EditPasswordFrm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public EditPasswordFrm() {
		setFont(new Font("微软雅黑", Font.PLAIN, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditPasswordFrm.class.getResource("/image/\u718A.png")));
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
     
		setContentPane(contentPane);
		JLabel lblNewLabel = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/image/\u5BC6\u7801.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/image/\u94A5\u5319.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		oldPasswordTextField = new JTextField();
		oldPasswordTextField.setColumns(10);
		
		newPasswordTextField = new JTextField();
		newPasswordTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_2.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/image/\u94A5\u5319.png")));
		
		comfirmPasswordTextField = new JTextField();
		comfirmPasswordTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4");
		submitButton.addActionListener(ae->submitEdit(ae));
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		submitButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/image/\u786E\u8BA4 .png")));
		
		JButton restButton = new JButton("\u91CD\u7F6E");
		restButton.addActionListener(ae->resetValue(ae));
		restButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		restButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/image/\u91CD\u7F6E02.png")));
		
		JLabel lblNewLabel_3 = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_3.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/image/\u7528\u6237\u540D.png")));
		
		currentUserLabel = new JTextField();
		currentUserLabel.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(155, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel)
							.addComponent(lblNewLabel_1)
							.addComponent(lblNewLabel_2)
							.addComponent(lblNewLabel_3))
						.addComponent(submitButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comfirmPasswordTextField)
								.addComponent(newPasswordTextField)
								.addComponent(oldPasswordTextField, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
								.addComponent(currentUserLabel)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(restButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addGap(148))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(currentUserLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comfirmPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(restButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	 if("系统管理员".equals(MainFrm.userType.getName())) {
		 Admin admin = (Admin)MainFrm.userObject;
		 currentUserLabel.setText("【系统管理员】" + admin.getName());
	 }
	 // 子窗口关闭时父窗口不关闭
	 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	}


	protected void submitEdit(ActionEvent ae) {
		// TODO Auto-generated method stub
		// 获取原密码输入框的内容
		String oldPassword = oldPasswordTextField.getText().toString();
		String newPassword = newPasswordTextField.getText().toString();
		String conformPassword = comfirmPasswordTextField.getText().toString();
		if(StringUtill.isEmpty(oldPassword)) {
			JOptionPane.showMessageDialog(this,"请填写旧密码！");
			return;
		}
		if(StringUtill.isEmpty(newPassword)) {
			JOptionPane.showMessageDialog(this,"请填写新密码！");
			return;
		}
		if(StringUtill.isEmpty(conformPassword)) {
			JOptionPane.showMessageDialog(this,"请填写确认密码！");
			return;
		}
		if(!newPassword.equals(conformPassword)) {
			JOptionPane.showMessageDialog(this,"两次密码输入不一致！");
			return;
		}
		if("系统管理员".equals(MainFrm.userType.getName())) {
		AdminDao adminDao = new AdminDao();
		Admin adminTmp = new Admin();
		Admin admin = (Admin)MainFrm.userObject;
		adminTmp.setName(admin.getName()); 
		adminTmp.setPassword(oldPassword);
		JOptionPane.showMessageDialog(this,	adminDao.editpassword(adminTmp, newPassword));
		return;
		}
	}


	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		oldPasswordTextField.setText("");
		newPasswordTextField.setText("");
		comfirmPasswordTextField.setText("");
	}
}
