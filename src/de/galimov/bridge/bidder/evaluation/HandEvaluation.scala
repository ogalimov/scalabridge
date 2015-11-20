package de.galimov.bridge.bidder.evaluation

import de.galimov.bridge.common.basic.Cards._
import de.galimov.bridge.common.basic.Hand

object HandEvaluation {
  def determineHcp(card: Card) : Int = card.rank match {
    case ACE => 4
    case KING => 3
    case QUEEN => 2
    case JACK => 1
    case _ => 0
  }

  def countHcp(hand: Hand): Int = hand.cards.toList.map(determineHcp).sum
}
