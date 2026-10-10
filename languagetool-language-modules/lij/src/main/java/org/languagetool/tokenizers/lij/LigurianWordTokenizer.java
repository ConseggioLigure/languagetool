/* LanguageTool, a natural language style checker
 * Copyright (C) 2026 the LanguageTool contributors
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301
 * USA
 */
package org.languagetool.tokenizers.lij;

import org.languagetool.tokenizers.WordTokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LigurianWordTokenizer extends WordTokenizer {

  private static final List<String> APOSTROPHES = List.of("'", "’");
  private static final Pattern WORD = Pattern.compile("[\\p{L}\\p{M}\\p{N}_]+(?:-[\\p{L}\\p{M}\\p{N}_]+)*|['’][nN]");

  @Override
  public List<String> tokenize(String text) {
    List<String> tokens = super.tokenize(text);
    List<String> result = new ArrayList<>();
    for (int i = 0; i < tokens.size(); i++) {
      String token = tokens.get(i);
      if (APOSTROPHES.contains(token) && i + 1 < tokens.size() && tokens.get(i + 1).equalsIgnoreCase("n")) {
        token += tokens.get(++i);
      }
      if (WORD.matcher(token).matches() && i + 1 < tokens.size() && APOSTROPHES.contains(tokens.get(i + 1))) {
        token += tokens.get(++i);
      }
      result.add(token);
    }
    return result;
  }
}
