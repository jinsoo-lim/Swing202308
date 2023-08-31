package swingPractice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JinsooPractice_MainFrame extends JFrame {
	
	 JinsooPractice_MainFrame(){
		JPanel infoPanel = new JPanel(new GridLayout(3,1));
		  JButton infobtn = new JButton("내 정보 보기");
		  JButton infoAllbtn = new JButton("전체 회원 보기");
		  JButton logoutbtn = new JButton("로그아웃");
		 
		 setTitle("메인화면");
			
	 		
	 	 this.setSize(300,500);	
		 this.setLocationRelativeTo(null);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			infoPanel.add(infobtn);	
			infoPanel.add(infoAllbtn);
			infoPanel.add(logoutbtn);
			
			add(infoPanel);
			
			
			infobtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					JinsooPractice_modifyPage_main goingSignIn = new JinsooPractice_modifyPage_main();
					goingSignIn.setVisible(true);
				}
			});
			infoAllbtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					JinsooPractice_infoTap_Tap jinsooPractice_infoTap = new JinsooPractice_infoTap_Tap();
					jinsooPractice_infoTap.setVisible(true);
					
				}
			});
			
			logoutbtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					int result = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "로그아웃", JOptionPane.YES_NO_CANCEL_OPTION);
					
					if(result==JOptionPane.YES_NO_OPTION) {
						setVisible(false);
						new JinsooPractice_LoginIn();
					}
				}
			});
	 }
	 
	    
	    
	 
}
