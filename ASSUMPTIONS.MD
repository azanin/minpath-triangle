# Assumptions

## IO interaction
Since there is the need to read from a file and to interact with the console, I choose to rely on the `cats-effect` library.

### Reading from stdIn
Using `Resource.fromAutoClosable` ensures that the stdIn will be closed after the usage.

## Parse the triangle
The triangle must contain numbers and every row contains one more node of the previous one.
Note that the program will `exit 1` in case of not a number input string (IO will fail).

## Algorithm
I choose to `foldRight` the structure of the triangle that is represented as a `List[List[Node]]`.
`foldRight` allows me to build path starting from the bottom and it is very straightforward and elegant:
- The minimum path sums for the nodes of the last row are the value of the nodes themselves.
- The minimum path sums for a node of a row will be the lesser of the path sums of its children plus the value of itself.

It's worth also notice that I choose the List's foldRight function instead of the cats `foldr` one because is stack safe 
in the case of `List`. 

## Model and output representation
I choose to model primitives value like `Int` with `Node` case class.
`Path` is the case class that keeps together the chosen nodes and their sum.

To represent the Path in the desired way I defined a `Show[Path]` instance.

## Unit tests
I have tested the algorithm with the provided example and with random numbers composing 500 rows triangle.
Furthermore, I added tests for the parse function and the representation logic.
