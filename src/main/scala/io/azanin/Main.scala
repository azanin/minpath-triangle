package io.azanin

import cats.Order
import cats.data.Ior
import cats.effect.{ ExitCode, IO, IOApp }
import cats.implicits._

object Main extends IOApp {

  implicit val orderPath: Order[Path] = (x: Path, y: Path) => x.total.compare(y.total)

  case class Node(value: Int) extends AnyVal
  case class Path(total: Int, nodes: List[Node])

  def minPathTriangle(input: List[List[Node]]): List[Path] =
    input.foldRight(List(): List[Path]) {
      case (row, paths) =>
        val couples = paths.zip(paths.drop(1)) //Can't use tail since is throwing exception on empty list
        row.alignWith(couples) {
          case Ior.Both(node, (left, right)) =>
            val chosenPath = left.min(right)
            Path(chosenPath.total + node.value, node +: chosenPath.nodes)
          case Ior.Left(node) => Path(node.value, List(node))
          case _              => Path(0, Nil)
        }
    }

  override def run(args: List[String]): IO[ExitCode] =
    IO.delay(println("Hello world")).as(ExitCode.Success)
}
