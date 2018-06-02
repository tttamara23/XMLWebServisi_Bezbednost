package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.KategorijaSmestajaDTO;
import pi.vezbe.model.KategorijaSmestaja;


@Component
public class KategorijaSmestajaToKategorijaSmestajaDTOConverter implements Converter<KategorijaSmestaja, KategorijaSmestajaDTO> {

	@Override
	public KategorijaSmestajaDTO convert(KategorijaSmestaja source) {
		if(source == null) {
			return null;
		}
		KategorijaSmestajaDTO ret = new KategorijaSmestajaDTO();
		ret.setId(source.getId());
		ret.setKategorija(source.getKategorija());
		return ret;
	}
	
	public List<KategorijaSmestajaDTO> convert(List<KategorijaSmestaja> source) {
		List<KategorijaSmestajaDTO> ret = new ArrayList<>();
		for(KategorijaSmestaja kategorijaSmestaj : source) {
			ret.add(convert(kategorijaSmestaj));
		}
		return ret;
	}

}
