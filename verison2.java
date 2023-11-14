import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class verison2 {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Welcome");
        JLabel heading = new JLabel("eNurse");
        heading.setFont(new Font("Poppins", Font.BOLD, 20));
        JLabel subheading = new JLabel("Nurse Dashboard");
        subheading.setFont(new Font("Poppins", Font.ITALIC, 10));
        JButton button1 = new JButton("View Shifts");
        JButton button2 = new JButton("View Profile");
        JButton button3 = new JButton("Logout");
  

        // Creating a panel with BoxLayout for left labels
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(heading);
        leftPanel.add(subheading);
 
        // Creating a subpanel for horizontal buttons on the right
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);



        // Second Layer
        JPanel meepPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton button10 = new JButton("FILTER");
        meepPanel.add(button10);

        JPanel meepPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel subheading2 = new JLabel("Shifts Reserved");
        meepPanel2.add(subheading2);
    
       
        // Creating a panel for the entire content with BorderLayout
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(leftPanel, BorderLayout.WEST);
        contentPanel.add(buttonPanel, BorderLayout.EAST);
        contentPanel.add(new JSeparator(), BorderLayout.SOUTH); // Horizontal Line

        // Set layout manager for the frame
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Add the content panel to the frame
        frame.add(contentPanel);
        frame.add(meepPanel);
        frame.add(meepPanel2);
        // sets the frame visibility to true
        frame.setVisible(true);

        // This method sets the width and height of the frame
        frame.setSize(1000, 800); // Adjust the size as needed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating a Schedule instance
        Schedule schedule = new verison2().new Schedule();
        schedule.createScheduleFrame(frame.getContentPane());
    }

    private static class DetailItem {
        private String date;
        private String time;
        private String hospitalName;

        public DetailItem(String date, String time, String hospitalName) {
            this.date = date;
            this.time = time;
            this.hospitalName = hospitalName;
        }

        public String getDate() {
            return date;
        }
        public String getTime() {
            return time;
        }

        public String getHospitalName() {
            return hospitalName;
        }

        @Override
        public String toString() {
            return hospitalName; // Used for JList display
        }
    }

    // Custom class to represent the schedule
    private class Schedule {

        public void createScheduleFrame(Container container) {
            // Create an ArrayList to store data
            ArrayList<DetailItem> dataList = new ArrayList<>();
            dataList.add(new DetailItem("2023-01-01", "10:00 AM - 4:00PM", "City Hospital"));
            dataList.add(new DetailItem("2023-01-02", "08:30 AM - 2:00PM", "General Hospital"));
            dataList.add(new DetailItem("2023-01-03", "08:45 AM - 3:00PM", "Medical Center"));
            dataList.add(new DetailItem("2023-01-04", "09:15 AM - 4:00PM", "Community Hospital"));


            // Create a DefaultListModel to hold the data
            DefaultListModel<DetailItem> listModel = new DefaultListModel<>();

            // Populate the DefaultListModel with data from the ArrayList
            for (DetailItem item : dataList) {
                listModel.addElement(item);
            }

            // These are the details that goes inside.
            JList<DetailItem> jList = new JList<>(listModel);
            jList.setCellRenderer(new MiniGrid());

            // Create a JScrollPane to allow scrolling if the list is too long
            JScrollPane scrollPane = new JScrollPane(jList);

            // Create a Remove Shift button with ActionEvent.
            JButton removeButton = new JButton("Remove Shift");
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Get the selected item and remove it from the list
                    int selectedIndex = jList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        listModel.remove(selectedIndex);
                    }
                }
            });

            // Create a panel to hold the JList and the Remove Shift button
            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.add(scrollPane, BorderLayout.NORTH); // Place JList at the top
            mainPanel.add(new JSeparator(), BorderLayout.CENTER); // Separator in the middle
            mainPanel.add(removeButton, BorderLayout.SOUTH); // Remove button on the bottom of th 
            container.add(mainPanel);

        }

        private class MiniGrid extends DefaultListCellRenderer {

            private static final int CELL_PADDING = 5; 
            private static final int BORDER_THICKNESS = 1; 
            private static final Color BORDER_COLOR = Color.BLACK;
            

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                DetailItem detailItem = (DetailItem) value;

                JPanel panel = new JPanel(new GridLayout(3, 2, CELL_PADDING, CELL_PADDING));
                panel.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
                 //The Details of the panel                                           
                panel.add(createLabel("Date:"));
                panel.add(createLabel(detailItem.getDate()));
                panel.add(createLabel("Time:"));
                panel.add(createLabel(detailItem.getTime()));
                panel.add(createLabel("Hospital:"));
                panel.add(createLabel(detailItem.getHospitalName()));

                //The Border around the Panel
                panel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(0, 0, BORDER_THICKNESS, BORDER_THICKNESS, BORDER_COLOR),
                        BorderFactory.createEmptyBorder(CELL_PADDING, CELL_PADDING, CELL_PADDING, CELL_PADDING)
                ));
                return panel;
            }

            private JLabel createLabel(String text) {
                JLabel label = new JLabel(text);
                label.setHorizontalAlignment(SwingConstants.LEFT);
                return label;
            }
        }
    }
}
