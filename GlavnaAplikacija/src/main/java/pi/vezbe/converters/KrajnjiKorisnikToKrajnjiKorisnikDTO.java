package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.KorisnikDTO;
import pi.vezbe.dto.KrajnjiKorisnikDTO;
import pi.vezbe.model.Korisnik;
import pi.vezbe.model.KrajnjiKorisnik;

@Component
public class KrajnjiKorisnikToKrajnjiKorisnikDTO implements Converter<KrajnjiKorisnik, KrajnjiKorisnikDTO>{


	@Override
	public KrajnjiKorisnikDTO convert(KrajnjiKorisnik source) {
		if(source==null){
			return null;
		}
		KrajnjiKorisnikDTO krajnjiKorisnikDTO = new KrajnjiKorisnikDTO();
		
		krajnjiKorisnikDTO.getKorisnikDTO().setIme(source.getIme());
		krajnjiKorisnikDTO.getKorisnikDTO().setKontakt(source.getKontakt());
		krajnjiKorisnikDTO.getKorisnikDTO().setPrezime(source.getPrezime());
		krajnjiKorisnikDTO.getKorisnikDTO().setEmail(source.getEmail());
		krajnjiKorisnikDTO.setBlokiran(source.getBlokiran());
		krajnjiKorisnikDTO.getKorisnikDTO().setId(source.getId());
		return krajnjiKorisnikDTO;
	}
	public List<KrajnjiKorisnikDTO> convert(List<KrajnjiKorisnik> source) {
		List<KrajnjiKorisnikDTO> ret = new ArrayList<KrajnjiKorisnikDTO>();
		for(KrajnjiKorisnik korisnik : source) {
			ret.add(convert(korisnik));
		}
		return ret;
	}
	
	
}
