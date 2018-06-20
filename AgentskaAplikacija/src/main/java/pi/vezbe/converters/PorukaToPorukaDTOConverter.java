package pi.vezbe.converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.KorisnikDTO;
import pi.vezbe.dto.PorukaDTO;
import pi.vezbe.model.Korisnik;
import pi.vezbe.model.Poruka;
import pi.vezbe.service.UserService;

@Component
public class PorukaToPorukaDTOConverter implements Converter<Poruka, PorukaDTO> {

	@Autowired
	private UserService userService;
	
	@Autowired
	private KorisnikToKorisnikDTOConverter korisnikToKorisnikDTOConverter;
	
	@Override
	public PorukaDTO convert(Poruka source) {
		if(source == null) {
			return null;
		}
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		PorukaDTO ret = new PorukaDTO();
		ret.setId(source.getId());
		ret.setSadrzaj(source.getSadrzaj());
		ret.setDatum(dateFormat.format(source.getDatumSlanja()));
		ret.setPosiljalac(korisnikToKorisnikDTOConverter.convert(source.getPosiljalac()));
		//Korisnik ulogovani = userService.getCurrentUser();
		//if(ulogovani.getId().equals(source.getPosiljalac().getId())) {
		//	ret.setPoslata(true);
		//} else {
			ret.setPoslata(false);
		//}
		return ret;
	}
	
	public List<PorukaDTO> convert(List<Poruka> source) {
		if(source == null) {
			return new ArrayList<PorukaDTO>();
		}
		List<PorukaDTO> ret = new ArrayList<PorukaDTO>();
		for(Poruka poruka : source) {
			ret.add(convert(poruka));
		}
		return ret;
	}

}
