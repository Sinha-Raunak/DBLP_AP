//***************************************
//          Author tag
//Raunak Sinha-2015075
//Ishbir Walia-2015041
//****************************************

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.TableModel;
import javax.swing.table.AbstractTableModel;
public class myTable extends AbstractTableModel{
	private Object[][] data = new String[20][8];
	private String count;
	private int counting;
	private int xcounter;
	public myTable(ArrayList<Data> dataset,int counterInp){
		xcounter = counterInp;
		counting = 0;
		setCount(xcounter);
		if(dataset != null){
		for(Data k:dataset){
			data[counting][0] = count;
			data[counting][1] = k.getStringAuthors();
			data[counting][2] = k.getTitle();
			data[counting][3] = k.getPages();
			data[counting][4] = k.getStringYear();
			data[counting][5] = k.getVolume();
			data[counting][6] = k.getJournal();
			data[counting][7] = k.getURl();
			counting ++;
			xcounter++;
			setCount(xcounter);
		}
	}
	}
	private String[] columnNames = { "Serial No,", "Authors", "Title","Pages", "Year","Volume","Journal","URL" };
	public int getColumnCount() {
		return columnNames.length;
	}
	public int getRowCount() {
	      return data.length;
	 }
	 public String getColumnName(int col) {
	      return columnNames[col];
	 }
	public Object getValueAt(int row, int col) {
	      return data[row][col];
	   }
	private void setCount(int s){
		count =  Integer.toString(s);
	}
}



