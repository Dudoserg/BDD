Feature: gamesina
  in order to avoid failing "verification"
  As a programmer idiot
  decided to make game 2048]
#add
  Scenario:
    Given I have my Game class
    When I have entered 2 as first operand
    And I have entered 2 as second operand
    And I use 'add' method
    Then The result should be 4
#generateNumber
  Scenario:
    Given  I have my Game class
    When I use 'generateNumber' method
    Then The result  2 or 4
#generateNumber
  Scenario:
    Given  I have my Game class
    When I use 'generateNumber' method 100000 raz
    Then The result  2 or 4 with probability 90 and 10
#getSize
  Scenario:
    Given  I have my Game class with param 4
    When I get gameSize
    Then The gameSize should be 4
# initArray
  Scenario:
    Given  I have my Game class with param 4
    When I get array from Game
    Then The array should be null
#setElem #getElem
  Scenario:
    Given  I have my Game class with param 4
    When I set elem 4 with index 0 0
    And I get elem with index 0 0
    Then The result getElem should be 4
#findFreePlace
  Scenario:
    Given  I have my Game class with param 4
    When I set elem 4 with index 0 0
    And I call 'findFreePlace' method 100000 times
    Then The result must not contain an element with index 0 0
#findFreePlace2
  Scenario:
    Given  I have my Game class with param 4
    When I have initialized all the elements of the matrix except the element with the index 2 2
    And I call 'findFreePlace' method 100000 times
    Then The result should always return an item with index 2 2
#rand
  Scenario:
    Given  I have my Game class with param 4
    When I call 'rand' method 1000000 times in the range from 0 to 10
    Then The probability of each generated number should be 1 to 10 and epsilon 1 to 100
#test read set get
  Scenario:
    Given  I have my Game class with param 4
    When I read matrix from "matrix_1.txt"
    And I set the game matrix in accordance with the read matrix
    And I call 'getArr'
    Then the matrix must match the matrix from the file "matrix_1.txt"
#Left
  Scenario:
    Given  I have my Game class with param 4
    When I read matrix from "matrix_1.txt"
    And I set the game matrix in accordance with the read matrix
    # читаем и запоминаем результирующую матрицу
    And I read matrix from "matrix_1_left.txt"
    # двигаем поле влево
    And I call 'left' method
    # получаем матрицу из игрового класса
    And I call 'getArr'
    # сравниваем считанную матрицу из файла и матрицу полученную из игрового поля
    Then the matrix must match the matrix from the file "matrix_1_left.txt"
#ClearArray_inactive
  Scenario:
    Given  I have my Game class with param 4
    When I fill 'clearArray' the array with random numbers
    And i clear the array
    Then all array elements are 0
#motion
  Scenario:
    Given  I have my Game class with param 4
    When I read matrix from "matrix_1.txt"
    And I set the game matrix in accordance with the read matrix
    # читаем и запоминаем результирующую матрицу
    And I read matrix from "matrix_1_testMotion(0.0).txt"
    # двигаем поле влево
    And I call 'motionElem' method with param 0 -1
    # получаем матрицу из игрового класса
    And I call 'getArr'
    # сравниваем считанную матрицу из файла и матрицу полученную из игрового поля
    Then the matrix must match the matrix from the file "matrix_1_testMotion(0.0).txt"
#motion
  Scenario:
    Given  I have my Game class with param 4
    When I read matrix from "motionTest1(0 -1 0 2).txt"
    And I set the game matrix in accordance with the read matrix
    # читаем и запоминаем результирующую матрицу
    And I read matrix from "motionTest1(0 -1 0 2)out.txt"
    # двигаем поле влево
    And I call 'motionElem' method with param 0 -1 0 2
    # получаем матрицу из игрового класса
    And I call 'getArr'
    # сравниваем считанную матрицу из файла и матрицу полученную из игрового поля
    Then the matrix must match the matrix from the file "motionTest1(0 -1 0 2)out.txt"
#motion
  Scenario:
    Given  I have my Game class with param 4
    When I read matrix from "motionTest3(0 -1 2 2).txt"
    And I set the game matrix in accordance with the read matrix
    # читаем и запоминаем результирующую матрицу
    And I read matrix from "motionTest3(0 -1 2 2)out.txt"
    # двигаем поле влево
    And I call 'motionElem' method with param 0 -1 2 2
    # получаем матрицу из игрового класса
    And I call 'getArr'
    # сравниваем считанную матрицу из файла и матрицу полученную из игрового поля
    Then the matrix must match the matrix from the file "motionTest3(0 -1 2 2)out.txt"
#Left
  Scenario:
    Given  I have my Game class with param 4
    When I read matrix from "matrix_2.txt"
    And I set the game matrix in accordance with the read matrix
    # читаем и запоминаем результирующую матрицу
    And I read matrix from "matrix_2_left.txt"
    # двигаем поле влево
    And I call 'left' method
    # получаем матрицу из игрового класса
    And I call 'getArr'
    # сравниваем считанную матрицу из файла и матрицу полученную из игрового поля
    Then the matrix must match the matrix from the file "matrix_2_left.txt"
#Right
  Scenario:
    Given  I have my Game class with param 4
    When I read matrix from "matrix_1.txt"
    And I set the game matrix in accordance with the read matrix
    # читаем и запоминаем результирующую матрицу
    And I read matrix from "matrix_1_right.txt"
    # двигаем поле влево
    And I call 'right' method
    # получаем матрицу из игрового класса
    And I call 'getArr'
    # сравниваем считанную матрицу из файла и матрицу полученную из игрового поля
    Then the matrix must match the matrix from the file "matrix_1_right.txt"
#Right
  Scenario:
    Given  I have my Game class with param 4
    When I read matrix from "matrix_2.txt"
    And I set the game matrix in accordance with the read matrix
    # читаем и запоминаем результирующую матрицу
    And I read matrix from "matrix_2_right.txt"
    # двигаем поле влево
    And I call 'right' method
    # получаем матрицу из игрового класса
    And I call 'getArr'
    # сравниваем считанную матрицу из файла и матрицу полученную из игрового поля
    Then the matrix must match the matrix from the file "matrix_2_right.txt"
#UP
  Scenario:
    Given  I have my Game class with param 4
    When I read matrix from "matrix_3.txt"
    And I set the game matrix in accordance with the read matrix
    # читаем и запоминаем результирующую матрицу
    And I read matrix from "matrix_3_up.txt"
    # двигаем поле влево
    And I call 'up' method
    # получаем матрицу из игрового класса
    And I call 'getArr'
    # сравниваем считанную матрицу из файла и матрицу полученную из игрового поля
    Then the matrix must match the matrix from the file "matrix_3_up.txt"
#DOWN
  Scenario:
    Given  I have my Game class with param 4
    When I read matrix from "matrix_3.txt"
    And I set the game matrix in accordance with the read matrix
    # читаем и запоминаем результирующую матрицу
    And I read matrix from "matrix_3_down.txt"
    # двигаем поле влево
    And I call 'down' method
    # получаем матрицу из игрового класса
    And I call 'getArr'
    # сравниваем считанную матрицу из файла и матрицу полученную из игрового поля
    Then the matrix must match the matrix from the file "matrix_3_down.txt"
#GameOver
  Scenario:
    Given  I have my Game class with param 4
    When I read matrix from "matrix_end.txt"
    And I set the game matrix in accordance with the read matrix
    # двигаем поле влево
    And I call 'left' method
    # сравниваем считанную матрицу из файла и матрицу полученную из игрового поля
    Then The result of 'left' method should be "false"
##GameOver2
  Scenario:
    Given  I have my Game class with param 4
    When I read matrix from "matrix_1.txt"
    And I set the game matrix in accordance with the read matrix
    # двигаем поле влево
    And I call 'left' method
    # сравниваем считанную матрицу из файла и матрицу полученную из игрового поля
    Then The result of 'left' method should be "true"

  Scenario:
    Given  I have my Game class with param 4
    When I read matrix from "matrix_end.txt"
    And I set the game matrix in accordance with the read matrix
    # двигаем поле влево
    And I call 'left' method
    And I call 'right' method
    And I call 'down' method
    And I call 'up' method
    # сравниваем считанную матрицу из файла и матрицу полученную из игрового поля
    Then All methods returned "false"
  Scenario:
    Given  I have my Game class with param 4
    When I read matrix from "matrix_end_2.txt"
    And I set the game matrix in accordance with the read matrix
    # двигаем поле влево
    And I call 'left' method
    And I call 'right' method
    And I call 'down' method
    And I call 'up' method
    # сравниваем считанную матрицу из файла и матрицу полученную из игрового поля
    Then at least one method will return "true"