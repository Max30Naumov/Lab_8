import java.io.Serializable;
import java.util.Objects;

public class Quadrilateral implements Comparable<Quadrilateral>, Serializable {

    static class Point implements Serializable {
        private double x, y;
        /**
         * Конструктор для создания точки
         */
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        public double getX() {
            return x;
        }
        public double getY() {
            return y;
        }
        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    /**
     * Подсчет расстояния между точками
     * @param p точка 1
     * @param q точка 2
     * @return расстояние между точками
     */
    public static double pointsDistance(Point p, Point q) {
        return Math.sqrt(Math.pow((p.getX() - q.getX()), 2) + Math.pow(p.getY() - q.getY(), 2));
    }

    /**
     * Подсчет квадрата расстояния между точками
     * @param p точка 1
     * @param q точка 2
     * @return квадрат расстояния между точками
     */
    public static double distSq(Point p, Point q)
    {
        return (p.getX() - q.getX()) * (p.getX() - q.getX()) + (p.getY() - q.getY()) * (p.getY() - q.getY());
    }

    /**
     * Построение прямоугольника по точкам
     * @param p1 точка 1
     * @param p2 точка 2
     * @param p3 точка 3
     * @param p4 точка 4
     */
    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) { // Конструктор класса
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    // Поля класса и гетеры
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    /**
     * Получение первой точки
     * @return первая точка
     */
    public Point getFirst() {
        return p1;
    }
    public Point getSecond() {
        return p2;
    }
    public Point getThird() {
        return p3;
    }
    public Point getFourth() {
        return p4;
    }
    /**
     * Задание первой точки
     */
    public void setFirst(Point p1) {
        this.p1 = p1;
    }
    public void setSecond(Point p2) {
        this.p2 = p2;
    }
    public void setThird(Point p3) {
        this.p3 = p3;
    }
    public void setFourth(Point p4) {
        this.p4 = p4;
    }

    /**
     * Проверка является ли четырехугольник квадратом
     * @param p1 точка 1
     * @param p2 точка 2
     * @param p3 точка 3
     * @param p4 точка 4
     * @return является ли прямоугольник квадратом
     */
    public static boolean isSquare(Point p1, Point p2, Point p3, Point p4) {
        // Находим квадраты расстояний между точками
        double d2 = distSq(p1, p2);
        double d3 = distSq(p1, p3);
        double d4 = distSq(p1, p4);

        if (d2 == 0 || d3 == 0 || d4 == 0)
            return false;
        // Попарно сверяем их
        if (d2 == d3 && 2 * d2 == d4 && 2 * distSq(p2, p4) == distSq(p2, p3))
            return true;
        if (d3 == d4 && 2 * d3 == d2 && 2 * distSq(p3, p2) == distSq(p3, p4))
            return true;
        if (d2 == d4 && 2 * d2 == d3 && 2 * distSq(p2, p3) == distSq(p2, p4))
            return true;
        // Если не совпало, возвращаем false
        return false;
    }

    /**
     * Вывод длин сторон прямоугольника
     */
    public void printSidesLengths() {
        System.out.println("Длина первой стороны: " + pointsDistance(p1, p2));
        System.out.println("Длина второй стороны: " + pointsDistance(p2, p3));
        System.out.println("Длина третьей стороны: " + pointsDistance(p3, p4));
        System.out.println("Длина четвертой стороны: " + pointsDistance(p1, p4));
    }

    /**
     * Вывод длин диагоналей прямоугольника
     */
    public void printDiagonalsLengths() {
        System.out.println("Длины диагоналей: " + pointsDistance(p1, p3) + ", " + pointsDistance(p2, p4));
    }

    /**
     * Подсчитать периметр прямоугольника
     * @return периметр прямоугольника
     */
    public double calculatePerimeter() {
        return pointsDistance(p1, p2) + pointsDistance(p2, p3) +
                pointsDistance(p3, p4) + pointsDistance(p1, p4);
    }

    /**
     * Вывод периметра прямоугольника
     */
    public void printPerimeter() { // Вывод периметра
        System.out.println("Периметр: " + calculatePerimeter());
    }

    /**
     * Подсчитать площадь прямоугольника
     * @return площадь прямоугольника
     */
    public double calculateArea() {
        // Формула шнурков для подсчета площади произвольного четырехугольника
        return 0.5 * Math.abs(p1.getX()*p2.getY() + p2.getX()*p3.getY() + p3.getX()*p4.getY() -
                (p1.getY()*p2.getX() + p2.getY()*p3.getX() + p3.getY()*p3.getX()));
    }

    /**
     * Вывести площадь прямоугольника
     */
    public void printArea() {
        System.out.println("Площадь: " + calculateArea());
    }

    // Согласно заданию переназначаем toString
    /**
     * Вывести все составляющие точки прямоугольника
     * @return
     */
    @Override
    public String toString() {
        return "Quadrilateral{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", p4=" + p4 +
                '}';
    }

    @Override
    /**
     * Критерий равенства прямоугольников -- если объекты равны
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null) {
            return false;
        }
        Quadrilateral obj = (Quadrilateral) o;
        return Objects.equals(obj.getFirst(), p1);
    }
    // Используем compareTo + наследование Comparable для возможности сортировки

    /**
     * Критерий сортировки прямоугольников -- по площади
     * @param o прямоугольник
     * @return различие в площади между текущим и переданным прямоугольником
     */
    @Override
    public int compareTo(Quadrilateral o) {
        return Double.compare(this.calculateArea(), o.calculateArea());
    }

}
