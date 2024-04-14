package com.binarytreesprint.binarytree.Entities;

import jakarta.persistence.*;

@Entity
public class TreeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String inputNumbers;

    @Column(nullable = false)
    private String treeStructure; // Store the tree structure as JSON or any other suitable format

    // Add the 'name' property
    @Transient
    private String name;

    // Constructors
    public TreeEntity() {}

    public TreeEntity(Long id, String inputNumbers, String treeStructure) {
        this.id = id;
        this.inputNumbers = inputNumbers;
        this.treeStructure = treeStructure;
    }

    public TreeEntity(String numbers, String treeStructure) {
        this.inputNumbers = numbers;
        this.treeStructure = treeStructure;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInputNumbers() {
        return inputNumbers;
    }

    public void setInputNumbers(String inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public String getTreeStructure() {
        return treeStructure;
    }

    public void setTreeStructure(String treeStructure) {
        this.treeStructure = treeStructure;
    }

    // Getter and setter for the 'name' property
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Method to calculate the name of the tree
    public String calculateName() {
        String[] numbers = inputNumbers.split(",");
        if (numbers.length > 0) {
            return "Tree " + numbers[0];
        } else {
            return "Unnamed Tree";
        }
    }

    // Method to get additional data about the tree
    public String getData() {
        // Implement as per your requirements
        return "";
    }
}
