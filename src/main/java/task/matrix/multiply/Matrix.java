package task.matrix.multiply;

/**
 * Created by P1A-7CK on 28.06.2016.
 */
public class Matrix {
    //public abstract void generateRandomMatrix(int agreedSize, int maxSize);
    //public abstract void multiplySimple(Matrix matrixA, Matrix matrixB);

    public enum ELEMENTS_ALLC { NONE, DONE }
    public enum ELEMENTS_TYPE { NONE, INT, LONG, DOUBLE }

    private String name;
    private int[] elementsInt;
    private long[] elementsLong;
    private double[] elementsDouble;
    private int width = 0, height = 0;
    private ELEMENTS_ALLC allc = ELEMENTS_ALLC.NONE;
    private ELEMENTS_TYPE type = ELEMENTS_TYPE.NONE;

    public Matrix(String name) { this.name = name;}

    public String getName() {
        return this.name;
    }

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
            allc = ELEMENTS_ALLC.NONE;
            retypeElements(ELEMENTS_TYPE.NONE);
        }
    }

    private void retypeElements(ELEMENTS_TYPE type) {
        this.type = type;
        if (type != ELEMENTS_TYPE.INT) elementsInt = null;
        if (type != ELEMENTS_TYPE.LONG) elementsLong = null;
        if (type != ELEMENTS_TYPE.DOUBLE) elementsDouble = null;
    }

    public void setElementsType(ELEMENTS_TYPE type) {
        if (allc == ELEMENTS_ALLC.DONE) {
            if (this.type == ELEMENTS_TYPE.INT && type == ELEMENTS_TYPE.LONG) {
                elementsLong = new long[height * width];
                for (int i = 0; i < elementsInt.length; i++) elementsLong[i] = elementsInt[i];
                retypeElements(type);
            } else {
                if (this.type == ELEMENTS_TYPE.INT && type == ELEMENTS_TYPE.DOUBLE) {
                    elementsDouble = new double[height * width];
                    for (int i = 0; i < elementsInt.length; i++) elementsDouble[i] = elementsInt[i];
                    retypeElements(type);
                } else {
                    if (this.type == ELEMENTS_TYPE.LONG && type == ELEMENTS_TYPE.DOUBLE) {
                        elementsDouble = new double[height * width];
                        for (int i = 0; i < elementsLong.length; i++) elementsDouble[i] = elementsLong[i];
                        retypeElements(type);
                    }
                }
            }
        } else {
            retypeElements(type);
        }
    }

    public ELEMENTS_TYPE getElementsType() {
        return type;
    }

    public void setElementsInt(int[] elementsInt) {
        if (elementsInt.length == height * width) {
            this.elementsInt = elementsInt;
            allc = ELEMENTS_ALLC.DONE;
            retypeElements(ELEMENTS_TYPE.INT);
        } else {
            throw new IndexOutOfBoundsException("Number of elements not match '" + name + "' matrix's dimension");
        }
    }

    public void setElementInt(int rowIndex, int columnIndex, int elementValueInt) {
        if (type == ELEMENTS_TYPE.NONE || type == ELEMENTS_TYPE.INT) {
            if (rowIndex >= 0 && rowIndex < height && columnIndex >= 0 && columnIndex < width) {
                if (allc == ELEMENTS_ALLC.NONE) {
                    elementsInt = new int[this.height * this.width];
                    allc = ELEMENTS_ALLC.DONE;
                }
                elementsInt[rowIndex * width + columnIndex] = elementValueInt;
                retypeElements(ELEMENTS_TYPE.INT);
            } else {
                throw new IndexOutOfBoundsException("Number of elements not match '" + name + "' matrix's dimension");
            }
        } else {
            throw new UnsupportedOperationException("There are no integer type elements in matrix '" + name + "'");
        }
    }

    public int getElementInt(int rowIndex, int columnIndex) {
        if (type == ELEMENTS_TYPE.INT) {
            if (rowIndex >= 0 && rowIndex < height && columnIndex >= 0 && columnIndex < width) {
                return this.elementsInt[rowIndex * width + columnIndex];
            } else {
                throw new IndexOutOfBoundsException("Out of '" + name + "' matrix's range");
            }
        } else {
            throw new UnsupportedOperationException("There are no integer type elements in matrix '" + name + "'");
        }
    }

    public void setElementsLong(long[] elementsLong) {
        if (elementsLong.length == height * width) {
            this.elementsLong = elementsLong;
            allc = ELEMENTS_ALLC.DONE;
            retypeElements(ELEMENTS_TYPE.LONG);
        } else {
            throw new IndexOutOfBoundsException("Number of elements not match '" + name + "' matrix's dimension");
        }
    }

    public void setElementLong(int rowIndex, int columnIndex, long elementValueLong) {
        if (type == ELEMENTS_TYPE.NONE || type == ELEMENTS_TYPE.LONG) {
            if (rowIndex >= 0 && rowIndex < height && columnIndex >= 0 && columnIndex < width) {
                if (allc == ELEMENTS_ALLC.NONE) {
                    elementsLong = new long[height * width];
                    allc = ELEMENTS_ALLC.DONE;
                }
                elementsLong[rowIndex * width + columnIndex] = elementValueLong;
                retypeElements(ELEMENTS_TYPE.LONG);
            } else {
                throw new IndexOutOfBoundsException("Number of elements not match '" + name + "' matrix's dimension");
            }
        } else {
            throw new UnsupportedOperationException("There are no long type elements in matrix '" + name + "'");
        }
    }

    public Long getElementLong(int rowIndex, int columnIndex) {
        if (type == ELEMENTS_TYPE.LONG) {
            if (rowIndex >= 0 && rowIndex < height && columnIndex >= 0 && columnIndex < width) {
                return this.elementsLong[rowIndex * width + columnIndex];
            } else {
                throw new IndexOutOfBoundsException("Out of '" + name + "' matrix's range");
            }
        } else {
            throw new UnsupportedOperationException("There are no long type elements in matrix '" + name + "'");
        }
    }

    public void setElementsDouble(double[] elementsDouble) {
        if (elementsDouble.length == height * width) {
            this.elementsDouble = elementsDouble;
            allc = ELEMENTS_ALLC.DONE;
            retypeElements(ELEMENTS_TYPE.DOUBLE);
        } else {
            throw new IndexOutOfBoundsException("Number of elements not match '" + name + "' matrix's dimension");
        }
    }

    public void setElementDouble(int rowIndex, int columnIndex, double elementValueDouble) {
        if (type == ELEMENTS_TYPE.NONE || type == ELEMENTS_TYPE.DOUBLE) {
            if (rowIndex >= 0 && rowIndex < height && columnIndex >= 0 && columnIndex < width) {
                if (allc == ELEMENTS_ALLC.NONE) {
                    elementsDouble = new double[height * width];
                    allc = ELEMENTS_ALLC.DONE;
                }
                elementsDouble[rowIndex * width + columnIndex] = elementValueDouble;
                retypeElements(ELEMENTS_TYPE.DOUBLE);
            } else {
                throw new IndexOutOfBoundsException("Number of elements not match '" + name + "' matrix's dimension");
            }
        } else {
            throw new UnsupportedOperationException("There are no double type elements in matrix '" + name + "'");
        }
    }

    public double getElementDouble(int rowIndex, int columnIndex) {
        if (type == ELEMENTS_TYPE.DOUBLE) {
            if (rowIndex >= 0 && rowIndex < height && columnIndex >= 0 && columnIndex < width) {
                return this.elementsDouble[rowIndex * width + columnIndex];
            } else {
                throw new IndexOutOfBoundsException("Out of '" + name + "' matrix's range");
            }
        } else {
            throw new UnsupportedOperationException("There are no double type elements in matrix '" + name + "'");
        }
    }

    @Override
    public String toString() {
        String o;
        o = "Matrix '" + name + "' (" + type + "):\n";
        if (allc == ELEMENTS_ALLC.NONE) {
            for (int j = 0; j < height; j++) {
                for (int i = 0; i < width; i++) {
                    o += "0\t";
                }
                o += "\n";
            }
        } else {
            switch (type) {
                case INT:
                    for (int j = 0; j < height; j++) {
                        for (int i = 0; i < width; i++) {
                            o += elementsInt[j * width + i] + "\t";
                        }
                        o += "\n";
                    }
                    break;
                case LONG:
                    for (int j = 0; j < height; j++) {
                        for (int i = 0; i < width; i++) {
                            o += elementsLong[j * width + i] + "\t";
                        }
                        o += "\n";
                    }
                    break;
                case DOUBLE:
                    for (int j = 0; j < height; j++) {
                        for (int i = 0; i < width; i++) {
                            o += elementsDouble[j * width + i] + "\t";
                        }
                        o += "\n";
                    }
                    break;
            }
        }
        return o;
    }
}