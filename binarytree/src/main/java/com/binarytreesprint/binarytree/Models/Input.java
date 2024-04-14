// Input.java
package com.binarytreesprint.binarytree.Models;

public class Input {
    private Long id;
    private String numbers;

    public Input() {
    }

    public Input(String numbers) {
        this.numbers = numbers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }
}
