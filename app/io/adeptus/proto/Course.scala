package io.adeptus.proto

import javax.inject.Inject

import play.api.libs.json.{Json, Format}
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile
import play.api.Play.current
import play.api.db.DBApi

case class Course(
  id: Option[Long],
  name: String,
  address: String,
  city: String)

class Course @Inject() (dbConfigProvider:DatabaseConfigProvider) {
  implicit val format: Format[Course] = Json.format[Course]
  
  val dbConfig = dbConfigProvider.get[JdbcProfile]
  import dbConfig._
  import dbConfig.driver.api._
  
  
  def list: Seq[Course] = { ??? }
  
  def getById(courseId: Long): Option[Course] = { ??? }
  
  def create(course: Course): Course = { ??? }
}
