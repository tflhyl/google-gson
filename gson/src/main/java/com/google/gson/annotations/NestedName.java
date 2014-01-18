/*
 * Copyright (C) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gson.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation that indicates this member should be deserialized from nested JSON object.
 *
 * <p/>
 * <p>Here is an example of how this annotation is meant to be used:</p>
 * <pre>
 * public class Employee {
 *   &#64NestedName(parent = "person", value = "name") private final String name;
 *   &#64NestedName(parent = "person", value = "age") private final int age;
 *   private final String department;
 *
 *   public Employee() { }
 *
 *   public String toString() {
 *       return name + ", " + age + ", " + department;
 *   }
 *
 * }
 * </pre>
 * <p/>
 * <p>The following shows the output that is generated when deserializing JSON:</p>
 * <pre>
 *     String json = "{\"person\" : { \"name\" : \"John\", \"age\" : 21}, \"department\" : \"IT\"}";
 *     Gson gson = new Gson();
 *     Employee employee = gson.fromJson(json, Employee.class);
 *     System.out.println(employee.toString);
 *
 * ===== OUTPUT =====
 * "John, 21, IT"
 * </pre>
 * <p/>
 * <p>NOTE: The value you specify in this annotation must be a valid JSON field name.</p>
 *
 * @author tfleo
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NestedName {

    String value();
    public String parent();
}
