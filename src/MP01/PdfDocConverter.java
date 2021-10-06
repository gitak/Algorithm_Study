package MP01;

public class PdfDocConverter extends DocConverter{
    @Override
    public void save(String fileName) {
        System.out.println(fileName+"."+super.getExtension()+"로 변환해서 저장합니다.");
    }

    public PdfDocConverter(){
        super("pdf"); //부모클래스 생성자 호출
    }
}
