package com.binarytreesprint.binarytree.Repositories;

import com.binarytreesprint.binarytree.Entities.InputEntity;
import org.springframework.data.repository.CrudRepository;

public interface InputRepositories extends CrudRepository<InputEntity, Long> {
    // No additional methods are needed because CrudRepository provides basic CRUD operations
}
