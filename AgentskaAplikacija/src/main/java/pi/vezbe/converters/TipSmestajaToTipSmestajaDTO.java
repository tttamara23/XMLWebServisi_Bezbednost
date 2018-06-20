package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.TipSmestajaDTO;
import pi.vezbe.model.TipSmestaja;

@Component
public class TipSmestajaToTipSmestajaDTO implements Converter<TipSmestaja, TipSmestajaDTO> {

	@Override
	public TipSmestajaDTO convert(TipSmestaja source) {
		if(source == null) {
			return null;
		}
		TipSmestajaDTO tipSmestajaDTO = new TipSmestajaDTO();
		tipSmestajaDTO.setId(source.getId());
		tipSmestajaDTO.setNaziv(source.getNaziv());
		return tipSmestajaDTO;
	}
	
	public List<TipSmestajaDTO> convert(List<TipSmestaja> source) {
		List<TipSmestajaDTO> ret = new ArrayList<TipSmestajaDTO>();
		for(TipSmestaja tipSmestaja : source) {
			ret.add(convert(tipSmestaja));
		}
		return ret;
	}

}
