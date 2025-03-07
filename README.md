# Sustainopoly

## 🌍 Overview

Sustainopoly is a Java-based game inspired by Monopoly, designed to address sustainable development challenges in Govan. The project focuses on improving the Govan Built Environment and tackling refugee resettlement issues through an interactive game-based approach. Players navigate through different regions of Govan, making decisions that impact the community and environment.

## 🎯 Sustainable Development Goals

The game aims to address several UN Sustainable Development Goals:
- 1 No Poverty
- 2 Zero Hunger
- 3 Good Health and Well Being
- 4 Quality Education
- 8 Decent Work and Economic Growth
- 9 Industry, Innovation and Infrastructure
- 10 Reduced Inequalities
- 11 Sustainable Cities and Communities
- 12 Responsible Consumption and Production
- 17 Partnerships for the Goals

## 🎮 Game Features

- **Regional Gameplay**: Navigate through 6 distinct geographical regions of Govan:
  - Ibrox
  - Plantation
  - Cessnock
  - Kinning Park
  - Kingston
  - Tradeston

- **Dice-based Movement**: Roll two dice to determine your movement across the game board
  
- **Multiple Interaction Types**:
  - Make decisions that affect the community
  - Exchange character attributes/resources
  - Accept and complete tasks
  - Encounter random events

- **Character Attributes**: Players have multiple attributes:
  - Strength
  - Leadership
  - Experience
  - Money
  - Happiness

## 💻 Technical Implementation

### Architecture

The game follows an object-oriented approach with these key classes:

#### Core Game Classes
- **Player**: Manages player attributes, movement, and rendering
- **GamePanel**: Main game interface handling rendering and user interactions
- **GameObject**: Base class for game elements with position and graphical representation
- **Events**: Handles the various in-game events (start, fate, exchange, task)
- **Dice**: Implements dice rolling mechanics with animation

#### UI and Threading
- **PaintThread**: Manages continuous screen updates
- **IconThread**: Handles icon animations, particularly for dice rolling
- **GameUtil**: Utility functions for game resources and operations

#### Game Data Management
- **GameData**: Stores game resources, images and game state
- **StartGame**: Entry point for game initialization

### Code Structure

```
src/
├── main/
│   ├── java/
│   │   ├── Player.java         # Player class with attributes and rendering
│   │   ├── GamePanel.java      # Main game panel with UI components
│   │   ├── GameObject.java     # Base class for all game objects
│   │   ├── Events.java         # Event handling system
│   │   ├── Dice.java           # Dice rolling mechanics
│   │   ├── IconThread.java     # Thread for animating icons
│   │   ├── PaintThread.java    # Thread for screen rendering
│   │   ├── GameData.java       # Game resource management
│   │   ├── GameUtil.java       # Utility functions
│   │   └── StartGame.java      # Game entry point
│   │
│   └── resources/              # Game assets and resources
```

## 🚀 Core Game Functionality

### Player Movement
```java
// Example code for player movement
public void move(int steps) {
    // Calculate new position
    int newPosition = currentPosition + steps;
    
    // Handle board wrapping
    if (newPosition >= boardSize) {
        newPosition = newPosition % boardSize;
    }
    
    // Update player position
    currentPosition = newPosition;
    
    // Draw player at new position
    drawMyself();
}
```

### Dice Rolling
```java
// Example dice rolling code
public void actionPerformed(ActionEvent ae) {
    // Start the dice animation thread
    iconThread1.run();
    iconThread2.run();
    
    // Get random dice values
    dice1 = 1 + (int)(Math.random() * 6);
    dice2 = 1 + (int)(Math.random() * 6);
    
    // Calculate total and move player
    int total = dice1 + dice2;
    playResult(total);
}
```

### Event Handling
```java
// Example event handling code
public void events(Player p) {
    switch(eventType) {
        case START:
            start(p);
            break;
        case FATE:
            fate(p);
            break;
        case EXCHANGE:
            exchange(p);
            break;
        case TASK:
            task(p);
            break;
    }
}
```

## 🎲 Game Board Layout

The game board features various locations including:
- Churches
- Bus stations
- Villages
- Stores
- Shelters
- Schools
- Refugee camps
- Soccer fields
- Parks
- Community centers
- Quiz spots
- Fate spots

Each location offers different interactions and challenges related to sustainable development goals.

## 🛠️ Setup and Installation

1. Ensure you have Java JDK 8 or higher installed
2. Clone the repository
   ```
   git clone https://github.com/yourusername/sustainopoly.git
   ```
3. Navigate to the project directory
   ```
   cd sustainopoly
   ```
4. Compile the source code
   ```
   javac -d bin src/main/java/*.java
   ```
5. Run the game
   ```
   java -cp bin StartGame
   ```

## 🔮 Future Development Plans

- **Improved UI**: Players will be able to choose avatars and enter IDs
- **Enhanced Player Attributes**: More detailed attribute system
- **Beautified Interface**: Improved game aesthetics
- **Increased Gameplay Options**: More player autonomy
- **Story Enrichment**: Richer storylines with multiple endings
- **Multiple Game Modes**: Additional play modes including:
  - Story mode
  - Options mode
  - Quiz mode
- **Accessibility Features**:
  - Game help tutorial
  - Voice system with text-to-speech
  - Color blind mode
  - Multilingual support

## 👥 Contributors

- Hailin Weng (Team Leader): Game architecture, UML diagrams, programming, debugging
- Yueying Xie: Game architecture, UML diagrams, programming, Gantt charts, game layout
- Peilin Zou: Frame window creation, panel design, button implementation, threading
- Ziwen Xu: Game rules design, area design, player class coding, team minutes
- Yikai Wu: Dice-related functions, demo video recording
- Yong Yang: Map design, UML class diagram, region design, use case descriptions

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.
