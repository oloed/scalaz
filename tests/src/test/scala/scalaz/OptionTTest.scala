package scalaz

import scalaz.scalacheck.ScalazProperties._
import scalaz.scalacheck.ScalazArbitrary._
import std.AllInstances._

class OptionTTest extends Spec {

  type OptionTList[A] = OptionT[List, A]

  checkAll(equal.laws[OptionTList[Int]])
  checkAll(monad.laws[OptionTList])
  checkAll(traverse.laws[OptionTList])

  object instances {
    def functor[F[_] : Functor] = Functor[({type λ[α] = OptionT[F, α]})#λ]
    def pointed[F[_] : Pointed] = Pointed[({type λ[α] = OptionT[F, α]})#λ]
    def apply[F[_] : Apply] = Apply[({type λ[α] = OptionT[F, α]})#λ]
    def monad[F[_] : Monad] = Monad[({type λ[α] = OptionT[F, α]})#λ]
    def foldable[F[_] : Foldable] = Foldable[({type λ[α] = OptionT[F, α]})#λ]
    def traverse[F[_] : Traverse] = Traverse[({type λ[α] = OptionT[F, α]})#λ]
  }
}