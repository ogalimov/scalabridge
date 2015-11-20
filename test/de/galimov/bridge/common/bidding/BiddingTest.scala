package de.galimov.bridge.common.bidding

import de.galimov.bridge.common.basic.Bids.{ONE_SPADES, PASS}
import de.galimov.bridge.common.basic.Player.South
import de.galimov.bridge.common.bidding.Bidding.BiddingStart
import org.scalatest.FunSuite

class BiddingTest extends FunSuite {
  test("one times pass bidding is not over") {
    val bidding = new Bidding(Some(PASS), new BiddingStart(South))

    assert(!bidding.isOver)
  }

  test("two times pass bidding is not over") {
    val biddingStart = new BiddingStart(South)
    val bidding1 = new Bidding(Some(PASS), biddingStart)
    val bidding2 = new Bidding(Some(PASS), bidding1)

    assert(!bidding2.isOver)
  }

  test("three times pass bidding is not over") {
    val biddingStart = new BiddingStart(South)
    val bidding1 = new Bidding(Some(PASS), biddingStart)
    val bidding2 = new Bidding(Some(PASS), bidding1)
    val bidding3 = new Bidding(Some(PASS), bidding2)

    assert(!bidding3.isOver)
  }

  test("four times pass bidding is over") {
    val biddingStart = new BiddingStart(South)
    val bidding1 = new Bidding(Some(PASS), biddingStart)
    val bidding2 = new Bidding(Some(PASS), bidding1)
    val bidding3 = new Bidding(Some(PASS), bidding2)
    val bidding4 = new Bidding(Some(PASS), bidding3)

    assert(bidding4.isOver)
  }

  test("one times pass after bid bidding is not over") {
    val biddingStart = new BiddingStart(South)
    val bidding1 = new Bidding(Some(ONE_SPADES), biddingStart)
    val bidding2 = new Bidding(Some(PASS), bidding1)

    assert(!bidding2.isOver)
  }

  test("two times pass after bid bidding is not over") {
    val biddingStart = new BiddingStart(South)
    val bidding1 = new Bidding(Some(ONE_SPADES), biddingStart)
    val bidding2 = new Bidding(Some(PASS), bidding1)
    val bidding3 = new Bidding(Some(PASS), bidding2)

    assert(!bidding3.isOver)
  }


  test("three times pass after bid bidding is over") {
    val biddingStart = new BiddingStart(South)
    val bidding1 = new Bidding(Some(ONE_SPADES), biddingStart)
    val bidding2 = new Bidding(Some(PASS), bidding1)
    val bidding3 = new Bidding(Some(PASS), bidding2)
    val bidding4 = new Bidding(Some(PASS), bidding3)

    assert(bidding4.isOver)
  }
}
