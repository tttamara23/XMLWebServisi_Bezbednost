package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.SmestajDTO;
import pi.vezbe.model.Smestaj;

@Component
public class SmestajToSmestajDtoConverter implements Converter<Smestaj, SmestajDTO> {
	
	@Autowired
	private KategorijaSmestajaToKategorijaSmestajaDTOConverter kategorijaSmestajaToKategorijaSmestajaDTOConverter;
	
	@Autowired
	private TipSmestajaToTipSmestajaDTO tipSmestajaToTipSmestajaDTOConverter;

	@Override
	public SmestajDTO convert(Smestaj source) {
		if(source == null) {
			return null;
		}
		SmestajDTO smestajDTO = new SmestajDTO();
		smestajDTO.setId(source.getId());
		smestajDTO.setNaziv(source.getNaziv());
		smestajDTO.setKategorija(kategorijaSmestajaToKategorijaSmestajaDTOConverter.convert(source.getKategorijaSmestaja()));
		smestajDTO.setLokacija(source.getLokacija());
		smestajDTO.setOpis(source.getOpis());
		
		smestajDTO.setTip(source.getTipSmestaja().getNaziv());
		return smestajDTO;
	}
	
	public List<SmestajDTO> convert(List<Smestaj> source) {
		List<SmestajDTO> ret = new ArrayList<SmestajDTO>();
		for(Smestaj smestaj : source) {
			ret.add(convert(smestaj));
		}
		return ret;
	}

	
}
