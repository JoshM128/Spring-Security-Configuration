package com.Authentication.SpringSecurity.Service.RoleService;

import com.Authentication.SpringSecurity.DTO.UpdateUserByIDRequest;
import com.Authentication.SpringSecurity.DTO.UserDTO;
import com.Authentication.SpringSecurity.Repoistory.TokenRepository;
import com.Authentication.SpringSecurity.Repoistory.UserRepository;
import com.Authentication.SpringSecurity.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, TokenRepository tokenRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO getUserByID(int userID){
        User user = userRepository.findById(userID).orElseThrow(() -> new UsernameNotFoundException("User not found, Incorrect ID"));
        return mapToDTO(user);
    }

    public UserDTO updateUserByID(UpdateUserByIDRequest userDTO, int userID){
        User user = userRepository.findById(userID).orElseThrow(() -> new UsernameNotFoundException("User not found, Incorrect ID"));

        user.setEmail(userDTO.getEmail()); user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname()); user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        User updatedUser = userRepository.save(user);
        return mapToDTO(updatedUser);
    }


    //Transactional is required for the access of both repositories with Hikari because of thread safety
    @Transactional
    public void deleteUser(int id){
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found, Incorrect ID"));
        tokenRepository.deleteTokenByUser(user);
        userRepository.delete(user);
    }


    private UserDTO mapToDTO(User user){
        return new UserDTO(user.getId(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getPassword());
    }

}
