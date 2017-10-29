package com.ax.test;

import java.sql.SQLException;

import javax.management.DescriptorKey;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.ax.dao.cadastro.ClienteDAO;
import com.ax.entity.cadastro.Cliente;

public class ClienteTest {
	
	private static ClienteDAO clienteDAO;
	private static Cliente cliente;
	
	@BeforeClass
	public static void setUp(){
		clienteDAO = new ClienteDAO();
		cliente = new Cliente();
		cliente.setName("clienteTest");
		cliente.setCPF("211.000.555-42");
		cliente.setEmail("clienteTest@ax.com");
		cliente.setPhone("1199871234");
		cliente.setVip(true);
	}
	
	@Test
	public void testeGRUDCliente() throws Exception{
		/*incluirCliente();
		consultarCliente();
		atualizarCliente();
		excluirCliente();*/
	}

	public void incluirCliente() throws SQLException{
		clienteDAO.save(cliente);
	}
	
	public void consultarCliente() throws Exception{
		for (Cliente c : clienteDAO.findList()) {
			if(cliente.getCPF().equals(c.getCPF())){
				cliente.setId(c.getId());
				return;
			}
		}
		
		throw new Exception("cliente n�o foi localizado");
	}
	
	public void atualizarCliente() throws Exception{
		consultarCliente();
		cliente.setName("clienteTestEdit");
		clienteDAO.edit(cliente);
	}
	
	public void excluirCliente() throws Exception{
		consultarCliente();
		clienteDAO.delete(cliente);
	}
	
}
