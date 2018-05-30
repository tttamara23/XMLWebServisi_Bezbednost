package pi.vezbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vezbe.model.Administrator;

public interface AdminRepository extends JpaRepository<Administrator, Long>  {

}
