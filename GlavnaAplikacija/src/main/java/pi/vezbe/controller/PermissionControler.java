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
import pi.vezbe.converters.PermissionToPermissionDTOConverter;
import pi.vezbe.service.PermissionService;
import pi.vezbe.service.RoleService;

@RestController()
@RequestMapping(value = "/permission")
public class PermissionControler {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private PermissionToPermissionDTOConverter permissionToPermissionDTOConverter;
	
	@PermissionAnnotation(name = "GET_PERMISSIONS")
	@CrossOrigin
	@RequestMapping(
            value = "/getPermissions/{idRole}",
            method = RequestMethod.GET
    )
	public ResponseEntity<?> getPermissions(@PathVariable Long idRole) {
		return new ResponseEntity<>(permissionToPermissionDTOConverter.convert(permissionService.findByRoleId(idRole)), HttpStatus.OK);
	}
	
	@PermissionAnnotation(name = "GET_PERMISSIONS")
	@CrossOrigin
	@RequestMapping(
            value = "/getAll",
            method = RequestMethod.GET
    )
	public ResponseEntity<?> getPermissionsToAdd() {
		return new ResponseEntity<>(permissionToPermissionDTOConverter.convert(permissionService.findAll()), HttpStatus.OK);
	}

}
