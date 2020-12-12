package ru.nsu.g.beryanov.book_library.gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ru.nsu.g.beryanov.book_library.gui.component.GraphDrawer;
import ru.nsu.g.beryanov.book_library.service.BookReadService;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

@Controller
public class GraphicPanelController {
    @Autowired
    @Qualifier(value = "currentMonthReadGraphPanel")
    private JPanel currentMonthReadGraphPanel;

    @Autowired
    @Qualifier(value = "graphicPanel")
    private JPanel graphicPanel;

    @Autowired
    private BookReadService bookReadService;

    public void updateGraphicPanel() {
        int n = 12;
        int val = 160;
        int x[] = {10, 35, 60, 83, 106, 129, 153, 177, 200, 223, 246, 270};
        int y[] = new int[n];

        Calendar everyMonth = Calendar.getInstance();
        everyMonth.set(Calendar.HOUR_OF_DAY, 0);
        everyMonth.set(Calendar.MINUTE, 0);
        everyMonth.set(Calendar.SECOND, 0);

        for (int i = 0; i < n; i++) {
            everyMonth.set(Calendar.MONTH, i);
            int amount = bookReadService.findAllInCurrentMonth(2020, i + 1).size();
            y[i] = val - amount * 10;
        }

        currentMonthReadGraphPanel.removeAll();
        currentMonthReadGraphPanel.repaint();
        currentMonthReadGraphPanel.revalidate();

        graphicPanel = new GraphDrawer(x, y, n);
        graphicPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        graphicPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentMonthReadGraphPanel.add(graphicPanel);

        Font font = new Font(new JLabel("").getFont().getName(), Font.PLAIN, 9);
        JLabel months = new JLabel("Янв  Фев  Мар  Апр  Май  Июн  Июл  Авг  Сен  Окт  Ноя  Дек");
        months.setFont(font.deriveFont(font.getStyle()));

        currentMonthReadGraphPanel.add(months);
    }
}
