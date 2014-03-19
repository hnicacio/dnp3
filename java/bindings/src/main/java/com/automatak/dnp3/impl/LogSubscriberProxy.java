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
package com.automatak.dnp3.impl;


import com.automatak.dnp3.LogSubscriber;

public final class LogSubscriberProxy {

    private LogSubscriber subscriber;

    public LogSubscriberProxy(LogSubscriber subscriber)
    {
        this.subscriber = subscriber;
    }

    public void onLogEntry(int filter, String name, String message, int errorCode)
    {
        LogEntryImpl entry = new LogEntryImpl(filter, name, message, errorCode);
        subscriber.onLogEntry(entry);
    }

}
