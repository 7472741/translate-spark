/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql

import java.util.{List => JList, Map => JMap}

import org.apache.spark.Accumulator
import org.apache.spark.api.python.PythonBroadcast
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.catalyst.expressions.{Expression, ScalaUdf}
import org.apache.spark.sql.execution.PythonUDF

import scala.reflect.runtime.universe.{TypeTag, typeTag}

/**
 * Functions for registering scala lambda functions as UDFs in a SQLContext.
 */
private[sql] trait UDFRegistration {
  self: SQLContext =>

  private[spark] def registerPython(
      name: String,
      command: Array[Byte],
      envVars: JMap[String, String],
      pythonIncludes: JList[String],
      pythonExec: String,
      broadcastVars: JList[Broadcast[PythonBroadcast]],
      accumulator: Accumulator[JList[Array[Byte]]],
      stringDataType: String): Unit = {
    log.debug(
      s"""
        | Registering new PythonUDF:
        | name: $name
        | command: ${command.toSeq}
        | envVars: $envVars
        | pythonIncludes: $pythonIncludes
        | pythonExec: $pythonExec
        | dataType: $stringDataType
      """.stripMargin)


    val dataType = parseDataType(stringDataType)

    def builder(e: Seq[Expression]) =
      PythonUDF(
        name,
        command,
        envVars,
        pythonIncludes,
        pythonExec,
        broadcastVars,
        accumulator,
        dataType,
        e)

    functionRegistry.registerFunction(name, builder)
  }

  /** registerFunction 1-22 were generated by this script

    (1 to 22).map { x =>
      val types = (1 to x).map(x => "_").reduce(_ + ", " + _)
      s"""
        def registerFunction[T: TypeTag](name: String, func: Function$x[$types, T]): Unit = {
          def builder(e: Seq[Expression]) =
            ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
          functionRegistry.registerFunction(name, builder)
        }
      """
    }
  */

  // scalastyle:off
  def registerFunction[T: TypeTag](name: String, func: Function1[_, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function2[_, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function3[_, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function4[_, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function5[_, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function6[_, _, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function7[_, _, _, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function8[_, _, _, _, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function9[_, _, _, _, _, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function10[_, _, _, _, _, _, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function11[_, _, _, _, _, _, _, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function12[_, _, _, _, _, _, _, _, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function13[_, _, _, _, _, _, _, _, _, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function14[_, _, _, _, _, _, _, _, _, _, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function15[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function16[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function17[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function18[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function19[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function20[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function21[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }

  def registerFunction[T: TypeTag](name: String, func: Function22[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, T]): Unit = {
    def builder(e: Seq[Expression]) = ScalaUdf(func, ScalaReflection.schemaFor[T].dataType, e)
    functionRegistry.registerFunction(name, builder)
  }
  // scalastyle:on
}
