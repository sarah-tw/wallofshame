package com.wallofshame

import domain.WallOfShameParser
import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import service.UpdateWallOfShameService
import org.joda.time.DateTime

class UpdateWallOfShameServiceTest extends Spec with ShouldMatchers {
  describe("analyse the builds") {
    it("should handle the friday correctly") {
     val dateTime:DateTime = new DateTime(2011, 6, 17, 0, 0, 0, 0);
     val date:String = new UpdateWallOfShameService().lastSunDay(dateTime)
     date should be === "06/12/2011"
    }
    
    it("should handle the monday builds correctly") {
     val dateTime:DateTime = new DateTime(2011, 6, 13, 0, 0, 0, 0);
     val date:String = new UpdateWallOfShameService().lastSunDay(dateTime)
     date should be === "06/12/2011"
    }
    
    it("should handle the cross month date") {
     val dateTime:DateTime = new DateTime(2011, 6, 1, 0, 0, 0, 0);
     val date:String = new UpdateWallOfShameService().lastSunDay(dateTime)
     date should be === "05/29/2011"
    }
  }
}