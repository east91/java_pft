package com.stqa.pft.sand;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testArea() {
    Point p2 = new Point(10, 20);
    Point p1 = new Point(30, 40);
    Assert.assertEquals(p2.distance(p1), 28.284271247461902);
  }
}
