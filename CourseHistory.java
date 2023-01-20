import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;



//NOTES:  You will need the import statements that appear at the top of this file, so you should
//leave them in place.  Follow the list of steps on the project writeup to complete the CourseHistory
//class that is started below.  This entire block of comments should be deleted when you are done. 


public class CourseHistory
{
    private ArrayList<CompletedCourse> courseList;
    
    
    
    
    public CourseHistory() {
    courseList = new ArrayList<CompletedCourse>();
    String department;
    String courseNumber;
    String semesterTaken;
    String credit;
    String grade;
    String competency;
    String distributionArea;
    
    try {
    FileReader reader = new FileReader("readme.txt");
    Scanner in = new Scanner(reader);
    String s;
    while(in.hasNextLine()) {
        department = in.nextLine();
        courseNumber = in.nextLine();
        semesterTaken = in.nextLine();
        credit = in.nextLine();
        grade = in.nextLine();
        competency = in.nextLine();
        distributionArea = in.nextLine();
        CompletedCourse theCourse = new CompletedCourse(department, courseNumber, semesterTaken, credit, grade, competency, distributionArea);
        courseList.add(theCourse);
    }
    in.close();
    } catch(IOException exception)
    {
        System.out.println("Error processing file:" + exception);
    }
    }
     
    
    public void displayCourseHistory() {
        System.out.println("Course History"); 
        for (int i=0; i<courseList.size(); i++) {
            courseList.get(i).displayCourse();
        }
    }
    
    public void summaryReport() {
        System.out.println("Summary Report");
        double totalGPA = 0;
        double totalCredits = 0;
        for (int i=0; i<courseList.size(); i++) {
            if (courseList.get(i).getGrade()>0) {
                totalCredits += courseList.get(i).getCredit();
            }
            totalGPA += courseList.get(i).getCredit() * courseList.get(i).getGrade();
                
        }
        System.out.println("GPA: " + totalGPA);
        System.out.println("Credits " + totalCredits);
        
    }
    
    public void distAreaReport() {
        System.out.println("Distribution Area Report"); 
        double creditAH = 0;
        double creditSS = 0;
        double creditSM = 0;
        double creditLA = 0;

        for (int i=0; i<courseList.size(); i++) {
            if (courseList.get(i).getGrade()>0) {
                if (courseList.get(i).getDistArea().equals("AH")) 
                    creditAH += courseList.get(i).getCredit();
                if (courseList.get(i).getDistArea().equals("SS")) 
                    creditSS += courseList.get(i).getCredit();
                if (courseList.get(i).getDistArea().equals("SM")) 
                    creditSM += courseList.get(i).getCredit();
                if (courseList.get(i).getDistArea().equals("LA")) 
                    creditLA += courseList.get(i).getCredit();
            }
        }
        System.out.println("Credits for AH: " + creditAH);
        System.out.println("Credits for SS: " + creditSS);
        System.out.println("Credits for SM: " + creditSM);
        System.out.println("Credits for LA: " + creditLA);     
    }
    
    
    public void compReport() {
        boolean haveW = false;
        boolean haveQ = false;
        boolean haveS = false;
        System.out.println("Competency Report");
        
        for (int i=0; i<courseList.size(); i++) {
            if (courseList.get(i).getGrade()>0) {
                if (courseList.get(i).getCompetency().equals("W"))
                    haveW = true;
                if (courseList.get(i).getCompetency().equals("Q"))
                    haveQ = true;
                if (courseList.get(i).getCompetency().equals("S"))
                    haveS = true;                
            }          
        }
        
        if (haveW && haveQ && haveS) 
            System.out.println("All competencies completed");
        else if (!haveW && !haveQ && !haveS)
            System.out.println("None competencies completed");
        else {
            System.out.println("Competencies Partially Completed");
            if (haveW)
                System.out.println("W: Complete");
            else
                System.out.println("W: Incomplete");
            if (haveQ)
                System.out.println("Q: Complete");
            else
                System.out.println("Q: Incomplete");
            if (haveS)
                System.out.println("S: Complete");
            else
                System.out.println("S: Incomplete");
        }
    }
    
    public void fullReport() {
        System.out.println("Full Report"); 
        summaryReport();
        distAreaReport();
        compReport();
    }
    
    public void sortListGPA() {
        ArrayList<CompletedCourse> temporary_list = courseList;
        
        int maxIndex;
        for (int i =0; i<temporary_list.size()-1; i++) {
            maxIndex = i;
            for (int j=i+1; j<temporary_list.size(); j++) {
                if (temporary_list.get(j).getGrade() > temporary_list.get(maxIndex).getGrade()) {
                    maxIndex = j;
                }
            }
            swap(i, maxIndex);
        }
        
        for (int i=0; i<temporary_list.size(); i++) {
            temporary_list.get(i).displayCourse();
        }
    }
    
    public void swap(int i, int j) {
        CompletedCourse temp = courseList.get(i);
        courseList.set(i, courseList.get(j));
        courseList.set(j,temp);
    }
    
}
    
    















