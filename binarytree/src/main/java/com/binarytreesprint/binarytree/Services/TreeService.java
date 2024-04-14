package com.binarytreesprint.binarytree.Services;

import com.binarytreesprint.binarytree.Entities.TreeEntity;
import com.binarytreesprint.binarytree.Repositories.TreeRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreeService {

    private final TreeRepositories treeRepositories;
    private Long currentTreeId;

    @Autowired
    public TreeService(TreeRepositories treeRepositories) {
        this.treeRepositories = treeRepositories;
    }

    // Method to process numbers and save tree entity
    public TreeEntity processNumbers(String numbers) {
        TreeEntity treeEntity = new TreeEntity();
        treeEntity.setInputNumbers(numbers);
        String treeStructureJson = constructTree(numbers);
        treeEntity.setTreeStructure(treeStructureJson);
        treeRepositories.save(treeEntity);
        currentTreeId = treeEntity.getId();
        return treeEntity;
    }

    // Placeholder method to construct tree structure (replace with actual logic)
    public String constructTree(String numbers) {
        // Example placeholder logic to create tree structure JSON
        return "{\"value\": 50, \"left\": {\"value\": 30}, \"right\": {\"value\": 70}}";
    }

    // Method to retrieve previous trees from the database
    public Iterable<TreeEntity> getAllTrees() {
        return treeRepositories.findAll();
    }

    // Method to retrieve a tree by its ID
    public TreeEntity getTreeById(Long id) {
        return treeRepositories.findById(id).orElse(null);
    }

    // Method to save a tree with given numbers and tree structure
    public void saveTree(String numbers, String treeStructure) {
        TreeEntity treeEntity = new TreeEntity(numbers, treeStructure);
        treeEntity = treeRepositories.save(treeEntity);
        currentTreeId = treeEntity.getId();
    }

    // Method to get the ID of the currently saved tree
    public String getCurrentTreeId() {
        return currentTreeId != null ? currentTreeId.toString() : "";
    }
}
