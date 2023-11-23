package com.wxy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.wxy.dao.ClassDao;
import com.wxy.model.StudentClass;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.nio.channels.NonWritableChannelException;
import java.awt.event.ActionEvent;

public class AddStudentClassAddFrm extends JFrame {
	private JTextField classNameTextField;
	private JTextArea classInfoTextArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentClassAddFrm frame = new AddStudentClassAddFrm();
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
	public AddStudentClassAddFrm() {
		setTitle("\u6DFB\u52A0\u73ED\u7EA7\u4FE1\u606F");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblNewLabel.setIcon(new ImageIcon(AddStudentClassAddFrm.class.getResource("/image/\u540D\u79F0.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u73ED\u7EA7\u4FE1\u606F\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(AddStudentClassAddFrm.class.getResource("/image/\u73ED\u7EA7\u4FE1\u606F.png")));
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		classNameTextField = new JTextField();
		classNameTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u63D0\u4EA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				 submitClass(ae);
			}
		});
		submitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		submitButton.setIcon(new ImageIcon(AddStudentClassAddFrm.class.getResource("/image/\u786E\u8BA4 .png")));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		resetButton.setIcon(new ImageIcon(AddStudentClassAddFrm.class.getResource("/image/\u91CD\u7F6E02.png")));
		resetButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel)
							.addComponent(lblNewLabel_1))
						.addComponent(submitButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(classInfoTextArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
						.addComponent(classNameTextField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
						.addComponent(resetButton))
					.addGap(87))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(classNameTextField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(classInfoTextArea, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(submitButton))
					.addGap(27))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void submitClass(ActionEvent ae) {
		// TODO Auto-generated method stub
		String classNameString = classNameTextField.getText();
		String classNameInfo = classInfoTextArea.getText();
		if(classNameString.isEmpty()) {
			JOptionPane.showMessageDialog(this, "°à¼¶Ãû³Æ²»ÄÜÎª¿Õ£¡");
		}
		StudentClass scl = new StudentClass();
		scl.setName(classNameString);
		scl.setInfo(classNameInfo);
		ClassDao classDao = new ClassDao();
		if(classDao.addClass(scl)) {
			JOptionPane.showMessageDialog(this, "°à¼¶Ìí¼Ó³É¹¦£¡");
		}else {
			
			JOptionPane.showMessageDialog(this, "°à¼¶Ìí¼ÓÊ§°Ü£¡");
		}
		resetValue(ae);
		return;
	}
	
	

	protected void resetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		classNameTextField.setText("");
		classInfoTextArea.setText("");
		
	}
}
