package groom4.study4.domain.user.controller;

import groom4.study4.config.jwt.JwtTokenProvider;
import groom4.study4.domain.user.User;
import groom4.study4.domain.user.dto.UserReqDto;
import groom4.study4.domain.user.dto.UserResDto;
import groom4.study4.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserReqDto userReqDto) {
        String token = userService.authenticate(userReqDto.getUsername(), userReqDto.getPassword());

        return new ResponseEntity<> (new UserResDto(token), HttpStatus.OK );
    }
}
