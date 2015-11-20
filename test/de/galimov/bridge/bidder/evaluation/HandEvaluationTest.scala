package de.galimov.bridge.bidder.evaluation

import de.galimov.bridge.common.basic.Hand
import org.scalatest.FunSuite

class HandEvaluationTest extends FunSuite {
  test("0 hcp HAND") {
    val hand = new Hand(Hand.formCardByCardString("7S 6S 5S 7H 6H 5H 7D 6D 5D 7C 6C 5C 4C"))

    assert(HandEvaluation.countHcp(hand) == 0)
  }

  test("15 hcp HAND") {
    val hand = new Hand(Hand.formSuitBySuitString("AK5S AK5H 765D J654C"))

    assert(HandEvaluation.countHcp(hand) == 15)
  }
}
