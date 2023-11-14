import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RandProductMaker extends JFrame {
    JPanel mainPanel;

    // Header panel assets
    JPanel headerPanel;
    JLabel header;
    Font headerFont = new Font("Comfortaa", Font.BOLD, 49);
    Color headerLabelColor = new Color(247, 246, 245, 255);
    Color headerBackgroundColor = new Color(28,33,40,255);


    // Main interface assets, which contains field to select file, as well as textArea to show extracted tags
    JPanel interfacePanel;
    JLabel productNameLabel;
    JLabel productDescLabel;
    JLabel productIDLabel;
    JLabel productPriceLabel;
    JLabel numRecordsLabel;
    JTextField productNameField;
    JTextField productDescField;
    JTextField productIDField;
    JTextField productPriceField;
    JTextField numRecordsField;
    JButton addButton;
    JButton exportButton;


    Font interfaceLabelFont = new Font("Arial", Font.PLAIN, 12);
    Color interfaceLabelColor = new Color(167,180,192,255);
    Color interfaceBackgroundColor = new Color(34,39,46,255);
    Color interfaceButtonColor = new Color(186, 185, 180);
    Color interfaceButtonTextColor = new Color(35,37,45);


    // Button Panel
    JPanel buttonPanel;
    JButton clearButton;
    JButton quitButton;


    // Program logic variables
    int numRecords = 0;
    ArrayList<Product> products = new ArrayList<>();
    File workingDirectory = new File(System.getProperty("user.dir"));
    Path file = Paths.get(workingDirectory.getPath() + "\\src\\productData.txt");



    public RandProductMaker() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        createHeaderPanel();
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        createInterfacePanel();
        mainPanel.add(interfacePanel, BorderLayout.CENTER);

        createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void createHeaderPanel() {
        headerPanel = new JPanel();
        headerPanel.setBackground(headerBackgroundColor);
        headerPanel.setLayout(new GridBagLayout());
        Dimension headerSize = new Dimension(1080, 100);
        headerPanel.setPreferredSize(headerSize);

        header = new JLabel("Product Maker");
        header.setFont(headerFont);
        header.setForeground(headerLabelColor);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        headerPanel.add(header, gbc);
    }

    private void createInterfacePanel() {
        interfacePanel = new JPanel();
        interfacePanel.setBackground(interfaceBackgroundColor);
        interfacePanel.setLayout(new GridBagLayout());

        productNameLabel = new JLabel("Name");
        productNameLabel.setFont(interfaceLabelFont);
        productNameLabel.setForeground(interfaceLabelColor);

        productNameField = new JTextField();
        productNameField.setColumns(18);

        productDescLabel = new JLabel("Description");
        productDescLabel.setFont(interfaceLabelFont);
        productDescLabel.setForeground(interfaceLabelColor);

        productDescField = new JTextField();
        productDescField.setColumns(24);

        productIDLabel = new JLabel("ID");
        productIDLabel.setFont(interfaceLabelFont);
        productIDLabel.setForeground(interfaceLabelColor);

        productIDField = new JTextField();
        productIDField.setColumns(8);

        productPriceLabel = new JLabel("Price");
        productPriceLabel.setFont(interfaceLabelFont);
        productPriceLabel.setForeground(interfaceLabelColor);

        productPriceField = new JTextField();
        productPriceField.setColumns(6);

        numRecordsLabel = new JLabel("Records:");
        numRecordsLabel.setFont(interfaceLabelFont);
        numRecordsLabel.setForeground(interfaceLabelColor);

        numRecordsField = new JTextField();
        numRecordsField.setColumns(2);
        numRecordsField.setEditable(false);

        addButton = new JButton("Add");
        addButton.setFont(interfaceLabelFont);
        addButton.setForeground(interfaceButtonTextColor);
        addButton.setBackground(interfaceButtonColor);
        addButton.addActionListener((ActionEvent ae) -> addRecord());

        exportButton = new JButton("Export");
        exportButton.setFont(interfaceLabelFont);
        exportButton.setForeground(interfaceButtonTextColor);
        exportButton.setBackground(interfaceButtonColor);
        exportButton.addActionListener((ActionEvent ae) -> exportProductData());


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        interfacePanel.add(productNameLabel, gbc);
        gbc.gridx = 1;
        interfacePanel.add(productNameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        interfacePanel.add(productDescLabel, gbc);
        gbc.gridx = 1;
        interfacePanel.add(productDescField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        interfacePanel.add(productIDLabel, gbc);
        gbc.gridx = 1;
        interfacePanel.add(productIDField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        interfacePanel.add(productPriceLabel, gbc);
        gbc.gridx = 1;
        interfacePanel.add(productPriceField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        interfacePanel.add(numRecordsLabel, gbc);
        gbc.gridx = 1;
        interfacePanel.add(numRecordsField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        interfacePanel.add(addButton, gbc);
        gbc.gridx = 1;
        interfacePanel.add(exportButton, gbc);
    }

    private void createButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setBackground(interfaceBackgroundColor);
        buttonPanel.setLayout(new GridBagLayout());

        clearButton = new JButton("Clear");
        clearButton.setFont(interfaceLabelFont);
        clearButton.setForeground(interfaceButtonTextColor);
        clearButton.setBackground(interfaceButtonColor);
        clearButton.addActionListener((ActionEvent ae) -> clearFields());

        quitButton = new JButton("Quit");
        quitButton.setFont(interfaceLabelFont);
        quitButton.setForeground(interfaceButtonTextColor);
        quitButton.setBackground(interfaceButtonColor);
        quitButton.addActionListener((ActionEvent ae) -> getQuitConfirm());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 5, 25, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(clearButton, gbc);
        gbc.gridx = 1;
        buttonPanel.add(quitButton, gbc);
    }

    private boolean anyFieldEmpty()
    {
        boolean fieldEmpty = true;
        ArrayList<JTextField> inputFields = new ArrayList<>();
        inputFields.add(productNameField);
        inputFields.add(productDescField);
        inputFields.add(productIDField);
        inputFields.add(productPriceField);

        for (JTextField field : inputFields)
        {
            fieldEmpty = field.getText().isEmpty();
        }
        return fieldEmpty;
    }

    private void clearFields()
    {
        ArrayList<JTextField> inputFields = new ArrayList<>();
        inputFields.add(productNameField);
        inputFields.add(productDescField);
        inputFields.add(productIDField);
        inputFields.add(productPriceField);

        for (JTextField field : inputFields)
        {
            field.setText("");
        }
    }

    private void addRecord()
    {
        if (anyFieldEmpty())
        {
            JOptionPane.showMessageDialog(null, "1 or more fields missing input.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            String name;
            String description;
            String ID;
            double price;

            name = productNameField.getText();
            description = productDescField.getText();
            ID = productIDField.getText();
            price = Double.parseDouble(productPriceField.getText());

            Product p = new Product(name, description, ID, price);
            products.add(p);

            numRecords++;
            numRecordsField.setText(String.valueOf(numRecords));
            clearFields();

            JOptionPane.showMessageDialog(null, "Product added successfully.", "Success", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void exportProductData()
    {
        if (products.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "No products entered.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try (RandomAccessFile randFile = new RandomAccessFile(String.valueOf(file), "rw"))
            {
                long currentPosition = 0L;

                for (Product p : products)
                {
                    String formattedName = String.format("%-35s", p.getName());
                    String formattedDesc = String.format("%-75s", p.getDescription());
                    String formattedID = String.format("%-6s", p.getID());

                    randFile.seek(currentPosition);
                    randFile.write(formattedName.getBytes(StandardCharsets.UTF_8));
                    randFile.write(formattedDesc.getBytes(StandardCharsets.UTF_8));
                    randFile.write(formattedID.getBytes(StandardCharsets.UTF_8));
                    randFile.writeDouble(p.getCost());

                    currentPosition += 124L;
                }
                JOptionPane.showMessageDialog(null, "Products exported.", "Success", JOptionPane.PLAIN_MESSAGE);
            }
            catch (IOException e)
            {
                JOptionPane.showMessageDialog(null, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void getQuitConfirm()
    {
        int quitConfirm;
        quitConfirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Exit", JOptionPane.YES_NO_OPTION);

        if (quitConfirm == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
}