package pageObjects;

import java.util.Optional;

public class Manager {

	private static Optional<HomePage> homePage = Optional.empty();
	private static Optional<CartPage> cartPage = Optional.empty();

	public  static HomePage gethomePage() {

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
	public static CartPage getCartPage() {

		return cartPage.orElseGet(() -> {

			CartPage page = new CartPage();
			cartPage = Optional.of(page);
			return page;

		});

	}

}
