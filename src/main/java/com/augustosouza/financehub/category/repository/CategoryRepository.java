package com.augustosouza.financehub.category.repository;

import com.augustosouza.financehub.category.entity.Category;
import com.augustosouza.financehub.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByUser(User user);

}