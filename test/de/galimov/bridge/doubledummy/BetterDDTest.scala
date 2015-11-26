package de.galimov.bridge.doubledummy

import de.galimov.bridge.common.basic.Bids.FOUR_SPADES
import de.galimov.bridge.common.basic.Player.{East, North, South, West}
import de.galimov.bridge.common.basic._
import de.galimov.bridge.common.basic.trick.OngoingTrick
import org.scalatest.FunSuite

import scala.collection.mutable

class BetterDDTest extends FunSuite {
  val testHands = Map[Player, Hand] (
    South -> new Hand(Hand.formSuitBySuitString("7654S A65H AKTD KJTC")),
    West -> new Hand(Hand.formSuitBySuitString("2S T94H 965D A65432C")),
    North -> new Hand(Hand.formSuitBySuitString("AKJ9S J872H QJ87D QC")),
    East -> new Hand(Hand.formSuitBySuitString("QT83S KQ3H 432D 987C"))
  )

  val deal = new Deal(testHands, North)

  test("blub") {
    val firstMove = new OngoingPlay(deal, new Contract(FOUR_SPADES, None), testHands, OngoingTrick.startTrick(West), Nil)
    val situations: mutable.Map[OngoingPlay, HitSituation] = mutable.Map()
    new Range(1, 13, 1).foreach(i => println(i + " " + new BetterDD(firstMove, situations).solve(i)))
  }

}
