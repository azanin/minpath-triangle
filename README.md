# Minimum/Maximum triangle paths
This program evaluates the minimum triangle path.

Problem states:

*Consider the following triangle of numbers*

```
    7
   6 3
  3 8 5
11 2 10 9
```

*A path through the triangle is a sequence of adjacent nodes, one from each row, starting from the top. So, for instance,
 7 → 6 → 3 → 11 is a path down the left-hand edge of the triangle.
 A minimal path is defined as one whose sum of values in its nodes is no greater than for any other
  path through the triangle.
  In this case, 7+6+3+2 = 18 is the minimal path.*
 
 ## Behaviour
 The application read from the stdIn a `data.txt` contente representing the triangle and output to the console the result in this form:
 *Minimal path is: 7 + 6 + 3 + 2 = 18*
 
 ### Run Tests
 `sbt test`
 
 ### Run application
 `cat data.txt | sbt run`