package pageObjects;

import java.util.Optional;

public class Manager {

	private  Optional<HomePage> homePage = Optional.empty();
	private  Optional<CartPage> cartPage = Optional.empty();

	/**
	 * @return pageObject of HomePage
	 */
	public   HomePage gethomePage() {

		return homePage.orElseGet(() -> {

			HomePage page = new HomePage();
			homePage = Optional.of(page);
			return page;

		});

	}

	/**
	 * @return pageobject of CartPage
	 * 
	 */
	public  CartPage getCartPage() {

		return cartPage.orElseGet(() -> {

			CartPage page = new CartPage();
			cartPage = Optional.of(page);
			return page;

		});

	}

}
