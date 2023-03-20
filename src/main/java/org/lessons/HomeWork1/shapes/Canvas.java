package org.lessons.HomeWork1.shapes;

import java.util.LinkedList;
import java.util.List;

public class Canvas implements Drawing, Washing {
    private List<Shape> drawings;

    public Canvas() {
        this.drawings = new LinkedList<>();
    }

    @Override
    public void draw(Shape shape) {
        System.out.println("Рисую на доске " + shape.getName());
        drawings.add(shape);
    }

    @Override
    public void eraseShape(Shape shape) {
        drawings.remove(shape);
        System.out.printf("Стираю с доски фигуру: %s", shape.getName());
    }

    @Override
    public void eraseAll() {
        drawings.clear();
        System.out.println("Очищаю доску");
    }

    @Override
    public String toString() {
        StringBuilder shapes = new StringBuilder();
        drawings.forEach(shape -> shapes.append("\n").append(shape.getName()).append(";"));
        return drawings.size() > 0 ? String.format("На доске нарисованы: %s", shapes) : "Чистая доска";
    }
}
