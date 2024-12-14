package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import Model.*;
import Controller.*
;
public class EmployeDAOImplement  implements EmployeDAOI{
	public DBConnection connection= new DBConnection();
	public PreparedStatement stmt = null;
	@Override
	public void add(Employe employe) {
		String sql ="INSERT INTO Employe (nom,prenom,email,telephone,salaire,role,poste)values(?,?,?,?,?,?,?)";
		try( PreparedStatement stmt =connection.getConnexion().prepareStatement(sql)){
			stmt.setString(1, employe.getNom());
			stmt.setString(2, employe.getPrenom());
			stmt.setString(3, employe.getEmail());	
			stmt.setString(4, employe.getTelephone());
			stmt.setDouble(5, employe.getSalaire());
			stmt.setString(6, employe.getRole().name());
			stmt.setString(7, employe.getPoste().name());
			stmt.executeUpdate();	
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	 @Override
	public void delete(int id){
		String sql ="Delete from Employe where id=?" ;
		try(PreparedStatement stmt=connection.getConnexion().prepareStatement(sql)){
			stmt.setInt(1, id);
			 int rowsDeleted = stmt.executeUpdate(); 
		        if (rowsDeleted > 0) {
		            System.out.println("Employé supprimé avec succès !");
		            
		        } else {
		            System.out.println("Aucun employé trouvé avec l'ID : " + id);
		        }
		 } catch (SQLException e) {
		        e.printStackTrace();
		} 
		}
	 @Override
		
	 public void update(Employe employee) {
	         String sql = "UPDATE employe SET nom = ?, prenom = ?, telephone = ?, email = ?, salaire = ?, role = ?, poste = ? WHERE id = ?";

	        try (PreparedStatement stmt=connection.getConnexion().prepareStatement(sql)) {
	            stmt.setString(1, employee.getNom());
	            stmt.setString(2, employee.getPrenom());
	            stmt.setString(3, employee.getTelephone());
	            stmt.setString(4, employee.getEmail());
	            stmt.setDouble(5, employee.getSalaire());
	            stmt.setString(6, employee.getRole().toString());
	            stmt.setString(7, employee.getPoste().toString());
	            stmt.setInt(8, employee.getId());
	            int rowsUpdated = stmt.executeUpdate();
	            int id = employee.getId();
	            System.out.println("Trimmed ID: " + id);
	            System.out.println("Rows updated: " + rowsUpdated);

	            if (rowsUpdated > 0) {
	                System.out.println("Employee updated successfully.");
	            } else {
	                System.out.println("No rows updated. Please check if the ID is correct.");
	            }
	        } catch (SQLException e) {
	            System.err.println("Error updating employee: " + e.getMessage());
	        }
	    }

		 
	@Override
	public List<Employe> getAll(){
		  List<Employe> employes = new ArrayList<>();
		String sql="Select * from Employe";
		try (PreparedStatement stmt = connection.getConnexion().prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		            Employe employe = new Employe(
		                rs.getInt("id"),
		                rs.getString("nom"),
		                rs.getString("prenom"),
		                rs.getString("email"),
		                rs.getString("telephone"),
		                rs.getFloat("salaire"),
		                Role.valueOf(rs.getString("role")),
		                Poste.valueOf(rs.getString("poste"))
		            );
		            employes.add(employe);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return employes;
		
		
		
	}



}
