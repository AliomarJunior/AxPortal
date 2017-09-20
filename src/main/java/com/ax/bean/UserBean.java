package com.ax.bean;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import com.ax.dao.admin.UserDAO;
import com.ax.entity.admin.User;
import com.ax.util.JSFUtil;

@ManagedBean(name="MBUser")
@ViewScoped
public class UserBean {
	
	private User user; 
	private ListDataModel<User> users;
	private Map<Long,String> roles;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public ListDataModel<User> getUsers() {
		return users;
	}

	public void setRoles(ListDataModel<User> users) {
		this.users = users;
	}
	
	public Map<Long, String> getRoles() {
		roles = new HashMap<Long, String>();
		roles.put(1L, "Admin");
		roles.put(2L, "User");
		return roles;
	}

	public void setRoles(Map<Long, String> roles) {
		this.roles = roles;
	}

	@PostConstruct
	public void loadUser(){
		UserDAO userDAO = new UserDAO();
		List<User> users;
		try {
			users = userDAO.findList();
			this.users = new ListDataModel<User>(users);
		} catch (SQLException e) {
			JSFUtil.sendMessageError(e.getMessage());
		}
	}
	
	public void createUser(){
		this.user = new User();
	}
	
	public void createUserFromRowData(){
		user = users.getRowData();
	}
	
	public void save(){
		UserDAO userDAO = new UserDAO();
		try {
			userDAO.save(user);
			this.loadUser();
			JSFUtil.sendMessageSucess("Usuario salva com sucesso!");
		} catch (SQLException e) {
			JSFUtil.sendMessageError(e.getMessage());
		}
	}
	
	public void delete(){
		UserDAO userDAO = new UserDAO();
		try {
			userDAO.delete(user);
			this.loadUser();
			JSFUtil.sendMessageSucess("Usuario excluida com sucesso!");
		} catch (SQLException e) {
			JSFUtil.sendMessageError(e.getMessage());
		}
	}
	
	public void edit(){
		UserDAO userDAO = new UserDAO();
		try {
			userDAO.edit(user);
			this.loadUser();
			JSFUtil.sendMessageSucess("Usuario Atualizada com sucesso!");
		} catch (SQLException e) {
			JSFUtil.sendMessageError(e.getMessage());
		}
	}
	
}
