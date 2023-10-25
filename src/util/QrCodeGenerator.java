/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author rayen
 */
public class QrCodeGenerator {
    public static boolean GenerateQrCode(String text,int id){
        String filePath="C:\\Users\\rayen\\Desktop\\PiDevVoyage\\src\\qrcode\\Assurance"+id+".png";
        // QR code dimensions.
        int size = 90;

        // Image format to be used.
        String fileType = "png";
        File myFile = new File(filePath);

        try {
            // Configuration map for QR code encoding.
            Map<EncodeHintType, Object> hintMap = new EnumMap<>(EncodeHintType.class);
            hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hintMap.put(EncodeHintType.MARGIN, 0);  // White border size
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);  // Error correction level

            // Initialize QR code writer.
            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            // Encode the text into a QR code.
            BitMatrix byteMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, size, size, hintMap);

            // Get the width for our image from the generated BitMatrix.
            int imageWidth = byteMatrix.getWidth();

            // Create an empty image with the specified width.
            BufferedImage image = new BufferedImage(imageWidth, imageWidth, BufferedImage.TYPE_INT_RGB);
            
            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, imageWidth, imageWidth);  // Fill the entire image with white
            graphics.setColor(Color.BLACK);

            // Draw the black pixels of the QR code onto our image.
            for (int i = 0; i < imageWidth; i++) {
                for (int j = 0; j < imageWidth; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }

            // Save the image to file.
            ImageIO.write(image, fileType, myFile);
        } catch (WriterException e) {
            e.printStackTrace();
            return false;  // Return false if there's an error in QR code generation
        } catch (IOException e) {
            e.printStackTrace();
            return false;  // Return false if there's an error in saving the file
        }

        System.out.println("\n\nYou have successfully created QR Code.");
        return true;  // Return true if QR code is generated and saved successfully
    }

}
