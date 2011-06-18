package com.wallofshame.domain

import com.gargoylesoftware.htmlunit.WebClient
import com.gargoylesoftware.htmlunit.html._

class QueryPage(browser: WebClient, dateStr:String ) {
  def query = {
    val page2: HtmlPage = this.browser.getPage("http://psfs89.thoughtworks.com/psc/fsprd89_1/EMPLOYEE/ERP/q/?ICAction=ICQryNameURL=PUBLIC.TW_UTIL_TIME_MISSING_DETAIL")
    var queryForm: HtmlForm = page2.getFormByName("win1")
    val date: HtmlTextInput = queryForm.getInputByName("InputKeys_TW_WEEK_END_DT")
    val dept: HtmlTextInput = queryForm.getInputByName("InputKeys_DEPTID")
    date.setValueAttribute(dateStr)
    dept.setValueAttribute("01")
    val viewResult: HtmlButtonInput = queryForm.getInputByValue("View Results")
    var result: HtmlPage = viewResult.click()
    try {
      val viewAll: HtmlAnchor = result.getAnchorByText("View All")
      result = viewAll.click()
    } catch {
      case e =>
    }
    result.asText()
  }
}