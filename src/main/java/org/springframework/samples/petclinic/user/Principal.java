package org.springframework.samples.petclinic.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class Principal implements UserDetails {

	private final User user;
	private final Collection<Role> roles;

	public Principal(User user, Collection<Role> roles) {
		this.user = user;
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
			return roles.stream()
				.map(r -> new SimpleGrantedAuthority(r.getRole()))
				.collect(Collectors.toSet());
	}

	@Override
	public String getPassword() {
		return user.getSecret();
	}

	@Override
	public String getUsername() {
		return user.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
