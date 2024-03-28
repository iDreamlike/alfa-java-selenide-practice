package ru.alfaCampus.pages.swagLabsPages;

import com.codeborne.selenide.CollectionCondition;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {
    private String inventoryList = "//div[@data-test='inventory-list']";
    private String inventoryItemsList = "//div[@data-test='inventory-item']";

    public void checkInventoryListIsVisible() {
        $x(inventoryList).shouldBe(visible);
    }

    public void checkInventoryItemsListSize(int size) {
        $$x(inventoryItemsList).shouldHave(CollectionCondition.size(size));
    }
}
