package tim23.agent.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tim23.agent.AgentClient;
import tim23.agent.config.JwtConfig;
import tim23.agent.model.poruke.GetSlikaResponse;

@RestController
@RequestMapping("/slika")
public class SlikaController {
	
	@Autowired
	private JwtConfig tokenUtils;
	
	@Autowired
	private AgentClient agentClient;
	
	@PostMapping("/{idSobe}")
	public ResponseEntity<?> dodajSliku(@RequestBody MultipartFile file, @PathVariable Integer idSobe, HttpServletRequest request) {
		
		String username = tokenUtils.getUsernameFromToken(tokenUtils.getToken(request));
		
		System.out.println(file.getOriginalFilename());
		
		try {
			byte[] bytes = file.getBytes();
			
			agentClient.dodajSliku(bytes, file.getOriginalFilename(), idSobe, username);
		} catch (IOException e) {
			e.printStackTrace();
		};
		
		
		return ResponseEntity.ok().build();
	}
}
