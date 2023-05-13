package com.springboot.bookshelfapp.repo;

import com.springboot.bookshelfapp.model.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IMemberRepo extends CrudRepository<Member, Long> {
    Optional<Member> findMemberByMemberLoginAndMemberPassword(String memberLogin, String memberPassword);
}
