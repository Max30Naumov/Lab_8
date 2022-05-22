import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Object> data = new ArrayList<Object>();
        Quadrilaterals quadrilaterals = new Quadrilaterals();
        Squares squares = new Squares();

        data = Serialize.Load();
        quadrilaterals = (Quadrilaterals) data.get(0);
        squares = (Squares) data.get(1);

        quadrilaterals.add(5,6,3,2,7,4,6,7);
        quadrilaterals.add(3,5,1,5,7,3,5,3);
        quadrilaterals.add(7,3,1,4,2,4,5,6);
        quadrilaterals.add(3,1,4,3,8,3,3,5);
        quadrilaterals.printExtremest();

        squares.add(-2,2,2,2,2,-2,-2,-2);
        squares.add(-2,2,2,2,2,-2,-2,-2);
        squares.add(1,3,3,3,3,1,1,1);
        squares.printSame();

        // Демонстрация работы новых методов
        // Выводим прямоугольник с индексом 1
        System.out.println(quadrilaterals.get(1));
        // Задаем ему новые координаты
        quadrilaterals.edit(1, 5, 7, 5, 7, 2, 6, 7, 2);
        // Выводим его заново
        System.out.println(quadrilaterals.get(1));
        // Выводим все прямоугольники
        quadrilaterals.printAll();
        // Убираем прямоугольник с индексом 3
        quadrilaterals.remove(3);

        data = new ArrayList<Object>();
        data.add(quadrilaterals);
        data.add(squares);

        Serialize.Save(data);

    }
}
