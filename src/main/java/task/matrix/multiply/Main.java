package task.matrix.multiply;

/**
 * Created by P1A-7CK on 28.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        Matrix matrixA = new Matrix("Alfa");
        Matrix matrixB = new Matrix("Beta");
        Matrix matrixC = new Matrix("Gamma");

        for (int i = 0; i < 10; i ++) {
            System.out.println("\n***");
            matrixA = new MatrixManipulator(matrixA).generateRandomMatrix(0, 10);
            matrixB = new MatrixManipulator(matrixB).generateRandomMatrix(matrixA.getWidth(), 10);
            matrixC = new MatrixManipulator(matrixC).generateRandomMatrix(0, 10);
            System.out.println(matrixA);
            System.out.println(matrixB);
            System.out.println(matrixC);

            System.out.println("\nSTEP #" + (i + 1));
            System.out.println("Trying to multiply with resulting to matrix '" + matrixC.getName() + "'...");
            try {
                matrixC = new MatrixManipulator(matrixC).multiplySimple(matrixA, matrixB);
                System.out.println(matrixC);
            } catch (Exception exc) {
                System.out.println("Failed (" + exc.getMessage() + ")");
            }
        }
    }
}
