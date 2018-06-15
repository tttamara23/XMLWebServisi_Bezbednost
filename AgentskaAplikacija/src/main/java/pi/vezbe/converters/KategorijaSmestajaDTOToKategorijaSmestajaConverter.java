package pi.vezbe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.KategorijaSmestajaDTO;
import pi.vezbe.model.KategorijaSmestaja;

@Component
public class KategorijaSmestajaDTOToKategorijaSmestajaConverter implements Converter<KategorijaSmestajaDTO, KategorijaSmestaja> {

	@Override
	public KategorijaSmestaja convert(KategorijaSmestajaDTO source) {
		// TODO Auto-generated method stub
		KategorijaSmestaja katS = new KategorijaSmestaja();
		katS.setId(source.getId());
		katS.setKategorija(source.getKategorija());
		return katS;
	}

}
