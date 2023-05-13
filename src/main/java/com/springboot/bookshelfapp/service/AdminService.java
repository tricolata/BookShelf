package com.springboot.bookshelfapp.service;

import com.springboot.bookshelfapp.model.Category;
import com.springboot.bookshelfapp.model.Item;
import com.springboot.bookshelfapp.model.Member;
import com.springboot.bookshelfapp.repo.ICategoryRepo;
import com.springboot.bookshelfapp.repo.IItemRepo;
import com.springboot.bookshelfapp.repo.IMemberRepo;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminService {
    Logger logger = LoggerFactory.getLogger(AdminService.class);

    private final ICategoryRepo categoryRepo;
    private final IMemberRepo memberRepo;
    private final IItemRepo itemRepo;

    // Admin Operations
    public Boolean addCategory(String categoryName) {
        Category newCategory = new Category();
        newCategory.setName(categoryName);
        try {
            categoryRepo.save(newCategory);
        } catch (DataAccessException dae) {
            logger.error(dae.getMessage());
            return false;
        }
        return true;
    }

    public Boolean removeCategory(String categoryName) {
        Optional<Category> optionalCategory = categoryRepo.findByName(categoryName);
        try {
            optionalCategory.ifPresent(categoryRepo::delete);
        } catch (DataAccessException dae) {
            logger.error(dae.getMessage());
            return false;
        }
        return true;
    }

    public Boolean addMember(Member newMember) {
        try {
            memberRepo.save(newMember);
        } catch (DataAccessException dae) {
            logger.error(dae.getMessage());
            return false;
        }
        return true;
    }

    public Boolean removeMember(Member memberToDelete) {
        Optional<Member> optionalMember = memberRepo.findById(memberToDelete.getId());
        try {
            optionalMember.ifPresent(memberRepo::delete);
        } catch (DataAccessException dae) {
            logger.error(dae.getMessage());
            return false;
        }
        return true;
    }

    //
    public Boolean addItem(Item newItem) {
        try {
            itemRepo.save(newItem);
        } catch (DataAccessException dae) {
            logger.error(dae.getMessage());
            return false;
        }
        return true;
    }

    public Boolean removeItem(Item itemToRemove) {
        Optional<Item> optionalItem = itemRepo.findById(itemToRemove.getId());
        try {
            optionalItem.ifPresent(itemRepo::delete);
        } catch (DataAccessException dae) {
            logger.error(dae.getMessage());
            return false;
        }
        return true;
    }
}

/*
    Concerns
    1. Majority of these methods are similar and could be written smartly to reduce reparative code
 */