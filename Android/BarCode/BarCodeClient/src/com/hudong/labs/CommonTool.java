package com.hudong.labs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import android.graphics.Bitmap;
import android.util.Log;

public class CommonTool {
	public static boolean hexStringToDeser(String hexString, File destFile) {
		boolean result = true;
		try {
			byte[] hexByte = HexUtil.hexStringToBytes(hexString);
			deserialize(hexByte, destFile);

		} catch (Exception e) {
			result = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 序列化和反序列化
	public static byte[] serialize(Bitmap b) {
		try {
			ByteArrayOutputStream mem_out = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(mem_out);

			out.writeObject(b);

			out.close();
			mem_out.close();

			byte[] bytes = mem_out.toByteArray();
			return bytes;
		} catch (IOException e) {
			return null;
		}
	}

	public static void deserialize(byte[] bytes, File f) {
		try {

			byte[] buffer = new byte[1024 * 4];
			int len = -1;
			ByteArrayInputStream mem_in = new ByteArrayInputStream(bytes);

			FileOutputStream outStream = new FileOutputStream(f);
			while ((len = mem_in.read(buffer)) != -1) {
				outStream.write(buffer, 0, len);
			}
			outStream.flush();
			outStream.close();
			mem_in.close();

		} catch (StreamCorruptedException e) {
			Log.e("CT", e.getMessage(), e);
		} catch (IOException e) {
			Log.e("CT", e.getMessage(), e);
		}
	}

	// 切割字符串
	public static String[] splitStrings(String[] aa) {
		return null;
	}
}
