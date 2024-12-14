package Controller;
import View.*;
import DAO.*;
import Model.*;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmployeController {
	private EmployeModel model;
	private EmployeView view;
	
	
	public EmployeController(EmployeModel model,EmployeView view) {
		this.view=view;
		this.model=model;
		
		this.view.addButton.addActionListener(e -> addEmploye());
		this.view.deleteButton.addActionListener(e -> deleteEmploye ());
		this.view.displayButton.addActionListener(e -> displayEmployes());
		this.view.updateButton.addActionListener(e -> updateEmploye());
	}
	
		private void addEmploye() {
			
			String name =view.nomField.getText();
			String prenom=view.prenomField.getText();
			float salaire = Float.parseFloat(view.salaireField.getText());
			String telephone=view.telephoneField.getText();
			Role role = (Role) view.roleDropdown.getSelectedItem();
            Poste poste = (Poste) view.posteDropdown.getSelectedItem();
			String email;
			
			try{
				email =view.emailField.getText();
			}
			catch(Exception e){
				 JOptionPane.showMessageDialog(view, "Invalide email !.");
				 return;
            }	
			boolean AjoutReaussit= model.add(name,prenom,email,telephone,salaire,role,poste);
			if(AjoutReaussit) {
				 JOptionPane.showMessageDialog(view, "L'employee est ajouter avec succees !");
			}else { 
				 JOptionPane.showMessageDialog(view, "Ajout est echoue !");
			}
	}
		
		private void deleteEmploye() {
			int selectedRow = view.employeTable.getSelectedRow();
			if(selectedRow == -1 ) {
				   JOptionPane.showMessageDialog(view, "Veuillez sélectionner un employé à supprimer !");
			        		
			}
			
			int id =(int)view.tableModel.getValueAt(selectedRow, 0);
			EmployeDAOImplement employeeDAO = new EmployeDAOImplement();  
			employeeDAO.delete(id); 
		}
		
		
		private void updateEmploye() {
			 int selectedRow = view.employeTable.getSelectedRow(); 
             if (selectedRow != -1) {
                 try {
                	
                     String nom = view.nomField.getText();
                     String prenom = view.prenomField.getText();
                     String telephone = view.telephoneField.getText();
                     String email = view.emailField.getText();  
                     double salaire = Double.parseDouble(view.salaireField.getText()); 
                     Role role = (Role) view.roleDropdown.getSelectedItem();
                     Poste poste = (Poste) view.posteDropdown.getSelectedItem();

                     int id =(int)view.tableModel.getValueAt(selectedRow, 0);
                     boolean success = model.update(id,nom,prenom,email,telephone,salaire,role,poste);
                     if (success) {
                         view.employeTable.setValueAt(nom, selectedRow, 1);
                         view.employeTable.setValueAt(prenom, selectedRow, 2);
                         view.employeTable.setValueAt(telephone, selectedRow, 3);
                         view.employeTable.setValueAt(email, selectedRow, 4);
                         view.employeTable.setValueAt(salaire, selectedRow, 5);
                         view.employeTable.setValueAt(role, selectedRow, 6);
                         view.employeTable.setValueAt(poste, selectedRow, 7);
                         JOptionPane.showMessageDialog(view, "La mise à jour avec succee.");
                     } else {
                         JOptionPane.showMessageDialog(view, "La mise à jour a échoué.");
                     }
                 } catch (NumberFormatException ex) {
                     JOptionPane.showMessageDialog(view, "Invalid input for ID or salary.", "Error", JOptionPane.ERROR_MESSAGE);
                 }
             } else {
                 JOptionPane.showMessageDialog(view, "Please select a row to modify.");
             }
         }
 

		private void displayEmployes() {
		    List<Employe> employes = model.getAllEmployes();
		    DefaultTableModel tableModel = (DefaultTableModel) view.employeTable.getModel();
		    tableModel.setRowCount(0);

		    for (Employe employe : employes) {
		        tableModel.addRow(new Object[]{
		            employe.getId(),
		            employe.getNom(),
		            employe.getPrenom(),
		            employe.getTelephone(),
		            employe.getEmail(),
		            employe.getSalaire(),
		            employe.getRole(),
		            employe.getPoste()
		        });
		    }
		}
		
}
