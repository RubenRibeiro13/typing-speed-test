import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TypingSpeedTest extends JFrame implements ActionListener {
    // Declare global variables

    private JLabel promptLabel, timerLabel, resultLabel;
    private JTextField textField;
    private Timer timer;
    private JButton startButton;
    private Random random;

    private int timeLeft;
    private int totalWordsTyped;
    private int totalCorrectChars;
    private int totalChars;
    
    private String currentPrompt;
    private String[] prompts = {
        "The quick brown fox jumps over the lazy dog.",
        "A journey of a thousand miles begins with a single step.",
        "To be or not to be, that is the question.",
        "All that glitters is not gold.",
        "She sells sea shells by the sea shore.",
        "Peter Piper picked a peck of pickled peppers.",
        "How much wood would a woodchuck chuck if a woodchuck could chuck wood?",
        "I scream, you scream, we all scream for ice cream.",
        "The five boxing wizards jump quickly.",
        "Pack my box with five dozen liquor jugs.",
        "Sphinx of black quartz, judge my vow.",
        "Jackdaws love my big sphinx of quartz.",
        "The lazy dog jumps quickly over the brown fox.",
        "Bright vixens jump; dozy fowl quack.",
        "Jinxed wizards pluck ivy from the big quilt.",
        "Crazy Fredrick bought many very exquisite opal jewels.",
        "We promptly judged antique ivory buckles for the next prize.",
        "My girl wove six dozen plaid jackets before she quit.",
        "Amazingly few discotheques provide jukeboxes.",
        "The jay, pig, fox, zebra, and my wolves quack!",
        "Blowzy red vixens fight for a quick jump.",
        "Jack quietly moved up front and seized the big ball of wax.",
        "Five quacking zephyrs jolt my wax bed.",
        "The public was amazed to view the quickness and dexterity of the juggler.",
        "The quick onyx goblin jumps over the lazy dwarf.",
        "Grumpy wizards make toxic brew for the evil queen and jack.",
        "Jim quickly realized that the beautiful gowns are expensive.",
        "A quivering Texas zombie fought republic linked jewelry.",
        "Just keep examining every low bid quoted for zinc etchings.",
        "Back in June we delivered oxygen equipment of the same size."
    };

    // Create, edit, and place the widgets

    public TypingSpeedTest() {
        setTitle("Typing Speed Test");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Font font = new Font("Verdana", Font.PLAIN, 18);

        JPanel promptPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(promptPanel, BorderLayout.NORTH);

        promptLabel = new JLabel("Click 'Start' to begin the test.");
        promptLabel.setFont(font);
        promptLabel.setPreferredSize(new Dimension(480, 60));
        promptPanel.add(promptLabel);

        JPanel textFieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(textFieldPanel, BorderLayout.CENTER);

        textField = new JTextField();
        textField.setFont(font);
        textField.setPreferredSize(new Dimension(480, 60));
        textField.setEnabled(false);
        textField.addActionListener(this);
        textFieldPanel.add(textField);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(bottomPanel, BorderLayout.SOUTH);

        JPanel bottomCenteredPanel = new JPanel(new BorderLayout());
        bottomCenteredPanel.setPreferredSize(new Dimension(480, 60));
        bottomPanel.add(bottomCenteredPanel);

        timerLabel = new JLabel("Time left: 60");
        timerLabel.setFont(font);
        bottomCenteredPanel.add(timerLabel, BorderLayout.WEST);

        resultLabel = new JLabel(" ", SwingConstants.CENTER);
        resultLabel.setFont(font);
        bottomCenteredPanel.add(resultLabel, BorderLayout.CENTER);

        startButton = new JButton("Start");
        startButton.setFont(font);
        startButton.addActionListener(e -> startTest());
        bottomCenteredPanel.add(startButton, BorderLayout.EAST);

        timer = new Timer(1000, e -> updateTimer());
        random = new Random();
    }

    // Start test

    private void startTest() {
        textField.setEnabled(true);
        textField.requestFocus();
        timerLabel.setText("Time left: 60");
        resultLabel.setText(" ");

        timeLeft = 60;
        totalWordsTyped = 0;
        totalCorrectChars = 0;
        totalChars = 0;

        timer.start();
        nextPrompt();
    }

    // Enter prompt

    @Override
    public void actionPerformed(ActionEvent e) {
        updateWordsChars();
        nextPrompt();
    }

    // Get next prompt

    private void nextPrompt() {
        currentPrompt = prompts[random.nextInt(prompts.length)];
        promptLabel.setText("<html>" + currentPrompt + "</html>");

        textField.setText("");
        textField.requestFocus();
    }

    // Update timer

    private void updateTimer() {
        timeLeft--;
        timerLabel.setText("Time left: " + timeLeft);

        if (timeLeft <= 0) {
            timer.stop();
            textField.setEnabled(false);
            calculateResults();
        }
    }

    // Calculate results

    private void calculateResults() {
        updateWordsChars();

        double accuracy = (double) totalCorrectChars / totalChars * 100;
        int wordsPerMinute = totalWordsTyped;

        resultLabel.setText(String.format("WPM: %d, Accuracy: %.0f%%", wordsPerMinute, accuracy));
    }

    // Update total words typed and total correct chars

    private void updateWordsChars() {
        String typedText = textField.getText();
        int correctChars = 0;

        for (int i = 0; i < Math.min(typedText.length(), currentPrompt.length()); i++) {
            if (typedText.charAt(i) == currentPrompt.charAt(i)) {
                correctChars++;
            }
        }

        totalCorrectChars += correctChars;
        totalChars += typedText.length();
        totalWordsTyped += typedText.split("\\s+").length;
    }

    // Start the GUI desktop app

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TypingSpeedTest app = new TypingSpeedTest();
            app.setVisible(true);
        });
    }
}