package com.wallofshame.domain

import com.gargoylesoftware.htmlunit.WebClient
import com.gargoylesoftware.htmlunit.html._

class LoginPage(browser:WebClient, credential:Credential.type) {

  def login = {
    val page: HtmlPage = this.browser.getPage("http://psfs89.thoughtworks.com/psp/fsprd89/?cmd=login&languageCd=ENG")
    val form: HtmlForm = page.getFormByName("login")

    val userId: HtmlTextInput = form.getInputByName("userid")
    val pwd: HtmlPasswordInput = form.getInputByName("pwd")
    val signIn: HtmlSubmitInput = form.getInputByValue("Sign In")
    userId.setValueAttribute(Credential.username)
    pwd.setValueAttribute(Credential.pwd)
    val dashboard:HtmlPage  = signIn.click()
    dashboard
  }
}