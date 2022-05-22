import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Quadrilaterals implements Serializable {
    ArrayList<Quadrilateral> quadrilaterals = new ArrayList<Quadrilateral>();

    public Quadrilaterals() {
    }

    /**
     * Добавить прямоугольник по координатам в список прямоугольников
     */
    public void add(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        quadrilaterals.add(new Quadrilateral(
                new Quadrilateral.Point(x1, y1),
                new Quadrilateral.Point(x2, y2),
                new Quadrilateral.Point(x3, y3),
                new Quadrilateral.Point(x4, y4))
        );
    }

    /**
     * Отредактировать прямоугольник по индексу, задав новые координаты
     * @param index индекс редактируемого прямоугольника
     * @throws IllegalArgumentException прямоугольник по заданному индексу не найден
     */
    public void edit(int index, double x1, double y1, double x2, double y2,
                     double x3, double y3, double x4, double y4) throws IllegalArgumentException {
        try {
            Quadrilateral quadrilateral = quadrilaterals.get(index);
            quadrilateral.setFirst(new Quadrilateral.Point(x1, y1));
            quadrilateral.setSecond(new Quadrilateral.Point(x2, y2));
            quadrilateral.setThird(new Quadrilateral.Point(x3, y3));
            quadrilateral.setFourth(new Quadrilateral.Point(x4, y4));
        } catch(Exception e) {
            throw new IllegalArgumentException("Прямоугольника по заданному индексу не существует");
        }
    }

    /**
     * Получить объект прямоугольника по индексу
     * @param index запрашиваемый индекс
     * @return объект прямоугольника
     * @throws IllegalArgumentException прямоугольника по заданному индексу не существует
     */
    public Quadrilateral get(int index) throws IllegalArgumentException {
        try {
            Quadrilateral quadrilateral = quadrilaterals.get(index);
            return quadrilateral;
        } catch(Exception e) {
            throw new IllegalArgumentException("Прямоугольника по заданному индексу не существует");
        }
    }

    /**
     * Распечатать все прямоугольники в списке
     */
    public void printAll() {
        System.out.println("Прямоугольники: ");
        for (Quadrilateral quadrilateral : quadrilaterals) {
            System.out.println(quadrilateral);
        }
    }

    /**
     * Убрать прямоугольник по индексу из списка
     * @param index индекс прямоугольника
     * @throws IllegalArgumentException прямоугольника по заданному индексу не существует
     */
    public void remove(int index) throws IllegalArgumentException {
        try {
            quadrilaterals.remove(index);
        } catch(Exception e) {
            throw new IllegalArgumentException("Прямоугольника по заданному индексу не существует");
        }
    }

    /**
     * Вывод наименьшего и наибольшего прямоугольника
     */
    public void printExtremest() {
        Collections.sort(quadrilaterals);
        System.out.println("Наименьший прямоугольник: ");
        System.out.println(quadrilaterals.get(0));
        System.out.println("Наибольший прямоугольник: ");
        System.out.println(quadrilaterals.get(quadrilaterals.size() - 1));
    }

}
