package pi.vezbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.Permission;
import pi.vezbe.repository.PermissionReposiory;

@Service
public class PermissionService {

	@Autowired
	private PermissionReposiory permissionReposiory;
	
	public Permission findById(Long id) {
		return permissionReposiory.findOne(id);
	}
	
	public Permission save(Permission permission) {
		return permissionReposiory.save(permission);
	}
	
	public void delete(Permission permission) {
		permissionReposiory.delete(permission);
	}
	
	public List<Permission> findByRoleId(Long roleId) {
		return permissionReposiory.findByRolesId(roleId);
	}
}
