package main;

import Controller.EmployeController;
import DAO.EmployeDAOImplement;
import Model.EmployeModel;
import View.EmployeView;

public class main {

	public static void main( String [] args) {
		EmployeView view=new EmployeView();
		EmployeDAOImplement dao=new  EmployeDAOImplement();
		EmployeModel model=new EmployeModel(dao);
		new EmployeController(model,view);
		view.setVisible(true);
		
	}
	
}
