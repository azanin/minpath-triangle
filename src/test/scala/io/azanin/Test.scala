package io.azanin

import cats.effect.IO
import org.scalatest.matchers.should.Matchers

class Test extends AsyncFunIOSpec with Matchers {
  test("The test should be true") {
    IO(true).asserting(b => b shouldBe true)
  }
}
