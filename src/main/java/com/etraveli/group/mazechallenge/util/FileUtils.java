package com.etraveli.group.mazechallenge.util;

import com.etraveli.group.mazechallenge.exception.ApplicationMazeException;
import org.apache.commons.collections.CollectionUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public final class FileUtils {

    private FileUtils() {
    }

    public static File file(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new ApplicationMazeException("File not found");
        }

        return file;
    }

    public static List<String> readFile(File file) {

        List<String> lines;

        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new ApplicationMazeException("Failed to read file", e);
        }

        if (CollectionUtils.isEmpty(lines)) {
            throw new ApplicationMazeException("File is empty");
        }

        return lines;
    }
}
