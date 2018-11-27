package com.techarchnotes

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class UserLoginSimulation extends Simulation {
  val httpConf = http.baseUrl("http://localhost:8080/")

  val twoMinutesEverySecond = scenario("User logs in 1 req / s for two minutes")
    .during(2 minutes) {
      exec(http("user login")
        .get("user/login"))
        .pause(1 second)
    }


  val fiveMinutesEverySecondFor10Users = scenario("User logs in 10 req / s for five minutes")
    .during(5 minutes) {
      exec(http("user login")
        .get("user/login"))
        .pause(1 second)
    }

  val fourMinutesEverySecond = scenario("User logs in 2 req / s for four minutes")
    .during(4 minutes) {
      exec(http("user login")
        .get("user/login"))
        .pause(1 second)
    }

  val fiveMinutesEverySecondFor100Users = scenario("User logs in 100 req / s for five minutes")
    .during(5 minutes) {
      exec(http("user login")
        .get("user/login"))
        .pause(1 second)
    }

  setUp( // 16 minutes = 960 seconds total
    twoMinutesEverySecond.inject(atOnceUsers(1)), // 2 minutes
    fiveMinutesEverySecondFor10Users.inject(nothingFor(2 minutes), atOnceUsers(10)), // 5 minutes
    fourMinutesEverySecond.inject(nothingFor(7 minutes), atOnceUsers(2)), // 4 minutes,
    fiveMinutesEverySecondFor100Users.inject(nothingFor(11 minutes), atOnceUsers(100)) // 5 minutes
  ).protocols(httpConf)
}