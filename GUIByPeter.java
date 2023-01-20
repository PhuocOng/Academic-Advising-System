import java.awt.*;           //Use the Abstract Window Toolkit
import java.awt.event.*;     //Use the Abstract Window Toolkit event processing
import javax.swing.*; 
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.JFrame;       //To use SWING interface components such as frames


/**
 * The Driver class presents a simple GUI that can be used to search courses. The
 * GUI allows the user to specify a department to use as a search criterion.
 * 
 * @author Computer Science Department 
 * @version November, 2007
 */
public class GUIByPeter implements ActionListener
{   private CourseHistory courses = new CourseHistory();
    private JFrame frame = new JFrame("DPU - Course History");
    private JButton submitButton = new JButton("SUBMIT");
    private JComboBox reportCombo = new JComboBox();  
  
    /*
     * The constructor for the Driver class creates the GUI and calls
     * a method to fill the report combo box with initial values. It
     * then displays this comboBox on the pane.
     */
    public GUIByPeter()
    {         
       //By default a gridlayout has one row
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel(new BorderLayout());
        
        
        Border blackline = BorderFactory.createLineBorder(Color.black);
        contentPane.setBorder(blackline);
        
 
        reportCombo.addItem("COURSE HISTORY");
        reportCombo.addItem("SUMMARY");
        reportCombo.addItem("DIST AREAS");
        reportCombo.addItem("COMPETENCY");
        reportCombo.addItem("FULLREPORT");
        reportCombo.addItem("SORTEDLIST");
        reportCombo.setPreferredSize(new Dimension(200, 50)); //change size of report combo
        contentPane.add(reportCombo, BorderLayout.WEST);
        
        JLabel l = new JLabel("ACADEMIC ADVISING SYSTEM \n \n \n \n \n \n",  SwingConstants.CENTER);
        l.setFont(new Font("Calibri", Font.BOLD, 15));
        l.setPreferredSize(new Dimension(250, 50)); //Change size of label
        contentPane.add(l,BorderLayout.PAGE_START);
        
        submitButton.addActionListener(this); 
        contentPane.add(submitButton, BorderLayout.CENTER);
        
        //Display the window.
        frame.setContentPane(contentPane);
        frame.setSize(400,200); //Set up initial size of frame
        
        frame.setVisible(true);
   }
      
    
    /*
     * This method fills the reportCombo box with initial values.
     */
    
    
    /*
     * This method is called when the user clicks on a button in the Interface.
     * The method checks to see if the user clicked on the SUBMIT button.  If so,
     * it prints the selected report.
     *
     */
    public void actionPerformed(ActionEvent event)
    { 
      if (event.getSource().equals(submitButton))
      {   String selectedReport = reportCombo.getSelectedItem().toString();
          if (selectedReport.equals("COURSE HISTORY") )
          {   courses.displayCourseHistory();
          }
          
          if (selectedReport.equals("SUMMARY") )
          {   courses.summaryReport();
          }
          
          if (selectedReport.equals("DIST AREAS") )
          {   courses.distAreaReport();
          }
          
          if (selectedReport.equals("COMPETENCY") )
          {   courses.compReport();
          }
          
          if (selectedReport.equals("FULLREPORT") )
          {   courses.fullReport();
          }
          
          if (selectedReport.equals("SORTEDLIST") )
          {
              courses.sortListGPA();
          }
          
      } 
    }

    public static void main(String[] args) {
        GUIByPeter gui = new GUIByPeter();
        
    }
}
