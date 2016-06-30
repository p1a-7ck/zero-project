package task.matrix.multiply;

/**
 * Created by P1A-7CK on 28.06.2016.
 */
public class MatrixMultiplier {
    Matrix matrixR;

    public MatrixMultiplier(Matrix matrixR) {
        this.matrixR = matrixR;
    }

    public MatrixMultiplier setMatrixR(Matrix matrixR) {
        this.matrixR = matrixR;
        return this;
    }

    private Matrix.ELEMENTS_TYPE getElementsType(Matrix.ELEMENTS_TYPE typeA, Matrix.ELEMENTS_TYPE typeB) {
        if (typeA == Matrix.ELEMENTS_TYPE.DOUBLE || typeB == Matrix.ELEMENTS_TYPE.DOUBLE ||
            matrixR.getElementsType() == Matrix.ELEMENTS_TYPE.DOUBLE) {
            return Matrix.ELEMENTS_TYPE.DOUBLE;
        } else {
            if (typeA == Matrix.ELEMENTS_TYPE.LONG || typeB == Matrix.ELEMENTS_TYPE.LONG ||
                matrixR.getElementsType() == Matrix.ELEMENTS_TYPE.LONG) {
                return Matrix.ELEMENTS_TYPE.LONG;
            }
            return Matrix.ELEMENTS_TYPE.INT;
        }
    }

    public Matrix multiplySimple(Matrix matrixA, Matrix matrixB) {
        /**
         * matrixA.height x matrixA.width
         * matrixB.height x matrixB.width
         * matrixA.width = matrixB.height
         * matrixResult.height x matrixResult.width
         * matrixResult.height = matrixA.height
         * matrixResult.width = matrixB.width
         * matrixResult i,j = matrixA i,w x matrixB h,j + matrixA i,w+1 x matrixB h+1,j + ...
         */
        Matrix.ELEMENTS_TYPE type = getElementsType(matrixA.getElementsType(), matrixB.getElementsType());

        if (matrixA.getWidth() == matrixB.getHeight()) {
            matrixR.resetWidthHeight(matrixB.getWidth(), matrixA.getHeight());
            switch (type) {
                case DOUBLE:
                    double[] elementsDouble = new double[matrixA.getHeight() * matrixB.getWidth()];
                    matrixA.setElementsType(Matrix.ELEMENTS_TYPE.DOUBLE);
                    matrixB.setElementsType(Matrix.ELEMENTS_TYPE.DOUBLE);
                    for (int i = 0; i < matrixA.getHeight(); i++) {
                        for (int j = 0; j < matrixB.getWidth(); j++) {
                            for (int k = 0; k < matrixA.getWidth(); k++) {
                                elementsDouble[i * matrixB.getWidth() + j] +=
                                matrixA.getElementDouble(i, k) * matrixB.getElementDouble(k, j);
                            }
                        }
                    }
                    matrixR.setElementsDouble(elementsDouble);
                    break;
                case LONG:
                    long[] elementsLong = new long[matrixA.getHeight() * matrixB.getWidth()];
                    matrixA.setElementsType(Matrix.ELEMENTS_TYPE.LONG);
                    matrixB.setElementsType(Matrix.ELEMENTS_TYPE.LONG);
                    for (int i = 0; i < matrixA.getHeight(); i++) {
                        for (int j = 0; j < matrixB.getWidth(); j++) {
                            for (int k = 0; k < matrixA.getWidth(); k++) {
                                elementsLong[i * matrixB.getWidth() + j] +=
                                matrixA.getElementLong(i, k) * matrixB.getElementLong(k, j);
                            }
                        }
                    }
                    matrixR.setElementsLong(elementsLong);
                    break;
                case INT:
                    int[] elementsInt = new int[matrixA.getHeight() * matrixB.getWidth()];
                    for (int i = 0; i < matrixA.getHeight(); i++) {
                        for (int j = 0; j < matrixB.getWidth(); j++) {
                            for (int k = 0; k < matrixA.getWidth(); k++) {
                                elementsInt[i * matrixB.getWidth() + j] +=
                                matrixA.getElementInt(i, k) * matrixB.getElementInt(k, j);
                            }
                        }
                    }
                    matrixR.setElementsInt(elementsInt);
                    break;
            }
        } else {
            throw new IllegalArgumentException("'" + matrixA.getName() + "' matrix's width should be equal to '" +
                                                     matrixB.getName() + "' matrix's height");
        }
        return matrixR;
    }
}