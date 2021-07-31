package com.etraveli.group.mazechallenge.util;

import com.etraveli.group.mazechallenge.exception.ApplicationMazeException;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileUtilsTest {

    @Test
    void testFileNotExists() {
        ApplicationMazeException applicationMazeException =
                assertThrows(ApplicationMazeException.class, () ->
                        FileUtils.file("src/test/resources/test.txt")
                );

        assertEquals("File not found", applicationMazeException.getMessage());
    }

    @Test
    void testReadFileWithError() {
        ApplicationMazeException applicationMazeException =
                assertThrows(ApplicationMazeException.class, () ->
                        FileUtils.readFile(new File("src/test/resources/test.txt"))
                );

        assertEquals("Failed to read file", applicationMazeException.getMessage());
    }
}
