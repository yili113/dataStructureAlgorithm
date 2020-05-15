package cqupt.interviewQ.JUCDemo;

/**
 * @author Liyi
 * @create 2020-05-05 11:24
 */
public enum CountryEnum {

    ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕");
    public static CountryEnum forEach_Country(int index) {
        CountryEnum[] values = CountryEnum.values();
        for(CountryEnum value : values) {
            if (value.retCode == index)
                return value;
        }
        return null;
    }
    private Integer retCode;
    private String retMessage;
    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }
    public Integer getRetCode() {
        return retCode;
    }
    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }
    public String getRetMessage() {
        return retMessage;
    }
    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }
}
