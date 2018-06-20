package pi.vezbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Permission;

public interface PermissionReposiory extends JpaRepository<Permission, Long>{
	
	List<Permission> findByRolesId(Long id);
	
}
