package org.springframework.samples.petclinic.system;

import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.user.PetsPermissionEvaluator;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomSecurityConfig extends GlobalMethodSecurityConfiguration {

	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		DefaultMethodSecurityExpressionHandler expressionHandler =
			new DefaultMethodSecurityExpressionHandler();
		expressionHandler.setPermissionEvaluator(new PetsPermissionEvaluator());
		return expressionHandler;
	}
}
