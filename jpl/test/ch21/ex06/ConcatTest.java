package ch21.ex06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Test;

public class ConcatTest {

	@Test
	public void catTest() {

		// Concat concat = new Concat();

		Concat.cat(new ByteArrayInputStream(new byte[] { 0x00 }), new ByteArrayInputStream(new byte[] { 0x01 }));

		try {
			assertThat(0x00, is(Concat.in.read()));
			assertThat(0x01, is(Concat.in.read()));
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
