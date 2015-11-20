package de.galimov.bridge.common.basic

object Bids {
  abstract class ContractSuit(val suit: Option[Cards.Suit])

  case object CLUBS extends ContractSuit(Some(Cards.CLUBS))
  case object DIAMONDS extends ContractSuit(Some(Cards.DIAMONDS))
  case object HEARTS extends ContractSuit(Some(Cards.HEARTS))
  case object SPADES extends ContractSuit(Some(Cards.SPADES))
  case object NT extends ContractSuit(None)

  abstract class Level(tricks: Integer)

  case object ONE extends Level(7)
  case object TWO extends Level(8)
  case object THREE extends Level(9)
  case object FOUR extends Level(10)
  case object FIVE extends Level(11)
  case object SIX extends Level(12)
  case object SEVEN extends Level(13)

  abstract class Bid

  case object PASS extends Bid

  abstract class ModifierBid extends Bid

  case object DOUBLE extends ModifierBid
  case object REDOUBLE extends ModifierBid

  abstract class ContractBid(val level: Level, val suit: ContractSuit) extends Bid

  case object ONE_CLUBS extends ContractBid(ONE, CLUBS)
  case object ONE_DIAMONDS extends ContractBid(ONE, DIAMONDS)
  case object ONE_HEARTS extends ContractBid(ONE, HEARTS)
  case object ONE_SPADES extends ContractBid(ONE, SPADES)
  case object ONE_NT extends ContractBid(ONE, NT)

  case object TWO_CLUBS extends ContractBid(TWO, CLUBS)
  case object TWO_DIAMONDS extends ContractBid(TWO, DIAMONDS)
  case object TWO_HEARTS extends ContractBid(TWO, HEARTS)
  case object TWO_SPADES extends ContractBid(TWO, SPADES)
  case object TWO_NT extends ContractBid(TWO, NT)

  case object THREE_CLUBS extends ContractBid(THREE, CLUBS)
  case object THREE_DIAMONDS extends ContractBid(THREE, DIAMONDS)
  case object THREE_HEARTS extends ContractBid(THREE, HEARTS)
  case object THREE_SPADES extends ContractBid(THREE, SPADES)
  case object THREE_NT extends ContractBid(THREE, NT)

  case object FOUR_CLUBS extends ContractBid(FOUR, CLUBS)
  case object FOUR_DIAMONDS extends ContractBid(FOUR, DIAMONDS)
  case object FOUR_HEARTS extends ContractBid(FOUR, HEARTS)
  case object FOUR_SPADES extends ContractBid(FOUR, SPADES)
  case object FOUR_NT extends ContractBid(FOUR, NT)

  case object FIVE_CLUBS extends ContractBid(FIVE, CLUBS)
  case object FIVE_DIAMONDS extends ContractBid(FIVE, DIAMONDS)
  case object FIVE_HEARTS extends ContractBid(FIVE, HEARTS)
  case object FIVE_SPADES extends ContractBid(FIVE, SPADES)
  case object FIVE_NT extends ContractBid(FIVE, NT)

  case object SIX_CLUBS extends ContractBid(SIX, CLUBS)
  case object SIX_DIAMONDS extends ContractBid(SIX, DIAMONDS)
  case object SIX_HEARTS extends ContractBid(SIX, HEARTS)
  case object SIX_SPADES extends ContractBid(SIX, SPADES)
  case object SIX_NT extends ContractBid(SIX, NT)

  case object SEVEN_CLUBS extends ContractBid(SEVEN, CLUBS)
  case object SEVEN_DIAMONDS extends ContractBid(SEVEN, DIAMONDS)
  case object SEVEN_HEARTS extends ContractBid(SEVEN, HEARTS)
  case object SEVEN_SPADES extends ContractBid(SEVEN, SPADES)
  case object SEVEN_NT extends ContractBid(SEVEN, NT)
}
