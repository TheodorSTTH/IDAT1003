public class Matrise {
    private int[][] matrise;
    public Matrise(int[][] matrise) {
        this.matrise = matrise;
    }
    final public int[][] adderMedMatrise(int[][] matriseSomSkalAdderesMed) {
        if (this.matrise.length != matriseSomSkalAdderesMed.length || this.matrise[0].length != matriseSomSkalAdderesMed[0].length) return null;
        int[][] utMatrise = new int[this.matrise.length][this.matrise[0].length];
        for (int row = 0; row < matrise.length; row++) {
            for (int col = 0; col < matrise[row].length; col++) {
                utMatrise[row][col] = this.matrise[row][col] + matriseSomSkalAdderesMed[row][col];
            }
        }
        return utMatrise;
    }
    final public int[][] multipliserMedMatrise(int[][] multiplumMatrise) {
        if (this.matrise[0].length != multiplumMatrise.length) return null;
        final int rows = this.matrise.length;
        final int cols = multiplumMatrise[0].length;
        int[][] utMatrise = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int i = 0; i < this.matrise[0].length; i++) {
                    utMatrise[row][col] += this.matrise[row][i]*multiplumMatrise[i][col];
                }
            }
        }
        return utMatrise;
    }
    final public int[][] transponer() {
        final int[][] utMatrise = new int[this.matrise[0].length][this.matrise.length]; 
        for (int row = 0; row < this.matrise.length; row++) {
            for (int col = 0; col < this.matrise[row].length; col++) {
                utMatrise[col][row] = this.matrise[row][col];
            }
        }
        return utMatrise;
    }
    final public int[][] skaffMatrise() {
        return this.matrise;
    }
}