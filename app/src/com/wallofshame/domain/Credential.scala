package com.wallofshame.domain

object Credential {
  var usr = ""
  var pass = ""

  def username = {
    usr
  }

  def pwd = {
    pass
  }

  def save(username: String, pwd: String) {
    usr = username
    pass = pwd
  }

  def isEmpty = {
    usr == "" || pass == ""
  }
}