package io.adeptus.proto

import play.api.libs.json.{ Json, Format }

import org.joda.time.DateTime

case class TeeSheet(
  id: Option[Long],
  courseId: Long,
  date: DateTime)

object TeeSheet {
  implicit val format: Format[TeeSheet] = Json.format[TeeSheet]
}