package pi.vezbe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.TipSmestajaDTO;
import pi.vezbe.model.TipSmestaja;

@Component
public class TipSmestajaDTOToTipSmestajaConverter implements Converter<TipSmestajaDTO, TipSmestaja> {

	@Override
	public TipSmestaja convert(TipSmestajaDTO source) {
		// TODO Auto-generated method stub
		TipSmestaja tipS = new TipSmestaja();
		tipS.setNaziv(source.getNaziv());
		tipS.setId(source.getId());
		return tipS;
	}
}
