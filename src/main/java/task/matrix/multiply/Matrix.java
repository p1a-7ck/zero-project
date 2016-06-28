package task.matrix.multiply;

/**
 * Created by P1A-7CK on 28.06.2016.
 */
public class Matrix {
    public String name;
    private int[] elements;
    private int width = 2, height = 2;

    public Matrix(String name) {
        this.name = name;
        this.elements = new int[this.width * this.height];
        System.out.println("Matrix '" + this.name + "' initialized");
    }

    public void setWidth(int width) {
        this.width = width;
        this.elements = new int[this.width * this.height];
        System.out.println("Matrix '" + this.name + "' width set to " + this.width);
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int height) {
        this.height = height;
        this.elements = new int[this.width * this.height];
        System.out.println("Matrix '" + this.name + "' height set to " + this.height);
    }

    public int getHeight() {
        return this.height;
    }

    public void setWidthHeight(int width, int height) {
        this.width = width;
        this.height = height;
        this.elements = new int[this.width * this.height];
        System.out.println("Matrix '" + this.name + "' width set to " + this.width + " and height set to " + this.height);
    }

    public void setElements(int[] elements) {
        if (elements.length == this.elements.length){
            this.elements = elements;
            this.showMatrix();
        } else {
            System.out.println("Number of elements not match '" + this.name + "' matrix's dimension");
        }
    }

    public void setElementsRow(int rowIndex, int[] row) {
        int j = 0;

        System.out.println("Matrix '" + this.name + "' row #" + rowIndex + " set to next values:");
        for (int i = rowIndex * this.width; i < (rowIndex + 1) * this.width; i++) {
            this.elements[i] = row[j];
            System.out.println("Element " + rowIndex + "," + j + " = " + this.elements[i]);
            j++;
        }
    }

    public void setElement(int rowIndex, int columnIndex, int elementValue) {
        this.elements[rowIndex * this.width + columnIndex] = elementValue;
        System.out.println("'" + this.name + "' matrix's element " + rowIndex + "," + columnIndex + " set to " + elementValue);
    }

    public int getElement(int rowIndex, int columnIndex) {
        return this.elements[rowIndex * this.width + columnIndex];
    }

    public void resultMatrixMultiply(Matrix matrixA, Matrix matrixB) {
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

        if (matrixA.width == matrixB.height) {
            System.out.println("Resulting multiply matrix '" + matrixA.name + "' and matrix '" + matrixB.name + "'");
            elementsResult = new int[matrixA.height * matrixB.width];
            for (int i = 0; i < matrixA.height; i++) {
                for (int j = 0; j < matrixB.width; j++) {
                    for (int k = 0; k < matrixA.width; k++) {
                        elementsResult[i * matrixB.width + j] = elementsResult[i * matrixB.width + j] +
                                matrixA.elements[i * matrixA.width + k] * matrixB.elements[k * matrixB.width + j];
                    }
                }
            }
            this.setWidthHeight(matrixB.width, matrixA.height);
            this.setElements(elementsResult);
        } else {
            System.out.println("'" + matrixA.name + "' matrix's width should be equal to '" + matrixB.name + "' matrix's height");
        }
    }

    public void showMatrix() {
        System.out.println("Matrix '" + this.name + "':");
        for (int j = 0; j < this.height; j++) {
            for (int i = 0; i < this.width; i++) {
                System.out.print(this.elements[j * this.width + i] + "\t");
            }
            System.out.println();
        }
    }
}