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
package org.languagetool.language;

import org.jetbrains.annotations.Nullable;
import org.languagetool.Language;
import org.languagetool.UserConfig;
import org.languagetool.rules.DoublePunctuationRule;
import org.languagetool.rules.MultipleWhitespaceRule;
import org.languagetool.rules.Rule;

import java.util.List;
import java.util.ResourceBundle;

public class Ligurian extends Language {

  @Override
  public String getName() {
    return "Ligurian";
  }

  @Override
  public String getShortCode() {
    return "lij";
  }

  @Override
  public String[] getCountries() {
    return new String[]{"IT", "MC"};
  }

  @Override
  public Contributor[] getMaintainers() {
    return new Contributor[]{new Contributor("Jean Maillard")};
  }

  @Nullable
  @Override
  public String getCommonWordsPath() {
    return null;
  }

  @Override
  public List<Rule> getRelevantRules(ResourceBundle messages, UserConfig userConfig, Language motherTongue, List<Language> altLanguages) {
    return List.of(
        new DoublePunctuationRule(messages),
        new MultipleWhitespaceRule(messages, this)
    );
  }
}
