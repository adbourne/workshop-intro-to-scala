package com.awaddell.demo.domain.animal

import play.api.libs.json.Json

object RhinoWithTemp { implicit val JsonFormat = Json.format[RhinoWithTemp] }
case class RhinoWithTemp(rhino: Rhinoceros, temperatureInDegC: Double)
