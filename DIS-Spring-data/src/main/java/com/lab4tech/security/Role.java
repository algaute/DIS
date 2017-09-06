/**
 * 
 */
package com.lab4tech.security;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.lab4tech.entities.AbstractEntity;

@Entity
@Table(name = "ROLES")
public class Role extends AbstractEntity {

	// propriétés
	private String name;

	// constructeurs
	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	// identité
	@Override
	public String toString() {
		return String.format("Role[%s]", name);
	}

	// getters et setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
