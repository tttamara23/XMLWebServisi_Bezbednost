package pi.vezbe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.UslugaDTO;
import pi.vezbe.model.DodatneUsluge;
import pi.vezbe.model.Usluga;

@Component
public class UslugaDTOToUslugaConverter implements Converter<UslugaDTO, Usluga> {

	@Override
	public Usluga convert(UslugaDTO source) {
		// TODO Auto-generated method stub
		Usluga dodU = new Usluga();
		dodU.setId(source.getId());
		dodU.setNaziv(source.getNaziv());
		return dodU;
	}

}
