import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Schedule{
    public static void main(String[] args) {
        // Create an ArrayList to store data
        ArrayList<DetailItem> dataList = new ArrayList<>();
        dataList.add(new DetailItem("2023-01-01", "10:00 AM - 4:00PM", "City Hospital"));
        dataList.add(new DetailItem("2023-01-02", "02:30 PM", "General Hospital"));
        dataList.add(new DetailItem("2023-01-03", "08:45 AM", "Medical Center"));
        dataList.add(new DetailItem("2023-01-04", "01:15 PM", "Community Hospital"));

        // Create a JFrame
        JFrame frame = new JFrame("Mini Grid ArrayList Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);

        // Create a DefaultListModel to hold the data
        DefaultListModel<DetailItem> listModel = new DefaultListModel<>();

        // Populate the DefaultListModel with data from the ArrayList
        for (DetailItem item : dataList) {
            listModel.addElement(item);
        }

        // Create a JList with the DefaultListModel and a custom cell renderer
        JList<DetailItem> jList = new JList<>(listModel);
        jList.setCellRenderer(new MiniGridListCellRenderer());

        // Create a JScrollPane to allow scrolling if the list is too long
        JScrollPane scrollPane = new JScrollPane(jList);

        // Create a Remove Shift button
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
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(removeButton, BorderLayout.SOUTH);

        // Add the main panel to the frame
        frame.getContentPane().add(mainPanel);

        // Display the JFrame
        frame.setVisible(true);
    }
}

// Custom cell renderer to create a mini grid with details for each item
class MiniGridListCellRenderer extends DefaultListCellRenderer {
    private static final int CELL_PADDING = 5; // Adjust the value to control spacing
    private static final int BORDER_THICKNESS = 1; // Adjust the value to control border thickness
    private static final Color BORDER_COLOR = Color.BLACK;

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        DetailItem detailItem = (DetailItem) value;

        JPanel panel = new JPanel(new GridLayout(3, 2, CELL_PADDING, CELL_PADDING));
        panel.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());

        // Add details to the panel
        panel.add(createLabel("Date:"));
        panel.add(createLabel(detailItem.getDate()));
        panel.add(createLabel("Time:"));
        panel.add(createLabel(detailItem.getTime()));
        panel.add(createLabel("Hospital:"));
        panel.add(createLabel(detailItem.getHospitalName()));

        // Set border around the panel
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

// Custom class to represent a detail item
class DetailItem {
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
