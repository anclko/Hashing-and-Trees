package Task3;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static class WordPuzzleSolver {
        private final char[][] puzzle;
        private final int rows;
        private final int cols;
        private final Set<String> dictionary;
        private final Set<String> prefixes;
        private final int[][] directions = {{0, 1}, {1, 0}, {1, 1}, {1, -1}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}};

        public WordPuzzleSolver(char[][] puzzle) {
            this.puzzle = puzzle;
            this.rows = puzzle.length;
            this.cols = puzzle[0].length;
            this.dictionary = new HashSet<>();
            this.prefixes = new HashSet<>();
        }

        public void storeWord(String[] words) {
            for (String word : words) {
                dictionary.add(word);
                // Store all prefixes of the word
                for (int i = 1; i <= word.length(); i++) {
                    prefixes.add(word.substring(0, i));
                }
            }
        }

        public void findWords() {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    for (int[] dir : directions) {
                        for (int len = 1; len <= Math.max(rows, cols); len++) {
                            StringBuilder wordBuilder = new StringBuilder();
                            for (int i = 0; i < len; i++) {
                                int currentRow = row + i * dir[0];
                                int currentCol = col + i * dir[1];

                                if (isValidPosition(currentRow, currentCol)) {
                                    wordBuilder.append(puzzle[currentRow][currentCol]);
                                } else {
                                    //out of bounds
                                    break;
                                }
                            }
                            String word = wordBuilder.toString();

                            if (prefixes.contains(word)) {
                                if (dictionary.contains(word)) {
                                    System.out.println("Found word: " + word + " at (" + row + "," + col + ")");
                                }
                            }
                        }
                    }
                }
            }
        }

        private boolean isValidPosition(int row, int col) {
            return row >= 0 && row < rows && col >= 0 && col < cols;
        }

        public void printWord() {
            System.out.print("  ");
            for (int col = 0; col < cols; col++) {
                System.out.print(col + " ");
            }
            System.out.println();

            for (int row = 0; row < rows; row++) {
                System.out.print(row + " ");
                for (int col = 0; col < cols; col++) {
                    System.out.print(puzzle[row][col] + " ");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            char[][] puzzle = {
                    {'t', 'h', 'i', 's'},
                    {'w', 'a', 't', 's'},
                    {'o', 'a', 'h', 'g'},
                    {'f', 'g', 'd', 't'}
            };

            String[] words = {"this", "two", "fat", "that"};

            WordPuzzleSolver solver = new WordPuzzleSolver(puzzle);
            solver.storeWord(words);
            solver.printWord();
            System.out.println();
            solver.findWords();
        }
    }
}