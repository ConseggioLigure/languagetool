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
package org.languagetool.rules.lij;

import org.junit.Test;
import org.languagetool.JLanguageTool;
import org.languagetool.Languages;
import org.languagetool.rules.patterns.PatternRuleTest;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LigurianPatternRuleTest extends PatternRuleTest {

  @Test
  public void testRules() throws IOException {
    runGrammarRulesFromXmlTest();
  }

  @Test
  public void testLanguage() throws IOException {
    JLanguageTool tool = new JLanguageTool(Languages.getLanguageForShortCode("lij"));
    assertEquals(0, tool.check("Son nasciuo à Zena.").size());
    assertEquals(1, tool.check("Son nasciuo  à Zena.").size());
    assertEquals(0, tool.check("Boñaseia, mondo!").size());
    assertEquals(1, tool.check("Boñaseia,, mondo!").size());
  }
}
