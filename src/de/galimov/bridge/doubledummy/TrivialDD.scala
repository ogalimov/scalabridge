package de.galimov.bridge.doubledummy

import de.galimov.bridge.common.basic.{Cards, OngoingPlay, Hand, Player}

class TrivialDD(problem: OngoingPlay) {
  def solve: Int = {
    val size: Int = problem.remainingCardsActivePlayer.cards.size
    if(size > 5) {
      println(size + "-" + problem.currentPlayer)
    }

    if (problem.finished) {
      problem.numNSTricks
    } else if (problem.currentPlayerIsNs) {
      problem.possibleMoves
        .map(card => (new TrivialDD(problem.playCard(card)).solve, card))
        .max
        ._1
    } else {
      problem.possibleMoves
        .map(card => (new TrivialDD(problem.playCard(card)).solve, card))
        .min
        ._1
    }
  }
}
