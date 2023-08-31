package swingPractice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JinsooPractice_LoginIn  extends JFrame{
	private JPanel loginPanel = new JPanel(new GridLayout(4,3));
	//멤버 변수
	private JLabel idLabel = new JLabel("아이디 "); 
	private JLabel pwLabel = new JLabel("비밀번호 ");
	private JTextField idText = new JTextField();
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("로그인");
	private JButton memberbtn = new JButton("회원가입");
	
	 	public static String login_id;
		public static String login_pw;
		public static String login_pwCheck;
		public static String login_name;
		public static String login_birthYear;
		public static String login_birthMonth;
		public static String login_birthDay;
		public static String login_phoneNumber;
	
	

	public JinsooPractice_LoginIn() {
//		super("로그인 창!");      //이거 이해가 안 되니까, 밑에 코드로 바꿔 씀.
		setTitle("로그인 창!");
		
		//this 는 클래스안의 객체라는 뜻. (여기는 같은 클래스안에 있다)
		this.setContentPane(loginPanel);
		loginPanel.add(idLabel);
		loginPanel.add(pwLabel);
		loginPanel.add(idText);
		loginPanel.add(pwText);
		loginPanel.add(loginBtn);
		loginPanel.add(memberbtn);
	
//		setSize(350,130);
		pack();
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//로그인 버튼을 눌렀을때
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idText.getText().trim();
				String pw = pwText.getText().trim();
				

				String login = "";
				
				if(id.length()==0 || pw.length()==0) {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디나 비번을 입력!", JOptionPane.DEFAULT_OPTION);
					return;
				}
				
				//텍스트 파일에 저장된 모든 글자를 가져온다 | 구분자로 아이디와 비번이 맞는게 있다면 로그인 시켜주면 된다.
				try {
					BufferedReader bufferdreader = new BufferedReader(new FileReader("C:\\userinfo\\memberinfo.txt"));
					  
					//한줄을 읽는다.
					String str;
					//한줄한줄 읽은 리스트를 생성한다.
					List<String> infoList = new ArrayList<String>(); 
					//읽어들인 줄에 정보가 있다면 str변수에 담는다. 읽어들인 줄에 정보가 없다면 처리를 중단한다.
					while((str = bufferdreader.readLine()) != null) {   //눌이 아니라면 = 값이 있다면
						infoList.add(str);
					}
				        
					bufferdreader.close(); //filereader 를 썼다면, 이걸로 닫아줘야함.
				        
					boolean loginOk = false;
					
					//infoList 배열에 들어간 값을 돌린다. 
					for(String info : infoList) {
						//값을 잘라서 빼낸다.
						String [] splitText = info.split("\\|");
						//배열을 빼내는 식
						//윗쪽에는 파일에서 빼내온 하나하나의 값이고
						//이건 한줄한줄 넣으면서 빼낸 값이다. 
						String infold = splitText[0];
						String infoPw = splitText[1];
//						String infoPwCheck = splitText[2];
						String infoName = splitText[3];
						String infobirthYear = splitText[4];
						String infobirthMonth = splitText[5];
						String infobirthDay = splitText[6];
						String infphoneNumber = splitText[7];
						
						if (id.equals(infold) && pw.equals(infoPw)) {
							loginOk = true; 
							login_id = infold;
							login_pw = infoPw;
//							login_pwCheck = infoPwCheck;
							login_name = infoName;
							login_birthYear = infobirthYear;
							login_birthMonth = infobirthMonth;
							login_birthDay = infobirthDay;
							login_phoneNumber = infphoneNumber;
							
						}

					}

					
					JOptionPane jo = new JOptionPane();
//					if(loginOk) {
					if(loginOk ==true) {
						jo.showMessageDialog(null, id + "님 환영합니다");
						setVisible(false);
						
						JinsooPractice_MainFrame goingSignIn = new JinsooPractice_MainFrame();
						goingSignIn.setVisible(true);
						
						
						
					}else {
						jo.showMessageDialog(null, "계정 정보를 확인해 주세요.");
					}
					
					
		        //뭐지..? errmsg 쓰니까 에러 없어짐
				} catch(Exception errmsg){
					errmsg.printStackTrace();
				}
				
			
				
			}
		});
				//회원가입 버튼을 눌렀을때
				memberbtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JinsooSwingPractice_SignUp signup = new JinsooSwingPractice_SignUp();
						signup.setVisible(true);
					}
				});
	}
			
		
	
	
	
	
	public static void main(String[] args) {
		
		new JinsooPractice_LoginIn();		
	}
}

