# Simple Flashcards
## About project
Simple Flashcards is a console application that allows you to train your Italian vocabulary by creating flashcards and solving exercises.
## Program details
### Simple DB
Application keeps flashcards in lists so its content resets everytime application is restarted. There are two lists. The first one is training flashcards list, which keeps newly added flashcards by default. Training Flashcards may be used to create both exercise: puzzle and test. When user decides that they learned the flashcard, they can move it to second list, which is learned flashcards list. Flashcards from this list may be used to create test exercise.

### Possible Actions
Application allows you to perform following actions:
- adding flashcard,
- delete flashcard,
- move flashcard to another list,
- make puzzle exercise,
- make test exercise,
- get statistics,
- turn off program

### Exercise types
- Puzzle exercise
  
This exercise is used to train flashcards. It is choosing five (or less if the user adds to little flashcards) random flashcards from training flashcards list and mixes their translations. User has to connect Italian words with its English translation by entering number and letter of rows (eg. 1c,3b).
- Test exercise
  
This exercise is used to test your skills. It is choosing ten (or less if the user adds to little flashcards) random flashcards from learned flashcards list and user is given a English word and must write Italian translation.

### Statistics
In statistics user can check their progress. Users collects points that are converted into level. The points are allocated based on exercises.
Punctation:
- 30 percent is a 1 point,
- 50 percent is a 4 points,
- 80 percent is a 6 points,
- 100 percent is a 10 points
  
The level increases when the user collects 100 points. When level change points reset to zero.

## Screenshots

### Main menu

![Screenshot from 2024-01-18 15-09-22](https://github.com/KlaudiaGnilka/SimpleFlashcards/assets/134264753/c29b1214-bddc-42b9-a4a6-2ce8b5c421a9)

### Adding new flashcard

  ![Screenshot from 2024-01-18 15-10-34](https://github.com/KlaudiaGnilka/SimpleFlashcards/assets/134264753/67c2e8cf-c427-406a-b26b-ac4f3674f83e)

### Puzzle exercise
  
  ![Screenshot from 2024-01-18 15-13-16](https://github.com/KlaudiaGnilka/SimpleFlashcards/assets/134264753/b567c26a-400f-4883-b596-241016f135fd)

### Test exercise
  
![Screenshot from 2024-01-18 15-14-43](https://github.com/KlaudiaGnilka/SimpleFlashcards/assets/134264753/94f2da16-4ace-48e9-8f96-e7dc579b74ac)

### Statistics 

![Screenshot from 2024-01-18 15-15-13](https://github.com/KlaudiaGnilka/SimpleFlashcards/assets/134264753/0ff4e3d1-3c8f-4472-ac9d-1c73baa2dae3)





