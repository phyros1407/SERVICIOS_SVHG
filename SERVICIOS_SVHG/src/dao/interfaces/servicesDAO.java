package dao.interfaces;

import java.util.ArrayList;

import beans.DepartamentoBean;
import beans.DistritoBean;
import beans.ProvinciaBean;

public interface servicesDAO {

	public ArrayList<DepartamentoBean> listarDepartamentos();
	public ArrayList<ProvinciaBean> listarProvincias(int id);
	public ArrayList<DistritoBean> listarDistritos(int id);
	
	
}
