package org.springframework.management.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.management.service.RoleService;
import org.springframework.management.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

@Component
public class MyUserDetailsService implements UserDetailsService {
	Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);
	@Autowired
	UserService userService;
	@Autowired
    RoleService roleService;

	@Autowired
	HttpServletRequest request;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = (User) request.getSession().getAttribute("userInfo");

		org.springframework.management.entity.User user = (org.springframework.management.entity.User) userService.findByName(username);

		if (user == null) {
			throw new UsernameNotFoundException("用户不存在");
		}

		String name = user.getName();
		String password = user.getPassword();

		Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
		collection.add(new SimpleGrantedAuthority("ROLE_ADMIN"));




		
		
//		Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
//        Iterator<String> iterator =  roleDao.getRolesByUserId(userEntity.getId()).iterator();
//        while (iterator.hasNext()){
//            collection.add(new SimpleGrantedAuthority(iterator.next()));
//        }
		
//		/*return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));*/
		return new User(name, password, collection);
	}

}
