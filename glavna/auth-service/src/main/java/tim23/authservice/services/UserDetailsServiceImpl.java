package tim23.authservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tim23.authservice.model.Administrator;
import tim23.authservice.model.Agent;
import tim23.authservice.model.KrajnjiKorisnik;
import tim23.authservice.repository.AdministratorRepository;
import tim23.authservice.repository.AgentRepository;
import tim23.authservice.repository.KrajnjiKorisnikRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private KrajnjiKorisnikRepository krajnjiKorisnikRepository;
	
	@Autowired
	private AgentRepository agentRepository;
	
	@Autowired
	private AdministratorRepository administratorRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
//		tim23.authservice.model.User user = userRepository.findOneByUsername(username);
//		
//		if (user != null) {
//			System.out.println(user.getUsername() + " " + user.getPassword());
//			System.out.println(user.getAuthorities());
//			return new User(user.getUsername(), user.getPassword(), user.getAuthorities());
//		}
		
		KrajnjiKorisnik kk = krajnjiKorisnikRepository.findOneByUsername(username);
		if (kk != null) {
			return new User(kk.getUsername(), kk.getPassword(), kk.getAuthorities());
		}
		
		Agent ag = agentRepository.findOneByUsername(username);
		if (ag != null) {
			return new User(ag.getUsername(), ag.getPassword(), ag.getAuthorities());
		}
		
		Administrator ad = administratorRepository.findOneByUsername(username);
		if (ad != null) {
			return new User(ad.getUsername(), ad.getPassword(), ad.getAuthorities());
		}
		
		throw new UsernameNotFoundException("Username: " + username + " not found");
	}

}
