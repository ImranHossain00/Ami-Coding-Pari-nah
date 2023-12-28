package com.imran.service;

import com.imran.domain.User;
import com.imran.dto.AddressDTO;
import com.imran.dto.ContactDTO;
import com.imran.dto.NIDInfoDTO;
import com.imran.dto.RegDTO;
import com.imran.repositories.UserRepo;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.stream.Stream;

public class UserServiceImpl implements UserService{
    private UserRepo repository;

    public UserServiceImpl(UserRepo repository) {
        this.repository = repository;
    }

    @Override
    public User saveSignupData(RegDTO dto) {
        var user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setAccountPassword(encryptPassword(dto.getPassword()));
        user.setAccountNo(Stream.generate(UUID::randomUUID).toString());
        return user;
    }

    @Override
    public User saveNidData(NIDInfoDTO dto) {

    }

    @Override
    public User saveAddressData(AddressDTO dto) {

    }

    @Override
    public User saveContactData(ContactDTO dto) {

    }

    private String encryptPassword(String password) {
        try {
            var digest
                    = MessageDigest.getInstance("SHA-256");
            var bytes
                    = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Unable to encrypt password", e);
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();

        for (var b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
