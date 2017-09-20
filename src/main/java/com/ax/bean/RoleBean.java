package com.ax.bean;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import com.ax.dao.admin.RoleDAO;
import com.ax.entity.admin.Role;
import com.ax.util.JSFUtil;

@ManagedBean(name="MBRole")
@ViewScoped
public class RoleBean {
	
	private Role role; 
	private ListDataModel<Role> roles;
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

	public ListDataModel<Role> getRoles() {
		return roles;
	}

	public void setRoles(ListDataModel<Role> roles) {
		this.roles = roles;
	}
	
	@PostConstruct
	public void loadRoles(){
		RoleDAO roleDAO = new RoleDAO();
		List<Role> roles;
		try {
			roles = roleDAO.findList();
			this.roles = new ListDataModel<Role>(roles);
		} catch (SQLException e) {
			JSFUtil.sendMessageError(e.getMessage());
		}
	}
	
	public void createRole(){
		this.role = new Role();
	}
	
	public void createRoleFromRowData(){
		role = roles.getRowData();
	}
	
	public void save(){
		RoleDAO roleDAO = new RoleDAO();
		try {
			roleDAO.save(role);
			this.loadRoles();
			JSFUtil.sendMessageSucess("Regra salva com sucesso!");
		} catch (SQLException e) {
			JSFUtil.sendMessageError(e.getMessage());
		}
	}
	
	public void delete(){
		RoleDAO roleDAO = new RoleDAO();
		try {
			roleDAO.delete(role);
			this.loadRoles();
			JSFUtil.sendMessageSucess("Regra excluida com sucesso!");
		} catch (SQLException e) {
			JSFUtil.sendMessageError(e.getMessage());
		}
	}
	
	public void edit(){
		RoleDAO roleDAO = new RoleDAO();
		try {
			roleDAO.edit(role);
			this.loadRoles();
			JSFUtil.sendMessageSucess("Regra Atualizada com sucesso!");
		} catch (SQLException e) {
			JSFUtil.sendMessageError(e.getMessage());
		}
	}
	
}
