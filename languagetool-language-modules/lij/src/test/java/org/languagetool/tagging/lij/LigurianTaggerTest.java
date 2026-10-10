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

import org.junit.Test;
import org.languagetool.TestTools;
import org.languagetool.language.Ligurian;
import org.languagetool.tagging.Tagger;
import org.languagetool.tokenizers.Tokenizer;

import java.io.IOException;

public class LigurianTaggerTest {

  @Test
  public void testTagger() throws IOException {
    Ligurian language = new Ligurian();
    Tagger tagger = language.getTagger();
    Tokenizer tokenizer = language.getWordTokenizer();

    TestTools.myAssert("son",
        "son/[son]NOUN Gender=Masc Number=Sing|son/[ëse]VERB Mood=Ind Number=Plur Person=3 Tense=Pres VerbForm=Fin|son/[ëse]VERB Mood=Ind Number=Sing Person=1 Tense=Pres VerbForm=Fin",
        tokenizer, tagger);
    TestTools.myAssert("Boñaseia, Zena!",
        "Boñaseia/[boñaseia]INTJ|Boñaseia/[boñaseia]NOUN Gender=Fem Number=Coll -- Zena/[Zena]PROPN Gender=Fem Number=Sing|Zena/[Zena]PROPN Gender=Masc Number=Sing",
        tokenizer, tagger);
    TestTools.myAssert("’N’amiga",
        "’N’/[un]DET Definite=Ind Gender=Fem Number=Sing PronType=Art -- amiga/[amigo]NOUN Gender=Fem Number=Sing", tokenizer, tagger);
    TestTools.myAssert("st'atro",
        "st'/[sto]DET Deixis=Prox Gender=Fem Number=Sing PronType=Dem|st'/[sto]DET Deixis=Prox Gender=Masc Number=Sing PronType=Dem -- atro/[atro]DET Gender=Masc Number=Sing PronType=Ind|atro/[atro]PRON Gender=Masc Number=Sing PronType=Ind",
        tokenizer, tagger);
    TestTools.myAssert("’n òmmo",
        "’n/[un]DET Definite=Ind Gender=Masc Number=Sing PronType=Art -- òmmo/[òmmo]NOUN Gender=Masc Number=Sing", tokenizer, tagger);
    TestTools.myAssert("a-e",
        "a-e/[a-o]ADP+DET Definite=Def Gender=Fem Number=Plur PronType=Art", tokenizer, tagger);
    TestTools.myAssert("sciâ",
        "sciâ/[sciâ]NOUN Gender=Fem Number=Sing|sciâ/[sciâ]VERB Gender=Fem Number=Sing Tense=Past VerbForm=Part|sciâ/[sciâ]VERB VerbForm=Inf|sciâ/[sciô]ADP+DET Definite=Def Gender=Fem Number=Sing PronType=Art",
        tokenizer, tagger);
    TestTools.myAssert("addesciæmelo",
        "addesciæmelo/[addesciâ]VERB Mood=Imp Number=Plur Person=2 Tense=Pres VerbForm=Fin WithClitics=melo", tokenizer, tagger);
    TestTools.myAssert("xyzzy", "xyzzy/[null]null", tokenizer, tagger);
  }
}
