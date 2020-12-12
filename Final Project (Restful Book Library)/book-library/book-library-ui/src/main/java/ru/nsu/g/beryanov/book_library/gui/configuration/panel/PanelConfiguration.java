package ru.nsu.g.beryanov.book_library.gui.configuration.panel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;

@Configuration
public class PanelConfiguration {
    @Autowired
    @Qualifier(value = "noBookSelected")
    private JLabel noBookSelected;

    @Autowired
    @Qualifier(value = "assessmentButtonsGroup")
    private ButtonGroup assessmentButtonsGroup;

    @Bean(name = "quotePanel")
    public JPanel quotePanel() {
        JPanel quotePanel = new JPanel();
        quotePanel.setBackground(Color.white);
        quotePanel.setLayout(new FlowLayout());
        quotePanel.setPreferredSize(new Dimension(405, 300));
        quotePanel.setBorder(BorderFactory.createTitledBorder("ЛЮБИМАЯ ЦИТАТА"));
        return quotePanel;
    }

    @Bean(name = "bookPanel")
    public JPanel bookPanel() {
        JPanel bookPanel = new JPanel();

        bookPanel.setBackground(Color.white);
        bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS));
        bookPanel.setPreferredSize(new Dimension(305, 690));
        bookPanel.setBorder(BorderFactory.createTitledBorder("СПИСОК КНИГ"));

//        bookListController.updateBookList();
        return bookPanel;
    }

    @Bean(name = "addBookPanel")
    public JPanel addBookPanel() {
        JPanel addBookPanel = new JPanel();
        addBookPanel.setBackground(Color.white);
        addBookPanel.setLayout(new BoxLayout(addBookPanel, BoxLayout.Y_AXIS));
        return addBookPanel;
    }

    @Bean(name = "selectedBookPanel")
    public JPanel selectedBookPanel() {
        JPanel selectedBookPanel = new JPanel();
        selectedBookPanel.setBackground(Color.white);
        selectedBookPanel.setLayout(new BoxLayout(selectedBookPanel, BoxLayout.Y_AXIS));
        selectedBookPanel.setPreferredSize(new Dimension(405, 690));
        selectedBookPanel.setBorder(BorderFactory.createTitledBorder("ВЫБРАННАЯ КНИГА"));
        selectedBookPanel.add(Box.createRigidArea(new Dimension(0, 300)));
        selectedBookPanel.add(noBookSelected);
        return selectedBookPanel;
    }

    @Bean(name = "myBookSectionPanel")
    public JPanel myBookSectionPanel() {
        JPanel myBookSectionPanel = new JPanel();
        myBookSectionPanel.setBackground(Color.white);
        myBookSectionPanel.setLayout(new FlowLayout());
        myBookSectionPanel.setPreferredSize(new Dimension(375, 690));
        myBookSectionPanel.setBorder(BorderFactory.createTitledBorder("МОЯ ПОЛКА"));

        myBookSectionPanel.add(bookReadingPanel());
        myBookSectionPanel.add(bookToReadPanel());
        myBookSectionPanel.add(bookReadPanel());
        return myBookSectionPanel;
    }

    @Bean(name = "bookReadingPanel")
    public JPanel bookReadingPanel() {
        JPanel bookReadingPanel = new JPanel();
        bookReadingPanel.setBackground(Color.white);
        bookReadingPanel.setLayout(new BoxLayout(bookReadingPanel, BoxLayout.Y_AXIS));
        bookReadingPanel.setPreferredSize(new Dimension(365, 217));
        bookReadingPanel.setBorder(BorderFactory.createTitledBorder("ЧИТАЮ"));
        return bookReadingPanel;
    }

    @Bean(name = "bookReadPanel")
    public JPanel bookReadPanel() {
        JPanel bookReadPanel = new JPanel();
        bookReadPanel.setBackground(Color.white);
        bookReadPanel.setLayout(new BoxLayout(bookReadPanel, BoxLayout.Y_AXIS));
        bookReadPanel.setPreferredSize(new Dimension(365, 217));
        bookReadPanel.setBorder(BorderFactory.createTitledBorder("ПРОЧИТАЛ"));
        return bookReadPanel;
    }

    @Bean(name = "bookToReadPanel")
    public JPanel bookToReadPanel() {
        JPanel bookToReadPanel = new JPanel();
        bookToReadPanel.setBackground(Color.white);
        bookToReadPanel.setLayout(new BoxLayout(bookToReadPanel, BoxLayout.Y_AXIS));
        bookToReadPanel.setPreferredSize(new Dimension(365, 217));
        bookToReadPanel.setBorder(BorderFactory.createTitledBorder("ХОЧУ ПРОЧИТАТЬ"));
        return bookToReadPanel;
    }

    @Bean(name = "buttonsReadPanel")
    public JPanel buttonsReadPanel() {
        JPanel buttonsReadPanel = new JPanel();
        buttonsReadPanel.setBackground(Color.white);
        buttonsReadPanel.setLayout(new BoxLayout(buttonsReadPanel, BoxLayout.X_AXIS));
        return buttonsReadPanel;
    }

    @Bean(name = "favouritesPanel")
    public JPanel favouritesPanel() {
        JPanel favouritesPanel = new JPanel();
        favouritesPanel.setBackground(Color.white);
        favouritesPanel.setLayout(new BoxLayout(favouritesPanel, BoxLayout.Y_AXIS));
        favouritesPanel.setPreferredSize(new Dimension(295, 216));
        favouritesPanel.setBorder(BorderFactory.createTitledBorder("ИЗБРАННОЕ"));
        return favouritesPanel;
    }

    @Bean(name = "currentMonthReadPanel")
    public JPanel currentMonthReadPanel() {
        JPanel currentMonthReadPanel = new JPanel();
        currentMonthReadPanel.setBackground(Color.white);
        currentMonthReadPanel.setLayout(new BoxLayout(currentMonthReadPanel, BoxLayout.Y_AXIS));
        currentMonthReadPanel.setPreferredSize(new Dimension(295, 216));
        currentMonthReadPanel.setBorder(BorderFactory.createTitledBorder("ПРОЧИТАЛ В ЭТОМ МЕСЯЦЕ"));
        return currentMonthReadPanel;
    }

    @Bean(name = "currentMonthReadGraphPanel")
    public JPanel currentMonthReadGraphPanel() {
        JPanel currentMonthReadGraphPanel = new JPanel();
        currentMonthReadGraphPanel.setBackground(Color.white);
        currentMonthReadGraphPanel.setLayout(new BoxLayout(currentMonthReadGraphPanel, BoxLayout.Y_AXIS));
        currentMonthReadGraphPanel.setPreferredSize(new Dimension(295, 218));
        currentMonthReadGraphPanel.setBorder(BorderFactory.createTitledBorder("ГРАФИК ПРОЧИТАННОГО ЗА ГОД"));
        return currentMonthReadGraphPanel;
    }

    @Bean(name = "myStatsPanel")
    public JPanel myStatsPanel() {
        JPanel myStatsPanel = new JPanel();
        myStatsPanel.setBackground(Color.white);
        myStatsPanel.setLayout(new FlowLayout());
        myStatsPanel.setPreferredSize(new Dimension(305, 690));
        myStatsPanel.setBorder(BorderFactory.createTitledBorder("МОЯ СТАТИСТИКА"));

        myStatsPanel.add(favouritesPanel());
        myStatsPanel.add(currentMonthReadPanel());
        myStatsPanel.add(currentMonthReadGraphPanel());
        return myStatsPanel;
    }

    @Bean(name = "kangarooLibraryFrame")
    public JFrame kangarooLibraryFrame() {
        JFrame kangarooLibraryFrame = new JFrame("Книжная библиотека");

        kangarooLibraryFrame.getContentPane().setBackground(Color.white);
        kangarooLibraryFrame.setLayout(new FlowLayout());
        kangarooLibraryFrame.setSize(1415, 723);
        kangarooLibraryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        kangarooLibraryFrame.add(bookPanel());
        kangarooLibraryFrame.add(selectedBookPanel());
        kangarooLibraryFrame.add(myBookSectionPanel());
        kangarooLibraryFrame.add(myStatsPanel());

        kangarooLibraryFrame.setLocationRelativeTo(null);
        kangarooLibraryFrame.setVisible(true);
        kangarooLibraryFrame.setResizable(false);

        return kangarooLibraryFrame;
    }

    @Bean(name = "authorCheckBoxesPanel")
    public JPanel authorCheckBoxesPanel() {
        JPanel authorCheckBoxesPanel = new JPanel();
        authorCheckBoxesPanel.setBackground(Color.white);
        authorCheckBoxesPanel.setLayout(new BoxLayout(authorCheckBoxesPanel, BoxLayout.Y_AXIS));
        return authorCheckBoxesPanel;
    }

    @Bean(name = "genreCheckBoxesPanel")
    public JPanel genreCheckBoxesPanel() {
        JPanel genreCheckBoxesPanel = new JPanel();
        genreCheckBoxesPanel.setBackground(Color.white);
        genreCheckBoxesPanel.setLayout(new BoxLayout(genreCheckBoxesPanel, BoxLayout.Y_AXIS));
        return genreCheckBoxesPanel;
    }

    @Bean(name = "assessmentCheckBoxesPanel")
    public JPanel assessmentCheckBoxesPanel() {
        JPanel assessmentCheckBoxesPanel = new JPanel();
        assessmentCheckBoxesPanel.setBackground(Color.white);
        assessmentCheckBoxesPanel.setLayout(new BoxLayout(assessmentCheckBoxesPanel, BoxLayout.Y_AXIS));
        return assessmentCheckBoxesPanel;
    }

    @Bean(name = "graphicPanel")
    public JPanel graphicPanel() {
        JPanel graphicPanel = new JPanel();
        graphicPanel.setBackground(Color.white);
        graphicPanel.setLayout(new FlowLayout());
        return graphicPanel;
    }

    @Bean(name = "assessmentButtons")
    public JPanel assessmentButtons() {
        JPanel assessmentButtons = new JPanel();

        assessmentButtons.add(new JLabel("Ваша оценка: "));
        assessmentButtons.setBackground(Color.white);
        assessmentButtons.setLayout(new BoxLayout(assessmentButtons, BoxLayout.X_AXIS));

        JRadioButton assessmentZero = new JRadioButton("0", false);
        assessmentButtons.add(assessmentZero);
        assessmentButtonsGroup.add(assessmentZero);

        JRadioButton assessmentOne = new JRadioButton("1", false);
        assessmentButtons.add(assessmentOne);
        assessmentButtonsGroup.add(assessmentOne);

        JRadioButton assessmentTwo = new JRadioButton("2", false);
        assessmentButtons.add(assessmentTwo);
        assessmentButtonsGroup.add(assessmentTwo);

        JRadioButton assessmentThree = new JRadioButton("3", false);
        assessmentButtons.add(assessmentThree);
        assessmentButtonsGroup.add(assessmentThree);

        JRadioButton assessmentFour = new JRadioButton("4", false);
        assessmentButtons.add(assessmentFour);
        assessmentButtonsGroup.add(assessmentFour);

        JRadioButton assessmentFive = new JRadioButton("5", false);
        assessmentButtons.add(assessmentFive);
        assessmentButtonsGroup.add(assessmentFive);

        return assessmentButtons;
    }
}
