package swingPractice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Library_ModifyingTable extends JFrame {

	
	private DefaultTableModel model = new DefaultTableModel();
	
	private JTable table = new JTable(model);
	
	private JButton jbtAddRow = new JButton("행 추가");
	private JButton jbtAddColumn = new JButton("열 추가");
	private JButton jbtDeleteRow = new JButton("행 삭제");
	private JButton jbtDeleteColumn = new JButton("열 삭제");
	
	private JButton jbtSave = new JButton("저장");
	private JButton jbtBack = new JButton("돌아가기");
	private JTextField jbtText_bookMakerName = new JTextField(10);
	private JTextField jbtText_bookName = new JTextField(10);
	private JButton jbtSearch = new JButton("검색");
	
	public static String login_bookMakerName;
	public static String login_bookName;
	public static String login_bookCompany;

	public Library_ModifyingTable() {
		
		model.addColumn("도서명");
		model.addColumn("저자");
		model.addColumn("출판일");
        
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\userinfo\\memberinformation.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                model.addRow(parts); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        

		table.setShowGrid(true);
		table.setGridColor(Color.BLACK);
		
		setTitle("JTable Demo");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p1 = new JPanel(new GridLayout(2, 2));
		p1.add(jbtAddRow);
		p1.add(jbtAddColumn);
		p1.add(jbtDeleteRow);
		p1.add(jbtDeleteColumn);
		
		JPanel p2 = new JPanel();
		p2.add(jbtText_bookMakerName);
		p2.add(jbtText_bookName);
		p2.add(jbtSearch);
		p2.add(jbtSave);
		p2.add(jbtBack);
		
		JPanel p3 = new JPanel(new BorderLayout());
		p3.add(p2, BorderLayout.CENTER);
		p3.add(p1, BorderLayout.SOUTH);
		
		add(new JScrollPane(table), BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		
		setVisible(true);
		jbtAddRow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() >= 0) {
					model.insertRow(table.getSelectedRow(), new Vector<String>());
				} else {
					model.addRow(new Vector<String>());
				}
			}
		});
		
		jbtAddColumn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("추가할 열의 이름을 입력해주세요");
				model.addColumn(name);
			}
		});
		
		jbtDeleteRow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int result = JOptionPane.showConfirmDialog(null, "삭제 하시겠습니까?", "삭제", JOptionPane.YES_NO_CANCEL_OPTION);
				
				if(result==JOptionPane.YES_NO_OPTION) {
					if(table.getSelectedRow() >= 0) {
						model.removeRow(table.getSelectedRow());
					}
				}
			}
		});
		
		jbtDeleteColumn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int result = JOptionPane.showConfirmDialog(null, "삭제 하시겠습니까?", "삭제", JOptionPane.YES_NO_CANCEL_OPTION);
				
				if(result==JOptionPane.YES_NO_OPTION) {
					if(table.getSelectedColumn() >= 0) {
						TableColumnModel columnModel = table.getColumnModel();
						TableColumn column = columnModel.getColumn(table.getSelectedColumn());
						columnModel.removeColumn(column);
					}
				}
			}
		});
		
		jbtSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String bookMakerName = jbtText_bookMakerName.getText().trim();
				String bookName = jbtText_bookName.getText().trim();
//				
				if (bookMakerName.length() == 0 && bookName.length() == 0) {
				    JOptionPane.showMessageDialog(null, "저자명을 입력하셔야 됩니다.", "저자명을 입력하세요!", JOptionPane.DEFAULT_OPTION);
				}
				
				try {
					BufferedReader bufferdreader = new BufferedReader(new FileReader("C:\\userinfo\\memberinformation.txt"));
					String str;
					List<String> infoList = new ArrayList<String>(); 
					while((str = bufferdreader.readLine()) != null) {   
						infoList.add(str);
					}
				        
					bufferdreader.close(); 
					
					boolean loginOk = false;

					for(String info : infoList) {
						String [] splitText = info.split("\\|");
						String info_bookMakerName = splitText[0];
						String info_bookName = splitText[1];
						String info_bookCompany = splitText[2];
						
						if (bookMakerName.equals(info_bookMakerName) || bookName.equals(info_bookName)) {
							loginOk = true; 
							login_bookMakerName = info_bookMakerName;
							login_bookName = info_bookName;
							login_bookCompany = info_bookCompany;
						}
					}
					JOptionPane jo = new JOptionPane();
					if(loginOk ==true) {
						jo.showMessageDialog(null, bookMakerName + bookName + "과 관련된 도서입니다.");
						setVisible(false);
						
						Library_RerultBookInfo library_RerultBookInfo = new Library_RerultBookInfo();
						library_RerultBookInfo.setVisible(true);
					}
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		jbtSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int rowCount = model.getRowCount();
				List<Object[]> allRows = new ArrayList<>();

				for (int i = 0; i < rowCount; i++) {
				    Object[] rowData = new Object[model.getColumnCount()];
				    for (int j = 0; j < model.getColumnCount(); j++) {
				        rowData[j] = model.getValueAt(i, j);
				    }
				    allRows.add(rowData);
				}
				
				String fileName = "C:\\userinfo\\memberinformation.txt" ;
				try {
					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,false));
				    for (Object[] row : allRows) {
				        StringBuilder rowStr = new StringBuilder();
				        for (Object cell : row) {
				            if (cell instanceof Integer || cell instanceof Double) {
				                rowStr.append(cell.toString());
				            } else {
				                rowStr.append(cell.toString());
				            }
				            rowStr.append("|");
				        }
				        rowStr.deleteCharAt(rowStr.length() - 1); 
				        bufferedWriter.write(rowStr.toString());
				        bufferedWriter.newLine(); 
				    }

				    bufferedWriter.flush();
				    bufferedWriter.close();
				    
				} catch(Exception ex) {
					
				}
				JOptionPane.showMessageDialog(null, "저장되었습니다.");
				
			}
			
			
		});
		
		jbtBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			Library_mainpage library_mainpage = new Library_mainpage();
			library_mainpage.setVisible(true);
			}
		});
		
	}
	
}