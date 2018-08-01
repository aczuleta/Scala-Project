package com.aczuleta.teams.prediction.system

import scala.concurrent.ExecutionContext

import akka.http.scaladsl.server.Route
import com.aczuleta.teams.prediction.system.resources.TeamsResource
import com.aczuleta.teams.prediction.system.services.TeamsService


trait RestInterface extends Resources {

  implicit def executionContext: ExecutionContext

  lazy val teamService = new TeamsService

  val routes: Route = TeamsRoutes

}

trait Resources extends TeamsResource

