package com.wallofshame.controller

import org.springframework.stereotype.Controller
import org.springframework.web.servlet.ModelAndView
import collection.JavaConversions
import com.wallofshame.domain.{Credential, PeopleMissingTimeSheet}
import org.springframework.web.bind.annotation.{ModelAttribute, PathVariable, RequestMethod, RequestMapping}
import javax.servlet.http.HttpServletRequest

@Controller
class ShameController {
  @RequestMapping(value = Array("/{country}.html"), method = Array(RequestMethod.GET))
  def index(@PathVariable country: String) = {
    if (Credential.isEmpty) {
      new ModelAndView("login")
    } else {
      new ModelAndView("index",
        JavaConversions.asJavaMap(Map(
          "names" -> JavaConversions.asJavaList(PeopleMissingTimeSheet.names(country)),
          "country" -> country.toLowerCase.replaceAll("\\s", "")
        )))
    }
  }

  @RequestMapping(value = Array("/login.html"), method = Array(RequestMethod.GET))
  def login = {
    new ModelAndView("login")
  }

  @RequestMapping(value = Array("/login.html"), method = Array(RequestMethod.POST))
  def save(request:HttpServletRequest){
     Credential.save(request.getParameter("username"), request.getParameter("password"))
    "redirect:/wallofshame/china"
  }
}