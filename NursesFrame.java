/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 *
 * @author Romari
 */
public class NursesFrame {
    AppSystem appsys = AppSystem.getInstance();
    private JFrame frame = new JFrame("Nurses"); 
    private JButton homeBtn = new JButton("Home");
    private JButton logoutBtn = new JButton("Logout");
    
    private JButton deleteShiftsBtn = new JButton("Delete Nurse");
    
    private DefaultListModel<Nurse> nurseListModel = new DefaultListModel<>();
    private JList<Nurse> nurseList = new JList<>(nurseListModel);
    
    public NursesFrame()
    {
        
        JLabel heading = new JLabel("eNurse");
        heading.setFont(new Font("Poppins", Font.BOLD, 20));
        JLabel subheading = new JLabel("Admin Nurses Frame");
        subheading.setFont(new Font("Poppins", Font.ITALIC, 10));

        // Setup left panel for heading and subheading
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(heading);
        leftPanel.add(subheading);

        // Setup top panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(homeBtn);
        buttonPanel.add(logoutBtn);

        // Header panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(leftPanel, BorderLayout.WEST);
        headerPanel.add(buttonPanel, BorderLayout.EAST);

        // Setting up the nurse list
        nurseList.setFont(new Font("Arial", Font.PLAIN, 18)); // Larger font for nurse list
        nurseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(nurseList);
        listScrollPane.setPreferredSize(new Dimension(300, 400)); // Adjust size as needed
        nurseList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (c instanceof JLabel) {
                    JLabel label = (JLabel) c;
                    label.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY)); 
                    label.setPreferredSize(new Dimension(label.getWidth(), 50)); // Increase cell height

                }
                return c;
            }
        });
        
        
        
        /////deleteShiftsBtn.addActionListener(e -> deleteSelectedNurse());
        JPanel deleteButtonPanel = new JPanel();
        deleteButtonPanel.add(deleteShiftsBtn);
       

        frame.setLayout(new BorderLayout());
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(listScrollPane, BorderLayout.CENTER);
        frame.add(deleteButtonPanel, BorderLayout.SOUTH);

        // Display nurses
        displayNurses();

        frame.setSize(800, 800); // Adjust the size as needed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ViewManager viewmanager = ViewManager.getInstance();
        AppSystem appsys = AppSystem.getInstance();
        
        //logout button action listener
        viewmanager.attachListener(logoutBtn, 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(frame, false);
                    frame.dispose();
                    viewmanager.refreshLoginFrame();
                    viewmanager.setVisibility(viewmanager.getLoginFrame().getFrame(), true);
                    appsys.setCurrentID(0);
                         
                }
            }
        );
        
        //home button action listener
        viewmanager.attachListener(homeBtn, 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    frame.dispose();
                    viewmanager.setVisibility(frame, false);
                    viewmanager.refreshADashboardFrame();
                    viewmanager.setVisibility(viewmanager.getADashboardFrame().getFrame(), true);
                }
            }
        );
        
        //remove nurse action listener 
        viewmanager.attachListener(deleteShiftsBtn, 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.getNursesFrame().deleteSelectedNurse();
                }
            }
        );
        
    }
    
    public JFrame getFrame()
    {
        return frame;
    }
    
    
    private void displayNurses() {        
        var nurses = appsys.getNurseList();
        NurseCollection nurseCollection = new NurseCollection(nurses);

        NurseIterator nurseIterator =nurseCollection.createIterator();
        while (nurseIterator.hasNext()) {
            Nurse nurse = nurseIterator.next();
            nurseListModel.addElement(nurse);
        }
    }
    
     //Delete Selected Nurses
    private void deleteSelectedNurse() {
        int selectedIndex = nurseList.getSelectedIndex();
        if (selectedIndex != -1) {
            Nurse selectedNurse = nurseListModel.get(selectedIndex);
            appsys.removeNurseFile(selectedNurse); // Implement this method in NurseManager
            nurseListModel.remove(selectedIndex);
            appsys.deleteNurse(selectedNurse.getID());
    }
    }
}
