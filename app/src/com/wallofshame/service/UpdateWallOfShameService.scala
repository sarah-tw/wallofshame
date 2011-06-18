package com.wallofshame.service

import org.springframework.stereotype.Service
import java.util.TimerTask
import com.gargoylesoftware.htmlunit.WebClient
import com.wallofshame.domain._
import com.gargoylesoftware.htmlunit.html.HtmlPage
import org.joda.time.DateTime
import org.joda.time.DateTime.Property
import org.joda.time.format.{DateTimeFormat}

@Service
class UpdateWallOfShameService extends TimerTask {
  override def run() {
    val webClient: WebClient = new WebClient()
    val login: HtmlPage = new LoginPage(webClient, Credential).login
    val text: String = new QueryPage(webClient, "06/12/2011").query
    PeopleMissingTimeSheet.names(
      WallOfShameParser.peopleMissedTimeSheet(text))
  }

  def lastSunDay(dateTime: DateTime) = {
    val property: Property = dateTime.dayOfWeek()
    val days: DateTime = dateTime.minusDays(property.get())
    days.toString(DateTimeFormat.forPattern("MM/dd/yyyy"));
  }
}