/**
 * Copyright 2013 Automatak, LLC
 *
 * Licensed to Automatak, LLC (www.automatak.com) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. Automatak, LLC
 * licenses this file to you under the Apache License Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.automatak.render.cpp

import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import com.automatak.render.{EnumValue, EnumModel}

@RunWith(classOf[JUnitRunner])
class EnumGeneratorTestSuite extends FunSuite with ShouldMatchers {

  test("Simple output") {

     val values = List(EnumValue("red", Some("2")), EnumValue("green"), EnumValue("blue"))
     val eg = EnumModel("Colors", Some(EnumModel.UInt8), values)

     EnumModelRenderer(eg).toList should equal(
       List(  "enum class Colors : uint8_t",
              "{",
              "red = 2,",
              "green,",
              "blue",
              "};"
       ))

  }

}