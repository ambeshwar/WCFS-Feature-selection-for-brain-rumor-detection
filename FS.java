import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.*;
import java.util.*;

public class FS extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5;	
	Font f1=new Font("Gabriola",Font.BOLD,35);
	JButton b1,b2;
	JTextArea ta;
	JScrollPane jsp;
	JTable table;
	
	FS()
	{
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			
			ImageIcon img=new ImageIcon("");
			l1=new JLabel(img);
			l1.setBounds(0,0,1366,768);
			add(l1);
			
			l2=new JLabel("Feature Selection");
			l2.setBounds(600,20,1200,80);
			l2.setFont(f1);
			l1.add(l2);
			
			ta=new JTextArea();
			ta.setForeground(Color.WHITE);
			ta.setBackground(Color.BLACK);

			jsp=new JScrollPane(ta);
			jsp.setBounds(300,150,800,250);
			l1.add(jsp);

			String str;
			BufferedReader br=new BufferedReader(new FileReader("Medical dataset\\data.csv"));
			while((str=br.readLine())!=null)
			{
				ta.append(str+"\n");
			}		
			
			b1=new JButton("Apply");
			b1.setBounds(500,450,150,40);
			b1.setForeground(Color.WHITE);
			b1.setBackground(Color.BLACK);
			l1.add(b1);
			
			b1.addActionListener(this);

			b2=new JButton("Select");
			b2.setBounds(850,450,150,40);
			b2.setForeground(Color.WHITE);
			b2.setBackground(Color.BLACK);
			l1.add(b2);
			
			b2.addActionListener(this);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		setTitle(" ");
		setSize(1366,768);
		setVisible(true);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try
			{
				jsp.setVisible(false);

				b1.setEnabled(false);

				int Row=0;
				
				DefaultTableModel dtm=new DefaultTableModel(new Object[]{"Number of features","Correlation"},0);
				table=new JTable(dtm)
				{
		
				};

				table.setForeground(Color.WHITE);
				table.setBackground(Color.BLACK);

				TableColumnModel tcm=table.getColumnModel();
				tcm.getColumn(0).setMaxWidth(600);
				tcm.getColumn(1).setMaxWidth(200);

				jsp=new JScrollPane(table);
				jsp.setBounds(350,150,800,200);
				l1.add(jsp);

				
				//BufferedWriter bw=new BufferedWriter(new FileWriter("CV"));
				
				String str;
				BufferedReader br=new BufferedReader(new FileReader("CV"));
				while((str=br.readLine())!=null)
				{
					String a[]=str.split("\t");
					dtm.insertRow(Row,new Object[]{a[0],a[1]});
					Row++;
				}

				JOptionPane.showMessageDialog(null," Measure the correlation between features");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}			
		}
		if(ae.getSource()==b2)
		{
			try
			{
				jsp.setVisible(false);
				
				b1.setVisible(false);
				b2.setVisible(false);
				
				int Row=0;
				
				DefaultTableModel dtm=new DefaultTableModel(new Object[]{"higher weighted features "},0);
				table=new JTable(dtm)
				{
		
				};

				table.setForeground(Color.WHITE);
				table.setBackground(Color.BLACK);				

				jsp=new JScrollPane(table);
				jsp.setBounds(400,150,600,200);
				l1.add(jsp);
				
				BufferedWriter bw=new BufferedWriter(new FileWriter("Features"));
				
				String str;
				BufferedReader br=new BufferedReader(new FileReader("CV"));
				while((str=br.readLine())!=null)
				{
					String a[]=str.split("\t");					
					double feature=Double.valueOf(a[1]);
					if(feature>0.50)
					{
						dtm.insertRow(Row,new Object[]{a[0]});
						Row++;
						bw.write(a[0]);
						bw.newLine();
					}
				}
				bw.close();
				
				JOptionPane.showMessageDialog(null,"Select only higher weighted features" );
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
				
	}		
	public static void main(String [] args)throws IOException
	{
		new FS();
	}
}