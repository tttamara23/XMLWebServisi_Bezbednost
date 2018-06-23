package pi.vezbe.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pi.vezbe.dto.ChatDTO;
import pi.vezbe.dto.KorisnikDTO;
import pi.vezbe.model.Chat;
import pi.vezbe.model.ChatKorisnik;
import pi.vezbe.service.ChatKorisnikService;
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
	
	@Autowired
	private ChatKorisnikService chatKorisnikService;
	
	@Override
	public ChatDTO convert(Chat source) {
		if(source == null) {
			return null;
		}
		ChatDTO ret = new ChatDTO();
		ret.setKorisnici(new ArrayList<KorisnikDTO>());
		ret.setId(source.getId());
		List<ChatKorisnik> chatKorisnici = chatKorisnikService.findByChatId(source.getId());
		
		for(ChatKorisnik ck : chatKorisnici){
			ret.getKorisnici().add(korisnikConverter.convert(ck.getUcesnik()));
		}		
		
		ret.setPoruke(porukaToPorukaDTOConverter.convert(source.getPoruke()));
		ret.setUnseen(porukaService.countUnseen(source.getId(), 4L));
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