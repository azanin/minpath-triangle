package io.azanin

import cats.effect.{ ExitCode, IO, IOApp }

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] =
    IO.delay(println("Hello world")).as(ExitCode.Success)
}
