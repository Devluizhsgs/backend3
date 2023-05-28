package br.iesp.edu.backend3.service;

import br.iesp.edu.backend3.Model.UserModel;
import br.iesp.edu.backend3.domain.repository.RoleModelRepository;
import br.iesp.edu.backend3.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleModelRepository roleModelRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//                return new User(userModel.getUserName(),
//                userModel.getPassword(), true, true,
//                true, true,userModel.getAuthorities());

        return userRepository.findByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException("Não foi encontrado o usúario:" + username));
    }

    @Transactional
    public UserModel criarUsuario(UserModel user){

        if (user.getUserName() != null && user.getPassword() != null && !user.getAuthorities().isEmpty()) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

            user = userRepository.save(user);
        }else {
            throw new UsernameNotFoundException("Parametros null");
        }

        return user;
    }

}