package de.galimov.bridge.common.basic.trick

import de.galimov.bridge.common.basic.Cards.Card
import de.galimov.bridge.common.basic.{Cards, Player}

class Trick(val trickStartPlayer: Player, val playedCards: Map[Player, Card]) {
  def trickSuit: Cards.Suit = playedCards(trickStartPlayer).suit
}
