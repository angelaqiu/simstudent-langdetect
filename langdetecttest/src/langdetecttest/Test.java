package langdetecttest;
import java.util.ArrayList;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;
import com.cybozu.labs.langdetect.Language;


public class Test {

	public void init(String profileDirectory) throws LangDetectException {
        DetectorFactory.loadProfile(profileDirectory);
    }
    public String detect(String text) throws LangDetectException {
        Detector detector = DetectorFactory.create();
        detector.append(text);
        return detector.detect();
    }
    public static ArrayList<Language> detectLangs(String text) throws LangDetectException {
        Detector detector = DetectorFactory.create();
        detector.append(text);
        return detector.getProbabilities();
    }
    
    public static void main (String[] args) throws LangDetectException
    {
    	DetectorFactory.loadProfile("src/profiles");
//    	String text = "hello this is me apples are delicious but I like bananas more why can the detector not detect any english? Ang lahat ng tao'y isinilang na malaya at pantay-pantay sa karangalan at mga karapatan.";
    	String text = "ewan ko";
//    	text = text.toLowerCase();
//    	System.out.println(text);
    	Detector detector = DetectorFactory.create();
    	detector.append(text);

    	ArrayList<Language> langlist = detector.getProbabilities();
    	System.out.println(langlist.toString());
    }
}
