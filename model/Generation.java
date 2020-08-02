package model;

import java.util.Random;

public class Generation {
    private boolean[][] field;

    public Generation(int n) {
        this.field = new boolean[n][n];
        Random random = new Random();
        for (int h = 0; h < field.length; h++) {
            for (int w = 0; w < field[h].length; w++) {
                field[h][w] = random.nextBoolean();
            }
        }
    }
    public boolean[][] getField() {
        return field;
    }

    public void setField(boolean[][] field) {
        this.field = field;
    }

    public void nextGeneration(boolean[][] field) {
        this.field = new boolean[field.length][field.length];
        int count;
        for (int h = 0; h < field.length; h++) {
            for (int w = 0; w < field[h].length; w++) {
                count = 0;
                if (field[contr(h + 1)][contr(w)]) {
                    count++;
                }
                if (field[contr(h - 1)][contr(w)]) {
                    count++;
                }
                if (field[contr(h)][contr(w + 1)]) {
                    count++;
                }
                if (field[contr(h)][contr(w - 1)]) {
                    count++;
                }
                if (field[contr(h + 1)][contr(w + 1)]) {
                    count++;
                }
                if (field[contr(h + 1)][contr(w - 1)]) {
                    count++;
                }
                if (field[contr(h - 1)][contr(w + 1)]) {
                    count++;
                }
                if (field[contr(h - 1)][contr(w - 1)]) {
                    count++;
                }
                if (field[h][w] && (count < 2 || count > 3)) {
                    this.field[h][w] = false;
                } else if (!field[h][w] && count == 3) {
                    this.field[h][w] = true;
                } else if (field[h][w]) {
                    this.field[h][w] = field[h][w];
                }
            }
        }
    }
    private int contr(int x) {
        if (x < 0) {
            return field.length - 1;
        }
        if (x >= field.length) {
            return 0;
        }
        return x;
    }
}
