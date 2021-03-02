import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

// Наследуется от основого класса кнопки, чтобы потом можно было добавить на панель
public class RoundButton extends JButton {
    private int diameter; // Диаметр кнопки

    public RoundButton(String label) {
        super(label); // Рисует надпись на кнопке

        // Устанавливают размер кнопки
        Dimension size = getPreferredSize();
        diameter = Math.max(size.width,size.height) - 7;
        setPreferredSize(new Dimension(diameter, diameter));

        setContentAreaFilled(false); // Убирает вот этот вот блеск ебаный, который в стандартной кнопке
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()){
            // Анимация нажатия кнопки
            g.setColor(Color.darkGray);
        }
        else if (getModel().isRollover()) {
            // Кнопка меняет цвет, когда в нее попадает курсор
            g.setColor(Color.lightGray);
        }
        else {
            g.setColor(Color.white);
        }

        // Рисование кнопки
        g.fillOval(getWidth()/2 - diameter / 2 , getHeight()/2 - diameter / 2, diameter, diameter);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        // Рисование границ кнопки
        g.setColor(Color.black);
        g.drawOval(getWidth()/2 - diameter / 2, getHeight()/2 - diameter / 2, diameter, diameter);
    }
}
