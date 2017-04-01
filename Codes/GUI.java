//***************************************
//          Author tag
//Raunak Sinha-2015075
//Ishbir Walia-2015041
//****************************************

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class GUI {
	private JFrame startingFrame;
	private JFrame Frame2;
	private JPanel thePanel;// Panel for first option frame --> Frame Layout 
	private JPanel newPanelEast;// Panel for subsequent queries --> Border Layout
	private JPanel newPanelWest;
	private JPanel newPanelNorth;
	private JPanel newPanelSouth;
	private JPanel newPanelCentre;
	private JButton sortByDate;
	private JButton sortByRelevence ;
	private JButton sortGivenYear ;
	private JButton sortInbetweenTwoYear;
	private static JTextField searchTag1;
	private static JTextField searchTag2;
	private static JTextField searchTag3;
	private static JTextField searchTag4;
	private static JTextField searchTag5;
	private static JTextField searchTag6;
	private static JTextField F3searchTag1;
	private static JTextField F3searchTag2;
	private JButton done ;
	private int check;
	private String toSend;
	private JLabel progress;
	private JLabel EnterTitle;
	private JLabel EnterName;
	private JLabel Name1;
	private JLabel Name2;
	private JLabel Name3;
	private JLabel Name4;
	private JLabel Name5;
	private JLabel Date;
	private JButton Exit;
	private JButton Next;
	private int searchType;
	private Entity entityList =new Entity();
	private Search Query1Search=new Search();
	private JFrame Frame3;
	private JLabel Frame3Label;
	private String year1;
	private String year2;
	private ArrayList<Data> MYdataSet;
	private ArrayList<String> MYstringList;
	private int xcounter;
	private Publication Query2 = new Publication(entityList);
	private int c;
	private JLabel resultCount = new JLabel("Displaying Result Count");
	public GUI(){
		//basicInitialise();
		initiateGUI();
	}
	public void initiateGUI(){
		c = 0;
		xcounter = 0;
		searchType = 0;
		check = 0;// Default check value no sorting 
		toSend = "";
		JPanel HelloPanel = new JPanel();
		JLabel text = new JLabel();
		text.setText("DBPL Query Engine");
		text.setForeground(Color.BLACK);
		text.setSize(100, 100);
		text.setLocation(100, 100);
		HelloPanel.add(text);
		HelloPanel.setBackground(Color.WHITE);
		JButton Query1 = new JButton("Query 1");
		
		Query1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent Event){
				forQuery1();
			}
		});
		JButton Query2 = new JButton("Query 2");
		Query2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent Event){
				forQuery2();
			}
		});
		JButton Query3 = new JButton("Query 3");
		Query3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent Event){
				forQuery3();
			}
		});
		
		Exit = new JButton("Exit");
		Exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent Event){
				System.exit(0);
			}
		});
		//JPanel 
		JPanel Explaining = new JPanel();
		Explaining.setBackground(Color.WHITE);
		Explaining.setLayout(new BoxLayout(Explaining,BoxLayout.PAGE_AXIS));;
		JLabel Query1Explained = new JLabel("Query1 : Choose Query1 to search publications either by author name or title");
		JLabel Query2Explained = new JLabel("Query2 : Find Name of Authors whith more than <K> pubications");
		JLabel Query3Explained = new JLabel("Query3 : Using Prediction");
		Explaining.add(Query1Explained);
		Explaining.add(Query2Explained);
		Explaining.add(Query3Explained);
		thePanel = new JPanel();
		thePanel.setSize(800, 800);
		thePanel.setLayout(new FlowLayout());
		thePanel.add(Query1);
		thePanel.add(Query2);
		//thePanel.add(Query3);
		thePanel.add(Exit);
		thePanel.setBackground(Color.BLACK);
		startingFrame = new JFrame("Base Frame For deciding Type of Query");
		startingFrame.setSize(1000,1000);
	    startingFrame.setLayout(new GridLayout(3,1));
	    startingFrame.add(HelloPanel);
	    startingFrame.add(thePanel);
	    startingFrame.add(Explaining);
	    startingFrame.setBackground(Color.BLACK);
	    startingFrame.setDefaultCloseOperation(startingFrame.EXIT_ON_CLOSE);
	    startingFrame.setLocationRelativeTo(null);
	    startingFrame.setVisible(true);
	}
	private void forQuery1(){
		commonForAll();
		Next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				callTable();
			}
		});
		done.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
			MYdataSet = new ArrayList<Data>();
			System.out.println(searchTag1.getText());
				System.out.println(searchTag2.getText());
				toSend = searchTag1.getText();
				if(toSend.equals("") == true){
					toSend = searchTag2.getText();
					if(toSend.equals("") == true)
						progress.setText("<Both feilds cannot be empty>");
					else {
						if(searchType == 1){
							int y1 = Integer.parseInt(year1);
							MYdataSet = Query1Search.searchTitleAfter(toSend, y1);
						}
						else  if(searchType == 2){
							int y1 = Integer.parseInt(year1);
							int y2 = Integer.parseInt(year2);
							MYdataSet = Query1Search.searchTitleBetween(toSend, y1, y2);
						}
						else if(searchType == 0) {
							MYdataSet = Query1Search.searchTitleandType(toSend, check);
						}
					}
				}
				else {
					if(searchType == 1){
						int y1 = Integer.parseInt(year1);
						MYdataSet = Query1Search.searchAuthorAfter(toSend, entityList, y1 );
					}
					else  if(searchType == 2){
						int y1 = Integer.parseInt(year1);
						int y2 = Integer.parseInt(year2);
						MYdataSet = Query1Search.searchAuthorBetween(toSend, entityList,y1,y2);
					}
					else if(searchType == 0) {
						MYdataSet = Query1Search.searchAuthorandType(toSend, entityList, check);
					}
				}
				resultCount.setText("Result Count == " + Integer.toString(MYdataSet.size()));
				callTable();
			}
			
		});
		newPanelWest.add(EnterName);
		newPanelWest.add(searchTag1);
		newPanelWest.add(EnterTitle);
		newPanelWest.add(searchTag2);
		newPanelWest.add(progress);
		newPanelWest.add(done);
		newPanelNorth.add(resultCount);
		Frame2activate();
	}
	private void forQuery2(){
		commonForAll();
		Next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				callTable1();
			}
		});
		newPanelWest.setLayout(new GridLayout(4,1));
		Frame2.setTitle("Query2");
		EnterName.setText("Enter number");
		newPanelWest.add(EnterName);
		newPanelWest.add(searchTag1);
		newPanelWest.add(progress);
		newPanelWest.add(done);
		done.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				System.out.println(searchTag1.getText());
				//System.out.println(searchTag2.getText());
				toSend = searchTag1.getText();
				int k = Integer.parseInt(toSend);
				if(toSend.equals("") == true){
					progress.setText("<<<Feild cannot be empty>>>");
				}
				else {
					MYstringList = Query2.SearchMoreThan(k);
					resultCount.setText("Result Count == " + Integer.toString(MYstringList.size()));
					System.out.println("------" + MYstringList.size() + "-------");
					callTable1();
					
				}
				xcounter = 0;
				
			}
		});
		newPanelNorth.add(resultCount);
		newPanelSouth.removeAll();
		Frame2activate();
	}
	
	
	private void forQuery3(){
		commonForAll();
		Frame2.setTitle("Query3");
		newPanelWest.setLayout(new GridLayout(12,1));
		Date.setText("Set Year");
		Name1.setText("Name 1");
		Name2.setText("Name 2");
		Name3.setText("Name 3");
		Name4.setText("Name 4");
		Name5.setText("Name 5");
		progress.setText("Enter all feilds");
		newPanelWest.add(Date);
		newPanelWest.add(searchTag1);
		newPanelWest.add(Name1);
		newPanelWest.add(searchTag2);
		newPanelWest.add(Name2);
		newPanelWest.add(searchTag3);
		newPanelWest.add(Name3);
		newPanelWest.add(searchTag4);
		newPanelWest.add(Name4);
		newPanelWest.add(searchTag5);
		newPanelWest.add(Name5);
		newPanelWest.add(searchTag6);
		newPanelWest.add(progress);
		done.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				//According to fucntionality
			}
		});
		newPanelWest.add(done);
		newPanelNorth.add(resultCount);
		Frame2activate();
	}	
	private void commonForAll(){
		Exit = new JButton("Exit");
		Date = new JLabel();
		Name1 = new JLabel();
		Name2 = new JLabel();
		Name3 = new JLabel();
		Name4 = new JLabel();
		Name5 = new JLabel();
		Date.setForeground(Color.WHITE);
		Name1.setForeground(Color.WHITE);
		Name2.setForeground(Color.WHITE);
		Name3.setForeground(Color.WHITE);
		Name4.setForeground(Color.WHITE);
		Name5.setForeground(Color.WHITE);
		EnterName = new JLabel("Enter Name ---->");
		EnterTitle = new JLabel("Enter Title ---> ");
		EnterName.setForeground(Color.WHITE);
		EnterTitle.setForeground(Color.WHITE);
		Frame2 = new JFrame();
		Frame2.setSize(1000, 1000);
		Frame2.setLocationRelativeTo(null);
		newPanelNorth = new JPanel();
		newPanelSouth = new JPanel();
		newPanelEast = new JPanel();
		newPanelWest = new JPanel();
		newPanelCentre = new JPanel();
		Frame2.setTitle("Query1");
		Frame2.setLayout(new BorderLayout());
		//Frame2.removeAll();
		sortByDate = new JButton("Sort By Date");
		sortByRelevence = new JButton("Sort By Relevence");
		sortGivenYear = new JButton("Sort by Given Year");
		sortInbetweenTwoYear= new JButton("Sort Inbetween Two Year"); 
		sortByDate.addActionListener(new ActionListener(){//Action Listners
			public void actionPerformed(ActionEvent Event){
				sortInbetweenTwoYear.setEnabled(false);
				sortByRelevence.setEnabled(false);
				sortGivenYear.setEnabled(false);
				check = 1;
			}
		});
		sortByRelevence.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent Event){
				sortByDate.setEnabled(false);
				sortInbetweenTwoYear.setEnabled(false);
				sortGivenYear.setEnabled(false);
				check = 2;
			}
		});
		sortGivenYear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent Event){
				Frame3 = new JFrame();
				sortByDate.setEnabled(false);
				sortInbetweenTwoYear.setEnabled(false);
				sortByRelevence.setEnabled(false);
				searchType = 1;//Change
				Frame3.setTitle("From a given year");
				JPanel panelHere = new JPanel();
				JLabel first = new JLabel("Enter Year");
				Frame3Label = new JLabel();
				F3searchTag1 = new JTextField();
				F3searchTag1.setText("");
				JButton doneNew = new JButton("done");
				doneNew.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent Event){
						if(F3searchTag1.getText().equals("") == true){
							Frame3Label.setText("Feilds cannot be empty");
						}
						else{
							year1 = F3searchTag1.getText();
							Frame3.dispose();
						}
					}
				});
				panelHere.setLayout(new GridLayout(4,1));
				panelHere.add(first);
				panelHere.add(F3searchTag1);
				panelHere.add(Frame3Label);
				panelHere.add(doneNew);
				Frame3.add(panelHere);
				Frame3.setLocationRelativeTo(null);
				Frame3.setSize(400,400);
				Frame3.setVisible(true);
			}
		});
		sortInbetweenTwoYear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent Event){
				Frame3 = new JFrame();
				sortByDate.setEnabled(false);
				sortGivenYear.setEnabled(false);
				sortByRelevence.setEnabled(false);
				searchType = 2;//Change
				Frame3Label = new JLabel();
				F3searchTag1 = new JTextField();
				F3searchTag2 = new JTextField();
				Frame3.setTitle("Set dates to choose between");
				JPanel panelHere = new JPanel();
				JLabel first = new JLabel("Enter starting Year");
				JLabel second = new JLabel("Enter ending  Year");
				F3searchTag1.setText("");
				F3searchTag2.setText("");
				JButton doneNew = new JButton("done");
				doneNew.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent Event){
						if(F3searchTag1.getText().equals("") == true || F3searchTag2.getText().equals("") == true){
							Frame3Label.setText("Feilds cannot be empty");
						}
						else {
							year1 = F3searchTag1.getText();
							year2 = F3searchTag2.getText();
							Frame3.dispose();
						}
					}
				});
				panelHere.setLayout(new GridLayout(6,1));
				panelHere.add(first);
				panelHere.add(F3searchTag1);
				panelHere.add(second);
				panelHere.add(F3searchTag2);
				panelHere.add(Frame3Label);
				panelHere.add(doneNew);
				Frame3.add(panelHere);
				Frame3.setLocationRelativeTo(null);
				Frame3.setSize(400,400);
				Frame3.setVisible(true);
			}
			
		});
		newPanelSouth.setBackground(Color.BLACK);
		newPanelSouth.add(sortByDate);
		newPanelSouth.add(sortByRelevence);
		newPanelSouth.add(sortGivenYear);
		newPanelSouth.add(sortInbetweenTwoYear);
		progress = new JLabel("Please fill in search feilds given");
		progress.setForeground(Color.WHITE);
		searchTag1 = new JTextField();
		searchTag2 = new JTextField();
		searchTag3 = new JTextField();
		searchTag4 = new JTextField();
		searchTag5  = new JTextField();
		searchTag6  = new JTextField();
		searchTag1.setText("");
		searchTag2.setText("");
		Next = new JButton("Next");
		Next.setToolTipText("Press for next 20 entries");
		JButton Restart = new JButton("Restart");
		Restart.setToolTipText("Different Kind of Searching");
		Restart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				Frame2.dispose();
				initiateGUI();
			}
		});
		Exit.setToolTipText("Exit");
		Exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		newPanelEast.setLayout(new BoxLayout(newPanelEast,BoxLayout.PAGE_AXIS));
		newPanelEast.setBackground(Color.BLACK);
		newPanelEast.add(Next);
		newPanelEast.add(Restart);
		newPanelEast.add(Exit);
		newPanelNorth.setBackground(Color.WHITE);
		done = new JButton("Done");
		done.setToolTipText("Press once Entered text for Input");
		newPanelWest.setBackground(Color.BLACK);
		newPanelWest.setLayout(new BoxLayout(newPanelWest , BoxLayout.PAGE_AXIS));
	}
	public void Frame2activate(){
		Frame2.getContentPane().add(BorderLayout.NORTH, newPanelNorth);
		Frame2.getContentPane().add(BorderLayout.SOUTH, newPanelSouth);
		Frame2.getContentPane().add(BorderLayout.WEST, newPanelWest);
		Frame2.getContentPane().add(BorderLayout.EAST, newPanelEast);
		Frame2.getContentPane().add(BorderLayout.CENTER, newPanelCentre);
		Frame2.setVisible(true);
		startingFrame.dispose();
		Frame2.setDefaultCloseOperation(Frame2.EXIT_ON_CLOSE);
		Frame2.setVisible(true);
	}
	public void Frame3basic(){
		
	}
	public void table(){
		JTable MyTable = new JTable();
		
	}
	
	private void callTable(){
		newPanelCentre.removeAll();
		System.out.println("Search size="+MYdataSet.size());
		ArrayList<Data> copy = new ArrayList<Data>();
		if( MYdataSet != null && MYdataSet.isEmpty() == false){
			int max = MYdataSet.size();
			if(MYdataSet.size() <  21){
				copy.removeAll(copy);
				for(int i=0 ; i < max ; i++){
					copy.add(MYdataSet.get(0));
					MYdataSet.remove(0);
					xcounter++;
					//c = xcounter - MYdataSet.size();
					c=0;
				}
				Next.setEnabled(false);
				}
			else{
				copy.removeAll(copy);
				for(int i = 0;i < 20 ; i++ ){
					copy.add(MYdataSet.get(0));
					MYdataSet.remove(0);
					xcounter++;
					c = xcounter - 20;
				}
				Next.setEnabled(true);
				}
			System.out.println("Should print on table now");
			JTable theTable = new JTable(new myTable(copy,c));
			theTable.setPreferredScrollableViewportSize(new Dimension(600, 600));
			theTable.setRowHeight(35);
			JScrollPane scrollPane = new JScrollPane(theTable);
			newPanelCentre.add(scrollPane);
			newPanelCentre.setBackground(Color.BLACK);
			newPanelCentre.repaint();
			newPanelCentre.revalidate();
			System.out.println("Table done");
			}
	}
	
	private void callTable1(){
		newPanelCentre.removeAll();
		System.out.println("Search size="+MYstringList.size());
		ArrayList<String> copy = new ArrayList<String>();
		
		if( MYstringList != null && MYstringList.isEmpty() == false){
			int max=MYstringList.size();
			if(MYstringList.size() <  21){
				//copy.removeAll(copy);
				for(int i=0 ; i < max  ; i++){
					copy.add(MYstringList.get(0));
					//System.out.println(copy.get(0));
					MYstringList.remove(0);
					xcounter ++;
					c = xcounter - copy.size();
				}
				Next.setEnabled(false);
				}
			else{
				copy.removeAll(copy);
				for(int i = 0;i < 20 ; i++ ){
					copy.add(MYstringList.get(0));
					MYstringList.remove(0);
					xcounter++;
					c = xcounter - 20;
				}
				Next.setEnabled(true);
				}
			System.out.println("Should print on table now");
			JTable theTable = new JTable(new myTable1(copy,c));
			System.out.println(copy.size());
			theTable.setRowHeight(35);
			theTable.setPreferredScrollableViewportSize(new Dimension(600, 600));
			JScrollPane scrollPane = new JScrollPane(theTable);
			newPanelCentre.add(scrollPane);
			newPanelCentre.setBackground(Color.BLACK);
			newPanelCentre.repaint();
			newPanelCentre.revalidate();
			System.out.println("Table done");
			}
	}
	
	/*public void basicInitialise(){ 
		Entity entityList =new Entity();
		Search s=new Search();
	}*/
	/*public void CallSearch(String sending,int method){
		ArrayList<Data> d=s.searchAuthorandType(sending, entityList,check);
		System.out.println("Size="+d.size());
	}*/
}
	




