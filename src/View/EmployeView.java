package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Model.Poste;
import Model.Role;
import java.awt.*;

public class EmployeView extends JFrame {

    public JPanel mainPanel;
    public JPanel formPanel;
    public JPanel buttonPanel;

    public JLabel idLabel, nomLabel, prenomLabel, telephoneLabel, emailLabel, salaireLabel, roleLabel, posteLabel;
    public JTextField idField, nomField, prenomField, telephoneField, emailField, salaireField;
    public JComboBox<Role> roleDropdown;
    public JComboBox<Poste> posteDropdown;
    public JTable employeTable;
    public DefaultTableModel tableModel;
    public JScrollPane tableScrollPane;
    public JButton addButton, updateButton, deleteButton, displayButton;

    public EmployeView() {
        setTitle("Gestion des Employés");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panels
        mainPanel = new JPanel(new BorderLayout());
        formPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        buttonPanel = new JPanel(new FlowLayout());

        // Labels
      //  idLabel = new JLabel("ID:");
        nomLabel = new JLabel("Nom:");
        prenomLabel = new JLabel("Prénom:");
        telephoneLabel = new JLabel("Téléphone:");
        emailLabel = new JLabel("Email:");
        salaireLabel = new JLabel("Salaire:");
        roleLabel = new JLabel("Rôle:");
        posteLabel = new JLabel("Poste:");

        // Text Fields
    //    idField = new JTextField(10);
        nomField = new JTextField(10);
        prenomField = new JTextField(10);
        telephoneField = new JTextField(10);
        emailField = new JTextField(10);
        salaireField = new JTextField(10);

        // Dropdowns
        roleDropdown = new JComboBox<>(Role.values());
        posteDropdown = new JComboBox<>(Poste.values());

        // Add components to form panel
       // formPanel.add(idLabel);
    //    formPanel.add(idField);
        formPanel.add(nomLabel);
        formPanel.add(nomField);
        formPanel.add(prenomLabel);
        formPanel.add(prenomField);
        formPanel.add(telephoneLabel);
        formPanel.add(telephoneField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(salaireLabel);
        formPanel.add(salaireField);
        formPanel.add(roleLabel);
        formPanel.add(roleDropdown);
        formPanel.add(posteLabel);
        formPanel.add(posteDropdown);

        // Table
        String[] columnNames = {"ID", "Nom", "Prénom", "Téléphone", "Email", "Salaire", "Rôle", "Poste"};
        tableModel = new DefaultTableModel(columnNames, 0);
        employeTable = new JTable(tableModel);
        tableScrollPane = new JScrollPane(employeTable);

        // Buttons
        addButton = new JButton("Ajouter");
        updateButton = new JButton("Modifier");
        deleteButton = new JButton("Supprimer");
        displayButton = new JButton("Afficher");

        // Add buttons to button panel
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(displayButton);

       
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Final setup
        add(mainPanel);
        setVisible(true);
    }

    // Getters and Setters for components
    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getDisplayButton() {
        return displayButton;
    }

    public void setDisplayButton(JButton displayButton) {
        this.displayButton = displayButton;
    }
}
