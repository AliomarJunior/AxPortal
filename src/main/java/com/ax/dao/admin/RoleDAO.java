package com.ax.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ax.entity.admin.Role;
import com.ax.factory.ConnectionFactory;

public class RoleDAO {

	public void save(Role role) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO role ");
		sql.append("(descricao,nivel) ");
		sql.append("VALUES (?,?)");

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement command = connection.prepareStatement(sql.toString());
		command.setString(1, role.getDescricao());
		command.setString(2, role.getNivel());
		command.executeUpdate();

	}

	public void delete(Role role) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM role ");
		sql.append("WHERE id = ? ");

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement command = connection.prepareStatement(sql.toString());
		command.setLong(1, role.getId());
		command.executeUpdate();
	}

	public void edit(Role role) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE role ");
		sql.append("SET ");
		sql.append("descricao = ? ");
		sql.append("nivel = ? ");
		sql.append("WHERE id = ? ");

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement command = connection.prepareStatement(sql.toString());
		command.setString(1, role.getDescricao());
		command.setString(2, role.getNivel());
		command.setLong(3, role.getId());
		command.executeUpdate();
	}

	public Role findById(Role role) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM role ");
		sql.append("WHERE id = ? ");
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement command = connection.prepareStatement(sql.toString());
		command.setLong(1, role.getId());
		ResultSet resultSet = command.executeQuery();
		Role resultRole = null;
		if (resultSet.next()) {
			resultRole = new Role();
			resultRole.setId(resultSet.getLong("id"));
			resultRole.setDescricao(resultSet.getString("descricao"));
			resultRole.setNivel(resultSet.getString("nivel"));
		}
		return resultRole;
	}
	
	public List<Role> findList() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM role ");
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement command = connection.prepareStatement(sql.toString());
		ResultSet resultSet = command.executeQuery();
		List<Role> roles = new ArrayList<Role>();
		while (resultSet.next()) {
			Role role = new Role();
			role.setId(resultSet.getLong("id"));
			role.setDescricao(resultSet.getString("descricao"));
			role.setNivel(resultSet.getString("nivel"));
			roles.add(role);
		}
		return roles;
	}
}