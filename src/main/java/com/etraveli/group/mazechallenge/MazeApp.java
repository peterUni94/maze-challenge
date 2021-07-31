package com.etraveli.group.mazechallenge;

import com.etraveli.group.mazechallenge.algorithm.MazeDriverAlgorithm;
import com.etraveli.group.mazechallenge.builder.MazeGenerator;
import com.etraveli.group.mazechallenge.model.Actor;
import com.etraveli.group.mazechallenge.model.Maze;
import com.etraveli.group.mazechallenge.model.Node;
import com.etraveli.group.mazechallenge.util.FileUtils;
import com.etraveli.group.mazechallenge.util.MazeUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MazeApp {

    private static final String FILE = "src/main/resources/maze-specs-empty.txt";

    public static void main(String[] args) {

        log.info("Generating maze...");

        //generate maze
        Maze maze = new MazeGenerator()
                .withFile(FileUtils.file(FILE))
                .create();

        //create actor
        Actor actor = new Actor(new boolean[maze.getCells().length][maze.getCells()[0].length]);

        log.info("Generating finished");
        log.info("Starting Maze Driver Algorithm");

        //run algorithm
        List<Node> nodes = new MazeDriverAlgorithm()
                .withMaze(maze)
                .withActor(actor)
                .run();

        //print path
        log.info("Finished Maze Driver Algorithm. Path: {}", MazeUtils.transform(nodes));
    }
}
