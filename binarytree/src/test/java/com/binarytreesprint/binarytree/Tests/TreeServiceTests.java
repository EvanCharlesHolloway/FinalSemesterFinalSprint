package com.binarytreesprint.binarytree.Tests;

import com.binarytreesprint.binarytree.Entities.TreeEntity;
import com.binarytreesprint.binarytree.Repositories.TreeRepositories;
import com.binarytreesprint.binarytree.Services.TreeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class TreeServiceTests {

    @Mock
    private TreeRepositories treeRepository;

    private TreeService treeService;

    public TreeServiceTests() {
        MockitoAnnotations.openMocks(this);
        treeService = new TreeService(treeRepository);
    }

    @Test
    public void testGetAllTrees() {
        List<TreeEntity> testTrees = Arrays.asList(
                new TreeEntity(1L, "50", "{\"value\": 50}"),
                new TreeEntity(2L, "30", "{\"value\": 30}"),
                new TreeEntity(3L, "70", "{\"value\": 70}")
        );
        when(treeRepository.findAll()).thenReturn(testTrees);

        Iterable<TreeEntity> result = treeService.getAllTrees();

        assertEquals(testTrees.size(), ((List<TreeEntity>) result).size());
    }

    @Test
    public void testGetTreeById() {
        Long id = 1L;
        TreeEntity treeEntity = new TreeEntity(id, "50", "{\"value\": 50}");
        when(treeRepository.findById(id)).thenReturn(Optional.of(treeEntity));

        TreeEntity result = treeService.getTreeById(id);

        assertEquals(treeEntity, result);
    }

    @Test
    public void testGetTreeById_NotFound() {
        Long id = 4L;
        when(treeRepository.findById(id)).thenReturn(Optional.empty());

        TreeEntity result = treeService.getTreeById(id);

        assertNull(result);
    }
}
