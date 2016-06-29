package task.matrix.multiply;

import java.util.Random;

/**
 * Created by P1A-7CK on 28.06.2016.
 */
public class MatrixManipulator {
    private Matrix matrixR;

    public MatrixManipulator() {
        this.matrixR = new Matrix("no_name");
    }

    public MatrixManipulator(String name) {
        this.matrixR = new Matrix(name);
    }

    public MatrixManipulator(Matrix matrixR) {
        this.matrixR = matrixR;
    }

    private Matrix.ELEMENTS_TYPE getElementsType(Matrix.ELEMENTS_TYPE typeA, Matrix.ELEMENTS_TYPE typeB) {
        if (typeA == Matrix.ELEMENTS_TYPE.DOUBLE || typeB == Matrix.ELEMENTS_TYPE.DOUBLE ||
            this.matrixR.getElementsType() == Matrix.ELEMENTS_TYPE.DOUBLE) {
            return Matrix.ELEMENTS_TYPE.DOUBLE;
        } else {
            if (typeA == Matrix.ELEMENTS_TYPE.LONG || typeB == Matrix.ELEMENTS_TYPE.LONG ||
                this.matrixR.getElementsType() == Matrix.ELEMENTS_TYPE.LONG) {
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
            this.matrixR.resetWidthHeight(matrixB.getWidth(), matrixA.getHeight());
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
                    this.matrixR.setElementsDouble(elementsDouble);
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
                    this.matrixR.setElementsLong(elementsLong);
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
                    this.matrixR.setElementsInt(elementsInt);
                    break;
            }
            return this.matrixR;
        } else {
            throw new IllegalArgumentException("'" + matrixA.getName() + "' matrix's width should be equal to '" +
                                                     matrixB.getName() + "' matrix's height");
        }
    }

    public Matrix generateRandomMatrix(int agreedSize, int maxSize) {
        Random rn = new Random();

        if (maxSize <= 0 && maxSize > 10) maxSize = 10;
        if (agreedSize <= 0) {
            this.matrixR.resetWidthHeight(rn.nextInt((maxSize - 1) + 1), rn.nextInt((maxSize - 1) + 1));
        } else {
            this.matrixR.resetWidthHeight(rn.nextInt((maxSize - 1) + 1), agreedSize);
        }
        int t = rn.nextInt(3);
        switch(t) {
            case 0:
                int[] elementsInt = new int[this.matrixR.getWidth() * this.matrixR.getHeight()];
                for (int i = 0; i < elementsInt.length; i++) elementsInt[i] = rn.nextInt();
                this.matrixR.setElementsInt(elementsInt);
                break;
            case 1:
                long[] elementsLong = new long[this.matrixR.getWidth() * this.matrixR.getHeight()];
                for (int i = 0; i < elementsLong.length; i++) elementsLong[i] = rn.nextLong();
                this.matrixR.setElementsLong(elementsLong);
                break;
            case 2:
                double[] elementsDouble = new double[this.matrixR.getWidth() * this.matrixR.getHeight()];
                for (int i = 0; i < elementsDouble.length; i++) elementsDouble[i] = rn.nextDouble();
                this.matrixR.setElementsDouble(elementsDouble);
                break;
        }
        return this.matrixR;
    }
}