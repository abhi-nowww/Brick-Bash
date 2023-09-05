# Brick Breaker Java Game

Welcome to the Brick Breaker Java game! This README provides an overview of the code and explains key concepts used in the game's implementation.

## Table of Contents

1. [Introduction](#introduction)
2. [Gameplay](#gameplay)
3. [Game Controls](#game-controls)
4. [Code Overview](#code-overview)
5. [How to Run](#how-to-run)

## Introduction

Brick Breaker is a classic arcade game where the player controls a paddle and tries to bounce a ball to break bricks. The goal is to clear all the bricks on the screen while avoiding letting the ball fall below the paddle. The game keeps track of the player's score.

## Gameplay

The gameplay involves the following elements:

- **Paddle**: The green rectangular bar at the bottom of the screen controlled by the player to bounce the ball.
- **Ball**: A yellow ball that bounces around the screen and destroys bricks on contact.
- **Bricks**: Rows of white bricks that need to be destroyed by the ball. Each brick has a certain value.
- **Score**: The player's score, which increases as bricks are destroyed.

The game starts with the ball at the top of the screen, and the player can move the paddle left or right using keyboard input. The player's objective is to bounce the ball off the paddle to hit and destroy the bricks. The game continues until all the bricks are cleared, or the ball falls below the paddle.

## Game Controls

- **Left Arrow**: Move the paddle to the left.
- **Right Arrow**: Move the paddle to the right.
- **Enter**: Start the game or restart it after winning or losing.

## Code Overview

The Java code for the Brick Breaker game is organized into several classes:

1. **Gameplay.java**: This class extends `JPanel` and implements the game logic. It handles painting the game elements, detecting collisions, and updating the game state.

2. **Main.java**: The main class that creates an instance of `Gameplay` and sets up the game window using `JFrame`.

3. **MapGenerator.java**: A class that manages the game's brick layout. It creates and draws the bricks on the screen.

Key Concepts from the Code:

- **Graphics**: Graphics are used to draw elements like bricks, the paddle, and the ball on the screen. The `paint` method is responsible for rendering the game's visuals.

- **Timers**: A `Timer` is used to control the speed of the game loop and update the game elements at regular intervals.

- **Collision Detection**: Collision detection is implemented to check if the ball collides with the paddle or bricks, enabling the game to react accordingly.

- **Game State Management**: The code manages the game's state, including starting, winning, and losing conditions.

## How to Run

To run the Brick Breaker Java game:

1. Make sure you have Java installed on your system.

2. Compile the Java files:

   ```bash
   javac BrickGame/*.java
   
