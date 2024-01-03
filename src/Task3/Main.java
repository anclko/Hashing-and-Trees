package Task3;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static class WordPuzzleSolver {
        private final char[][] puzzle; // 2D array representing the word puzzle
        private final int rows;
        private final int cols;

        // Set to store the valid words
        private final Set<String> dictionary;

        // Set to store prefixes of the valid words
        private final Set<String> prefixes;
        // Array to represent 8 possible directions: right, down, diagonal down-right, diagonal down-left, left, up, diagonal up-left, diagonal up-right
        private final int[][] directions = {{0, 1}, {1, 0}, {1, 1}, {1, -1}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}};

        // Constructor to initialize the word puzzle
        public WordPuzzleSolver(char[][] puzzle) {
            this.puzzle = puzzle;
            this.rows = puzzle.length;
            this.cols = puzzle[0].length;
            this.dictionary = new HashSet<>();
            this.prefixes = new HashSet<>();
        }

        // Method to add words to the dictionary and their prefixes to the prefixes set
        public void storeWord(String[] words) {
            for (String word : words) {
                // Add each word to the dictionary
                dictionary.add(word);
                // Store all prefixes of the word
                for (int i = 1; i <= word.length(); i++) {
                    prefixes.add(word.substring(0, i));
                }
            }
        }

        // Method to find and print all valid words in the puzzle
        public void findWords() {
            // Iterate over each cell (row and col)
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    // Explore in all directions from the current cell
                    for (int[] dir : directions) {
                        // Explore words of different lengths
                        for (int len = 1; len <= Math.max(rows, cols); len++) {
                            StringBuilder wordBuilder = new StringBuilder();
                            for (int i = 0; i < len; i++) {
                                int currentRow = row + i * dir[0];
                                int currentCol = col + i * dir[1];

                                // Check if the position is within the bounds of the puzzle
                                if (isValidPosition(currentRow, currentCol)) {
                                    wordBuilder.append(puzzle[currentRow][currentCol]);
                                } else {
                                    //out of bounds
                                    break;
                                }
                            }
                            String word = wordBuilder.toString();

                            // Check if the formed word is a valid prefix or word
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

        // Helper method to check if a position is valid within the puzzle
        private boolean isValidPosition(int row, int col) {
            return row >= 0 && row < rows && col >= 0 && col < cols;
        }

        // Method to print the word puzzle
        public void printWord() {
            // Print column headers
            System.out.print("  ");
            for (int col = 0; col < cols; col++) {
                System.out.print(col + " ");
            }
            System.out.println();

            // Print each row with row number
            for (int row = 0; row < rows; row++) {
                System.out.print(row + " ");
                for (int col = 0; col < cols; col++) {
                    System.out.print(puzzle[row][col] + " ");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            // Sample puzzle and words
            char[][] puzzle = {
                    {'t', 'h', 'i', 's'},
                    {'w', 'a', 't', 's'},
                    {'o', 'a', 'h', 'g'},
                    {'f', 'g', 'd', 't'}
            };
            String[] words = {"this", "two", "fat", "that"};

            // Create an instance of the solver, store words, print the puzzle, and find words
            WordPuzzleSolver solver = new WordPuzzleSolver(puzzle);
            solver.storeWord(words);
            solver.printWord();
            System.out.println();
            solver.findWords();
        }
    }
}
