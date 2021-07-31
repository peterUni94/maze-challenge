package com.etraveli.group.mazechallenge.util;

import com.etraveli.group.mazechallenge.model.Node;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MazeUtilsTest {

    @Test
    void testTransform() {

        List<Node> nodes = List.of(
                new Node(1,1),
                new Node(0,1),
                new Node(1,2),
                new Node(1,3)
        );

        assertEquals("(1,1),(0,1),(1,2),(1,3)", MazeUtils.transform(nodes));
    }
}
