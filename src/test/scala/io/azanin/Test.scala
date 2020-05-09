package io.azanin

import io.azanin.Main.{ Node, Path }
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Test extends AnyFunSuite with Matchers {
  test("The test should be true") {

    val input = List(List(7), List(6, 3), List(3, 8, 5), List(11, 2, 10, 9))

    val actual = Main.minPathTriangle(input)

    val expectedResult = List(Path(18, List(Node(7), Node(6), Node(3), Node(2))))

    actual.shouldBe(expectedResult)
  }
}
