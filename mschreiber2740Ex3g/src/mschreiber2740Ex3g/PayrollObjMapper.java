package mschreiber2740Ex3g;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.DefaultListModel;

public class PayrollObjMapper {
	
	private String fileName;
	private PrintWriter outputFile;
	private Scanner inputFile;
	private File file;
	
	
	public PayrollObjMapper(String fileName) {
		this.fileName = fileName;
	}	
		
	public boolean openInputFile()	{
		boolean fileOpened = false;
		
		// Open the file.
	    try {
	    	File file = new File(this.fileName);
			fileOpened = file.exists();
			
			if (fileOpened){
				//Open the file
				this.inputFile = new Scanner (file);
			}	    
	    }
	    catch (IOException e) {}
	    
		return fileOpened;
	}
	
	public boolean openOutputFile() {
		boolean fileOpened = false;
		// Open the file.
	    try {
	    	this.outputFile = new PrintWriter (fileName); 
			fileOpened = true;
	    }	
			
	    catch (IOException e) {}
	    
		return fileOpened;
		
	}
	
	
		
		
	public DefaultListModel getAllPayroll(){
		
		DefaultListModel payrollCollection = new DefaultListModel();
		
		if(this.openInputFile())
		{
			while (this.inputFile.hasNext()) {
				Payroll p = this.getNextPayroll();
				if (p != null)
				payrollCollection.addElement(p);
			}
		}
		
		this.closeInputFile();
		return payrollCollection;
		
	}
		
	
	public void closeInputFile() {
		if(this.inputFile !=null) this.inputFile.close();
	}
		
	public Payroll getNextPayroll() {
		Payroll p = null;
		
		int id = 0;
		String name = "";
		double payRate = 0.0;
		double hours = 0.0;
		
		try {
			String textLine = inputFile.nextLine();
			id = Integer.parseInt(textLine);
			name = inputFile.nextLine();
			textLine = inputFile.nextLine();
			payRate = Double.parseDouble(textLine);
			textLine = inputFile.nextLine();
			hours = Double.parseDouble(textLine);
			p = new Payroll(id, name, payRate, hours);
		}
		
		catch (NoSuchElementException e) {}
		catch (NumberFormatException e) {}
		
		return p;
	}
		
	public void closeOutputFile() {
		if(this.outputFile !=null) this.outputFile.close();
	}
	
	public void writeAllPayroll(DefaultListModel payrollCollection) {
		if (this.openOutputFile()){
			
			
		}
		this.closeOutputFile();
	}
		
		
	//after adding the closeOutput file and writeAllPayroll I cannot get the listModel to populate
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
