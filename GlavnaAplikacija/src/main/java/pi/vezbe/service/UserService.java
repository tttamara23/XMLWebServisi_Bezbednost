package pi.vezbe.service;

import java.io.UnsupportedEncodingException;
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
	private KrajnjiKorisnikRepository krajnjiKorisnikRepository;
	
	@Autowired
	private AgentRepository agentRepository;
	
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
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
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
	      byte[] byt = skf.generateSecret(spec).getEncoded();
	      String str;
		try {
			str = new String(byt, "UTF-8");
			byte[] byt2 = str.getBytes("UTF-8");
		      return byt2;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      return null;
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

	public Agent findAgentById(Long idVlasnika) {
		// TODO Auto-generated method stub
		return agentRepository.findOne(idVlasnika);
	}

}
