package com.wallofshame

import domain.{QueryPage, Credential, LoginPage}
import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import com.gargoylesoftware.htmlunit.WebClient
import com.gargoylesoftware.htmlunit.html.HtmlPage

class QueryTest extends Spec with ShouldMatchers {
  describe("analyse the builds") {
    it("should handle the friday correctly") {
      val webClient: WebClient = new WebClient()
      val login: HtmlPage = new LoginPage(webClient, Credential).login
      val text: String = new QueryPage(webClient, "06/19/2011").query
      print(text)
    }

  }
}