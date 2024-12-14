package DAO;

import java.util.List;

import Model.*;

public interface EmployeDAOI {

	void add(Employe employe);
	void delete(int id);
	void update(Employe employe);
	List<Employe> getAll();
	
	
}