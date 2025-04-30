package com.training.training_event_management_system_back.services;


import com.training.training_event_management_system_back.dto.LoginRequest;
import com.training.training_event_management_system_back.entities.PersonPrincipal;
import com.training.training_event_management_system_back.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public String login(LoginRequest loginRequest){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUserName(),
                            loginRequest.getPassword()
                    )
            );

            if (authentication.isAuthenticated()) {
                PersonPrincipal principal = (PersonPrincipal) authentication.getPrincipal();
                String actualRole = principal.getPerson().getRole().getCurrentRole();

                if (!actualRole.equals("ROLE_" + loginRequest.getRole())) {
                    throw new BusinessException("Incorrect role");
                }

                return jwtService.generateToken(loginRequest.getUserName());
            } else {
                throw new BusinessException("Login failed");
            }
        } catch (Exception e) {
            throw new BusinessException("Invalid username or password");
        }
    }

}
