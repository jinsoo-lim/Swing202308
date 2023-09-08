package swingPractice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Library_mainpage extends JFrame {

	Library_mainpage(){
		JPanel infoPanel = new JPanel(new GridLayout(2,1));
		  JButton infoAllbtn = new JButton("도서 관리 페이지");
		  JButton logoutbtn = new JButton("로그아웃");
		 
		 setTitle("메인화면");   
			
	 		
	 	 this.setSize(300,300);	
		 this.setLocationRelativeTo(null);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			infoPanel.add(infoAllbtn);
			infoPanel.add(logoutbtn);
			
			add(infoPanel);
			
			
			infoAllbtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					Library_ModifyingTable library_ModifyingTable = new Library_ModifyingTable();
					library_ModifyingTable.setVisible(true);
					
				}
			});
			
			logoutbtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					int result = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "로그아웃", JOptionPane.YES_NO_CANCEL_OPTION);
					
					if(result==JOptionPane.YES_NO_OPTION) {
						setVisible(false);
						new Library_LoginIn();
					}
				}
			});
	}
}
