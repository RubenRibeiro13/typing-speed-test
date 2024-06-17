# Typing Speed Test (GUI)
A Java-based Typing Speed Test application that measures typing speed and accuracy. Users are presented with random prompts to type, and their performance is tracked and displayed after the test period.

## Features
- Randomized typing prompts.
- Timer that counts down from 60 seconds.
- Measures words per minute (WPM) and accuracy.
- Displays results at the end of the test.
- User-friendly GUI with adjustable component sizes for readability.

## Requirements
- Java Development Kit (JDK) 8 or higher.
- Swing library (included in JDK).

## Installation
1. Navigate to the project directory:
```
cd typing-speed-test
```

2. Clone the repository:
```
git clone https://github.com/yourusername/typing-speed-test.git
```

3. Compile the Java source file:
```
javac TypingSpeedTest.java
```

4. Run the application:
```
java TypingSpeedTest
```

## Usage
1. Begin the test:
- Click the "Start" button to begin the test. A random prompt will appear at the top of the window.

2. Type the prompt:
- Type the displayed prompt in the text field below it. Press Enter to submit your input and receive the next prompt.

3. Track your performance:
- The timer at the bottom left will count down from 60 seconds.
- The WPM (words per minute) and accuracy will be displayed after the time runs out.

4. Restart the test:
- Click the "Start" button again to restart the test.

## Customization
### Changing Prompts
To add or modify prompts, edit the prompts array in the TypingSpeedTest.java file:
```
private String[] prompts = {
    "The quick brown fox jumps over the lazy dog.",
    "A journey of a thousand miles begins with a single step.",
    // Add more prompts here
};
```

### Adjusting Font
To change the font for all components, modify the font size in the TypingSpeedTest constructor:
```
Font font = new Font("Verdana", Font.PLAIN, 18);
```

### Adjusting Component Sizes
To adjust the sizes of specific components, modify the preferred sizes in the constructor:
```
setSize(500, 300); // Window
promptLabel.setPreferredSize(new Dimension(480, 60)); // Prompt label
textField.setPreferredSize(new Dimension(480, 60)); // Text field
bottomCenteredPanel.setPreferredSize(new Dimension(480, 60)); // Panel with timer, results label, and start button
```