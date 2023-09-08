package swingPractice;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Library_RerultBookInfo extends JFrame  {
	
	 private JPanel signUpPanel = new JPanel(new GridLayout(3, 2));
	 private JPanel signUpPanel2 = new JPanel();
	 
	 private JLabel idText = new JLabel(Library_ModifyingTable.login_bookMakerName);
	 private JLabel pwText = new JLabel(Library_ModifyingTable.login_bookName);
	 private JLabel pwCheckText = new JLabel(Library_ModifyingTable.login_bookCompany);
	 private JButton cancelbtn = new JButton("돌아가기");
	
	 private JLabel idLavel = new JLabel("도서명");
	 private JLabel pwLavel = new JLabel("저자명");
	 private JLabel pwCheckLavel = new JLabel("출판사");
	 
	 
	 
	 

	 Library_RerultBookInfo(){

		 setTitle("");
			
		 	signUpPanel.add(idLavel);
			signUpPanel.add(idText);
			signUpPanel.add(pwLavel);
			signUpPanel.add(pwText);
			signUpPanel.add(pwCheckLavel);
			signUpPanel.add(pwCheckText);
			
			signUpPanel2.add(cancelbtn);
			
			JPanel p3 = new JPanel(new BorderLayout());
			p3.add(signUpPanel);
			p3.add(signUpPanel2);
			
			add(signUpPanel, BorderLayout.CENTER);
			add(signUpPanel2, BorderLayout.SOUTH);
			
			this.setSize(200,200);	
			this.setLocationRelativeTo(null);
			
			cancelbtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					Library_ModifyingTable goingMain = new Library_ModifyingTable();
					goingMain.setVisible(true);				
					}
			});
	 }
}
