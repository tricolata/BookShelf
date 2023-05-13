package com.springboot.bookshelfapp.service;

import com.springboot.bookshelfapp.model.Member;
import com.springboot.bookshelfapp.repo.IMemberRepo;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

@AllArgsConstructor
@Service
public class UserService {

    Logger logger = getLogger(UserService.class);
    private IMemberRepo memberRepo;

    public Member login(String userId, String password) {
        Optional<Member> optionalMember;
        try {
            optionalMember = memberRepo.
                    findMemberByMemberLoginAndMemberPassword(userId, password);
        } catch (DataAccessException dae) {
            logger.error(dae.getMessage());
            return null;
        }
        return optionalMember.orElse(null);
    }

    // public Boolean verifyLogin(String userId) {}
}

/*
    Concern
    1. Implement a session whereby member who is logged in could stay logged in.
 */
