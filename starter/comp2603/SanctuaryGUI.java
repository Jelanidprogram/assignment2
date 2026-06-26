package comp2603;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Swing GUI for searching and viewing animals in a sanctuary.
 *
 * Layout:
 *   NORTH:  Search field, type combo box, injured checkbox, search button
 *   CENTER: Scrollable text area showing results
 *   SOUTH:  Status label showing match count
 */
public class SanctuaryGUI extends JFrame {
    // TODO M10: Declare private Sanctuary field
    private Sanctuary sanctuary;

    // TODO M9: Declare GUI components:
    //   JTextField nameField
    //   JComboBox<String> typeCombo
    //   JCheckBox injuredCheck
    //   JButton searchButton
    //   JTextArea resultArea
    //   JLabel statusLabel
    private JTextField searchField;
    private JComboBox<String> typeCombo;
    private JCheckBox injuredCheck;
    private JButton searchButton;
    private JTextArea resultArea;
    private JLabel statusLabel;


    public SanctuaryGUI() {
        super("Caribbean Wildlife Conservation Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);

        // TODO M9: Set layout to BorderLayout
        setLayout(new BorderLayout(10, 10));
        // TODO M9: Build NORTH panel (FlowLayout)
        //   Add JLabel "Search:", JTextField (14 columns), JLabel "Type:",
        //   JComboBox with {"All","Bird","Reptile","Marine"},
        //   JCheckBox "Injured/Critical only", JButton "Search"
        //   Add panel to NORTH
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        northPanel.add(new JLabel("Search"));
        searchField = new JTextField(14);

        northPanel.add(searchField);
        northPanel.add(new JLabel("Type:"));
        String[] types = {"All", "Bird", "Reptile", "Marine"};
        typeCombo = new JComboBox<>(types);
       northPanel.add(typeCombo);

        injuredCheck = new JCheckBox("Injured/Critical only");
        northPanel.add(injuredCheck);

        searchButton = new JButton("Search");
        northPanel.add(searchButton);
        add(northPanel, BorderLayout.NORTH);

        // TODO M9: Build CENTER
        //   Create JTextArea, set monospaced font, make non-editable
        //   Wrap in JScrollPane, add to CENTER
resultArea = new JTextArea();
resultArea.setFont(new Font("Monospaced", Font.PLAIN,12));
resultArea.setEditable(false);
JScrollPane scrollPane = new JScrollPane(resultArea);
add(scrollPane, BorderLayout.CENTER);

        // TODO M9: Build SOUTH
        //   Create JLabel "Ready", add to SOUTH
 statusLabel = new JLabel("Ready");
 add(statusLabel, BorderLayout.SOUTH);
        // TODO M11: Add ActionListener to searchButton that calls runSearch()

        searchButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        runSearch();
    }
});
        // TODO M11: Add KeyListener to nameField that calls runSearch() on keyReleased
       searchField.addKeyListener(new KeyAdapter() {
       @Override
           public void keyReleased(KeyEvent e){
           runSearch();
       }
       });

        setLocationRelativeTo(null);
}
    /**
     * Stores the Sanctuary to search over.
     * TODO M10: Implement setModel
     */


    public void setModel(Sanctuary s) {
        // TODO M10: Store the sanctuary reference
        // TODO M10: Optionally update the window title
        this.sanctuary = s;
        if (s != null) {
            setTitle("Caribbean Wildlife Conservation Tracker - " + s.getName()); // optional
        }
        runSearch();
    }

    /**
     * Filters the sanctuary's animals based on the GUI controls and
     * displays matching results.
     * <p>
     * TODO M11: Implement runSearch
     * <p>
     * Steps:
     * 1. Get text from nameField (trim, convert to lowercase)
     * 2. Get selected type from typeCombo
     * 3. Get checkbox state from injuredCheck
     * 4. Loop through sanctuary's animals:
     * - If text is non-empty, keep only animals whose species or nickname
     * contains the text (case-insensitive)
     * - If type is not "All", keep only matching type
     * - If checkbox is selected, keep only "Injured" or "Critical" animals
     * 5. Build result string and set in resultArea
     * 6. Set statusLabel: "No matches", "1 result", or "N results"
     */
    private void runSearch() {
        // TODO M11: Implement filtering and display
        if (sanctuary == null) {
            statusLabel.setText("There is no Sanctuary");
            return;
        }
        String searchText = searchField.getText().trim().toLowerCase();

        String fromComboBox = (String) typeCombo.getSelectedItem();

        boolean isInjured = injuredCheck.isSelected();

        ArrayList<Animal> filterResults = new ArrayList<>();
        for (Animal a : sanctuary.getAnimals()) {
            boolean filterPass = true; // set all animals to pass the filters by defauly and then modify later.
// search text match?
            if (!searchText.isEmpty()) {
                String species = a.getSpecies().toLowerCase();
                String nickname = a.getNickname().toLowerCase();

                if (!species.contains(searchText) && !nickname.contains(searchText)) {
                    filterPass = false;
                }
            }

   // filter by type
            if (!fromComboBox.equals("All")) {
                    if(!a.getType().equals(fromComboBox)){
                        filterPass = false;

            }
        }
            // Health status.
            if(isInjured){
                if(!a.getHealthStatus().equals("Injured") && !a.getHealthStatus().equals("Critical")){
                    filterPass = false; // animals are in goog condition so it doesnt fall into this category.
                }
            }
            if(filterPass){
                filterResults.add(a);
            }
    }

        StringBuilder sb = new StringBuilder();
        for(Animal a : filterResults){
            sb.append(a.toString()).append("\n");
        }
        resultArea.setText(sb.toString()); // stringbuilder set to the text area.

      // 29 status label update

        int count = filterResults.size();
        if (count == 0) {
            statusLabel.setText("No matches");
        }
        else if (count == 1) {
            statusLabel.setText("1 result");
        }
        else {
            statusLabel.setText(count + " results");
        }
}


    /**
     * Creates a demo sanctuary, populates it, and launches the GUI.
     *
     * TODO M12: Implement main method
     */

    public static void main(String[] args) {
        // TODO M12: Create Sanctuary, add animals, create GUI, wire model, show

        Sanctuary caroni = new Sanctuary("Caroni Bird Sanctuary", "Trinidad", 20);
        Bird b1 = new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true);
         Bird b2 = new Bird("Scarlet Ibis", "Blaze", "Trinidad", 0.40, "Healthy", 58.0, true);
            Bird b3 = new Bird("Cocrico", "Dusty", "Trinidad", 0.25, "Injured", 30.0, true);
          Reptile r1 = new Reptile("Spectacled Caiman", "Brutus", "Trinidad", 45.0, "Healthy", false, 180.0);
             Reptile r2 = new Reptile("Green Anaconda", "Medusa", "Trinidad", 30.0, "Critical", false, 350.0);
          Marine m1 = new Marine("Leatherback Turtle", "Atlas", "Trinidad", 500.0, "Healthy", 1200.0, 8000);

        caroni.addAnimal(b1);
        caroni.addAnimal(b2);
        caroni.addAnimal(b3);
        caroni.addAnimal(r1);
        caroni.addAnimal(r2);
        caroni.addAnimal(m1);


    SanctuaryGUI gui = new SanctuaryGUI();
    gui.setModel(caroni);
    gui.setVisible(true);
    }
}

