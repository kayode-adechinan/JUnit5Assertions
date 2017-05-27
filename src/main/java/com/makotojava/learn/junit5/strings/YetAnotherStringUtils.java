/*
 * Copyright 2017 Makoto Consulting Group, Inc.
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
 *
 */
package com.makotojava.learn.junit5.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Yet Another String Utils class. Exactly what the
 * world needed, right?
 * 
 * @author J Steven Perry
 *
 */
public class YetAnotherStringUtils {

  /**
   * Tokenize the specified string parameter, delimited by
   * the specified delimiters, and return the tokens in a
   * List&lt;String&gt;
   * 
   * @param string
   *          The string to tokenize
   * 
   * @param delimiters
   *          The delimiters that are used to break the string up into tokens.
   * 
   * @return List&lt;String&gt; - the List of Strings, one List element per token. The List will be empty if no tokens
   *         were found.
   */
  public static List<String> tokenize(String string, String delimiters) {
    List<String> ret = new ArrayList<>();

    StringTokenizer strtok = new StringTokenizer(string, delimiters);
    while (strtok.hasMoreTokens()) {
      ret.add(strtok.nextToken());
    }

    return ret;
  }
}
