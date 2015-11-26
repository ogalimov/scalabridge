package de.galimov.bridge.doubledummy

import de.galimov.bridge.common.basic.OngoingPlay

import scala.collection.mutable

class BetterDD(problem: OngoingPlay, situations: mutable.Map[OngoingPlay, HitSituation]) {
  def solve(target: Int): Boolean = {
    val size: Int = problem.remainingCardsActivePlayer.cards.size

    val currentHitSituation: HitSituation = situations.getOrElse(problem, new HitSituation(0, 14))

    if (target <= currentHitSituation.trueHit) {
      true
    } else if (target >= currentHitSituation.falseHit) {
      false
    } else {
      val result = if (problem.numNSTricks == target) {
        true
      } else if (problem.numNSTricks + size < target) {
        false
      } else if (problem.currentPlayerIsNs) {
        problem.possibleMoves.exists(card => new BetterDD(problem.playCard(card), situations).solve(target))
      } else {
        !problem.possibleMoves.exists(card => !new BetterDD(problem.playCard(card), situations).solve(target))
      }

      if(result) {
        situations.put(problem, new HitSituation(target, currentHitSituation.falseHit))
      } else {
        situations.put(problem, new HitSituation(currentHitSituation.trueHit, target))
      }

      result
    }
  }
}
