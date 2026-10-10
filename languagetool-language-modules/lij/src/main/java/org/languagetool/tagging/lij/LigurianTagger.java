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
package org.languagetool.tagging.lij;

import org.languagetool.tagging.BaseTagger;
import org.languagetool.tagging.WordTagger;

import java.util.Locale;

public class LigurianTagger extends BaseTagger {

  public LigurianTagger() {
    super("/lij/ligurian.dict", new Locale("lij"));
  }

  @Override
  protected WordTagger getWordTagger() {
    return word -> wordTagger.tag(word.replace('’', '\''));
  }
}
