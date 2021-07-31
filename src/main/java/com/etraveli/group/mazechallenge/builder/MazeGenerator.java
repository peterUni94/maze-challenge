package com.etraveli.group.mazechallenge.builder;

import com.etraveli.group.mazechallenge.model.Maze;
import com.etraveli.group.mazechallenge.model.Node;
import com.etraveli.group.mazechallenge.model.enumeration.MazeCellType;
import com.etraveli.group.mazechallenge.util.FileUtils;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class MazeGenerator {

    private File file;

    public MazeGenerator withFile(File file) {
        this.file = Objects.requireNonNull(file, "File cannot be null");
        return this;
    }

    public Maze create() {

        int[][] cells;
        Node start = null;
        Node end = null;

        List<String> lines = FileUtils.readFile(file);
        cells = new int[lines.size()][lines.get(0).length()];

        for (int i = 0; i < lines.size(); i++) {

            String line = lines.get(i);

            for (int j = 0; j < line.length(); j++) {

                String s = String.valueOf(line.charAt(j));

                MazeCellType mazeCellType = MazeCellType.fromText(s);
                switch (mazeCellType) {
                    case ROAD:
                        cells[i][j] = MazeCellType.ROAD.getCode();
                        break;
                    case WALL:
                        cells[i][j] = MazeCellType.WALL.getCode();
                        break;
                    case EXIT:
                        cells[i][j] = MazeCellType.EXIT.getCode();
                        end = new Node(i, j);
                        break;
                    case START:
                        cells[i][j] = MazeCellType.START.getCode();
                        start = new Node(i, j);
                        break;
                    default:
                }
            }
        }
        return new Maze(cells, start, end);
    }
}
