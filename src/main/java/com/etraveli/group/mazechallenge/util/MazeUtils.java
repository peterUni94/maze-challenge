package com.etraveli.group.mazechallenge.util;

import com.etraveli.group.mazechallenge.model.Node;
import com.etraveli.group.mazechallenge.model.enumeration.MazeCellType;

import java.util.List;
import java.util.stream.Collectors;

public final class MazeUtils {

    private MazeUtils() {
    }

    public static String transform(List<Node> nodes) {
        List<String> elements = nodes.stream().map(node -> String.format("(%s,%s)", node.getX(), node.getY())).collect(Collectors.toList());

        return String.join(",", elements);
    }

    public static boolean validCellPredicate(Node node, int[][] cells, boolean[][] visited) {
        return correctLocation(node, cells) && !isBlocked(node, cells) && !isVisited(node, visited);
    }

    private static boolean correctLocation(Node node, int[][] cells) {
        return !(node.getX() < 0 || node.getX() >= cells.length || node.getY() < 0 || node.getY() >= cells[0].length);
    }

    private static boolean isBlocked(Node node, int[][] cells) {
        return cells[node.getX()][node.getY()] == MazeCellType.WALL.getCode();
    }

    private static boolean isVisited(Node node, boolean[][] visited) {
        return visited[node.getX()][node.getY()];
    }
}
