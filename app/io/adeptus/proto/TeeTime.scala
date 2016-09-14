package io.adeptus.proto

import org.joda.time.DateTime

case class TeeTime(
  id: Option[Long],
  teeSheetId: Long,
  time: DateTime)
