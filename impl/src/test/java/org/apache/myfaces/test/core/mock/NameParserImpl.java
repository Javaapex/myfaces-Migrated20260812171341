/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.myfaces.test.core.mock;

import jakarta.naming.CompositeName;
import jakarta.naming.Name;
import jakarta.naming.NameParser;
import jakarta.naming.NamingException;

/**
 * A default implementation of {@link NameParser}
 *
 * NOTE: Code copied from org.apache.xbean.spring.jndi.NameParserImpl
 *
 * @version $Revision: 1.2 $
 */
public class NameParserImpl implements NameParser
{

    public Name parse(String name) throws NamingException
    {
        return new CompositeName(name);
    }
}
