package task.matrix.multiply;

/**
 * Created by P1A-7CK on 28.06.2016.
 */
public class MatrixMultiply {
    private Matrix matrixR;

    public MatrixMultiply() {
        this.matrixR = new Matrix("no_name");
    }

    public MatrixMultiply(Matrix matrixR) {
        this.matrixR = matrixR;
    }

    public Matrix Multiply(Matrix matrixA, Matrix matrixB) {
        /**
         * matrixA.height x matrixA.width
         * matrixB.height x matrixB.width
         * matrixA.width = matrixB.height
         * matrixResult.height x matrixResult.width
         * matrixResult.height = matrixA.height
         * matrixResult.width = matrixB.width
         * matrixResult i,j = matrixA i,w x matrixB h,j + matrixA i,w+1 x matrixB h+1,j + ...
         */
        int[] elementsResult;

        if (matrixA.getWidth() == matrixB.getHeight()) {
            System.out.println("Resulting multiply matrix '" + matrixA.getName() + "' and matrix '" + matrixB.getName() + "'");
            elementsResult = new int[matrixA.getHeight() * matrixB.getWidth()];
            for (int i = 0; i < matrixA.getHeight(); i++) {
                for (int j = 0; j < matrixB.getWidth(); j++) {
                    for (int k = 0; k < matrixA.getWidth(); k++) {
                        elementsResult[i * matrixB.getWidth() + j] += matrixA.getElement(i, k) * matrixB.getElement(k, j);
                    }
                }
            }
            this.matrixR.resetWidthHeight(matrixB.getWidth(), matrixA.getHeight());
            this.matrixR.setElements(elementsResult);
            return this.matrixR;
        } else {
            System.out.println("'" + matrixA.getName() + "' matrix's width should be equal to '" + matrixB.getName() + "' matrix's height");
            return this.matrixR;
        }
    }

}
