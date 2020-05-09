package io.azanin

import cats.effect.{ ContextShift, IO, Timer }
import cats.effect.testing.scalatest.{ AssertingSyntax, EffectTestSupport }
import org.scalatest.funsuite.AsyncFunSuite

import scala.concurrent.ExecutionContext

trait AsyncFunIOSpec extends AsyncFunSuite with AssertingSyntax with EffectTestSupport {
  override val executionContext: ExecutionContext = ExecutionContext.global
  implicit val ioContextShift: ContextShift[IO]   = IO.contextShift(executionContext)
  implicit val ioTimer: Timer[IO]                 = IO.timer(executionContext)
}
