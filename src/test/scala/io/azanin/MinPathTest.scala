package io.azanin

import cats.implicits._
import io.azanin.MinPathTriangle.{ Node, Path }
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import scala.util.{ Random, Success }

class MinPathTest extends AnyFunSuite with Matchers {
  test("Correctness of the algorithm") {

    val input = List(
      List(Node(7)),
      List(Node(6), Node(3)),
      List(Node(3), Node(8), Node(5)),
      List(Node(11), Node(2), Node(10), Node(9))
    )

    val actual         = MinPathTriangle.minPathTriangle(input)
    val expectedResult = Some(Path(18, List(Node(7), Node(6), Node(3), Node(2))))

    actual.shouldBe(expectedResult)
  }

  test("Correctness of the algorithm with empty triangle") {

    val input = Nil

    val actual         = MinPathTriangle.minPathTriangle(input)
    val expectedResult = None

    actual.shouldBe(expectedResult)
  }

  test("500 rows triangle") {

    val input = (for {
      rows <- 1 to 500
    } yield List.fill(rows)(Node(Random.nextInt(20)))).toList

    val actual = MinPathTriangle.minPathTriangle(input)

    actual.nonEmpty.shouldBe(true)
  }

  test("parse triangle") {

    val input          = List("1", "2 3", "4 5 6")
    val expectedResult = Success(List(List(Node(1)), List(Node(2), Node(3)), List(Node(4), Node(5), Node(6))))

    val actual = MinPathTriangle.parseTriangle(input)

    actual.shouldBe(expectedResult)
  }

  test("error in parsing triangle") {

    val input = List("1", "notANumber 3", "4 5 6")

    val actual = MinPathTriangle.parseTriangle(input)

    actual.isFailure.shouldBe(true)
  }

  test("path string representation") {
    val input          = Path(18, List(Node(7), Node(6), Node(3), Node(2)))
    val expectedResult = "Minimal path is: 7 + 6 + 3 + 2 = 18"

    input.show.shouldBe(expectedResult)
  }

}
