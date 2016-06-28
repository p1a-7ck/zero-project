package task.matrix.multiply;

/**
 * Created by P1A-7CK on 28.06.2016.
 */
public class Matrix {
    private String name;
    private int[] elements;
    private int width = 2, height = 2;

    public Matrix(String name) {
        this.name = name;
        this.elements = new int[this.width * this.height];
        System.out.println("Matrix '" + this.name + "' initialized with dimension " + this.height + "x" + this.width);
    }

    public Matrix(String name, int width, int height) {
        this.name = name;
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
        }
        this.elements = new int[this.width * this.height];
        System.out.println("Matrix '" + this.name + "' initialized with dimension " + this.height + "x" + this.width);
    }

    public String getName() { return this.name; }
    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }

    public void resetWidthHeight(int width, int height) {
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
            this.elements = new int[this.width * this.height];
            System.out.println("Matrix '" + this.name + "' changed with dimension " + this.height + "x" + this.width);
        }
    }

    public void setElements(int[] elements) {
        if (elements.length == this.elements.length){
            this.elements = elements;
            this.showMatrix();
        } else {
            System.out.println("Number of elements not match '" + this.name + "' matrix's dimension");
        }
    }

    public void setElement(int rowIndex, int columnIndex, int elementValue) {
        if (rowIndex >= 0 && rowIndex < this.height && columnIndex >=0 && columnIndex < this.width) {
            this.elements[rowIndex * this.width + columnIndex] = elementValue;
            System.out.println("'" + this.name + "' matrix's element " + rowIndex + "," + columnIndex + " set to " + elementValue);
        }
    }

    public int getElement(int rowIndex, int columnIndex) {
        if (rowIndex >= 0 && rowIndex < this.height && columnIndex >=0 && columnIndex < this.width) {
            return this.elements[rowIndex * this.width + columnIndex];
        } else { return 0; } // bad return, because there are no exceptions manager
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