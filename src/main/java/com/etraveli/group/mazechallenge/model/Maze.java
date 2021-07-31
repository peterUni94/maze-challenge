package com.etraveli.group.mazechallenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Maze {
    private int[][] cells;
    private Node start;
    private Node end;
}
