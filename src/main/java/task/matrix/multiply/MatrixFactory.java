package task.matrix.multiply;

import java.util.Random;

/**
 * Created by P1A-7CK on 30.06.2016.
 */
public class MatrixFactory {
    Matrix matrixR;

    public MatrixFactory(Matrix matrixR) {
        this.matrixR = matrixR;
    }

    public MatrixFactory setMatrixR(Matrix matrixR) {
        this.matrixR = matrixR;
        return this;
    }

    public Matrix generateRandomMatrix(int agreedSize, int maxSize) {
        Random rn = new Random();

        if (maxSize <= 0 && maxSize > 10) maxSize = 10;
        if (agreedSize <= 0) {
            matrixR.resetWidthHeight(rn.nextInt((maxSize - 1) + 1), rn.nextInt((maxSize - 1) + 1));
        } else {
            matrixR.resetWidthHeight(rn.nextInt((maxSize - 1) + 1), agreedSize);
        }
        int t = rn.nextInt(3);
        switch(t) {
            case 0:
                int[] elementsInt = new int[matrixR.getWidth() * matrixR.getHeight()];
                for (int i = 0; i < elementsInt.length; i++) elementsInt[i] = rn.nextInt();
                matrixR.setElementsInt(elementsInt);
                break;
            case 1:
                long[] elementsLong = new long[matrixR.getWidth() * matrixR.getHeight()];
                for (int i = 0; i < elementsLong.length; i++) elementsLong[i] = rn.nextLong();
                matrixR.setElementsLong(elementsLong);
                break;
            case 2:
                double[] elementsDouble = new double[matrixR.getWidth() * matrixR.getHeight()];
                for (int i = 0; i < elementsDouble.length; i++) elementsDouble[i] = rn.nextDouble();
                matrixR.setElementsDouble(elementsDouble);
                break;
        }
        return matrixR;
    }
}