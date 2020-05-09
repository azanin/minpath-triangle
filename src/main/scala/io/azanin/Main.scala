package io.azanin

import cats.effect.{ ExitCode, IO, IOApp }

object Main extends IOApp {

  case class Node(value: Int) extends AnyVal
  case class Path(total: Int, nodes: List[Node])

  def minPathTriangle(input: List[List[Int]]): List[Path] = ???

  override def run(args: List[String]): IO[ExitCode] =
    IO.delay(println("Hello world")).as(ExitCode.Success)
}
