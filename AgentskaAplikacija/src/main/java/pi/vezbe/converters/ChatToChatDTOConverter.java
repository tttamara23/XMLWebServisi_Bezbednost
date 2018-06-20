package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.ChatDTO;
import pi.vezbe.model.Chat;
import pi.vezbe.service.PorukaService;
import pi.vezbe.service.UserService;

@Component
public class ChatToChatDTOConverter implements Converter<Chat, ChatDTO>{

	@Autowired
	private KorisnikToKorisnikDTOConverter korisnikConverter;
	
	@Autowired
	private PorukaToPorukaDTOConverter  porukaToPorukaDTOConverter;
	
	@Autowired
	private PorukaService porukaService;
	
	@Autowired
	private UserService userService;
	
	@Override
	public ChatDTO convert(Chat source) {
		if(source == null) {
			return null;
		}
		ChatDTO ret = new ChatDTO();
		ret.setId(source.getId());
		ret.setKorisnici(korisnikConverter.convert(source.getKorisnici()));
		ret.setPoruke(porukaToPorukaDTOConverter.convert(source.getPoruke()));
		//ret.setUnseen(porukaService.countUnseen(source.getId(), userService.getCurrentUser().getId()));
		return ret;
	}
	
	public List<ChatDTO> convert(List<Chat> source) {
		List<ChatDTO> ret = new ArrayList<ChatDTO>();
		for(Chat chat : source) {
			ret.add(convert(chat));
		}
		return ret;
	}

}