import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.util.*;

public class MD extends JFrame 
{
	JLabel l1,l2,l3,l4,l5;	
	Font f1=new Font("Gabriola",Font.BOLD,35);
	JTextArea ta;
	JScrollPane jsp;
	
	MD()
	{
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			
			ImageIcon img=new ImageIcon("");
			l1=new JLabel(img);
			l1.setBounds(0,0,1366,768);
			add(l1);
			
			l2=new JLabel("Medical dataset");
			l2.setBounds(600,20,1200,80);
			l2.setFont(f1);
			l1.add(l2);
			
			ta=new JTextArea();
			ta.setForeground(Color.WHITE);
			ta.setBackground(Color.BLACK);

			jsp=new JScrollPane(ta);
			jsp.setBounds(350,150,800,250);
			l1.add(jsp);

			String str;
			BufferedReader br=new BufferedReader(new FileReader("Medical dataset\\data.csv"));
			while((str=br.readLine())!=null)
			{
				ta.append(str+"\n");
			}		
			
			
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
	public static void main(String [] args)throws IOException
	{
		new MD();
	}
}