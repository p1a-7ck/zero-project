package task.matrix.multiply;

/**
 * Created by P1A-7CK on 28.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        Matrix matrixA = new Matrix("Alfa");
        Matrix matrixB = new Matrix("Beta");
        Matrix matrixC = new Matrix("Gamma");
        MatrixFactory matrixGen = new MatrixFactory(matrixA);
        MatrixMultiplier matrixMul = new MatrixMultiplier(matrixC);

        matrixA = matrixGen.generateRandomMatrix(0, 10);
        matrixB = matrixGen.setMatrixR(matrixB).generateRandomMatrix(matrixA.getWidth(), 10);

        for (int i = 0; i < 10; i ++) {
            System.out.println("\n***");
            matrixA = matrixGen.setMatrixR(matrixA).generateRandomMatrix(0, 10);
            matrixB = matrixGen.setMatrixR(matrixB).generateRandomMatrix(matrixA.getWidth(), 10);
            matrixC = matrixGen.setMatrixR(matrixC).generateRandomMatrix(0, 10);
            System.out.println(matrixA);
            System.out.println(matrixB);
            System.out.println(matrixC);

            System.out.println("\nSTEP #" + (i + 1));
            System.out.println("Trying to multiply with resulting to matrix '" + matrixC.getName() + "'...");
            try {
                matrixC = matrixMul.setMatrixR(matrixC).multiplySimple(matrixA, matrixB);
                System.out.println(matrixC);
            } catch (Exception exc) {
                System.out.println("Failed (" + exc.getMessage() + ")");
            }
        }
    }
}
