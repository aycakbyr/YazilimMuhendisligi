
public class BankAccount {
    
   private String hesapSahibi;
   private String hesapNo;
   private float bakiye;
   private String paraBirimi;
   
   public BankAccount (String hesapSahibi, String hesapNo, float bakiye, String paraBirimi){
      
       setHesapSahibi(hesapSahibi);
       setHesapNo(hesapNo);
       setBakiye(bakiye);
       setParaBirimi(paraBirimi);
       
   }
   
   public String getHesapSahibi() {
       return hesapSahibi;
   }
   
   public void setHesapSahibi(String hesapSahibi) {
       this.hesapSahibi = hesapSahibi;
   }
   
   public String getHesapNo() {
       return hesapNo;
   }
   
   public void setHesapNo(String hesapNo) {
       this.hesapNo = hesapNo;
   }
   
   public float getBakiye() {
       return bakiye;
   }
   
   public void setBakiye(float bakiye) {
       if (bakiye < 0) {
           bakiye = 0;
       }
       
       this.bakiye = bakiye;   
   }
   
   public String getParaBirimi() {
       return paraBirimi;
   }
   
   public void setParaBirimi(String paraBirimi) {
       this.paraBirimi = paraBirimi;
   }
   
   public void paraYatir(float miktar) {
       if (miktar < 0) {
           System.out.println("İşlem tutarı 0 dan büyük olmalıdır...");
       } else {
           bakiye += miktar;
       }    
   }
   
   public void paraCek(float miktar) {
       if (miktar < 0 ) {
           System.out.println("İşlem tutarı 0 dan büyük olmalıdır...");
       } else if (miktar > bakiye) {
           System.out.println("Yetersiz bakiye... En fazla işlem yapabileceğiniz miktar : " + bakiye+paraBirimi);
       } else {
           bakiye-=miktar;
       }
   }
   
   
   public void bilgiYazdir() {
       System.out.print(hesapNo + " ( " + hesapSahibi + " ) Bakiye : " + bakiye + " " + paraBirimi );
   }
   
   
    
    
}
