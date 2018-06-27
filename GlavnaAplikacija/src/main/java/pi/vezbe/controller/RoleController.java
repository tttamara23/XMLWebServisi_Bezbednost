package pi.vezbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pi.vezbe.annotations.PermissionAnnotation;
import pi.vezbe.converters.RoleToRoleDTOConverter;
import pi.vezbe.model.Permission;
import pi.vezbe.model.Role;
import pi.vezbe.service.PermissionService;
import pi.vezbe.service.RoleService;

@RestController()
@RequestMapping(value = "/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private RoleToRoleDTOConverter roleToRoleDTOConverter;
	
	@PermissionAnnotation(name = "GET_ROLES")
	@CrossOrigin
	@RequestMapping(
            value = "/getRoles",
            method = RequestMethod.GET
    )
	public ResponseEntity<?> getRoles() {
		return new ResponseEntity<>(roleToRoleDTOConverter.convert(roleService.getAll()), HttpStatus.OK);
	}
	
	@PermissionAnnotation(name = "ADD_PERMISSION_TO_ROLE")
	@CrossOrigin
	@RequestMapping(
            value = "/addPermissionToRole/{idRole}/{idPermission}",
            method = RequestMethod.GET
    )
	public ResponseEntity<?> addPermissionToRole(@PathVariable Long idRole, @PathVariable Long idPermission) {
		Role role = roleService.findById(idRole);
		Permission permission = permissionService.findById(idPermission);
		if(role == null || permission == null) {
			return new ResponseEntity<>("Role or permission doesn't exist.", HttpStatus.BAD_REQUEST);
		}
		for(Permission p : role.getPermissions()) {
			if(p.getId().equals(permission.getId())) {
				return new ResponseEntity<>("Permission exists for this role.", HttpStatus.BAD_REQUEST);
			}
		}
		role.getPermissions().add(permission);
		roleService.save(role);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PermissionAnnotation(name = "DELETE_PERMISSION_TO_ROLE")
	@CrossOrigin
	@RequestMapping(
            value = "/deletePermissionToRole/{idRole}/{idPermission}",
            method = RequestMethod.DELETE
    )
	public ResponseEntity<?> deletePermissionToRole(@PathVariable Long idRole, @PathVariable Long idPermission) {
		Role role = roleService.findById(idRole);
		Permission permission = permissionService.findById(idPermission);
		if(role == null || permission == null) {
			return new ResponseEntity<>("Role or permission doesn't exist.", HttpStatus.BAD_REQUEST);
		}
		for(Permission p : role.getPermissions()) {
			if(p.getId().equals(permission.getId())) {
				role.getPermissions().remove(p);
				roleService.save(role);
				return new ResponseEntity<>(roleToRoleDTOConverter.convert(role), HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("Permission doesn't exist for this role.", HttpStatus.BAD_REQUEST);
	}
	
}
