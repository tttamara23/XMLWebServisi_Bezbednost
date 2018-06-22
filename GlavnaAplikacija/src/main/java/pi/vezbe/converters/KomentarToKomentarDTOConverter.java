package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.KomentarDTO;
import pi.vezbe.model.Komentar;

@Component
public class KomentarToKomentarDTOConverter implements Converter<Komentar, KomentarDTO> {

	@Autowired
	private SmestajToSmestajDtoConverter smestajToSmestajDTOConverter;
	@Override
	public KomentarDTO convert(Komentar source) {
		// TODO Auto-generated method stub
		if(source == null) {
			return null;
		}
		KomentarDTO komentarDTO = new KomentarDTO();
		komentarDTO.setId(source.getId());
		if(source.getDatumKomentara() != null) {
			komentarDTO.setDatumKomentara(source.getDatumKomentara().toString());
		}
		komentarDTO.setOpis(source.getOpis());
		komentarDTO.setImeAutora(source.getAutor().getIme());
		komentarDTO.setPrezimeAutora(source.getAutor().getPrezime());
		komentarDTO.setSmestajDTO(smestajToSmestajDTOConverter.convert(source.getSmestaj()));
		return komentarDTO;
	}
	
	public List<KomentarDTO> convert(List<Komentar> source) {
		List<KomentarDTO> ret = new ArrayList<KomentarDTO>();
		for(Komentar kom : source) {
			ret.add(convert(kom));
		}
		return ret;
	}

}
