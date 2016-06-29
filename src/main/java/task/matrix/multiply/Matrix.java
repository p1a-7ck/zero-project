package task.matrix.multiply;

/**
 * Created by P1A-7CK on 28.06.2016.
 */
public class Matrix {
    public enum ELEMENTS_ALLC { NONE, DONE }
    public enum ELEMENTS_TYPE { NONE, INT, LONG, DOUBLE }

    private String name;
    private int[] elementsInt;
    private long[] elementsLong;
    private double[] elementsDouble;
    private int width = 0, height = 0;
    private ELEMENTS_ALLC allc = ELEMENTS_ALLC.NONE;
    private ELEMENTS_TYPE type = ELEMENTS_TYPE.NONE;

    public Matrix(String name) {
        this.name = name;
    }

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
            this.allc = ELEMENTS_ALLC.NONE;
            retypeElements(ELEMENTS_TYPE.NONE);
        }
    }

    private void retypeElements(ELEMENTS_TYPE type) {
        this.type = type;
        if (type != ELEMENTS_TYPE.INT) this.elementsInt = null;
        if (type != ELEMENTS_TYPE.LONG) this.elementsLong = null;
        if (type != ELEMENTS_TYPE.DOUBLE) this.elementsDouble = null;
    }

    public void setElementsType(ELEMENTS_TYPE type) {
        if (this.allc == ELEMENTS_ALLC.DONE) {
            if (this.type == ELEMENTS_TYPE.INT && type == ELEMENTS_TYPE.LONG) {
                elementsLong = new long[this.height * this.width];
                for (int i = 0; i < elementsInt.length; i++) elementsLong[i] = elementsInt[i];
                retypeElements(type);
            } else {
                if (this.type == ELEMENTS_TYPE.INT && type == ELEMENTS_TYPE.DOUBLE) {
                    elementsDouble = new double[this.height * this.width];
                    for (int i = 0; i < elementsInt.length; i++) elementsDouble[i] = elementsInt[i];
                    retypeElements(type);
                } else {
                    if (this.type == ELEMENTS_TYPE.LONG && type == ELEMENTS_TYPE.DOUBLE) {
                        elementsDouble = new double[this.height * this.width];
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
        return this.type;
    }

    public void setElementsInt(int[] elementsInt) {
        if (elementsInt.length == this.height * this.width) {
            this.elementsInt = elementsInt;
            this.allc = ELEMENTS_ALLC.DONE;
            retypeElements(ELEMENTS_TYPE.INT);
        } else {
            throw new IndexOutOfBoundsException("Number of elements not match '" + this.name + "' matrix's dimension");
        }
    }

    public void setElementInt(int rowIndex, int columnIndex, int elementValueInt) {
        if (this.type == ELEMENTS_TYPE.NONE || this.type == ELEMENTS_TYPE.INT) {
            if (rowIndex >= 0 && rowIndex < this.height && columnIndex >= 0 && columnIndex < this.width) {
                if (this.allc == ELEMENTS_ALLC.NONE) {
                    this.elementsInt = new int[this.height * this.width];
                    this.allc = ELEMENTS_ALLC.DONE;
                }
                this.elementsInt[rowIndex * this.width + columnIndex] = elementValueInt;
                retypeElements(ELEMENTS_TYPE.INT);
            } else {
                throw new IndexOutOfBoundsException("Number of elements not match '" + this.name + "' matrix's dimension");
            }
        } else {
            throw new UnsupportedOperationException("There are no integer type elements in matrix '" + this.name + "'");
        }
    }

    public int getElementInt(int rowIndex, int columnIndex) {
        if (this.type == ELEMENTS_TYPE.INT) {
            if (rowIndex >= 0 && rowIndex < this.height && columnIndex >= 0 && columnIndex < this.width) {
                return this.elementsInt[rowIndex * this.width + columnIndex];
            } else {
                throw new IndexOutOfBoundsException("Out of '" + this.name + "' matrix's range");
            }
        } else {
            throw new UnsupportedOperationException("There are no integer type elements in matrix '" + this.name + "'");
        }
    }

    public void setElementsLong(long[] elementsLong) {
        if (elementsLong.length == this.height * this.width) {
            this.elementsLong = elementsLong;
            this.allc = ELEMENTS_ALLC.DONE;
            retypeElements(ELEMENTS_TYPE.LONG);
        } else {
            throw new IndexOutOfBoundsException("Number of elements not match '" + this.name + "' matrix's dimension");
        }
    }

    public void setElementLong(int rowIndex, int columnIndex, long elementValueLong) {
        if (this.type == ELEMENTS_TYPE.NONE || this.type == ELEMENTS_TYPE.LONG) {
            if (rowIndex >= 0 && rowIndex < this.height && columnIndex >= 0 && columnIndex < this.width) {
                if (this.allc == ELEMENTS_ALLC.NONE) {
                    this.elementsLong = new long[this.height * this.width];
                    this.allc = ELEMENTS_ALLC.DONE;
                }
                this.elementsLong[rowIndex * this.width + columnIndex] = elementValueLong;
                retypeElements(ELEMENTS_TYPE.LONG);
            } else {
                throw new IndexOutOfBoundsException("Number of elements not match '" + this.name + "' matrix's dimension");
            }
        } else {
            throw new UnsupportedOperationException("There are no long type elements in matrix '" + this.name + "'");
        }
    }

    public Long getElementLong(int rowIndex, int columnIndex) {
        if (this.type == ELEMENTS_TYPE.LONG) {
            if (rowIndex >= 0 && rowIndex < this.height && columnIndex >= 0 && columnIndex < this.width) {
                return this.elementsLong[rowIndex * this.width + columnIndex];
            } else {
                throw new IndexOutOfBoundsException("Out of '" + this.name + "' matrix's range");
            }
        } else {
            throw new UnsupportedOperationException("There are no long type elements in matrix '" + this.name + "'");
        }
    }

    public void setElementsDouble(double[] elementsDouble) {
        if (elementsDouble.length == this.height * this.width) {
            this.elementsDouble = elementsDouble;
            this.allc = ELEMENTS_ALLC.DONE;
            retypeElements(ELEMENTS_TYPE.DOUBLE);
        } else {
            throw new IndexOutOfBoundsException("Number of elements not match '" + this.name + "' matrix's dimension");
        }
    }

    public void setElementDouble(int rowIndex, int columnIndex, double elementValueDouble) {
        if (this.type == ELEMENTS_TYPE.NONE || this.type == ELEMENTS_TYPE.DOUBLE) {
            if (rowIndex >= 0 && rowIndex < this.height && columnIndex >= 0 && columnIndex < this.width) {
                if (this.allc == ELEMENTS_ALLC.NONE) {
                    this.elementsDouble = new double[this.height * this.width];
                    this.allc = ELEMENTS_ALLC.DONE;
                }
                this.elementsDouble[rowIndex * this.width + columnIndex] = elementValueDouble;
                retypeElements(ELEMENTS_TYPE.DOUBLE);
            } else {
                throw new IndexOutOfBoundsException("Number of elements not match '" + this.name + "' matrix's dimension");
            }
        } else {
            throw new UnsupportedOperationException("There are no double type elements in matrix '" + this.name + "'");
        }
    }

    public double getElementDouble(int rowIndex, int columnIndex) {
        if (this.type == ELEMENTS_TYPE.DOUBLE) {
            if (rowIndex >= 0 && rowIndex < this.height && columnIndex >= 0 && columnIndex < this.width) {
                return this.elementsDouble[rowIndex * this.width + columnIndex];
            } else {
                throw new IndexOutOfBoundsException("Out of '" + this.name + "' matrix's range");
            }
        } else {
            System.out.println(this.type);
            throw new UnsupportedOperationException("There are no double type elements in matrix '" + this.name + "'");
        }
    }

    @Override
    public String toString() {
        String o;
        o = "Matrix '" + this.name + "' (" + this.type + "):\n";
        if (this.allc == ELEMENTS_ALLC.NONE) {
            for (int j = 0; j < this.height; j++) {
                for (int i = 0; i < this.width; i++) {
                    o += "0\t";
                }
                o += "\n";
            }
        } else {
            switch (this.type) {
                case INT:
                    for (int j = 0; j < this.height; j++) {
                        for (int i = 0; i < this.width; i++) {
                            o += this.elementsInt[j * this.width + i] + "\t";
                        }
                        o += "\n";
                    }
                    break;
                case LONG:
                    for (int j = 0; j < this.height; j++) {
                        for (int i = 0; i < this.width; i++) {
                            o += this.elementsLong[j * this.width + i] + "\t";
                        }
                        o += "\n";
                    }
                    break;
                case DOUBLE:
                    for (int j = 0; j < this.height; j++) {
                        for (int i = 0; i < this.width; i++) {
                            o += this.elementsDouble[j * this.width + i] + "\t";
                        }
                        o += "\n";
                    }
                    break;
            }
        }
        return o;
    }
}