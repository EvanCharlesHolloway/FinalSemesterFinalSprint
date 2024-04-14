package com.binarytreesprint.binarytree.Services;

import com.binarytreesprint.binarytree.Entities.InputEntity;
import com.binarytreesprint.binarytree.Repositories.InputRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputService {

    private final InputRepositories inputRepositories;

    @Autowired
    public InputService(InputRepositories inputRepositories) {
        this.inputRepositories = inputRepositories;
    }

    // Method to save input numbers
    public InputEntity saveInput(String numbers) {
        InputEntity inputEntity = new InputEntity(numbers);
        return inputRepositories.save(inputEntity);
    }

    // Method to retrieve input by ID
    public InputEntity getInputById(Long id) {
        return inputRepositories.findById(id).orElse(null);
    }
}
