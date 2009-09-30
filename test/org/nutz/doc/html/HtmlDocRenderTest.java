package org.nutz.doc.html;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.nutz.doc.meta.ZDoc;
import org.nutz.doc.zdoc.ZDocParser;
import org.nutz.lang.Files;
import org.nutz.lang.Lang;
import org.nutz.lang.Streams;
import org.nutz.lang.Strings;

public class HtmlDocRenderTest {

	private static String render(String name) {
		File src = Files.findFile("org/nutz/doc/html/" + name + "/src.zdoc");
		String s = Lang.readAll(Streams.fileInr(src));
		ZDocParser parser = new ZDocParser();
		ZDoc doc = parser.parse(s);
		HtmlDocRender render = new HtmlDocRender();
		return Strings.trim(render.render(doc).toString()).replace("\r", "");

	}

	private static String expect(String name) {
		File expect = Files.findFile("org/nutz/doc/html/" + name + "/expect.html");
		return Strings.trim(Lang.readAll(Streams.fileInr(expect))).replace("\r", "");
	}

	@Test
	public void t1() {
		String actual = render("t1");
		String expect = expect("t1");
		assertEquals(expect, actual);
	}

}
