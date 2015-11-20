package de.galimov.bridge.common.basic

object Cards {
  abstract class Suit(val order: Int)

  case object CLUBS extends Suit(1)
  case object DIAMONDS extends Suit(2)
  case object HEARTS extends Suit(3)
  case object SPADES extends Suit(4)

  abstract class Rank(val order: Int) extends Ordered[Rank] {
    override def compare(that: Rank): Int = order.compare(that.order)
  }

  case object ACE extends Rank(140)
  case object KING extends Rank(130)
  case object QUEEN extends Rank(120)
  case object JACK extends Rank(110)
  case object TEN extends Rank(100)
  case object NINE extends Rank(90)
  case object EIGHT extends Rank(80)
  case object SEVEN extends Rank(70)
  case object SIX extends Rank(60)
  case object FIVE extends Rank(50)
  case object FOUR extends Rank(40)
  case object THREE extends Rank(30)
  case object TWO extends Rank(20)

  abstract class Card(val rank: Rank, val suit: Suit) extends Ordered[Card] {
    override def compare(that: Card): Int = (rank.order + suit.order).compare(that.rank.order + that.suit.order)
  }

  case object ACE_OF_CLUBS extends Card(ACE, CLUBS)
  case object KING_OF_CLUBS extends Card(KING, CLUBS)
  case object QUEEN_OF_CLUBS extends Card(QUEEN, CLUBS)
  case object JACK_OF_CLUBS extends Card(JACK, CLUBS)
  case object TEN_OF_CLUBS extends Card(TEN, CLUBS)
  case object NINE_OF_CLUBS extends Card(NINE, CLUBS)
  case object EIGHT_OF_CLUBS extends Card(EIGHT, CLUBS)
  case object SEVEN_OF_CLUBS extends Card(SEVEN, CLUBS)
  case object SIX_OF_CLUBS extends Card(SIX, CLUBS)
  case object FIVE_OF_CLUBS extends Card(FIVE, CLUBS)
  case object FOUR_OF_CLUBS extends Card(FOUR, CLUBS)
  case object THREE_OF_CLUBS extends Card(THREE, CLUBS)
  case object TWO_OF_CLUBS extends Card(TWO, CLUBS)

  case object ACE_OF_DIAMONDS extends Card(ACE, DIAMONDS)
  case object KING_OF_DIAMONDS extends Card(KING, DIAMONDS)
  case object QUEEN_OF_DIAMONDS extends Card(QUEEN, DIAMONDS)
  case object JACK_OF_DIAMONDS extends Card(JACK, DIAMONDS)
  case object TEN_OF_DIAMONDS extends Card(TEN, DIAMONDS)
  case object NINE_OF_DIAMONDS extends Card(NINE, DIAMONDS)
  case object EIGHT_OF_DIAMONDS extends Card(EIGHT, DIAMONDS)
  case object SEVEN_OF_DIAMONDS extends Card(SEVEN, DIAMONDS)
  case object SIX_OF_DIAMONDS extends Card(SIX, DIAMONDS)
  case object FIVE_OF_DIAMONDS extends Card(FIVE, DIAMONDS)
  case object FOUR_OF_DIAMONDS extends Card(FOUR, DIAMONDS)
  case object THREE_OF_DIAMONDS extends Card(THREE, DIAMONDS)
  case object TWO_OF_DIAMONDS extends Card(TWO, DIAMONDS)

  case object ACE_OF_HEARTS extends Card(ACE, HEARTS)
  case object KING_OF_HEARTS extends Card(KING, HEARTS)
  case object QUEEN_OF_HEARTS extends Card(QUEEN, HEARTS)
  case object JACK_OF_HEARTS extends Card(JACK, HEARTS)
  case object TEN_OF_HEARTS extends Card(TEN, HEARTS)
  case object NINE_OF_HEARTS extends Card(NINE, HEARTS)
  case object EIGHT_OF_HEARTS extends Card(EIGHT, HEARTS)
  case object SEVEN_OF_HEARTS extends Card(SEVEN, HEARTS)
  case object SIX_OF_HEARTS extends Card(SIX, HEARTS)
  case object FIVE_OF_HEARTS extends Card(FIVE, HEARTS)
  case object FOUR_OF_HEARTS extends Card(FOUR, HEARTS)
  case object THREE_OF_HEARTS extends Card(THREE, HEARTS)
  case object TWO_OF_HEARTS extends Card(TWO, HEARTS)

  case object ACE_OF_SPADES extends Card(ACE, SPADES)
  case object KING_OF_SPADES extends Card(KING, SPADES)
  case object QUEEN_OF_SPADES extends Card(QUEEN, SPADES)
  case object JACK_OF_SPADES extends Card(JACK, SPADES)
  case object TEN_OF_SPADES extends Card(TEN, SPADES)
  case object NINE_OF_SPADES extends Card(NINE, SPADES)
  case object EIGHT_OF_SPADES extends Card(EIGHT, SPADES)
  case object SEVEN_OF_SPADES extends Card(SEVEN, SPADES)
  case object SIX_OF_SPADES extends Card(SIX, SPADES)
  case object FIVE_OF_SPADES extends Card(FIVE, SPADES)
  case object FOUR_OF_SPADES extends Card(FOUR, SPADES)
  case object THREE_OF_SPADES extends Card(THREE, SPADES)
  case object TWO_OF_SPADES extends Card(TWO, SPADES)

  val stringToCard = Map(
    "AC" -> ACE_OF_CLUBS, "AD" -> ACE_OF_DIAMONDS, "AH" -> ACE_OF_HEARTS, "AS" -> ACE_OF_SPADES,
    "KC" -> KING_OF_CLUBS, "KD" -> KING_OF_DIAMONDS, "KH" -> KING_OF_HEARTS, "KS" -> KING_OF_SPADES,
    "QC" -> QUEEN_OF_CLUBS, "QD" -> QUEEN_OF_DIAMONDS, "QH" -> QUEEN_OF_HEARTS, "QS" -> QUEEN_OF_SPADES,
    "JC" -> JACK_OF_CLUBS, "JD" -> JACK_OF_DIAMONDS, "JH" -> JACK_OF_HEARTS, "JS" -> JACK_OF_SPADES,
    "TC" -> TEN_OF_CLUBS, "TD" -> TEN_OF_DIAMONDS, "TH" -> TEN_OF_HEARTS, "TS" -> TEN_OF_SPADES,
    "9C" -> NINE_OF_CLUBS, "9D" -> NINE_OF_DIAMONDS, "9H" -> NINE_OF_HEARTS, "9S" -> NINE_OF_SPADES,
    "8C" -> EIGHT_OF_CLUBS, "8D" -> EIGHT_OF_DIAMONDS, "8H" -> EIGHT_OF_HEARTS, "8S" -> EIGHT_OF_SPADES,
    "7C" -> SEVEN_OF_CLUBS, "7D" -> SEVEN_OF_DIAMONDS, "7H" -> SEVEN_OF_HEARTS, "7S" -> SEVEN_OF_SPADES,
    "6C" -> SIX_OF_CLUBS, "6D" -> SIX_OF_DIAMONDS, "6H" -> SIX_OF_HEARTS, "6S" -> SIX_OF_SPADES,
    "5C" -> FIVE_OF_CLUBS, "5D" -> FIVE_OF_DIAMONDS, "5H" -> FIVE_OF_HEARTS, "5S" -> FIVE_OF_SPADES,
    "4C" -> FOUR_OF_CLUBS, "4D" -> FOUR_OF_DIAMONDS, "4H" -> FOUR_OF_HEARTS, "4S" -> FOUR_OF_SPADES,
    "3C" -> THREE_OF_CLUBS, "3D" -> THREE_OF_DIAMONDS, "3H" -> THREE_OF_HEARTS, "3S" -> THREE_OF_SPADES,
    "2C" -> TWO_OF_CLUBS, "2D" -> TWO_OF_DIAMONDS, "2H" -> TWO_OF_HEARTS, "2S" -> TWO_OF_SPADES
  )
  
  val suitStringToSuit = Map(
    "C" -> CLUBS,
    "D" -> DIAMONDS,
    "H" -> HEARTS,
    "S" -> SPADES
  )

  val rankStringToCards = Map(
    "A" -> Array(ACE_OF_CLUBS, ACE_OF_DIAMONDS, ACE_OF_HEARTS, ACE_OF_SPADES),
    "K" -> Array(KING_OF_CLUBS, KING_OF_DIAMONDS, KING_OF_HEARTS, KING_OF_SPADES),
    "Q" -> Array(QUEEN_OF_CLUBS, QUEEN_OF_DIAMONDS, QUEEN_OF_HEARTS, QUEEN_OF_SPADES),
    "J" -> Array(JACK_OF_CLUBS, JACK_OF_DIAMONDS, JACK_OF_HEARTS, JACK_OF_SPADES),
    "T" -> Array(TEN_OF_CLUBS, TEN_OF_DIAMONDS, TEN_OF_HEARTS, TEN_OF_SPADES),
    "9" -> Array(NINE_OF_CLUBS, NINE_OF_DIAMONDS, NINE_OF_HEARTS, NINE_OF_SPADES),
    "8" -> Array(EIGHT_OF_CLUBS, EIGHT_OF_DIAMONDS, EIGHT_OF_HEARTS, EIGHT_OF_SPADES),
    "7" -> Array(SEVEN_OF_CLUBS, SEVEN_OF_DIAMONDS, SEVEN_OF_HEARTS, SEVEN_OF_SPADES),
    "6" -> Array(SIX_OF_CLUBS, SIX_OF_DIAMONDS, SIX_OF_HEARTS, SIX_OF_SPADES),
    "5" -> Array(FIVE_OF_CLUBS, FIVE_OF_DIAMONDS, FIVE_OF_HEARTS, FIVE_OF_SPADES),
    "4" -> Array(FOUR_OF_CLUBS, FOUR_OF_DIAMONDS, FOUR_OF_HEARTS, FOUR_OF_SPADES),
    "3" -> Array(THREE_OF_CLUBS, THREE_OF_DIAMONDS, THREE_OF_HEARTS, THREE_OF_SPADES),
    "2" -> Array(TWO_OF_CLUBS, TWO_OF_DIAMONDS, TWO_OF_HEARTS, TWO_OF_SPADES)
  )
}
