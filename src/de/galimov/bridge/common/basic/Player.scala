package de.galimov.bridge.common.basic

object Player {
  case object South extends Player(West, East)
  case object East extends Player(South, North)
  case object North extends Player(East, West)
  case object West extends Player(North, South)
}

abstract class Player(nextPlayer: => Player, previousPlayer: => Player) {
  def next: Player = nextPlayer
  def prev: Player = previousPlayer
}
