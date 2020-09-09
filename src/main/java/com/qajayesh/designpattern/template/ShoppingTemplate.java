package com.qajayesh.designpattern.template;

public interface ShoppingTemplate {

    void launchSite();
    void searchForProduct();
    void selectProduct();
    void buy();

    default void shop() {
        launchSite();
        searchForProduct();
        selectProduct();
        buy();
    }

}
