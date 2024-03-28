package ru.alfaCampus.pages.swagLabsPages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {
    private String inventoryList = "//div[@data-test='inventory-list']";
    private String inventoryItemsList = "//div[@data-test='inventory-item']";
    private String addToCartBtns = "//button[contains(@name, 'add-to-cart')]";
    private String cartBubble = "//span[@data-test='shopping-cart-badge']";

    public void checkInventoryListIsVisible() {
        $x(inventoryList).shouldBe(visible);
    }

    public void checkInventoryItemsListSize(int size) {
        $$x(inventoryItemsList).shouldHave(CollectionCondition.size(size));
    }

    public ProductsPage addAllItemsInCart() {
        $$x(addToCartBtns).forEach(SelenideElement::click);
        return this;
    }

    public ProductsPage checkCartBubble() {
        $x(cartBubble).shouldBe(visible);
        return this;
    }
}
