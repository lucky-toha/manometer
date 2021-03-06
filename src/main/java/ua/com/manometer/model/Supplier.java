package ua.com.manometer.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
public class Supplier {
    public static final String[] currencyAlias = {"грн", "руб", "дол. США", "евро"};
    public static Map<String, String> LANGUAGES;

    static {
        LANGUAGES = new LinkedHashMap<String, String>();
        LANGUAGES.put("ru", "Русский");
        LANGUAGES.put("ua", "Украинский");
        LANGUAGES.put("en", "Английский");
    }



    @Id
    @GeneratedValue()
    Integer id;
    String alias; //условное название
    String name;  //название
    String address;  //6.4
    String phone;    //6.5
    String erdpou;   //6.6
    String inn;     //6.7
    String innkpp; //6.8
    String okpo; //6.9
    String ogrn; //6.10

    String bankMediatorName; //6.11
    String bankMediatorAddress; //6.12
    String bankMediatorSWIFT; //6.13

    String bankBeneficiaryName; //6.14
    String bankBeneficiaryAddress; //6.15
    String bankBeneficiarySWIFT; //6.16
    String bankBeneficiaryASS; //6.17
    String rs; //6.18
    String ts; //6.19
    String bank;  //6.20
    String mfoBank;//6.21
    String BIC;//6.22
    String ks;//6.23

    @ManyToOne
    Currency currency; //6.24
    String logo;  //6.26
    String taxationScheme;//6.27
    String chief;//6.28
    String FIOChief;//6.29

    @Column(name ="second_chief")
    String secondChief;

    @Column(name ="second_chief_fio")
    String secondFIOChief;

    String NDSPayerNom;   //6.30
    String language;

    @Column(name ="default_row" ,nullable = false, length = 1)
    @Type(type = "yes_no")
    private boolean def;

    public Supplier() {
    }

    public Supplier(Integer id, String alias, String name, String address, String phone, String erdpou, String inn, String NDSPayerNom, String bank, String mfoBank, String logo) {
        this.id = id;
        this.alias = alias;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.erdpou = erdpou;
        this.inn = inn;
        this.NDSPayerNom = NDSPayerNom;

        this.bank = bank;
        this.mfoBank = mfoBank;
//        this.currency = currency;
        this.logo = logo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getErdpou() {
        return erdpou;
    }

    public void setErdpou(String erdpou) {
        this.erdpou = erdpou;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getNDSPayerNom() {
        return NDSPayerNom;
    }

    public void setNDSPayerNom(String NDSPayerNom) {
        this.NDSPayerNom = NDSPayerNom;
    }


    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getMfoBank() {
        return mfoBank;
    }

    public void setMfoBank(String mfoBank) {
        this.mfoBank = mfoBank;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }


    public String getInnkpp() {
        return innkpp;
    }

    public void setInnkpp(String innkpp) {
        this.innkpp = innkpp;
    }

    public String getOkpo() {
        return okpo;
    }

    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getBankMediatorName() {
        return bankMediatorName;
    }

    public void setBankMediatorName(String bankMediatorName) {
        this.bankMediatorName = bankMediatorName;
    }

    public String getBankMediatorAddress() {
        return bankMediatorAddress;
    }

    public void setBankMediatorAddress(String bankMediatorAddress) {
        this.bankMediatorAddress = bankMediatorAddress;
    }

    public String getBankMediatorSWIFT() {
        return bankMediatorSWIFT;
    }

    public void setBankMediatorSWIFT(String bankMediatorSWIFT) {
        this.bankMediatorSWIFT = bankMediatorSWIFT;
    }

    public String getBankBeneficiaryName() {
        return bankBeneficiaryName;
    }

    public void setBankBeneficiaryName(String bankBeneficiaryName) {
        this.bankBeneficiaryName = bankBeneficiaryName;
    }

    public String getBankBeneficiaryAddress() {
        return bankBeneficiaryAddress;
    }

    public void setBankBeneficiaryAddress(String bankBeneficiaryAddress) {
        this.bankBeneficiaryAddress = bankBeneficiaryAddress;
    }

    public String getBankBeneficiarySWIFT() {
        return bankBeneficiarySWIFT;
    }

    public void setBankBeneficiarySWIFT(String bankBeneficiarySWIFT) {
        this.bankBeneficiarySWIFT = bankBeneficiarySWIFT;
    }

    public String getBankBeneficiaryASS() {
        return bankBeneficiaryASS;
    }

    public void setBankBeneficiaryASS(String bankBeneficiaryASS) {
        this.bankBeneficiaryASS = bankBeneficiaryASS;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
    }

    public String getKs() {
        return ks;
    }

    public void setKs(String ks) {
        this.ks = ks;
    }

    public String getTaxationScheme() {
        return taxationScheme;
    }

    public void setTaxationScheme(String taxationScheme) {
        this.taxationScheme = taxationScheme;
    }

    public String getChief() {
        return chief;
    }

    public void setChief(String chief) {
        this.chief = chief;
    }

    public String getFIOChief() {
        return FIOChief;
    }

    public void setFIOChief(String FIOChief) {
        this.FIOChief = FIOChief;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Column(nullable = false, length = 1)
    @Type(type = "yes_no")
    public boolean isDef() {
        return def;
    }

    public void setDef(boolean def) {
        this.def = def;
    }

    public String getSecondChief() {
        return secondChief;
    }

    public void setSecondChief(String secondChief) {
        this.secondChief = secondChief;
    }

    public String getSecondFIOChief() {
        return secondFIOChief;
    }

    public void setSecondFIOChief(String secondFIOChief) {
        this.secondFIOChief = secondFIOChief;
    }

    @Override
    public String toString() {
        return "sup_"+id;
    }
}
