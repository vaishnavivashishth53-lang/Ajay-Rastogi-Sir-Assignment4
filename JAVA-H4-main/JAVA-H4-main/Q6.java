import java.awt.*;
import java.awt.event.*;

public class Q6 extends Frame implements ActionListener {
    private TextField nameField, fatherField, ageField;
    private CheckboxGroup genderGroup;
    private Checkbox maleRadio, femaleRadio;
    private Choice courseChoice;
    private Checkbox cbDrawing, cbSinging, cbMusic, cbOthers;
    private TextArea addressArea;
    private Button saveButton, clearButton;

    public Q6() {
        setTitle("User Registration Form");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Set Cyan Frame Background (#00FFFF)
        Color cyanColor = new Color(0, 255, 255); // #00FFFF
        setBackground(cyanColor);

        // Header Title
        Label titleLabel = new Label("Registration Form");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.BLUE); // Dark blue header for contrast
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;

        // Name
        Label lblName = new Label("Name");
        lblName.setForeground(Color.BLACK);
        gbc.gridx = 0; gbc.gridy = 1;
        add(lblName, gbc);

        nameField = new TextField(25);
        styleTextField(nameField);
        gbc.gridx = 1;
        add(nameField, gbc);

        // Father Name
        Label lblFather = new Label("Father Name");
        lblFather.setForeground(Color.BLACK);
        gbc.gridx = 0; gbc.gridy = 2;
        add(lblFather, gbc);

        fatherField = new TextField(25);
        styleTextField(fatherField);
        gbc.gridx = 1;
        add(fatherField, gbc);

        // Age
        Label lblAge = new Label("Age");
        lblAge.setForeground(Color.BLACK);
        gbc.gridx = 0; gbc.gridy = 3;
        add(lblAge, gbc);

        ageField = new TextField(25);
        styleTextField(ageField);
        gbc.gridx = 1;
        add(ageField, gbc);

        // Gender
        Label lblGender = new Label("Gender");
        lblGender.setForeground(Color.BLACK);
        gbc.gridx = 0; gbc.gridy = 4;
        add(lblGender, gbc);

        Panel genderPanel = new Panel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        genderPanel.setBackground(cyanColor);
        genderGroup = new CheckboxGroup();
        maleRadio = new Checkbox("Male", genderGroup, true);
        femaleRadio = new Checkbox("Female", genderGroup, false);
        maleRadio.setForeground(Color.BLACK);
        femaleRadio.setForeground(Color.BLACK);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        gbc.gridx = 1;
        add(genderPanel, gbc);

        // Course
        Label lblCourse = new Label("Course");
        lblCourse.setForeground(Color.BLACK);
        gbc.gridx = 0; gbc.gridy = 5;
        add(lblCourse, gbc);

        courseChoice = new Choice();
        courseChoice.add("Java");
        courseChoice.add("C++");
        courseChoice.add("Python");
        courseChoice.add("Data Structures");
        gbc.gridx = 1;
        add(courseChoice, gbc);

        // Hobbies
        Label lblHobbies = new Label("Hobbies");
        lblHobbies.setForeground(Color.BLACK);
        gbc.gridx = 0; gbc.gridy = 6;
        add(lblHobbies, gbc);

        Panel hobbiesPanel = new Panel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        hobbiesPanel.setBackground(cyanColor);
        cbDrawing = new Checkbox("Drawing");
        cbSinging = new Checkbox("Singing");
        cbMusic = new Checkbox("Music");
        cbOthers = new Checkbox("Others");

        cbDrawing.setForeground(Color.BLACK);
        cbSinging.setForeground(Color.BLACK);
        cbMusic.setForeground(Color.BLACK);
        cbOthers.setForeground(Color.BLACK);

        hobbiesPanel.add(cbDrawing);
        hobbiesPanel.add(cbSinging);
        hobbiesPanel.add(cbMusic);
        hobbiesPanel.add(cbOthers);
        gbc.gridx = 1;
        add(hobbiesPanel, gbc);

        // Address
        Label lblAddress = new Label("Address");
        lblAddress.setForeground(Color.BLACK);
        gbc.gridx = 0; gbc.gridy = 7;
        add(lblAddress, gbc);

        addressArea = new TextArea(4, 25);
        addressArea.setBackground(Color.WHITE);
        addressArea.setForeground(Color.BLACK);
        gbc.gridx = 1;
        add(addressArea, gbc);

        // Buttons
        Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBackground(cyanColor);
        saveButton = new Button("Save Details");
        clearButton = new Button("Clear All");
        saveButton.setBackground(Color.BLUE);
        saveButton.setForeground(Color.WHITE);
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);

        saveButton.addActionListener(this);
        clearButton.addActionListener(this);

        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);

        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2;
        add(buttonPanel, gbc);

        setSize(500, 500);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void styleTextField(TextField tf) {
        tf.setBackground(Color.WHITE);
        tf.setForeground(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            StringBuilder hobbies = new StringBuilder();
            if (cbDrawing.getState()) hobbies.append("Drawing ");
            if (cbSinging.getState()) hobbies.append("Singing ");
            if (cbMusic.getState()) hobbies.append("Music ");
            if (cbOthers.getState()) hobbies.append("Others ");

            String details = "=== Registration Successful ===\n" +
                    "Name: " + nameField.getText() + "\n" +
                    "Father Name: " + fatherField.getText() + "\n" +
                    "Age: " + ageField.getText() + "\n" +
                    "Gender: " + genderGroup.getSelectedCheckbox().getLabel() + "\n" +
                    "Course: " + courseChoice.getSelectedItem() + "\n" +
                    "Hobbies: " + hobbies.toString() + "\n" +
                    "Address: " + addressArea.getText();

            // Dialog Pop-up
            Dialog d = new Dialog(this, "Success", true);
            d.setLayout(new FlowLayout());
            d.add(new Label("Student registered successfully!"));
            TextArea detailsText = new TextArea(details, 8, 35, TextArea.SCROLLBARS_VERTICAL_ONLY);
            detailsText.setEditable(false);
            detailsText.setBackground(Color.WHITE);
            detailsText.setForeground(Color.BLACK);
            d.add(detailsText);

            Button ok = new Button("OK");
            ok.addActionListener(ae -> d.setVisible(false));
            d.add(ok);
            d.setSize(350, 250);
            d.setLocationRelativeTo(this);
            d.setVisible(true);

        } else if (e.getSource() == clearButton) {
            nameField.setText("");
            fatherField.setText("");
            ageField.setText("");
            addressArea.setText("");
            cbDrawing.setState(false);
            cbSinging.setState(false);
            cbMusic.setState(false);
            cbOthers.setState(false);
        }
    }

    public static void main(String[] args) {
        new Q6();
    }
}