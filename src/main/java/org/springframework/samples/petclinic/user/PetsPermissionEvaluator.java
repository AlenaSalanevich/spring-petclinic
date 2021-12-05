package org.springframework.samples.petclinic.user;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

public class PetsPermissionEvaluator implements PermissionEvaluator {
	@Override
	public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
		if ((auth == null) || (targetDomainObject == null) || !(permission instanceof String)){
			return false;
		}

		return hasRole(auth, permission.toString().toUpperCase());
	}

	@Override
	public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
		if ((auth == null) || (targetType == null) || !(permission instanceof String)) {
			return false;
		}
		return hasRole(auth, permission.toString().toUpperCase());
	}

	private boolean hasRole(Authentication auth,  String permission) {
		Principal principal = (Principal) auth.getPrincipal();
		return principal.getAuthorities().stream()
			.map(GrantedAuthority::getAuthority)
			.anyMatch(permission::equalsIgnoreCase);
	}
}
