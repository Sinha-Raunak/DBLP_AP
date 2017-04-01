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
public class myTable1 extends AbstractTableModel{
	private Object[][] data = new String[20][2];
	private String count;
	private int counting;
	private int xcounter;
	public myTable1(ArrayList<String> dataset,int countString){
		xcounter = countString;
		counting = 0;
		setCount(xcounter);
		if(dataset != null){
		for(String k:dataset){
			data[counting][0] = count;
			data[counting][1] = k;
			counting ++;
			xcounter++;
			setCount(xcounter);
		}
	}
	}
	private String[] columnNames = { "Serial No,", "Authors" };
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



