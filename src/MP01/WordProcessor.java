package MP01;
import java.util.Map;
import java.util.HashMap;


public class WordProcessor  {
    private ISpellChecker spellChecker ;
    private String filename;
    private Map<String, DocConverter> docConverters;

    public WordProcessor(String filename){
        this.filename = filename;
        docConverters = new HashMap<String, DocConverter>();

    }
    public void addDocConverter(DocConverter converter){//문서 변환 객체를 Map에 추가
        docConverters.put(converter.getExtension(), converter);
    }

    public void convertDocTo(String ext){
        if(docConverters.containsKey(ext)) {
            docConverters.get(ext).save(filename);
        }
        else{
            System.out.println(ext+"파일 형식을 지원하는 DocConverter가 없습니다.");
        }

    }

    public void setSpellChecker(ISpellChecker spellChecker){
        this.spellChecker = spellChecker;
    }

    public void checkSpelling(){
        spellChecker.check();
    }

}

