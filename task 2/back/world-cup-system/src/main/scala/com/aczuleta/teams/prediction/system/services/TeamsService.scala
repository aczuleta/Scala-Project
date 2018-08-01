package com.aczuleta.teams.prediction.system.services

import com.aczuleta.teams.prediction.system.entities.{Player, PlayerUpdate,Team}
import com.aczuleta.teams.prediction.system.models.db

import scala.concurrent.duration.Duration
import scala.concurrent._



class TeamsService(implicit val executionContext: ExecutionContext) {

  var teams = Vector.empty[Team]
  var cachePlayers = scala.collection.mutable.Map[String, List[Player]]()
  var cacheTeams = List[Team]()


  def getPlayers(name:String):List[Player] = {
    if(cachePlayers.contains(name)){
        println("We are getting the players from the cache")
        return cachePlayers(name)
    } else {
      println("We are getting the players from the database")
      var result = Await.result(db.getPlayersByTeam(name), Duration.Inf)
      cachePlayers+=  (name -> result)
      return result
    }
  }

  def getTeams():List[Team] = {
    if(cacheTeams.isEmpty){
      println("We are getting the teams from the database")
      cacheTeams = Await.result(db.getTeams, Duration.Inf)
      return cacheTeams
    } else {
      println("We are getting the teams from the cache")
      return  cacheTeams

    }
  }


  def updatePlayer(update: PlayerUpdate):Future[Any] = {
    println("We need to delete the cache since we are updatign everything")
    cachePlayers.clear()
    cacheTeams = List[Team]()
    return db.updatePlayer(update.id, update.score)
  }
  
}

