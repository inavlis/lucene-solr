package org.apache.solr.ltr.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.solr.common.params.SolrParams;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class LTRUtils {

  /**
   * Given a set of local SolrParams, extract all of the efi.key=value params into a map
   * @param localParams Local request parameters that might conatin efi params
   * @return Map of efi params, where the key is the name of the efi param, and the
   *  value is the value of the efi param
   */
  public static Map<String,String> extractEFIParams(SolrParams localParams) {
    final Map<String,String> externalFeatureInfo = new HashMap<>();
    for (final Iterator<String> it = localParams.getParameterNamesIterator(); it
        .hasNext();) {
      final String name = it.next();
      if (name.startsWith(CommonLTRParams.EXTERNAL_FEATURE_INFO)) {
        externalFeatureInfo.put(
            name.substring(CommonLTRParams.EXTERNAL_FEATURE_INFO.length()),
            localParams.get(name));
      }
    }
    return externalFeatureInfo;
  }

}
