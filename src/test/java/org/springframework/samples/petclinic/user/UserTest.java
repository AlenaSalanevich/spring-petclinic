package org.springframework.samples.petclinic.user;

import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.SerializationUtils;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Test
	void testEncrypt() {
		Arrays.asList("admin", "user", "guest").stream().map(s-> encoder.encode(s)).forEach(System.out::println);
	}

}
