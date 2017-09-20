package com.ax.bean;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import com.ax.dao.cadastro.ClienteDAO;
import com.ax.entity.cadastro.Cliente;
import com.ax.util.JSFUtil;

@ManagedBean(name="MBCliente")
@ViewScoped
public class ClienteBean {
	private Cliente cliente; 
	private ListDataModel<Cliente> clientes;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ListDataModel<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ListDataModel<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@PostConstruct
	public void loadCliente(){
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> cliente;
		try {
			cliente = clienteDAO.findList();
			this.clientes = new ListDataModel<Cliente>(cliente);
		} catch (SQLException e) {
			JSFUtil.sendMessageError(e.getMessage());
		}
	}
	
	public void createCliente(){
		cliente = new Cliente();
	}
	
	public void createClienteFromRowData(){
		cliente = clientes.getRowData();
	}
	
	public void save(){
		ClienteDAO clienteDAO = new ClienteDAO();
		try {
			clienteDAO.save(cliente);
			this.loadCliente();
			JSFUtil.sendMessageSucess("Cliente Salvo com sucesso.");
		} catch (SQLException e) {
			JSFUtil.sendMessageError(e.getMessage());
		}
	}
	
	public void delete(){
		ClienteDAO clienteDAO = new ClienteDAO();
		try{
		clienteDAO.delete(cliente);
		this.loadCliente();
		JSFUtil.sendMessageSucess("Cliente excluido com sucesso.");
		}catch(SQLException e){
			JSFUtil.sendMessageError(e.getMessage());
		}
	}
	
	public void edit(){
		ClienteDAO clienteDAO = new ClienteDAO();
		try{
		clienteDAO.edit(cliente);
		this.loadCliente();
		JSFUtil.sendMessageSucess("Cliente atualizado com sucesso.");
		}catch(SQLException e){
			JSFUtil.sendMessageError(e.getMessage());
		}		
	}
}
