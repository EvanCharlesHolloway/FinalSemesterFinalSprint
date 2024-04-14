package com.binarytreesprint.binarytree.Repositories;

import com.binarytreesprint.binarytree.Entities.TreeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreeRepositories extends JpaRepository<TreeEntity, Long> {
    @Query("SELECT t FROM TreeEntity t WHERE t.inputNumbers = :inputNumbers")
    Optional<TreeEntity> findByInputNumbers(String inputNumbers);
}
