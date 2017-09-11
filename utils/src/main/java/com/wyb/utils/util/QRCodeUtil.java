package com.wyb.utils.util;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * QRCodeUtil
 *
 * @author FE
 * @date 2016/7/29
 */
public class QRCodeUtil {


    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(QRCodeUtil.class);

    /**
     * 生成图像
     *
     * @throws WriterException
     * @throws IOException
     */
    public static String writeCode(String filePath, String content) {
        try {
            String _SUB_DIR = StringUtils.join(FileUtil.separator, "qrcode", FileUtil.separator, DateUtil.formatSimple(new Date(), DateUtil.FORMAT_YYYYMMDD));
            filePath = StringUtils.join(filePath, _SUB_DIR);
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            String fileName = StringUtils.join(UUID.randomUUID().toString().replace("-", ""), ".png");
            int width = 200; // 图像宽度
            int height = 200; // 图像高度
            String format = "png";// 图像类型
            Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
            Path path = FileSystems.getDefault().getPath(filePath, fileName);
            MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像
            return StringUtils.join(_SUB_DIR, FileUtil.separator, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析图像
     */
    public static JSONObject decodeQRinfo(String filePath) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(filePath));
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码
            JSONObject content = JSONObject.parseObject(result.getText());
            return content;
//            System.out.println("图片中内容：  ");
//            System.out.println("author： " + content.getString("author"));
//            System.out.println("zxing：  " + content.getString("zxing"));
//            System.out.println("图片中格式：  ");
//            System.out.println("encode： " + result.getBarcodeFormat());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
