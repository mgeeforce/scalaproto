package controllers

import play.api.mvc._
import play.api.libs.json.Json

import io.adeptus.proto.TeeSheet
import controllers.responses._

class TeeSheets extends Controller {
  
  def list = Action { request =>
    val teeSheets: Seq[TeeSheet] = ???
    Ok(Json.toJson(SuccessResponse(teeSheets)))
  }
  
  def getById(teeSheetId: Long) = Action { request =>
    val teeSheet: Option[TeeSheet] = ???
    teeSheet.fold {
      NotFound(Json.toJson(ErrorResponse(NOT_FOUND, "No tee sheet found")))
    } { e =>
      Ok(Json.toJson(SuccessResponse(e)))
    }
  }
  
  def create = Action(parse.json) { request =>
    val incomingBody = request.body.validate[TeeSheet]
    
    incomingBody.fold(error => {
      val errorMessage = s"Invalid JSON: ${error}"
      val response = ErrorResponse(ErrorResponse.INVALID_JSON, errorMessage)
      BadRequest(Json.toJson(response))
    }, { teeSheet =>
      // save course and get a copy back
      val createdTeeSheet: TeeSheet = ???
      
      Created(Json.toJson(SuccessResponse(createdTeeSheet)))
    })
  }
  
  
}