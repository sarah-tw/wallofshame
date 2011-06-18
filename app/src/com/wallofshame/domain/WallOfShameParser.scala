package com.wallofshame.domain

import com.wallofshame.LogHelper
import collection.mutable.HashMap


object WallOfShameParser extends LogHelper {
  def peopleMissedTimeSheet(textToParse: String) = {
    var shameOnYou = new HashMap[String, List[String]]() {
      override def default(key: String) = List[String]()
    }
    val pattern = """\d+\s+(Australia|Brazil|Canada West|China|ETG|India|US Central|US East|US West)\s+(.+)"""
    val MissingTimeSheetPeople = pattern.r
    for (personMissingSheet <- textToParse.split("\n")) {
      try {
        val MissingTimeSheetPeople(captured, nameOfPerson) = personMissingSheet
        var countryName = captured.toLowerCase.replaceAll("\\s", "");
        var names: List[String] = shameOnYou(countryName)
        shameOnYou += (countryName -> names.:::(List(nameOfPerson)))
      } catch {
        case e =>
      }
    }
    shameOnYou
  }
}