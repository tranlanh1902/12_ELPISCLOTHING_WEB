package elpisclothing.StepsDefinitions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import elpisclothing.pageObjects.Product_Search_PageObject;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Steps;

@SuppressWarnings({ "deprecation" })
public class Product_Search_PageDefinitions {
	@Steps
	Product_Search_PageObject searchPro;

	@Given("^Product-SearchPage: nhập từ khoá tìm kiếm và nhấn Enter$")
	public void productsearchpage_nhp_t_kho_tm_kim(DataTable table) {
		String key = searchPro.getValueColumnDataTableBDD(table, "tuKhoaTimKiem");
		searchPro.inputToSearchAndEnterTxt(key);
	}

	@Then("^Product-SearchPage: kiểm tra hiển thị thông báo$")
	public void productsearchpage_kim_tra_hin_th_thng_bo(DataTable table) {
		String mesage = searchPro.getValueColumnDataTableBDD(table, "thongBao");
		String type = searchPro.getValueColumnDataTableBDD(table, "type");

		switch (type) {
		case "0":
			searchPro.verifyMessageResultSeach(mesage);
			break;
		case "1":
			searchPro.verifyNoMessageResultSeach(mesage);
			break;
		default:
			System.out.println("not found type search");
			break;
		}

	}

	@Then("^Product-SearchPage: kiểm tra hiển thị thông báo tìm kiếm thành công$")
	public void productsearchpage_kim_tra_hin_th_thng_bo_tm_kim_thnh_cng(DataTable table) {
		String mesage = searchPro.getValueColumnDataTableBDD(table, "thongBao");
		searchPro.verifyMessageResultSeach(mesage);
	}

	@When("^Product-SearchPage: nhấn vào sản phẩm đã tìm kiếm để xem chi tiết$")
	public void productsearchpage_nhn_vo_sn_phm_tm_kim_xem_chi_tit(DataTable table) {
		String key = searchPro.getValueColumnDataTableBDD(table, "tuKhoaTimKiem");
		searchPro.clickToNameLabel(key);
	}
}
