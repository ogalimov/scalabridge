package de.galimov.bridge.common.basic.trick

import de.galimov.bridge.common.basic.Bids
import de.galimov.bridge.common.basic.Bids.NT
import de.galimov.bridge.common.basic.Cards._
import de.galimov.bridge.common.basic.Player.{North, West, South}
import org.scalatest.FunSuite

class OngoingTrickTest extends FunSuite {
  test("Trick winner NT some follow suit") {
    val firstPlay = OngoingTrick.startTrick(South).playCard(SEVEN_OF_SPADES, NT).asInstanceOf[OngoingTrick]
    val secondPlay = firstPlay.playCard(NINE_OF_SPADES, NT).asInstanceOf[OngoingTrick]
    val thirdPlay = secondPlay.playCard(EIGHT_OF_SPADES, NT).asInstanceOf[OngoingTrick]
    val forthPlay = thirdPlay.playCard(TEN_OF_HEARTS, NT).asInstanceOf[CompletedTrick]

    assert(forthPlay.winningPlayer == West)
  }

  test("Trick winner NT no one follows suit") {
    val firstPlay = OngoingTrick.startTrick(South).playCard(SEVEN_OF_DIAMONDS, NT).asInstanceOf[OngoingTrick]
    val secondPlay = firstPlay.playCard(NINE_OF_SPADES, NT).asInstanceOf[OngoingTrick]
    val thirdPlay = secondPlay.playCard(EIGHT_OF_SPADES, NT).asInstanceOf[OngoingTrick]
    val forthPlay = thirdPlay.playCard(TEN_OF_HEARTS, NT).asInstanceOf[CompletedTrick]

    assert(forthPlay.winningPlayer == South)
  }

  test("Trick winner trump contract noone trumps") {
    val firstPlay = OngoingTrick.startTrick(South).playCard(SEVEN_OF_DIAMONDS, Bids.CLUBS).asInstanceOf[OngoingTrick]
    val secondPlay = firstPlay.playCard(NINE_OF_SPADES, Bids.CLUBS).asInstanceOf[OngoingTrick]
    val thirdPlay = secondPlay.playCard(EIGHT_OF_SPADES, Bids.CLUBS).asInstanceOf[OngoingTrick]
    val forthPlay = thirdPlay.playCard(TEN_OF_HEARTS, Bids.CLUBS).asInstanceOf[CompletedTrick]

    assert(forthPlay.winningPlayer == South)
  }

  test("Trick winner trump contract one trumps") {
    val firstPlay = OngoingTrick.startTrick(South).playCard(SEVEN_OF_DIAMONDS, Bids.CLUBS).asInstanceOf[OngoingTrick]
    val secondPlay = firstPlay.playCard(NINE_OF_SPADES, Bids.CLUBS).asInstanceOf[OngoingTrick]
    val thirdPlay = secondPlay.playCard(EIGHT_OF_CLUBS, Bids.CLUBS).asInstanceOf[OngoingTrick]
    val forthPlay = thirdPlay.playCard(TEN_OF_HEARTS, Bids.CLUBS).asInstanceOf[CompletedTrick]

    assert(forthPlay.winningPlayer == North)
  }

  test("Trick winner trump contract two trump") {
    val firstPlay = OngoingTrick.startTrick(South).playCard(SEVEN_OF_DIAMONDS, Bids.CLUBS).asInstanceOf[OngoingTrick]
    val secondPlay = firstPlay.playCard(NINE_OF_CLUBS, Bids.CLUBS).asInstanceOf[OngoingTrick]
    val thirdPlay = secondPlay.playCard(EIGHT_OF_CLUBS, Bids.CLUBS).asInstanceOf[OngoingTrick]
    val forthPlay = thirdPlay.playCard(TEN_OF_HEARTS, Bids.CLUBS).asInstanceOf[CompletedTrick]

    assert(forthPlay.winningPlayer == West)
  }
}
