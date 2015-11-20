package de.galimov.bridge.common.basic

import de.galimov.bridge.common.basic.Bids.{ModifierBid, ContractBid}

class Contract(val contractBid: ContractBid, val modifierBid: Option[ModifierBid]) {
}
