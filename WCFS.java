import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.util.*;

public class WCFS extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
	Font f1=new Font("Gabriola",Font.BOLD,26);
	Font f2=new Font("Gabriola",Font.BOLD,30);
	double time1=0,time2=0,time3=0,time4=0,time5=0,time6=0,time7=0,time8=0,time9=0,time10=0;
	
	WCFS()
	{
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			
			ImageIcon img=new ImageIcon("");
			l1=new JLabel(img);
			l1.setBounds(0,0,1366,768);
			add(l1);
			
			l2=new JLabel("<html><h1 style=Color:Blue;><u>A DEEP NEURAL NETWORK BASED CLASSIFIER FOR BRAIN TUMOR DIAGNOSIS</h1></u></html>");
			l2.setBounds(350,80,1200,60);
			l2.setFont(f2);
			l1.add(l2);
			
			l3=new JLabel("<html><h1 style=Color:blue;><u></h1></u></html>");
			l3.setBounds(400,70,1000,60);
			l3.setFont(f1);
			//l1.add(l3);
			
			TitledBorder tb=new TitledBorder("WCFS-IBMDNL Technique ");			
			l4=new JLabel();
			l4.setBounds(180,180,350,225);
			l4.setBorder(tb);
			l1.add(l4);
			
			b1=new JButton("Medical dataset");
			b1.setBounds(200,230,300,40);
			b1.setForeground(Color.WHITE);
			b1.setBackground(Color.BLACK);
			l1.add(b1);
			
			b1.addActionListener(this);
			
			b2=new JButton("Feature Selection");
			b2.setBounds(200,280,300,40);
			b2.setForeground(Color.WHITE);
			b2.setBackground(Color.BLACK);
			l1.add(b2);
			
			b2.addActionListener(this);
			
			b3=new JButton("Tumor Classification");
			b3.setBounds(200,330,300,40);
			b3.setForeground(Color.WHITE);
			b3.setBackground(Color.BLACK);
			l1.add(b3);
			
			b3.addActionListener(this);
			
			TitledBorder tb1=new TitledBorder("Performance ");			
			l5=new JLabel();
			l5.setBounds(780,380,350,225);
			l5.setBorder(tb1);
			l1.add(l5);
			
			b4=new JButton("Disease Diagnosis Rate (%)");
			b4.setBounds(810,420,300,40);
			b4.setForeground(Color.WHITE);
			b4.setBackground(Color.BLACK);
			l1.add(b4);
			
			b4.addActionListener(this);
			
			b5=new JButton("Disease Diagnosis Time (ms)");
			b5.setBounds(810,470,300,40);
			b5.setForeground(Color.WHITE);
			b5.setBackground(Color.BLACK);
			l1.add(b5);
			
			b5.addActionListener(this);
			
			b6=new JButton("False Alarm Rate (%)");
			b6.setBounds(810,520,300,40);
			b6.setForeground(Color.WHITE);
			b6.setBackground(Color.BLACK);
			l1.add(b6);
			
			b6.addActionListener(this);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		setTitle("A DEEP NEURAL NETWORK BASED CLASSIFIER FOR BRAIN TUMOR DIAGNOSIS");
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
				time1=(double)System.currentTimeMillis();
				new MD();
				time2=(double)System.currentTimeMillis();

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
				time3=(double)System.currentTimeMillis();
				new FS();
				time4=(double)System.currentTimeMillis();				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(ae.getSource()==b3)
		{
			try
			{
				time5=(double)System.currentTimeMillis();
				new TC();
				time6=(double)System.currentTimeMillis();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}			
		if(ae.getSource()==b4)
		{
			try
			{
				Runtime.getRuntime().exec("G1.bat");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(ae.getSource()==b5)
		{
			try
			{
				Runtime.getRuntime().exec("G2.bat");
			}		
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(ae.getSource()==b6)
		{
			try
			{
				Runtime.getRuntime().exec("G3.bat");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void main(String [] args)throws IOException
	{
		new WCFS();
	}
}