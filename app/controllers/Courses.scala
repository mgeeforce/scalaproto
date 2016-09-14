package controllers

import play.api.mvc._
import play.api.libs.json.Json

import io.adeptus.proto.Course
import controllers.responses._

class Courses extends Controller {
  
  def list = Action { request =>
    val courses: Seq[Course] = ???
    Ok(Json.toJson(SuccessResponse(courses)))
  }
  
  def getById(courseId: Long) = Action { request =>
    val course: Option[Course] = ???
    course.fold {
      NotFound(Json.toJson(ErrorResponse(NOT_FOUND, "No course found")))
    } { e =>
      Ok(Json.toJson(SuccessResponse(e)))
    }
  }
  
  def create = Action(parse.json) { request =>
    val incomingBody = request.body.validate[Course]
    
    incomingBody.fold(error => {
      val errorMessage = s"Invalid JSON: ${error}"
      val response = ErrorResponse(ErrorResponse.INVALID_JSON, errorMessage)
      BadRequest(Json.toJson(response))
    }, { course =>
      // save course and get a copy back
      val createdCourse: Course = ???
      
      Created(Json.toJson(SuccessResponse(createdCourse)))
    })
  }
  
  
}