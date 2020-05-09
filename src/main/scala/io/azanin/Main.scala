package io.azanin

import cats.{ Order, Show }
import cats.data.Ior
import cats.effect.{ ExitCode, IO, IOApp, Resource }
import cats.implicits._

import scala.io.Source
import scala.util.Try

object Main extends IOApp {

  implicit val orderPath: Order[Path] = (x: Path, y: Path) => x.total.compare(y.total)

  implicit val nodeShow: Show[Node] = (n: Node) => n.toString
  implicit val showPath: Show[Path] = (t: Path) => s"Minimal path is: ${t.nodes.map(_.show).mkString("+")} = ${t.total}"

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

  def parseTriangle(rows: List[String]): Try[List[List[Node]]] =
    rows.traverse(_.split(" ").toList.traverse(n => Try(Node(n.toInt))))

  override def run(args: List[String]): IO[ExitCode] =
    Resource
      .fromAutoCloseable(IO.delay(Source.fromFile("data.txt")))
      .use { bs =>
        for {
          lines    <- IO.delay(bs.getLines().toList)
          triangle <- IO.fromTry(parseTriangle(lines))
          path     = minPathTriangle(triangle).headOption
          repr     = path.fold("No Path for the specified Triangle")(_.show)
        } yield println(repr)
      }
      .as(ExitCode.Success)
}
