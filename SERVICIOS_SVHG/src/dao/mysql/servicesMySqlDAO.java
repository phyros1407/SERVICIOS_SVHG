package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import beans.DepartamentoBean;
import beans.DistritoBean;
import beans.ProvinciaBean;
import dao.factory.MySqlDAOFactory;
import dao.interfaces.servicesDAO;

public class servicesMySqlDAO extends MySqlDAOFactory implements servicesDAO{

	@Override
	public ArrayList<DepartamentoBean> listarDepartamentos() {
		// TODO Auto-generated method stub
		
		ArrayList<DepartamentoBean> departamentos = new ArrayList<DepartamentoBean>();
		
		try{
			
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			String query = "SELECT * FROM T_DEPARTAMENTO";
			
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(query);
			
			DepartamentoBean departamento = null;
			while(rs.next()){
				departamento = new DepartamentoBean();
				departamento.setId(rs.getInt("id"));
				departamento.setDepartamento(rs.getString("departamento"));
				departamentos.add(departamento);
			}
			
			//CERRANDO CONEXION
			rs.close();
			stmt.close();
			con.close();
			
			
		}catch(Exception e){
			
			e.getMessage();
			
		}
		
		
		return departamentos;
	}

	@Override
	public ArrayList<ProvinciaBean> listarProvincias(int id) {
		// TODO Auto-generated method stub
		

		ArrayList<ProvinciaBean> provincias = new ArrayList<ProvinciaBean>();
		
		try{
			
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			String query = "SELECT * FROM T_PROVINCIA WHERE ID_DEPARTAMENTO = "+id;
			
			ResultSet rs = stmt.executeQuery(query);
			
			ProvinciaBean provincia = null;
			
			while(rs.next()){
				provincia = new ProvinciaBean();
				provincia.setId(rs.getInt("id"));
				provincia.setProvincia(rs.getString("provincia"));
				provincia.setId_departamento(rs.getInt("id_departamento"));
				provincias.add(provincia);
			}
			
			//CERRANDO CONEXION
			rs.close();
			stmt.close();
			con.close();
			
			
		}catch(Exception e){
			
			e.getMessage();
			
		}
		
		
		return provincias;
	}

	@Override
	public ArrayList<DistritoBean> listarDistritos(int id) {
		// TODO Auto-generated method stub
		
		
		ArrayList<DistritoBean> distritos = new ArrayList<DistritoBean>();
		
		try{
			
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			String query = "SELECT * FROM T_DISTRITO WHERE ID_PROVINCIA = "+id;
			
			ResultSet rs = stmt.executeQuery(query);
			
			DistritoBean distrito = null;
			
			while(rs.next()){
				distrito = new DistritoBean();
				distrito.setId(rs.getInt("id"));
				distrito.setDistrito(rs.getString("distrito"));
				distrito.setId_provincia(rs.getInt("id_provincia"));
				distritos.add(distrito);
			}
			
			//CERRANDO CONEXION
			rs.close();
			stmt.close();
			con.close();
			
			
		}catch(Exception e){
			
			e.getMessage();
			
		}
		
		
		
		
		return distritos;
	}

}
