package edu.hawaii.iCalEvent;

import java.awt.*;

import java.awt.event.*;
 
import javax.swing.*;
 
import java.text.DateFormatSymbols;
 
import java.util.Calendar;
 

 
public class boyntonGUI extends JFrame{
 

 
    //Data Fields
 

 
    JLabel eventNameText;
 
    JTextField eventName;
 
    JLabel locationNameText;
 
    JTextField locationName;
 
    JLabel startText;
 
    JLabel endText;
 
    JComboBox startYears;
 
    JComboBox startMonths;
 
    JComboBox startDays;
 
    JComboBox startHours;
 
    JComboBox startMinutes;
 
    JComboBox startAMPM;
 
    JComboBox endYears;
 
    JComboBox endMonths;
 
    JComboBox endDays;    
 
    JComboBox endHours;
 
    JComboBox endMinutes;
 
    JComboBox endAMPM;
 
    JLabel latitudeText;
 
    JTextField latitude;
 
    JLabel longitudeText;
 
    JTextField longitude;    
 
    JTextArea descriptionInput;
 
    JLabel descriptionText;
 
    JButton button_1;
 
    JLabel resourcesText;
 
    JTextField resources;
 
/**
 
 * GUI Constructor
 
 *
 
 */
 
    public boyntonGUI() {
 
         
 
             //Layout
 
        boyntonGUILayout customLayout = new boyntonGUILayout();
 
        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 15));
 
        getContentPane().setLayout(customLayout);
 

 
 
 
        //Event:0
 
        eventNameText = new JLabel("Event Name:");
 
        getContentPane().add(eventNameText);
 
        //Event Box:1
 
        eventName = new JTextField("");
 
        getContentPane().add(eventName);
 

 
        //Location:2
 
        locationNameText = new JLabel("Location:");
 
        getContentPane().add(locationNameText);
 
        //Location Box:3
 
        locationName = new JTextField("");
 
        getContentPane().add(locationName);
 

 
        //Start Text:4
 
        startText = new JLabel("Start:");
 
        getContentPane().add(startText);
 
        
 
        //End Text:5
 
        endText = new JLabel("End:");
 
        getContentPane().add(endText);        
 
        
 
        // Get months names
 
        String[] months = new DateFormatSymbols().getMonths();
 
        
 
        //Start Months:6
 
        startMonths = new JComboBox();
 
        for (int i = 0; i < months.length-1; i++) {
 
          startMonths.addItem(months[i]);
 
        }
 
        getContentPane().add(startMonths);
 
        
 
        //End Months:7
 
        endMonths = new JComboBox();
 
        for (int i = 0; i < months.length-1; i++) {
 
          endMonths.addItem(months[i]);
 
        }
 
        getContentPane().add(endMonths);
 
        
 
        //Start Days:8
 
        startDays = new JComboBox();
 
        for(int i = 1; i <= 31; i++) {
 
          startDays.addItem(i);
 
        }
 
        getContentPane().add(startDays);
 

 
        //End Days:9
 
        endDays = new JComboBox();
 
        for(int i = 1; i <= 31; i++) {
 
          endDays.addItem(i);
 
        }
 
        getContentPane().add(endDays);
 

 
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
 
        
 
        //Start Years:10
 
        startYears = new JComboBox();
 
        for(int i = currentYear; i <= currentYear + 10; i++) {
 
          startYears.addItem(i);
 
        }
 
        getContentPane().add(startYears);
 

 
        //End Years:11
 
        endYears = new JComboBox();
 
        for(int i = currentYear; i <= currentYear + 10; i++) {
 
          endYears.addItem(i);
 
        }
 
        getContentPane().add(endYears);
 

 
        //Start Hours:12
 
        startHours = new JComboBox();
 
        for(int i = 1; i <= 12; i++) {
 
          startHours.addItem(i);
 
        }
 
        getContentPane().add(startHours);
 

 
        //End Hours:13
 
        endHours = new JComboBox();
 
        for(int i = 1; i <= 12; i++) {
 
          endHours.addItem(i);
 
        }
 
        getContentPane().add(endHours);
 

 
        //Start Minutes:14
 
        startMinutes = new JComboBox();
 
        for(int i = 0; i <= 11; i++) {
 
          if(i*5 < 10)
 
            startMinutes.addItem("0"+Integer.toString(i*5));
 
          else
 
            startMinutes.addItem(i*5);
 
        }
 
        getContentPane().add(startMinutes);
 

 
        //End Minutes:15
 
        endMinutes = new JComboBox();
 
        for(int i = 0; i <= 11; i++) {
 
          if(i*5 < 10)
 
            endMinutes.addItem("0"+Integer.toString(i*5));
 
          else
 
            endMinutes.addItem(i*5);
 
        }
 
        getContentPane().add(endMinutes);
 

 
        //Start AM / PM:16
 
        startAMPM = new JComboBox();
 
        startAMPM.addItem("AM");
 
        startAMPM.addItem("PM");
 
        getContentPane().add(startAMPM);
 

 
        //End AM / PM:17
 
        endAMPM = new JComboBox();
 
        endAMPM.addItem("AM");
 
        endAMPM.addItem("PM");
 
        getContentPane().add(endAMPM);
 
        
 
     
 

 
        //Latitude:18
 
        latitudeText = new JLabel("Latitude:");
 
        getContentPane().add(latitudeText);
 
        //Latitude Box:19
 
        latitude = new JTextField("");
 
        getContentPane().add(latitude);
 
        //Longitude:20
 
        longitudeText = new JLabel("Longitude:");
 
        getContentPane().add(longitudeText);
 
        //Longitude Box:21
 
        longitude = new JTextField("");
 
        getContentPane().add(longitude);
 
        
 
        //Resources:22
 
        resourcesText = new JLabel("Anticipated Resources:");
 
        getContentPane().add(resourcesText);
 
        //Resources Box:23
 
        resources = new JTextField("");
 
        getContentPane().add(resources);
 

 
        //Description:24
 
        descriptionText = new JLabel("Description of Event:");
 
        getContentPane().add(descriptionText);
 
        //Description Box:25
 
        descriptionInput = new JTextArea("");
 
        getContentPane().add(descriptionInput);
 

 
                
 
        //Event Button:26
 
        button_1 = new JButton("Create Event");
 
        getContentPane().add(button_1);
 
        button_1.addActionListener(  //Listener for button push
 
          new ActionListener () {
 
            public void actionPerformed(ActionEvent e) {
 
              // Creates new instance of .ics event class
 
              iCalEvent myEvent = new iCalEvent();
 
          
 
              String startDate = iCalReadableDate(startYears,startMonths,startDays);
 
              String endDate = iCalReadableDate(endYears,endMonths,endDays);
 
              
 
              String startTime = iCalReadableTime(startHours,startMinutes,startAMPM);
 
              String endTime = iCalReadableTime(endHours,endMinutes,endAMPM);
 
          
 
              // Creates .ics event 
 
              if(!myEvent.createEvent(eventName.getText(), 
 
                              descriptionInput.getText(), locationName.getText(),
 
                              resources.getText(),
 
                              latitude.getText(),longitude.getText(),
 
                              startDate,startTime,endDate,endTime))
 
              System.out.println("Failed to create event.");
 
            }    
 
        
 
          }
 
        );
 

 
        //Window
 
        setSize(getPreferredSize());
 
        addWindowListener(new WindowAdapter() {
 
            public void windowClosing(WindowEvent e) {
 
                System.exit(0);
 
            }
 
        });
 
    }       
 
    // Converts for easier iCal reaable dates
 
    public String iCalReadableDate(JComboBox year, JComboBox month, JComboBox day) {
 
       return year.getSelectedItem().toString()+singleDigitFix(month.getSelectedIndex()+1) +
 
              singleDigitFix(day.getSelectedIndex()+1);
 
    }
 
    // Converts for easier iCal readabe times 
 
    public String iCalReadableTime(JComboBox hours, JComboBox minutes, JComboBox ampm) {
 
       int intHours = hours.getSelectedIndex()+1;
 
       if(intHours == 12)
 
         intHours = 0;
 
       if(ampm.getSelectedItem().toString().equals("PM"))
 
         intHours +=12;
 
         
 
       return singleDigitFix(intHours) + minutes.getSelectedItem().toString() +
 
              "00";
 
    }
 
    
 
    // Appends 0s to integers to convert to strings
 
    public String singleDigitFix(int value) {
 
       
 
       if(value == 0)
 
         return "00";
 
       else if(value < 10) 
 
         return "0" + Integer.toString(value);
 
       else
 
         return Integer.toString(value);
 
    }
 
         
 
/**
 
 * Main Method
 
 */
 
    public static void main(String args[]) {
 
        boyntonGUI window = new boyntonGUI();
 

 
        window.setTitle("Boynton Event Creater");
 
        window.pack();
 
        window.show();
 
     
 
    }
 
}//End Main Method
 

 

 
/**
 
 * GUI Layout Class
 
 */
 
class boyntonGUILayout implements LayoutManager {
 

 
    public boyntonGUILayout() {
 
    }
 

 
    public void addLayoutComponent(String name, Component comp) {
 
    }
 

 
    public void removeLayoutComponent(Component comp) {
 
    }
 

 
    public Dimension preferredLayoutSize(Container parent) {
 
        Dimension dim = new Dimension(0, 0);
 

 
        Insets insets = parent.getInsets();
 
        dim.width = 622 + insets.left + insets.right;
 
        dim.height = 482 + insets.top + insets.bottom;
 

 
        return dim;
 
    }
 

 
    public Dimension minimumLayoutSize(Container parent) {
 
        Dimension dim = new Dimension(0, 0);
 
        return dim;
 
    }
 

 
    public void layoutContainer(Container parent) {
 
        Insets insets = parent.getInsets();
 

 
        Component c;
 
        c = parent.getComponent(0);//Event:0
 
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+24,72,24);}
 
        c = parent.getComponent(1);//Event Box:1
 
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+24,200,24);}
 
        c = parent.getComponent(2);//Location:2
 
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+56,72,24);}
 
        c = parent.getComponent(3);//Location Box:3
 
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+56,200,24);}
 
        c = parent.getComponent(4);//Start Text:4
 
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+104,72,24);}
 
        c = parent.getComponent(5);//End Text:5
 
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+144,72,24);}
 
        c = parent.getComponent(6);//Start Months:6
 
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+104,100,32);} 
 
        c = parent.getComponent(7);//End Months:7
 
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+144,100,32);}
 
        c = parent.getComponent(8);//Start Days:8
 
        if (c.isVisible()) {c.setBounds(insets.left+188,insets.top+104,62,32);}
 
        c = parent.getComponent(9);//End Days:9
 
        if (c.isVisible()) {c.setBounds(insets.left+188,insets.top+144,62,32);}        
 
        c = parent.getComponent(10);//Start Years:10
 
        if (c.isVisible()) {c.setBounds(insets.left+250,insets.top+104,62,32);}
 
        c = parent.getComponent(11);//End Years:11
 
        if (c.isVisible()) {c.setBounds(insets.left+250,insets.top+144,62,32);}     
 
        c = parent.getComponent(12);//Start Hours:12
 
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+104,72,32);}
 
        c = parent.getComponent(13);//Start Hours:13
 
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+144,72,32);}
 
        c = parent.getComponent(14);//Start Minutes:14
 
        if (c.isVisible()) {c.setBounds(insets.left+448,insets.top+104,72,32);}
 
        c = parent.getComponent(15);//Start Minutes:15
 
        if (c.isVisible()) {c.setBounds(insets.left+448,insets.top+144,72,32);}
 
        c = parent.getComponent(16);//Start AM / PM:16
 
        if (c.isVisible()) {c.setBounds(insets.left+520,insets.top+104,72,32);}
 
        c = parent.getComponent(17);//Start AM / PM:17
 
        if (c.isVisible()) {c.setBounds(insets.left+520,insets.top+144,72,32);}
 
        c = parent.getComponent(18);//Latitude:18
 
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+180,72,24);}
 
        c = parent.getComponent(19);//Latitude Box:19
 
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+180,150,24);}
 
        c = parent.getComponent(20);//Longitude:20
 
        if (c.isVisible()) {c.setBounds(insets.left+316,insets.top+180,72,24);}
 
        c = parent.getComponent(21);//Longitude Box:21
 
        if (c.isVisible()) {c.setBounds(insets.left+388,insets.top+180,150,24);}
 
        c = parent.getComponent(22);//Resources:22
 
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+210,150,24);}
 
        c = parent.getComponent(23);//Resources Box:23
 
        if (c.isVisible()) {c.setBounds(insets.left+158,insets.top+210,300,24);}  
 
        c = parent.getComponent(24);//Description:24
 
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+240,152,24);}
 
        c = parent.getComponent(25);//Description Box:25
 
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+270,550,136);}              
 
        c = parent.getComponent(26);//Event Button:26
 
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+418,144,40);}
 
    }
 
}//End Layout Class
 

 


