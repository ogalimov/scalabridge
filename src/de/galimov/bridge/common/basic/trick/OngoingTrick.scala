package de.galimov.bridge.common.basic.trick

import de.galimov.bridge.common.basic.Bids.ContractSuit
import de.galimov.bridge.common.basic.Cards.Card
import de.galimov.bridge.common.basic.{Bids, Player}

class OngoingTrick(trickStartPlayer: Player, val currentPlayer: Player, playedCards: Map[Player, Card]) extends Trick(trickStartPlayer, playedCards) {
  def playCard(card: Card, contractSuit: Bids.ContractSuit): Trick = {
    val newPlayedCards = playedCards.updated(currentPlayer, card)
    if (newPlayedCards.size == 4) {
      val playerWinningTrick = determineTrickWinner(newPlayedCards, contractSuit)

      new CompletedTrick(trickStartPlayer, playerWinningTrick, newPlayedCards)
    } else {
      new OngoingTrick(trickStartPlayer, currentPlayer.next, newPlayedCards)
    }
  }

  def determineTrickWinner(cards: Map[Player, Card], contractSuit: ContractSuit): Player = {
    val aPlayer = cards.keys.toList.head
    if (cards.size == 1) {
      aPlayer
    } else {
      val otherCandidate = determineTrickWinner(cards - aPlayer, contractSuit)
      val myCard = cards(aPlayer)
      val otherCard = cards(otherCandidate)

      if (myCard.suit == otherCard.suit) {
        if (myCard > otherCard) {
          aPlayer
        } else {
          otherCandidate
        }
      } else {
        if (contractSuit.suit.isDefined) {
          if (myCard.suit == contractSuit.suit.get) {
            aPlayer
          } else if (otherCard.suit == contractSuit.suit.get) {
            otherCandidate
          } else {
            if (myCard.suit == trickSuit) {
              aPlayer
            } else {
              otherCandidate
            }
          }
        } else {
          if (myCard.suit == trickSuit) {
            aPlayer
          } else {
            otherCandidate
          }
        }
      }
    }
  }
}

object OngoingTrick {
  def startTrick(trickStartPlayer: Player): OngoingTrick = new OngoingTrick(trickStartPlayer, trickStartPlayer, Map[Player, Card]())
}
