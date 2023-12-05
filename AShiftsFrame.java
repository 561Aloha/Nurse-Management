/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Romari
 */
public class AShiftsFrame {
    private JFrame frame = new JFrame("Available Shifts"); 
    private JButton homeBtn = new JButton("Home");
    private JButton logoutBtn = new JButton("Logout");
    private JButton removeBtn = new JButton("Remove Shift");
    private ArrayList<Shift> shiftsList = AppSystem.getShiftList();
    Filter filter = new Filter(shiftsList);
    
    
    public AShiftsFrame()
    {
        JLabel heading = new JLabel("eNurse");
        heading.setFont(new Font("Poppins", Font.BOLD, 20));
        JLabel subheading = new JLabel("Admin Shifts Frame");
        subheading.setFont(new Font("Poppins", Font.ITALIC, 10));
        
        
      

        // Creating a subpanel for horizontal buttons on the right
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.add(homeBtn);
        rightPanel.add(logoutBtn);
        
        
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(heading);
        leftPanel.add(subheading);
        
        // Set layout manager for the frame
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        
        // Creating a panel for the entire content with BorderLayout
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(leftPanel, BorderLayout.WEST);
        headerPanel.add(rightPanel, BorderLayout.EAST);
        headerPanel.add(new JSeparator(), BorderLayout.SOUTH); // Horizontal Line

        // Add the content panel to the frame
        frame.add(headerPanel);


            // Second Layer
        JPanel meepPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Use FlowLayout.CENTER for center alignment

        JLabel subheading2 = new JLabel("Welcome");
        subheading2.setFont(new Font("Poppins", Font.ITALIC, 30));
        meepPanel.add(subheading2);


        // Set layout manager for the frame
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(meepPanel);
        
        ///frame.setVisible(true);
        // This method sets the width and height of the frame
        ////frame.setSize(1000, 800); //
        
        
        ////frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Schedule schedule = new Schedule();
        schedule.createScheduleFrame(frame.getContentPane());   
 

        frame.setSize(1000, 800); // Adjust the size as needed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //////frame.setVisible(true);
    }
    
    public JFrame getFrame()
    {
        return frame;
    }
    
    public JButton getLogoutBtn()
    {
        return logoutBtn;
    }
    
    public JButton getHomeBtn()
    {
        return homeBtn;
    }
    
    public JButton getRemoveBtn()
    {
        return removeBtn;
    }
    
    private class Schedule 
    {
        DefaultListModel<Shift> listModel = new DefaultListModel<>();
        JList<Shift> jList = new JList<>(listModel);    

        public void createScheduleFrame(Container container) {
            // Create an ArrayList to store data
            //ArrayList<Shift> dataList = new ArrayList<>();
            
            displayShifts();
            /*
            dataList.add(new DetailItem("2023-01-01", "10:00 AM - 4:00PM", "City Hospital"));
            dataList.add(new DetailItem("2023-01-02", "08:30 AM - 2:00PM", "General Hospital"));
            dataList.add(new DetailItem("2023-01-03", "08:45 AM - 3:00PM", "Medical Center"));
            dataList.add(new DetailItem("2023-01-04", "09:15 AM - 4:00PM", "Community Hospital"));
            */
            // Create a DefaultListModel to hold the data

            // Populate the DefaultListModel with data from the ArrayList
            //for (DetailItem item : dataList) {
             //   listModel.addElement(item);
            //}

            // These are the details that goes inside.
            jList.setCellRenderer(new MiniGrid());

            // Create a JScrollPane to allow scrolling if the list is too long
            JScrollPane scrollPane = new JScrollPane(jList);

            // Create a Remove Shift button with ActionEvent.
            
            removeBtn.addActionListener(e -> deleteSelectedShift());
                   
            
            //Sort_D sortPanel = new Sort_D(shiftsList);
            
            filter.getSubmitBtn().addActionListener(e -> filterShifts());
            

            JPanel westPanel = new JPanel();
            westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
            westPanel.add(filter);
            //westPanel.add(sortPanel);

            JPanel eastPanel = new JPanel();
            eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
            eastPanel.add(removeBtn);
            
            // Create a panel to hold the JList and the Remove Shift button
            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.add(westPanel,BorderLayout.WEST);
            mainPanel.add(scrollPane, BorderLayout.CENTER); // Place JList at the top
            mainPanel.add(eastPanel, BorderLayout.EAST); // Remove button on the bottom of th 
            container.add(mainPanel);


        }
        private class MiniGrid extends DefaultListCellRenderer 
        {

            private static final int CELL_PADDING = 5; 
            private static final int BORDER_THICKNESS = 1; 
            private static final Color BORDER_COLOR = Color.BLACK;
            

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
            {
                Shift shift = (Shift) value;

                JPanel panel = new JPanel(new GridLayout(3, 2, CELL_PADDING, CELL_PADDING));
                panel.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
                 //The Details of the panel                                           
                
                panel.add(createLabel("Date:"));
                panel.add(createLabel(shift.getShiftDateString()));
                panel.add(createLabel("Time:"));
                panel.add(createLabel(shift.getTimeString()));
                panel.add(createLabel("Hospital:"));
                panel.add(createLabel(shift.getHospital()));
                
                //panel.add(createLabel("Shift:"));
                //panel.add(createLabel(shift.toString()));

                //The Border around the Panel
                panel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(0, 0, BORDER_THICKNESS, BORDER_THICKNESS, BORDER_COLOR),
                        BorderFactory.createEmptyBorder(CELL_PADDING, CELL_PADDING, CELL_PADDING, CELL_PADDING)
                ));
                return panel;
            }

            private JLabel createLabel(String text) 
            {
                JLabel label = new JLabel(text);
                label.setHorizontalAlignment(SwingConstants.LEFT);
                return label;
            }
        }
        private void displayShifts() 
        {        
            var shifts = AppSystem.getShiftList();
            System.out.println("here");
            ShiftCollection shiftCollection = new ShiftCollection(shifts);

            ShiftIterator shiftIterator =shiftCollection.createIterator();
            while (shiftIterator.hasNext()) 
            {
                Shift shift = shiftIterator.next();
                listModel.addElement(shift);
            }
        }
        private void deleteSelectedShift() 
        {
            int selectedIndex = jList.getSelectedIndex();
            if (selectedIndex != -1) 
            {
                Shift selectedShift = listModel.get(selectedIndex);
                AppSystem.removeShift(selectedShift); // Implement this method in NurseManager
                listModel.remove(selectedIndex);
            }
        }
        
        private void filterShifts()
        {
            listModel.clear();
            //Filter filter = new Filter(AppSystem.getShiftList());
            
            var shifts = AppSystem.getShiftList();
            
            if(filter.getABtn().isSelected())
            {
                System.out.println("radio button A");
                shifts = filter.filterShiftsByHospital(1);
            }
            else if(filter.getBBtn().isSelected())
            {
                System.out.println("radio button B");
                shifts = filter.filterShiftsByHospital(2);
            }
            else if(filter.getCBtn().isSelected())
            {
                System.out.println("radio button C");
                shifts = filter.filterShiftsByHospital(3);
            }
            else if(filter.getDBtn().isSelected())
            {
                System.out.println("radio button D");
                shifts = filter.filterShiftsByHospital(4);
            }
            else if(filter.getDayBtn().isSelected())
            {
                System.out.println("radio button day");
                shifts = filter.filterShiftsByType(1);
            }
            else if(filter.getNightBtn().isSelected())
            {
                System.out.println("radio button night");
                shifts = filter.filterShiftsByType(2);
            }
            
            
            for(Shift shift: shifts)
            {
                System.out.println(shift.toString());
            }
            
            for(Shift shift: shiftsList)
            {
                System.out.println(shift.toString());
            }
            
            
            
            System.out.println("here");
            ShiftCollection shiftCollection = new ShiftCollection(shifts);

            ShiftIterator shiftIterator =shiftCollection.createIterator();
            while (shiftIterator.hasNext()) 
            {
                Shift shift = shiftIterator.next();
                listModel.addElement(shift);
            }
            
            
        }
        
        private void addShift() 
        {
            /*take to wherever you open another page to add a shift*/
        }
    }
}
