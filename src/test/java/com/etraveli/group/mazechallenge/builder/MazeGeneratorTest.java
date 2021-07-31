package com.etraveli.group.mazechallenge.builder;

import com.etraveli.group.mazechallenge.exception.ApplicationMazeException;
import com.etraveli.group.mazechallenge.model.Maze;
import com.etraveli.group.mazechallenge.model.enumeration.MazeCellType;
import com.etraveli.group.mazechallenge.util.FileUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MazeGeneratorTest {

    @Test
    void testCreateWithNullFile() {
        NullPointerException nullPointerException =
                assertThrows(NullPointerException.class, () ->
                        new MazeGenerator().withFile(null).create()
                );

        assertEquals("File cannot be null", nullPointerException.getMessage());
    }

    @Test
    void testCreateEmptyFile() {

        ApplicationMazeException applicationMazeException =
                assertThrows(ApplicationMazeException.class, () ->
                        new MazeGenerator().withFile(FileUtils.file("src/test/resources/maze-specs-empty.txt")).create()
                );

        assertEquals("File is empty", applicationMazeException.getMessage());
    }

    @Test
    void testCreateWrongType() {

        IllegalArgumentException mazeException =
                assertThrows(IllegalArgumentException.class, () ->
                        new MazeGenerator().withFile(FileUtils.file("src/test/resources/maze-specs-wrong-type.txt")).create()
                );

        assertEquals("Wrong type", mazeException.getMessage());
    }

    @Test
    void testCreate() {

        Maze maze = new MazeGenerator().withFile(FileUtils.file("src/test/resources/maze-specs.txt")).create();
        assertEquals(8, maze.getCells()[0].length);
        assertEquals(1, maze.getCells().length);
        assertEquals(MazeCellType.EXIT.getCode(), maze.getCells()[0][1]);
        assertEquals(MazeCellType.WALL.getCode(), maze.getCells()[0][4]);
        assertEquals(MazeCellType.START.getCode(), maze.getCells()[0][7]);
    }
}
