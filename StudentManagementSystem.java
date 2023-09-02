/*            To Login User ID:     CODSOFT */
/*				          PASS:     Task */

import java.awt.*;
import java.io.*;
import java.util.regex.*;
import java.awt.event.*;

public class StudentManagementSystem extends Frame implements WindowListener,ActionListener{
	
	Frame f1 ; 
	Button login,add,edit,show,delete,exit,submit,update,next1,search,okB;				
	TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
	Panel pnl,pnlX,pnlY,pnlA,pnlB,pnlC,pnlD,pnlE,pnl1,pnl2,pnl3,pnl4,pnl5,pnl6,p,p1,p2,p3,pH,pH1 ;			
	Dialog addStudent,notFound;	
	Color clr1,clr ;													
	Dimension d ;
	Label header,header1,l,lA,l1,l2,l2A,l3,l3A,l4,l5,l6,l7,l8,l9,a,a1,a2,a3,a4,a5,a6,n1,n2,notL;	
	Canvas c,c1;
	Object obj ;
	int strt,cnt, searchIndex,sIndex ;						boolean pass,updt,pass1 ;
	String opt,nam,ag,fa,mo,cl,ph,r1,r2,r3,r4,sDta,lId= "101";
	
	public 	StudentManagementSystem(){
		//MAIN FRAME....
		// Constructor: Initialize the main user interface and components
        // Set up the frame, buttons, labels, and panels.
        // Set event listeners for buttons. 
		
		f1 = new Frame(" User Dashboard ");										f1.setSize(1400, 880);
		f1.addWindowListener(this);								clr = new Color(101,150,150);	
		f1.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,30));
		clr1 = new Color(101,150,150);
		header1 = new Label("          Search Student : ",2);		
		f1.setBackground(clr);
		pH = new Panel();										pH.setLayout(new BorderLayout());
		pH1 = new Panel();										pH1.setLayout(new GridLayout(0,2));
		tf9 = new TextField("",10);			
		pH1.add(header1);										pH1.add(tf9);
		pH.add(pH1);									
		pnl = new Panel();										pnl.setLayout(new GridLayout(7,0));
		l7 = new Label("Options :            ");				
		add = new Button("New Student");						add.addActionListener(this);
		edit = new Button("Edit Student");						edit.addActionListener(this);
		delete = new Button("Delete Student");					delete.addActionListener(this);
		show = new Button("Show Student");						show.addActionListener(this);
		exit = new Button("Logout");							exit.addActionListener(this);
		search = new Button("Search");						search.addActionListener(this);
		pnl.add(l7);		pnl.add(add);		pnl.add(edit);		pnl.add(delete);
		pnl.add(show);		pnl.add(exit);		f1.add(pnl,"West");
		pH.add(search,"East");					
		f1.add(pH,"North");
		
			
		
		pnlE = new Panel();										pnlE.setLayout(new BorderLayout());
		f1.add(pnlE);		
		this.addWindowListener(this);							this.setSize(1400, 880);
		d = new Dimension() ;									d = this.getSize();
		pnl1 = new Panel();										pnl1.setLayout(new GridLayout(0,2));								
		pnl1.setBackground(clr1);
		l = new Label(" ");
		lA = new Label(" ");
		l1 = new Label("   Welcome To  ",Label.CENTER);
		l2 = new Label("  Student  ",Label.CENTER);
		l2A = new Label("  Management System  ",Label.CENTER);
		l1.setFont(new Font("Arial",Font.PLAIN+Font.BOLD,40));
		l2.setFont(new Font("Arial",Font.PLAIN+Font.BOLD,35));
		l2A.setFont(new Font("Arial",Font.PLAIN+Font.BOLD,35));
		
		pnl2 = new Panel();		
		pnl2.setLayout(new GridLayout(9,0));
		pnl2.setBackground(clr1);
		pnl2.add(l);
		pnl2.add(lA);
		pnl2.add(l1);
		pnl2.add(l2);
		pnl2.add(l2A);
		pnl1.add(pnl2);
		
		pnl3 = new Panel();
		pnl3.setLayout(new GridLayout(8,0));
		l3 = new Label("  Login User  ",1);
		l3A = new Label(" ");
		l3.setFont(new Font("Arial",Font.PLAIN+Font.BOLD,32));
		l4 = new Label("  User Id :       ",0);
		l4.setFont(new Font("Arial",Font.PLAIN+Font.BOLD,30));
		tf1 = new TextField(30);
		pnl4 = new Panel();
		pnl4.add(l4);
		pnl4.add(tf1);
		l5 = new Label("Password : ",0);
		l5.setFont(new Font("Arial",Font.PLAIN+Font.BOLD,30));
		tf2 = new TextField(30);
		pnl5 = new Panel();
		pnl5.add(l5);
		pnl5.add(tf2);
		l6 = new Label();
		pnl4.add(l6);
		pnl6 = new Panel();
		pnl6.setLayout(new FlowLayout());
		login = new Button("Login");
		login.setPreferredSize(new Dimension(80,40));
		login.addActionListener(this);
		pnl6.add(login);
		pnl3.add(l3A);											
		pnl3.add(l3);											
		pnl3.add(pnl4);											
		pnl3.add(pnl5);											
		pnl3.add(pnl6);
		pnl1.add(pnl3);
			
		this.add(pnl1);
		setVisible(true);
		
		notFound = new Dialog(this, " Not Found ", true);
			notFound.setLayout(new FlowLayout());          notFound.setSize(200, 100);
			notFound.addWindowListener(this);			   notFound.setLocation(d.width/2,d.height/2);
			okB = new Button("OK");					   	   okB.addActionListener(this); 
			notL = new Label();               	   
			notFound.add(notL);							   notFound.add(okB);
		
								
	}
	
		public void actionPerformed(ActionEvent e){
			String o = e.getActionCommand();
			switch(o){
				case "Login" :
				// User clicked the "Login" button, validate user credentials
										loginCheck();
										break;
									
				case "New Student" :
				// User clicked the "New Student" button, prepare for adding a new student
										remover();
										opt = "New";
										panelCreation();					
										break;
				
				case "Edit Student" :
										opt = "Update";
										notL.setText("  Enter Student Id & Press OK ");
										tf10 = new TextField(1);
										notFound.add(tf10);
										notFound.setVisible(true);	
										break;
								
				case "Delete Student" :						
										opt = "Delete";
										notL.setText("  Enter Student Id & Press OK ");
										tf10 = new TextField(1);
										notFound.add(tf10);
										notFound.setVisible(true);	
										break;
				case "Show Student" :						
										remover();
										opt = "Show";
										panelCreation();
										lId = "101";
										showDta();
										break;
								
				case "Logout" :
										f1.dispose();
										setVisible(true);	
										break;
				
				case "Submit" :
										validationCheck();	
										if(pass)
											adding();
										break;
										
				case "Update" :
										validationCheck();
										if(pass)
											dataReplace();
										break;
										
				case "Delete" :
										validationCheck();
										if(pass)
											dataReplace();
										break;
				
				case "Next" :
										lId = Integer.parseInt(lId) + 1 +"";
										opt = "Show";
										showDta();
										break;
				
				case "Search" :
										lId = tf9.getText();
										opt = "Search";
										showDta();
										break;
										
										
				case "OK" :
										addUpdateDta();
										break;						
				
				default :
										f1.setVisible(true);
			

			}
		}
		
		
		void loginCheck(){
			// Check if the provided user ID and password are valid
			if(!tf1.getText().equals("CODSOFT") && !tf2.getText().equals("Task")){
				notL.setText("   Invalid User Credentials");
				pass1 = false;
				notFound.setVisible(true);
			}
			else
			if(!tf1.getText().equals("CODSOFT")){
				notL.setText("     Invalid User Id");
				pass1 = false;
				notFound.setVisible(true);
			}
			else
			if(!tf2.getText().equals("Task")){
				notL.setText("     Invalid User Password");
				pass1 = false;
				notFound.setVisible(true);
			}
			else
			if(tf1.getText().equals("CODSOFT") && tf2.getText().equals("Task")){
				tf1.setText("");
				tf2.setText("");
				pass1 = true;
				remover();
				defaultPnl();
				this.dispose();	
				f1.setVisible(true);
			}	
		}
		
		
		
		void defaultPnl(){
			Label pnlTemp = new Label("                The Student Management System ",1) ;
			f1.add(pnlTemp);
		}
				
		public void remover(){
			Component [] comp = f1.getComponents();
			if(comp.length > 3){
				Component secPanl = comp[3];
				f1.remove(secPanl);
				f1.validate();
			}
		}
		
		
		private void panelCreation(){
			if(opt.equals("New")){
				pnlA = new Panel();										pnlA.setLayout(new BorderLayout());		
				pnlA.setBackground(clr1);								pnlA.setName("pnlA");
				pnlY = new Panel();										p = new Panel();											
				submit = new Button("Submit");							submit.addActionListener(this);	
				p.add(submit);	
				p1 = (Panel)panelAdd();									p1.add(p);
				lastId();
				a.setText(lId);
				pnlY.add(p1);											pnlA.add(pnlY);
				f1.add(pnlA);											f1.setVisible(true);
			}else
			if(opt.equals("Update")){
				
				pnlB = new Panel();										pnlB.setLayout(new BorderLayout());		
				pnlB.setBackground(clr1);								pnlB.setName("pnlB");
				pnlY = new Panel();										p = new Panel();
				update = new Button("Update");							update.addActionListener(this);
				p.add(update);	
				p1 = (Panel)panelAdd();									p1.add(p);
				a.setText(lId);			
				pnlY.add(p1);											pnlB.add(pnlY);
				f1.add(pnlB);											f1.setVisible(true);
				
			}else
			if(opt.equals("Delete")){
				pnlC = new Panel();										pnlC.setLayout(new BorderLayout());		
				pnlC.setBackground(clr1);								pnlC.setName("pnlC");
				pnlY = new Panel();										p = new Panel();
				delete = new Button("Delete");							delete.addActionListener(this);
				p.add(delete);	
				p1 = (Panel)panelAdd();									p1.add(p);
				a.setText(lId);	
				pnlY.add(p1);											pnlC.add(pnlY);
				f1.add(pnlC);											f1.setVisible(true);
			}else
			if(opt.equals("Show") || opt.equals("Search")){	

				pnlD = new Panel();										pnlD.setLayout(new BorderLayout());		
				pnlD.setBackground(clr1);								pnlD.setName("pnlD");
				pnlY = new Panel();										p = new Panel();
				show = new Button("Next");								show.addActionListener(this);
				p.add(show);	
				p1 = (Panel)panelAdd();									p1.add(p);
				pnlY.add(p1);											pnlD.add(pnlY);
				f1.add(pnlD);											f1.setVisible(true);
			}
		}
		
		
		
		
		public Object panelAdd(){
			pnlX = new Panel();									pnlX.setLayout(new GridLayout(15,0));
			a = new Label(" ");
			a1 = new Label("Student Name :");						a2 = new Label("Student Age :");
			a3 = new Label("Student Father's Name :");				a4 = new Label("Student Mother's Name :");
			a5 = new Label("Student Class :");						a6 = new Label("Student Contact :");
			tf3 = new TextField(40);								tf4 = new TextField(40);
			tf5 = new TextField(40);								tf6 = new TextField(40);
			tf7 = new TextField(40);								tf8 = new TextField(40);
			submit = new Button("Submit");
			f1.setFont(new Font("Arial",Font.PLAIN+Font.BOLD,20));
			Panel x = new Panel();									pnlX.add(a);
			pnlX.add(a1);											pnlX.add(tf3);	
			pnlX.add(a2);											pnlX.add(tf4);	
			pnlX.add(a3);											pnlX.add(tf5);	
			pnlX.add(a4);											pnlX.add(tf6);	
			pnlX.add(a5);											pnlX.add(tf7);	
			pnlX.add(a6);											pnlX.add(tf8);	
			pnlX.add(x);	
			return pnlX;			
		}
		
		
		
		
		
		
		
		
		void lastId(){
			try{
				File f1 = new File("StudentDta.txt");
				if(!f1.exists()){
					f1.createNewFile();
				}	
					FileReader fr = new FileReader(f1);		
					BufferedReader rdr = new BufferedReader(fr);
					String ln;
					while ((ln = rdr.readLine()) != null) {
						String[] parts = ln.split(",",2);
						if(parts.length > 0 && !parts[0].isEmpty()){
							int i = Integer.parseInt(parts[0]);
							i += 1 ;
							lId= Integer.toString(i); ;
						
						}				
					}
				rdr.close();					
				
			}
			catch (IOException e) {
				e.getMessage();
			}
			
		}
		
		
		
		public boolean idCheck( String sId) {
			try{
				File file = new File("StudentDta.txt");
					FileReader fr = new FileReader(file);		
					BufferedReader rdr = new BufferedReader(fr);
					String line;
					while ((line = rdr.readLine()) != null) {
						String[] parts = line.split(",",2);
						if (parts.length > 0 && parts[0].equals(sId)) 
							return true;
						
					}
					rdr.close();
				
			}
			catch (IOException e) {
				e.getMessage();
			}
			return false;
		}
		
		
		
		public void validationCheck(){
			nam = tf3.getText();
			ag = tf4.getText();
			fa = tf5.getText();
			mo = tf6.getText();
			cl = tf7.getText();
			ph = tf8.getText();
			sDta = nam + "," + ag + "," + fa + "," + mo + "," + cl + "," + ph;
			
			r1 = "^[A-Za-z]+(?:[\\s'-][A-Za-z]+)*$";
			r2 = "^(?:[1-9]|[1-9][0-9])$";
			r3 = "^\\d{10}$";
			Pattern p1 = Pattern.compile(r1);
			Pattern p2 = Pattern.compile(r2);
			Pattern p3 = Pattern.compile(r3);
			Matcher m1 = p1.matcher(nam);
			Matcher m2 = p2.matcher(ag);
			Matcher m3 = p1.matcher(fa);
			Matcher m4 = p1.matcher(mo);
			Matcher m5 = p2.matcher(cl);
			Matcher m6 = p3.matcher(ph);
			
			if(!m1.find()){
				notL.setText("     Invalid Name Format...");
				pass = false;
				notFound.setVisible(true);	
			}else
				
			if(!m2.find()){
				notL.setText("       Invalid Age Format...  ");
				pass = false;
				notFound.setVisible(true);
			}else
			
				
			if(!m3.find()){
				notL.setText("  Invalid Father's Name Format...");
				pass = false;
				notFound.setVisible(true);
			}else
				
			if(!m4.find()){
				notL.setText("  Invalid Mother's Name Format...");
				pass = false;
				notFound.setVisible(true);
			}else
				
			if(!m5.find()){
				notL.setText("  Invalid Class Name Format...");
				pass = false;
				notFound.setVisible(true);
			}else
				
			if(!m6.find()){
				notL.setText("  Invalid Contact Number...");
				pass = false;
				notFound.setVisible(true);
			}else{
				
				pass = true;
			}
				
		}
		
		
		
		void adding(){
				sDta = lId + "," + sDta + "\n" ;
			if(!idCheck(a.getText())){
				try{
					File file = new File("StudentDta.txt");
					 if (file.exists()) {
						FileWriter fw = new FileWriter(file, true); 
						fw.write(sDta);
						fw.close();
						int i = Integer.parseInt(lId);
							i += 1 ;
							lId= i + "" ;
						a.setText(lId);
						tf3.setText("");
						tf4.setText("");
						tf5.setText("");
						tf6.setText("");
						tf7.setText("");
						tf8.setText("");
						pass = false;
						notL.setText("  Successfully Submitted ...");
						notFound.setVisible(true);
					 }	
                
            
					
				}
				catch(IOException e1){
						System.out.println(e1.getMessage());
				}
			}
			else{
				notL.setText("  Data Already Found...");
				notFound.setVisible(true);
			}
				
		}
		
		
		void showDta(){
			try{
				File file = new File("StudentDta.txt");
				FileReader fr = new FileReader(file);		
				BufferedReader rdr = new BufferedReader(fr);
				String line;
				while ((line = rdr.readLine()) != null) {
					String[] parts = line.split(",");
					if(parts.length > 0 && parts[0].equals(lId) && opt.equals("Search")){
						int i = Integer.parseInt(lId);
						if(i <= Integer.parseInt(parts[0])){
							opt = "Show";
							remover();
							panelCreation();
							a.setText(lId);
							tf3.setText(parts[1]);
							tf4.setText(parts[2]);
							tf5.setText(parts[3]);
							tf6.setText(parts[4]);
							tf7.setText(parts[5]);
							tf8.setText(parts[6]);
							opt = "Search";
						}
					}else
					if (parts.length > 0 && parts[0].equals(lId) && opt.equals("Show")) {
						a.setText(lId);
						tf3.setText(parts[1]);
						tf4.setText(parts[2]);
						tf5.setText(parts[3]);
						tf6.setText(parts[4]);
						tf7.setText(parts[5]);
						tf8.setText(parts[6]);
					}	
				}
				rdr.close();
			}
			catch (IOException e) {
				e.getMessage();
			}
		}
		
		
		void addUpdateDta(){
			if(!pass1){	
				notFound.dispose();
				tf1.setText("");
				tf2.setText("");
				this.setVisible(true);
			}else
			if(opt.equals("Update") | opt.equals("Delete") ){
				lId = tf10.getText();
				
				if(idCheck(lId)){				
					remover();
					panelCreation();
					try{
						File file = new File("StudentDta.txt");
						FileReader fr = new FileReader(file);		
						BufferedReader rdr = new BufferedReader(fr);
						String line;
						while ((line = rdr.readLine()) != null) {
							String[] parts = line.split(",");
							if (parts.length > 0 && parts[0].equals(lId)) {
								tf3.setText(parts[1]);
								tf4.setText(parts[2]);
								tf5.setText(parts[3]);
								tf6.setText(parts[4]);
								tf7.setText(parts[5]);
								tf8.setText(parts[6]);
								
							}								
						}
						notFound.remove(tf10);
						notFound.dispose();	
						rdr.close();
					}
					catch (IOException e) {
						e.getMessage();
					}
				}else{
					notFound.remove(tf10);
					notL.setText("    No Data Found!");
					opt = "";
				}	
			}
			else
				notFound.dispose();
				
		}
		
		
		
		void dataReplace(){
			try{
				File fil = new File("StudentDta.txt");
				FileReader fr = new FileReader(fil);
				BufferedReader bf = new BufferedReader(fr);
				StringBuilder sB = new StringBuilder();
				String line;				
				while ((line = bf.readLine()) != null) {
					String[] parts = line.split(",");
					if (parts.length >= 7 && parts[0].equals(a.getText()) && opt.equals("Update")) {
						parts[1] = tf3.getText();  
						parts[2] = tf4.getText();  
						parts[3] = tf5.getText();  
						parts[4] = tf6.getText();  
						parts[5] = tf7.getText();  
						parts[6] = tf8.getText();  
						line = String.join(",", parts);
						sB.append(line).append(System.lineSeparator());
					}else
					if (parts.length >= 7 && parts[0].equals(a.getText()) && opt.equals("Delete")) {
						sB = sB ;
					}else{
						sB.append(line).append(System.lineSeparator());
						
					}
					
				}
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(fil));
				writer.write(sB.toString());
				bf.close();
				writer.close();
				notL.setText("     Operation Success");
				notFound.setVisible(true);
				remover();
				defaultPnl();
				f1.setVisible(true);
				
			}
				
			catch (IOException e) {
				e.getMessage();
			}
			
		}
		
	
		public void windowClosing(WindowEvent e){
			Window w = e.getWindow();
			if(w == f1){
				w.dispose();
				System.exit(0);
			}else
			if(w == notFound){
				notFound.remove(tf10);
				w.dispose();
			}	
				w.dispose();
		}
		
		public void  windowDeactivated(WindowEvent e){
			
		}
		public void  windowActivated(WindowEvent e){
			
		}
		public void  windowDeiconified(WindowEvent e){
			
		}
		public void  windowIconified(WindowEvent e){
			
		}
		public void  windowClosed(WindowEvent e){
			
		}
		public void  windowOpened(WindowEvent e){
			
		}
	
	
	public static void main(String args[]) 
	{
		 new StudentManagementSystem();
	}
}