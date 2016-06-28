package task.matrix.multiply;

/**
 * Created by P1A-7CK on 28.06.2016.
 */
public class StartMM {
    public static void main(String[] args) {
        Matrix matrixA = new Matrix("Alfa");
        Matrix matrixB = new Matrix("Beta");
        Matrix matrixC = new Matrix("Gamma");

        System.out.println("Setting matrix's dimension and values...");
        int[] v = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
        matrixA.setWidthHeight(4, 3);
        matrixA.setElements(v);
        v = new int[] {10, 10, 10, 10, 10, 15, 15, 15, 15, 15, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25};
        matrixB.setWidthHeight(5, 4);
        matrixB.setElements(v);

        matrixC.showMatrix();

        System.out.println("STEP #1");
        System.out.println("Trying to multiply with resulting to matrix '" + matrixC.name + "'...");
        matrixC.resultMatrixMultiply(matrixA, matrixB);

        System.out.println("STEP #2");
        System.out.println("Trying to multiply with resulting to matrix '" + matrixA.name + "'...");
        matrixA.resultMatrixMultiply(matrixA, matrixB);

        System.out.println("STEP #3 (DIMENSION EXCEPTION)");
        System.out.println("Trying to multiply with resulting to matrix '" + matrixB.name + "'...");
        matrixB.resultMatrixMultiply(matrixA, matrixC);

        matrixA.showMatrix();
        matrixB.showMatrix();
        matrixC.showMatrix();
    }
}
