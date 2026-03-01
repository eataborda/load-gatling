package com.github.eataborda.gatling.example

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration.DurationInt

class StressSimulation extends Simulation {
  val httpProtocol: HttpProtocolBuilder = http.baseUrl("http://computer-database.gatling.io")
  val requestHeaders = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
    "Accept-Encoding" -> "gzip, deflate",
    "Accept-Language" -> "en-US,en;q=0.5",
    "Content-Type" -> "application/json",
    "User-Agent" -> "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0"
  )
  val getThinkpadComputersScenario: ScenarioBuilder = scenario("Get Thinkpad computers")
    .exec(
      http("get_ibm_computers")
        .get("/computers")
        .headers(requestHeaders)
        .queryParam("f", "thinkpad")
        .check(status is 200)
    )

  setUp(
    getThinkpadComputersScenario.inject(
      nothingFor(5.seconds),
      incrementUsersPerSec(2)
        .times(5)
        .eachLevelLasting(10.seconds)
        .separatedByRampsLasting(5.seconds)
        .startingFrom(2)
    ).protocols(httpProtocol)
  )
}
