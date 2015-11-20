package de.galimov.bridge.common.bidding

import de.galimov.bridge.common.basic.Bids.PASS
import de.galimov.bridge.common.basic.{Player, Bids}

class Bidding(val bid: Option[Bids.Bid], pastBidding: => Bidding)  {
  def currentPlayer: Player = pastBidding.currentPlayer.next

  private def numPassesInARow: Int = if(bid.isEmpty) 0 else {
    bid.get match {
      case PASS => pastBidding.numPassesInARow + 1;
      case _ => 0
    }
  }

  def getPastBidding = pastBidding

  def isOver: Boolean = numPassesInARow == 4 || (numPassesInARow == 3 && getPastBidding.getPastBidding.getPastBidding.bid.isDefined)
}

object Bidding {
  class BiddingStart(startPlayer: Player) extends Bidding(None, EMPTY_BIDDING1) {
    override def currentPlayer: Player = startPlayer
  }

  private object EMPTY_BIDDING1 extends Bidding(None, EMPTY_BIDDING2)
  private object EMPTY_BIDDING2 extends Bidding(None, EMPTY_BIDDING1)
}