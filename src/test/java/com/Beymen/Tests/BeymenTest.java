package com.Beymen.Tests;

import com.Beymen.Pages.BasePage;
import org.junit.Test;
import org.openqa.selenium.Keys;

public class BeymenTest extends BasePage {

    @Test
    public void senaryo_1() {

        extentLogger = report.createTest("Beymen");

        extentLogger.info("www.beymen.com sitesi açılır");
        mainPage();

        extentLogger.info("Ana sayfanın açıldığı kontrol edilir.");
        checkMainPage();

        extentLogger.info("Arama kutucuğuna şort kelimesi girilir.(Not = Şort kelimesi excel dosyası üzerinden 1 sütun 1 satırdan alınarak yazılmalıdır. )");
        inputSearchBox(readExcelFile()[0]);

        extentLogger.info("Arama kutucuğuna girilen “şort” kelimesi silinir.");
        deleteSearchBox();

        extentLogger.info("Arama kutucuğuna “gömlek” kelimesi girilir.(Not = Gömlek kelimesi excel dosyası üzerinden 2 sütun 1 satırdan alınarak yazılmalıdır. )");
        inputSearchBox(readExcelFile()[1]);

        extentLogger.info("Klavye üzerinden “enter” tuşuna bastırılır");
        searchBox.sendKeys(Keys.ENTER);

        extentLogger.info("Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.");
        getRandomProduct();

        extentLogger.info("Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır.");
        prodInformation();

        extentLogger.info("Seçilen ürün sepete eklenir.");
        addToBasket();

        extentLogger.info("Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.");
        matchPrice();

        extentLogger.info("Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.");
        increaseThePiece("2 adet");

        extentLogger.info("Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.");
        deleteProduct();







    }

}
