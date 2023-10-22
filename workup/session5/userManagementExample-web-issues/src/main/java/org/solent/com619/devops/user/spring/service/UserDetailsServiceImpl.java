package org.solent.com619.devops.user.spring.service;

import org.solent.com619.devops.user.model.dto.UserRole;
import org.solent.com619.devops.user.model.dto.User;
import org.solent.com619.devops.user.dao.impl.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	final static Logger LOG = LogManager.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> users = userRepository.findByUsername(username);

		if (users.isEmpty())
			throw new UsernameNotFoundException("could not find username: " + username);
		// assume only one user with this username
		User user = users.get(0);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserRole().getTag()));
		LOG.debug("   added granted authority role to username " + username + " tag: " 
		+ user.getUserRole().getTag() + " name: " + user.getUserRole().name());

		boolean enabled = true;
		// set login enabled depending upon user enabled status
		if (user.getEnabled() == null || !user.getEnabled()) {
			enabled = false;
		}

		// User(java.lang.String username, java.lang.String password,
		// boolean enabled,
		// boolean accountNonExpired,
		// boolean credentialsNonExpired,
		// boolean accountNonLocked,
		// java.util.Collection<? extends GrantedAuthority> authorities)
		org.springframework.security.core.userdetails.User userDetailsUser = new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getHashedPassword(), enabled, true, true, true, grantedAuthorities);

		return userDetailsUser;
	}
}
