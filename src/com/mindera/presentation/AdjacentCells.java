package com.mindera.presentation;
import java.util.ArrayList;
import java.util.List;

public class AdjacentCells {
	public int[][] numbers;
	public boolean[][] visited;
	public static final String OPEN_SQUARE_BRACKET="[";
	public static final String CLOSE_SQUARE_BRACKET="]";
	public static final String COMMA=",";
	public AdjacentCells(int[][] nos) {
		numbers = nos;
		visited = new boolean[getRowCount()][getColumnCount()];
	}

	public static void main(String[] args) {
		int[][] input = { { 0, 0, 0, 1, 0, 0, 1, 1 }, { 0, 0, 1, 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 1, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0, 0, 1, 1 } };
		AdjacentCells object = new AdjacentCells(input);
		object.compute();
	}

	private int getRowCount() {
		return numbers.length;
	}

	private int getColumnCount() {
		return numbers[0].length;
	}

	private boolean isInBoundary(int row, int column) {
		return row >= 0 && row < getRowCount() && column >= 0 && column < getColumnCount();
	}

	public void compute() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < getRowCount(); i++) {
			for (int j = 0; j < getColumnCount(); j++) {
				traverse(i, j, list);
				if (list.size() > 1)
					System.out.println(list.toString());
				list.clear();
			}
		}
	}

	private void traverse(int row, int column, List<String> list) {
		if (isInBoundary(row, column) && (!visited[row][column]) && numbers[row][column] == 1) {
			visited[row][column] = true;
			list.add(OPEN_SQUARE_BRACKET + row + COMMA + column + CLOSE_SQUARE_BRACKET);
			traverse(row + 1, column, list);
			traverse(row - 1, column, list);
			traverse(row, column + 1, list);
			traverse(row, column - 1, list);

		} else
			return;
	}
}
