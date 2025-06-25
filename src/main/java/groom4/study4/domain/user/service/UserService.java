package groom4.study4.domain.user.service;

import groom4.study4.config.jwt.JwtTokenProvider;
import groom4.study4.domain.user.User;
import groom4.study4.domain.user.repository.UserRepository;
import groom4.study4.exceptions.user.NotFoundUsernameException;
import groom4.study4.exceptions.user.WrongPasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider tokenProvider;

    public String authenticate(String username, String password) {
        User user = userRepository.findByUsername(username).orElseThrow(()->
                new NotFoundUsernameException("존재하지 않는 유저입니다."));
        if (!Objects.equals(password, user.getPassword())) {
            throw new WrongPasswordException();
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), password);

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        String access = tokenProvider.createToken(username);


        return access;
    }


}
