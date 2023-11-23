package com.wxy.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.wxy.model.UserType;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Toolkit;

public class MainFrm extends JFrame {
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	// 当前登录用户类型
	public static UserType userType;
	// 当前登录用户信息对象
    public static Object userObject;
    
    private JMenuItem changePasswordMenuItem;
    private JMenuItem exitSystemMenuItem;
    private JMenuItem addStudentMenuItem;
    private JMenuItem listStudentMenuItem;
    private JMenuItem classAddMenuItem;
    private JMenuItem _2mangeClassMenuItem;
    private JMenuItem addTeacherMenuItem;
    private JMenuItem listTeacherMenuItem;
    private JMenuItem mntmNewMenuItem_5;
    
    private JMenu systemSettingsMenu_1;
    private JMenu manageStudentMenu_2;
    private JMenu mangeClassMenu_3;
    private JMenu manageTeacherMenu_4;
    private JMenu helpMenu_5;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrm frame = new MainFrm();
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
	public MainFrm(UserType userType,Object userObject) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/image/logo.png")));
		this.userType = userType;
		this.userObject = userObject;
		setTitle("\u5B66\u751F\u4FE1\u606F\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 586);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		systemSettingsMenu_1 = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		systemSettingsMenu_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
		systemSettingsMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u7CFB\u7EDF.png")));
		menuBar.add(systemSettingsMenu_1);
		
		changePasswordMenuItem = new JMenuItem("修改密码");
		changePasswordMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPassword(ae);
			}
		});
		changePasswordMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u4FEE\u6539\u5BC6\u7801.png")));
		systemSettingsMenu_1.add(changePasswordMenuItem);
		
		exitSystemMenuItem = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		exitSystemMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(MainFrm.this,"确定退出么？") == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		exitSystemMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u9000\u51FA.png")));
		systemSettingsMenu_1.add(exitSystemMenuItem);
		
		manageStudentMenu_2 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		manageStudentMenu_2.setFont(new Font("微软雅黑", Font.BOLD, 18));
		manageStudentMenu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u5B66\u751F.png")));
		menuBar.add(manageStudentMenu_2);
		
		addStudentMenuItem = new JMenuItem("\u5B66\u751F\u6DFB\u52A0");
		addStudentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentFrm frame = new AddStudentFrm();
				frame.setVisible(true);
			}
		});
		addStudentMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u6DFB\u52A0.png")));
		manageStudentMenu_2.add(addStudentMenuItem);
		
		listStudentMenuItem = new JMenuItem("\u5B66\u751F\u5217\u8868");
		listStudentMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u5217\u8868\u6A21\u5F0F.png")));
		manageStudentMenu_2.add(listStudentMenuItem);
		listStudentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageStudentFrm frame = new ManageStudentFrm();
				frame.setVisible(true);
			}
		});
		mangeClassMenu_3 = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		mangeClassMenu_3.setFont(new Font("微软雅黑", Font.BOLD, 18));
		mangeClassMenu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u73ED\u7EA7\u7BA1\u7406.png")));
		menuBar.add(mangeClassMenu_3);
		
		classAddMenuItem = new JMenuItem("\u73ED\u7EA7\u6DFB\u52A0");
		classAddMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addStudentClass(ae);
			}
		});
		classAddMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u6DFB\u52A0.png")));
		mangeClassMenu_3.add(classAddMenuItem);
		
		_2mangeClassMenuItem = new JMenuItem("\u73ED\u7EA7\u7BA1\u7406");
		_2mangeClassMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageClassFrm classManageFrm = new ManageClassFrm();
				classManageFrm.setVisible(true);
//			    desktopPane.add(classManageFrm);
			}
		});
		_2mangeClassMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u5217\u8868\u6A21\u5F0F.png")));
		mangeClassMenu_3.add(_2mangeClassMenuItem);
		
		manageTeacherMenu_4 = new JMenu("\u6559\u5E08\u7BA1\u7406");
		manageTeacherMenu_4.setFont(new Font("微软雅黑", Font.BOLD, 18));
		manageTeacherMenu_4.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u8001\u5E08.png")));		
		menuBar.add(manageTeacherMenu_4);
		
		addTeacherMenuItem = new JMenuItem("\u6559\u5E08\u6DFB\u52A0");
		addTeacherMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTeacherFrm addTeacherFrm= new AddTeacherFrm();
				addTeacherFrm.setVisible(true);
//			    desktopPane.add(addTeacherFrm);
			}
		});
		addTeacherMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u6DFB\u52A0.png")));
		manageTeacherMenu_4.add(addTeacherMenuItem);
		
		listTeacherMenuItem = new JMenuItem("\u6559\u5E08\u5217\u8868");
		listTeacherMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u5217\u8868\u6A21\u5F0F.png")));
		listTeacherMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageTeacherFrm manageTeacherFrm= new ManageTeacherFrm();
				manageTeacherFrm.setVisible(true);
//			    desktopPane.add(addTeacherFrm);
			}
		});
		manageTeacherMenu_4.add(listTeacherMenuItem);
		
		helpMenu_5 = new JMenu("\u5E2E\u52A9");
		helpMenu_5.setFont(new Font("微软雅黑", Font.BOLD, 18));
		helpMenu_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
			}
		});
		helpMenu_5.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u5E2E\u52A9.png")));
		menuBar.add(helpMenu_5);
		
		mntmNewMenuItem_5 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abouUs(e);
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/image/\u5173\u4E8E\u6211\u4EEC.png")));
		helpMenu_5.add(mntmNewMenuItem_5);
		
//		contentPane = new JPanel();
//		setContentPane(contentPane);
//		
//		desktopPane = new JDesktopPane();
//		contentPane.add(desktopPane, BorderLayout.CENTER);
		// 设置权限
		setAuthority();
	}

	protected void addStudentClass(ActionEvent ae) {
		// TODO Auto-generated method stub
		AddStudentClassAddFrm sca = new AddStudentClassAddFrm();
		sca.setVisible (true);
//		desktopPane.add(sca);
	}

	protected void editPassword(ActionEvent ae) {
		// TODO Auto-generated method stub
		EditPasswordFrm editPasswordFrm = new EditPasswordFrm();
		editPasswordFrm.setVisible(true);
//		desktopPane.add(editPasswordFrm);
	
	}

	protected void abouUs(ActionEvent ae) {
		// TODO Auto-generated method stub
		String info = "【李富贵】出品\n";
		info += "网址:https://www.gcc.edu.cn/\n";
		info += "欢迎报考黄浦区看守所!";
		JOptionPane.showMessageDialog(this, info);
	}

	 /**设置权限
	  * */
     private void setAuthority() {
    	 if("学生".equals(userType.getName())) {
    		 addStudentMenuItem.setEnabled(false);
    		 mangeClassMenu_3.setEnabled(false);
    		 manageTeacherMenu_4.setEnabled(false);
    	 }
    	 if("教师".equals(userType.getName())) {
    		addTeacherMenuItem.setEnabled(false);
    	 }
	   
   }
}