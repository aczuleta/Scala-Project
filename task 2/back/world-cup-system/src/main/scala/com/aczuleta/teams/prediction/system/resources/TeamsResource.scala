package com.aczuleta.teams.prediction.system.resources

import akka.http.scaladsl.server.Route
import com.aczuleta.teams.prediction.system.entities.PlayerUpdate
import com.aczuleta.teams.prediction.system.services.TeamsService
import com.aczuleta.teams.prediction.system.routing.MyResource
import com.aczuleta.teams.prediction.system.routing.CORSHandler

trait TeamsResource extends MyResource with CORSHandler {

  val teamService: TeamsService
  def TeamsRoutes: Route = pathPrefix("teams") {
    pathEnd {

      corsHandler(
      get {
        complete(teamService.getTeams())
      } ~
        put {
          entity(as[PlayerUpdate]) { update =>
            complete(teamService.updatePlayer(update))
          }
        })
    } ~
      path(Segment) { id =>
        corsHandler(
        get {
          complete(teamService.getPlayers(id))
        })
      }

  }
}

