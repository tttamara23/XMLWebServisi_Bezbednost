package pi.vezbe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.vezbe.model.Role;
import pi.vezbe.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public Role findById(Long id) {
		return roleRepository.findOne(id);
	}
	
	public Role save(Role role) {
		return roleRepository.save(role);
	}
	
	public void delete(Role role) {
		roleRepository.delete(role);
	}
	
}
