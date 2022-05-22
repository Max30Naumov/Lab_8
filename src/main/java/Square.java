public class Square extends Quadrilateral {

    /**
     * Создать квадрат
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @throws IllegalArgumentException фигура по заданным точкам не является квадратом
     */
    public Square(Point p1, Point p2, Point p3, Point p4) throws IllegalArgumentException {
        super(p1, p2, p3, p4);
        if (!Quadrilateral.isSquare(p1, p2, p3, p4)) {
            throw new IllegalArgumentException("Фигура не является квадратом");
        }
    }

    @Override
    public String toString() {
        return "Square{} " + super.toString();
    }
}
