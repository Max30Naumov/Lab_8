import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Squares implements Serializable {
    ArrayList<Square> squares = new ArrayList<Square>();

    public Squares() {
    }

    /**
     * Добавить новый квадрат по координатам в список
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @param x4
     * @param y4
     */
    public void add(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        squares.add(new Square(
                new Quadrilateral.Point(x1, y1),
                new Quadrilateral.Point(x2, y2),
                new Quadrilateral.Point(x3, y3),
                new Quadrilateral.Point(x4, y4))
        );
    }

    /**
     * Вывести одинаковые квадраты
     */
    public void printSame() {
        // Создаем хешсеты (куда можно добавить объект только один раз)
        HashSet<Double> areas = new HashSet<>(); // Для проверки площадей на уникальность (если уникально -- значит квадраты не совпадают)
        HashSet<Square> duplicates = new HashSet<>(); // Хешсет для хранения дубликатов
        // Проходимся по всем квадратам
        for(Square s: squares)
            // Если не можем добавить площадь (уже есть, нашли дубликат) -- добавляем квадрат в хешсет дубликатов
            if(!areas.add(s.calculateArea())) duplicates.add(s);

        System.out.println("Одинаковые квадраты: " + duplicates);

    }
}
