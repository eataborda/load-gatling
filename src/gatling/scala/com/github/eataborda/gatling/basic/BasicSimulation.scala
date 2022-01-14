package com.github.eataborda.gatling.basic

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._

class BasicSimulation extends Simulation {
  val httpProtocol: HttpProtocolBuilder = http.baseUrl("http://computer-database.gatling.io")
  val requestHeaders = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
    "Accept-Encoding" -> "gzip, deflate",
    "Accept-Language" -> "en-US,en;q=0.5",
    "Content-Type" -> "application/json",
    "User-Agent" -> "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0"
  )

  val getDellComputersScenario: ScenarioBuilder = scenario("Get Dell computers")
    .exec(
      http("get_dell_computers")
        .get("/computers")
        .headers(requestHeaders)
        .queryParam("f","dell")
        .check(status is 200)
    )

  setUp(
    getDellComputersScenario.inject(
      nothingFor(3.seconds),
      atOnceUsers(2),
      rampUsers(20).during(10.seconds)
    ).protocols(httpProtocol))

}
