package de.galimov.bridge.common.basic.trick

import de.galimov.bridge.common.basic.Cards.Card
import de.galimov.bridge.common.basic.Player

class CompletedTrick(trickStartPlayer: Player, val winningPlayer: Player, playedCards: Map[Player, Card]) extends Trick(trickStartPlayer, playedCards) {
}
