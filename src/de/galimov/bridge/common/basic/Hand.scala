package de.galimov.bridge.common.basic

import de.galimov.bridge.common.basic.Cards.Suit

class Hand(val cards: Set[Cards.Card]) {
  def countCardsForSuit(suit: Suit): Int = cards.count(card => card.suit == suit)
  def cardsForSuit(suit: Suit): Set[Cards.Card] = cards.filter(card => card.suit == suit)

  def playCard(card: Cards.Card) : Hand = new Hand(cards - card)
}

object Hand {
  def formCardByCardString(str: String) : Set[Cards.Card] = {
    str.split(" ").map(Cards.stringToCard).toSet
  }

  def formSuitBySuitString(str: String) : Set[Cards.Card] = {
    str.split(" ").flatMap(s => {
      val suit = Cards.suitStringToSuit(s.charAt(s.length - 1).toString)
      s.substring(0, s.length - 1).map(c => Cards.rankStringToCards(c.toString).find(card => card.suit == suit).get)
    }).toSet
  }

}
