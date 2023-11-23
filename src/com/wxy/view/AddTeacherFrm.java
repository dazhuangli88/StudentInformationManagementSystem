package com.wxy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.wxy.dao.TeacherDao;
import com.wxy.model.Teacher;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddTeacherFrm extends JFrame {
	private JTextField teacherNameTextField;
	private JTextField teacherTitleTextField;
	private JTextField teacherAgeTextField;
	private JButton submitButton;
	private JButton resetButton;
	private JRadioButton teacherSexManRadioButton;
	private JRadioButton teacherSexFemaleRadioButton;
	private JTextField passwordTextField;
	private TeacherDao teacherDao = new TeacherDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacherFrm frame = new AddTeacherFrm();
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
	public AddTeacherFrm() {
		setTitle("\u6DFB\u52A0\u6559\u5E08");
		setBounds(100, 100, 445, 334);
		
		JLabel lblNewLabel = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		lblNewLabel.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/image/\u8001\u5E08.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u6559\u5E08\u6027\u522B\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/image/\u6027\u522B.png")));
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("\u6559\u5E08\u804C\u79F0\uFF1A");
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		lblNewLabel_2.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/image/\u804C\u79F0.png")));
		
		JLabel lblNewLabel_3 = new JLabel("\u6559\u5E08\u5E74\u9F84\uFF1A");
		lblNewLabel_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		lblNewLabel_3.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/image/\u5E74\u9F84.png")));
		
		submitButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitTeacherInfo(e);
			}
		});
		submitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		
		resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTeacherInfo(e);
			}
		});
		resetButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		
		teacherNameTextField = new JTextField();
		teacherNameTextField.setColumns(10);
		
		teacherSexManRadioButton = new JRadioButton("\u7537");
		teacherSexManRadioButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		teacherSexManRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherSexManRadioButton.setSelected(true);
				teacherSexFemaleRadioButton.setSelected(false);
			}
		});
		
		teacherSexFemaleRadioButton = new JRadioButton("\u5973");
		teacherSexFemaleRadioButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		teacherSexFemaleRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherSexManRadioButton.setSelected(false);
				teacherSexFemaleRadioButton.setSelected(true);
			}
		});
		
		teacherTitleTextField = new JTextField();
		teacherTitleTextField.setColumns(10);
		
		teacherAgeTextField = new JTextField();
		teacherAgeTextField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		lblNewLabel_4.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/image/\u5BC6\u7801.png")));
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordTextField, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
								.addComponent(teacherNameTextField, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
								.addComponent(teacherAgeTextField, 208, 208, 208)
								.addComponent(teacherTitleTextField, 208, 208, 208)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(teacherSexManRadioButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(teacherSexFemaleRadioButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addGap(55))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(teacherSexFemaleRadioButton)
						.addComponent(teacherSexManRadioButton))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(teacherTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(teacherAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton)
						.addComponent(submitButton))
					.addGap(18))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void resetTeacherInfo(ActionEvent e) {
		teacherNameTextField.setText("");
		teacherTitleTextField.setText("");
		teacherAgeTextField.setText("");
		passwordTextField.setText("");
		teacherSexManRadioButton.setSelected(false);
		teacherSexFemaleRadioButton.setSelected(false);
	}

	protected void submitTeacherInfo(ActionEvent e) {
		Teacher teacher = new Teacher();
		teacher.setName(teacherNameTextField.getText());
		teacher.setTitle(teacherTitleTextField.getText());
		teacher.setAge(Integer.parseInt(teacherAgeTextField.getText()));
		teacher.setPassword(passwordTextField.getText());
		if (teacherSexManRadioButton.isSelected()) {
			teacher.setSex(teacherSexManRadioButton.getText());
		} else {
			teacher.setSex(teacherSexFemaleRadioButton.getText());
		}
		boolean result = teacherDao.addTeacher(teacher);
		if (result) {
			JOptionPane.showMessageDialog(this, "ÐÂÔö½ÌÊ¦ÐÅÏ¢³É¹¦£¡");
		} else {
			JOptionPane.showMessageDialog(this, "ÐÂÔö½ÌÊ¦ÐÅÏ¢Ê§°Ü£¡");
		}
	}
}
