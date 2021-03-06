package ua.com.manometer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.manometer.dao.UserDAO;
import ua.com.manometer.model.SecuredUser;
import ua.com.manometer.model.User;
import ua.com.manometer.model.invoice.filter.BookingFilter;
import ua.com.manometer.model.invoice.filter.InvoiceFilter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    public CustomUserDetailsService() {
        System.out.println("CustomUserDetailsService.CustomUserDetailsService");
    }

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {


        try {
            User user = userDAO.findByLogin(login);


            boolean enabled = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;

            Integer powersLevel = user.getPowersLevel();
            SecuredUser securedUser = new SecuredUser(
                    user.getLogin(),
                    user.getPass().toLowerCase(),
                    enabled,
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked,
                    getAuthorities(powersLevel));
            securedUser.setUserId(user.getId());
            InvoiceFilter invoiceFilter = user.getInvoiceFilter();
            BookingFilter bookingFilter = user.getBookingFilter();


            if (User.LEVEL_MANAGER.equals(powersLevel) || User.LEVEL_USER.equals(powersLevel)) {
                LinkedList<Integer> userFilter = new LinkedList<Integer>();
                userFilter.add(user.getId());
                invoiceFilter.setUsers(userFilter);
            }
//
//
            securedUser.setInvoiceFilter(invoiceFilter);
            securedUser.setBookingFilter(bookingFilter);
            securedUser.setPowerLevel(powersLevel);
            return securedUser;

        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User [" + login + "] not found");
        }
    }


    /**
     * Retrieves a collection of {@link GrantedAuthority} based on a numerical role
     *
     * @param role the numerical role
     * @return a collection of {@link GrantedAuthority
     */
    public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }

    /**
     * Converts a numerical role to an equivalent list of roles
     *
     * @param role the numerical role
     * @return list of roles as as a list of {@link String}
     */
    public List<String> getRoles(Integer role) {
        List<String> roles = new ArrayList<String>();

        if (role.intValue() == 4) {
            roles.add("ROLE_USER");
            roles.add("ROLE_MANAGER");
            roles.add("ROLE_ECONOMIST");
            roles.add("ROLE_ADMIN");

        } else if (role.intValue() == 3) {
            roles.add("ROLE_USER");
            roles.add("ROLE_MANAGER");
            roles.add("ROLE_ECONOMIST");

        } else if (role.intValue() == 2) {
            roles.add("ROLE_USER");
            roles.add("ROLE_MANAGER");
        } else if (role.intValue() == 1) {
            roles.add("ROLE_USER");
        }

        return roles;
    }

    /**
     * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects
     *
     * @param roles {@link String} of roles
     * @return list of granted authorities
     */
    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}