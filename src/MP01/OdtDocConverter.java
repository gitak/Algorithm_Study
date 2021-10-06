package MP01;

public class OdtDocConverter extends DocConverter{
    @Override
    public void save(String fileName) {
        System.out.println(fileName+"."+super.getExtension()+"로 변환해서 저장합니다.");
    }

    public OdtDocConverter(){
        super("odt"); //부모클래스 생성자 호출
    }
}
