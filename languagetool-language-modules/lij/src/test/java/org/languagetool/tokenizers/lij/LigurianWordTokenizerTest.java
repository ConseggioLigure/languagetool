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

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LigurianWordTokenizerTest {

  @Test
  public void testTokenize() {
    LigurianWordTokenizer tokenizer = new LigurianWordTokenizer();
    for (String apostrophe : List.of("'", "’")) {
      assertEquals(List.of("d" + apostrophe, "Italia"), tokenizer.tokenize("d" + apostrophe + "Italia"));
      assertEquals(List.of(apostrophe + "n", " ", "amigo"), tokenizer.tokenize(apostrophe + "n amigo"));
      assertEquals(List.of(apostrophe + "n" + apostrophe, "amiga"), tokenizer.tokenize(apostrophe + "n" + apostrophe + "amiga"));
    }
    assertEquals(List.of("cös’", " ", "co\u0308s'"), tokenizer.tokenize("cös’ co\u0308s'"));
    assertEquals(List.of("a-e", " ", "https://example.com", " ", "name@example.com", "."),
        tokenizer.tokenize("a-e https://example.com name@example.com."));
  }
}
