package com.wxy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.wxy.dao.ClassDao;
import com.wxy.dao.StudentDao;
import com.wxy.model.Student;
import com.wxy.model.StudentClass;
import com.wxy.utill.StringUtill;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class AddStudentFrm extends JFrame {
	private JTextField studentNameTextField;
	private JPasswordField studentPasswordField;
	private JComboBox studentClassComboBox;
	private ButtonGroup sexButtonGroup;
	private JRadioButton studentSexManRadioButton;
	private JRadioButton studentSexManRadioButton_1;
	private JRadioButton studentSexFemalRadioButton;
	private JRadioButton studentSexFemalRadioButton_1;
	

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { AddStudentFrm frame = new
	 * AddStudentFrm(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public AddStudentFrm() {
		setTitle("\u6DFB\u52A0\u5B66\u751F");
		setBounds(100, 100, 555, 370);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
		lblNewLabel.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/image/\u540D\u79F0.png")));
		
		studentNameTextField = new JTextField();
		studentNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/image/\u6240\u5C5E\u5355\u4F4D.png")));
		lblNewLabel_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		lblNewLabel_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
		lblNewLabel_2.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/image/\u6027\u522B.png")));
		
		JLabel lblNewLabel_3 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
		lblNewLabel_3.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/image/\u5BC6\u7801.png")));
		
		JButton submitButton = new JButton("\u786E\u8BA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				studentAddAct(ae);
			}
		});
		submitButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
		submitButton.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/image/\u786E\u8BA4 .png")));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
		resetButton.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/image/\u91CD\u7F6E02.png")));
		
		studentSexManRadioButton = new JRadioButton("\u7537");
		studentSexManRadioButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
		
		studentSexFemalRadioButton = new JRadioButton("\u5973");
		studentSexFemalRadioButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
		studentClassComboBox = new JComboBox();
		ClassDao classDao = new ClassDao();
		List<StudentClass> classList = classDao.getClassList(new StudentClass());
		for(StudentClass studentClass : classList) {
			studentClassComboBox.addItem(studentClass.getId() + "_" + studentClass.getName());
		}
		studentPasswordField = new JPasswordField();
		studentSexManRadioButton_1 = new JRadioButton();
		studentSexManRadioButton_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
		studentSexManRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentSexManRadioButton_1.setSelected(true);
				studentSexFemalRadioButton.setSelected(false);
			}
		});
		studentSexManRadioButton_1.setText("\u7537");
		studentSexFemalRadioButton_1 = new JRadioButton();
		studentSexFemalRadioButton_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 16));
		studentSexFemalRadioButton_1.setText("\u5973");
		studentSexFemalRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentSexManRadioButton_1.setSelected(false);
				studentSexFemalRadioButton.setSelected(true);
			}
		});
		sexButtonGroup = new ButtonGroup();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(132)
							.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(53)
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(95)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(studentSexManRadioButton_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(studentSexFemalRadioButton_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(lblNewLabel_3))
									.addGap(35)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(studentPasswordField, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(studentClassComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(studentNameTextField, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))))))
					.addGap(107))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(studentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(studentClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(studentPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(studentSexManRadioButton_1)
						.addComponent(studentSexFemalRadioButton_1))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addGap(52))
		);
		getContentPane().setLayout(groupLayout);

	}
	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		studentNameTextField.setText("");
		studentPasswordField.setText("");
		studentClassComboBox.setSelectedIndex(0);
		sexButtonGroup.clearSelection();
		studentSexManRadioButton_1.setSelected(true);
	}


	protected void studentAddAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String studentName = studentNameTextField.getText().toString();
		String studentPassword = studentPasswordField.getText().toString();
		if(StringUtill.isEmpty(studentName)){
			JOptionPane.showMessageDialog(this, "«ÎÃÓ–¥—ß…˙–’√˚!");
			return;
		}
		if(StringUtill.isEmpty(studentPassword)){
			JOptionPane.showMessageDialog(this, "«ÎÃÓ–¥√‹¬Î!");
			return;
		}
		System.out.println(studentClassComboBox.getSelectedItem());
		String classInfo = studentClassComboBox.getSelectedItem().toString();
		String sex = studentSexManRadioButton_1.isSelected() ? studentSexManRadioButton_1.getText() :studentSexFemalRadioButton_1.getText();
		Student student = new Student();
		student.setName(studentName);
		// …Ë÷√∞‡º∂id
		student.setClassId(Integer.valueOf(classInfo.split("_")[0]));
		student.setPassword(studentPassword);
		student.setSex(sex);
		StudentDao studentDao = new StudentDao();
		if(studentDao.addStudent(student)){
			JOptionPane.showMessageDialog(this, "ÃÌº”≥…π¶!");
		}else{
			JOptionPane.showMessageDialog(this, "ÃÌº” ß∞‹!");
		}
		resetValue(ae);
	}
	private void setStudentClassInfo(){
		ClassDao classDao = new ClassDao();
		List<StudentClass> classList = classDao.getClassList(new StudentClass());
		for (StudentClass sc : classList) {
//			studentClassComboBox.addItem(sc);
		}
		classDao.closeDao();
	}
}

