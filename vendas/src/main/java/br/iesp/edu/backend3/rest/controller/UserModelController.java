package br.iesp.edu.backend3.rest.controller;

import br.iesp.edu.backend3.Model.UserModel;
import br.iesp.edu.backend3.TokenDto;
import br.iesp.edu.backend3.service.TokenService;
import br.iesp.edu.backend3.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class UserModelController {

    @Autowired
    UserDetailsServiceImpl service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @RequestMapping(value="/criar-usuario", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UserModel>  criarUsuario (@RequestBody UserModel user) {

        return ResponseEntity.status(201).body(service.criarUsuario(user));
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<TokenDto>  login (@RequestBody UserModel user) {

        UsernamePasswordAuthenticationToken userToken =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        Authentication authentication =  this.authenticationManager.authenticate(userToken);

        var usauario = (UserModel) authentication.getPrincipal();

        return ResponseEntity.ok(tokenService.gerarToken(usauario));
    }
}
