package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;/*ANOTACAO DO @MANAGEDBEAN*/
import javax.faces.bean.ViewScoped;/*ANOTACAO DO @VIEWSCOPED*/
import javax.faces.model.ListDataModel;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {
	private ListDataModel<Fabricante> itens;

	public ListDataModel<Fabricante> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Fabricante> itens) {
		this.itens = itens;
	}

	@PostConstruct /*sera chamado antes da pagina ser desenhada*/
	public void prepararPesquisa() {
		try {
			FabricanteDAO dao = new FabricanteDAO(); /* criou o DAO */
			ArrayList<Fabricante> lista = dao
					.listar();/*
								 * Capturei os dados do banco de dados e gravei
								 * no lista
								 */
			itens = new ListDataModel<Fabricante>(
					lista);/* converter o lista em ListDataModel */
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
