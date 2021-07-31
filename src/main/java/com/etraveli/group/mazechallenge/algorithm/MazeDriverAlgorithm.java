package com.etraveli.group.mazechallenge.algorithm;

import com.etraveli.group.mazechallenge.model.Actor;
import com.etraveli.group.mazechallenge.model.Maze;
import com.etraveli.group.mazechallenge.model.Node;
import com.etraveli.group.mazechallenge.model.enumeration.MazeDirection;
import com.etraveli.group.mazechallenge.util.MazeUtils;

import java.util.*;

public class MazeDriverAlgorithm {
    private Maze maze;
    private Actor actor;

    public MazeDriverAlgorithm withMaze(Maze maze) {
        this.maze = Objects.requireNonNull(maze, "Maze cannot be null");
        return this;
    }

    public MazeDriverAlgorithm withActor(Actor actor) {
        this.actor = Objects.requireNonNull(actor, "Actor cannot be null");
        return this;
    }

    public List<Node> run() {

        List<Node> nodes = new LinkedList<>();
        Deque<Node> deque = new ArrayDeque<>();
        deque.push(maze.getStart());

        while (!deque.isEmpty()) {

            Node node = deque.pop();

            if (MazeUtils.validCellPredicate(node, maze.getCells(), actor.getVisited())) {

                nodes.add(node);
                actor.getVisited()[node.getX()][node.getY()] = true;

                if (maze.getEnd().equals(node)) {
                    break;
                }

                for (MazeDirection direction : MazeDirection.values()) {
                    Node newNode = new Node(node.getX() + direction.getX(), node.getY() + direction.getY());
                    deque.push(newNode);
                }
            }
        }
        return nodes;
    }
}
