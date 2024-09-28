package Utility;


import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
//import org.monte.media.Codec;
//import static org.monte.media.FormatKeys.FrameRateKey;
//import static org.monte.media.FormatKeys.MIME_QUICKTIME;
//import org.monte.media.MovieWriter;
//import org.monte.media.Registry;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
//import java.io.File;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.monte.media.Format;
import org.monte.media.FormatKeys;
//import static org.monte.media.FormatKeys.MediaTypeKey;
//import static org.monte.media.FormatKeys.MimeTypeKey;
//import static org.monte.media.FormatKeys.MIME_AVI;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;

//import org.monte.media.VideoFormatKeys;
import static org.monte.media.FormatKeys.EncodingKey;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
//import org.monte.media.avi.AVIWriter;
//import org.monte.media.beans.AbstractStateModel;
//import org.monte.media.color.Colors;
//import org.monte.media.converter.CodecChain;
//import org.monte.media.converter.ScaleImageCodec;
//import org.monte.media.image.Images;
//import org.monte.media.quicktime.QuickTimeWriter;



public class ScreenRecord extends org.monte.screenrecorder.ScreenRecorder{
	
//	public static ScreenRecorder startRecording(String fileName) throws Exception {
//	    //retrieving the default graphics configuration of the primary screen
//		GraphicsConfiguration gc = GraphicsEnvironment
//	    .getLocalGraphicsEnvironment()
//	    .getDefaultScreenDevice()
//	    .getDefaultConfiguration();
//
//	    ScreenRecorder screenRecorder = new ScreenRecorder(
//	    		gc, null,
//			    new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
//			    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
//			    CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, (int) 24, FrameRateKey,
//			    Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, (int) (15 * 60)),
//			    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
//			    null, new File(fileName));
//
//	    screenRecorder.start();
//
//	    return screenRecorder;
//	    }
//
//	public static void stopRecording(ScreenRecorder screenRecorder) throws Exception {
//	    screenRecorder.stop();
//	    }


	public final static String RECORDINGS_PATH = "./ScreenRecords/";
	private static ScreenRecord screenRecord;
	private final String filename;
	
	public ScreenRecord(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
	                    Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
	        throws IOException, AWTException {
		super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
	    filename = name;
	}
	
	public static void startRecording(String methodName) throws Exception {
	    try {
	        File file = new File(RECORDINGS_PATH);
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        Rectangle captureSize = new Rectangle(0, 0, screenSize.width, screenSize.height);
	
	
	        screenRecord = new ScreenRecord(GraphicsEnvironment.getLocalGraphicsEnvironment().
	                getDefaultScreenDevice()
	                .getDefaultConfiguration(), captureSize,
	                new Format(FormatKeys.MediaTypeKey, MediaType.FILE, FormatKeys.MimeTypeKey, FormatKeys.MIME_AVI),
	                new Format(FormatKeys.MediaTypeKey, MediaType.VIDEO, FormatKeys.EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FormatKeys.FrameRateKey,
	                        Rational.valueOf(25), QualityKey, 1.0f, FormatKeys.KeyFrameIntervalKey, 15 * 60),
	                new Format(FormatKeys.MediaTypeKey, MediaType.VIDEO, FormatKeys.EncodingKey, "black", FormatKeys.FrameRateKey, Rational.valueOf(25)),
	                null, file, methodName);
	
	        screenRecord.start();
	    } 
	    catch (Exception e) {
	       System.out.println(e);
	    }
	
	
	}
	
	public static void stopRecording() throws Exception {
	    try {
	        screenRecord.stop();
	    } catch (Exception e) {
	    	System.out.println(e);
	    }
	
	}
	
	@Override
	protected File createMovieFile(Format fileFormat) throws IOException {
	    try {
	        if (!movieFolder.exists()) {
	            movieFolder.mkdirs();
	        } else if (!movieFolder.isDirectory()) {
	            throw new IOException("\"" + movieFolder + "\" is not a directory.");
	        }
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
	       
	        return new File(movieFolder,
	                filename + "-" + "." +
	                        Registry.getInstance().getExtension(fileFormat));
	
	    } catch (Exception e) {
	    	System.out.println(e);
	        return null;
	    }
	
	}
}
