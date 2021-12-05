package org.springframework.samples.petclinic.user;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "role")
	private String role;

	Role(int id, String role) {
		this.id = id;
		this.role = role;
	}

	public Role() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
