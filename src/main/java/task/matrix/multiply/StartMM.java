package task.matrix.multiply;

/**
 * Created by P1A-7CK on 28.06.2016.
 */
public class StartMM {
    public static void main(String[] args) {
        Matrix matrixA = new Matrix("Alfa", 4, 3);
        Matrix matrixB = new Matrix("Beta", 5, 4);
        Matrix matrixC = new Matrix("Gamma");

        int[] v = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
        matrixA.setElements(v);
        v = new int[] {10, 10, 10, 10, 10, 15, 15, 15, 15, 15, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25};
        matrixB.setElements(v);
        matrixC.showMatrix();

        System.out.println("\nSTEP #1");
        System.out.println("Trying to multiply with resulting to matrix '" + matrixC.getName() + "'...");
        matrixC = new MatrixMultiply(matrixC).Multiply(matrixA, matrixB);

        System.out.println("\nSTEP #2");
        System.out.println("Trying to multiply with resulting to matrix '" + matrixA.getName() + "'...");
        matrixA = new MatrixMultiply(matrixA).Multiply(matrixA, matrixB);

        System.out.println("\nSTEP #3 (DIMENSION EXCEPTION)");
        System.out.println("Trying to multiply with resulting to matrix '" + matrixB.getName() + "'...");
        matrixB = new MatrixMultiply(matrixB).Multiply(matrixA, matrixC);

        System.out.println("\nSTEP #4 (DYNAMICALLY CREATING OBJECT AND ASSIGNING RESULT)");
        System.out.println("Trying to multiply with resulting to new matrix...");
        Matrix matrixD = new MatrixMultiply().Multiply(matrixA, matrixB);

        matrixA.showMatrix();
        matrixB.showMatrix();
        matrixC.showMatrix();

        matrixD.showMatrix();

        System.out.println("\nSTEP #5 (WRONG DIMENSION EXCEPTION)");
        System.out.println("Trying to initialize with 0x0 dimension...");
        matrixD = new Matrix("Extra", 0, 0);

        System.out.println("\nSTEP #6 (WRONG DIMENSION EXCEPTION)");
        System.out.println("Trying to get element 5,4 from matrix '" + matrixD.getName() + "'...");
        System.out.println("'" + matrixD.getName() + "' matrix's element 5,4 = " + matrixD.getElement(5, 4));
    }
}
