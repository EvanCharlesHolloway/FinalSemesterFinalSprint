package com.binarytreesprint.binarytree.Controllers;

import com.binarytreesprint.binarytree.Entities.TreeEntity;
import com.binarytreesprint.binarytree.Services.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class TreeController {

    @Autowired
    private TreeService treeService; // Assuming you have a service class for handling tree operations

    @GetMapping("/show-tree/{id}")
    public String showTree(@PathVariable Long id, Model model) {
        TreeEntity treeEntity = treeService.getTreeById(id);
        model.addAttribute("tree", treeEntity);
        return "show-tree"; // Return the name of the HTML page for displaying the tree
    }

    @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model) {
        List<TreeEntity> previousTrees = (List<TreeEntity>) treeService.getAllTrees();
        model.addAttribute("trees", previousTrees);
        return "previous-trees"; // Return the name of the HTML page for displaying previous trees
    }
}
