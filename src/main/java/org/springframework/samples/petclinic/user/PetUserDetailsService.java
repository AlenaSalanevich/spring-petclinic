package org.springframework.samples.petclinic.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("petUsersDetailService")
public class PetUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String login) {
		try {
			User user = userRepository.findAll()
				.stream()
				.filter(u -> u.getLogin().equalsIgnoreCase(login))
				.findFirst()
				.orElseThrow(() -> new UsernameNotFoundException(login));
			return new Principal(user, user.getRoles());
		} catch (Exception e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
	}
}
