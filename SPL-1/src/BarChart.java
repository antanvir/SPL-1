
package forspl;
import forspl.LocalVariableCounting;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class BarChart extends ApplicationFrame {
   
   public BarChart( String applicationTitle , String chartTitle ) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "VARIABLES",            
         "Number Of Times Found",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 650 , 700 ) );        
      setContentPane( chartPanel ); 
   }
   
   private CategoryDataset createDataset( ) {
      final String Int = "int";        
      final String Double = "double";        
      final String Float = "float";        
      final String Char = "char";        
      final String Boolean = "boolean";        
      final String string = "String";     
      
      final String variables = "Variables";   
      
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue(LocalVariableCounting.countInt , variables , Int );        
      dataset.addValue( LocalVariableCounting.countDouble , variables , Double );        
      dataset.addValue( LocalVariableCounting.countFloat ,variables ,Float  ); 
      dataset.addValue( LocalVariableCounting.countChar , variables , Char );           
      dataset.addValue( LocalVariableCounting.countBoolean , variables , Boolean  );        
      dataset.addValue( LocalVariableCounting.countString , variables , string  );       
                  

      return dataset; 
   }
   
   public static void main( String[ ] args ) {
      BarChart chart = new BarChart("Car Usage Statistics", 
         "Which car do you like?");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
}
