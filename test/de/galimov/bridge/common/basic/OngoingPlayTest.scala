package de.galimov.bridge.common.basic

import de.galimov.bridge.common.basic.Bids.FOUR_SPADES
import de.galimov.bridge.common.basic.Cards._
import de.galimov.bridge.common.basic.Player.{East, North, West, South}
import de.galimov.bridge.common.basic.trick.OngoingTrick
import org.scalatest.FunSuite

class OngoingPlayTest extends FunSuite {
  val testHands = Map[Player, Hand] (
    South -> new Hand(Hand.formSuitBySuitString("7654S A65H AKTD KJTC")),
    West -> new Hand(Hand.formSuitBySuitString("2S T94H 965D A65432C")),
    North -> new Hand(Hand.formSuitBySuitString("AKJ9S J872H QJ87D QC")),
    East -> new Hand(Hand.formSuitBySuitString("QT83S KQ3H 432D 987C"))
  )

  val deal = new Deal(testHands, North)

  test("Possible moves first card") {
    val firstMove = new OngoingPlay(deal, new Contract(FOUR_SPADES, None), testHands, OngoingTrick.startTrick(West), Nil)
    val possibleMoves = firstMove.possibleMoves

    assert(possibleMoves.size == 13)

    assert(possibleMoves.forall(testHands(West).cards.contains))
  }

  test("Possible moves second card") {
    val firstMove = new OngoingPlay(deal, new Contract(FOUR_SPADES, None), testHands, OngoingTrick.startTrick(West), Nil)
    val secondMove = firstMove.playCard(TEN_OF_HEARTS)
    val possibleMoves = secondMove.possibleMoves

    assert(possibleMoves.size == 4)

    assert(possibleMoves.forall(Hand.formSuitBySuitString("J872H").contains))
  }

  test("Possible moves later void") {
    val firstMove = new OngoingPlay(deal, new Contract(FOUR_SPADES, None), testHands, OngoingTrick.startTrick(West), Nil)
    val secondMove = firstMove.playCard(TWO_OF_SPADES)
    val thirdMove = secondMove.playCard(ACE_OF_SPADES)
    val forthMove = thirdMove.playCard(THREE_OF_SPADES)
    val fifthMove = forthMove.playCard(FOUR_OF_SPADES)

    val sixMove = fifthMove.playCard(KING_OF_SPADES)
    val seventhMove = sixMove.playCard(EIGHT_OF_SPADES)
    val eightsMove = seventhMove.playCard(FIVE_OF_SPADES)

    val possibleMoves = eightsMove.possibleMoves

    assert(possibleMoves.size == 12)

    assert(possibleMoves.forall(Hand.formSuitBySuitString("T94H 965D A65432C").contains))
  }
}
