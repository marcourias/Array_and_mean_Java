# Array_and_mean_Java

This program  reads the number of students of a class, the height of the students and saves them to a Double ArrayList.
Next, the program calculates the mean height of the class, compares each student's height to the mean, and how many students have
a higher and lower height compared to the mean.

## 1. Method cls
For cleaning the sreen when called.

## 2. Method continuar
Stops the program until an ENTER is captured.

## 3. Method numeroAlumnos
Reads the number of students.

## 4. Method leerAlturas
Reads the height of students using a _for loop_ and _scanner_. To avoid errors while entering data that is not a number, _try-catch_ is used.

## 5. Method calcularMedias
Uses a _for loop_ to add all the heights, and then returns the result of dividing that sum by the number of elements in the arraylist (using .size())


## 6. Method mostrarResultados
This method uses a for loop to print the elements in the array (we use another array for the headers),  then it prints the elements in _ArrayList_, also we add another column using the _if_ statement, which compares the height to the mean, and prints "higher","lower", "same" depending on the result of that comparisson. In the same if statement we use a variable _int_ that sums 1 each time a number is higher, lower or same to them. Finally, we print said variable (there are 3 variables of this kind sup, inf or mid) and explain how many students are higher, lower or same to the _mean_.
