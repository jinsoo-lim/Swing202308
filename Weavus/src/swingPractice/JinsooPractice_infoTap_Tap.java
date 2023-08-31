package swingPractice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JinsooPractice_infoTap_Tap extends JFrame {
	
    private JComboBox<String> comboBox;
    private JLabel comboBoxlavel = new JLabel("회원선택:");
    private JLabel idText = new JLabel("아이디:");
    private JLabel pwText = new JLabel("비밀번호:");
    private JLabel nameText = new JLabel("이름:");
    private JLabel birthYearText = new JLabel("생일 년도:");
    private JLabel birthMonthContent = new JLabel("생일 월자:");
    private JLabel birthDayText = new JLabel("생일 일자:");
    private JLabel phoneNumberText = new JLabel("휴대폰 번호:");
    private JButton cancelbtn = new JButton("돌아가기");
    private List<String> infoList;

    public JinsooPractice_infoTap_Tap() {
    	
        infoList = new ArrayList<>(); // 데이터를 저장할 리스트 초기화

        // 파일에서 데이터를 읽어와서 infoList 리스트에 저장
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\userinfo\\memberinfo.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                infoList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // JComboBox 생성 및 데이터 설정
        comboBox = new JComboBox<>();
        for (String info : infoList) {
            String[] splitText = info.split("\\|");
            String infold = splitText[0];
            comboBox.addItem(infold); // 콤보박스에 아이디 추가
        }

        // JComboBox 이벤트 처리
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = (String) comboBox.getSelectedItem();
                // 선택된 항목을 처리하는 코드 작성
                // 여기서는 선택된 아이디에 해당하는 정보를 표시합니다.
                for (String info : infoList) {
                    String[] splitText = info.split("\\|");
                    String infold = splitText[0];
                    if (infold.equals(selectedValue)) {
                        // 선택된 아이디에 해당하는 정보를 표시
                        idText.setText("아이디:           " + infold);
                        pwText.setText("비밀번호:           " + splitText[1]);
                        nameText.setText("이    름:           " + splitText[3]);
                        birthYearText.setText("생일 년도:           " + splitText[4]);
                        birthMonthContent.setText("생일 월자:           " + splitText[5]);
                        birthDayText.setText("생일 일자:           " + splitText[6]);
                        phoneNumberText.setText("휴대폰 번호:         " + splitText[7]);
                        break;
                    }
                }
            }
        });
       

        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new JinsooPractice_MainFrame().setVisible(true);
            }
        });
        
        JPanel infoPanel = new JPanel(new GridLayout(6,6));
        // JFrame 설정
        setTitle("회원 정보");
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        infoPanel.add(comboBoxlavel);
        infoPanel.add(comboBox);
        infoPanel.add(idText);
        infoPanel.add(pwText);
        infoPanel.add(nameText);
        infoPanel.add(birthYearText);
        infoPanel.add(birthMonthContent);
        infoPanel.add(birthDayText);
        infoPanel.add(phoneNumberText);
        infoPanel.add(cancelbtn);
        
        add(infoPanel);

    }

    public static void main(String[] args) {
        new JinsooPractice_infoTap_Tap();
    }
}
