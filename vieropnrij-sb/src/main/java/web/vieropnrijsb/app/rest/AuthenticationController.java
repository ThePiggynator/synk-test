package web.vieropnrijsb.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.vieropnrijsb.app.exceptions.AuthenticationException;
import web.vieropnrijsb.app.models.User;
import com.fasterxml.jackson.databind.node.ObjectNode;
import web.vieropnrijsb.app.repositories.UserRepository;
import web.vieropnrijsb.app.security.JWTokenUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/authentication")
@CrossOrigin("/**")
public class AuthenticationController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private JWTokenUtils tokenGenerator;

    @PostMapping(path = "/login", produces = "application/json")
    public ResponseEntity<User> authenticateUser(@RequestBody ObjectNode signInInfo,
        HttpServletRequest request,
        HttpServletResponse response)
            throws AuthenticationException {

            String userEmail = signInInfo.get("email").asText();
            String password = signInInfo.get("password").asText();

            // Authenticate the user using the credentials provided
            User user = userRepository.findUserWithEmailAndPassword(userEmail, password);

            if (user == null) {
                throw new AuthenticationException("Invalid user and/or password");
            }


            String tokenString = tokenGenerator.encode(user.getEmail(), user.getRole());

            return ResponseEntity.accepted()
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenString)
                    .body(user);
        }
    }

