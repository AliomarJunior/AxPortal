package com.ax.dao.cadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ax.entity.cadastro.Cliente;
import com.ax.factory.ConnectionFactory;

public class ClienteDAO {

	public void save(Cliente cliente) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO cliente ");
		sql.append("(name,cpf,email,phone,vip) ");
		sql.append("VALUES (?,?,?,?,?)");

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement command = connection.prepareStatement(sql.toString());
		command.setString(1, cliente.getName());
		command.setString(2, cliente.getCPF());
		command.setString(3, cliente.getEmail());
		command.setString(4, cliente.getPhone());	
		command.setBoolean(5, cliente.getVip());
		command.executeUpdate();

	}

	public void delete(Cliente cliente) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM cliente ");
		sql.append("WHERE id = ? ");

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement command = connection.prepareStatement(sql.toString());
		command.setLong(1, cliente.getId());
		command.executeUpdate();
	}

	public void edit(Cliente cliente) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE cliente ");
		sql.append("SET ");
		sql.append("name = ? ,");
		sql.append("cpf = ? ,");
		sql.append("email = ? ,");
		sql.append("phone = ? ,");
		sql.append("vip = ? ");
		sql.append("WHERE id = ? ");

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement command = connection.prepareStatement(sql.toString());
		command.setString(1, cliente.getName());
		command.setString(2, cliente.getCPF());
		command.setString(3, cliente.getEmail());
		command.setString(4, cliente.getPhone());	
		command.setBoolean(5, cliente.getVip());
		command.setLong(6, cliente.getId());
		command.executeUpdate();
	}

	public Cliente findById(Cliente cliente) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM cliente ");
		sql.append("WHERE id = ? ");
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement command = connection.prepareStatement(sql.toString());
		command.setLong(1, cliente.getId());
		ResultSet resultSet = command.executeQuery();
		Cliente clienteResult = null;
		if (resultSet.next()) {
			clienteResult = new Cliente();
			clienteResult.setId(resultSet.getLong("id"));
			clienteResult.setName(resultSet.getString("name"));
			clienteResult.setCPF(resultSet.getString("cpf"));
			clienteResult.setEmail(resultSet.getString("email"));
			clienteResult.setPhone(resultSet.getString("phone"));
			clienteResult.setVip(resultSet.getBoolean("vip"));
		}
		return clienteResult;
	}
	
	public List<Cliente> findList() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM cliente ");
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement command = connection.prepareStatement(sql.toString());
		ResultSet resultSet = command.executeQuery();
		List<Cliente> clientes = new ArrayList<Cliente>();
		while (resultSet.next()) {
			Cliente cliente = new Cliente();
			cliente.setId(resultSet.getLong("id"));
			cliente.setName(resultSet.getString("name"));
			cliente.setCPF(resultSet.getString("cpf"));
			cliente.setEmail(resultSet.getString("email"));
			cliente.setPhone(resultSet.getString("phone"));
			cliente.setVip(resultSet.getBoolean("vip"));
			clientes.add(cliente);
		}
		return clientes;
	}
}
