package pi.vezbe.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import pi.vezbe.model.Korisnik;
import pi.vezbe.repository.KorisnikRepository;

@Service
public class UserService {
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	public Korisnik findByEmail(String email) {
		return korisnikRepository.findByEmailIgnoreCase(email).orElseThrow(RuntimeException::new);
	}
	
	public Korisnik save(Korisnik korisnik) {
		return korisnikRepository.save(korisnik);
	}
	
	public void setCurrentUser(Korisnik user) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
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

}
