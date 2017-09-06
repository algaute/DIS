package com.lab4tech.security;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.jdbc.Sql;

import com.google.common.collect.Lists;
import com.lab4tech.AbstractIntegrationTest;


public class UsersTest extends AbstractIntegrationTest
{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	@Autowired
	private AppUserDetailsService appUserDetailsService;

	@Test
	public void findAllUsersWithTheirRoles() {
		
		createUser("algaute1","totomalade1","admin");
		createUser("algaute2","totomalade2","user");
		createUser("algaute3","totomalade3","user");
		
		Iterable<User> users = userRepository.findAll();
		for (User u : users) {
			System.out.println(u);
			display("Roles :", userRepository.getRoles(u.getId()));
		}
	}

	@Test
	public void findUserByLogin() {
		createUser("admin","totomalade1","ROLE_ADMIN");
		createUser("user1","totomalade2","ROLE_USER");
		createUser("user2","totomalade3","ROLE_USER");

		
		// on récupère l'utilisateur [admin]
		User user = userRepository.findUserByLogin("admin");
		// on vérifie que son mot de passe est [totomalade1]
		Assert.assertTrue(BCrypt.checkpw("totomalade1", user.getPassword()));
		
		// on vérifie le rôle de admin / totomalade1
		List<Role> roles = Lists.newArrayList(userRepository.getRoles("admin", user.getPassword()));
		Assert.assertEquals(1L, roles.size());
		Assert.assertEquals("ROLE_ADMIN", roles.get(0).getName());
		
		
		// on récupère l'utilisateur [user1]
		user = userRepository.findUserByLogin("user1");
		// on vérifie que son mot de passe est [totomalade2]
		Assert.assertTrue(BCrypt.checkpw("totomalade2", user.getPassword()));
		// on vérifie le rôle de user1 / totomalade2
		roles = Lists.newArrayList(userRepository.getRoles("user1", user.getPassword()));
		Assert.assertEquals(1L, roles.size());
		Assert.assertEquals("ROLE_USER", roles.get(0).getName());
	}

	@Test
	public void loadUserByUsername() {
		createUser("admin","totomalade1","ROLE_ADMIN");
		createUser("user1","totomalade2","ROLE_USER");
		createUser("user2","totomalade3","ROLE_USER");
		
		// on récupère l'utilisateur [admin]
		AppUserDetails userDetails = (AppUserDetails) appUserDetailsService.loadUserByUsername("admin");
		// on vérifie que son mot de passe est [totomalade1]
		Assert.assertTrue(BCrypt.checkpw("totomalade1", userDetails.getPassword()));
		// on vérifie le rôle de admin / totomalade1
		@SuppressWarnings("unchecked")
		List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>)userDetails.getAuthorities();
		Assert.assertEquals(1L, authorities.size());
		Assert.assertEquals("ROLE_ADMIN", authorities.get(0).getAuthority());
	}

	// méthode utilitaire - affiche les éléments d'une collection
	private void display(String message, Iterable<?> elements) {
		System.out.println(message);
		for (Object element : elements) {
			System.out.println(element);
		}
	}
	
	
	private void createUser(String login, String password, String roleName) {
		// Création du rôle
		Role role = roleRepository.save(new Role(roleName));
		// sauvegarde de l'utilisateur
		User user = userRepository.save(new User(login, login, BCrypt.hashpw(password, BCrypt.gensalt())));
		// création de la relation avec le rôle
		UserRole userRole = userRoleRepository.save(new UserRole(user, role));
	}
}
