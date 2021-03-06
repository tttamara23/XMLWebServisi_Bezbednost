package pi.vezbe.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import pi.vezbe.model.Agent;
import pi.vezbe.model.Korisnik;
import pi.vezbe.model.KrajnjiKorisnik;
import pi.vezbe.repository.AgentRepository;
import pi.vezbe.repository.KorisnikRepository;
import pi.vezbe.repository.KrajnjiKorisnikRepository;

@Service
public class UserService {
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
	private AgentRepository agentRepository;


	@Autowired
	private KrajnjiKorisnikRepository krajnjiKorisnikRepository;
	
	public Korisnik findByEmail(String email) {
		return korisnikRepository.findByEmailIgnoreCase(email).orElseThrow(RuntimeException::new);
	}
	public KrajnjiKorisnik findRegisteredByEmail(String email) {
		return krajnjiKorisnikRepository.findByEmailIgnoreCase(email).orElseThrow(RuntimeException::new);
	}
	public Korisnik save(Korisnik korisnik) {
		return korisnikRepository.save(korisnik);
	}
	
	public Agent save(Agent agent){
		return agentRepository.save(agent);
	}
	public KrajnjiKorisnik findKrajnjiKorisnikById(Long id) {
		return krajnjiKorisnikRepository.findOne(id);
	}
	
	public Agent findAgentById(Long id){
		return agentRepository.findOne(id);
	}
	
	public KrajnjiKorisnik save(KrajnjiKorisnik korisnik) {
		return krajnjiKorisnikRepository.save(korisnik);
	}
	
	public void delete(KrajnjiKorisnik zaBrisanje) {
		krajnjiKorisnikRepository.delete(zaBrisanje);
	}
	
	public void setCurrentUser(Korisnik user) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        Authentication authentication = new PreAuthenticatedAuthenticationToken(user.getId(), null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public Korisnik getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            Long id = Long.parseLong(auth.getName());
            return korisnikRepository.findById(id).orElseThrow(RuntimeException::new);
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<KrajnjiKorisnik> findAll(){
    	return krajnjiKorisnikRepository.findAll();
    }
    
    public Korisnik findById(Long id){
    	return korisnikRepository.findOne(id);
    }

}
