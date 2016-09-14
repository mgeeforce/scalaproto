package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.routing.JavaScriptReverseRouter


/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    //val ticketsAvailable = 1000
    Ok(views.html.index())
  }
  
  def jsRoutes = Action { implicit request =>
  Ok(
    JavaScriptReverseRouter("jsRoutes")(
      routes.javascript.Tickets.ticketsAvailable
    )
  )
}

}
