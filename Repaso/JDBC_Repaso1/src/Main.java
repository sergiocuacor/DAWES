import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sergio.classicmodels.dtos.ClienteDTO;
import com.sergio.classicmodels.utils.DBUtils;
import com.sergio.classicmodels.view.ClientesView;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ClientesView cv = new ClientesView();
		cv.menuRecuperarClienteFiltroNombreTelefonoPais();
		
	}
}
