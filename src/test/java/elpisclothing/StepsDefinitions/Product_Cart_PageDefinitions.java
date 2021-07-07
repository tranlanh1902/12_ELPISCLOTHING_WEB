package elpisclothing.StepsDefinitions;

import static org.junit.Assert.assertTrue;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import elpisclothing.pageObjects.Product_Cart_PageObject;
import net.thucydides.core.annotations.Steps;

@SuppressWarnings({ "deprecation" })
public class Product_Cart_PageDefinitions {
	@Steps
	Product_Cart_PageObject cartPro;

	@When("^Product-CartPage: lấy thông tin Tên, Giá tiền, Tiêu đề, Kích thước, Số lượng sản phẩm trong giỏ hàng và Tổng tiền$")
	public void productcartpage_ly_thng_tin_tn_gi_tin_tiu_kch_thc_sn_phm_trong_gi_hng() {
		ShareContextData.NAME_selected = cartPro.getNamePro();
		ShareContextData.PRICE_selected = cartPro.getPricelPro();
		ShareContextData.TITLE_selected = cartPro.getTitlePro();
		ShareContextData.SIZE_selected = cartPro.getSizePro();
		ShareContextData.COUNT_selected = cartPro.getCountPro();
		ShareContextData.TOTAL_PRICE_selected = cartPro.getTotalPricePro();

		System.out.println("======= thông tin sản phẩm trong giỏ hàng =====");
		System.out.println(ShareContextData.NAME_selected);
		System.out.println(ShareContextData.PRICE_selected);
		System.out.println(ShareContextData.TITLE_selected);
		System.out.println(ShareContextData.SIZE_selected);
		System.out.println(ShareContextData.COUNT_selected);
		System.out.println(ShareContextData.TOTAL_PRICE_selected);

	}

	@And("^Product-CartPage: kiểm tra thông tin Tên, Giá tiền, Tiêu đề, Kích thước sản phẩm đã chọn lần lượt trùng với thông tin Tên, Giá tiền, Tiêu đề, Kích thước sản phẩm với trong giỏ hàng$")
	public void productcartpage_kim_tra_thng_tin_tn_gi_tin_tiu_kch_thc_sn_phm_chn_ln_lt_trng_vi_thng_tin_tn_gi_tin_tiu_kch_thc_sn_phm_vi_trong_gi_hng() {
		assertTrue(ShareContextData.NAME_selected.equals(ShareContextData.NAME_select));
		assertTrue(ShareContextData.TITLE_selected.equals(ShareContextData.TITLE_select));
		assertTrue(ShareContextData.SIZE_selected.equals(ShareContextData.SIZE_select));
		assertTrue(ShareContextData.PRICE_selected == ShareContextData.PRICE_select);

		System.out.println("======= thông tin sản phẩm trước khi chọn =====");
		System.out.println(ShareContextData.NAME_select);
		System.out.println(ShareContextData.PRICE_select);
		System.out.println(ShareContextData.TITLE_select);
		System.out.println(ShareContextData.SIZE_select);

	}

	@And("^Product-CartPage: kiểm tra thông tin số lượng của sản phẩm đã chọn là (.*)$")
	public void productcartpage_kim_tra_thng_tin_s_lng_ca_sn_phm_chn_l_1(int count) {
		assertTrue(ShareContextData.COUNT_selected == count);
	}

	@And("^Product-CartPage: kiểm tra tổng tiền = số lượng x giá tiền$")
	public void productcartpage_kim_tra_tng_tin_s_lng_gi_tin() throws InterruptedException {
		Thread.sleep(5000);
		int total = ShareContextData.COUNT_selected * ShareContextData.PRICE_selected;
		System.out.println("total=" + total);
		assertTrue(ShareContextData.TOTAL_PRICE_selected == total);
	}

	// sua
	@And("^Product-CartPage: chọn số lượng sản phẩm là (.*)$")
	public void productcartpage_chn_s_lng_sn_phm_l_count(int count) {
		cartPro.chooseCountPro(count);
	}

	// xoá
	@Given("^Product-CartPage: nhấn hyperlink xoá sản phẩm$")
	public void productcartpage_nu_gi_hng_c_sn_phm_nhn_hyperlink_something() {
		cartPro.clickToDeleteHyperlink();
	}

	@Then("^Product-CartPage: kiểm tra xoá thành công với thông báo \"([^\"]*)\"$")
	public void productcartpage_kim_tra_xo_thnh_cng_vi_thng_bo_something(String message) {
		cartPro.verifyDeleteSuccess(message);
	}
}
