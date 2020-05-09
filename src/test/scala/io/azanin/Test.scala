package io.azanin

import io.azanin.Main.{ Node, Path }
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import scala.util.Random

class Test extends AnyFunSuite with Matchers {
  test("Correctness of the alghoritm") {

    val input = List(
      List(Node(7)),
      List(Node(6), Node(3)),
      List(Node(3), Node(8), Node(5)),
      List(Node(11), Node(2), Node(10), Node(9))
    )

    val actual         = Main.minPathTriangle(input)
    val expectedResult = List(Path(18, List(Node(7), Node(6), Node(3), Node(2))))

    actual.shouldBe(expectedResult)
  }

  test("500 rows triangle") {

    val input = (for {
      rows <- 1 to 500
    } yield List.fill(rows)(Node(Random.nextInt(20)))).toList

    val actual = Main.minPathTriangle(input)

    actual.nonEmpty.shouldBe(true)
  }

}
