package com.aczuleta.teams.prediction.system.models

import com.aczuleta.teams.prediction.system.entities.{Player,Team,PlayerUpdate}
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent._
import io.getquill._


object db {

  lazy val ctx = new MysqlAsyncContext(SnakeCase, "db.default")

  import ctx._


  def getTeams: Future[List[Team]] =  {
    val s = quote {
      infix"select team,  AVG(score) as score from  player GROUP BY team".as[Query[Team]]
    }
    ctx.run(s)
  }


  def getPlayersByTeam(teamName:String = "Real Madrid CF") = {
    println("Getting players from: " + teamName)
    val f = quote{
      query[Player].filter(_.team == lift(teamName))
    }

    ctx.run(f)
  }

  def updatePlayer(idp:Int = 0, scorep:Int = 0): Future[Any] = {
    println("Player Updated!")
    val q = quote {
      query[Player].filter(_.id == lift(idp) ).update(_.score -> lift(scorep))
    }

    ctx.run(q)
  }

}