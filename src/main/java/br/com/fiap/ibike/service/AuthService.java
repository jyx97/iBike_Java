package  br.com.fiap.ibike.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import br.com.fiap.ibike.repository.AdministradorRepository;


@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private AdministradorRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminRepository.findByEmail(username).orElseThrow(
            () -> new UsernameNotFoundException("User not found")
        );
    }
    
    
}