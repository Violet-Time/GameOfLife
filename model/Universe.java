package model;

public class Universe {
    private Generation generation;
    private boolean[][] field;
    private int sizeField = 10;
    private int countSteps = 0;

    public Universe() {
        this.generation = new Generation(sizeField);
        this.field = this.generation.getField();
    }

    private void setField(boolean[][] field) {
        if (this.field.length == field.length && this.field[0].length == field[0].length) {
            this.field = field;
        }
    }

    public boolean[][] getField() {
        return field;
    }

    public int countAlive() {
        int count = 0;
        for (boolean[] booleans : field) {
            for (boolean aBooleans : booleans) {
                if (aBooleans) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getCountSteps() {
        return countSteps;
    }

    public void step() {
        this.generation.nextGeneration(this.field);
        this.field = this.generation.getField();
        countSteps++;
    }

    public void restart() {
        this.generation = new Generation(sizeField);
        this.field = this.generation.getField();
        countSteps = 0;
    }

    public void setSizeField(int sizeField) {
        this.sizeField = sizeField;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (boolean[] booleans : field) {
            for (boolean aBooleans : booleans) {
                builder.append(aBooleans ? 'O' : ' ');
            }
            builder.append('\n');
        }
        return builder.toString();
    }
}
