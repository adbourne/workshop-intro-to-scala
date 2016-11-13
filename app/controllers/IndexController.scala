package controllers

import javax.inject._

import play.api.mvc._


@Singleton
class IndexController @Inject() extends Controller {


  def index = Action{
    Ok(views.html.index())
  }

}
