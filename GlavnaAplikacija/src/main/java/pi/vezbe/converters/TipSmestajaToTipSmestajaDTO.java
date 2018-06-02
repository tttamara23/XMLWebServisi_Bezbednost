package pi.vezbe.converters;

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

}
