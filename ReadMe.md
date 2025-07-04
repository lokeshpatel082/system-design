# Low-Level Design (LLD) Project

## Overview
This is a **Maven-based Java project** containing various **low-level design** implementations for real-world systems. Each system is encapsulated in its own module, allowing for easy understanding and maintainability. The designs follow **SOLID principles** and best practices of object-oriented programming.

## Project Structure
The project is organized in a modular fashion using Maven's multi-module architecture. Each module represents a specific design problem and contains all necessary classes and logic for that system.

### Current Modules

1. **Snake-Ladder Game**:

    - A simulation of an snake and ladder game.
   
2. Cache System
   - Cache implementation using LRU eviction policy.


2. **Task-Scheduler**:
    - Design a scheduling system to execute tasks at predefined intervals.
    - Implement task creation, execution, and cancellation mechanisms.
3. **Logger:**
    - Design a structured logging framework for an application.
    - Implement different log levels (INFO, DEBUG, ERROR, etc.).
    - Support log rotation and persistence (file-based or database).

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/lokeshpatel082/system-design.git
2. Run below command:
    ```bash
     mvn clean install
3. Run individual modules 
   ```bash
   You can navigate to each module's directory and run the main class for the respective system.

## Technologies Used
- Java
- Maven

## How to Contribute
- Feel free to fork the repository, add new low-level design systems, or improve existing ones.
- Fork the repo.
- Create a new branch for your module or improvement.
- Submit a pull request.