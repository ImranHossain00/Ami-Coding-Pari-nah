package com.imran.service;

import com.imran.domain.User;
import com.imran.dto.AddressDTO;
import com.imran.dto.ContactDTO;
import com.imran.dto.NIDInfoDTO;
import com.imran.dto.RegDTO;

public interface UserService {
    User saveSignupData(RegDTO dto);
    User saveNidData(NIDInfoDTO dto);
    User saveAddressData(AddressDTO dto);
    User saveContactData(ContactDTO dto);
}
