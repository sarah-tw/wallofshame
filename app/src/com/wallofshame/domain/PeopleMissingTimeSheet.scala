package com.wallofshame.domain

import collection.mutable.HashMap

object PeopleMissingTimeSheet {
  var peopleMissingTimeSheet: HashMap[String, List[String]]
            =  new HashMap[String, List[String]]() {
    override def default(key:String) = List[String]();
  }

  def names(key:String) = {
    peopleMissingTimeSheet(key)
  }

  def names(namesToAdd:HashMap[String, List[String]]) {
    peopleMissingTimeSheet = namesToAdd
  }
}