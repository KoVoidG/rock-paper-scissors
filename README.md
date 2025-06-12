# Rock Paper Scissors Game

This is a classic Rock Paper Scissors game brought to life with a graphical user interface (GUI) in Java Swing. It's built following the **Model-View-Controller (MVC)** architectural pattern, showcasing a clear separation of concerns for robust and maintainable code.

## Features

- **Player vs. Computer**: Challenge a simple AI opponent in rounds of Rock, Paper, Scissors.
- **Customizable Rounds**: Decide how many rounds you want to play per game.
- **Personalized Player Name**: Enter your name for a custom game experience; if you leave it blank, you'll be "Player1."
- **Score Tracking**: Keep an eye on your wins, losses, and ties throughout the game.
- **Intuitive Visuals**: Clear images represent choices, and dynamic text updates show round results and overall scores.
- **Seamless Replay**: Easily jump back into another game after one concludes.
- **MVC Architecture**: Designed for clarity and scalability, making it easy to understand, maintain, and expand.

## Project Structure
The project is neatly organized into standard MVC components, making it straightforward to navigate and understand each part's role: 

``` 
YourProjectFolder/

├── App.java 
├── model/ 
│   └── RPSGameModel.java
├── view/ 
│   ├── RPSView.java
│   ├── SetupPanel.java
│   ├── GamePanel.java
│   └── EndPanel.java
├── controller/
│   └── RPSController.java
├── utils/ 
│   └── ImageUtils.java
└── images/ 
    ├── rock.jpg
    ├── paper.jpg
    ├── scissors.jpg
    └── default.jpg
```
## Technology used

- **Java 8+**
- **Java Swing** for the GUI
- **Model-View-Controller (MVC) Architectural Pattern**

## How to Run

1. Clone the repository or download the source files.
2. Compile the main file:

```bash
javac App.java
```
3.Run the game:
```
java App
```
## 🤝 Contributing
Feel free to fork this repository, explore the code, and suggest improvements or new features!

## Author
***Hein Pyae Sone Htet***
