package pi.vezbe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.DodatneUslugeDTO;
import pi.vezbe.model.DodatneUsluge;

@Component
public class DodatneUslugeDTOToDodatneUslugeConverter implements Converter<DodatneUslugeDTO, DodatneUsluge> {

	@Override
	public DodatneUsluge convert(DodatneUslugeDTO source) {
		// TODO Auto-generated method stub
		DodatneUsluge dodU = new DodatneUsluge();
		dodU.setId(source.getId());
		dodU.setNaziv(source.getNaziv());
		return dodU;
	}

}
