package com.ax.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ax.entity.admin.Role;
import com.ax.entity.admin.User;
import com.ax.factory.ConnectionFactory;

public class UserDAO {
	
	public void save(User user) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO user ");
		sql.append("(name, password, datecadastro, role) ");
		sql.append("Values(?, ?, ?, ?)");
		
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement command = connection.prepareStatement(sql.toString());
		command.setString(1, user.getNome());
		command.setString(2, "1234'");
		command.setDate(3, user.getDateCreated());
		command.setLong(4, user.getRole().getId());
		command.executeUpdate();
	}
	
	public void delete(User user) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM user ");
		sql.append("WHERE id = ? ");

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement command = connection.prepareStatement(sql.toString());
		command.setLong(1, user.getId());
		command.executeUpdate();
	}

	public void edit(User user) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE user ");
		sql.append("SET ");
		sql.append("name = ? ");
		sql.append("role = ? ");
		sql.append("WHERE id = ? ");

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement command = connection.prepareStatement(sql.toString());
		command.setString(1, user.getNome());
		command.setLong(2, user.getRole().getId());
		command.setLong(3, user.getId());
		command.executeUpdate();
	}

	public User findById(User user) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM role ");
		sql.append("WHERE id = ? ");
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement command = connection.prepareStatement(sql.toString());
		command.setLong(1, user.getId());
		ResultSet resultSet = command.executeQuery();
		User resultUser = null;
		if (resultSet.next()) {
			resultUser = new User();
			resultUser.setId(resultSet.getLong("id"));
			resultUser.setNome(resultSet.getString("nome"));
			Role role = new Role();
			role.setId(resultSet.getLong("role"));
			resultUser.setRole(role);
		}
		return resultUser;
	}
	
	public List<User> findList() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM user ");
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement command = connection.prepareStatement(sql.toString());
		ResultSet resultSet = command.executeQuery();
		List<User> users = new ArrayList<User>();
		while (resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getLong("id"));
			user.setNome(resultSet.getString("descricao"));
			Role role = new Role();
			role.setId(resultSet.getLong("role"));
			user.setRole(role);
			users.add(user);
		}
		return users;
	}
}
