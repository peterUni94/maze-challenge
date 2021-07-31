package com.etraveli.group.mazechallenge.algorithm;

import com.etraveli.group.mazechallenge.model.Actor;
import com.etraveli.group.mazechallenge.model.Maze;
import com.etraveli.group.mazechallenge.model.Node;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MazeDriverAlgorithmTest {

    @Test
    void testCreateWithNullMaze() {

        NullPointerException nullPointerException =
                assertThrows(NullPointerException.class, () ->
                        new MazeDriverAlgorithm().withMaze(null).withActor(new Actor()).run()
                );

        assertEquals("Maze cannot be null", nullPointerException.getMessage());
    }

    @Test
    void testCreateWithNullActor() {

        NullPointerException nullPointerException =
                assertThrows(NullPointerException.class, () ->
                        new MazeDriverAlgorithm().withMaze(new Maze()).withActor(null).run()
                );

        assertEquals("Actor cannot be null", nullPointerException.getMessage());
    }

    @Test
    void testRun() {

        Maze maze = new Maze(new int[2][2], new Node(0, 1), new Node(1, 0));
        Actor actor = new Actor(new boolean[2][2]);

        assertEquals(List.of(new Node(0, 1), new Node(1, 1), new Node(1, 0)), new MazeDriverAlgorithm().withActor(actor).withMaze(maze).run());
    }
}
