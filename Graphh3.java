import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.*;
import org.jfree.ui.*;
import java.io.*;


public class Graphh3 extends ApplicationFrame {

    /**
     * Creates a new demo instance.
     *
     * @param title  the frame title.
     */
    public Graphh3(final String title) {

        super(title);

        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(1350, 730));
        setContentPane(chartPanel);

		
    }

    private CategoryDataset createDataset() {

          		int a[]=new int[20];
		double b[]=new double[20];
		double d[]=new double[20];
		double e[]=new double[20];
		double f[]=new double[20];
		int i=0;
		try
		{
			String s1;
			BufferedReader br1=new BufferedReader(new FileReader("Performance\\FAR.txt"));
			while((s1=br1.readLine())!=null)
			{
				String c[]=s1.split("\t");
				a[i]=Integer.parseInt(c[0]);
				b[i]=Double.valueOf(c[1]);
				d[i]=Double.valueOf(c[2]);
				e[i]=Double.valueOf(c[3]);
				f[i]=Double.valueOf(c[4]);
				
				i++;
			}
		}
		catch(Exception g)
		{
			g.printStackTrace();
		}
        
        final String series1 = "Ensemble classifier";
        final String series2 = "SVM classifier";
        final String series3 = "MRBF-MPSO-SVM";
        final String series4 = "WCFS-IBMDNL Technique";
        
       

      

        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(b[0], series1, String.valueOf(a[0]));
        dataset.addValue(b[1], series1, String.valueOf(a[1]));
        dataset.addValue(b[2], series1, String.valueOf(a[2]));
        dataset.addValue(b[3], series1, String.valueOf(a[3]));
        dataset.addValue(b[4], series1, String.valueOf(a[4]));
        dataset.addValue(b[5], series1, String.valueOf(a[5]));
        dataset.addValue(b[6], series1, String.valueOf(a[6]));
        dataset.addValue(b[7], series1, String.valueOf(a[7]));
        dataset.addValue(b[8], series1, String.valueOf(a[8]));
        dataset.addValue(b[9], series1, String.valueOf(a[9]));

        dataset.addValue(d[0], series2, String.valueOf(a[0]));
        dataset.addValue(d[1], series2, String.valueOf(a[1]));
        dataset.addValue(d[2], series2, String.valueOf(a[2]));
        dataset.addValue(d[3], series2, String.valueOf(a[3]));
        dataset.addValue(d[4], series2, String.valueOf(a[4]));
        dataset.addValue(d[5], series2, String.valueOf(a[5]));
        dataset.addValue(d[6], series2, String.valueOf(a[6]));
        dataset.addValue(d[7], series2, String.valueOf(a[7]));
        dataset.addValue(d[8], series2, String.valueOf(a[8]));
        dataset.addValue(d[9], series2, String.valueOf(a[9]));

        dataset.addValue(e[0], series3, String.valueOf(a[0]));
        dataset.addValue(e[1], series3, String.valueOf(a[1]));
        dataset.addValue(e[2], series3, String.valueOf(a[2]));
        dataset.addValue(e[3], series3, String.valueOf(a[3]));
        dataset.addValue(e[4], series3, String.valueOf(a[4]));
        dataset.addValue(e[5], series3, String.valueOf(a[5]));
        dataset.addValue(e[6], series3, String.valueOf(a[6]));
        dataset.addValue(e[7], series3, String.valueOf(a[7]));
        dataset.addValue(e[8], series3, String.valueOf(a[8]));
        dataset.addValue(e[9], series3, String.valueOf(a[9]));     
        
        dataset.addValue(f[0], series4, String.valueOf(a[0]));
        dataset.addValue(f[1], series4, String.valueOf(a[1]));
        dataset.addValue(f[2], series4, String.valueOf(a[2]));
        dataset.addValue(f[3], series4, String.valueOf(a[3]));
        dataset.addValue(f[4], series4, String.valueOf(a[4]));
        dataset.addValue(f[5], series4, String.valueOf(a[5]));
        dataset.addValue(f[6], series4, String.valueOf(a[6]));
        dataset.addValue(f[7], series4, String.valueOf(a[7]));
        dataset.addValue(f[8], series4, String.valueOf(a[8]));
        dataset.addValue(f[9], series4, String.valueOf(a[9])); 
        return dataset;
        
    }
    
    
    private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart3D(
            "Number of Patient (N)  Vs False Alarm Rate (%)  ",         // chart title
            "Number of Patient (N) ",               // domain axis label
            "False Alarm Rate (%) ",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        //For Range Axis
        CategoryPlot p = chart.getCategoryPlot(); 
        ValueAxis axis1= p.getRangeAxis();

        //For Domian Axis
        CategoryPlot p1 = chart.getCategoryPlot(); 
        CategoryAxis axis = p1.getDomainAxis();
       

       Font font = new Font("Tahoma Bold", Font.BOLD, 22);
      axis.setLabelFont(font);
     axis1.setLabelFont(font);
     chart.getLegend().setItemFont(new Font("Tahoma Bold", Font.BOLD, 20));
     chart.getLegend().setPosition(RectangleEdge.RIGHT); 


        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        //rangeAxis.setRange(0,100);

        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();

	
        renderer.setDrawBarOutline(false);
        
        // set up gradient paints for series...
       final GradientPaint gp0 = new GradientPaint(
            0.0f, 0.0f, Color.blue, 
            0.0f, 0.0f, Color.blue
        );
        final GradientPaint gp1 = new GradientPaint(
            0.0f, 0.0f, Color.red, 
            0.0f, 0.0f, Color.red
        );
        final GradientPaint gp2 = new GradientPaint(
            0.0f, 0.0f, Color.green, 
            0.0f, 0.0f, Color.green
        );
         final GradientPaint gp3 = new GradientPaint(
            0.0f, 0.0f, new Color(147,112,219),
            0.0f, 0.0f, new Color(147,112,219)
        );

	

        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);
        renderer.setSeriesPaint(3, gp3);



       /* final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );*/
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }
    
    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        final Graphh3 graph = new Graphh3("Number of Patient (N) Vs False Alarm Rate (%) ");
        graph.pack();
        RefineryUtilities.centerFrameOnScreen(graph);
        graph.setVisible(true);

    }

}