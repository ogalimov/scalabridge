package de.galimov.bridge.common.basic

import de.galimov.bridge.common.basic.Cards.Card
import de.galimov.bridge.common.basic.Player.{East, West, North, South}
import de.galimov.bridge.common.basic.trick.{OngoingTrick, CompletedTrick}

class OngoingPlay(val deal: Deal, val contract: Contract, val remainingCards: Map[Player, Hand], val ongoingTrick: OngoingTrick, completedTricks: List[CompletedTrick]) {
  def possibleMoves: List[Card] = {
    if (ongoingTrick.playedCards.isEmpty) {
      remainingCardsActivePlayer.cards.toList
    } else {
      val currentSuit = ongoingTrick.trickSuit
      val cardsInSuit = remainingCardsActivePlayer.cardsForSuit(currentSuit)
      if (cardsInSuit.isEmpty) {
        remainingCardsActivePlayer.cards.toList
      } else {
        cardsInSuit.toList
      }
    }
  }

  def playCard(card: Card): OngoingPlay = {
    val newRemainingCards = remainingCards.updated(currentPlayer, remainingCardsActivePlayer.playCard(card))
    val newTrick = ongoingTrick.playCard(card, contract.contractBid.suit)
    newTrick match {
      case trick: CompletedTrick =>
        new OngoingPlay(deal, contract, newRemainingCards, OngoingTrick.startTrick(trick.winningPlayer), trick :: completedTricks)
      case trick: OngoingTrick =>
        new OngoingPlay(deal, contract, newRemainingCards, trick, completedTricks)
    }
  }

  def numNSTricks: Int = completedTricks.count(trick => trick.winningPlayer == South || trick.winningPlayer == North)
  def numEWTricks: Int = completedTricks.count(trick => trick.winningPlayer == East || trick.winningPlayer == West)

  def finished: Boolean = completedTricks.size == 13

  def remainingCardsActivePlayer: Hand = remainingCards(ongoingTrick.currentPlayer)

  def currentPlayer: Player = ongoingTrick.currentPlayer

  def currentPlayerIsNs = currentPlayer == South || currentPlayer == North
}
