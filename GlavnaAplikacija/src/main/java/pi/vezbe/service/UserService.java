package pi.vezbe.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import pi.vezbe.model.Korisnik;
import pi.vezbe.model.KrajnjiKorisnik;
import pi.vezbe.repository.KorisnikRepository;
import pi.vezbe.repository.KrajnjiKorisnikRepository;

@Service
public class UserService {
	
	@Autowired
	private KorisnikRepository korisnikRepository;

	@Autowired
	private KrajnjiKorisnikRepository krajnjiKorisnikRepository;
	
	public Korisnik findById(Long id) {
		return korisnikRepository.findOne(id);
	}
	
	public Korisnik findByEmail(String email) {
		return korisnikRepository.findByEmailIgnoreCase(email).orElseThrow(RuntimeException::new);
	}
	public KrajnjiKorisnik findRegisteredByEmail(String email) {
		return krajnjiKorisnikRepository.findByEmailIgnoreCase(email).orElseThrow(RuntimeException::new);
	}
	public Korisnik save(Korisnik korisnik) {
		return korisnikRepository.save(korisnik);
	}
	
	public KrajnjiKorisnik save(KrajnjiKorisnik korisnik) {
		return krajnjiKorisnikRepository.save(korisnik);
	}
	
	public void delete(KrajnjiKorisnik zaBrisanje) {
		krajnjiKorisnikRepository.delete(zaBrisanje);
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
    
    public List<KrajnjiKorisnik> findAll(){
    	return krajnjiKorisnikRepository.findAll();
    }

    public byte[] hashPassword(String password, byte[] salt) {
		
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 1000, 256);
	    try {
	      SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	      return skf.generateSecret(spec).getEncoded();
	    } catch (NoSuchAlgorithmException e) {
	    	e.printStackTrace();
	    } catch (InvalidKeySpecException e) {
	    	e.printStackTrace();
	    }
	    return null;
	}
	
	public byte[] salt() {
		return new SecureRandom().generateSeed(64);
	}
	
public boolean authenticate(String attemptedPassword, byte[] storedPassword, byte[] salt) {
		
		byte[] tmpHash = hashPassword(attemptedPassword, salt);
		
		if (tmpHash.length != storedPassword.length)
			return false;
		
	    for (int i = 0; i < tmpHash.length; i++) {
	      if (tmpHash[i] != storedPassword[i])
	    	  return false;
	    }

	    return true;
	}
	

}
